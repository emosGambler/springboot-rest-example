package com.goraj.jacek.springbootsandbox.restexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingsController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greetings")
    public Greetings greeting(@RequestParam(value = "name", defaultValue = "NoName") String name) {
        return new Greetings(counter.incrementAndGet(), String.format(template, name));
    }
}
