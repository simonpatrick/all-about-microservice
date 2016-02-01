package io.hedwig.samples.todo.repositories;

import io.hedwig.samples.todo.ToDoApplication;
import io.hedwig.samples.todo.domain.ToDoItem;
import io.hedwig.samples.todo.exceptions.ToDoItemNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.Collection;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by patrick on 16/2/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ToDoApplication.class)

public class ToDoInMemoryRepositoryTest {

    @Autowired
    private ToDoInMemoryRepository repository ;

    @Test
    public void testFindAll_insert() throws Exception {
       ToDoItem item = new ToDoItem();
       this.repository.insert(item);
       Collection<ToDoItem> result =  repository.findAll();
       assertThat(result.size(), is(1));
        result.clear();
    }

    @Test()
    public void testDelete() throws Exception {
        ToDoItem item = new ToDoItem();
        this.repository.insert(item);
        this.repository.delete(item.getId());
    }

    @Test
    public void testUpdate() throws Exception {
        ToDoItem item = new ToDoItem();
        this.repository.insert(item);
        item.setContent("test_again");
        this.repository.update(item);
        assertThat(this.repository.findOne(item.getId()).getContent()
                ,is("test_again"));
    }


    @Test
    public void testRemove() throws Exception {
        ToDoItem item = new ToDoItem();
        this.repository.insert(item);
        this.repository.remove(toDoItem -> toDoItem.isCompleted());
        assertThat(this.repository.findOne(item.getId()), is(item));
    }
}