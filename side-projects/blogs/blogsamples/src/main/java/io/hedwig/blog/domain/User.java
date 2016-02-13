package io.hedwig.blog.domain;

import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.*;

/**
 * Created by patrick on 15/10/23.
 */
@Entity
@Table(name="users")
public class User extends AbstractAuditable<User,Long> {
    private static final long serialVersionUID = 5147518120482550787L;

    @Id
    @GeneratedValue
    private Long userId;

    @Column(nullable = false)
    private String userName;

    @Column
    private String userNickName;

    @Column(nullable = false)
    private String password;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
