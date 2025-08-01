package proverb

import (
	"fmt"
	"testing"
)

func TestProverb(t *testing.T) {
	for _, test := range stringTestCases {
		actual := Proverb(test.input)
		if fmt.Sprintf("%q", actual) != fmt.Sprintf("%q", test.expected) {
			t.Fatalf("FAIL %s - Proverb test [%s]\n\texpected: [%s],\n\tactual:   [%s]",
				test.description, test.input, test.expected, actual)
		}
		t.Logf("PASS %s", test.description)
	}
}

func TestProverbRecursive(t *testing.T) {
	for _, test := range stringTestCases {
		actual := ProverbRecursive(test.input)
		if fmt.Sprintf("%q", actual) != fmt.Sprintf("%q", test.expected) {
			t.Fatalf("FAIL %s - Proverb test [%s]\n\texpected: [%s],\n\tactual:   [%s]",
				test.description, test.input, test.expected, actual)
		}
		t.Logf("PASS %s", test.description)
	}
}

func TestProverbRecursiveInitialized(t *testing.T) {
	for _, test := range stringTestCases {
		actual := ProverbRecursiveInitialized(test.input)
		if fmt.Sprintf("%q", actual) != fmt.Sprintf("%q", test.expected) {
			t.Fatalf("FAIL %s - Proverb test [%s]\n\texpected: [%s],\n\tactual:   [%s]",
				test.description, test.input, test.expected, actual)
		}
		t.Logf("PASS %s", test.description)
	}
}

func BenchmarkProverb(b *testing.B) {
	for i := 0; i < b.N; i++ {
		for _, test := range stringTestCases {
			Proverb(test.input)
		}
	}
}

func BenchmarkProverbRecursive(b *testing.B) {
	for i := 0; i < b.N; i++ {
		for _, test := range stringTestCases {
			ProverbRecursive(test.input)
		}
	}
}

func BenchmarkProverbRecursiveInitialized(b *testing.B) {
	for i := 0; i < b.N; i++ {
		for _, test := range stringTestCases {
			ProverbRecursiveInitialized(test.input)
		}
	}
}
