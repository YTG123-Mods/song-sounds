package io.github.ytg1234.songsounds.init;

import com.mojang.brigadier.CommandDispatcher;
import io.github.ytg1234.songsounds.command.NoteCommand;
import io.github.ytg1234.songsounds.command.SetsongCommand;
import io.github.ytg1234.songsounds.command.SongsoundsCommand;
import net.minecraft.server.command.ServerCommandSource;

public class EventListener {
    public static void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        SetsongCommand.register(dispatcher);
        SongsoundsCommand.register(dispatcher);
        NoteCommand.register(dispatcher);
    }
}
