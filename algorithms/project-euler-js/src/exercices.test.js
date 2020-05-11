const test = require('ava');

const e = require('./exercices');

test('one', t => {
  t.is(e.one(10), 23)
  t.is(e.one(1000), 233168)
})

test('two', t => {
  // 0, 1, 1, 2, 5, 8
  t.is(e.two(10), 10)
  //
  t.is(e.two(4000000), 4613732)
})

test.only('three', t => {
  // Largest prime
  // t.is(e.three(13195), 29)
  //
  t.is(e.three(600851475143), 29)
})
