package io.hedwig.booklib.repository;

import io.hedwig.booklib.domain.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by patrick on 15/11/11.
 */
public interface AccountDao extends CrudRepository<Account,Long> {
    Account findByEmail(String email);
}
