package cc.foaler.api.module;

public class Mode<T extends Module> {

    private String name;
    private T parent;

    public Mode(String name, T parent) {
        this.name = name;
        this.parent = parent;
    }

    public void onEnable() {

    }

    public void onDisable() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getParent() {
        return parent;
    }

    public void setParent(T parent) {
        this.parent = parent;
    }
}
