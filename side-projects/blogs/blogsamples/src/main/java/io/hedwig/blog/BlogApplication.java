package io.hedwig.blog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by patrick on 15/10/17.
 */
@SpringBootApplication
public class BlogApplication {
    private static Logger logger = LoggerFactory.getLogger(BlogApplication.class);

    @Bean
    protected ServletContextListener listener(){
        return  new ServletContextListener() {
            @Override
            public void contextInitialized(ServletContextEvent servletContextEvent) {
                logger.info("ServletContext initialized");
            }

            @Override
            public void contextDestroyed(ServletContextEvent servletContextEvent) {
                logger.info("ServletContext destroyed");
            }
        };
    }

    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(
                BlogApplication.class);
        application.setApplicationContextClass(AnnotationConfigApplicationContext.class);
        SpringApplication.run(BlogApplication.class, args);
    }

}
