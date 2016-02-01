package io.hedwig.samples.todo;

import com.alibaba.fastjson.JSON;
import io.hedwig.samples.todo.domain.ToDoItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by patrick on 16/2/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ToDoApplication.class)
@WebAppConfiguration
public class ToDoApplicationTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        this.mockMvc= MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void testHome() throws Exception {
        this.mockMvc.perform(get("/todo")).andExpect(status().isOk());
    }

    @Test
    public void should_return_404_when_item_not_found() throws Exception {
        this.mockMvc.perform(delete("todo/1")).andExpect(status().isNotFound());
    }

    @Test
    public void should_add_todo_item() throws Exception {
        ToDoItem item = new ToDoItem();
        item.setCompleted(true);
        item.setTitle("this is test");
        item.setContent("test");;
        MvcResult result =this.mockMvc.perform(post("/todo")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(JSON.toJSONString(item)))
                .andExpect(status().isOk())
                .andReturn();
        //todo ignore field for json/database collection compared with json
        ToDoItem actualToDoItem = JSON.parseObject(result.getResponse().getContentAsString(),ToDoItem.class);
        assertThat(item).isEqualToIgnoringGivenFields(actualToDoItem,"id");
    }
}