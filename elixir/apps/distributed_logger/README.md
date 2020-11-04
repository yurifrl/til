# DLogger

**TODO: Add description**

## Installation

If [available in Hex](https://hex.pm/docs/publish), the package can be installed
by adding `distributed_logger` to your list of dependencies in `mix.exs`:

```elixir
def deps do
  [
    {:distributed_logger, "~> 0.1.0"}
  ]
end
```

Documentation can be generated with [ExDoc](https://github.com/elixir-lang/ex_doc)
and published on [HexDocs](https://hexdocs.pm). Once published, the docs can
be found at [https://hexdocs.pm/distributed_logger](https://hexdocs.pm/distributed_logger).


### Distributed Logging

Write a multi-node (via Distributed Elixir) system that accepts textual messages over HTTP, and logs them to disk, with a timestamp, on all the nodes. The nodes can all be run on your local machine, but they should use separate directories for file storage to demonstrate resilience.
Below is a suggested API usage case, with three nodes, listening on ports 5555,5556, and 5557, respectively. If you like, feel free to use docker, docker-compose, or another tool, to maintain the same input port on 3 different IPs.
$ curl -X POST http://127.0.0.1:5555/event --data “This is event 1”
$ curl -X POST http://127.0.0.1:5556/event --data “This is event 2”
$ curl -X POST http://127.0.0.1:5557/event --data “This is event 3”
$ cat ./nodes/node_1/data/events.log
1567770972000 This is event 1
1567770973345 This is event 2
1567770974821 This is event 3
$ cat ./nodes/node_2/data/events.log
1567770972000 This is event 1
1567770973345 This is event 2
1567770974821 This is event 3
$ cat ./nodes/node_3/data/events.log
1567770972000 This is event 1
1567770973345 This is event 2
1567770974821 This is event 3