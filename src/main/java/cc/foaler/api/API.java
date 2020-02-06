package cc.foaler.api;

import cc.foaler.api.command.CommandManager;
import cc.foaler.api.event.EventManager;
import cc.foaler.api.module.ModuleManager;

public class API {

    private static API instance = new API();

    private EventManager eventManager;
    private CommandManager commandManager;
    private ModuleManager moduleManager;

    public void register() {
        moduleManager = new ModuleManager();
        commandManager = new CommandManager();

        eventManager = new EventManager();
        eventManager.register(this);
    }

    public void unregister() {
        eventManager.unregister(this);
    }

    public static void setInstance(API instance) {
        API.instance = instance;
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public void setEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }

    public void setModuleManager(ModuleManager moduleManager) {
        this.moduleManager = moduleManager;
    }

    public static API getInstance() {
        return instance;
    }
}
