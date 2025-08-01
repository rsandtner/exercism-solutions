import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(bornAt: LocalDateTime) {
    
    constructor(bornAt: LocalDate) : this(bornAt.atStartOfDay())
    
    val date = bornAt.plusSeconds(1_000_000_000)
    
}
