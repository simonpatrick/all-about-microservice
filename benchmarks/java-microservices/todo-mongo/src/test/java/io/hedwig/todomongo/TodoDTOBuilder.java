package io.hedwig.todomongo;

import io.hedwig.todomongo.todo.dto.TodoDTO;

/**
 * @author Petri Kainulainen
 */
class TodoDTOBuilder {

    private String description;
    private String id;
    private String title;

    public TodoDTOBuilder() {

    }

    TodoDTOBuilder description(String description) {
        this.description = description;
        return this;
    }

    TodoDTOBuilder id(String id) {
        this.id = id;
        return this;
    }

    TodoDTOBuilder title(String title) {
        this.title = title;
        return this;
    }

    TodoDTO build() {
        TodoDTO dto = new TodoDTO();

        dto.setDescription(description);
        dto.setId(id);
        dto.setTitle(title);

        return dto;
    }
}
