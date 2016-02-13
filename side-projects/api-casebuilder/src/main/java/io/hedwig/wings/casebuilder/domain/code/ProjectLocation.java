package io.hedwig.wings.casebuilder.domain.code;

import com.google.common.base.MoreObjects;

public class ProjectLocation {
    private String projectLocation;
    private String sourceCodeLocation;
    private String testSourCodeLocation;
    private String resourcesLocation;
    private String testResourcesLocation;
    private String apiSourceCodeLocation;
    private String apiTestSourceCodeLocation;

//    public static ProjectLocation init(String workSpacePath) {
//        try{
//            ProjectLocation p = new ProjectLocation();
//            p.projectLocation = workSpacePath;
//            p.sourceCodeLocation = SourceCodePathUtils.getSrcPath(workSpacePath);
//            p.testSourCodeLocation= SourceCodePathUtils.getTestSrcPath(workSpacePath);
//            p.resourcesLocation= SourceCodePathUtils.getResourcePath(workSpacePath);
//            p.testResourcesLocation= SourceCodePathUtils.getTestResourcePath(workSpacePath);
//            p.apiSourceCodeLocation= SourceCodePathUtils.getDirPathInSrcPath(workSpacePath,
//                    FileHelpers.packageToDir(TemplatesConstants.BASE_PACKAGE))+TemplatesConstants.API_BASEDIR;
//            p.apiTestSourceCodeLocation= SourceCodePathUtils.getDirPathInTestSrcPath(workSpacePath,
//                    FileHelpers.packageToDir(TemplatesConstants.BASE_PACKAGE))+TemplatesConstants.API_BASEDIR;
//            return p;
//        }catch (Exception e){
//            logger.error("init project location failed, error={}",e);
//            throw new RuntimeException("init project location failed!!!!");
//        }
//
//    }


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
