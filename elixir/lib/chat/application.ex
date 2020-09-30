defmodule Sandbox.Chat do
  use Application
  def start(_type, _args) do
    Sandbox.Chat.Supervisor.start_link
  end
end
