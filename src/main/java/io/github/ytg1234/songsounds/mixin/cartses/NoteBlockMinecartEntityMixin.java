package io.github.ytg1234.songsounds.mixin.cartses;

import io.github.boogiemonster1o1.cartses.entity.cart.MinecartWithNoteBlockEntity;
import io.github.ytg1234.songsounds.util.SongSoundsUtilsKt;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Mixin(MinecartWithNoteBlockEntity.class)
public class NoteBlockMinecartEntityMixin {
	@Redirect(method = "playSound(Lnet/minecraft/block/BlockState;)V",
			  at = @At(value = "INVOKE",
					   target = "Lnet/minecraft/world/World;playSound(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/sound/SoundEvent;Lnet/minecraft/sound/SoundCategory;FF)V"))
	private void playSongSoundsNote(
			World self, PlayerEntity player, BlockPos pos, SoundEvent sound, SoundCategory category, float volume, float pitch
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
