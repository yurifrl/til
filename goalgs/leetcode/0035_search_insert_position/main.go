package main

func searchInsert(nums []int, target int) int {
	left, right := 0, len(nums)-1
	var mid int

	for left <= right {
		mid = int(uint(left+right)) >> 1

		if nums[mid] == target {
			return mid
		}

		if nums[mid] < target {
			left = mid + 1
		} else {
			right = mid - 1
		}
	}

	return left
}
