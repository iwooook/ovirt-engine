package org.ovirt.engine.ui.uicommonweb.models.whitelists;

import org.ovirt.engine.core.common.action.ActionReturnValue;
import org.ovirt.engine.core.common.action.ActionType;
import org.ovirt.engine.ui.uicommonweb.models.SearchableListModel;
import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.ui.uicommonweb.models.Model;
import org.ovirt.engine.ui.frontend.Frontend;
import org.ovirt.engine.ui.uicommonweb.UICommand;

public class WhitelistModel extends Model {

    protected final SearchableListModel sourceListModel;
    private ActionType action;
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

    @Override
    public void executeCommand(UICommand command) {
        super.executeCommand(command);

        // FIXME getName, setName for UICommand
        if (command.getName() == "OnSave") {
            onSave();
        } //else if (CMD_TEST.equals(command.getName())) {
           // onTest();
    }

    protected void onSave() {
        /*
        Frontend.getInstance().runAction(action, new ProviderParameters(provider), result -> {
            if (result.getReturnValue() == null || !result.getReturnValue().getSucceeded()) {
                return;
            }
            sourceListModel.getSearchCommand().execute();
            cancel();
        }, this);
        */
    }
}
