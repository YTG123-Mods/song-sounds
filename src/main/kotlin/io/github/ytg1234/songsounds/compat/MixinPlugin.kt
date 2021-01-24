package io.github.ytg1234.songsounds.compat

import net.fabricmc.loader.api.FabricLoader
import org.objectweb.asm.tree.ClassNode
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin
import org.spongepowered.asm.mixin.extensibility.IMixinInfo

class MixinPlugin : IMixinConfigPlugin {
    override fun onLoad(mixinPackage: String?) = Unit

    override fun getRefMapperConfig(): String? = null

    override fun shouldApplyMixin(targetClassName: String?, mixinClassName: String): Boolean {
        val name = mixinClassName.split(".")
        return if (name[name.size - 2] != "mixin") {
            println("Found compat mixin for mod ${name[name.size - 2]}, checking things")
            FabricLoader.getInstance().isModLoaded(name[name.size - 2])
        } else true
    }

    override fun acceptTargets(myTargets: MutableSet<String>?, otherTargets: MutableSet<String>?) = Unit

    override fun getMixins(): MutableList<String>? = null

    override fun preApply(
        targetClassName: String?,
        targetClass: ClassNode?,
        mixinClassName: String?,
        mixinInfo: IMixinInfo?
    ) = Unit

    override fun postApply(
        targetClassName: String?,
        targetClass: ClassNode?,
        mixinClassName: String?,
        mixinInfo: IMixinInfo?
    ) = Unit
}
