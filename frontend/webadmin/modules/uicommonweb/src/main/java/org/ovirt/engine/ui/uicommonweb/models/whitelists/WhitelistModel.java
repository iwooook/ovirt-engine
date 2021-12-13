package org.ovirt.engine.ui.uicommonweb.models.whitelists;

import org.ovirt.engine.core.common.action.ActionReturnValue;
import org.ovirt.engine.core.common.action.ActionType;
import org.ovirt.engine.ui.uicommonweb.models.SearchableListModel;
import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.ui.uicommonweb.models.Model;

public class WhitelistModel extends Model {

    protected final SearchableListModel sourceListModel;
    private Whitelist whitelist;

    public Whitelist getWhitelist() {
        return whitelist;
    }

    public void setWhitelist(Whitelist whitelist) {
        this.whitelist = whitelist;
    }

    public WhitelistModel(SearchableListModel sourceListModel, ActionType action, final Whitelist whitelist) {
        this.sourceListModel = sourceListModel;
        this.whitelist = whitelist;
    }
}
