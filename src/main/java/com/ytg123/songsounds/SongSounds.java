package com.ytg123.songsounds;

import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.ytg123.songsounds.util.ModVars;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.command.argument.IdentifierArgumentType;
import net.minecraft.resource.ResourceType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.CommandSource;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;
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
            final SuggestionProvider<ServerCommandSource>
                    SUGGESTION_PROVIDER =
                    (commandContext, suggestionsBuilder) -> CommandSource.suggestIdentifiers(SongManager.INSTANCE.getSongIDs(),
                            suggestionsBuilder);

            dispacher.register(CommandManager.literal("togglesongs")
                    .requires(source -> source.hasPermissionLevel(2))
                    .executes(context -> {
                        ModVars.isEnabled = !ModVars.isEnabled;
                        context.getSource()
                                .sendFeedback(new TranslatableText("text.songsounds.toggled", ModVars.isEnabled), true);
                        return 1;
                    }));
            dispacher.register(CommandManager.literal("switchsong")
                    .requires(source -> source.hasPermissionLevel(2))
                    .then(CommandManager.argument("song",
                            IdentifierArgumentType.identifier()).suggests(SUGGESTION_PROVIDER))
                    .executes(context -> {
                        ModVars.currentSong =
                                SongManager.INSTANCE.getSong(IdentifierArgumentType.getIdentifier(context, "song"));
                        return 1;
                    }));
        });
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(SongManager.INSTANCE);
    }
}
