package br.com.frsiqueira.requestidtest.controller;

import br.com.frsiqueira.requestidtest.dto.Greeting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping
public class HelloWorldController {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello-world")
    @ResponseBody
    public Greeting sayHello(@RequestParam(name = "name", required = false, defaultValue = "Stranger") String name) {
        logger.info("Entrou aqui 1");
        logger.info("Entrou aqui 2");

        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
