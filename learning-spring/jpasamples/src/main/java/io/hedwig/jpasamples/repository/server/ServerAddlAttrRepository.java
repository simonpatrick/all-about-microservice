package io.hedwig.jpasamples.repository.server;

import io.hedwig.jpasamples.domain.server.ServerAdditionalAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Created by patrick on 16/1/15.
 */
public interface ServerAddlAttrRepository extends JpaRepository<ServerAdditionalAttribute,Long> {

    Optional<List<ServerAdditionalAttribute>>
        findServerAddlAttrValuesByServerIdAndStatus(Long serverInfoId,boolean status);

}
