package io.hedwig.samples.todo.repositories;

import io.hedwig.samples.todo.domain.ToDoItem;
import io.hedwig.samples.todo.exceptions.ToDoItemNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;

/**
 * Created by patrick on 16/2/1.
 */

@Repository
public class ToDoInMemoryRepository implements TodoItemRepository {
    private AtomicLong counter = new AtomicLong(0);
    private Map<Long, ToDoItem> toDoItems = new ConcurrentHashMap<>();

    @Override
    public Collection<ToDoItem> findAll() {
        return toDoItems.values();
    }

    @Override
    public ToDoItem insert(ToDoItem todoItem) {
        Long id = counter.incrementAndGet();
        todoItem.setId(id);
        toDoItems.put(id, todoItem);
        return todoItem;
    }

    @Override
    public ToDoItem delete(Long todoId) {
        checkIfExist(todoId);
        ToDoItem deletedItem = toDoItems.remove(todoId);
        deletedItem.setCompleted(true);
        return deletedItem;

    }

    private void checkIfExist(Long todoId) {
        if (!toDoItems.containsKey(todoId)) {
            throw new ToDoItemNotFoundException(todoId);
        }
    }

    @Override
    public void update(ToDoItem todoItem) {
        checkIfExist(todoItem.getId());
        toDoItems.put(todoItem.getId(), todoItem);
    }

    @Override
    public ToDoItem findOne(Long todoId) {
        checkIfExist(todoId);
        return toDoItems.get(todoId);
    }

    @Override
    public void remove(Predicate<ToDoItem> predicate) {
        toDoItems.forEach((k, v) -> {
            if (predicate.test(v)) {
                toDoItems.remove(v);
            }
        });
    }
}
