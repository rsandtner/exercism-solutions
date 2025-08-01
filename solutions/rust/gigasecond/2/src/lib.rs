use time::{Duration, PrimitiveDateTime as DateTime};

const GIGA_SECOND: Duration = Duration::seconds(1_000_000_000);

// Returns a DateTime one billion seconds after start.
pub fn after(start: DateTime) -> DateTime {
    start + GIGA_SECOND
}
