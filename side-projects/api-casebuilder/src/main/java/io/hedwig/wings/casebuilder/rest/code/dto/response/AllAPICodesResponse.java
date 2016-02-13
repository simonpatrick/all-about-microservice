package io.hedwig.wings.casebuilder.rest.code.dto.response;

import java.util.List;

public class AllAPICodesResponse {

    private List<APICodesResponse> codesInfo;

    public List<APICodesResponse> getCodesInfo() {
        return codesInfo;
    }

    public void setCodesInfo(List<APICodesResponse> codesInfo) {
        this.codesInfo = codesInfo;
    }
}
