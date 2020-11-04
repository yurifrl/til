defmodule Web.TCP.Supervisor do
  use Supervisor

  @spec start_link :: :ignore | {:error, any} | {:ok, pid}
  def start_link(opts \\ []) do
    Supervisor.start_link(__MODULE__, :ok, opts ++ [name: __MODULE__])
  end

  @spec start_input(port) :: {:ok, pid}
  def start_input(socket) do
    {:ok, pid} = Task.Supervisor.start_child(Web.TCP.TaskSupervisor,
                                             Web.TCP.Connection, :login,
                                             [socket])
    :ok = :gen_tcp.controlling_process(socket, pid)
    {:ok, pid}
  end

  ## Server CB

  @impl true
  def init(:ok) do
    port = 8080
    children = [
      {Task.Supervisor, name: Web.TCP.TaskSupervisor},
      {Web.TCP.Listener, [port]}
    ]

    Supervisor.init(children, strategy: :one_for_one)
  end
end
