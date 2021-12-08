package org.ovirt.engine.ui.common.view;

import javax.inject.Inject;

import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.ui.common.presenter.WhitelistBreadCrumbsPresenterWidget.WhitelistBreadCrumbsViewDef;
import org.ovirt.engine.ui.common.uicommon.model.MainModelProvider;
import org.ovirt.engine.ui.common.widget.MenuDetailsProvider;
import org.ovirt.engine.ui.uicommonweb.models.whitelists.WhitelistListModel;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

public class WhitelistBreadCrumbsView extends OvirtBreadCrumbsView<Whitelist, WhitelistListModel> implements WhitelistBreadCrumbsViewDef {

    @Inject
    public WhitelistBreadCrumbsView(MenuDetailsProvider menu, MainModelProvider<Whitelist, WhitelistListModel> listModelProvider) {
        super(listModelProvider, menu);
    }

    @Override
    public SafeHtml getName(Whitelist item) {
        SafeHtmlBuilder builder = new SafeHtmlBuilder();
        builder.append(super.getName(item));
        builder.appendEscaped(" ("); // $NON-NLS-1$
        builder.appendEscaped(item.getStoragePoolName());
        builder.appendEscaped(")"); // $NON-NLS-1$
        return builder.toSafeHtml();
    }

}
