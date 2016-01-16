package io.hedwig.jpasamples;

import io.hedwig.jpasamples.config.RepositoryConfig;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by patrick on 16/1/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RepositoryConfig.class)
public class BaseDBTest {
}
