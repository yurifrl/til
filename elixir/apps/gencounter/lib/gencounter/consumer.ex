defmodule Gencounter.Consumer do
  def start_link do
    GenStage.start_link(__MODULE__, :state)
  end
  def init(state) do
    {:consumer, state, subscribe_to: [Gencounter.ProducerConsumer]}
  end
  def handle_events(events, _from, state) do
    for event <- events do
      IO.inspect {self(), event, state}
    end
    # events |> Enum.map(&IO.inspect(self(), &1, state))
    {:noreply, [], state}
  end
end
