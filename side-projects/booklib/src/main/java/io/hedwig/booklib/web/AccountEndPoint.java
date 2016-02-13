package io.hedwig.booklib.web;

import com.google.common.hash.Hashing;
import io.hedwig.booklib.domain.Account;
import io.hedwig.booklib.repository.AccountDao;
import io.hedwig.booklib.service.account.AccountService;
import io.hedwig.booklib.web.support.RestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.nio.charset.Charset;

/**
 * Created by patrick on 15/11/11.
 */

@RestController
public class AccountEndPoint {
    private static Logger logger = LoggerFactory.getLogger(AccountEndPoint.class);

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/rest/accounts/login")
    public void login(@RequestParam("email") String email,
                      @RequestParam("password") String password,
                      HttpSession session) {

        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
            throw new RestException("User or password empty", HttpStatus.BAD_REQUEST);
        }

        Account account = accountService.findByEmail(email);

        if (account == null) {
            throw new RestException("User not exist", HttpStatus.UNAUTHORIZED);
        }

        if (!account.hashPassword.equals(hashPassword(password))) {
            throw new RestException("Password wrong", HttpStatus.UNAUTHORIZED);
        }

        session.setAttribute("account", account);
    }

    @RequestMapping(value = "/rest/accounts/register")
    public void register(@RequestParam("email") String email, @RequestParam("name") String name,
                         @RequestParam("password") String password) {

        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            throw new RestException("User or name or password empty", HttpStatus.BAD_REQUEST);
        }

        Account account = new Account();
        account.email = email;
        account.name = name;
        account.hashPassword = hashPassword(password);
        accountService.save(account);
    }

    public static String hashPassword(String password) {
        return Hashing.sha1().hashString(password, Charset.forName("UTF-8")).toString();
    }
}
