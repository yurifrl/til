FROM elixir:alpine
ARG MIX_ENV=prod
COPY lib ./lib
COPY mix.exs .
# COPY mix.lock .
RUN mix local.rebar --force \
    && mix local.hex --force \
    && mix deps.get \
    && mix release

RUN apk add --no-cache --update bash openssl

ENTRYPOINT ["_build/prod/rel/chat/bin/chat"]
CMD ["start"]