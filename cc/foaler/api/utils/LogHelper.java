package cc.foaler.api.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHelper {

    private static LogHelper instance;

    private String name;

    public LogHelper(String name) {
        instance=this;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void log(Level level, Object message) {
        Logger logger = LogManager.getLogger(getName());

        logger.log(level, "(" + getName() + "): " + message);
    }

    public void off(Object message) {
        getInstance(). log(Level.OFF, message);
    }

    public void fatal(Object message) {
        getInstance().log(Level.FATAL, message);
    }

    public void error(Object message) {
        getInstance().log(Level.ERROR, message);
    }

    public void warn(Object message) {
        getInstance().log(Level.WARN, message);
    }

    public void info(Object message) {
        getInstance().log(Level.INFO, message);
    }

    public void debug(Object message) {
        getInstance().log(Level.DEBUG, message);
    }

    public void trace(Object message) {
        getInstance().log(Level.TRACE, message);
    }

    public void all(Object message) {
        getInstance().log(Level.ALL, message);
    }

    public LogHelper getInstance() {
        return instance;
    }
}
