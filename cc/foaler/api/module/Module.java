package cc.foaler.api.module;

import cc.foaler.api.ClientAPI;

public abstract class Module {

    private String name;
    private String description;
    private Category category;
    private int bind;
    private boolean show;

    private boolean state;

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

    public boolean isEnabled() {
        return state;
    }

    public void setEnabled(boolean state) {
        if(state) {
            this.state = true;
            onEnable();

            ClientAPI.getInstance().getEventManager().register(this);
        } else {
            this.state = false;
            onDisable();

            ClientAPI.getInstance().getEventManager().unregister(this);
        }
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
