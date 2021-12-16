package org.ovirt.engine.ui.uicommonweb.models.whitelists;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import org.ovirt.engine.core.common.action.ActionType;
import org.ovirt.engine.core.common.action.WhitelistParameters;
import org.ovirt.engine.core.common.action.ActionParametersBase;
import org.ovirt.engine.core.common.businessentities.Provider;
import org.ovirt.engine.core.common.businessentities.ProviderType;
import org.ovirt.engine.core.common.businessentities.StoragePool;
import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.core.compat.Guid;
import org.ovirt.engine.ui.frontend.Frontend;
import org.ovirt.engine.ui.uicommonweb.Linq;
import org.ovirt.engine.ui.uicommonweb.dataprovider.AsyncDataProvider;
import org.ovirt.engine.ui.uicommonweb.help.HelpTag;
import org.ovirt.engine.ui.uicommonweb.models.ConfirmationModel;
import org.ovirt.engine.ui.uicommonweb.UICommand;
import org.ovirt.engine.ui.uicompat.ConstantsManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoveWhitelistsModel extends ConfirmationModel {

    private static final Logger log = LoggerFactory.getLogger(RemoveWhitelistsModel.class);

    private final WhitelistListModel sourceListModel;
    private final List<Whitelist> whitelists;
    private final boolean force;

    public RemoveWhitelistsModel(WhitelistListModel sourceListModel, boolean force) {
        this.sourceListModel = sourceListModel;
        this.force = force;
        whitelists = (List<Whitelist>) sourceListModel.getSelectedItems();

        setTitle(ConstantsManager.getInstance().getConstants().removeWhitelistTitle());

        List<Guid> whitelistIds = new ArrayList<>();
        for (Whitelist whitelist : whitelists) {
            whitelistIds.add(whitelist.getId());
        }
        setItems(whitelistIds);

        if (force) {
            getLatch().setIsAvailable(true);
            getLatch().setIsChangeable(true);
            setMessage(ConstantsManager.getInstance().getConstants().forceRemoveProvider());
        }

        UICommand tempVar = UICommand.createDefaultOkUiCommand("Remove", this);
        getCommands().add(tempVar);
        UICommand tempVar2 = UICommand.createCancelUiCommand("Cancel", this);
        getCommands().add(tempVar2);
    }

    private void cancel() {
        sourceListModel.setConfirmWindow(null);
    }

    private void onRemove(boolean force) {
        List<ActionParametersBase> parameterList = new LinkedList<>();
        for (Whitelist whitelist : whitelists) {
            parameterList.add(new WhitelistParameters(whitelist, force));
        }

        Frontend.getInstance().runMultipleActions(ActionType.RemoveWhitelist, parameterList,
                result -> sourceListModel.getSearchCommand().execute());
        cancel();
    }

    @Override
    public void executeCommand(UICommand command) {
        super.executeCommand(command);

        if (command.getName() == "Remove") {
            onRemove(force);
        } else if (command.getName() == "Cancel") {
            cancel();
        }
    }
}
