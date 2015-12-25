package io.hedwig.wings.casebuilder.domain;

import java.util.Date;

/**
 * Created by patrick on 15/12/25.
 */
public class BaseAuditableEntity {
    private Date createdDate;
    private Date lastUpdatedDate;
    private String createBy;
    private String lastedUpdateBy;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getLastedUpdateBy() {
        return lastedUpdateBy;
    }

    public void setLastedUpdateBy(String lastedUpdateBy) {
        this.lastedUpdateBy = lastedUpdateBy;
    }
}
