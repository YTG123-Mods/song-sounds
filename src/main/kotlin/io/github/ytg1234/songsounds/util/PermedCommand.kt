package io.github.ytg1234.songsounds.util

import com.mojang.brigadier.CommandDispatcher
import me.lucko.fabric.api.permissions.v0.Permissions
import net.fabricmc.loader.api.FabricLoader
import net.minecraft.server.command.CommandManager
import net.minecraft.server.command.ServerCommandSource

/**
 * A simple utility class to manage commands
 * with permissions.
 *
 * @param literal the command name
 * @param permNode the permission node required for the command
 * @param permLevel the operator permission level required if node is not present
 *
 * @constructor Configures the class to use the correct settings.
 *
 * @author YTG1234
 */
abstract class PermedCommand(val literal: String, val permNode: String, val permLevel: Int) {
    /**
     * Takes a [Builder], applies some modifications (example: Calling [then][com.mojang.brigadier.builder.ArgumentBuilder.then]), and
     * returns a builder.
     */
    abstract val cmd: (Builder) -> Builder

    private fun register(dispatcher: CommandDispatcher<ServerCommandSource>) {
        dispatcher.register(
            cmd(
                CommandManager.literal(literal).requires {
                    it.hasPermissionLevel(permLevel)
                }
            )
        )
    }

    private fun registerWithPerms(dispatcher: CommandDispatcher<ServerCommandSource>) {
        dispatcher.register(
            cmd(
                CommandManager.literal(literal)
                    .requires(Permissions.require(permNode, permLevel))
            )
        )
    }

    companion object {
        fun PermedCommand.registerCmd(dispatcher: CommandDispatcher<ServerCommandSource>) {
            if (FabricLoader.getInstance().isModLoaded("fabric-permissions-api-v0")) registerWithPerms(dispatcher)
            else register(dispatcher)
        }
    }
}
