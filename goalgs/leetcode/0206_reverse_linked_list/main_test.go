package main

import (
	"reflect"
	"testing"
)

func Test(t *testing.T) {
	type args struct {
		head *ListNode
	}

	node := &ListNode{
		Val: 0,
		Next: &ListNode{
			Val:  0,
			Next: nil,
		},
	}
	node.Next.Next = node

	testcases := []struct {
		name string
		args args
		want *ListNode
	}{
		{
			name: "Test-1",
			args: args{
				head: &ListNode{
					Val: 0,
					Next: &ListNode{
						Val: 1,
						Next: &ListNode{
							Val: 2,
							Next: &ListNode{
								Val:  0,
								Next: node,
							},
						},
					},
				},
			},
			want: node,
		},
	}
	for _, tc := range testcases {
		t.Run(tc.name, func(t *testing.T) {
			if got := reverseList(tc.args.head); reflect.DeepEqual(got, tc.want) {
				t.Errorf("reverseList() = %v, want %v", got, tc.want)
			}
		})

		if got := reverseList2(tc.args.head); reflect.DeepEqual(got, tc.want) {
			t.Errorf("reverseList2() = %v, want %v", got, tc.want)
		}
	}
}
