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
	var c Clock
	c.normalize(h*60 + m)
	return c
}

func (c Clock) String() string {
	return fmt.Sprintf("%02d:%02d", c.hour, c.minute)
}

// Add adds the given amount in minutes to the Clock and
// returns a new Clock
func (c Clock) Add(minutes int) Clock {
	c.normalize(c.hour*60 + c.minute + minutes)
	return c
}

// Subtract reduces the given amount in minutes from the Clock and
// returns a new Clock
func (c Clock) Subtract(minutes int) Clock {
	c.normalize(c.hour*60 + c.minute - minutes)
	return c
}

func (c *Clock) normalize(m int) {

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

	c.hour = m / 60
	c.minute = m % 60
}
