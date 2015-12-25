package io.hedwig.wings.casebuilder.domain.user;

import io.hedwig.wings.casebuilder.domain.BaseAuditableEntity;

/**
 * Created by patrick on 15/12/25.
 */
public class User extends BaseAuditableEntity {

    private String useName;
    private String userId;
    private String password;
    private String passwodMD5;

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswodMD5() {
        return passwodMD5;
    }

    public void setPasswodMD5(String passwodMD5) {
        this.passwodMD5 = passwodMD5;
    }
}
