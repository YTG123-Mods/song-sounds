package com.ytg123.songsounds.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.ytg123.songsounds.util.ModVars;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class NoteCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("note").then(argument("section", IntegerArgumentType.integer(0)).then(argument("note",
                                                                                                                   IntegerArgumentType.integer(0)
                                                                                                                  ).executes(NoteCommand::execute))));
    }

    private static int execute(CommandContext<ServerCommandSource> ctx) {
        ModVars.section = IntegerArgumentType.getInteger(ctx, "section");
        ModVars.index = IntegerArgumentType.getInteger(ctx, "note");
        ctx.getSource().sendFeedback(new TranslatableText("text.songsounds.switchednote",
                                                          IntegerArgumentType.getInteger(ctx, "note"),
                                                          IntegerArgumentType.getInteger(ctx, "section"),
                                                          ModVars.currentSong.sections[IntegerArgumentType.getInteger(ctx, "section")].name,
                                                          ModVars.currentSong.name
        ), true);
        return 1;
    }
}
