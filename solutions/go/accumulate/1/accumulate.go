package accumulate

type Mapper func(string) string

func Accumulate(s []string, m Mapper) []string {

	res := make([]string, len(s), len(s))
	for i, p := range s {
		res[i] = m(p)
	}

	return res
}
