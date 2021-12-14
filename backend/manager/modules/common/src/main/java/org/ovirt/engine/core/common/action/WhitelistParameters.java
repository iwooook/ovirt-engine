package org.ovirt.engine.core.common.action;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.core.compat.Guid;

public class WhitelistParameters extends ActionParametersBase {

    private static final long serialVersionUID = 308877238353433123L;

    @Valid
    @NotNull
    Guid id;
    private Whitelist whitelist;

    // FIXME
    public WhitelistParameters() {
        whitelist = new Whitelist();
        id = Guid.Empty;
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
}
