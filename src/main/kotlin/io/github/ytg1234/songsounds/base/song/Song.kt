package io.github.ytg1234.songsounds.base.song

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import io.github.ytg1234.songsounds.MOD_ID
import io.github.ytg1234.songsounds.logger
import net.minecraft.util.Identifier
import net.minecraft.util.JsonHelper
import java.lang.reflect.Type

class Song private constructor(var name: String?, vararg val sections: Section) {
    class Serializer : JsonDeserializer<Song>, JsonSerializer<Song> {
        override fun deserialize(
            jsonElement: JsonElement,
            type: Type,
            jsonDeserializationContext: JsonDeserializationContext
        ): Song {
            val jsonObject = JsonHelper.asObject(jsonElement, "song")
            val name = JsonHelper.getString(jsonObject, "name")
            val sections = JsonHelper.deserialize(
                jsonObject, "sections", arrayOf(), jsonDeserializationContext,
                Array<Section>::class.java
            )
            val output = Song(name, *sections)
            logger.debug(
                "Successfully deserialized a JSON song object, name is ${output.name}, sections are ${output.sections.contentToString()}"
            )
            return output
        }

        override fun serialize(
            song: Song,
            type: Type,
            jsonSerializationContext: JsonSerializationContext
        ): JsonElement {
            val jsonObject = JsonObject()
            jsonObject.addProperty("name", song.name)
            jsonObject.add("sections", jsonSerializationContext.serialize(song.sections))
            return jsonObject
        }
    }

    companion object {
        val EMPTY_ID = Identifier(MOD_ID, "empty")
        val EMPTY = Song(null)
    }
}
