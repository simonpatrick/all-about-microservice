package io.hedwig.wings.casebuilder;

import io.hedwig.wings.casebuilder.samples.config.HelloProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(HelloProperties.class)
public class CaseBuilderApplication {

    private static final Logger logger = LoggerFactory.getLogger(CaseBuilderApplication.class);
    
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(CaseBuilderApplication.class, args);
        logger.info(context.getApplicationName());
        logger.info("environment={}", context.getEnvironment());
        logger.info("bean factory:{}", context.getBeanFactory());
        String[] beans = context.getBeanDefinitionNames();
        for (String bean : beans) {
            logger.info("initializedBean_name={}",bean);
        }
        logger.info("End of Loading");
    }

}