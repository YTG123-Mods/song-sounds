package io.github.ytg1234.songsounds.base

import com.google.common.collect.ImmutableMap
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import io.github.ytg1234.songsounds.MOD_ID
import io.github.ytg1234.songsounds.base.song.Section
import io.github.ytg1234.songsounds.base.song.Song
import io.github.ytg1234.songsounds.logger
import io.github.ytg1234.songsounds.util.currentSong
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener
import net.minecraft.resource.ResourceManager
import net.minecraft.util.Identifier
import java.io.IOException
import java.io.InputStreamReader
import java.util.regex.Pattern

// lmao this is like a black box for me
object SongManager : SimpleSynchronousResourceReloadListener {
    private var songs: Map<Identifier, Song> = ImmutableMap.of()

    private val ID = Identifier(MOD_ID, "song_json")
    private val GSON = GsonBuilder().registerTypeAdapter(Song::class.java, Song.Serializer())
        .registerTypeAdapter(Section::class.java, Section.Serializer())
        .create()

    val songIDs: Set<Identifier>
        get() = songs.keys

    override fun getFabricId(): Identifier {
        return ID
    }

    override fun apply(manager: ResourceManager) {
        val resources = manager.findResources(
            "songs"
        ) { string: String -> string.endsWith(".json") }
        val builder = ImmutableMap.builder<Identifier, Song>()
        for (id in resources) {
            try {
                val parser = JsonParser()
                val jsonObj = parser.parse(InputStreamReader(manager.getResource(id).inputStream)) as JsonObject
                val song = GSON.fromJson(jsonObj, Song::class.java)

                // Removing "songs/" and ".json" from the path
                var newPath = id.path.replaceFirst(Pattern.quote("songs/").toRegex(), "")
                val stringBuilder = StringBuilder(newPath)
                stringBuilder.replace(newPath.lastIndexOf(".json"), newPath.lastIndexOf(".json") + 5, "")
                newPath = stringBuilder.toString()
                val newID = Identifier(id.namespace, newPath)
                builder.put(newID, song)
                logger.info("Successfully loaded $id, new Identifier is $newID")
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        builder.put(Song.EMPTY_ID, Song.EMPTY)
        songs = builder.build()
        if (currentSong == null) {
            currentSong = getSong(Identifier(MOD_ID, "rickroll"))
        }
    }

    operator fun get(id: Identifier) = songs[id] ?: Song.EMPTY

    fun getSong(id: Identifier): Song {
        return songs[id] ?: Song.EMPTY
    }
}
