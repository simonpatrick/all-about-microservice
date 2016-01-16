package io.hedwig.jpasamples.service.functions;

import io.hedwig.jpasamples.domain.AbstractAuditingEntity;

import java.time.ZonedDateTime;
import java.util.function.Function;

/**
 * Created by patrick on 16/1/16.
 */
public class Functions {

    public static <T extends AbstractAuditingEntity,
            R extends AbstractAuditingEntity> Function<T,R> addCreatedAuditInfo(){

        return t -> {

            t.setCreatedBy("tester123");
            t.setCreatedDate(ZonedDateTime.now());
            t.setLastModifiedBy("tester123");
            t.setLastModifiedDate(ZonedDateTime.now());
            return (R)t;
        };
    }
}
