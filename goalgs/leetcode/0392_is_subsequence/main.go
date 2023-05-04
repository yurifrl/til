package main

func isIsomorphic(s string, t string) bool {
	s1 := map[byte]byte{}
	t1 := map[byte]byte{}

	for i := 0; i < len(s); i++ {

		if val, ok := s1[s[i]]; ok {
			if val != t[i] {
				return false
			}
		} else {
			s1[s[i]] = t[i]
		}

		if val, ok := t1[t[i]]; ok {
			if val != s[i] {
				return false
			}
		} else {
			t1[t[i]] = s[i]
		}
	}

	return true

}
