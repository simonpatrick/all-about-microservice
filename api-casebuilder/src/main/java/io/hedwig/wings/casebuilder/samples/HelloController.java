package io.hedwig.wings.casebuilder.samples;

import io.hedwig.wings.casebuilder.rest.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController extends BaseController {

    @Autowired
    private HelloWorldService service;
    private final AtomicLong counter = new AtomicLong();
    private static final String template = "Hello, %s!";


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return service.greeting();
    }


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public
    @ResponseBody
    String sayHello(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
        return counter.incrementAndGet() + String.format(template, name);
    }
}
