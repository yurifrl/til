package main

import (
	"reflect"
	"testing"
)

func Test(t *testing.T) {
	testcases := []struct {
		name string
		args []string
		want bool
	}{
		{
			name: "Test-1",
			args: []string{
				"abc",
				"ahbgdc",
			},
			want: true,
		},
	}
	for _, tc := range testcases {
		t.Run(tc.name, func(t *testing.T) {
			if got := isSubsequence(tc.args[0], tc.args[1]); !reflect.DeepEqual(got, tc.want) {
				t.Errorf("isSubsequence() = %v, want %v", got, tc.want)
			}
		})
	}
}
