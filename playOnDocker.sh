#!/bin/bash
docker run --rm -ti \
 -v $(pwd):/opt/app \
 -w /opt/app \
 -e TERM=xterm \
 -v $HOME/.m2:/root/.m2 \
 -p 8080:8080 \
 maven mvn spring-boot:run
