
package io.hedwig.satasamples.cassandra;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


import com.sun.tools.javac.util.AbstractDiagnosticFormatter;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AbstractDiagnosticFormatter.SimpleConfiguration.class)
public class SimpleUserRepositoryTest {

//    @Autowired
//    private SimpleUserRepository repository;
    User user;

    @Before
    public void setUp() {

        user = new User();
        user.setId(42L);
        user.setUsername("foobar");
        user.setFirstname("firstname");
        user.setLastname("lastname");
    }

    @Test
    public void findSavedUserById() {

//        user = repository.save(user);
//
//        assertThat(repository.findOne(user.getId()), is(user));
    }
}