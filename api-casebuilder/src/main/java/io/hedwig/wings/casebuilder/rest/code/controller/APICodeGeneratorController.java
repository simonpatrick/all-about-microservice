//package io.hedwig.wings.casebuilder.rest.controller;
//
//import com.dooioo.casebuilder.apitest.domain.dto.CODEGENERATETYPE;
//import com.dooioo.casebuilder.apitest.domain.dto.requests.APIGenerateRequest;
//import com.dooioo.casebuilder.apitest.service.APICodeGenerateService;
//import com.dooioo.casebuilder.common.models.dto.responses.AllGeneratedCodesResponse;
//import com.dooioo.casebuilder.common.models.dto.responses.GeneratedCodesResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import static org.springframework.http.MediaType.*;
//
///**
// * Created by patrick on 15/4/15.
// *
// * @version $Id$
// */
//@Controller
//@RequestMapping("/codes/api")
//public class APICodeGeneratorController {
//
//    @Autowired
//    private APICodeGenerateService codeGenerateService;
//
//    @RequestMapping(value = "/client"
//            , method = RequestMethod.POST
//            , consumes = {APPLICATION_JSON_VALUE
//            }
//            , produces = {APPLICATION_JSON_VALUE})
//
//    @ResponseBody
//    public GeneratedCodesResponse generateAPIClientCode(@RequestBody APIGenerateRequest request) {
//        request.setType(CODEGENERATETYPE.CLIENT_CODE.toString());
//        return codeGenerateService.generatedClientCodesResponse(request);
//    }
//
//
//    @RequestMapping(value = "/testcase"
//            , method = RequestMethod.POST
//            , consumes = {APPLICATION_JSON_VALUE,
//            APPLICATION_XML_VALUE, TEXT_PLAIN_VALUE, ALL_VALUE}
//            , produces = {APPLICATION_JSON_VALUE})
//    @ResponseBody
//    public GeneratedCodesResponse generateAPITestCode(@RequestBody APIGenerateRequest request) {
//        request.setType(CODEGENERATETYPE.TESTCASE_CODE.toString());
//        return codeGenerateService.generatedTestCodesResponse(request);
//
//    }
//
//    @RequestMapping(value = "/testdata"
//            , method = RequestMethod.POST
//            , consumes = {APPLICATION_JSON_VALUE,
//            APPLICATION_XML_VALUE, TEXT_PLAIN_VALUE, ALL_VALUE}
//            , produces = {APPLICATION_JSON_VALUE})
//    @ResponseBody
//    public GeneratedCodesResponse generateAPITestData(@RequestBody APIGenerateRequest request) {
//
//        return codeGenerateService.generateTestDataResponse(request);
//
//    }
//
//    @RequestMapping(value = "/allcodes"
//            , method = RequestMethod.POST
//            , consumes = {APPLICATION_JSON_VALUE,
//            APPLICATION_XML_VALUE, TEXT_PLAIN_VALUE, ALL_VALUE}
//            , produces = {APPLICATION_JSON_VALUE})
//    @ResponseBody
//    public AllGeneratedCodesResponse generateAllCodes(@RequestBody APIGenerateRequest request) {
//
//        return codeGenerateService.generateAllCodes(request);
//
//    }
//}
