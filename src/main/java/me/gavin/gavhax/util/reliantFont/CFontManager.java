package me.gavin.gavhax.util.reliantFont;

import java.awt.*;

public class CFontManager {

    public static Font RELIANT_FONT = getFontByName("r").deriveFont(18f);

    public static Font getFontByName(String name) {
        if (name.equalsIgnoreCase("r")) {
            return getFontFromInput("/assets/gavhax/font.ttf");
        }
        return null;
    }

    public static Font getFontFromInput(String path) {

        try {
            Font newFont = Font.createFont(Font.TRUETYPE_FONT, CFontManager.class.getResourceAsStream(path));
            return newFont;
        }
        catch (Exception e) {
            return null;
        }
    }
}
