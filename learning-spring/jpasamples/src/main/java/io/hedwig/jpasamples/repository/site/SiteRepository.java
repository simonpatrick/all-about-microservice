package io.hedwig.jpasamples.repository.site;

import io.hedwig.jpasamples.domain.server.ServerAdditionalAttribute;
import io.hedwig.jpasamples.domain.site.Site;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by patrick on 16/1/15.
 */
public interface SiteRepository extends JpaRepository<Site,Long> {

    Optional<List<Site>> findSiteInfoByIdAndStatus(Long id,boolean status);
}
