package io.hedwig.todomongo.todo.exception;

public class TodoNotFoundException extends RuntimeException {

    public TodoNotFoundException(String id) {
        super(String.format("No todo entry found with id: <%s>", id));
    }
}
