package io.hedwig.booklib.service.account;

import io.hedwig.booklib.domain.Account;
import io.hedwig.booklib.repository.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by patrick on 15/11/11.
 */
@Component
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    public Account findByEmail(String email){
        return accountDao.findByEmail(email);
    }

    public Account save(Account account){
        return accountDao.save(account);
    }
}
