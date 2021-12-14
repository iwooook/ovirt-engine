package org.ovirt.engine.core.dao;

import java.util.List;

import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.core.compat.Guid;

public interface WhitelistDao extends Dao {
    /**
     * Retrieves the whitelist with the specified id.
     *
     * @param id
     *            the id
     * @return the whitelist, or {@code null} if the id was invalid
     */
    //Whitelist get(Guid id);

    /**
     * Retrieves all whitelists.
     *
     * @return the collection of all whitelists
     */
    //List<Whitelist> getAll();

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
