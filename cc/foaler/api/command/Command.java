package cc.foaler.api.command;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Command {

    private String name;
    private String description;
    private String[] alias;

    private List<Serializable> names;

    public Command(String name, String description, String... alias) {
        this.name = name;
        this.description = description;
        this.alias = alias;
        this.names = new ArrayList<>();

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
