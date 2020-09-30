defmodule Chat.Server do
  use GenServer
  @spec start_link :: :ignore | {:error, any} | {:ok, pid}
  def start_link do
    GenServer.start(__MODULE__, [], name: :chat_room)
  end

  def get_msgs do
    GenServer.call(:chat_room, :get_msgs)
  end
  def add_msg(msg) do
    GenServer.cast(:chat_room, {:add_msg, msg})
  end
  @spec init(any) :: {:ok, any}
  def init(msgs) do
    {:ok, msgs}
  end
  def handle_call(:get_msgs, _form, msgs) do
    {:reply, msgs, msgs}
  end
  def handle_cast({:add_msg, msg}, msgs) do
    {:noreply, [msg | msgs]}
  end
end
