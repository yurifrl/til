defmodule Chat.Application do
  use Application
  def start(_type, _args) do
    Chat.Supervisor.start_link
  end
end
