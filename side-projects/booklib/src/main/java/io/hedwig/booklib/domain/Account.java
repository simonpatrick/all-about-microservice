package io.hedwig.booklib.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by patrick on 15/11/11.
 */
@Entity
public class Account {
    @Id
    public Long id;
    public String email;
    public String name;
    public String hashPassword;


}
