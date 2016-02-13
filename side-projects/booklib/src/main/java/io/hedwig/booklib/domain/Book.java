package io.hedwig.booklib.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by patrick on 15/11/11.
 */
@Entity
public class Book {
    public static final String STATUS_IDLE = "idle";
    public static final String STATUS_REQUEST = "request";
    public static final String STATUS_OUT = "out";
    @Id
    public Long id;
    public String bookId;
    public String title;
    public String url;
    public String status;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    public Account owner;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    public Date onboardDate;

    @ManyToOne
    @JoinColumn(name = "borrower_id")
    public Account borrower;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+08:00")
    public Date borrowDate;


}
