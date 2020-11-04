defmodule Chat.User do

  use GenServer

  defstruct name: "",
            rooms: []  # [{pid, name, monitor}, ...]

  #
  # Client API
  #

  def start_link(data) do
    GenServer.start_link(__MODULE__, data)
  end

  def stop(user) do
    GenServer.stop(user, :normal)
  end

  def get(user) do
    GenServer.call(user, {:get})
  end

  def rooms(user) do
    GenServer.call(user, {:rooms})
  end

  def update(user, data) do
    GenServer.call(user, {:update, data})
  end

  def add_room(user, room) do
    GenServer.call(user, {:add_room, room})
  end

  def remove_room(user, room) do
    GenServer.call(user, {:remove_room, room})
  end

  #
  # Server callbacks
  #

  def init(data) do
    {:ok, data}
  end

  def handle_call({:get}, _from, data) do
    {:reply, data, data}
  end

  def handle_call({:rooms}, _from, data) do
    {:reply, Enum.map(data.rooms, fn {c, _n, _m} -> c end), data}
  end

  def handle_call({:update, data}, _from, _data) do
    {:reply, :ok, data}
  end

  def handle_call({:add_room, room}, _from, data) do
    if contains_room?(data, room) do
      {:reply, :already_added, data}
    else
      name = Chat.Room.get(room).name
      mon = Process.monitor(room)
      {:reply, :ok, put_in(data.rooms, [{room, name, mon} | data.rooms])}
    end
  end

  def handle_call({:remove_room, room}, _from, data) do
    {removed, rooms} = Enum.split_with(data.rooms, fn {c, _n, _m} -> c == room end)
    Enum.each(removed, fn {_c, _n, m} -> Process.demonitor(m) end)
    {:reply, ok_unless_empty(removed), put_in(data.rooms, rooms)}
  end

  def handle_info({:DOWN, mon, :process, _pid, _reason}, data) do
    {removed, rooms} = Enum.split_with(data.rooms, fn {_c, _n, m} -> m == mon end)
    [{_c, _name, _m}] = removed
    # TODO: Notify the user that the room disappeared.
    {:noreply, put_in(data.rooms, rooms)}
  end

  def handle_info(_msg, data) do
    {:noreply, data}
  end

  defp contains_room?(data, room) do
    nil != Enum.find(data.rooms, fn {c, _n, _m} -> c == room end)
  end

  defp ok_unless_empty([]), do: :not_found
  defp ok_unless_empty(_),  do: :ok
end
