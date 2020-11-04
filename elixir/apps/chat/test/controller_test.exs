defmodule Chat.ControllerTest do
  use ExUnit.Case, async: false

  alias Chat.Controller, as: Controller

  @moduletag :capture_log
  @tag :sync

  setup do
    Application.stop(:chat)
    :ok = Application.start(:chat)
  end

  test "user creation" do
    {:ok, bob}   = Controller.new_user("bob")
    {:ok, alice} = Controller.new_user("alice")

    assert Chat.User.get(bob).name   == "bob"
    assert Chat.User.get(alice).name == "alice"

    assert Chat.Registry.whereis_name({:user, "bob"})   == bob
    assert Chat.Registry.whereis_name({:user, "alice"}) == alice

    assert Controller.new_user("bob")   == {:already_created, bob}
    assert Controller.new_user("alice") == {:already_created, alice}
  end

  test "room joins and leaves" do
    {:ok, bob}   = Controller.new_user("bob")
    {:ok, alice} = Controller.new_user("alice")

    {:ok, ^bob, admin}    = Controller.join_room(bob, "admin")
    {:ok, ^alice, ^admin} = Controller.join_room(alice, "admin")

    ^admin  = Chat.Registry.whereis_name({:room, "admin"})
    "admin" = Chat.Room.get(admin).name

    true = Chat.Room.member?(admin, bob)
    true = Chat.Room.member?(admin, alice)

    {:already_joined, ^bob, ^admin}   = Controller.join_room("bob", "admin")
    {:already_joined, ^alice, ^admin} = Controller.join_room("alice", "admin")
    {:already_joined, ^bob, ^admin}   = Controller.join_room("bob", admin)
    {:already_joined, ^alice, ^admin} = Controller.join_room("alice", admin)
    {:already_joined, ^bob, ^admin}   = Controller.join_room(bob, "admin")
    {:already_joined, ^alice, ^admin} = Controller.join_room(alice, "admin")
    {:already_joined, ^bob, ^admin}   = Controller.join_room(bob, admin)
    {:already_joined, ^alice, ^admin} = Controller.join_room(alice, admin)

    :user_not_found    = Controller.join_room("eve", "admin")
    :user_not_found    = Controller.leave_room("eve", "admin")
    :room_not_found = Controller.leave_room("alice", "missing")

    {:ok, ^bob, ^admin} = Controller.leave_room("bob", "admin")
    false = Chat.Room.member?(admin, bob)
    true = Chat.Room.member?(admin, alice)

    {:not_joined, ^bob, ^admin} = Controller.leave_room("bob", "admin")

    {:ok, ^alice, ^admin} = Controller.leave_room("alice", "admin")
    false = Chat.Room.member?(admin, bob)
    false = Chat.Room.member?(admin, alice)
  end
end
