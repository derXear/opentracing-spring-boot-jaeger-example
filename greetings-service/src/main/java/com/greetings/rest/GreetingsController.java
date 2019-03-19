package com.greetings.rest;

import com.greetings.service.GreetingsService;
import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class GreetingsController {

    @Autowired
    private Tracer tracer;

    private final GreetingsService greetingsService;

    @Autowired
    public GreetingsController(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }

    @GetMapping("/hello")
    public String getHello() {
        Span span = tracer.buildSpan("GET /greetings/hello").start();

        String result = greetingsService.printHello();

        span.finish();
        return result;
    }

}
