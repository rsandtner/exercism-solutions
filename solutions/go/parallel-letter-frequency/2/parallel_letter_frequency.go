package letter

// FreqMap records the frequency of each rune in a given text.
type FreqMap map[rune]int

// Frequency counts the frequency of each rune in a given text and returns this
// data as a FreqMap.
func Frequency(s string) FreqMap {
	m := FreqMap{}
	for _, r := range s {
		m[r]++
	}
	return m
}

// ConcurrentFrequency counts the frequency of each rune in the given strings
func ConcurrentFrequency(s []string) FreqMap {

	recorder := make(chan FreqMap)

	for _, r := range s {
		go func(s string) {
			recorder <- Frequency(s)
		}(r)
	}

	m := FreqMap{}
	for i := 0; i < len(s); i++ {
		for k, v := range <-recorder {
			m[k] = m[k] + v
		}
	}

	return m
}
