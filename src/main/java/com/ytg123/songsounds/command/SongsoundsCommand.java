package com.ytg123.songsounds.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.ytg123.songsounds.util.ModVars;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;

import static net.minecraft.server.command.CommandManager.literal;

public class SongsoundsCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("songsounds").requires(source -> source.hasPermissionLevel(2)).executes(SongsoundsCommand::execute));
    }

    private static int execute(CommandContext<ServerCommandSource> ctx) {
        ModVars.isEnabled = !ModVars.isEnabled;
        ctx.getSource()
               .sendFeedback(new TranslatableText("text.songsounds.toggled",
                                                  ModVars.isEnabled), true);
        return 1;
    }
}
