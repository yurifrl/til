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
    n1 = 0
    n2 = 1
    b = 0
    res = 0
    for (; n > 0; n--) {
        b = n1 + n2
        n1 = n2
        n2 = b
        res += b
    }
    return res;
}

module.exports = { one, two }