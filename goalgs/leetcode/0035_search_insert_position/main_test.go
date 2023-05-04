package main

import (
	"testing"
)

func Test(t *testing.T) {
	type args struct {
		nums   []int
		target int
	}
	testcases := []struct {
		name string
		args args
		want int
	}{
		{
			name: "Test-1",
			args: args{
				nums:   []int{1, 3, 5, 6},
				target: 5,
			},
			want: 2,
		},
	}
	for _, tc := range testcases {
		t.Run(tc.name, func(t *testing.T) {
			if got := searchInsert(tc.args.nums, tc.args.target); got != tc.want {
				t.Errorf("searchInsert() = %v, want %v", got, tc.want)
			}
		})
	}
}
