package main

import "github.com/k0kubun/pp/v3"

var _ = pp.Println

// Check if a string has all unique characters
func IsUnique(a string) bool {
	b := make(map[rune]bool)
	for _, s := range a {
		if b[s] {
			return false
		}
		b[s] = true
	}
	return true
}
