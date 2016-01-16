package io.hedwig.jpasamples.repository.site;

import io.hedwig.jpasamples.domain.site.SiteNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Created by patrick on 16/1/15.
 */
public interface SiteNodeRepository extends JpaRepository<SiteNode,Long> {

    Optional<List<SiteNode>> findSiteNodesBySiteIdAndStatus(@Param("siteId")Long siteId,
                                                            @Param("status")boolean status);
}
