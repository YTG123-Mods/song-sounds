package io.github.ytg1234.songsounds.base

import com.google.common.collect.ImmutableMap
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import io.github.ytg1234.songsounds.MOD_ID
import io.github.ytg1234.songsounds.base.song.Section
import io.github.ytg1234.songsounds.base.song.Song
import io.github.ytg1234.songsounds.logger
import net.fabricmc.fabric.api.resource.SimpleResourceReloadListener
import net.minecraft.resource.ResourceManager
import net.minecraft.util.Identifier
import net.minecraft.util.profiler.Profiler
import java.io.IOException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.regex.Pattern

object SongManager : SimpleResourceReloadListener<ImmutableMap<Identifier, Song>> {
    @Volatile
    private var songs: ImmutableMap<Identifier, Song> = ImmutableMap.of()

    val songIDs: Set<Identifier>
        get() = songs.keys

    private val ID = Identifier(MOD_ID, "song_json")
    private val GSON = GsonBuilder()
        .registerTypeAdapter(Song::class.java, Song.Serializer())
        .registerTypeAdapter(Section::class.java, Section.Serializer())
        .create()

    override fun getFabricId() = ID

    override fun load(
        manager: ResourceManager,
        profiler: Profiler,
        executor: Executor
    ): CompletableFuture<ImmutableMap<Identifier, Song>> { // I love async code
        return CompletableFuture.supplyAsync({
            profiler.startTick()
            profiler.push("SongManager")

            val resources = manager.findResources(
                "songs"
            ) { it.endsWith(".json") }

            val builder = ImmutableMap.builder<Identifier, Song>()

            for (id in resources) {
                try {
                    val jsonObj =
                        manager.getResource(id).use { JsonParser().parse(it.inputStream.reader()).asJsonObject }
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
            val finished = builder.build()

            profiler.pop()
            finished
        }, executor)
    }

    override fun apply(
        map: ImmutableMap<Identifier, Song>,
        manager: ResourceManager,
        profiler: Profiler,
        executor: Executor
    ): CompletableFuture<Void> {
        return CompletableFuture.runAsync({
            songs = map
        }, executor)
    }

    operator fun get(id: Identifier) = getSong(id)

    private fun getSong(id: Identifier): Song {
        return songs[id] ?: Song.EMPTY
    }
}
