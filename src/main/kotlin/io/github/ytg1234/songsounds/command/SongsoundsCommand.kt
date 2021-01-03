package io.github.ytg1234.songsounds.command

import com.mojang.brigadier.CommandDispatcher
import com.mojang.brigadier.context.CommandContext
import io.github.ytg1234.songsounds.util.isEnabled
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.TranslatableText

object SongsoundsCommand {
    fun register(dispatcher: CommandDispatcher<ServerCommandSource>) {
        dispatcher.register(
            CommandManager.literal("songsounds").requires { it.hasPermissionLevel(2) }
                .executes(::execute)
        )
    }

    private fun execute(ctx: CommandContext<ServerCommandSource>): Int {
        isEnabled = !isEnabled
        ctx.source.sendFeedback(
            TranslatableText(
                "text.songsounds.toggled",
                isEnabled
            ), true
        )
        return 1
    }
}
