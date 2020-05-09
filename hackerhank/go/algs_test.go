package main

import (
	"reflect"
	"sort"
	"testing"
)

// mergeAlloverlappingIntervals
func mergeAlloverlappingIntervals(intervals [][]int) [][]int {
	if len(intervals) <= 1 {
		return intervals
	}
	sort.Slice(intervals, func(i, j int) bool { return intervals[i][0] < intervals[j][0] })

	response := make([][]int, 0, len(intervals))
	t := intervals[0]
	for i := 1; i < len(intervals); i++ {
		if intervals[i][0] <= t[1] {
			t[1] = max(t[1], intervals[i][1])
		} else {
			response = append(response, t)
			t = intervals[i]
		}
	}

	return append(response, t)
}

// isValid
func isValid(dict []string, word string) bool {
	t := make([]bool, len(word)+1)
	t[0] = true
	for i := 0; i < len(word); i++ {
		if i >= len(t) {
			continue
		}
		for _, d := range dict {
			end := i + len(d)
			if end > len(word) {
				continue
			}
			if end >= len(t) {
				continue
			}
			if word[i:end] == d {
				t[end] = true
			}
		}
	}
	return t[len(word)]
}

// Helpers
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

// Tests ====
/*
TASK 1
Given a non-empty string s and a list wordList containing a list of non-empty words,
determine if s can be segmented into a space-separated sequence of one or more dictionary words.
You may assume the dictionary does not contain duplicate words.
For example, given
	s := "whataniceday",
	wordList := ["a", "what", "an", "nice", "day"].
	return true because "whataniceday" can be segmented as "what a nice day".
*/
func TestTaskOne(t *testing.T) {
	wordList := []string{"a", "what", "an", "nice", "day", "rr"}
	t.Run("Runs ok", func(t *testing.T) {
		is(t, isValid(wordList, "whataniceday"), true)
	})

	t.Run("Runs ok", func(t *testing.T) {
		is(t, isValid(wordList, "whatanicedayaaaa"), true)
	})

	t.Run("Runs ok", func(t *testing.T) {
		is(t, isValid(wordList, "whatanicedayr"), false)
	})

	t.Run("Runs ok", func(t *testing.T) {
		is(t, isValid(wordList, "whatanicedayrr"), true)
	})
}

/*
TASK 2
Given a collection of intervals, merge all overlapping intervals.
For example
	Given [1,3],[8,10],[15,18],[18,21]
	return [1,6],[8,10],[15,21]
*/
func TestTaskTwo(t *testing.T) {
	intervals := [][]int{{1, 3}, {2, 6}, {8, 10}, {15, 18}, {18, 21}}
	overlapping := [][]int{{1, 6}, {8, 10}, {15, 21}}

	t.Run("Runs ok", func(t *testing.T) {
		eq(t, mergeAlloverlappingIntervals(intervals), overlapping)
	})
}

// Helpers ...
func is(t *testing.T, got bool, want bool) {
	t.Helper()
	if got != want {
		t.Errorf("assertion failed, got %v, want %v", got, want)
	}
}

func eq(t *testing.T, got [][]int, want [][]int) {
	t.Helper()
	if !reflect.DeepEqual(got, want) {
		t.Errorf("assertion failed, got %d, want %d", got, want)
	}
}
