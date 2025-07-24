package br.com.paulosantos.controller;

import br.com.paulosantos.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private final AtomicLong counter = new AtomicLong();

    private static String template = "Hello, %s!";

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(name = "name", value = "name",defaultValue = "") String name) {
        return new Greeting(counter.getAndIncrement(),String.format(template, name));
    }

}
