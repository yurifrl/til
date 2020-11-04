defmodule ThySupervisorTest do
  use ExUnit.Case
  doctest ThySupervisor

  test "greets the world" do
    opts = []
    ThySupervisor.start_link(opts)
  end
end
