package org.ovirt.engine.core.common.action;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.ovirt.engine.core.common.businessentities.Whitelist;

public class WhitelistParameters extends ActionParametersBase {

    private static final long serialVersionUID = 308877238353433123L;

    @Valid
    @NotNull
    private Whitelist whitelist;

    // FIXME
    public WhitelistParameters() {
        whitelist = new Whitelist();
    }

    public Whitelist getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(Whitelist whitelist) {
        this.whitelist = whitelist;
    }
}
