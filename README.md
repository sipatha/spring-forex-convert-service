Forex Convert Service
=

Get forex rates from openexchangerates.org

Creating Docker Image
-

`docker build --build-arg JAR_FILE=target/forex-convert-service-0.0.1-SNAPSHOT.jar --file=Dockerfile --tag=spring-demo/forex-convert-service:latest .`

Run Docker Image
-

`docker run --network=spring-demo -i -t -d spring-demo/forex-convert-service`

Accessing The Web Service
-

`curl http://localhost:9000/forex-convert-service/convert/100/USD/ZAR | json_pp`
 