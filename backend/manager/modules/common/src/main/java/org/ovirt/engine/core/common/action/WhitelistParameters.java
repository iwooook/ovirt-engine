package org.ovirt.engine.core.common.action;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.ovirt.engine.core.common.businessentities.Provider;
import org.ovirt.engine.core.common.businessentities.Whitelist;

public class WhitelistParameters extends ActionParametersBase {

    private static final long serialVersionUID = 308877238353433123L;

    @Valid
    @NotNull
    private Provider<?> provider;

    private boolean force;

    public WhitelistParameters() {
    }

    public WhitelistParameters(Provider<?> provider) {
        this(provider, false);
    }

    public WhitelistParameters(Provider<?> provider, boolean force) {
        this.provider = provider;
        this.force = force;
    }

    public Provider<?> getProvider() {
        return provider;
    }

    public void setProvider(Provider<?> provider) {
        this.provider = provider;
    }

    public boolean isForce() {
        return force;
    }

    public void setForce(boolean force) {
        this.force = force;
    }
}
