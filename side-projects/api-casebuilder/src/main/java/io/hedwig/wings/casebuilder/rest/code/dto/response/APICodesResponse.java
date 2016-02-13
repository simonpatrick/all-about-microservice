package io.hedwig.wings.casebuilder.rest.code.dto.response;

public class APICodesResponse {
    private String className;
    private String codes;
    private String codeLocationPath;
    private CodesErrorResponse error;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public String getCodeLocationPath() {
        return codeLocationPath;
    }

    public void setCodeLocationPath(String codeLocationPath) {
        this.codeLocationPath = codeLocationPath;
    }

    public CodesErrorResponse getError() {
        return error;
    }

    public void setError(CodesErrorResponse error) {
        this.error = error;
    }
}