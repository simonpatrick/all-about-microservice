package io.hedwig.samples.todo.controllers;

import io.hedwig.samples.todo.domain.ToDoItem;
import io.hedwig.samples.todo.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by patrick on 16/2/1.
 */
@RestController
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    private TodoItemRepository todoItemRepository;

    @RequestMapping(method= RequestMethod.GET)
    public Collection<ToDoItem> toDoItems(){
        return todoItemRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Collection<ToDoItem> deleteCompleted() {
        todoItemRepository.remove(ToDoItem::isCompleted);
        return todoItemRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST
            ,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
            ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ToDoItem> insert(@RequestBody ToDoItem todoItem) {
        ToDoItem savedTodoItem = todoItemRepository.insert(todoItem);
        return new ResponseEntity<>(savedTodoItem, HttpStatus.OK);
    }

    @RequestMapping(value = "/{todoId}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long todoId) {
      ToDoItem deletedToDoItem= todoItemRepository.delete(todoId);
      return new ResponseEntity<>(deletedToDoItem,HttpStatus.OK);
    }

    @RequestMapping(value = "/{todoId}", method = RequestMethod.PUT)
    public void put(@PathVariable Long todoId, @RequestBody ToDoItem item) {
        ToDoItem todoItem = todoItemRepository.findOne(todoId);
        todoItem.merge(item);
        todoItemRepository.update(todoItem);
    }
}
