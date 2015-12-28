package io.hedwig.wings.casebuilder.samples;

import io.hedwig.wings.casebuilder.rest.BaseController;
import io.hedwig.wings.casebuilder.samples.domain.Speaker;
import io.hedwig.wings.casebuilder.samples.service.HelloService;
import io.hedwig.wings.casebuilder.samples.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController extends BaseController {

    @Autowired
    private HelloWorldService service;
    @Autowired
    private HelloService helloService;

    @Autowired
    private SpeakerService speakerService;

    private final AtomicLong counter = new AtomicLong();
    private static final String template = "Hello, %s!";


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return service.greeting();
    }

    @RequestMapping(value = "/newhello", method = RequestMethod.GET)
    @ResponseBody
    public String newHello() throws Exception {
        helloService.run("testing hello");
        return "{test:test,teset2:test2}";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name) {
        return counter.incrementAndGet() + String.format(template, name);
    }

    @RequestMapping(value = "/speaker/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Speaker getSpeaker(@PathVariable(value="id") long id) throws Exception {
       return speakerService.getSpeakerRepository().findOne(id);
    }


    @RequestMapping(value = "/speaker", method = RequestMethod.GET)
    @ResponseBody
    public List<Speaker> getSpeakers() throws Exception {
        return (List<Speaker>) speakerService.getSpeakerRepository().findAll();
    }

}
