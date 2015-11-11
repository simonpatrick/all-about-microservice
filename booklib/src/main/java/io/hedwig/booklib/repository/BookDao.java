package io.hedwig.booklib.repository;

import io.hedwig.booklib.domain.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by patrick on 15/11/11.
 */
public interface BookDao extends PagingAndSortingRepository<Book,Long> {
    public List<Book> findByOwnerId(Long ownerId);
    public List<Book> findByBorrowerId(Long borrowerId);
}
