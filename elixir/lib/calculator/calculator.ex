defmodule Calculator do
  def start do
    spawn(fn -> loop(0) end)
  end

  defp loop(current_value) do
    new_value = receive do
      {:value, client_id} -> send(client_id, {:response, current_value})
        current_value
      {:add, value} -> current_value + value
      {:sub, value} -> current_value - value
      {:mult, value} -> current_value * value
      {:div, value} -> current_value / value

      invalid_request -> IO.puts("Invalid #{invalid_request}")
    end

    loop(new_value)
  end

  def value(server_id) do
    send(server_id, {:value, self()})
    receive do
      {:response, value} -> value
    end
  end

  def operation(server_id, name, value) do
    send(server_id, {name, value})
    value(server_id)
  end
end
