package io.github.ytg1234.songsounds.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import io.github.ytg1234.songsounds.util.SongSoundsUtils;
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
        SongSoundsUtils.section = IntegerArgumentType.getInteger(ctx, "section");
        SongSoundsUtils.index = IntegerArgumentType.getInteger(ctx, "note");
        ctx.getSource().sendFeedback(new TranslatableText("text.songsounds.switchednote",
                                                          IntegerArgumentType.getInteger(ctx, "note"),
                                                          IntegerArgumentType.getInteger(ctx, "section"),
                                                          SongSoundsUtils.currentSong.sections[IntegerArgumentType.getInteger(ctx, "section")].name,
                                                          SongSoundsUtils.currentSong.name
        ), true);
        return 1;
    }
}
