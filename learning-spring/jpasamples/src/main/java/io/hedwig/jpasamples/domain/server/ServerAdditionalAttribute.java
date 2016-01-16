package io.hedwig.jpasamples.domain.server;

import io.hedwig.jpasamples.domain.AbstractAuditingEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by patrick on 16/1/15.
 */
@Entity
@Table(name="server_additional_attribute")
public class ServerAdditionalAttribute  extends AbstractAuditingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "server_additional_attribute_name")
    private String serverAdditionalAttributeName;

    @NotNull
    @Column(name = "server_type")
    private String serverType;

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

    public String getServerType() {
        return serverType;
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

}
