package io.hedwig.jpasamples.domain.server;

import io.hedwig.jpasamples.domain.AbstractAuditingEntity;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by patrick on 16/1/15.
 */
@Entity
@Table(name = "server_info")
public class ServerInfo extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "server_name")
    private String serverName;
    @Column(name = "server_ip")
    private String serverIP;
    @Column(name = "server_type")
    private String serverType;
    @Column(name = "server_os")
    private String serverOS;
    @Column(name = "server_mem")
    private String serverMem;
    @Column(name = "server_cpu")
    private String serverCPU;
    @Column(name = "server_hd_1")
    private String serverHD1;
    @Column(name = "server_hd_2")
    private String serverHD2;
    @Column(name = "server_raidlv")
    private String serverRaidLV;
    @Column(name = "server_management_card_ip")
    private String serverManagementCardIP;
    @Column(name = "server_management_card_user")
    private String serverManagementCardUser;
    @Column(name = "server_management_card_pwd")
    private String serverManagementCardPWD;
    @Column(name = "server_management_card_sn")
    private String serverManagementCardSN;
    @Column(name = "server_asset_no")
    private String serverAssetNo;
    @Column(name = "account")
    private String account;
    @Column(name = "account_password")
    private String accountPassword;
    @Column(name = "server_usage_comments")
    private String serverUsageComments;

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

}
