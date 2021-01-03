package io.github.ytg1234.songsounds.mixin;

import net.minecraft.block.NoteBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import io.github.ytg1234.songsounds.util.SongSoundsUtilsKt;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(NoteBlock.class)
public class NoteBlockMixin {
    @Redirect(method = "onSyncedBlockEvent(Lnet/minecraft/block/BlockState;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;II)Z",
              at = @At(value = "INVOKE",
                       target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FF)V"))
    public void playSound(
            World self,
            @Nullable PlayerEntity player,
            BlockPos pos,
            SoundEvent sound,
            SoundCategory category,
            float volume,
            float pitch
                         ) {
        if (SongSoundsUtilsKt.isEnabled()) {
            if (!self.isClient()) {
                self.playSound(
                        player,
                        (double) pos.getX() + 0.5D,
                        (double) pos.getY() + 0.5D,
                        (double) pos.getZ() + 0.5D,
                        sound,
                        category,
                        volume,
                        SongSoundsUtilsKt.getNextNote()
                              );
            }
        } else {
            self.playSound(player, pos, sound, category, volume, pitch);
        }
    }
}
