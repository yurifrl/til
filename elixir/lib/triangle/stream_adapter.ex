defmodule Triangle.StreamAdapter do
  @type read :: :stream

  @moduledoc """
  Creates a stream that will read a file and apply the `Triangle.type/1` to every
  3 number group and Return the computed result as stream
  """

  @doc """
  Creates a stream that will read a file and apply the `Triangle.type/1` to every
  3 number group and Return the computed result as stream

  ##Example
    Triangle.StreamAdapter.read("./test/test.data")
    #=> :stream
  """
  @spec read(String.t) :: :stream | { :error, String.t }
  def read(file) do
    file
    |> File.stream!([], 2048)
    |> Stream.map(&read_chunk/1)
    |> Stream.flat_map(&List.flatten/1)
  end

  @doc """
  Process a string, breaking it in chunks of 3 and giving it's types

  ##Example
    iex> Triangle.StreamAdapter.read_chunk("314")
    [{:ok, :scalene, {3, 1, 4}}]
  """
  @spec read_chunk(String.t) :: list | { :error, Strint.t }
  def read_chunk(string) do
    string
    |> String.graphemes
    |> Enum.filter_map(&is_numeric/1, &String.to_integer/1)
    |> Enum.chunk(3)
    |> Enum.map(&read_array/1)
  end

  def is_numeric(str) do
    case Float.parse(str) do
      {_num, ""} -> true
      _          -> false
    end
  end

  defp read_array([a, b, c]), do: Tuple.append Triangle.type(a, b, c), {a, b, c}
end
