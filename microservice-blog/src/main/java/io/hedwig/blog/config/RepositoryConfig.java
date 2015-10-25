package io.hedwig.blog.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by patrick on 15/10/23.
 */

@Configuration
@EnableJpaRepositories(basePackages = "io.hedwig.blog.repository")
@EnableAutoConfiguration
@EntityScan(basePackages = "io.hedwig.blog.domain")
public class RepositoryConfig {
}
