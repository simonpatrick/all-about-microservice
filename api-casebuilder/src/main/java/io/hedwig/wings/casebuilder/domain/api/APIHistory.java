package io.hedwig.wings.casebuilder.domain.api;

import io.hedwig.wings.casebuilder.domain.BaseAuditableEntity;

import javax.persistence.Entity;

/**
 * Created by patrick on 15/12/25.
 */

@Entity(name="api_history")
public class APIHistory extends BaseAuditableEntity {

    private String apiId ;
    private String apiName ;
    private String apiURL ;
    private String apiDomainName ;
    private String apiMethod ;
    private String apiRequestBody ;
    private String apiAcceptType ;
    private String apiContentType ;
    private String apiStatus ;

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiURL() {
        return apiURL;
    }

    public void setApiURL(String apiURL) {
        this.apiURL = apiURL;
    }

    public String getApiDomainName() {
        return apiDomainName;
    }

    public void setApiDomainName(String apiDomainName) {
        this.apiDomainName = apiDomainName;
    }

    public String getApiMethod() {
        return apiMethod;
    }

    public void setApiMethod(String apiMethod) {
        this.apiMethod = apiMethod;
    }

    public String getApiRequestBody() {
        return apiRequestBody;
    }

    public void setApiRequestBody(String apiRequestBody) {
        this.apiRequestBody = apiRequestBody;
    }

    public String getApiAcceptType() {
        return apiAcceptType;
    }

    public void setApiAcceptType(String apiAcceptType) {
        this.apiAcceptType = apiAcceptType;
    }

    public String getApiContentType() {
        return apiContentType;
    }

    public void setApiContentType(String apiContentType) {
        this.apiContentType = apiContentType;
    }

    public String getApiStatus() {
        return apiStatus;
    }

    public void setApiStatus(String apiStatus) {
        this.apiStatus = apiStatus;
    }
}
