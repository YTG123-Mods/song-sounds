package io.github.ytg1234.songsounds.command

import com.mojang.brigadier.Command
import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.context.CommandContext
import com.mojang.brigadier.suggestion.SuggestionProvider
import io.github.ytg1234.songsounds.base.SongManager
import io.github.ytg1234.songsounds.base.song.Song
import io.github.ytg1234.songsounds.util.currentSong
import io.github.ytg1234.songsounds.util.index
import io.github.ytg1234.songsounds.util.section
import net.minecraft.command.CommandSource
import net.minecraft.command.argument.IdentifierArgumentType
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.TranslatableText

object SetsongCommand {
    fun register(dispatcher: CommandDispatcher<ServerCommandSource>) {
        val provider = SuggestionProvider<ServerCommandSource> { _, builder ->
                CommandSource.suggestIdentifiers(
                    SongManager.songIDs,
                    builder
                )
            }

        dispatcher.register(
            CommandManager.literal("setsong")
                .then(CommandManager.argument("id", IdentifierArgumentType.identifier()).suggests(provider)
                    .executes(::execute)
                )
        )
    }

    private fun execute(ctx: CommandContext<ServerCommandSource>): Int {
        val song: Song = SongManager[IdentifierArgumentType.getIdentifier(ctx, "id")]
        if (song == Song.EMPTY || IdentifierArgumentType.getIdentifier(ctx, "id" ) == Song.EMPTY_ID
        ) {
            ctx.source.sendError(TranslatableText("error.songsounds.emptysong"))
            return 0
        } else if (song.sections.isEmpty()) {
            ctx.source.sendError(TranslatableText("error.songsounds.nosections"))
            return 0
        } else if (song.sections[0].notes.isEmpty()) {
            ctx.source.sendError(TranslatableText("error.songsounds.nonotes"))
            return 0
        } else if (song == currentSong) {
            ctx.source.sendError(TranslatableText("error.songsounds.same", song.name))
            return 0
        } else if (song.name == null) {
            ctx.source.sendError(TranslatableText("error.songsounds.other"))
            return 0
        }
        currentSong = song
        index = 0
        section = 0
        ctx.source.sendFeedback(TranslatableText("text.songsounds.switched", song.name), true)
        return Command.SINGLE_SUCCESS
    }
}
