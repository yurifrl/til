# TriangleChallenge

A program that determine the type of a triangle.

It takes the lengths of the triangle's three sides as input,
and return whether the triangle is equilateral, isosceles or scalene.

## Installation

The package can be installed by adding `triangle_challenge` to your list of
dependencies in `mix.exs`:

```elixir
def deps do
  [{:triangle_challenge, "~> 0.1.0"}]
end

```
The docs can be found at [https://hexdocs.pm/triangle_challenge](https://hexdocs.pm/triangle_challenge).

## Testing
```
docker-compose run --rm web mix test
```

OR

```
mix test
```

My workflow

```
docker-compose run --rm web mix test --listen-on-stdin --cover
docker-compose run --rm web iex -S mix
```

## Reflections
Short excerpts of the work process

### Reflection on design Decisions.
First thing, i isolated this component from any framework, i believe that's essential,
Communicate with well defined limits is very important for reuse, readability, extensibility etc

I lost some time trying to create a solution that would give meaning to large polygons
but it could use more research on the typing of polygons, although i'm happy with the
way the idea was conceived

When creating this component the api was very straightforward after i wrote the tests
and i did in a way one can easily introduce new rules

### Structural Considerations.
I built this in elixir because i imagined that this component could be used to process
huge chunks of data, and elixir is good for parallelism and it uses very well
the computer resources

Elixir is not the fastest but it's native mechanisms to handle multiple process
at time are very satisfying, one thing i imagine this application being used on, was
in a cell phone network, where you could want to triangulate calls, and things of
that nature

I added a case in the tests, were i imagined a constant flow of inputs from pictures,
distances between things in a picture, and this component could find polygonal patterns
for example

### Readability of code and error cases.
I did not put the amount of work i would like in error handling, but the api is
designed in a way that it's pieces are very isolated, and very easy to test, i managed
100% coverage without trying

I really appreciate the way elixir makes comments first class citizens, so i used
them to give api examples, and document usage

### Showcase problem solving skills.
I have to say that i failed in trying to make a module to type huge polygons,
but it was not taking anywhere and was a kind of extra so i decided to tackle it later

I tried to document my thought process in the HISTORY.md, but that file became
huge, so i changed approach and did this instead, But i believe a handled this task
very well, i might have overthought it sometimes, but it is a functional first work
