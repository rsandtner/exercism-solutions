package raindrops

import "strconv"

// Convert converts the given number into a string
//
// if the number is a factor of 3 -> it will be replaced with "Pling"
// if the number is a factor of 5 -> it will be replaced with "Plang"
// if the number is a factor of 7 -> it will be replaced with "Plong"
//
// in case the number has multiple factors, the strings will be concatenated.
func Convert(i int) string {
	type drop struct {
		factor int
		name   string
	}

	var factors = [3]drop{
		{factor: 3, name: "Pling"},
		{factor: 5, name: "Plang"},
		{factor: 7, name: "Plong"},
	}

	var s string
	for _, f := range factors {
		if i%f.factor == 0 {
			s = s + f.name
		}
	}

	if s == "" {
		return strconv.Itoa(i)
	}

	return s
}
