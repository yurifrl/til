package main

import (
	"reflect"
	"testing"
)

func Test(t *testing.T) {
	type args struct {
		nums []int
	}
	testcases := []struct {
		name string
		args args
		want []int
	}{
		{
			name: "Test-1",
			args: args{
				nums: []int{1, 2, 3, 4},
			},
			want: []int{1, 3, 6, 10},
		},
	}
	for _, tc := range testcases {
		t.Run(tc.name, func(t *testing.T) {
			if got := runningSum(tc.args.nums); !reflect.DeepEqual(got, tc.want) {
				t.Errorf("runningSum() = %v, want %v", got, tc.want)
			}
		})
	}
}
