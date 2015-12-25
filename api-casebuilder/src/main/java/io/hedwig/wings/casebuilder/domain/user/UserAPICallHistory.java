package io.hedwig.wings.casebuilder.domain.user;

/**
 * Created by patrick on 15/12/25.
 */
public class UserAPICallHistory {

    private long id;
    private String calledAPIId;
    private String calledAPIName;
    private String calledAPIRequest;
    private String calledAPIResponse;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCalledAPIId() {
        return calledAPIId;
    }

    public void setCalledAPIId(String calledAPIId) {
        this.calledAPIId = calledAPIId;
    }

    public String getCalledAPIName() {
        return calledAPIName;
    }

    public void setCalledAPIName(String calledAPIName) {
        this.calledAPIName = calledAPIName;
    }

    public String getCalledAPIRequest() {
        return calledAPIRequest;
    }

    public void setCalledAPIRequest(String calledAPIRequest) {
        this.calledAPIRequest = calledAPIRequest;
    }

    public String getCalledAPIResponse() {
        return calledAPIResponse;
    }

    public void setCalledAPIResponse(String calledAPIResponse) {
        this.calledAPIResponse = calledAPIResponse;
    }
}
