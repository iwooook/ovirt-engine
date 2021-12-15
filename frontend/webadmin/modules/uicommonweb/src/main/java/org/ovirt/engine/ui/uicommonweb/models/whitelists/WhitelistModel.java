package org.ovirt.engine.ui.uicommonweb.models.whitelists;

import java.util.Date;

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

    private EntityModel<String> description = new EntityModel<>();
    private EntityModel<String> userName = new EntityModel<>();
    private EntityModel<String> ipAddress = new EntityModel<>();
    private EntityModel<Date> registrationTime = new EntityModel<>();
    
    public EntityModel<String> getDescription() {
        return description;
    }

    public EntityModel<String> getUserName() {
        return userName;
    }

    public EntityModel<String> getIpAddress() {
        return ipAddress;
    } 

    public EntityModel<Date> getRegistrationTime() {
        return registrationTime;
    }

    public Whitelist getWhitelist() {
        return whitelist;
    }

    public WhitelistModel(SearchableListModel sourceListModel, ActionType action, final Whitelist whitelist) {
        this.sourceListModel = sourceListModel;
        this.action = action;
        this.whitelist = whitelist;

        getCommands().add(UICommand.createDefaultOkUiCommand("Save", this));
        getCommands().add(UICommand.createCancelUiCommand("Cancel", this));
    }

    // FIXME: EditWhitelistModel, RemoveWhitelistModel
    private void onSave() {
        preSave();
    }

    protected void preSave() {
        actualSave();
    }

    protected void actualSave() {
        flush();
        Frontend.getInstance().runAction(action, new WhitelistParameters(whitelist), result -> {
            if (result.getReturnValue() == null || !result.getReturnValue().getSucceeded()) {
                return;
            }
            sourceListModel.getSearchCommand().execute();
            cancel();
        }, this);
    } 

    private void cancel() {
        sourceListModel.setWindow(null);
    }

    private void flush() {
        whitelist.setDescription(description.getEntity());
        whitelist.setUserName(userName.getEntity());
        whitelist.setIpAddress(ipAddress.getEntity());
        whitelist.setRegistrationTime(registrationTime.getEntity());
    }

    @Override
    public void executeCommand(UICommand command) {
        super.executeCommand(command);

        if (command.getName() == "Save") {
            onSave();
        } else if (command.getName() == "Cancel") {
            cancel();
        }
    }
}
