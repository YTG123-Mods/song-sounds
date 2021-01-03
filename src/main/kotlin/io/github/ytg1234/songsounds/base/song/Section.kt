package io.github.ytg1234.songsounds.base.song

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import io.github.ytg1234.songsounds.logger
import io.github.ytg1234.songsounds.util.NO_SUCH_NOTE
import net.minecraft.util.JsonHelper
import java.lang.reflect.Type

class Section private constructor(var name: String, vararg var notes: Float) {
    class Serializer : JsonDeserializer<Section> {
        override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Section {
            // Reading notes as String array
            val jsonObject = JsonHelper.asObject(json, "section")
            val name = JsonHelper.getString(jsonObject, "name")
            val notes = JsonHelper.deserialize(
                jsonObject, "notes", arrayOf(), context,
                Array<String>::class.java
            )

            // Creating float array for future use
            val floatingNotes = FloatArray(notes.size)

            // Populating the float array
            for (i in notes.indices) {
                val floatingNote = Notes[notes[i]]
                floatingNotes[i] = floatingNote
                if (floatingNote == NO_SUCH_NOTE) {
                    logger.warn("Datapack declared note ${notes[i]}, which is unknown!")
                }
            }
            val output = Section(name, *floatingNotes)
            logger.debug(
                "Successfully deserialized a JSON section object, name is ${output.name}, notes are ${output.notes.contentToString()}"
            )
            return output
        }
    }
}
