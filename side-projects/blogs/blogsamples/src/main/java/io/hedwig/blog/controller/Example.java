package io.hedwig.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by patrick on 15/11/7.
 */
@RestController

public class Example {
    @RequestMapping("/")
    String home(){
        return "hello world!";
    }
}
