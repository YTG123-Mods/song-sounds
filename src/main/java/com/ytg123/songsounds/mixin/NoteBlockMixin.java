package com.ytg123.songsounds.mixin;

import com.ytg123.songsounds.util.ModVars;
import com.ytg123.songsounds.util.Note;
import net.minecraft.block.NoteBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.logging.log4j.Level;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static com.ytg123.songsounds.SongSounds.log;

@Mixin(NoteBlock.class)
public class NoteBlockMixin {
    @Unique
    private static float[]
            notes =
            {       // Intro
                    Note.FA_1,
                    Note.SOL_2,
                    Note.DO_1,
                    Note.SOL_2,
                    Note.LA_2,
                    Note.DO_2,
                    Note.SI_B_2,
                    Note.LA_2,
                    Note.FA_1,
                    Note.SOL_2,
                    Note.DO_1,
                    Note.DO_1,
                    Note.DO_1,
                    Note.RE_1,
                    Note.MI_1,
                    Note.MI_1,
                    Note.FA_1,
                    Note.SOL_2,
                    Note.DO_1,
                    Note.SOL_2,
                    Note.LA_2,
                    Note.DO_2,
                    Note.SI_B_2,
                    Note.LA_2,
                    Note.FA_1,
                    Note.SOL_2,
                    Note.DO_1,
                    Note.MI_1,
                    Note.FA_1,
                    Note.FA_1,
                    // Verse 1
                    Note.RE_1,
                    Note.MI_1,
                    Note.FA_1,
                    Note.FA_1,
                    Note.SOL_2,
                    Note.MI_1,
                    Note.RE_1,
                    Note.DO_1, // We're no strangers to love
                    Note.RE_1,
                    Note.RE_1,
                    Note.MI_1,
                    Note.FA_1,
                    Note.RE_1,
                    Note.DO_1,
                    Note.DO_2,
                    Note.DO_2,
                    Note.SOL_2, // You know the rules, and so do I
                    Note.RE_1,
                    Note.RE_1,
                    Note.MI_1,
                    Note.FA_1,
                    Note.RE_1,
                    Note.FA_1,
                    Note.SOL_2,
                    Note.MI_1,
                    Note.RE_1,
                    Note.DO_1, // A full commitment's what I'm thinking of
                    Note.RE_1,
                    Note.RE_1,
                    Note.MI_1,
                    Note.FA_1,
                    Note.RE_1,
                    Note.DO_1,
                    Note.SOL_2,
                    Note.SOL_2,
                    Note.SOL_2,
                    Note.LA_2,
                    Note.SOL_2, // You wouldn't get this from any other guy
                    Note.FA_1,
                    Note.SOL_2,
                    Note.LA_2,
                    Note.FA_1,
                    Note.SOL_2,
                    Note.SOL_2,
                    Note.SOL_2,
                    Note.LA_2,
                    Note.SOL_2,
                    Note.DO_1 // I just wanna tell you how I'm feeling
            }; // This is hardcoded for the moment, as I'm going to change it when I get datapacks working

    @Unique
    private static int index = 0;

    @Redirect(method = "onSyncedBlockEvent(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;II)Z",
              at = @At(value = "INVOKE",
                       target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FF)V"))
    public void playSound(World self,
                          @Nullable PlayerEntity player,
                          BlockPos pos,
                          SoundEvent sound,
                          SoundCategory category,
                          float volume,
                          float pitch) {
        if (ModVars.isEnabled) {
            if (!self.isClient()) {
                if (index >= notes.length) {
                    index = 0;
                }
                log(Level.DEBUG, "notes[" + index + "] = " + notes[index]);
                self.playSound(player,
                        (double) pos.getX() + 0.5D,
                        (double) pos.getY() + 0.5D,
                        (double) pos.getZ() + 0.5D,
                        sound,
                        category,
                        volume,
                        notes[index]);
                index++;
            }
        } else {
            self.playSound(player, pos, sound, category, volume, pitch);
        }
    }
}
