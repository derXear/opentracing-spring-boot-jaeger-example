package com.hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    private static final Logger LOG = LoggerFactory.getLogger(HelloService.class);

    public String printHello() {
        String helloStr = "Hello from Service";
        LOG.info("Printing hello");
        return helloStr;
    }
}
