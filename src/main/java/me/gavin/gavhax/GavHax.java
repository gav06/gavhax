package me.gavin.gavhax;

import me.gavin.gavhax.event.EventProcessor;
import me.gavin.gavhax.mod.ModuleManager;
import me.gavin.gavhax.util.reliantFont.CFontManager;
import me.gavin.gavhax.util.reliantFont.CFontRenderer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = GavHax.MOD_ID,
        name = GavHax.MOD_NAME,
        version = GavHax.VERSION,
        clientSideOnly = true
)
public class GavHax {

    public static final String MOD_ID = "gavhax";
    public static final String MOD_NAME = "Gavhax";
    public static final String VERSION = "1.0";

    public static CFontRenderer cFont = new CFontRenderer(CFontManager.RELIANT_FONT, true, true);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModuleManager.init_modules();
        EventProcessor.register_events();
    }
}