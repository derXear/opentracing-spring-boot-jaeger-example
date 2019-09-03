# OpenTracing Spring Boot example with Jaeger

[![Build Status][travis-image]][travis-url]
[![Coverage Status][coveralls-image]][coveralls-url]

In this example we are running 2 services:
 * hello-service
 * greetings-service
 
Both are using [java-spring-jaeger](https://github.com/opentracing-contrib/java-spring-jaeger)
by including the following dependency
```
<dependency>
    <groupId>io.opentracing.contrib</groupId>
    <artifactId>opentracing-spring-jaeger-web-starter</artifactId>
    <version>1.0.3</version>
</dependency>
```

_Hello service_
will run on **port 8888** and exposes the enpoint **/hello**.
This endpoint returns the String "Hello from Service"

_Greetings service_
will run on **port 8080** and exposes the enpoint **/greetings/hello**.
When calling this endpoint, this service calls the _hello-service_ and returns the String received in the response.

When a request is processed, traces are sent to the Jaeger tool, where you get a detailed view of the process. 
You can access the Jaeger UI via the following link [http://localhost:16686/](http://localhost:16686/)


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

[travis-image]: https://travis-ci.org/derXear/opentracing-spring-boot-jaeger-example.svg?branch=master
[travis-url]: https://travis-ci.org/derXear/opentracing-spring-boot-jaeger-example
[coveralls-image]: https://coveralls.io/repos/github/derXear/opentracing-spring-boot-jaeger-example/badge.svg
[coveralls-url]: https://coveralls.io/github/derXear/opentracing-spring-boot-jaeger-example