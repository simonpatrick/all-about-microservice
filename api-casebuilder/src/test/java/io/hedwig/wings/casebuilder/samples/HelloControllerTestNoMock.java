package io.hedwig.wings.casebuilder.samples;

import io.hedwig.wings.casebuilder.BaseTest;
import io.hedwig.wings.casebuilder.CaseBuilderApplication;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by patrick on 15/12/25.
 */
@SpringApplicationConfiguration(classes = CaseBuilderApplication.class)
public class HelloControllerTestNoMock extends BaseTest {

    @Value("${local.server.port}")
    private int port;

    private URL baseHello;
    private URL baseTest;
    private RestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.baseHello = new URL("http://localhost:" + port + "/hello");
        this.baseTest= new URL("http://localhost:" + port + "/test");
        template = new TestRestTemplate();
    }


    @Test
    public void testSay() throws Exception {
        ResponseEntity<String> response = template.getForEntity(baseHello.toString(), String.class);
        assertThat(response.getBody()).isEqualTo("hello1.0");
    }

    @Test
    public void testSayHello() throws Exception {
        ResponseEntity<String> response = template.getForEntity(baseTest.toString(), String.class);
        assertThat(response.getBody()).isEqualTo("1Hello, Stranger!");

    }
}