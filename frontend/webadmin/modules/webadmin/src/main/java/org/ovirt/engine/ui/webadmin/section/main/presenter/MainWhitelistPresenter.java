package org.ovirt.engine.ui.webadmin.section.main.presenter;

import java.util.List;

import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.core.common.businessentities.Quota;
import org.ovirt.engine.ui.common.place.PlaceRequestFactory;
import org.ovirt.engine.ui.common.presenter.WhitelistBreadCrumbsPresenterWidget;
import org.ovirt.engine.ui.common.presenter.QuotaBreadCrumbsPresenterWidget;
import org.ovirt.engine.ui.common.uicommon.model.MainModelProvider;
import org.ovirt.engine.ui.uicommonweb.models.whitelists.WhitelistListModel;
import org.ovirt.engine.ui.uicommonweb.models.quota.QuotaListModel;
import org.ovirt.engine.ui.uicommonweb.place.WebAdminApplicationPlaces;
import org.ovirt.engine.ui.webadmin.section.main.presenter.tab.WhitelistActionPanelPresenterWidget;
import org.ovirt.engine.ui.webadmin.section.main.presenter.tab.QuotaActionPanelPresenterWidget;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.annotation.GenEvent;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class MainWhitelistPresenter extends AbstractMainWithDetailsPresenter<Whitelist, WhitelistListModel, MainWhitelistPresenter.ViewDef, MainWhitelistPresenter.ProxyDef> {

    @GenEvent
    public class QuotaSelectionChange {

        List<Quota> selectedItems;

    }

    @ProxyCodeSplit
    @NameToken(WebAdminApplicationPlaces.quotaMainPlace)
    public interface ProxyDef extends ProxyPlace<MainWhitelistPresenter> {
    }

    public interface ViewDef extends AbstractMainWithDetailsPresenter.ViewDef<Whitelist> {
    }

    @Inject
    public MainWhitelistPresenter(EventBus eventBus, ViewDef view, ProxyDef proxy,
            PlaceManager placeManager, MainModelProvider<Whitelist, WhitelistListModel> modelProvider,
            SearchPanelPresenterWidget<Whitelist, WhitelistListModel> searchPanelPresenterWidget,
            WhitelistBreadCrumbsPresenterWidget breadCrumbs,
            WhitelistActionPanelPresenterWidget<Void> actionPanel) {
        super(eventBus, view, proxy, placeManager, modelProvider, searchPanelPresenterWidget, breadCrumbs, actionPanel);
    }

    @Override
    protected void fireTableSelectionChangeEvent() {
        //QuotaSelectionChangeEvent.fire(this, getSelectedItems());
    }

    @Override
    protected PlaceRequest getMainViewRequest() {
        return PlaceRequestFactory.get(WebAdminApplicationPlaces.quotaMainPlace);
    }

}
