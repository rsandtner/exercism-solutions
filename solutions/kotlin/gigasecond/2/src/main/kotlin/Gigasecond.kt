import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(bornAt: LocalDateTime) {

    val date: LocalDateTime = bornAt.plusSeconds(1_000_000_000)

    constructor(bornAt: LocalDate) : this(bornAt.atStartOfDay())
}
