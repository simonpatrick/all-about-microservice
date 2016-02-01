package io.hedwig.benchmarks.singlefile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by patrick on 16/2/1.
 */
@SpringBootApplication
@RestController
public class HelloWorldEndPoint {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldEndPoint.class,args);
    }

    public static class StartupRunner implements CommandLineRunner{
        protected final Logger logger = LoggerFactory.getLogger(StartupRunner.class);

        @Override
        public void run(String... strings) throws Exception {
            logger.info("startup command is running ........");
        }
    }
    //inject into spring start lifecycle
    @Bean
    @Order(value = 1)
    public StartupRunner runner(){
        return new StartupRunner();
    }

    @Bean
    @Order(value = 2)
    public StartupRunner runner2(){
        return new StartupRunner(){

            @Override
            public void run(String... strings) throws Exception {
                System.out.println("start up 2 command is running......");
            }
        };
    }

    @RequestMapping("/")
    @ResponseBody
    public String home(){
        return "hello world!";
    }

}
