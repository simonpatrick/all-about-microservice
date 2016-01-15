package io.hedwig.jpasamples.tools;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * Created by patrick on 16/1/15.
 */
public class CollectionsHelper {

    public static List<Long> parseToList(String ids,String separator){
        String[] idArray=ids.split(separator);
        List<Long> result =Lists.newArrayList();
        for (String id : idArray) {
            try{
                result.add(Long.parseLong(id));
            }catch (Exception e){
                //ignore invalid error
            }
        }

        return result;
    }
}
