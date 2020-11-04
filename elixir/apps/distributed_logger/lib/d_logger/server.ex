defmodule DLogger.Server do
  use GenServer

  def start_link(opts) do
    GenServer.start(__MODULE__, opts)
  end

  def init(state) do
    {:ok, state}
  end
end
