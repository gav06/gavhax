package me.gavin.gavhax.mod;

import me.gavin.gavhax.mod.mods.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModuleManager {

    public static ArrayList<Module> modules = new ArrayList<>();

    public static void init_modules() {
        // render
        addModule(new WallhacksMod());
        addModule(new NoCaveCullingMod());
        addModule(new FullbrightMod());
        addModule(new AntiBatMod());
        addModule(new NoRenderMod());
        addModule(new TracersMod());
        addModule(new ReliantChatMod());
        addModule(new ChestESPMod());
        addModule(new MobESPMod());

        // combat
        addModule(new AutoTotemMod());
        addModule(new CriticalsMod());
        addModule(new KillAuraMod());
        addModule(new FastXPMod());

        // movement
        addModule(new AntiKockbackMod());
        addModule(new NoFallMod());
        addModule(new SprintMod());
        addModule(new CreativeFlyMod());
        addModule(new StepMod());

        // world
        addModule(new XCarryMod());
        addModule(new FastPlaceMod());
        addModule(new PortalGodModeMod());
        addModule(new NoRotateMod());
        addModule(new NoBreakDelayMod());
        addModule(new AntiExplosionMod());

        modules.sort(ModuleManager::compareTo);
    }

    private static void addModule(Module m) {
        modules.add(m);
    }

    public static List<Module> getModulesByCategory(Category cat) {
        return modules.stream().filter(module -> module.category == cat).collect(Collectors.toList());
    }

    public static int compareTo(Module firstMod, Module secondMod) {
        return Integer.compare(firstMod.name.compareTo(secondMod.name), 0);
    }

    public static Module getModule(String name) {
        return modules.stream().filter(module -> module.name.equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
