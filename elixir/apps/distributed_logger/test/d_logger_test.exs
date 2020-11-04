defmodule DLoggerTest do
  use ExUnit.Case
  doctest DLogger

  test "greets the world" do
    assert DLogger.hello() == :world
  end
end
