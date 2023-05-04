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
			args: []*ListNode{
				{
					Val: 1,
					Next: &ListNode{
						Val: 2,
						Next: &ListNode{
							Val: 4,
						},
					},
				},
				{
					Val: 1,
					Next: &ListNode{
						Val: 3,
						Next: &ListNode{
							Val: 4,
						},
					},
				},
			},
			want: &ListNode{
				Val: 1,
				Next: &ListNode{
					Val: 1,
					Next: &ListNode{
						Val: 2,
						Next: &ListNode{
							Val: 3,
							Next: &ListNode{
								Val: 4,
								Next: &ListNode{
									Val: 4,
								},
							},
						},
					},
				},
			},
		},
	}
	for _, tc := range testcases {
		t.Run(tc.name, func(t *testing.T) {
			if got := mergeTwoLists(tc.args[0], tc.args[1]); !reflect.DeepEqual(got, tc.want) {
				t.Errorf("mergeTwoLists() = %v, want %v", got, tc.want)
			}
		})
	}
}
