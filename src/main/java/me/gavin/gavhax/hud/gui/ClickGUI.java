package me.gavin.gavhax.hud.gui;

import me.gavin.gavhax.mod.Category;
import net.minecraft.client.gui.GuiScreen;

import java.util.ArrayList;

public class ClickGUI extends GuiScreen {

    ArrayList<Panel> panels = new ArrayList<>();

    public static ClickGUI INSTANCE = new ClickGUI();

    public ClickGUI() {
        int offset = 0;
        for (Category c : Category.values()) {
            panels.add(new Panel(c, 20 + offset, 15));
            offset += 115;
        }
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        for (Panel p : panels) {
            p.updatePosition(mouseX, mouseY);
            p.draw_panel(mouseX, mouseY);
        }
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        for (Panel p : panels) {

            if (p.isWithin(mouseX, mouseY)) {
                p.isDragging = true;
                p.dragX = mouseX - p.x;
                p.dragY = mouseY - p.y;
            }

            p.mouseClicked(mouseX, mouseY, mouseButton);
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        for (Panel p : panels) {
            p.isDragging = false;
            //p.mouseReleased(mouseX, mouseY, mouseButton);
        }
    }
}
