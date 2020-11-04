defmodule Chat.EventManager do
  use DynamicSupervisor

  @moduledoc """
  This is the pub-sub implementation, it handles message propagation
  """

  #
  # Public API
  #
  def start_link(init_arg \\ []), do: DynamicSupervisor.start_link(__MODULE__, init_arg)

  @impl true
  def init(_), do: DynamicSupervisor.init(strategy: :one_for_one)

  def add_handler(sup, handler, init_args \\ []), do: DynamicSupervisor.start_child(sup, handler_spec(handler, init_args))

  def publish(sup, payload), do: notify(sup, {:publish, payload})

  #
  # Private
  #
  defp handler_spec(handler_module, init_args) do
    %{
      id: GenServer,
      start: {GenServer, :start_link, [handler_module, init_args]},
      restart: :temporary,
      shutdown: 5000,
      type: :worker,
      modules: [GenServer]
    }
  end

  defp notify(sup, msg), do: notify_children(msg, DynamicSupervisor.which_children(sup))
  defp notify_children(_msg, []), do: :ok
  defp notify_children(msg, [{_id, child, _type, _modules} | rest]) do
    # Cast message to handler process
    GenServer.cast(child, msg)
    notify_children(msg, rest)
  end
end
