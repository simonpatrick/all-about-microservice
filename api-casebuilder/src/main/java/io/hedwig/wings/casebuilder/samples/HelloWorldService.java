package io.hedwig.wings.casebuilder.samples;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    @Value("${app.version}")
    private String version;

    public String greeting(){
        return "hello"+version;
    }
}
