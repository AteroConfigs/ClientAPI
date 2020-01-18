package cc.foaler.api;

import cc.foaler.api.event.EventManager;
import cc.foaler.api.module.ModuleManager;

public class ClientAPI {

    private static ClientAPI instance = new ClientAPI();

    private EventManager eventManager;
    private ModuleManager moduleManager;

    public void inject() {
        eventManager = new EventManager();
        moduleManager = new ModuleManager();

        eventManager.register(this);
    }

    public void uninject() {
        eventManager.unregister(this);
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }

    public static ClientAPI getInstance() {
        return instance;
    }
}
