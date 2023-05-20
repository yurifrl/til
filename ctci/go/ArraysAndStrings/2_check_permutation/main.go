package main

import "github.com/k0kubun/pp/v3"

var _ = pp.Println

func CheckPermutation(st1 string, st2 string) bool {
	st1r := []rune(st1)
	st2r := []rune(st2)
	buffer := make([]rune, len(st1r))

	// Check if they are the same size
	// If not, they are not permutation
	if len(st1r) != len(st2r) {
		return false
	}

	// Invert
	copy(buffer, st1r)
	for i, j := 0, len(st1)-1; j >= 0; {
		st1r[i] = buffer[j]
		i++
		j--

	}
	// Check if they are equal
	for i := 0; i < len(st1r); i++ {
		if st1r[i] != st2r[i] {
			return false
		}
	}
	return true
}
