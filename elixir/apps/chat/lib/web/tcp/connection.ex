defmodule Web.TCP.Connection do

  @room_name "chat_room"

  #
  # Public Api
  #
  def login(socket) do
    write(socket, "Enter your name: " <> "\r\n")
    with {:ok, line} <- read_line(socket),
         {:ok, name} <- process_name(line),
         {:ok, user} <- create_user(socket, name)
    do
      process_input(socket, user)
    else
      {:try_again, reason} ->
        write_line(socket, "Invalid login. " <> reason)
        login(socket)
      _ ->
        exit(:shutdown)
    end
  end

  #
  # Server CB
  #
  def init(state) do
    {:ok, state}
  end

  def handle_cast({:publish, data}, {socket, user, room} = state) do
    process_msg(socket, room, user, data)
    {:noreply, state}
  end

  #
  # Private
  #
  defp process_name(line) do
    name = String.trim(line)
    len  = String.length(name)
    cond do
      len < 4 ->
        {:try_again, "Too short."}
      len > 20 ->
        {:try_again, "Too long."}
      String.match?(name, ~r/[^a-zA-Z]/) ->
        {:try_again, "Contains invalid characters."}
      true ->
        {:ok, name}
    end
  end

  defp create_user(socket, name) do
    case Chat.Controller.new_user(name) do
      {:ok, user} ->
        Process.link(user) # TODO: Possible race condition
        write_line(socket, "Welcome, #{name}.")
        join_room(socket, user, @room_name)
        {:ok, user}
      {:already_created, _user} ->
        {:try_again, "Already logged in."}
    end
  end

  defp join_room(socket, user, room) do
    {:ok, ^user, room} = Chat.Controller.join_room(user, room)
    Chat.Room.subscribe(room, Web.TCP.Connection, {socket, user, room})
  end

  defp process_input(socket, user) do
    case read_line(socket) do
      {:ok, msg} ->
        Chat.Controller.say_room(user, @room_name, String.trim(msg))
        process_input(socket, user)
      _ ->
        exit(:shutdown)
    end
  end

  defp process_msg(socket, room, _user, {:say, speaker, msg}) do
    cdata = Chat.Room.get(room)
    sdata = Chat.User.get(speaker)
    write_line(socket, "[#{cdata.name}] #{sdata.name}: #{msg}")
  end

  defp process_msg(socket, room, _user, {:join, speaker}) do
    cdata = Chat.Room.get(room)
    sdata = Chat.User.get(speaker)
    write_line(socket, "[#{cdata.name}] #{sdata.name} just joined the room.")
  end

  defp process_msg(socket, room, _user, {:leave, speaker}) do
    cdata = Chat.Room.get(room)
    sdata = Chat.User.get(speaker)
    write_line(socket, "[#{cdata.name}] #{sdata.name} just left the room.")
  end

  defp process_msg(socket, room, _user, {:logout, uname}) do
    cdata = Chat.Room.get(room)
    write_line(socket, "[#{cdata.name}] #{uname} disconnected.")
  end

  defp process_msg(_socket, _room, _user, _msg) do
    # Ignore unhandled messages
  end

  defp write(socket, msg) do
    :gen_tcp.send(socket, msg)
  end

  defp write_line(socket, msg) do
    :gen_tcp.send(socket, msg <> "\r\n")
  end

  defp read_line(socket) do
    :gen_tcp.recv(socket, 0)
  end
end
