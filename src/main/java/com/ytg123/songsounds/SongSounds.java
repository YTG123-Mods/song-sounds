package com.ytg123.songsounds;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.ytg123.songsounds.song.Song;
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
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            final SuggestionProvider<ServerCommandSource>
                    SUGGESTION_PROVIDER =
                    (commandContext, suggestionsBuilder) -> CommandSource.suggestIdentifiers(SongManager.INSTANCE.getSongIDs(),
                            suggestionsBuilder);

            dispatcher.register(
                    CommandManager.literal(
                            "songsounds"
                    )
                            .requires(
                                    source -> source.hasPermissionLevel(2)
                            )
                            .executes(context -> {
                                ModVars.isEnabled = !ModVars.isEnabled;
                                context.getSource()
                                        .sendFeedback(new TranslatableText("text.songsounds.toggled",
                                                ModVars.isEnabled), true);
                                return 1;
                            }));
            dispatcher.register(
                    CommandManager.literal(
                            "setsong"
                    ).then(
                            CommandManager.argument(
                                    "id",
                                    IdentifierArgumentType.identifier()
                            ).suggests(SUGGESTION_PROVIDER).executes(context -> {
                                Song song = SongManager.INSTANCE.getSong(IdentifierArgumentType.getIdentifier(
                                        context,
                                        "id"));

                                if (song == null ||
                                        song.equals(Song.EMPTY) ||
                                        IdentifierArgumentType.getIdentifier(
                                                context,
                                                "id").equals(Song.EMPTY_ID)) {
                                    context.getSource()
                                            .sendError(new TranslatableText("error.songsounds.emptysong"));
                                    return 0;
                                } else if (song.sections == null || song.sections.length <= 0) {
                                    context.getSource()
                                            .sendError(new TranslatableText("error.songsounds.nosections"));
                                    return 0;
                                } else if (song.sections[0].notes == null ||
                                        song.sections[0].notes.length <= 0) {
                                    context.getSource()
                                            .sendError(new TranslatableText("error.songsounds.nonotes"));
                                    return 0;
                                } else if (song.equals(ModVars.currentSong)) {
                                    context.getSource()
                                            .sendError(new TranslatableText("error.songsounds.same",
                                                    song.name));
                                    return 0;
                                } else if (song.name == null) {
                                    context.getSource()
                                            .sendError(new TranslatableText("error.songsounds.other"));
                                    return 0;
                                }

                                ModVars.currentSong = song;
                                ModVars.index = 0;
                                ModVars.section = 0;

                                context.getSource()
                                        .sendFeedback(new TranslatableText("text.songsounds.switched",
                                                song.name), true);
                                return 1;
                            })
                    )
            );
            dispatcher.register(CommandManager.literal(
                    "note"
            ).then(
                    CommandManager.argument("section",
                            IntegerArgumentType.integer(0)
                    ).then(
                            CommandManager.argument("note", IntegerArgumentType.integer(0)
                            ).executes(
                                    context -> {
                                        ModVars.section = IntegerArgumentType.getInteger(context, "section");
                                        ModVars.index = IntegerArgumentType.getInteger(context, "note");
                                        context.getSource()
                                                .sendFeedback(new TranslatableText("text.songsounds.switchednote",
                                                        IntegerArgumentType.getInteger(context, "note"),
                                                        IntegerArgumentType.getInteger(context, "section"),
                                                        ModVars.currentSong.sections[IntegerArgumentType.getInteger(
                                                                context,
                                                                "section")].name,
                                                        ModVars.currentSong.name), true);
                                        return 1;
                                    }
                            )
                    )
            ));
        });
        ResourceManagerHelper.get(ResourceType.SERVER_DATA).registerReloadListener(SongManager.INSTANCE);
    }
}

/*
Song song = SongManager.INSTANCE.getSong(IdentifierArgumentType.getIdentifier(
                                                context,
                                                "id"));

                                        if (song == null ||
                                                song.equals(Song.EMPTY) ||
                                                IdentifierArgumentType.getIdentifier(
                                                        context,
                                                        "id").equals(Song.EMPTY_ID)) {
                                            context.getSource()
                                                    .sendError(new TranslatableText("error.songsounds.emptysong"));
                                            return 0;
                                        } else if (song.sections == null || song.sections.length <= 0) {
                                            context.getSource()
                                                    .sendError(new TranslatableText("error.songsounds.nosections"));
                                            return 0;
                                        } else if (song.sections[0].notes == null ||
                                                song.sections[0].notes.length <= 0) {
                                            context.getSource()
                                                    .sendError(new TranslatableText("error.songsounds.nonotes"));
                                            return 0;
                                        } else if (song.equals(ModVars.currentSong)) {
                                            context.getSource()
                                                    .sendError(new TranslatableText("error.songsounds.same",
                                                            song.name));
                                            return 0;
                                        } else if (song.name == null) {
                                            context.getSource()
                                                    .sendError(new TranslatableText("error.songsounds.other"));
                                            return 0;
                                        }

                                        ModVars.currentSong = song;
                                        ModVars.index = 0;
                                        ModVars.section = 0;

                                        context.getSource()
                                                .sendFeedback(new TranslatableText("text.songsounds.switched",
                                                        song.name), true);
                                        return 1;
 */