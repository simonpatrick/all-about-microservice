package io.hedwig.wings.casebuilder.domain.user;

import io.hedwig.wings.casebuilder.domain.BaseAuditableEntity;

/**
 * Created by patrick on 15/12/25.
 */
public class UserAPICollection extends BaseAuditableEntity {

    private long id;
    private String userId;
    private String apiId;
    private String apiName;
    private String userApiCollectionStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public String getUserApiCollectionStatus() {
        return userApiCollectionStatus;
    }

    public void setUserApiCollectionStatus(String userApiCollectionStatus) {
        this.userApiCollectionStatus = userApiCollectionStatus;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }
}
