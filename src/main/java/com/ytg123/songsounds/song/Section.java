package com.ytg123.songsounds.song;

import com.google.gson.*;
import com.ytg123.songsounds.SongSounds;
import com.ytg123.songsounds.util.Note;
import net.minecraft.util.JsonHelper;
import org.apache.logging.log4j.Level;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class Section {
    public String name;
    public float[] notes;

    private Section(String name, float... notes) {
        this.name = name;
        this.notes = notes;
    }

    public static class Serializer implements JsonDeserializer<Section> {
        @Override public Section deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws
                JsonParseException {
            // Reading notes as String array
            JsonObject jsonObject = JsonHelper.asObject(json, "section");
            String name = JsonHelper.getString(jsonObject, "name");
            String[] notes = JsonHelper.deserialize(jsonObject, "notes", new String[0], context, String[].class);

            // Creating float array for future use
            float[] floatingNotes = new float[notes.length];

            // Populating the float array
            for (int i = 0; i < notes.length; i++) {
                try {
                    Field field = Note.class.getField(notes[i]);
                    field.setAccessible(true);
                    floatingNotes[i] = (float) field.get(null);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    SongSounds.log(Level.FATAL, "Datapack declared note " + notes[i] + ", which is invalid! Exiting!");
                    throw new RuntimeException("Could not find note " + notes[i]);
                }
            }
            return new Section(name, floatingNotes);
        }
    }
}
