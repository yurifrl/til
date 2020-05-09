defmodule Polygon do
  @type type :: :equilateral | :isosceles | :scalene

  @moduledoc """
  Provides a function `type/1` to type a polygon
  """

  @doc """
  A less then 3 sided polygon is a invalid polygon

  ## Examples
    iex> Polygon.type([2, 2])
    { :error, :invalid }
  """
  def type(a) when length(a) < 3, do: { :error, :invalid }

  @doc """
  Returns the type of a n sided polygon.
  ## Examples
    iex> Polygon.type([1, 1, 1])
    { :ok, :equilateral }

    iex> Polygon.type([1, 1, 2])
    { :ok, :isosceles }

    iex> Polygon.type([1, 2, 3])
    { :ok, :scalene }

    iex> Polygon.type([1, 2, 0])
    { :error, :invalid }
  """
  @spec type(list(pos_integer())) :: { :ok, type } | { :error, :atom }
  def type(ngon), do: type(ngon, [])

  @docp """
  If for some reason the user pass a accumulator
  """
  defp type(a, []) when length(a) < 3, do: { :error, :invalid }

  @docp """
  """
  defp type(_, [{:error, _ }]), do: { :error, :invalid }

  @docp """
    Stop condition
    Pipe Triangles to the Triangle Module
    I let it run til it finds a invalid list
  ## Examples
    iex> Polygon.type([1, 1, 1])
    { :ok, :equilateral }
  """
  defp type([_, _], [{:ok, result}]), do: { :ok, result }

  @docp """
  """
  defp type([_, _], [{:ok, :equilateral}, {:ok, :equilateral}]), do: { :ok, :equilateral }

  @docp """
  """
  defp type([_, _], [{:ok, :scalene}, {:ok, :scalene}]), do: { :ok, :scalene }

  @docp """
  """
  defp type([_, _], [_, _]), do: { :ok, :isosceles }


  @docp """
  Restart the proccess with the accumulators
  """
  defp type([_, _], n), do: type(n)

  @docp """
  The loop condition
  Remember the last thing should be a call to other function, or we loose
  Tail Call Optimisation

  You can form triangles from a n sided polygon
  So we split it in haf, end type the triangle
  Not i haf, i extract a triangle out of it

  Initialize the accumulator

  ## Examples
    iex> Polygon.type([9, 8, 8, 8, 8, 8])
    { :ok, :isosceles }
    iex> Polygon.type([1, 2, 3, 4])
    { :ok, :scalene }
  """
  defp type([ head | tail ], accumulator) do
    [b, c] = Enum.take(tail, 2)
    type(tail, [ Triangle.type(head, b, c) | accumulator ])
  end
end
