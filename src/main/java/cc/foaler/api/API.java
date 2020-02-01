package cc.foaler.api;

import cc.foaler.api.command.Command;
import cc.foaler.api.command.CommandManager;
import cc.foaler.api.event.Event;
import cc.foaler.api.event.EventManager;
import cc.foaler.api.module.Module;
import cc.foaler.api.module.ModuleManager;
import cc.foaler.api.utils.ClassScanner;
import cc.foaler.api.utils.Client;
import cc.foaler.api.utils.Init;
import cc.foaler.api.utils.LogHelper;
import one.util.streamex.StreamEx;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

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

    public void initializeScanner(Class<?> mainClass, Client client, boolean loadModules, boolean loadCommands) {
        StreamEx.of(ClassScanner.scanFile(null, mainClass)).filter(c -> {
            try {
                Class clazz = Class.forName(c);

                return clazz.isAnnotationPresent(Init.class);
            } catch(Exception e) {
                e.printStackTrace();
            }
            return false;
        }).sorted(Comparator.comparingInt(c -> {
            try {
                Class clazz = Class.forName(c);

                Init annotation = (Init) clazz.getAnnotation(Init.class);

                return annotation.priority().getPriority();
            } catch(Exception e) {
                e.printStackTrace();
            }
            return 3;
        })).forEachOrdered(c -> {
            try {
                Class clazz = Class.forName(c);

                if(clazz.isAnnotationPresent(Init.class)) {
                    Object obj = clazz.equals(mainClass) ? client : clazz.newInstance();
                    Init annotation = (Init) clazz.getAnnotation(Init.class);

                    if (loadModules && obj instanceof Module) {
                        getModuleManager().addModule((Module) obj);
                    } else if(loadCommands && obj instanceof Command) {
                        getCommandManager().addCommand((Command) obj);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
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
