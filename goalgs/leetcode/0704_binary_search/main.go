package main

func search(nums []int, target int) int {
	low := 0
	high := len(nums) - 1
	var mid int
	for low <= high {
		// mid = (low + high) / 2
		mid = low + (high-low)>>1

		if nums[mid] == target {
			return mid
		}

		if target < nums[mid] {
			high = mid - 1
		} else {
			low = mid + 1
		}
	}

	return -1
}
