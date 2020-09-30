defmodule Triangle do
  @type type :: :equilateral | :isosceles | :scalene

  @spec type(number, number, number) :: { :ok, type } | { :error, :atom }

  @moduledoc """
  Documentation for Triangle Module.

  ## Examples
    iex> Triangle.type(1, 1, 1)
    { :ok, :equilateral }

    iex> Triangle.type(1, 1, 2)
    { :ok, :isosceles }

    iex> Triangle.type(1, 2, 3)
    { :ok, :scalene }

    iex> Triangle.type(1, 2, 0)
    { :error, :invalid }
  """

  @doc """
  No negative or zeroed sides.
  sidenote, i don't like this very much

  ## Examples
    iex> Triangle.type([0, 0, 0])
    { :error, :invalid }
  """
  def type(a, b, c) when a <= 0 or b <= 0 or c <= 0, do: { :error, :invalid }

  @doc """
  Equilateral, when all sides are equal

  ## Examples
    iex> Triangle.type(2, 2, 2)
    { :ok, :equilateral }
  """
  def type(a, a, a), do: { :ok, :equilateral }

  @doc """
  Isosceles, when x are equal

  ## Examples
    iex> Triangle.type(1, 1, 2)
    { :ok, :isosceles }
  """
  def type(a, a, _), do: { :ok, :isosceles }
  def type(a, _, a), do: { :ok, :isosceles }
  def type(_, a, a), do: { :ok, :isosceles }

  @doc """
  Scalene, when they are, all different

  ## Examples
    iex> Triangle.type(1, 2, 3)
    { :ok, :scalene }
  """
  def type(_, _, _), do: { :ok, :scalene }
end
