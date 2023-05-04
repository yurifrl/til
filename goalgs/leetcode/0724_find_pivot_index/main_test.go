package main

import (
	"testing"
)

func Test(t *testing.T) {
	type args struct {
		nums []int
	}
	testcases := []struct {
		name string
		args args
		want int
	}{
		{
			name: "Test-1",
			args: args{
				nums: []int{1, 7, 3, 6, 5, 6},
			},
			want: 3,
		},
	}
	for _, tc := range testcases {
		t.Run(tc.name, func(t *testing.T) {
			if got := pivotIndex(tc.args.nums); got != tc.want {
				t.Errorf("pivotIndex() = %v, want %v", got, tc.want)
			}
		})
	}
}
