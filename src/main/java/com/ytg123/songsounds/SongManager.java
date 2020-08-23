package com.ytg123.songsounds;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.ytg123.songsounds.song.Section;
import com.ytg123.songsounds.song.Song;
import net.minecraft.resource.JsonDataLoader;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.profiler.Profiler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;
import java.util.Set;

public class SongManager extends JsonDataLoader {
    public static final SongManager INSTANCE = new SongManager();

    private static final Logger LOGGER = LogManager.getLogger();
    private Map<Identifier, Song> songs = ImmutableMap.of();
    private static final Gson GSON = (new GsonBuilder()).registerTypeAdapter(Song.class, new Song.Serializer()).registerTypeAdapter(
            Section.class, new Section.Serializer()).create();

    public SongManager() {
        super(GSON, "songs");
    }

    @Override protected void apply(Map<Identifier, JsonElement> loader, ResourceManager manager, Profiler profiler) {
        ImmutableMap.Builder<Identifier, Song> builder = ImmutableMap.builder();
        JsonElement elm = loader.remove(Song.EMPTY_ID);

        loader.forEach((identifier, element) -> {
            Song song = GSON.fromJson(element, Song.class);
            builder.put(identifier, song);
        });
        builder.put(Song.EMPTY_ID, Song.EMPTY);
        this.songs = builder.build();
    }

    public Song getSong(Identifier id) {
        return this.songs.getOrDefault(id, Song.EMPTY);
    }

    public Set<Identifier> getSongIDs() {
        return songs.keySet();
    }
}
