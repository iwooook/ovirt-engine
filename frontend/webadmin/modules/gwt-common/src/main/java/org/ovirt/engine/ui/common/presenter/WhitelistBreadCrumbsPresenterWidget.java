package org.ovirt.engine.ui.common.presenter;

import javax.inject.Inject;

import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.ui.common.uicommon.model.MainModelProvider;
import org.ovirt.engine.ui.uicommonweb.models.whitelists.WhitelistListModel;

import com.google.web.bindery.event.shared.EventBus;

public class WhitelistBreadCrumbsPresenterWidget extends OvirtBreadCrumbsPresenterWidget<Whitelist, WhitelistListModel> {

    public interface QuotaBreadCrumbsViewDef extends OvirtBreadCrumbsPresenterWidget.ViewDef<Whitelist> {
    }

    @Inject
    public WhitelistBreadCrumbsPresenterWidget(EventBus eventBus, QuotaBreadCrumbsViewDef view,
            MainModelProvider<Whitelist, WhitelistListModel> listModelProvider) {
        super(eventBus, view, listModelProvider);
    }

}
