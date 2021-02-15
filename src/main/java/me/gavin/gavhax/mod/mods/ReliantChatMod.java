package me.gavin.gavhax.mod.mods;

import me.gavin.gavhax.mod.Category;
import me.gavin.gavhax.mod.Module;
import me.gavin.gavhax.util.BooleanHooks;

public class ReliantChatMod extends Module {
    public ReliantChatMod() {
        super("ReliantChat", "makes the chat like from reliant", Category.Render);
    }

    public void onEnable() {
        BooleanHooks.DO_RELIANT_CHAT = true;
    }

    public void onDisable() {
        BooleanHooks.DO_RELIANT_CHAT = false;;
    }
}
