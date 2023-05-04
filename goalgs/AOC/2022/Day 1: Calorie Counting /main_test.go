package main

import (
	"reflect"
	"testing"
)

func Test(t *testing.T) {
	testcases := []struct {
		name string
		args []*ListNode
		want *ListNode
	}{
		{
			name: "Test-1",
			args: """
				1000
				2000
				3000

				4000

				5000
				6000

				7000
				8000
				9000

				10000
				""",
			want: 24000,
		},
	}
	for _, tc := range testcases {
		t.Run(tc.name, func(t *testing.T) {
			if got := exec(tc.args[0]); got != tc.want {
				t.Errorf("exec() = %v, want %v", got, tc.want)
			}
		})
	}
}
