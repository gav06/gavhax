package me.gavin.gavhax.hud.gui;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.gavin.gavhax.mod.Category;
import me.gavin.gavhax.mod.Module;
import me.gavin.gavhax.mod.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

import java.util.ArrayList;

public class Panel {

    ArrayList<Button> buttons = new ArrayList<>();
    FontRenderer fr = Minecraft.getMinecraft().fontRenderer;

    public int x;
    public int y;
    public int width;
    public int height;
    public Category category;
    public boolean isDragging;

    public int dragX;
    public int dragY;

    public Panel(Category category, int x, int y) {
        this.category = category;
        this.x = x;
        this.y = y;
        this.width = 85;
        this.height = 15;

        int offset = 0;
        for (Module m : ModuleManager.getModulesByCategory(category)) {
            offset += 18;
            buttons.add(new Button(m, this, x ,y + offset, offset));

        }
    }

    public boolean isWithin(int x, int y) {
        return x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.height;
    }

    public void updatePosition(int mouseX, int mouseY) {
        if (this.isDragging) {
            this.x = (mouseX - dragX);
            this.y = (mouseY - dragY);
        }
    }

    public void draw_panel(int mouseX, int mouseY) {
        Gui.drawRect(x, y, x + width, y + 2, 0xffa1a1a1);
        Gui.drawRect(x, y, x + 2, y + height, 0xffa1a1a1);
        Gui.drawRect(x, (y + height) - 2, x + width, (y + height), 0xffa1a1a1);
        Gui.drawRect((x + width) - 2, y, x + width, (y + height), 0xffa1a1a1);

        //Gui.drawRect(x, y, x + width, y + height, 0xcca1a1a1);
        fr.drawStringWithShadow(category.toString(), x + ((width / 2.0F) - (fr.getStringWidth(category.toString()) / 2.0F)), y + 3, -1);

        for (Button b : buttons) {
            b.draw(mouseX,mouseY);
        }
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        for (Button button : buttons) {
            button.mouseClicked(mouseX, mouseY, mouseButton);
        }
    }
}
