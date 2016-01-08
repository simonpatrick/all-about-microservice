package io.hedwig.petclinic.cachesamples;

/**
 * @author Stephane Nicoll
 */
public interface FooService {

    public String get(long key);

    public String defaultGet(long key);

}
