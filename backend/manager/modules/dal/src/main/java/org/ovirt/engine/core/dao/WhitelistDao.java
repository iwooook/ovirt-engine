package org.ovirt.engine.core.dao;

import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.core.compat.Guid;

public interface WhitelistDao extends GenericDao<Whitelist, Guid>, SearchDao<Whitelist>{
    /**
     * Gets the whitelist by ip address.
     *
     * @param ipAddress
     *            ip address
     */
    Whitelist getByIpAddress(String ipAddress);
    
    /**
     * Saves the whitelist.
     *
     * @param whitelist
     *            the whitelist
     */
    void save(Whitelist whitelist);

    /**
     * Updates the specified whitelist in the database.
     *
     * @param whitelist
     *            the whitelist
     */
    void update(Whitelist whitelist);

    /**
     * Removes the whitelist with the specified id.
     *
     * @param id
     *            the whitelist id
     */
    void remove(Guid id);
}
