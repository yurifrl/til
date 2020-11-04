defmodule TcpTest do
  use ExUnit.Case

  @moduletag :capture_log
  @crlf "\r\n"
  @welcome "Enter your name: \r\n"
  @tag :integration

  setup do
    Application.stop(:chat)
    :ok = Application.start(:chat)
  end

  test "client can connect to the chat server" do
    assert {:ok, _socket} = connect()
  end

  test "client is prompted to enter nickname" do
    {:ok, socket} = connect()
    assert {:ok, @welcome} = recv_from_chat(socket)
  end

  test "client can respond with nickname and receive connected msg" do
    {:ok, socket} = connect()
    {:ok, @welcome} = recv_from_chat(socket)
    :ok = send_to_chat(socket, "yuri" <> @crlf)
    assert {:ok,  "Welcome, yuri.\r\n"} = recv_from_chat(socket)
  end

  @tag :skip
  test "client broadcasts message to all other users" do
    alphaSocket = joins_chat("alpha")
    benSocket = joins_chat("ben")

    recv_all_messages(benSocket)
    recv_all_messages(alphaSocket)

    send_to_chat(benSocket, "Hello!" <> @crlf)

    alphaSocket |> recv_from_chat() |> IO.inspect

    {:ok, line} = alphaSocket |> recv_from_chat()
    assert [_ts, "<ben>", "Hello!"] = String.split(line)
    {:ok, line} = benSocket |> recv_from_chat()
    assert [_ts, "<ben>", "Hello!"] = String.split(line)
  end

  defp recv_from_chat(socket, numLines \\ 1)
  defp recv_from_chat(socket, 1) do
    :gen_tcp.recv(socket, 0, 1000000)
  end
  defp recv_from_chat(socket, numLines) do
    recv_from_chat(socket)
    recv_from_chat(socket, numLines - 1)
  end

  defp send_to_chat(socket, text) do
    :gen_tcp.send(socket, text)
  end

  defp joins_chat(name) do
    {:ok, cs} = connect()
    {:ok, @welcome} = recv_from_chat(cs)
    :ok = send_to_chat(cs, name <> @crlf)
    cs
  end

  defp recv_all_messages(socket, msgs \\ []) do
    case recv_from_chat(socket) do
      {:ok, msg} -> recv_all_messages(socket, [msg | msgs])
      {:error, :timeout} -> msgs
    end
  end

  defp connect() do
    :gen_tcp.connect('127.0.0.1', 8080, [:binary, packet: :line, active: false])
  end
end
