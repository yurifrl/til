package main

func isSubsequence(s string, t string) bool {
	si := 0

	if s == "" {
		return true
	}

	for t1 := range t {
		if t[t1] == s[si] {
			si++
		}

		if len(s) == si {
			return true
		}
	}

	return false
}
