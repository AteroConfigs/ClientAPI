package cc.foaler.api.module;

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

    public Module getModule(String name) {
        for(Module module : modules) {
            if(module.getName().equalsIgnoreCase(name)) {
                return module;
            }
        }
        return null;
    }

    public List<Module> getModules() {
        return modules;
    }
}
