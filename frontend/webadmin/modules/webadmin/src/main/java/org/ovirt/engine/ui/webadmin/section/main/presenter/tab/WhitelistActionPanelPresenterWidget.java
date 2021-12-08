package org.ovirt.engine.ui.webadmin.section.main.presenter.tab;

import javax.inject.Inject;

import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.core.common.businessentities.Quota;
import org.ovirt.engine.ui.common.presenter.ActionPanelPresenterWidget;
import org.ovirt.engine.ui.common.uicommon.model.MainModelProvider;
import org.ovirt.engine.ui.uicommonweb.UICommand;
import org.ovirt.engine.ui.uicommonweb.models.whitelists.WhitelistListModel;
import org.ovirt.engine.ui.uicommonweb.models.quota.QuotaListModel;
import org.ovirt.engine.ui.webadmin.ApplicationConstants;
import org.ovirt.engine.ui.webadmin.gin.AssetProvider;
import org.ovirt.engine.ui.webadmin.widget.action.WebAdminButtonDefinition;

import com.google.web.bindery.event.shared.EventBus;

public class WhitelistActionPanelPresenterWidget<E> extends ActionPanelPresenterWidget<E, Whitelist, WhitelistListModel> {

    private static final ApplicationConstants constants = AssetProvider.getConstants();

    private WebAdminButtonDefinition<E, Whitelist> newButtonDefinition;

    @Inject
    public WhitelistActionPanelPresenterWidget(EventBus eventBus,
            ActionPanelPresenterWidget.ViewDef<E, Whitelist> view,
            MainModelProvider<Whitelist, WhitelistListModel> dataProvider) {
        super(eventBus, view, dataProvider);
    }

    @Override
    protected void initializeButtons() {
        
        newButtonDefinition = new WebAdminButtonDefinition<E, Whitelist>(constants.addWhitelist()) {
            @Override
            protected UICommand resolveCommand() {
                return getModel().getCreateCommand();
            }
        };
        /*
        addActionButton(newButtonDefinition);
        addActionButton(new WebAdminButtonDefinition<E, Quota>(constants.editQuota()) {
            @Override
            protected UICommand resolveCommand() {
                return getModel().getEditCommand();
            }
        });
        addActionButton(new WebAdminButtonDefinition<E, Quota>(constants.copyQuota()) {
            @Override
            protected UICommand resolveCommand() {
                return getModel().getCloneCommand();
            }
        });
        addActionButton(new WebAdminButtonDefinition<E, Quota>(constants.removeQuota()) {
            @Override
            protected UICommand resolveCommand() {
                return getModel().getRemoveCommand();
            }
        });
        */
    }

    public WebAdminButtonDefinition<E, Whitelist> getNewButtonDefinition() {
        return newButtonDefinition;
    }
}
