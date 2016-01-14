package io.hedwig.satasamples.cassandra;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cassandra.config.java.AbstractCqlTemplateConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.datastax.driver.core.Session;

@Configuration
@EnableAutoConfiguration
class SimpleConfiguration {

	@Configuration
	@EnableCassandraRepositories
	static class CassandraConfig extends AbstractCqlTemplateConfiguration {

		@Override
		public String getKeyspaceName() {
			return "example";
		}
		
		@Bean
		public CassandraTemplate cassandraTemplate(Session session) {
			return new CassandraTemplate(session);
		}
	}
}
