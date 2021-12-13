package org.ovirt.engine.ui.uicommonweb.models.whitelists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.ovirt.engine.core.common.action.ActionParametersBase;
import org.ovirt.engine.core.common.action.ActionType;
import org.ovirt.engine.core.common.action.IdParameters;
import org.ovirt.engine.core.common.action.QuotaCRUDParameters;
import org.ovirt.engine.core.common.businessentities.Cluster;
import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.core.common.businessentities.Quota;
import org.ovirt.engine.core.common.businessentities.QuotaCluster;
import org.ovirt.engine.core.common.businessentities.QuotaStorage;
import org.ovirt.engine.core.common.businessentities.StorageDomain;
import org.ovirt.engine.core.common.businessentities.StoragePool;
import org.ovirt.engine.core.common.interfaces.SearchType;
import org.ovirt.engine.core.common.mode.ApplicationMode;
import org.ovirt.engine.core.common.queries.IdQueryParameters;
import org.ovirt.engine.core.common.queries.QueryReturnValue;
import org.ovirt.engine.core.common.queries.QueryType;
import org.ovirt.engine.core.common.queries.SearchParameters;
import org.ovirt.engine.core.compat.Guid;
import org.ovirt.engine.core.searchbackend.SearchObjects;
import org.ovirt.engine.ui.frontend.Frontend;
import org.ovirt.engine.ui.uicommonweb.UICommand;
import org.ovirt.engine.ui.uicommonweb.dataprovider.AsyncDataProvider;
import org.ovirt.engine.ui.uicommonweb.help.HelpTag;
import org.ovirt.engine.ui.uicommonweb.models.ConfirmationModel;
import org.ovirt.engine.ui.uicommonweb.models.HasEntity;
import org.ovirt.engine.ui.uicommonweb.models.ListWithSimpleDetailsModel;
import org.ovirt.engine.ui.uicommonweb.models.SearchStringMapping;
import org.ovirt.engine.ui.uicommonweb.place.WebAdminApplicationPlaces;
import org.ovirt.engine.ui.uicompat.ConstantsManager;
import com.google.inject.Inject;

// FIXME <Void, Whitelist>
public class WhitelistListModel extends ListWithSimpleDetailsModel<Whitelist, Whitelist> {

    private static final Logger logger = Logger.getLogger("WhitelistListModel: ");

    private static final String CMD_ADD = "Add"; //$NON-NLS-1$
    private static final String CMD_EDIT = "Edit"; //$NON-NLS-1$
    private static final String CMD_REMOVE = "Remove"; //$NON-NLS-1$

    private UICommand addCommand;
    private UICommand editCommand;
    private UICommand removeCommand;

    @Inject
    public WhitelistListModel() {
        // FIXME
        setModelList();

        setTitle(ConstantsManager.getInstance().getConstants().whitelistTitle());
        //setHelpTag(HelpTag.engine_sessions);
        setApplicationPlace(WebAdminApplicationPlaces.whitelistMainPlace);
        //setHashName("whitelists"); //$NON-NLS-1$

        setDefaultSearchString(SearchStringMapping.WHITELIST_DEFAULT_SEARCH + ":"); //$NON-NLS-1$
        setSearchString(getDefaultSearchString());
        setSearchObjects(new String[] { SearchObjects.WHITELIST_OBJ_NAME, SearchObjects.WHITELIST_PLU_OBJ_NAME });
        setAvailableInModes(ApplicationMode.AllModes);

        setAddCommand(new UICommand(CMD_ADD, this));
        setEditCommand(new UICommand(CMD_EDIT, this));
        setRemoveCommand(new UICommand(CMD_REMOVE, this));

        updateActionAvailability();

        getSearchNextPageCommand().setIsAvailable(true);
        getSearchPreviousPageCommand().setIsAvailable(true);
    }

    private void setModelList() {
        List<HasEntity<Whitelist>> list = new ArrayList<>();
        setDetailModels(list);
    }

    public UICommand getAddCommand() {
        return addCommand;
    }

    public void setAddCommand(UICommand value) {
        addCommand = value;
    }

    @Override
    public UICommand getEditCommand() {
        return editCommand;
    }

    private void setEditCommand(UICommand value) {
        editCommand = value;
    }

    public UICommand getRemoveCommand() {
        return removeCommand;
    }

    private void setRemoveCommand(UICommand value) {
        removeCommand = value;
    }

    @Override
    protected String getListName() {
        return "WhitelistListModel"; //$NON-NLS-1$
    }

    @Override
    protected void onSelectedItemChanged() {
        super.onSelectedItemChanged();
        updateActionAvailability();
    }

    @Override
    protected void selectedItemsChanged() {
        super.selectedItemsChanged();
        updateActionAvailability();
    }

    private void updateActionAvailability() {
        Collection<Whitelist> tempVar = getSelectedItems();
        Collection<Whitelist> selectedItems = (tempVar != null) ? tempVar : new ArrayList();

        getEditCommand().setIsExecutionAllowed(selectedItems.size() == 1);
        getRemoveCommand().setIsExecutionAllowed(selectedItems.size() > 0);


        getAddCommand().setIsAvailable(true);
        getRemoveCommand().setIsAvailable(true);
    }

    @Override
    public boolean isSearchStringMatch(String searchString) {
        return searchString.trim().toLowerCase().startsWith("whitelist"); //$NON-NLS-1$
    }

    /*
    @Override
    protected void syncSearch() {
        SearchParameters tempVar =
                new SearchParameters(applySortOptions(getSearchString()), SearchType.Whitelist, isCaseSensitiveSearch());
        tempVar.setMaxCount(getSearchPageSize());
        super.syncSearch(QueryType.Search, tempVar);
    }
    */

    private void add() {
        logger.log(Level.WARNING, "add() called"); 

        if (getWindow() != null) {
            return;
        }
        setWindow(new AddWhitelistModel(this));
    }

    /*
    private void edit() {
        if (getWindow() != null) {
            return;
        }
        setWindow(new EditWhitelistModel(this, getSelectedItem()));
    }

    private void remove() {
        if (getConfirmWindow() != null) {
            return;
        }
        setConfirmWindow(new RemoveWhitlistsModel(this, false));
    }
    */

    @Override
    public void executeCommand(UICommand command) {
        super.executeCommand(command);

        if (command == getAddCommand()) {
            add();
        } 
        /*
        else if (command == getEditCommand()) {
            edit();
        } else if (command == getRemoveCommand()) {
            remove();
        }
        */
    }
}