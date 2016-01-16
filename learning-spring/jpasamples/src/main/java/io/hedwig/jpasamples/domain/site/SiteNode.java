package io.hedwig.jpasamples.domain.site;

import io.hedwig.jpasamples.domain.AbstractAuditingEntity;

import javax.persistence.*;

/**
 * Created by patrick on 16/1/15.
 */
@Entity
@Table(name = "site_node")
public class SiteNode extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "site_id")
    private long siteId;
    @Column(name = "site_node_comments")
    private String siteNodeComments;
    @Column(name = "site_node_ip")
    private String siteNodeIP;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSiteId() {
        return siteId;
    }

    public void setSiteId(long siteId) {
        this.siteId = siteId;
    }

    public String getSiteNodeIP() {
        return siteNodeIP;
    }

    public void setSiteNodeIP(String siteNodeIP) {
        this.siteNodeIP = siteNodeIP;
    }

    public String getSiteNodeComments() {
        return siteNodeComments;
    }

    public void setSiteNodeComments(String siteNodeComments) {
        this.siteNodeComments = siteNodeComments;
    }

}
