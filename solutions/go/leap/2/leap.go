package leap

// IsLeapYear checks if the given number is a leap year
func IsLeapYear(year int) bool {
	//return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)

	if year%4 == 0 {
		if year%100 == 0 {
			if year%400 == 0 {
				return true
			} else {
				return false
			}
		} else {
			return true
		}
	}
	return false
}
