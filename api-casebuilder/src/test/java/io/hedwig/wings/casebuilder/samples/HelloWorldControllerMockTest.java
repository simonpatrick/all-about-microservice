package io.hedwig.wings.casebuilder.samples;

import io.hedwig.wings.casebuilder.BaseTest;
import io.hedwig.wings.casebuilder.CaseBuilderApplication;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringApplicationConfiguration(classes= {CaseBuilderApplication.class,MockServletContext.class})
public class HelloWorldControllerMockTest extends BaseTest{

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception{
        mockMvc= MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void testHelloWorld() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello")
        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect((ResultMatcher) content().string(equalTo("hello1.0")));
    }


}