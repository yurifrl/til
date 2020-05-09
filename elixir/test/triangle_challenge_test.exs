defmodule TriangleChallengeTest do
  @moduledoc """
  Tests Triangle Computer Module
  """

  use ExUnit.Case, async: true
  doctest Triangle
  doctest Triangle.StreamAdapter
  doctest Polygon

  @doc """
  Test Triangles with streams finding posible triangles on pi
  """
  test "Triangles with streams" do
    sample =
      Triangle.StreamAdapter.read("./test/fixtures/pi.txt")
      |> Enum.take(5)

    assert sample === [
      {:ok, :scalene, {3, 1, 4}},
      {:ok, :scalene, {1, 5, 9}},
      {:ok, :scalene, {2, 6, 5}},
      {:ok, :scalene, {3, 5, 8}},
      {:ok, :isosceles, {9, 7, 9}}
    ]

    is_valid? = fn
      { :ok, _, _ } -> true
      { _, _, _ } -> false
    end
    valid_count =
      Triangle.StreamAdapter.read("./test/fixtures/pi.txt")
      |> Enum.take(5)
      |> Enum.count(is_valid?)

    assert valid_count === 5
  end

  @doc """
  Test Triangles with streams and a 'huge' chuck of data
  Imagine you want to count every equilateral triangle that apears in a video
  """
  test "Triangles with streams on steroids" do
    is_equilateral? = fn
      { :ok, :equilateral, _ } -> true
      { _, _, _ } -> false
    end
    equilateral_count =
      Triangle.StreamAdapter.read("./test/fixtures/largeW.txt")
      |> Enum.to_list
      |> Enum.count(is_equilateral?)

    assert equilateral_count === 18468
  end

  @doc """
  Test the happy path, in a way that esposes the api
  """
  test "Triangles" do
    assert Triangle.type(1,1,1) === { :ok, :equilateral }
    assert Triangle.type(1,1,2) === { :ok, :isosceles }
    assert Triangle.type(1,2,3) === { :ok, :scalene }
    assert Triangle.type(1,2,3.2) === { :ok, :scalene }
    assert Triangle.type(1.0,1.0,1.1) === { :ok, :isosceles }
    assert Triangle.type(1,2,0) === { :error, :invalid }
    assert Triangle.type(1,2,-1) === { :error, :invalid }
  end

  @doc """
  Test the happy path, in a way that esposes the api
  """
  test "Polygons" do
    assert Polygon.type([1, 1, 1]) === { :ok, :equilateral }
    assert Polygon.type([1, 1, 1, 1]) === { :ok, :equilateral }
    assert Polygon.type([1, 1, 1, 1, 1, 1, 1, 1, 1]) === { :ok, :equilateral }
    assert Polygon.type([1, 1, 2]) === { :ok, :isosceles }
    assert Polygon.type([1, 2, 3]) === { :ok, :scalene }
    assert Polygon.type([1, 2]) === { :error, :invalid }
    assert Polygon.type([1, 2, 3, 4]) === { :ok, :scalene }
    assert Polygon.type([1, 2, 3]) === { :ok, :scalene }
    assert Polygon.type([1, 2, 3]) === { :ok, :scalene }
    assert Polygon.type([1, 2, 0]) === { :error, :invalid }
    assert Polygon.type([6, 6, 8, 8]) === { :ok, :isosceles }
    assert Polygon.type([1, 1, 1, 1, 2]) === { :ok, :isosceles }
    assert Polygon.type([2, 1, 1, 1, 1]) === { :ok, :isosceles }
    assert Polygon.type([2, 1, 1, 1, 1]) === { :ok, :isosceles }
    assert Polygon.type([9, 8, 8, 8, 8, 8]) === { :ok, :isosceles }
    assert Polygon.type([9, 8, 8, 8]) === { :ok, :isosceles }
  end
end
