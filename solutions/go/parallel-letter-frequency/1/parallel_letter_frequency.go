package letter

import (
	"sync"
)

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
	var wg sync.WaitGroup
	wg.Add(len(s))

	for _, r := range s {
		go func(s string) {
			recorder <- Frequency(s)
			wg.Done()
		}(r)
	}

	go func() {
		wg.Wait()
		close(recorder)
	}()

	m := FreqMap{}
	for rec := range recorder {
		for k, v := range rec {
			m[k] = m[k] + v
		}
	}

	return m
}
