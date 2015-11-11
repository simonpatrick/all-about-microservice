package io.hedwig.booklib.service.book;

import com.google.common.collect.Lists;
import io.hedwig.booklib.domain.Book;
import io.hedwig.booklib.dto.BookDTO;
import io.hedwig.booklib.repository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by patrick on 15/11/11.
 */
@Component
public class BookService {

    @Autowired
    private BookInfoProviderProxy bookInfoProviderProxy;

    @Autowired
    private BookDao bookDao;

    public List<BookDTO> findAll(){
        List<BookDTO> bookDTOList= Lists.newArrayList();
        Iterable<Book> books = bookDao.findAll();
        for (Book book : books) {
            bookDTOList.add(getBookDtoByBookId(book.bookId));
        }
        return bookDTOList;
    }
    private BookDTO getBookDtoByBookId(String bookId){
        return bookInfoProviderProxy.findBookInfo(bookId);
    }
}
