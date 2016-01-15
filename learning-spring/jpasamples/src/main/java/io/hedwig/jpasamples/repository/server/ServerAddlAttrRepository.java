package io.hedwig.jpasamples.repository.server;

import io.hedwig.jpasamples.domain.server.ServerAdditionalAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by patrick on 16/1/15.
 */
public interface ServerAddlAttrRepository extends JpaRepository<ServerAdditionalAttribute,Long> {
}
