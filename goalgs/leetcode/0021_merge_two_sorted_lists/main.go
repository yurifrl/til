package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	prehead := &ListNode{}
	prev := prehead

	for list1 != nil && list2 != nil {
		if list1.Val <= list2.Val {
			prev.Next = list1
			// move list1
			list1 = list1.Next
		} else {
			prev.Next = list2
			// move list2
			list2 = list2.Next
		}

		prev = prev.Next
	}

	// if list1 is empty return list2
	// list2 is the list
	if list1 == nil {
		prev.Next = list2
	} else {
		prev.Next = list1
	}

	return prehead.Next
}
