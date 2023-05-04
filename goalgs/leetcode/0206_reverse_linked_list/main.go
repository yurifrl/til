package main

type ListNode struct {
	Val  int
	Next *ListNode
}

// faster
func reverseList(head *ListNode) (prev *ListNode) {

	for head != nil {
		head.Next, prev, head = prev, head, head.Next
	}
	return

}

// slower
func reverseList2(head *ListNode) (prev *ListNode) {

	var next *ListNode
	for head != nil {
		next = head.Next
		head.Next = prev
		prev = head
		head = next
	}
	return

}
