package io.github.ytg1234.songsounds;

import io.github.ytg1234.songsounds.init.EventListener;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.resource.ResourceType;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SongSounds implements ModInitializer {

    public static final String MOD_ID = "songsounds";
    public static final String MOD_NAME = "Song Sounds";

    public static Logger LOGGER = LogManager.getLogger(MOD_NAME);

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        CommandRegistrationCallback.EVENT.register(EventListener::registerCommands);
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(SongManager.INSTANCE);
    }

    public static void log(Level level, String message) {
        LOGGER.log(level, "[" + MOD_NAME + "] " + message);
    }
}
