package com.ytg123.songsounds.init;

import com.mojang.brigadier.CommandDispatcher;
import com.ytg123.songsounds.command.NoteCommand;
import com.ytg123.songsounds.command.SetsongCommand;
import com.ytg123.songsounds.command.SongsoundsCommand;
import net.minecraft.server.command.ServerCommandSource;

public class EventListener {
    public static void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        SetsongCommand.register(dispatcher);
        SongsoundsCommand.register(dispatcher);
        NoteCommand.register(dispatcher);
    }
}
