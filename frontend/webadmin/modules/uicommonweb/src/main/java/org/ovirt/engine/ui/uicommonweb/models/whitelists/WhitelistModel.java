package org.ovirt.engine.ui.uicommonweb.models.whitelists;

import org.checkerframework.checker.units.qual.s;
import org.ovirt.engine.core.common.action.ActionReturnValue;
import org.ovirt.engine.core.common.action.ActionType;
import org.ovirt.engine.core.common.action.WhitelistParameters;
import org.ovirt.engine.ui.uicommonweb.models.SearchableListModel;
import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.ui.uicommonweb.models.Model;
import org.ovirt.engine.ui.frontend.Frontend;
import org.ovirt.engine.ui.uicommonweb.UICommand;

import org.ovirt.engine.ui.uicommonweb.models.EntityModel;

public class WhitelistModel extends Model {

    protected final SearchableListModel sourceListModel;
    private final ActionType action;
    private final Whitelist whitelist;

    // FIXME test for PopupView
    private EntityModel<String> name = new EntityModel<>();
    private EntityModel<String> description = new EntityModel<>();
    private UICommand testCommand;

    public Whitelist getWhitelist() {
        return whitelist;
    }

    public WhitelistModel(SearchableListModel sourceListModel, ActionType action, final Whitelist whitelist) {
        this.sourceListModel = sourceListModel;
        this.action = action;
        this.whitelist = whitelist;

        getCommands().add(UICommand.createDefaultOkUiCommand("OnSave", this));
    }

    protected void onSave() {
        Frontend.getInstance().runAction(action, new WhitelistParameters(), result -> {
            if (result.getReturnValue() == null || !result.getReturnValue().getSucceeded()) {
                return;
            }
            sourceListModel.getSearchCommand().execute();
            cancel();
        }, this);
    } 

    @Override
    public void executeCommand(UICommand command) {
        super.executeCommand(command);

        if (command.getName() == "OnSave") {
            onSave();
        } 
    }

    private void cancel() {
        sourceListModel.setWindow(null);
    }
}
