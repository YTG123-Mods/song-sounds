package com.ytg123.songsounds.song;

import com.google.gson.*;
import com.ytg123.songsounds.SongSounds;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;

import java.lang.reflect.Type;

public class Song {
    public String name;
    public Section[] sections;

    public static final Identifier EMPTY_ID = new Identifier(SongSounds.MOD_ID, "empty");
    public static final Song EMPTY = new Song(null, new Section[0]);

    private Song(String name, Section... sections) {
        this.name = name;
        this.sections = sections;
    }

    public static class Serializer implements JsonDeserializer<Song>, JsonSerializer<Song> {
        public Song deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws
                JsonParseException {
                JsonObject jsonObject = JsonHelper.asObject(jsonElement, "song");
                String name = JsonHelper.getString(jsonObject, "name");
                Section[] sections = JsonHelper.deserialize(jsonObject, "sections", new Section[0], jsonDeserializationContext, Section[].class);
                return new Song(name, sections);
        }

        public JsonElement serialize(Song song, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", song.name);
            jsonObject.add("sections", jsonSerializationContext.serialize(song.sections));
            return jsonObject;
        }
    }
}
