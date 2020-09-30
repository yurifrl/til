defmodule Sandbox.Chat.Supervisor do
  use Supervisor

  def start_link do
    Supervisor.start_link(__MODULE__, [])
  end
  def init(_) do
    children = [
      worker(Sandbox.Chat.Server, [], restart: :temporary)
    ]

    Supervisor.init(children, strategy: :one_for_one)
  end
end
