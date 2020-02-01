package cc.foaler.api.module;

import cc.foaler.api.API;
import cc.foaler.api.event.EventHandler;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ModuleManager {

    private List<Module> modules = new CopyOnWriteArrayList<>();

    public ModuleManager() {
        
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public void removeModule(Module module) {
        modules.remove(module);
    }

    public Module getModule(Module module) {
        return module;
    }

    public List<Module> getModules() {
        return modules;
    }
}
