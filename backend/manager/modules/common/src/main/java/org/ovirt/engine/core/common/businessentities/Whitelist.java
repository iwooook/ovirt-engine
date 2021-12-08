package org.ovirt.engine.core.common.businessentities;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.ovirt.engine.core.compat.Guid;

public class Whitelist implements Queryable {

    private Guid id;
    @Size(min = 0, max = BusinessEntitiesDefinitions.QUOTA_DESCRIPTION_SIZE)
    @NotNull
    private String description;
    private Guid userId;
    private String userName = "FIXME, userName";
    private String ipAddress = "FIXME, ipAddress";
    private Date registrationTime;

    public Whitelist() {
        id = Guid.Empty;
        description = "";
    }

    public Guid getId() {
        return id;
    }

    public void setId(Guid id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? "" : description;
    }

    @Override
    public Object getQueryableId() {
        return getId();
    }

    public String getUserName() {
        return userName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Guid getUserId() {
        return userId;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }
}
