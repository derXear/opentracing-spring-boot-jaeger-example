# OpenTracing Spring Boot example with Jaeger

## THE EXAMPLE
In this example we are running 2 services:
 * hello-service
 * greetings-service
 
Both are using [java-spring-web](https://github.com/opentracing-contrib/java-spring-web)
by including the following dependency
```
<dependency>
  <groupId>io.opentracing.contrib</groupId>
  <artifactId>opentracing-spring-web-starter</artifactId>
</dependency>
```

_Hello service_
will run on **port 8888** and exposes the enpoint **/hello**.
This endpoint returns the String "Hello from Service"

_Greetings service_
will run on **port 8080** and exposes the enpoint **/greetings/hello**.
When calling this endpoint, this service calls the _hello-service_ and returns the String received in the response.

When a request is process, traces are sent to Jaeger tool where you will get a detailed view of the operation. 
You can access at [http://localhost:16686/](http://localhost:16686/)


## Build/run the example
Example can be run with docker-compose.
**Build**:
```
docker-compose build
```

**Run**:
```
docker-compose up
```

**Call endpoint**: [http://localhost:8080/greetings/hello](http://localhost:8080/greetings/hello)

and you will see the traces by accessing to Jaeger at [http://localhost:16686/](http://localhost:16686/)

## Not working

For whatever reason, you will not see the dependencies graph in Jaeger UI.