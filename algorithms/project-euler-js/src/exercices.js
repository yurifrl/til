// Find the sum of all the multiples of 3 or 5 below 1000.
const one = function(r) {
  let acc = 0;
  for (let i = 1; i < r; i++) {
    let multTree = i % 3 == 0
    let multFive = i % 5 == 0
    if (multTree || multFive) {
      acc += i;
    }
  }
  return acc
}

// By considering the terms in the Fibonacci sequence whose values do
// not exceed four million, find the sum of the even-valued terms.
const two = function(n) {
  let n1 = 0
  let n2 = 1
  let temp = 0
  let sum = 0
  while (true) {
    temp = n1
    n1 = n2
    n2 = temp + n2
    if (n2 % 2 == 0) {
      sum += n2
    }
    if (n2 >= n) {
      break
    }
  }
  return sum;
}

const three = function(n) {
  let largestPrime = n
  while (n > 1) {
    if (largestPrime % n == 0) {
      largestPrime = n
    }
    n--
  }
  console.log("ok: " + largestPrime)
  return largestPrime
}

module.exports = { one, two, three }
