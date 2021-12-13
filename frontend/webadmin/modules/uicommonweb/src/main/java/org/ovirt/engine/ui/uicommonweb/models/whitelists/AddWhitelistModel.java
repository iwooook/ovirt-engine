package org.ovirt.engine.ui.uicommonweb.models.whitelists;

import org.ovirt.engine.core.common.action.ActionType;
import org.ovirt.engine.core.common.businessentities.Provider;
import org.ovirt.engine.core.common.businessentities.ProviderType;
import org.ovirt.engine.core.common.businessentities.StoragePool;
import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.core.compat.Guid;
import org.ovirt.engine.ui.uicommonweb.Linq;
import org.ovirt.engine.ui.uicommonweb.dataprovider.AsyncDataProvider;
import org.ovirt.engine.ui.uicommonweb.help.HelpTag;
import org.ovirt.engine.ui.uicompat.ConstantsManager;

public class AddWhitelistModel extends WhitelistModel {

    public AddWhitelistModel(WhitelistListModel sourceListModel) {
        super(sourceListModel, ActionType.AddWhitelist, new Whitelist());
        setTitle(ConstantsManager.getInstance().getConstants().addWhitelistTitle());
    }
}
