package io.hedwig.wings.casebuilder.utils;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Map;

/**
 * Created by patrick on 15/12/25.
 */
public class JsonHelper {

    public static void generateSimpleClass(String jsonString,String className) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String,String> o = mapper.readValue(jsonString, Map.class);
        System.out.println(String.format("public class %s {", StringUtils.capitalize(className)));
        for (Map.Entry<String, String> entry : o.entrySet()) {
            System.out.println(String.format("private String %s ;",entry.getKey().toString()));
        }
        System.out.println("}");
    }
    public static void main(String[] args) throws IOException {
        String jsonFile = "      { \n" +
                "        \"apiId\":123455,\n" +
                "        \"apiName\":\"testAPI\",\n" +
                "        \"apiURL\":\"/test/\",\n" +
                "        \"apiDomainName\":\"testDomain\",\n" +
                "        \"apiMethod\":\"GET\",\n" +
                "        \"apiRequestBody\":\"a sample file or a json sample\",\n" +
                "        \"apiAcceptType\":\"application/json\",\n" +
                "        \"apiContentType\":\"application/json\",\n" +
                "        \"apiStatus\":\"active\"\n" +
                "      }";
       // System.out.println(String.format("test %s","test"));
        generateSimpleClass(jsonFile,"API");

    }
}
