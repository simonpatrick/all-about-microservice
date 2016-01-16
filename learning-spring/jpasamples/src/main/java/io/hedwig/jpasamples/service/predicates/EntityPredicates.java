package io.hedwig.jpasamples.service.predicates;

import io.hedwig.jpasamples.domain.AbstractStatusEntity;
import io.hedwig.jpasamples.enums.Status;

import java.util.function.Predicate;

/**
 * Created by patrick on 16/1/16.
 */
public class EntityPredicates {

    public static <T extends AbstractStatusEntity>
    Predicate<T> statusPredicate(Status status){
        return t -> t.getStatus()==status.getStatusValue();
    }
}
