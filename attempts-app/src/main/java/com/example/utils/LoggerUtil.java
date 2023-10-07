package com.example.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class LoggerUtil {
    private static Logger logger = null;

    private LoggerUtil() {
        Configurator.setRootLevel(org.apache.logging.log4j.Level.ALL);
        logger = LogManager.getLogger(LoggerUtil.class);
    }

    public static Logger getInstance() {
        if (logger == null) {
            new LoggerUtil();
        }
        return logger;
    }
}
