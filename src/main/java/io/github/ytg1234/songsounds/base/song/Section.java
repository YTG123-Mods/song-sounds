package io.github.ytg1234.songsounds.base.song;

import com.google.gson.*;
import io.github.ytg1234.songsounds.SongSounds;
import io.github.ytg1234.songsounds.util.ModVars;
import net.minecraft.util.JsonHelper;
import org.apache.logging.log4j.Level;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;

public class Section {
    public String name;
    public float[] notes;

    private Section(String name, float... notes) {
        this.name = name;
        this.notes = notes;
    }

    public static class Serializer implements JsonDeserializer<Section> {
        @Override public Section deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            // Reading notes as String array
            JsonObject jsonObject = JsonHelper.asObject(json, "section");
            String name = JsonHelper.getString(jsonObject, "name");
            String[] notes = JsonHelper.deserialize(jsonObject, "notes", new String[0], context, String[].class);

            // Creating float array for future use
            float[] floatingNotes = new float[notes.length];

            // Populating the float array
            for (int i = 0; i < notes.length; i++) {
                try {
                    Field field = Notes.class.getField(notes[i].toUpperCase());
                    field.setAccessible(true);
                    floatingNotes[i] = (float) field.get(null);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    SongSounds.log(Level.WARN, "Datapack declared note " + notes[i] + ", which is unknown!");
                    floatingNotes[i] = ModVars.NoSuchNote;
                }
            }
            Section output = new Section(name, floatingNotes);
            SongSounds.log(Level.DEBUG, "Successfully deserialized a JSON section object, name is " + output.name + ", notes are " +
                    Arrays.toString(output.notes));
            return output;
        }
    }
}
