defmodule Chat.User.Test do
  use ExUnit.Case, async: true

  alias Chat.User, as: User

  setup do
    {:ok, user} = User.start_link(%User{name: "foo"})
    {:ok, %{user: user}}
  end

  test "user data", %{user: user} do
    assert User.get(user) == %User{name: "foo"}
  end

  test "user rooms", %{user: user} do
    {:ok, ch1} = Chat.Room.start_link(%Chat.Room{name: "ch1"})
    {:ok, ch2} = Chat.Room.start_link(%Chat.Room{name: "ch2"})

    assert User.rooms(user) == []

    :ok = User.add_room(user, ch1)
    assert User.rooms(user) == [ch1]

    :already_added = User.add_room(user, ch1)
    assert User.rooms(user) == [ch1]

    :ok = User.add_room(user, ch2)
    assert User.rooms(user) == [ch2, ch1]

    :ok = User.remove_room(user, ch1)
    assert User.rooms(user) == [ch2]

    :not_found = User.remove_room(user, ch1)
    assert User.rooms(user) == [ch2]

    :ok = User.remove_room(user, ch2)
    assert User.rooms(user) == []

    :ok = User.add_room(user, ch2)
    :ok = User.add_room(user, ch1)
    assert User.rooms(user) == [ch1, ch2]
    Agent.stop(ch1)
    assert User.rooms(user) == [ch2]
    Agent.stop(ch2)
    assert User.rooms(user) == []
  end
end
