package org.ovirt.engine.core.common.action;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.core.compat.Guid;

public class WhitelistParameters extends ActionParametersBase {

    // FIXME: serialVersionUID for WhitelistParameters
    private static final long serialVersionUID = 308877238353433123L;

    @NotNull
    Guid id;
    private Whitelist whitelist;

    private boolean force;

    public WhitelistParameters() {
        id = Guid.Empty;
    }

    public WhitelistParameters(Whitelist whitelist) {
        this(whitelist, false);
    }

    public WhitelistParameters(Whitelist whitelist, boolean force) {
        this.whitelist = whitelist;
        this.force = force;
    }

    public Whitelist getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(Whitelist whitelist) {
        this.whitelist = whitelist;
    }

    public Guid getId() {
        return id;
    }

    public void setId(Guid id) {
        this.id = id;
    }

    public boolean isForce() {
        return force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }
}
