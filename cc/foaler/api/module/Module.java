package cc.foaler.api.module;

import cc.foaler.api.API;

import java.util.ArrayList;
import java.util.List;

public abstract class Module {

    private String name;
    private String description;
    private Category category;
    private int bind;
    private boolean show;

    private boolean state;
    public Mode mode;
    private List<Mode> modes = new ArrayList<>();

    public Module(String name, String description, Category category, int bind, boolean show) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.bind = bind;
        this.show = show;
    }

    public void toggle() {
        setEnabled(!state);
    }

    public void onEnable() {

    }

    public void onDisable() {

    }

    public void init() {

    }

    public boolean isEnabled() {
        return state;
    }

    public void setEnabled(boolean state) {
        if(state) {
            if(mode != null) {
                this.state = true;
                mode.onEnable();

                API.getInstance().getEventManager().register(mode);
            } else {
                this.state = true;
                onEnable();

                API.getInstance().getEventManager().register(this);
            }
        } else {
            if(mode != null) {
                this.state = false;
                mode.onDisable();

                API.getInstance().getEventManager().unregister(mode);
            } else {
                this.state = false;
                onDisable();

                API.getInstance().getEventManager().unregister(this);
            }
        }
    }

    public List<Mode> getModes() {
        return modes;
    }

    public void addMode(Mode mode) {
        this.mode = mode;

        modes.add(mode);
    }

    public void removeMode(Mode mode) {
        this.mode = null;

        modes.remove(mode);
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public Mode getMode(Mode mode) {
        return mode;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getBind() {
        return bind;
    }

    public void setBind(int bind) {
        this.bind = bind;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
