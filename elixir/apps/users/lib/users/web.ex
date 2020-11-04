defmodule Users.Web do
  use Plug.Router

  plug(:match)
  plug(:dispatch)

  post "/hello" do
    {:ok, data, _conn} = read_body(conn)

    case Users.Unique.claim(data) do
      :ok ->
        send_resp(conn, 200, "ok")

      {:error, _} ->
        send_resp(conn, 400, "ono")
    end
  end

  match _ do
    send_resp(conn, 404, "oops")
  end
end
