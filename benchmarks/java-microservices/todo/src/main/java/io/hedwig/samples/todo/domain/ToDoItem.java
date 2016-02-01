package io.hedwig.samples.todo.domain;

/**
 * Created by patrick on 16/2/1.
 */
public class ToDoItem {

    private Long id;
    private String title;
    private String content;
    private boolean completed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void merge(ToDoItem item) {
        setTitle(item.getTitle());
        setCompleted(item.isCompleted());
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
