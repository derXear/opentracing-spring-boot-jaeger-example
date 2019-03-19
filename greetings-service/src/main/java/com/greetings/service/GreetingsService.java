package com.greetings.service;

import io.opentracing.Span;
import io.opentracing.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GreetingsService {
    private static final Logger LOG = LoggerFactory.getLogger(GreetingsService.class);
    private final String helloServiceHost;

    @Autowired
    private Tracer tracer;

    @Autowired
    public GreetingsService(@Value("${service.helloHost}") String helloServiceHost) {
        this.helloServiceHost = helloServiceHost;
    }

    public String printHello() {
        LOG.info("printHello");
        Span span = tracer.buildSpan("GreetingsService printHello").start();
        String result;
        String url = "http://" + helloServiceHost + ":8888/hello";

        RestTemplate template = new RestTemplate();
        result = template.getForObject(url, String.class);

        span.finish();
        return result;
    }
}
