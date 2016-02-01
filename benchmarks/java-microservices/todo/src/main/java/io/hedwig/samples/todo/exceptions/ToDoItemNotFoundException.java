package io.hedwig.samples.todo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ToDoItemNotFoundException extends RuntimeException {
	private final Long id;

	public ToDoItemNotFoundException(Long id) {
		super("TodoItem [id=" + id + "] not found");
		this.id = id;
	}

	public Long getId() {
		return id;
	}
}