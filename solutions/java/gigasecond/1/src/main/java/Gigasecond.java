import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Gigasecond {

    private final LocalDateTime calculatedMoment;

    public Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    public Gigasecond(LocalDateTime moment) {
        this.calculatedMoment = moment.plusSeconds(1_000_000_000);
    }

    public LocalDateTime getDateTime() {
        return calculatedMoment;
    }
}
