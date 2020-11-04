defmodule RoomTest do
  use ExUnit.Case, async: true

  alias Chat.Room, as: Room
  alias Chat.User, as: User

  setup do
    {:ok, room} = Room.start_link(%Room{name: "test-room"})
    {:ok, %{room: room}}
  end

  test "room data", %{room: room} do
    assert Room.get(room).name == "test-room"
  end

  test "room users", %{room: room} do
    {:ok, foo} = User.start_link(%User{name: "foo"})
    {:ok, bar} = User.start_link(%User{name: "bar"})

    assert Room.users(room) == []

    :ok = Room.add_user(room, foo)
    assert Room.users(room) == [foo]

    :already_added = Room.add_user(room, foo)
    assert Room.users(room) == [foo]

    :ok = Room.add_user(room, bar)
    assert Room.users(room) == [bar, foo]

    :ok = Room.remove_user(room, foo)
    assert Room.users(room) == [bar]

    :not_found = Room.remove_user(room, foo)
    assert Room.users(room) == [bar]

    :ok = Room.remove_user(room, bar)
    assert Room.users(room) == []

    :ok = Room.add_user(room, bar)
    :ok = Room.add_user(room, foo)

    assert Room.users(room) == [foo, bar]
    Agent.stop(foo)
    assert Room.users(room) == [bar]
    Agent.stop(bar)
    assert Room.users(room) == []
  end
end
