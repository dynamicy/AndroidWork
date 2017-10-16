package io.csie.chris.logger;

import android.util.Log;

/**
 * Title: io.csie.chris.logger.Logger <br/>
 * Description: Logger <br/>
 *
 * @author chrish
 * @version 1.0
 */
public class Logger {

    private static final String TAG = Logger.class.getSimpleName();

    private static Logger Instance;

    /**
     * VERBOSE = 2<br/>
     * DEBUG = 3<br/>
     * INFO = 4<br/>
     * WARN = 5;<br/>
     * ERROR = 6;<br/>
     */
    private int appLogLevel;

    private Logger() {

        Log.i(TAG, "Logger init...");

        String level = "DEBUG";

        switch (level) {
            case "VERBOSE":
                appLogLevel = Log.VERBOSE;
                break;
            case "DEBUG":
                appLogLevel = Log.DEBUG;
                break;
            case "INFO":
                appLogLevel = Log.INFO;
                break;
            case "WARN":
                appLogLevel = Log.WARN;
                break;
            case "ERROR":
                appLogLevel = Log.ERROR;
                break;
            default:
                appLogLevel = Log.INFO;
        }
    }

    public static void v(String message) {
        if (isSystemLogLoggable(Log.VERBOSE) || isAppLogLoggable(Log.VERBOSE)) {
            Log.v(getCallerClassName(), message);
        }
    }

    public static void d(String message) {
        if (isSystemLogLoggable(Log.DEBUG) || isAppLogLoggable(Log.DEBUG)) {
            Log.d(getCallerClassName(), message);
        }
    }

    public static void i(String message) {
        if (isSystemLogLoggable(Log.INFO) || isAppLogLoggable(Log.INFO)) {
            Log.i(getCallerClassName(), message);
        }
    }

    public static void w(String message) {
        if (isSystemLogLoggable(Log.WARN) || isAppLogLoggable(Log.WARN)) {
            Log.w(getCallerClassName(), message);
        }
    }

    public static void e(String message) {
        if (isSystemLogLoggable(Log.ERROR) || isAppLogLoggable(Log.ERROR)) {
            Log.e(getCallerClassName(), message);
        }
    }

    public static void e(String message, Throwable t) {
        if (isSystemLogLoggable(Log.ERROR) || isAppLogLoggable(Log.ERROR)) {
            Log.e(getCallerClassName(), message, t);
        }
    }

    /**
     * Get Caller Class Name
     *
     * @return class name
     */
    private static String getCallerClassName() {

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

        int targetIdx = 0;

        for (int i = 0; i < stackTraceElements.length; i++) {

            StackTraceElement e = stackTraceElements[i];

            if (e.getClassName().equals(Logger.class.getName())) {
                targetIdx = i + 2;
                break;
            }
        }

        if (targetIdx < stackTraceElements.length) {
            return stackTraceElements[targetIdx].getClassName();
        } else {
            return Logger.class.getName();
        }

    }

    /**
     * the same vaule in android.util.Log
     * VERBOSE = 2<br/>
     * DEBUG = 3<br/>
     * INFO = 4<br/>
     * WARN = 5;<br/>
     * ERROR = 6;<br/>
     */
    @SuppressWarnings("unused")
    public void setAppLogLevel(int appLogLevel) {
        this.appLogLevel = appLogLevel;
    }

    private static boolean isSystemLogLoggable(int logLevel) {
        return Log.isLoggable(TAG, logLevel);
    }

    private static boolean isAppLogLoggable(int logLevel) {
        return logLevel >= getInstance().appLogLevel;
    }

    public static Logger getInstance() {

        if (Instance == null) {
            newInstance();
        }

        return Instance;
    }

    private static synchronized void newInstance() {
        if (Instance == null) {
            Instance = new Logger();
        }
    }

}
