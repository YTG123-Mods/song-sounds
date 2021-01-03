package io.github.ytg1234.songsounds

import io.github.ytg1234.songsounds.base.SongManager
import io.github.ytg1234.songsounds.init.EventListener
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback
import net.fabricmc.fabric.api.resource.ResourceManagerHelper
import net.minecraft.resource.ResourceType
import org.apache.logging.log4j.LogManager

const val MOD_ID = "songsounds"
const val MOD_NAME = "Song Sounds"
val logger = LogManager.getLogger(MOD_NAME)!!

object SongSounds : ModInitializer {
    override fun onInitialize() {
        logger.info("Initializing")
        CommandRegistrationCallback.EVENT.register(EventListener::registerCommands)
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(SongManager)
    }
}
