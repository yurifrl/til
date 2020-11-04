defmodule DLogger.Application do
  # See https://hexdocs.pm/elixir/Application.html
  # for more information on OTP Applications
  @moduledoc false

  use Application

  def start(_type, _args) do
    children = [
      # Starts a worker by calling: DLogger.Worker.start_link(arg)
      # {DLogger.Worker, arg}
      {Plug.Cowboy, scheme: :http, plug: DLogger.Web, options: [port: 8080]}
    ]

    # See https://hexdocs.pm/elixir/Supervisor.html
    # for other strategies and supported options
    opts = [strategy: :one_for_one, name: DLogger.Supervisor]
    Supervisor.start_link(children, opts)
  end
end
