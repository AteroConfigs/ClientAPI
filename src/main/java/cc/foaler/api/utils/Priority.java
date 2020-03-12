package cc.foaler.api.utils;

public enum Priority {
    LOW(1),NORMAL(2),HIGH(3);

    int priority;

    Priority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
