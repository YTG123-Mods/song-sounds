package io.github.ytg1234.songsounds.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import io.github.ytg1234.songsounds.SongManager;
import io.github.ytg1234.songsounds.base.song.Song;
import io.github.ytg1234.songsounds.util.ModVars;
import net.minecraft.command.CommandSource;
import net.minecraft.command.argument.IdentifierArgumentType;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class SetsongCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        final SuggestionProvider<ServerCommandSource>
                SUGGESTION_PROVIDER =
                (commandContext, suggestionsBuilder) -> CommandSource.suggestIdentifiers(SongManager.INSTANCE.getSongIDs(), suggestionsBuilder);

        dispatcher.register(literal("setsong").then(argument("id", IdentifierArgumentType.identifier()).suggests(SUGGESTION_PROVIDER)
                                                                                                       .executes(SetsongCommand::execute)));
    }

    private static int execute(CommandContext<ServerCommandSource> ctx) {
        Song song = SongManager.INSTANCE.getSong(IdentifierArgumentType.getIdentifier(ctx, "id"));

        if (song == null || song.equals(Song.EMPTY) || IdentifierArgumentType.getIdentifier(ctx, "id").equals(Song.EMPTY_ID)) {
            ctx.getSource().sendError(new TranslatableText("error.songsounds.emptysong"));
            return 0;
        } else if (song.sections == null || song.sections.length <= 0) {
            ctx.getSource().sendError(new TranslatableText("error.songsounds.nosections"));
            return 0;
        } else if (song.sections[0].notes == null || song.sections[0].notes.length <= 0) {
            ctx.getSource().sendError(new TranslatableText("error.songsounds.nonotes"));
            return 0;
        } else if (song.equals(ModVars.currentSong)) {
            ctx.getSource().sendError(new TranslatableText("error.songsounds.same", song.name));
            return 0;
        } else if (song.name == null) {
            ctx.getSource().sendError(new TranslatableText("error.songsounds.other"));
            return 0;
        }

        ModVars.currentSong = song;
        ModVars.index = 0;
        ModVars.section = 0;

        ctx.getSource().sendFeedback(new TranslatableText("text.songsounds.switched", song.name), true);
        return 1;
    }
}
