package io.hedwig.wings.casebuilder.domain.application;

/**
 * Created by patrick on 15/12/25.
 */
public class Application {

    private long id;
    private String applicationName;
    private String applicationStatus;
    private String applicationDomainURL;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getApplicationDomainURL() {
        return applicationDomainURL;
    }

    public void setApplicationDomainURL(String applicationDomainURL) {
        this.applicationDomainURL = applicationDomainURL;
    }
}
