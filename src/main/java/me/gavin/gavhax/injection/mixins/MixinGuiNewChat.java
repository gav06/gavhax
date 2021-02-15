package me.gavin.gavhax.injection.mixins;

import me.gavin.gavhax.GavHax;
import me.gavin.gavhax.util.BooleanHooks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiNewChat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.awt.*;

@Mixin(GuiNewChat.class)
public class MixinGuiNewChat {

    @Redirect(method = "drawChat", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/FontRenderer;drawStringWithShadow(Ljava/lang/String;FFI)I"))
    private int overrideDrawTextHook(FontRenderer fontRenderer, String text, float x, float y, int color) {
        if (!BooleanHooks.DO_RELIANT_CHAT) {
            Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(text,x,y,color);
        } else {
            GavHax.cFont.drawStringWithShadow(text, x, y, new Color(color));
        }
        return color;
    }

}
