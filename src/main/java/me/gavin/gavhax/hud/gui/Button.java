package me.gavin.gavhax.hud.gui;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.gavin.gavhax.mod.Category;
import me.gavin.gavhax.mod.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.init.SoundEvents;

public class Button {

    public int x, y, width, height, offset;
    public Module module;
    public Panel parent;

    public Button(Module module, Panel parent, int x, int y, int offset) {
        this.x = x;
        this.y = y;
        this.offset = offset;
        this.width = 85;
        this.height = 16;
        this.module = module;
        this.parent = parent;
    }

    FontRenderer fr = Minecraft.getMinecraft().fontRenderer;

    public void draw(int mouseX, int mouseY) {
        if (module.enabled) {
            Gui.drawRect(parent.x, parent.y + offset, parent.x + width, parent.y + offset+ height, 0xcc333333);
        } else {
            Gui.drawRect(parent.x, parent.y + offset, parent.x + width, parent.y + offset+ height, 0xcca1a1a1);
        }

        fr.drawStringWithShadow(module.name, parent.x + 2, parent.y + offset + 4, -1);
    }

    //public void updatePos(int mouseX, int mouseY) {
    //
    //}

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (isWithin(mouseX, mouseY)) {
            Minecraft.getMinecraft().getSoundHandler().playSound(PositionedSoundRecord.getRecord(SoundEvents.UI_BUTTON_CLICK, 1.0F, 0.25F));
            module.toggle();
        }
    }

    public boolean isWithin(int x, int y) {
        return x >= parent.x && x <= parent.x + width && y >= parent.y + this.offset && y <= parent.y + height + this.offset;
    }
}
