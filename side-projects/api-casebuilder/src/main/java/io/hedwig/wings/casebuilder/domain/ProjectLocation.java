package io.hedwig.wings.casebuilder.domain;

import com.google.common.base.MoreObjects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by patrick on 15/4/13.
 *
 * @version $Id$
 */


public class ProjectLocation {

    private String projectLocation;
    private String sourceCodeLocation;
    private String testSourCodeLocation;
    private String resourcesLocation;
    private String testResourcesLocation;
    private String apiSourceCodeLocation;
    private String apiTestSourceCodeLocation;

    public String getProjectLocation() {
        return projectLocation;
    }

    public void setProjectLocation(String projectLocation) {
        this.projectLocation = projectLocation;
    }

    public String getSourceCodeLocation() {
        return sourceCodeLocation;
    }

    public void setSourceCodeLocation(String sourceCodeLocation) {
        this.sourceCodeLocation = sourceCodeLocation;
    }

    public String getTestSourCodeLocation() {
        return testSourCodeLocation;
    }

    public void setTestSourCodeLocation(String testSourCodeLocation) {
        this.testSourCodeLocation = testSourCodeLocation;
    }

    public String getResourcesLocation() {
        return resourcesLocation;
    }

    public void setResourcesLocation(String resourcesLocation) {
        this.resourcesLocation = resourcesLocation;
    }

    public String getTestResourcesLocation() {
        return testResourcesLocation;
    }

    public void setTestResourcesLocation(String testResourcesLocation) {
        this.testResourcesLocation = testResourcesLocation;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("projectLocation", projectLocation)
                .add("sourceCodeLocation", sourceCodeLocation)
                .add("testSourCodeLocation", testSourCodeLocation)
                .add("resourcesLocation", resourcesLocation)
                .add("testResourcesLocation", testResourcesLocation)
                .add("apiSourceCodeLocation", apiSourceCodeLocation)
                .add("apiTestSourceCodeLocation", apiTestSourceCodeLocation)
                .toString();
    }

    public String getApiSourceCodeLocation() {
        return apiSourceCodeLocation;
    }

    public void setApiSourceCodeLocation(String apiSourceCodeLocation) {
        this.apiSourceCodeLocation = apiSourceCodeLocation;
    }

    public String getApiTestSourceCodeLocation() {
        return apiTestSourceCodeLocation;
    }

    public void setApiTestSourceCodeLocation(String apiTestSourceCodeLocation) {
        this.apiTestSourceCodeLocation = apiTestSourceCodeLocation;
    }
}
