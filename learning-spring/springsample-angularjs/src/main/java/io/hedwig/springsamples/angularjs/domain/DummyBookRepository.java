package io.hedwig.springsamples.angularjs.domain;

import io.hedwig.springsamples.angularjs.repositories.BookRepository;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A very noddy implementation of the {@see BookRepository} interface.
 */
@Component
class DummyBookRepository implements BookRepository {
  private final Map<Integer, Book> books = new ConcurrentHashMap<Integer, Book>();

  @Override
  public Book findById(Integer id) {
    return this.books.get(id);
  }

  @Override
  public List<Book> findAll() {
    List<Book> books = new ArrayList<>(this.books.values());
    Collections.sort(books, (o1, o2) -> o1.getId() - o2.getId());
    return books;
  }

  @Override
  public Book save(Book book) {
    if (book.getId() == null) {
      book.setId(nextId());
    }
    this.books.put(book.getId(), book);
    return book;
  }

  @Override
  public void delete(Integer id) {
    this.books.remove(id);
  }

  private Integer nextId() {
    if (this.books.isEmpty()) {
      return 1;
    } else {
      return Collections.max(this.books.keySet()) + 1;
    }
  }
}
