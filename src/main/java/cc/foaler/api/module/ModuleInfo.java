package cc.foaler.api.module;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ModuleInfo {
    String name();
    String description();
    Category category();
    int bind();
    boolean show() default true;
}
