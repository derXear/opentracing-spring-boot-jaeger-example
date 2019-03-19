package com.hello.rest;

import com.hello.service.HelloService;
import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/hello")
public class HelloController {

    @Autowired
    private Tracer tracer;

    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping
    public String getHello() {
        Span span = tracer.buildSpan("HelloController getHello").start();
        String result = helloService.printHello();
        span.finish();
        return result;
    }
}
