package io.hedwig.jpasamples.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by patrick on 16/1/15.
 */
@Configuration
@EnableJpaRepositories(basePackages = "io.hedwig.jpasamples.repository")
@EnableAutoConfiguration
@EnableTransactionManagement
@EntityScan(basePackages = {"io.hedwig.jpasamples.domain"})
public class RepositoryConfig {
}
