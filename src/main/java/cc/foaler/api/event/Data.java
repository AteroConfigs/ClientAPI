package cc.foaler.api.event;

import java.lang.reflect.Method;

public class Data {

    public final Object source;
    public final Method target;
    public final Priority priority;

    public Data(Object source, Method target, Priority priority) {
        this.source = source;
        this.target = target;
        this.priority = priority;
    }
}
