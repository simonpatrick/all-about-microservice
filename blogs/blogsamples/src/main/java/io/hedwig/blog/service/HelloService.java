package io.hedwig.blog.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by patrick on 15/10/21.
 */
@Component
public class HelloService {

    @Value("${name: World}")
    private String name;

    public String getMessage(){
        return "Hello "+this.name;
    }
}
