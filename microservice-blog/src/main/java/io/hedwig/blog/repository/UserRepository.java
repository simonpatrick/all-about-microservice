package io.hedwig.blog.repository;

import io.hedwig.blog.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by patrick on 15/10/23.
 */

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

}
