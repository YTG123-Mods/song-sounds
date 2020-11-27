package io.github.ytg1234.songsounds.base.mixin;

import net.minecraft.client.sound.SoundSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(SoundSystem.class)
public abstract class SoundSystemMixin {
    @ModifyArg(method = "getAdjustedPitch(Lnet/minecraft/client/sound/SoundInstance;)F",
               at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;clamp(FFF)F"),
               index = 1)
    private float yeetLowerLimit(float value, float min, float max) {
        return Float.MIN_VALUE;
    }

    @ModifyArg(method = "getAdjustedPitch(Lnet/minecraft/client/sound/SoundInstance;)F",
               at = @At(value = "INVOKE", target = "Lnet/minecraft/util/math/MathHelper;clamp(FFF)F"),
               index = 2)
    private float yeetUpperLimit(float value, float min, float max) {
        return Float.MAX_VALUE;
    }
}
