package com.ytg123.songsounds;

import com.ytg123.songsounds.util.ModVars;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.command.argument.IdentifierArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SongSounds implements ModInitializer {

    public static final String MOD_ID = "songsounds";
    public static final String MOD_NAME = "Song Sounds";

    public static Logger LOGGER = LogManager.getLogger();

    public static void log(Level level, String message) {
        LOGGER.log(level, "[" + MOD_NAME + "] " + message);
    }

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        CommandRegistrationCallback.EVENT.register((dispacher, dedicated) -> {
            dispacher.register(CommandManager.literal("togglesounds").requires(source -> source.hasPermissionLevel(2)).executes(context -> {
                ModVars.isEnabled = !ModVars.isEnabled;
                context.getSource().sendFeedback(new TranslatableText("text.songsounds.toggled", ModVars.isEnabled), true);
                return 1;
            }));
            dispacher.register(CommandManager.literal("switchsound").requires(source -> source.hasPermissionLevel(2)).then(CommandManager.argument("song",
                    IdentifierArgumentType.identifier())).executes(context -> {
                return 1;
            }));
        });
    }
}
