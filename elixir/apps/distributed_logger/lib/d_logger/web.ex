defmodule DLogger.Web do
  use Plug.Router

  plug(:match)
  plug(:dispatch)

  post "/event" do
    send_resp(conn, 200, "Welcome")
  end

  match _ do
    IO.inspect("")
    send_resp(conn, 404, "Oops!")
  end
end
