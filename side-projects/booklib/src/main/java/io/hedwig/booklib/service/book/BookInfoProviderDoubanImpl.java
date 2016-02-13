package io.hedwig.booklib.service.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.internal.Nullable;
import io.hedwig.booklib.dto.BookDTO;
import org.apache.http.client.fluent.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by patrick on 15/11/11.
 */
public class BookInfoProviderDoubanImpl {

    private static final String DOUBAN_URL = "https://api.douban.com/v2/book/%s?fields=id,title,url,image,images,author,summary";

    private static Logger logger = LoggerFactory.getLogger(BookInfoProviderDoubanImpl.class);

    private static ObjectMapper jsonMapper = new ObjectMapper();

    @Nullable
    public BookDTO findBookInfo(String doubanBookId) {
        String doubanQueryRequestUrl = String.format(DOUBAN_URL, doubanBookId);
        try {
            String bookInfoJsonString = Request.
                    Get(doubanQueryRequestUrl).execute().returnContent().asString();
            return jsonMapper.readValue(bookInfoJsonString, BookDTO.class);
        } catch (IOException e) {
            logger.error("Failed to retrieve book info from douban for bookId: " + doubanBookId + ".", e);
        }

        return null;
    }
}
