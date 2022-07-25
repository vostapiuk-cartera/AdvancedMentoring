package com.ostapiuk.core.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.util.Properties;

public class Log {
    private static Logger logger = null;

    private Log() {
        throw new IllegalStateException("Utility class");
    }

    public static Logger setName(String name) {
        logger = Logger.getLogger(String.format("%s", name));
        Properties props = new Properties();
        try (FileInputStream istream = new FileInputStream("src/main/resources/log4j.properties")) {
            props.load(istream);
        } catch (Exception e) {
            getLogger().trace(e);
        }
        PropertyConfigurator.configure(props);
        return logger;
    }

    public static Logger getLogger() {
        if (logger == null) {
            logger = setName("Test");
        }
        return logger;
    }

    public static void log(String message) {
        getLogger().info(message);
    }
}
