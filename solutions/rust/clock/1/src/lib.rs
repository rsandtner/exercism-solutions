use std::cmp::Ordering;
use std::fmt::{Display, Formatter};
use time::Duration;

#[derive(Debug, PartialEq, Eq)]
pub struct Clock {
    minutes: i32,
}

impl Display for Clock {
    fn fmt(&self, f: &mut Formatter<'_>) -> std::fmt::Result {
        let mut hours = self.minutes / 60;
        let minutes = self.minutes - (60 * hours);
        if hours == 24 {
            hours = 0;
        }
        write!(f, "{:02}:{:02}", hours, minutes)
    }
}

impl Clock {
    const DAY_IN_MINUTES: i32 = Duration::days(1).whole_minutes() as i32;

    pub fn new(hours: i32, minutes: i32) -> Self {
        let total_minutes = (hours * 60) + minutes;
        Self {
            minutes: Self::minutes(total_minutes),
        }
    }

    pub fn add_minutes(&self, minutes: i32) -> Self {
        Self {
            minutes: Self::minutes(self.minutes + minutes),
        }
    }

    fn minutes(minutes: i32) -> i32 {
        if minutes.is_negative() {
            let abs = minutes.abs();
            let minutes = Self::handle_days(abs);
            return Self::DAY_IN_MINUTES - minutes;
        }

        Self::handle_days(minutes)
    }

    fn handle_days(minutes: i32) -> i32 {
        match minutes.cmp(&Self::DAY_IN_MINUTES) {
            Ordering::Less => minutes,
            Ordering::Equal => 0,
            _ => {
                let days = minutes / Self::DAY_IN_MINUTES;
                minutes - (Self::DAY_IN_MINUTES * days)
            }
        }
    }
}
