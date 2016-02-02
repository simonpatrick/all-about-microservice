package io.hedwig.todomongo;

import io.hedwig.todomongo.todo.domain.Todo;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * @author Petri Kainulainen
 */
class TodoBuilder {

    private String description;
    private String id;
    private String title = "NOT_IMPORTANT";

    public TodoBuilder() {

    }

    public TodoBuilder description(String description) {
        this.description = description;
        return this;
    }

   public TodoBuilder id(String id) {
        this.id = id;
        return this;
    }

    TodoBuilder title(String title) {
        this.title = title;
        return this;
    }

    Todo build() {
        Todo todo = Todo.getBuilder()
                .title(title)
                .description(description)
                .build();

        ReflectionTestUtils.setField(todo, "id", id);

        return todo;
    }
}
