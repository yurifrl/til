defmodule Algs do
  @open "<"
  @close ">"

  def run(input) do
    input
    |> String.split("")
    |> loop(0, 0)
  end

  def loop([@close | tail], prev, acc) when prev > 0, do: loop(tail, prev - 1, acc + 1)

  def loop([@open | tail], prev, acc), do: loop(tail, prev + 1, acc)

  def loop([_ | tail], prev, acc), do: loop(tail, prev, acc)

  def loop([], _, acc), do: acc

  def fib(0), do: 0
  def fib(1), do: 1
  def fib(n), do: fib(1, 1, n)
  def fib(last, _prev, 1), do: last
  def fib(last, prev, n), do: fib(last + prev, last, n - 1)
end

IO.inspect(Algs.fib(20) == 6765)
IO.inspect(Algs.fib(999_999))

IO.inspect(Algs.run("<<<...>>...>>><<>>.>>>") == 5)
IO.inspect(Algs.run("<<<..<......<<<<....>") == 1)
IO.inspect(Algs.run("<<<...>>...>>><<>>.>>>") == 5)
IO.inspect(Algs.run("<<<<<<..<<<<<.<>") == 1)
IO.inspect(Algs.run("<<<<<<>....<<<<<<") == 1)
IO.inspect(Algs.run(">>>>>>>>><.....") == 0)
IO.inspect(Algs.run(">>>>>>>>>>><><><><><....") == 4)
IO.inspect(Algs.run(">>>><<<<") == 0)
