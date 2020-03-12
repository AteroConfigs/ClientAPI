package cc.foaler.api;

import cc.foaler.api.command.Command;
import cc.foaler.api.command.CommandManager;
import cc.foaler.api.event.EventManager;
import cc.foaler.api.module.Module;
import cc.foaler.api.module.ModuleManager;
import cc.foaler.api.utils.ClassScanner;
import cc.foaler.api.utils.Init;
import one.util.streamex.StreamEx;

import java.util.Comparator;

public class Client {

    private static Client instance = new Client();

    private String name;
    private double version;

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

    public String getName() {
        return name;
    }

    public double getVersion() {
        return version;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public static Client getInstance() {
        return instance;
    }
}
