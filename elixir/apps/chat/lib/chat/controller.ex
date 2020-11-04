defmodule Chat.Controller do
  @moduledoc """
  Controller is the middleware that joins User and Room
  """
  use GenServer

  @name __MODULE__

  #
  # Client API
  #

  def start_link(opts \\ []) do
    GenServer.start_link(__MODULE__, :ok, opts ++ [name: @name])
  end

  @doc """
  Dispatches the creation of a new user
  """
  def new_user(name) do
    GenServer.call(@name, {:new_user, name})
  end

  @doc """
  Dispatches the creation of a new room
  """
  def new_room(name) do
    GenServer.call(@name, {:new_room, name})
  end

  @doc """
  Given a use and room it will add them together, can be called with the name or the pid
  """
  def join_room(user, room) do
    GenServer.call(@name, {:join_room, user, room})
  end

  @doc """
  Remove a user for the registry
  """
  def leave_room(user, room) do
    GenServer.call(@name, {:leave_room, user, room})
  end

  def say_room(user, room, msg) do
    GenServer.call(@name, {:say_room, user, room, msg})
  end

  #
  # Server callbacks
  #

  def init(:ok) do
    {:ok, %{ id_counter: 0 }}
  end

  def handle_call({:new_user, name}, _from, state) do
    case Chat.Registry.whereis_name({:user, name}) do
      :undefined ->
        {:ok, pid} = DynamicSupervisor.start_child(Chat.UserDynamicSupervisor, {Chat.User, %Chat.User{name: name}})
        Chat.Registry.register_name({:user, name}, pid)
        {:reply, {:ok, pid}, state}
      pid ->
        {:reply, {:already_created, pid}, state}
    end
  end

  def handle_call({:new_room, name}, _from, state) do
    case Chat.Registry.whereis_name({:room, name}) do
      :undefined ->
        {:reply, create_room(name), state}
      pid ->
        {:reply, {:already_created, pid}, state}
    end
  end

  def handle_call({:generate_id}, _from, state) do
    id = state.id_counter + 1
    {:reply, {self(), id}, put_in(state.id_counter, id)}
  end

  def handle_call({:join_room, user, room}, _from, state) do
    resolve_and_do(user, room, state,
                   &do_join_room/4, nil,
                   [create_room: true])
  end

  def handle_call({:leave_room, user, room}, _from, state) do
    resolve_and_do(user, room, state,
                   &do_leave_room/4, nil)
  end

  def handle_call({:say_room, user, room, msg}, _from, state) do
    resolve_and_do(user, room, state,
                   &do_say_room/4, msg)
  end

  ## Private funcitons

  defp resolve_and_do(user, room, state, fun, args, opts \\ []) do
    with {:ok, user}    <- resolve_user(user),
         {:ok, room} <- resolve_room(room, opts) do
      fun.(user, room, args, state)
    else
      error -> {:reply, error, state}
    end
  end

  defp resolve_user(user) when is_pid(user) do
    {:ok, user}
  end

  defp resolve_user(user) do
    case Chat.Registry.whereis_name({:user, user}) do
      :undefined -> :user_not_found
      user       -> {:ok, user}
    end
  end

  defp resolve_room(room, _opts) when is_pid(room) do
    {:ok, room}
  end

  defp resolve_room(name, opts) do
    room = Chat.Registry.whereis_name({:room, name})
    create? = Keyword.get(opts, :create_room)
    case {room, create?} do
      {:undefined, true} -> create_room(name)
      {:undefined, _}    -> :room_not_found
      {room, _}       -> {:ok, room}
    end
  end

  defp create_room(name) do
    {:ok, room} = DynamicSupervisor.start_child(Chat.RoomDynamicSupervisor ,{Chat.Room, %Chat.Room{name: name}})
    Chat.Registry.register_name({:room, name}, room)
    {:ok, room}
  end

  defp do_join_room(user, room, _args, state) do
    if Chat.Room.member?(room, user) do
      {:reply, {:already_joined, user, room}, state}
    else
      Chat.User.add_room(user, room)
      Chat.Room.add_user(room, user)
      Chat.Room.publish(room, {:join, user})
      {:reply, {:ok, user, room}, state}
    end
  end

  defp do_leave_room(user, room, _args, state) do
    if Chat.Room.member?(room, user) do
      Chat.Room.publish(room, {:leave, user})
      Chat.User.remove_room(user, room)
      Chat.Room.remove_user(room, user)
      {:reply, {:ok, user, room}, state}
    else
      {:reply, {:not_joined, user, room}, state}
    end
  end

  defp do_say_room(user, room, msg, state) do
    if Chat.Room.member?(room, user) do
      Chat.Room.publish(room, {:say, user, msg})
      {:reply, {:ok, user, room}, state}
    else
      {:reply, {:not_joined, user, room}, state}
    end
  end
end
