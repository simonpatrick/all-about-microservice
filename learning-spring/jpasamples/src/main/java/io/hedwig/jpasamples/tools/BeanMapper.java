package io.hedwig.jpasamples.tools;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;

/**
 * Created by patrick on 16/1/16.
 */
public class BeanMapper {
    private static MapperFacade mapper = null;

    static{
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapper=mapperFactory.getMapperFacade();
    }

    public static <S,D>  D map(S source,Class<D> destinationClass){
        return mapper.map(source,destinationClass);
    }

    public static <S,D> List<D> mapList(Iterable<S> sourceList,Class<D> destClass){
        return mapper.mapAsList(sourceList,destClass);
    }
}
