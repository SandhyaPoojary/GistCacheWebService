package meredith;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template =  "Hello, %s";
    private final AtomicLong count = new AtomicLong();


    @RequestMapping("/greetings")
    public Greetings greeting(@RequestParam(value = "name", defaultValue = "World") String name){

        return new Greetings(count.incrementAndGet(), String.format(template, name));
    }
}

