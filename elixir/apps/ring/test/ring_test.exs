defmodule RingTest do
  use ExUnit.Case
  doctest Ring

  test "1" do
    pids = Ring.create_processes(5)
    assert Ring.link_processes(pids) == :ok
    pids |> Enum.map(fn pid -> Process.info(pid, :links) |> IO.inspect() end)
  end

  test "2" do
    [p1, p2, p3] = Ring.create_processes(3)
    [p1, p2, p3] |> Ring.link_processes()

    send(p1, :trap_exit)
    send(p2, :trap_exit)

    Process.exit(p2, :kill)
    assert [true, false, false] === [p1, p2, p3] |> Enum.map(&Process.alive?(&1))
  end
end
