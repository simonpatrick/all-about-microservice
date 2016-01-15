package io.hedwig.jpasamples.domain.server;

import io.hedwig.jpasamples.domain.AbstractAuditingEntity;

import javax.persistence.*;

/**
 * Created by patrick on 16/1/15.
 */
@Entity
@Table(name="server_additional_attribute")
public class ServerAdditionalAttribute  extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "server_additional_attribute_name")
    private String serverAdditionalAttributeName;

    @Column(name = "server_additional_attribute_value")
    private String serverAdditionalAttributeValue;
    @Column(name = "status")
    private boolean status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getServerAdditionalAttributeName() {
        return serverAdditionalAttributeName;
    }

    public void setServerAdditionalAttributeName(String serverAdditionalAttributeName) {
        this.serverAdditionalAttributeName = serverAdditionalAttributeName;
    }

    public String getServerAdditionalAttributeValue() {
        return serverAdditionalAttributeValue;
    }

    public void setServerAdditionalAttributeValue(String serverAdditionalAttributeValue) {
        this.serverAdditionalAttributeValue = serverAdditionalAttributeValue;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
