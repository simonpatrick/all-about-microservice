package io.hedwig.satasamples.cassandra;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface SimpleUserRepository extends CrudRepository<User, Long> {}
