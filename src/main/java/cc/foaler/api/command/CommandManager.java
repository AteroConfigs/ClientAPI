package cc.foaler.api.command;

import cc.foaler.api.module.ModuleInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CommandManager {

    private List<Command> commands = new CopyOnWriteArrayList<>();

    public CommandManager() {

    }

    public void addCommand(Command command) {
        if(command.getClass().isAnnotationPresent(ModuleInfo.class)) {
            commands.add(command);
        }
    }

    public void removeCommand(Command command) {
        commands.remove(command);
    }

    public Command getCommand(Command command) {
        return command;
    }

    public Command getCommand(String name) {
        for(Command command : commands) {
            if(command.getName().equalsIgnoreCase(name) || command.getAlias().equals(Collections.singletonList(name))) {
                return command;
            }
        }
        return null;
    }

    public List<Command> getCommands() {
        return commands;
    }
}
