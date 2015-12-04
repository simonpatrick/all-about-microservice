package io.hedwig.springsessions.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@ComponentScan(basePackages = "io.hedwig.springsessions")
public class WebConfig extends WebMvcConfigurerAdapter {

}