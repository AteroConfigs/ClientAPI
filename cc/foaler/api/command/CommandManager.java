package cc.foaler.api.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CommandManager {

    private List<Command> commands = new CopyOnWriteArrayList<>();

    public CommandManager() {

    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void removeCommand(Command command) {
        commands.remove(command);
    }

    public Command getCommand(Command command) {
        return command;
    }

    public Command getCommand(String[] names) {
        for(Command command : commands) {
            if(command.getNames().get(0).equals(names)) {
                return command;
            }
        }
        return null;
    }

    public List<Command> getCommands() {
        return commands;
    }
}
