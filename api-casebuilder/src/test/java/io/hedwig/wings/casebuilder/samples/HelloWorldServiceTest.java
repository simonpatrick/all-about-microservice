package io.hedwig.wings.casebuilder.samples;

import io.hedwig.wings.casebuilder.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by patrick on 15/12/25.
 */
public class HelloWorldServiceTest extends BaseTest{

    @Autowired
    private HelloWorldService service;

    @Test
    public void testGreeting() throws Exception {
        assertThat(service.greeting()).isEqualTo("hello1.0");
    }
}