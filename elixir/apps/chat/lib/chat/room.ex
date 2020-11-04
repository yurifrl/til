defmodule Chat.Room do

  use GenServer

  defstruct name: "",
            event_manager: nil, # Chat.EventManager
            users: []           # [{pid, name, monitor}, ...]

  #
  # Client API
  #

  def start_link(data) do
    GenServer.start_link(__MODULE__, data)
  end

  def stop(room) do
    GenServer.stop(room, :normal)
  end

  def get(room) do
    GenServer.call(room, {:get})
  end

  def users(room) do
    GenServer.call(room, {:users})
  end

  def update(room, data) do
    GenServer.call(room, {:update, data})
  end

  def add_user(room, user) do
    GenServer.call(room, {:add_user, user})
  end

  def remove_user(room, user) do
    GenServer.call(room, {:remove_user, user})
  end

  def publish(room, msg, options \\ []) do
    GenServer.call(room, {:publish, msg, options})
  end

  def subscribe(room, handler, args) do
    GenServer.call(room, {:get_event_manager})
    |> Chat.EventManager.add_handler(handler, args)
  end

  def member?(room, user) do
    GenServer.call(room, {:member?, user})
  end

  #
  # Server callbacks
  #

  def init(data) do
    {:ok, event_manager} = Chat.EventManager.start_link()
    {:ok, put_in(data.event_manager, event_manager)}
  end

  def handle_call({:get}, _from, data) do
    {:reply, data, data}
  end

  def handle_call({:get_event_manager}, _from, data) do
    {:reply, data.event_manager, data}
  end

  def handle_call({:users}, _from, data) do
    {:reply, Enum.map(data.users, fn {u, _n, _m} -> u end), data}
  end

  def handle_call({:update, data}, _from, data) do
    {:reply, :ok, data}
  end

  def handle_call({:add_user, user}, _from, data) do
    if contains_user?(data, user) do
      {:reply, :already_added, data}
    else
      name = Chat.User.get(user).name
      mon = Process.monitor(user)
      {:reply, :ok, put_in(data.users, [{user, name, mon} | data.users])}
    end
  end

  def handle_call({:remove_user, user}, _from, data) do
    {removed, users} = Enum.split_with(data.users, fn {u, _n, _m} -> u == user end)
    Enum.each(removed, fn {_u, _n, m} -> Process.demonitor(m) end)
    {:reply, ok_unless_empty(removed), put_in(data.users, users)}
  end

  def handle_call({:publish, msg, _options}, _from, data) do
    Chat.EventManager.publish(data.event_manager, msg)
    {:reply, :ok, data}
  end

  def handle_call({:member?, user}, _from, data) do
    {:reply, contains_user?(data, user), data}
  end

  def handle_info({:DOWN, mon, :process, _pid, _reason}, data) do
    {removed, users} = Enum.split_with(data.users, fn {_u, _n, m} -> m == mon end)
    [{_user, name, _ref}] = removed
    Chat.EventManager.publish(data.event_manager, {:logout, name})
    {:noreply, put_in(data.users, users)}
  end

  def handle_info(_msg, data) do
    {:noreply, data}
  end

  defp contains_user?(data, user) do
    nil != Enum.find(data.users, fn {u, _n, _m} -> u == user end)
  end

  defp ok_unless_empty([]), do: :not_found
  defp ok_unless_empty(_),  do: :ok
end
