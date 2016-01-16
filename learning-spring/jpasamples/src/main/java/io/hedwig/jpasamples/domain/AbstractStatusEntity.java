package io.hedwig.jpasamples.domain;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * Created by patrick on 16/1/16.
 */
@MappedSuperclass
public class AbstractStatusEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
