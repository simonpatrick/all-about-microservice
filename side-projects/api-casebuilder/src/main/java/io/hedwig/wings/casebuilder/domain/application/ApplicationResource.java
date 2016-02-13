package io.hedwig.wings.casebuilder.domain.application;

/**
 * Created by patrick on 15/12/25.
 */
public class ApplicationResource {

    private long id;
    private long applicationId;
    private String applicationName;
    private String applicationResourceName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(long applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationResourceName() {
        return applicationResourceName;
    }

    public void setApplicationResourceName(String applicationResourceName) {
        this.applicationResourceName = applicationResourceName;
    }
}
