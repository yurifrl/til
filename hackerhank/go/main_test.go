package main

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

// func TestFirstCase(t *testing.T) {
// 	var expected int32
//
// 	managers := [][]int32{[]int32{1, 60}, []int32{2, 20}, []int32{3, 95}, []int32{4, 75}}
// 	customers := [][]int32{[]int32{1, 90}, []int32{2, 20}, []int32{3, 70}, []int32{4, 40}, []int32{5, 60}, []int32{6, 10}}
// 	managersVacantIds := []int32{2, 4}
//
// 	res := csRush(int32(len(managers)), int32(len(customers)), managers, customers, managersVacantIds)
// 	expected = 1
//
// 	assert.Equal(t, expected, res, "they should be equal")
// }

func TestHasMoreSuitableManager(t *testing.T) {
	capabilities := []int32{60, 95}

	// t.Run("false", func(t *testing.T) {
	// 	size := int32(10)
	// 	current := int32(60)
	// 	assert.Equal(t, false, hasMoreSuitableManager(size, current, capabilities), "they should be equal")
	// })

	// t.Run("true", func(t *testing.T) {
	// 	size := int32(10)
	// 	current := int32(95)
	// 	assert.Equal(t, true, hasMoreSuitableManager(size, current, capabilities), "they should be equal")
	// })

	t.Run("true", func(t *testing.T) {
		size := int32(90)
		current := int32(60)
		assert.Equal(t, true, hasMoreSuitableManager(size, current, capabilities), "they should be equal")
	})
}
