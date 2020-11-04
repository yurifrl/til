defmodule Chat.Registry do
  use GenServer

  @reg_name __MODULE__

  #
  # Client API
  #

  def start do
    GenServer.start(__MODULE__, :ok, [name: @reg_name])
  end

  def start_link(opts \\ []) do
    GenServer.start_link(__MODULE__, :ok, opts ++ [name: @reg_name])
  end

  def whereis_name(name) do
    GenServer.call(@reg_name, {:whereis, name})
  end

  def register_name(name, pid) when not is_pid(name) and is_pid(pid) do
    GenServer.call(@reg_name, {:register, name, pid})
  end

  def unregister_name(name) do
    GenServer.call(@reg_name, {:unregister, name})
  end

  #
  # Server callbacks
  #
  def init(:ok) do
    {:ok, %{ processes: %{}, monitors:  %{} }}
  end

  def handle_call({:whereis, name}, _from, state) do
    case Map.get(state.processes, name) do
      {pid, _mon} -> {:reply, pid, state}
      nil         -> {:reply, :undefined, state}
    end
  end

  def handle_call({:register, name, pid}, _from, state) do
    if Map.has_key?(state.processes, name) do
      {:reply, :no, state}
    else
      mon = Process.monitor(pid)
      state = put_in(state.processes, Map.put(state.processes, name, {pid, mon}))
      state = put_in(state.monitors, Map.put(state.monitors, mon, name))
      {:reply, :yes, state}
    end
  end

  def handle_call({:unregister, name}, _from, state) do
    case Map.get(state.processes, name) do
      nil ->
        {:reply, :ok, state}
      {_pid, mon} ->
        Process.demonitor(mon)
        state = put_in(state.processes, Map.delete(state.processes, name))
        state = put_in(state.monitors, Map.delete(state.monitors, mon))
        {:reply, :ok, state}
    end
  end

  def handle_info({:DOWN, mon, :process, pid, _reason}, state) do
    {name, monitors} = Map.pop(state.monitors, mon)
    {{^pid, ^mon}, processes} = Map.pop(state.processes, name)
    state = put_in(state.processes, processes)
    state = put_in(state.monitors, monitors)
    {:noreply, state}
  end

  def handle_info(_msg, state) do
    {:noreply, state}
  end
end
