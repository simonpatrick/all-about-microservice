package io.hedwig.jpasamples.domain.server;

import io.hedwig.jpasamples.domain.AbstractAuditingEntity;

import javax.persistence.*;

/**
 * Created by patrick on 16/1/15.
 */
@Entity
@Table(name="server_additional_attribute_value")
public class ServerAdditionalAttributeValue extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "server_info_id")
    private long serverInfoId;
    @Column(name = "server_additional_attribute_id")
    private long serverAdditionalAttributeId;
    @Column(name = "status")
    private boolean status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getServerInfoId() {
        return serverInfoId;
    }

    public void setServerInfoId(long serverInfoId) {
        this.serverInfoId = serverInfoId;
    }

    public long getServerAdditionalAttributeId() {
        return serverAdditionalAttributeId;
    }

    public void setServerAdditionalAttributeId(long serverAdditionalAttributeId) {
        this.serverAdditionalAttributeId = serverAdditionalAttributeId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
