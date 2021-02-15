package me.gavin.gavhax.injection.mixins;

import net.minecraft.client.gui.GuiMainMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiMainMenu.class)
public class MixinGuiMainMenu {

    @Inject(method = "drawScreen", at = @At("TAIL"))
    public void drawScreenHook(int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
        //Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(GavHax.MOD_NAME, 2, 2, -1);
        //Neon.font.drawStringWithShadow(Neon.NAME_VERSION, 2, 2, new Color(-1));
    }
}
