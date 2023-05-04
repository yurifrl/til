package main

import (
	"reflect"
	"testing"
)

func Test(t *testing.T) {
	type args struct {
		n int
	}
	testcases := []struct {
		name string
		args args
		want int
	}{
		{
			name: "Test-1",
			args: args{
				n: 5,
			},
			want: 2,
		},
	}
	for _, tc := range testcases {
		t.Run(tc.name, func(t *testing.T) {
			if got := firstBadVersion(tc.args.n); !reflect.DeepEqual(got, tc.want) {
				t.Errorf("firstBadVersion() = %v, want %v", got, tc.want)
			}
		})
	}
}
