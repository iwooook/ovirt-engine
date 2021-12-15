package org.ovirt.engine.ui.uicommonweb.models.whitelists;

import org.ovirt.engine.core.common.action.ActionType;
import org.ovirt.engine.core.common.businessentities.Provider;
import org.ovirt.engine.core.common.businessentities.ProviderType;
import org.ovirt.engine.core.common.businessentities.StoragePool;
import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.core.compat.Guid;
import org.ovirt.engine.ui.uicommonweb.UICommand;
import org.ovirt.engine.ui.uicommonweb.Linq;
import org.ovirt.engine.ui.uicommonweb.dataprovider.AsyncDataProvider;
import org.ovirt.engine.ui.uicommonweb.help.HelpTag;
import org.ovirt.engine.ui.uicompat.ConstantsManager;

public class EditWhitelistModel extends WhitelistModel {

    public EditWhitelistModel(WhitelistListModel sourceListModel, Whitelist whitelist) {
        super(sourceListModel, ActionType.EditWhitelist, whitelist);
        setTitle(ConstantsManager.getInstance().getConstants().editWhitelistTitle());

        getDescription().setEntity(whitelist.getDescription());
        getUserName().setEntity(whitelist.getUserName());
        getIpAddress().setEntity(whitelist.getIpAddress());
        getRegistrationTime().setEntity(whitelist.getRegistrationTime());
    }

    private void cancel() {
        sourceListModel.setConfirmWindow(null);
    }

    @Override
    public void executeCommand(UICommand command) {
        super.executeCommand(command);

        if (command.getName() == "Approve") {
            cancel();
            actualSave();
        } else if (command.getName() == "Cancel") {
            cancel();
        }
    }
}
