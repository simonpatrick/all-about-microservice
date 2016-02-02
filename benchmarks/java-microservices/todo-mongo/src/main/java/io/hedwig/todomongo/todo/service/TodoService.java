package io.hedwig.todomongo.todo.service;

import io.hedwig.todomongo.todo.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    /**
     * Creates a new todo entry.
     * @param todo  The information of the created todo entry.
     * @return      The information of the created todo entry.
     */
    TodoDTO create(TodoDTO todo);

    TodoDTO delete(String id);

    /**
     * Finds all todo entries.
     * @return      The information of all todo entries.
     */
    List<TodoDTO> findAll();

    TodoDTO findById(String id);

    TodoDTO update(TodoDTO todo);
}
