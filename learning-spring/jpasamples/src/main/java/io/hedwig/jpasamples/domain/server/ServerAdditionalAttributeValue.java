package io.hedwig.jpasamples.domain.server;

import io.hedwig.jpasamples.domain.AbstractAuditingEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by patrick on 16/1/15.
 */
@Entity
@Table(name="server_additional_attribute_value")
public class ServerAdditionalAttributeValue extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "server_info_id")
    private Long serverInfoId;
//    @Column(name = "server_additional_attribute_id")
//    private Long serverAdditionalAttributeId;

    //todo learn join
    @Column(name = "server_additional_attribute_Name")
    private String serverAdditionalAttributeName;

    @NotNull
    @Column(name = "server_additional_attribute_value")
    private String serverAdditionalAttributeValue;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getServerInfoId() {
        return serverInfoId;
    }

    public void setServerInfoId(Long serverInfoId) {
        this.serverInfoId = serverInfoId;
    }
//
//    public Long getServerAdditionalAttributeId() {
//        return serverAdditionalAttributeId;
//    }
//
//    public void setServerAdditionalAttributeId(Long serverAdditionalAttributeId) {
//        this.serverAdditionalAttributeId = serverAdditionalAttributeId;
//    }


    public String getServerAdditionalAttributeValue() {
        return serverAdditionalAttributeValue;
    }

    public void setServerAdditionalAttributeValue(String serverAdditionalAttributeValue) {
        this.serverAdditionalAttributeValue = serverAdditionalAttributeValue;
    }

    public String getServerAdditionalAttributeName() {
        return serverAdditionalAttributeName;
    }

    public void setServerAdditionalAttributeName(String serverAdditionalAttributeName) {
        this.serverAdditionalAttributeName = serverAdditionalAttributeName;
    }

}
