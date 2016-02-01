package io.hedwig.samples.todo.repositories;

import io.hedwig.samples.todo.domain.ToDoItem;

import java.util.Collection;
import java.util.function.Predicate;

public interface TodoItemRepository {
	Collection<ToDoItem> findAll();

	ToDoItem insert(ToDoItem todoItem);

	ToDoItem delete(Long todoId);

	void update(ToDoItem todoItem);

	ToDoItem findOne(Long todoId);

	void remove(Predicate<ToDoItem> predicate);
}