import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogLevels {

    private static final Pattern LEVEL_PATTERN = Pattern.compile("\\[([A-Z]*)]:\\s*([\\w\\s]*)");
    
    public static String message(String logLine) {
        return message(matcher(logLine));
    }

    public static String logLevel(String logLine) {
        return level(matcher(logLine));
    }

    public static String reformat(String logLine) {
        var matcher = matcher(logLine);
        return String.format("%s (%s)", message(matcher), level(matcher));
    }

    private static Matcher matcher(String logLine) {
        var matcher = LEVEL_PATTERN.matcher(logLine);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("invalid log message: " + logLine);
        }

        return matcher;
    }

    private static String message(Matcher matcher) {
        return matcher.group(2).trim();
    }

    private static String level(Matcher matcher) {
        return matcher.group(1).toLowerCase();
    }
}
