package org.ovirt.engine.core.common.businessentities;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.ovirt.engine.core.compat.Guid;

public class Whitelist implements Queryable, BusinessEntity<Guid> {

    private Guid id;
    @Size(min = 0, max = BusinessEntitiesDefinitions.QUOTA_DESCRIPTION_SIZE)
    @NotNull
    private String description;
    private String userName;
    private String ipAddress;
    private Date registrationTime;

    public Whitelist() {
        id = Guid.Empty;
        description = "description";
        userName = "userName";
        ipAddress = "ipAddress";
        registrationTime = new Date();
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date time) {
        this.registrationTime = time;
    }

    @Override
    public Object getQueryableId() {
        return getId();
    }
}
