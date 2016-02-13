package io.hedwig.booklib.service.book;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import io.hedwig.booklib.dto.BookDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by patrick on 15/11/11.
 */
@Component
public class BookInfoProviderProxy {
    private static Logger logger = LoggerFactory
            .getLogger(BookInfoProviderProxy.class);

    @Autowired
    private BookInfoProviderDoubanImpl doubanBookService;

    private LoadingCache<String,BookDTO> bookInfoCache;

    @PostConstruct
    public void init(){
        bookInfoCache = CacheBuilder.newBuilder().initialCapacity(50)
                .maximumSize(1000).expireAfterWrite(7, TimeUnit.DAYS)
                .build(new CacheLoader<String, BookDTO>() {
                    @Override
                    public BookDTO load(String bookId) throws Exception {
                        return doubanBookService.findBookInfo(bookId);
                    }
                });
    }

    public BookDTO findBookInfo(String bookId){
        try {
            return bookInfoCache.get(bookId);
        } catch (ExecutionException e) {
            logger.error("failed to get book info for bookId : {}.",bookId);
            throw new RuntimeException("Failed to get book Info for "+bookId);
        }
    }
}
