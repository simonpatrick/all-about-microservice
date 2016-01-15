package io.hedwig.jpasamples.domain.site;

import io.hedwig.jpasamples.domain.AbstractAuditingEntity;

import javax.persistence.*;

/**
 * Created by patrick on 16/1/15.
 */
@Entity
@Table(name="site")
public class Site extends AbstractAuditingEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "site_name")
    private String siteName;
    @Column(name = "site_domain_name")
    private String siteDomainName;
    @Column(name = "status")
    private String status;
    @Column(name = "site_comments")
    private String siteComments;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteDomainName() {
        return siteDomainName;
    }

    public void setSiteDomainName(String siteDomainName) {
        this.siteDomainName = siteDomainName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSiteComments() {
        return siteComments;
    }

    public void setSiteComments(String siteComments) {
        this.siteComments = siteComments;
    }
}
