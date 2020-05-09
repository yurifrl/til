# https://rosettacode.org/wiki/Category:Elixir
defmodule RC do
  def nth_root(n, x, precision \\ 1.0e-5) do
    f = fn(prev) -> ((n - 1) * prev + x / Math.pow(prev, (n-1))) / n end
    fixed_point(f, x, precision, f.(x))
  end

  defp fixed_point(_, guess, tolerance, next) when abs(guess - next) < tolerance, do: next
  defp fixed_point(f, _, tolerance, next), do: fixed_point(f, next, tolerance, f.(next))
end

defmodule Math do
  def pow(_, 0), do: 1
  def pow(x, n) when rem(n, 2) != 0, do: x * pow(x, n - 1)
  def pow(x, n) do
    result = pow(x, div(n, 2))
    result * result
  end
end

ExUnit.start()

defmodule IntegerRootsTest do
  use ExUnit.Case

  test "Square Root" do
    assert RC.nth_root(2, 1) == 1
    assert RC.nth_root(2, 144) == 12
    assert RC.nth_root(2, 169) == 13
    assert RC.nth_root(2, 5) == 2.236067977499978
  end
end
