defmodule Chat.Supervisor do
  # Automatically defines child_spec/1
  use Supervisor

  def start_link(opts \\ []) do
    Supervisor.start_link(__MODULE__, opts, name: __MODULE__)
  end

  @impl true
  def init(_init_arg) do
    children = [
      {Chat.Controller, []},
      {Chat.EventManager, []},
      {Chat.Registry, []},
      {DynamicSupervisor, strategy: :one_for_one, name: Chat.RoomDynamicSupervisor},
      {DynamicSupervisor, strategy: :one_for_one, name: Chat.UserDynamicSupervisor},
    ]

    Supervisor.init(children, strategy: :one_for_one)
  end
end
