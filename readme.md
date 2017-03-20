# KALAH

## How to run it

The application use docker to work, the next script create a docker
image and run it.

```bash
./run.sh
```

If you just want to create the image use.

```bash
./build.sh
```

## How to use it

To use the application exists 3 main endpoint

 1. Create a new Kalah and take de id `POST: $HOST:$PORT/kalah`
 2. Run a turn `POST: $HOST:$PORT/kalah/{id}?pit=#`.
 3. Get the match status `GET: $HOST:$PORT/kalah/{id}`.
 

