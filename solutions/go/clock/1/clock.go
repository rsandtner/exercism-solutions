package clock

import "fmt"

const dayInMinutes = 24 * 60

// Clock is a clock with only hours and minutes
type Clock struct {
	hour   int
	minute int
}

// New create a new Clock
func New(h, m int) Clock {
	return new(h*60 + m)
}

func (c Clock) String() string {
	return fmt.Sprintf("%02d:%02d", c.hour, c.minute)
}

// Add adds the given amount in minutes to the Clock and
// returns a new Clock
func (c Clock) Add(minutes int) Clock {
	return new(c.hour*60 + c.minute + minutes)
}

// Subtract reduces the given amount in minutes from the Clock and
// returns a new Clock
func (c Clock) Subtract(minutes int) Clock {
	return new(c.hour*60 + c.minute - minutes)
}

func new(m int) Clock {

	negative := false
	if m < 0 {
		negative = true
		m = -m
	}

	if m >= dayInMinutes {
		m -= dayInMinutes * (m / dayInMinutes)
	}

	if negative {
		m = dayInMinutes - m
	}

	hour := m / 60
	minute := m % 60

	return Clock{hour: hour, minute: minute}
}
