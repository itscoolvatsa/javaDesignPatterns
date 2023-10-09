package com.example.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.builder.api.*;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

import java.io.File;

public class LoggerUtil {
    private static Logger logger = null;

    private LoggerUtil(Class<?> clazz) {
        logger = LogManager.getLogger(clazz);
    }

    public static Logger getInstance(Class<?> clazz) {
        if (logger == null || logger.getClass() != clazz) {
            new LoggerUtil(clazz);
        }
        return logger;
    }
}
