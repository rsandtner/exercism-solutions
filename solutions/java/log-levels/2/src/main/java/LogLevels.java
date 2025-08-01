import java.util.regex.Pattern;

public class LogLevels {

    public static String message(String logLine) {
        return LogMessage.fromLine(logLine).message();
    }

    public static String logLevel(String logLine) {
        return LogMessage.fromLine(logLine).level();
    }

    public static String reformat(String logLine) {
        var log = LogMessage.fromLine(logLine);
        return log.message() + " (" + log.level() + ")";
    }
}

record LogMessage(String level, String message) {

    private static final Pattern LEVEL_PATTERN = Pattern.compile("\\[([A-Z]*)]:\\s*([\\w\\s]*)");

    static LogMessage fromLine(String logLine) {
        var matcher = LEVEL_PATTERN.matcher(logLine);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("invalid log message: " + logLine);
        }

        return new LogMessage(matcher.group(1).toLowerCase(), matcher.group(2).trim());
    }
}
