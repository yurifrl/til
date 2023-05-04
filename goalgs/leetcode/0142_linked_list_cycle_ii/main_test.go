package main

import (
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
			if got := detectCycle(tc.args.head); got != tc.want {
				t.Errorf("detectCycle() = %v, want %v", got, tc.want)
			}
		})

		t.Run(tc.name, func(t *testing.T) {
			if got := detectCycle2(tc.args.head); got != tc.want {
				t.Errorf("detectCycle2() = %v, want %v", got, tc.want)
			}
		})
	}
}
