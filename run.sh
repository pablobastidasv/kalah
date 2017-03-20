#!/usr/bin/env bash
./build.sh
docker container run --rm -ti -p 8080:8080 -p 9990:9990 pablobastidas/kalah