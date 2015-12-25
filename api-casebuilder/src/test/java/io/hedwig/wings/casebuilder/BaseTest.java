package io.hedwig.wings.casebuilder;

import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by patrick on 15/12/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CaseBuilderApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=9000")
public class BaseTest {
}
