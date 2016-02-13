package io.hedwig.booklib.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by patrick on 15/11/11.
 */
public class BookDTO {
    @JsonIgnore
    public Long id;

    public String status;

//    @JsonProperty("bookId")
    public String bookId;

    public String title;

    public String url;

    public String image;

    /**
     * Here are more images for this book, such as large image, medium, small
     * image...
     */
    public BookImages images;

    public List<String> author;

    public String summary;

}
