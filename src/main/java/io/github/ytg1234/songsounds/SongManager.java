package io.github.ytg1234.songsounds;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.github.ytg1234.songsounds.song.Section;
import io.github.ytg1234.songsounds.song.Song;
import io.github.ytg1234.songsounds.util.ModVars;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class SongManager implements SimpleSynchronousResourceReloadListener {
    public static final SongManager INSTANCE = new SongManager();
    public static final Identifier ID = new Identifier(SongSounds.MOD_ID, "song_json");
    private static final Gson
            GSON =
            (new GsonBuilder()).registerTypeAdapter(Song.class, new Song.Serializer())
                               .registerTypeAdapter(Section.class, new Section.Serializer())
                               .create();
    private Map<Identifier, Song> songs = ImmutableMap.of();

    public Set<Identifier> getSongIDs() {
        return songs.keySet();
    }

    @Override
    public Identifier getFabricId() {
        return ID;
    }

    @Override
    public void apply(ResourceManager manager) {
        Collection<Identifier> resources = manager.findResources("songs", (string) -> string.endsWith(".json"));
        ImmutableMap.Builder<Identifier, Song> builder = ImmutableMap.builder();

        for (Identifier id : resources) {
            try {
                JsonParser JsonParser = new JsonParser();
                JsonObject jsonObj = (JsonObject) JsonParser.parse(new InputStreamReader(manager.getResource(id).getInputStream()));
                Song song = GSON.fromJson(jsonObj, Song.class);

                // Removing "songs/" and ".json" from the path
                String newPath = id.getPath().replaceFirst(Pattern.quote("songs/"), "");
                StringBuilder stringBuilder = new StringBuilder(newPath);
                stringBuilder.replace(newPath.lastIndexOf(".json"), newPath.lastIndexOf(".json") + 5, "");
                newPath = stringBuilder.toString();

                Identifier newID = new Identifier(id.getNamespace(), newPath);

                builder.put(newID, song);
                SongSounds.log(Level.INFO, "Successfully loaded " + id.toString() + ", new Identifier is " + newID.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        builder.put(Song.EMPTY_ID, Song.EMPTY);
        this.songs = builder.build();
        if (ModVars.currentSong == null) {
            ModVars.currentSong = getSong(new Identifier(SongSounds.MOD_ID, "rickroll"));
        }
    }

    public Song getSong(Identifier id) {
        return this.songs.getOrDefault(id, Song.EMPTY);
    }
}
