#!/usr/bin/env bash
# docker ps -a -q --filter="name=forex-convert-service"
mvn clean install
docker build --build-arg JAR_FILE=target/forex-convert-service-0.0.1-SNAPSHOT.jar --file=Dockerfile --tag=spring-demo/forex-convert-service:latest .
docker rmi $(docker images -f 'dangling=true' -q)
# docker run --network=spring-demo -i -t  -d spring-demo/forex-convert-service
