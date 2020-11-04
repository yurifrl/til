defmodule Web.TCP.Listener do
  use Task

  def start_link(opts \\ []) do
    Task.start_link(__MODULE__, :listen, opts)
  end

  def listen(port) do
    opts = [:binary, packet: :line, active: false, reuseaddr: true]
    {:ok, socket} = :gen_tcp.listen(port, opts)
    accept_loop(socket)
  end

  defp accept_loop(listen_socket) do
    {:ok, socket} = :gen_tcp.accept(listen_socket)

    {:ok, _pid} = Web.TCP.Supervisor.start_input(socket)
    accept_loop(listen_socket)
  end
end
