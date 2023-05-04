package main

type MyLinkedList struct {
	Head *Node
	Size int
}

type Node struct {
	Val  int
	Next *Node
}

func Constructor() MyLinkedList {
	return MyLinkedList{
		Head: new(Node),
		Size: 0,
	}
}

func (this *MyLinkedList) Get(index int) int {
	if index < 0 || index >= this.Size {
		return -1
	}

	head := this.Head
	for i := 0; i < index+1; i++ {
		head = head.Next
	}

	return head.Val
}

func (this *MyLinkedList) AddAtHead(val int) {
	this.AddAtIndex(0, val)
}

func (this *MyLinkedList) AddAtTail(val int) {
	this.AddAtIndex(this.Size, val)
}

func (this *MyLinkedList) AddAtIndex(index int, val int) {
	if index > this.Size {
		return
	}

	prev := this.Head
	for i := 0; i < index; i++ {
		prev = prev.Next
	}

	this.Size++
	prev.Next = &Node{
		Val:  val,
		Next: prev.Next,
	}
}

func (this *MyLinkedList) DeleteAtIndex(index int) {
	if index < 0 || index >= this.Size {
		return
	}

	prev := this.Head
	for i := 0; i < index; i++ {
		prev = prev.Next
	}

	this.Size--
	prev.Next = prev.Next.Next
}
