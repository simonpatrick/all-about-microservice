package io.hedwig.bootsamples.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by patrick on 16/1/7.
 */
public class Regex {

    public static void main(String[] args) {
        Pattern  pattern = Pattern.compile("$");
        String testString ="test ${test}";

        Matcher m = pattern.matcher(testString);
        if(m.find()){
            System.out.println("find pattern");
        }
    }
}
