package io.hedwig.jpasamples.repository.server;

import io.hedwig.jpasamples.domain.server.ServerAdditionalAttribute;
import io.hedwig.jpasamples.domain.server.ServerAdditionalAttributeValue;
import io.hedwig.jpasamples.domain.server.ServerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by patrick on 16/1/15.
 */
public interface ServerAddlAttrValueRepository
        extends JpaRepository<ServerAdditionalAttributeValue,Long> {

    Optional<List<ServerAdditionalAttributeValue>>
    findServerInfoByServerInfoAndStatus(String serveInfoId,boolean status);

}
