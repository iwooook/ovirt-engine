package org.ovirt.engine.core.common.businessentities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.ovirt.engine.core.common.validation.annotation.ValidName;
import org.ovirt.engine.core.common.validation.group.CreateEntity;
import org.ovirt.engine.core.common.validation.group.UpdateEntity;
import org.ovirt.engine.core.compat.Guid;

/**
 * Quota business entity which reflects the <code>Quota</code> limitations for storage pool. <BR/>
 * The limitation are separated to two different types
 * <ul>
 * <li>General Limitation - Indicates the general limitation of the quota cross all the storage pool</li>
 * <li>Specific Limitation - Indicates specific limitation of the quota for specific storage or vds group</li>
 * </ul>
 * <BR/>
 * Quota entity encapsulate the specific limitations of the storage pool with lists, general limitations are configured
 * in the field members.<BR/>
 * <BR/>
 * Take in notice there can not be general limitation and specific limitation on the same resource type.
 */
public class Whitelist implements Queryable, BusinessEntity<Guid>, Nameable {

    /**
     * Automatic generated serial version ID.
     */
    private static final long serialVersionUID = 6637198348072059123L;

    /**
     * The quota id.
     */
    private Guid id;

    /**
     * The quota description.
     */
    @Size(min = 0, max = BusinessEntitiesDefinitions.QUOTA_DESCRIPTION_SIZE)
    @NotNull
    private String description;

    private Guid userId;
    private String userName = "FIXME, userName";
    private String ipAddress = "FIXME, ipAddress";
    private Date registrationTime;

    /**
     * Default constructor of Quota, which initialize empty lists for specific limitations, and no user assigned.
     */
    public Whitelist() {
        id = Guid.Empty;
        description = "";
    }

    /**
     * @return the quota id.
     */
    public Guid getId() {
        return id;
    }

    /**
     * @param id
     *            the quota Id to set.
     */
    public void setId(Guid id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
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
