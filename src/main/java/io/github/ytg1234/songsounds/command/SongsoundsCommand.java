package io.github.ytg1234.songsounds.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import io.github.ytg1234.songsounds.util.SongSoundsUtils;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;

import static net.minecraft.server.command.CommandManager.literal;

public class SongsoundsCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("songsounds").requires(source -> source.hasPermissionLevel(2)).executes(SongsoundsCommand::execute));
    }

    private static int execute(CommandContext<ServerCommandSource> ctx) {
        SongSoundsUtils.isEnabled = !SongSoundsUtils.isEnabled;
        ctx.getSource()
               .sendFeedback(new TranslatableText("text.songsounds.toggled",
                                                  SongSoundsUtils.isEnabled), true);
        return 1;
    }
}
