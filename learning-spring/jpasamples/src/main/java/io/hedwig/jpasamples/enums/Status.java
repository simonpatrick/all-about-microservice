package io.hedwig.jpasamples.enums;

/**
 * Created by patrick on 16/1/15.
 */
public enum Status {
    ACTIVE(1),DEACTIVE(0),PENDING(2);

    private int statusValue;

    Status(int statusValue) {
        this.statusValue=statusValue;
    }

    public int getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(int statusValue) {
        this.statusValue = statusValue;
    }
}
