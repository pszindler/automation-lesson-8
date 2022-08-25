package utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {
    private static final Logger logger = LoggerFactory.getLogger(Log.class);

    public static void startTestCase(String testCaseName) {
        logger.info("test started: " + testCaseName);
    }

    public static void endTestCase(String testCaseName) {
        logger.info("test ended: " + testCaseName);
    }

    public static void classThreadInfo(Object obj) {
        logger.info(obj.getClass().getName() + " initialized with thread: " + Thread.currentThread().getName());
    }

    public static void seleniumThreadExitInfo() {
        logger.info("Selenium Web driver successfully closed on thread: " + Thread.currentThread().getName());
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void trace(String message) {
        logger.trace(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }


}
