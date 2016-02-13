//package io.hedwig.wings.casebuilder.service;
//
//import com.dooioo.automation.assertion.SoftAssertion;
//import com.dooioo.automation.helpers.FileHelper;
//import com.dooioo.automation.helpers.StringHelper;
//import com.dooioo.casebuilder.apitest.domain.ProjectLocation;
//import com.dooioo.casebuilder.apitest.domain.dto.CODEGENERATETYPE;
//import com.dooioo.casebuilder.apitest.domain.dto.requests.APIGenerateRequest;
//import com.dooioo.casebuilder.common.models.DummyProjectSetting;
//import com.dooioo.casebuilder.common.models.dto.responses.AllGeneratedCodesResponse;
//import com.dooioo.casebuilder.common.models.dto.responses.CodesErrorResponseBuilder;
//import com.dooioo.casebuilder.common.models.dto.responses.GeneratedCodesResponse;
//import com.dooioo.casebuilder.common.utils.generator.ApiCodeGenerator;
//import com.google.common.collect.Lists;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
///**
// * Created by patrick on 15/4/15.
// *
// * @version $Id$
// */
//
//@Service
//public class APICodeGenerateService {
//
//    private static final Logger logger = LoggerFactory.getLogger(APICodeGenerateService.class.getName());
//
//    /**
//     * 生成测试数据的Response
//     * @param request http 请求
//     * @return
//     */
//    public GeneratedCodesResponse generateTestDataResponse(APIGenerateRequest request){
//
//        GeneratedCodesResponse codes = new GeneratedCodesResponse();
//        ProjectLocation location = DummyProjectSetting.get(request.getProjectName().toLowerCase());
//        if(location==null){
//            codes.setError(CodesErrorResponseBuilder.projectLocationError());
//            return codes;
//        }
//        return generateTestData(request,codes,location);
//    }
//
//    /**
//     * 获取生成代码的所有请求
//     * @param request
//     * @return
//     */
//    public AllGeneratedCodesResponse generateAllCodes(APIGenerateRequest request) {
//
//        AllGeneratedCodesResponse response = new AllGeneratedCodesResponse();
//        GeneratedCodesResponse codes = new GeneratedCodesResponse();
//        ProjectLocation location = DummyProjectSetting.get(request.getProjectName().toLowerCase());
//        if(!validateCodeGeneratorRequest(request,codes,location)) {
//            response.setAllCodes(Lists.newArrayList(codes));
//            return response;
//        }
//
//        response.setAllCodes(Lists.newArrayList(generateClientCode(request
//                ,new GeneratedCodesResponse(),location)
//        ,generateTestCaseCode(request,new GeneratedCodesResponse(),location)
//                ,generateTestData(request,new GeneratedCodesResponse(),location)));
//        return response;
//    }
//
//
//    /**
//     * 获取客户端代码
//     * @param request
//     * @return
//     */
//    public GeneratedCodesResponse generatedClientCodesResponse(APIGenerateRequest request){
//        GeneratedCodesResponse codes = new GeneratedCodesResponse();
//        ProjectLocation location = DummyProjectSetting.get(request.getProjectName().toLowerCase());
//        if (!validateCodeGeneratorRequest(request, codes, location)) return codes;
//        return generateClientCode(request, codes, location);
//    }
//
//    /**
//     * 生成测试代码
//     * @param request
//     * @return
//     */
//    public GeneratedCodesResponse generatedTestCodesResponse(APIGenerateRequest request){
//        GeneratedCodesResponse codes = new GeneratedCodesResponse();
//        ProjectLocation location = DummyProjectSetting.get(request.getProjectName().toLowerCase());
//        if (!validateCodeGeneratorRequest(request, codes, location)) return codes;
//        return generateTestCaseCode(request, codes, location);
//    }
//
//    /**
//     * 验证是不是正确的请求
//     * @param request
//     * @param codes
//     * @param location
//     * @return
//     */
//    private boolean validateCodeGeneratorRequest(APIGenerateRequest request
//            , GeneratedCodesResponse codes, ProjectLocation location) {
//        if(!StringHelper.isNotEmptyOrNotBlankString(request.getProjectName())){
//            codes.setError(CodesErrorResponseBuilder.projectLocationError());
//            return false;
//        }
//        if(location==null){
//            codes.setError(CodesErrorResponseBuilder.projectLocationError());
//            return false;
//        }
//        if(request.getApiDescription()==null){
//            codes.setError(CodesErrorResponseBuilder.APIDescriptionError());
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * 生成测试数据代码
//     * @param request
//     * @param codes
//     * @param location
//     * @return
//     */
//    private GeneratedCodesResponse generateTestData(APIGenerateRequest request
//            ,GeneratedCodesResponse codes,ProjectLocation location) {
//        StringBuilder sb = new StringBuilder();
//        String testDataPrefix = "RequestData.";
//        String mapPattern="%s[%s]";
//        sb.append("RequestData.body,");
//        if(request.getApiDescription().getPathParameters().size()>=1){
//            request.getApiDescription().getPathParameters().stream()
//                    .forEach(element -> {
//                        sb.append(testDataPrefix);
//                        sb.append(String.format(mapPattern,"pathParameters",element));
//                        sb.append(",");
//                    });
//        }
//        if(request.getApiDescription().getQueryParameters().size()>=1){
//            request.getApiDescription().getQueryParameters().stream()
//                    .forEach(element -> {
//                        sb.append(testDataPrefix);
//                        sb.append(String.format(mapPattern,"queryParameters",element));
//                        sb.append(",");
//                    });
//        }
//        sb.append("status_code,");
//        sb.append("result_body");
//        String data =  sb.toString();
//        logger.info("start write test data file.....");
//        FileHelper.writeToFile("testdata.csv",data);
//        codes.setCodes(data);
//        codes.setClassName(ApiCodeGenerator.generateClassName(request.getApiName(),"APITest"));
//        codes.setCodeLocationPath(location.getTestResourcesLocation()+"testcases/apis/"+request.getApiCategory());
//        return codes;
//    }
//
//    /**
//     * 生成测试case代码
//     * @param request
//     * @param codes
//     * @param location
//     * @return
//     */
//    private GeneratedCodesResponse generateTestCaseCode(APIGenerateRequest request, GeneratedCodesResponse codes, ProjectLocation location) {
//        if(CODEGENERATETYPE.TESTCASE_CODE.toString().equalsIgnoreCase(request.getType())){
//            codes.setClassName(ApiCodeGenerator.generateClassName(request.getApiName(), "APITest"));
//            codes.setCodeLocationPath(location.getTestSourCodeLocation()+"/"+request.getApiCategory());
//            String clientCode = ApiCodeGenerator.generateAPITestCaseCode(request);
//            logger.info("start write api test file.....");
//            FileHelper.writeToFile("APITest.java", clientCode);
//            codes.setCodes(clientCode);
//        }
//        return codes;
//
//    }
//
//
//    /**
//     * 生成测试客户端代码
//     * @param request
//     * @param codes
//     * @param location
//     * @return
//     */
//    private GeneratedCodesResponse generateClientCode(APIGenerateRequest request, GeneratedCodesResponse codes, ProjectLocation location) {
//        if(CODEGENERATETYPE.CLIENT_CODE.toString().equalsIgnoreCase(request.getType())){
//            codes.setClassName(ApiCodeGenerator.generateClassName(request.getApiName(), "API"));
//            codes.setCodeLocationPath(location.getApiSourceCodeLocation());
//            String clientCode = ApiCodeGenerator.generateAPIClientCode(request);
//            logger.info("start write api code file.....");
//            FileHelper.writeToFile("API.java", clientCode);
//            codes.setCodes(clientCode);
//        }
//
//        return codes;
//    }
//
//
//}
