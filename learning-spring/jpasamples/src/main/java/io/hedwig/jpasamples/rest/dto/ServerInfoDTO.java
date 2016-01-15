package io.hedwig.jpasamples.rest.dto;

import io.hedwig.jpasamples.domain.server.ServerAdditionalAttributeValue;
import io.hedwig.jpasamples.domain.server.ServerInfo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Map;

/**
 * Created by patrick on 16/1/15.
 */
public class ServerInfoDTO {
    private long id;
    private String serverName;
    private String serverIP;
    private String serverType;
    private String serverOS;
    private String serverMem;
    private String serverCPU;
    private String serverHD1;
    private String serverHD2;
    private String serverRaidLV;
    private String serverManagementCardIP;
    private String serverManagementCardUser;
    private String serverManagementCardPWD;
    private String serverManagementCardSN;
    private String serverAssetNo;
    private String account;
    private String accountPassword;
    private String serverUsageComments;
    private String status;
    private Map<String,String> serverAddlValues;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public String getServerType() {
        return serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    public String getServerOS() {
        return serverOS;
    }

    public void setServerOS(String serverOS) {
        this.serverOS = serverOS;
    }

    public String getServerMem() {
        return serverMem;
    }

    public void setServerMem(String serverMem) {
        this.serverMem = serverMem;
    }

    public String getServerCPU() {
        return serverCPU;
    }

    public void setServerCPU(String serverCPU) {
        this.serverCPU = serverCPU;
    }

    public String getServerHD1() {
        return serverHD1;
    }

    public void setServerHD1(String serverHD1) {
        this.serverHD1 = serverHD1;
    }

    public String getServerHD2() {
        return serverHD2;
    }

    public void setServerHD2(String serverHD2) {
        this.serverHD2 = serverHD2;
    }

    public String getServerRaidLV() {
        return serverRaidLV;
    }

    public void setServerRaidLV(String serverRaidLV) {
        this.serverRaidLV = serverRaidLV;
    }

    public String getServerManagementCardIP() {
        return serverManagementCardIP;
    }

    public void setServerManagementCardIP(String serverManagementCardIP) {
        this.serverManagementCardIP = serverManagementCardIP;
    }

    public String getServerManagementCardUser() {
        return serverManagementCardUser;
    }

    public void setServerManagementCardUser(String serverManagementCardUser) {
        this.serverManagementCardUser = serverManagementCardUser;
    }

    public String getServerManagementCardPWD() {
        return serverManagementCardPWD;
    }

    public void setServerManagementCardPWD(String serverManagementCardPWD) {
        this.serverManagementCardPWD = serverManagementCardPWD;
    }

    public String getServerManagementCardSN() {
        return serverManagementCardSN;
    }

    public void setServerManagementCardSN(String serverManagementCardSN) {
        this.serverManagementCardSN = serverManagementCardSN;
    }

    public String getServerAssetNo() {
        return serverAssetNo;
    }

    public void setServerAssetNo(String serverAssetNo) {
        this.serverAssetNo = serverAssetNo;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getServerUsageComments() {
        return serverUsageComments;
    }

    public void setServerUsageComments(String serverUsageComments) {
        this.serverUsageComments = serverUsageComments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, String> getServerAddlValues() {
        return serverAddlValues;
    }

    public void setServerAddlValues(Map<String, String> serverAddlValues) {
        this.serverAddlValues = serverAddlValues;
    }
}
