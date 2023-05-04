package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func detectCycle(head *ListNode) *ListNode {
	seen := map[*ListNode]struct{}{}
	for head != nil {
		if _, ok := seen[head]; ok {
			return head
		}

		seen[head] = struct{}{}
		head = head.Next
	}

	return nil
}

func detectCycle2(head *ListNode) *ListNode {
	slow, fast, isCycle := head, head, false

	for fast != nil && fast.Next != nil {
		slow, fast = slow.Next, fast.Next.Next

		if fast == slow {
			isCycle = true
			break
		}
	}

	if !isCycle {
		return nil
	}

	for head != fast {
		head, fast = head.Next, fast.Next
	}

	return head
}
