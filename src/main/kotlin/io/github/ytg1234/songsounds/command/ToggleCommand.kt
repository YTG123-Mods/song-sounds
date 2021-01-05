package io.github.ytg1234.songsounds.command

import com.mojang.brigadier.context.CommandContext
import io.github.ytg1234.songsounds.util.Builder
import io.github.ytg1234.songsounds.util.PermedCommand
import io.github.ytg1234.songsounds.util.isEnabled
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.text.TranslatableText

object ToggleCommand : PermedCommand("songsounds", "songsounds.command.toggle", 2) {
    override val cmd = { it: Builder -> it.executes(::execute) }

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
