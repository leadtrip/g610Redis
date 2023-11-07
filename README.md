## Grails 6.1.0 App using redis

Fire up redis with docker compose (included)

Add a random Person using spring data

http://localhost:8080/person/index

Inspect with CLI:

`redis-cli`

Find some keys:

`KEYS *Person*`
or
`keys *`

Take a key and get details:

All person detials:

`HGETALL Person:-899518921978865380`

Individual Person fields:

`HGET Person:-899518921978865380 name`

`HGET Person:-899518921978865380 age`

All bullfinchresponses details:

`HGETALL bullfinchresponses:694cefd1-db49-4fb3-8aed-3feb69f25427`

Individual bullfinchresponses fields:

`HGET bullfinchresponses:694cefd1-db49-4fb3-8aed-3feb69f25427 body`

`HGET bullfinchresponses:694cefd1-db49-4fb3-8aed-3feb69f25427 styles.[0]` 