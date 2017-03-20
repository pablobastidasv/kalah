#!/usr/bin/env bash
./gradlew build
docker image build -t pablobastidas/kalah .