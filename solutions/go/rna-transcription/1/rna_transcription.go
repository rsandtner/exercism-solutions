package strand

// ToRNA converts the given DNA into RNA
//
// DNA -> RNA
//  G  ->  C
//  C  ->  G
//  T  ->  A
//  A  ->  U
func ToRNA(dna string) string {

	rna := make([]byte, len(dna))
	for i, r := range dna {

		switch r {
		case 'G':
			rna[i] = 'C'
		case 'C':
			rna[i] = 'G'
		case 'T':
			rna[i] = 'A'
		case 'A':
			rna[i] = 'U'
		}
	}

	return string(rna)
}
