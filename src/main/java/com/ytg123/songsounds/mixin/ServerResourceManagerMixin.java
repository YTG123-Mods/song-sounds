package com.ytg123.songsounds.mixin;

import com.ytg123.songsounds.SongManager;
import net.minecraft.resource.ReloadableResourceManager;
import net.minecraft.resource.ServerResourceManager;
import net.minecraft.server.command.CommandManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerResourceManager.class)
public abstract class ServerResourceManagerMixin {
    @Shadow @Final private ReloadableResourceManager resourceManager;

    @Inject(method = "<init>*", at = @At("RETURN"))
    public void my$onConstruct(CommandManager.RegistrationEnvironment registrationEnvironment, int i, CallbackInfo ci) {
      resourceManager.registerListener(SongManager.INSTANCE);
    }
}
