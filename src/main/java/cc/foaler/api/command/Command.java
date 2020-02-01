package cc.foaler.api.command;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Command {

    private String name = getClass().getAnnotation(CommandInfo.class).name();
    private String description = getClass().getAnnotation(CommandInfo.class).description();
    private String[] alias = getClass().getAnnotation(CommandInfo.class).alias();

    private List<Serializable> names;

    public Command() {
        names.addAll(Arrays.asList(name, alias));
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

    public List<Serializable> getNames() {
        return names;
    }

    public void setNames(List<Serializable> names) {
        this.names = names;
    }
}
