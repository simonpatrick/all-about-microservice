package io.hedwig.wings.casebuilder.rest.code.dto;

import io.hedwig.wings.casebuilder.rest.code.dto.response.CodesErrorResponse;

public class CodesErrorResponseBuilder {

    public static CodesErrorResponse projectLocationError(){
        CodesErrorResponse error = new CodesErrorResponse();
        error.setErrorCode("001");
        error.setErrorMessage("project_is_not_defined");
        error.setErrorReason("project is not defined");
        return error;
    }

    public static CodesErrorResponse APIDescriptionError(){
        CodesErrorResponse error = new CodesErrorResponse();
        error.setErrorCode("002");
        error.setErrorMessage("api_description_is_not_defined");
        error.setErrorReason("api description is not defined");
        return error;
    }

    public static CodesErrorResponse OtherDescriptionError(){
        CodesErrorResponse error = new CodesErrorResponse();
        error.setErrorCode("009");
        error.setErrorMessage("no_matched_code_type");
        error.setErrorReason("there is not matched code type to generate,please check your code type selection");
        return error;
    }
}
