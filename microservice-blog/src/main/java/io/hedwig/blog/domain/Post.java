package io.hedwig.blog.domain;

import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.*;

/**
 * Created by patrick on 15/10/22.
 */
@Entity
@Table(name = "posts")
public class Post extends AbstractAuditable{

    private static final long serialVersionUID = 3238290567162096392L;
    @Id
    @GeneratedValue
    private Long postId;

    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private long categoryId;

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
