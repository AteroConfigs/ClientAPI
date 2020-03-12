package cc.foaler.api.command;

import java.util.List;

public abstract class Command {

    private CommandInfo commandInfo = getClass().getAnnotation(CommandInfo.class);

    private String name;
    private String description;
    private String[] alias;

    public Command() {
        name = commandInfo.name();
        description = commandInfo.description();
        alias = commandInfo.alias();
    }

    public abstract void onRun(String args);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getAlias() {
        return alias;
    }

    public void setAlias(String[] alias) {
        this.alias = alias;
    }
}
