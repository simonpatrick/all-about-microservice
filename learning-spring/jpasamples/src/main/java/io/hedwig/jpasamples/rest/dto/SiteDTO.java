package io.hedwig.jpasamples.rest.dto;

import javax.persistence.Column;

/**
 * Created by patrick on 16/1/16.
 */
public class SiteDTO {
    private long id;
    private String siteName;
    private String siteDomainName;
    private String siteComments;
    private String status;

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

    public String getSiteComments() {
        return siteComments;
    }

    public void setSiteComments(String siteComments) {
        this.siteComments = siteComments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
