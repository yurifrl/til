defmodule Chat.Test.RoomSubscribeTest do
  use ExUnit.Case, async: false

  alias Chat.Room, as: Room
  alias Chat.Controller, as: Controller

  @tag :sync
  @room :room

  defmodule EventForwarder do
    def init(state), do: {:ok, state}
    def handle_cast({:publish, msg}, pid) do
      send(pid, msg)
      {:noreply, pid}
    end
  end

  setup do
    Application.stop(:chat)
    :ok = Application.start(:chat)
  end

  test "pubsub" do
    {:ok, bob}   = Controller.new_user("bob")
    {:ok, alice} = Controller.new_user("alice")

    {:ok, ^bob, admin}    = Controller.join_room(bob, @room)
    {:ok, ^alice, ^admin} = Controller.join_room(alice, @room)

    pid = self()
    {:ok, _} = Room.subscribe(admin, EventForwarder, pid)

    Room.publish(admin, :msg1)
    assert_receive :msg1

    Room.publish(admin, :msg2)
    assert_receive :msg2

    Room.publish(admin, {:msg3, "test"})
    assert_receive {:msg3, "test"}
  end
end
