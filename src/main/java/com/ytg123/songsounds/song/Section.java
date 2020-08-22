package com.ytg123.songsounds.song;

import com.google.gson.*;
import com.ytg123.songsounds.util.Note;
import net.minecraft.util.JsonHelper;

import java.lang.reflect.Type;

public class Section {
    public String name;
    public String[] notes;

    public static class Serializer implements JsonSerializer<Section>, JsonDeserializer<Section> {
        @Override public Section deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
                JsonParseException {
            JsonObject jsonObject = JsonHelper.asObject(json, "section");
            String name = JsonHelper.getString(jsonObject, "name");
            String[] notes = JsonHelper.deserialize(jsonObject, "notes", new String[0], context, String[].class);
            return new Section(name, notes);
        }

        @Override public JsonElement serialize(Section src, Type typeOfSrc, JsonSerializationContext context) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", src.name);
            jsonObject.add("notes", context.serialize(src.notes));
            return jsonObject;
        }
    }

    private Section(String name, String... notes) {
        this.name = name;
        this.notes = notes;
    }
}
