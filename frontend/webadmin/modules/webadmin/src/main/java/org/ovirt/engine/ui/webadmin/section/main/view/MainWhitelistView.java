package org.ovirt.engine.ui.webadmin.section.main.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;

import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.core.common.businessentities.Quota;
import org.ovirt.engine.core.common.businessentities.QuotaCluster;
import org.ovirt.engine.core.common.businessentities.QuotaStorage;
import org.ovirt.engine.core.common.utils.SizeConverter;
import org.ovirt.engine.core.searchbackend.QuotaConditionFieldAutoCompleter;
import org.ovirt.engine.core.searchbackend.WhitelistConditionFieldAutoCompleter;
import org.ovirt.engine.ui.common.idhandler.ElementIdHandler;
import org.ovirt.engine.ui.common.presenter.FragmentParams;
import org.ovirt.engine.ui.common.uicommon.model.MainModelProvider;
import org.ovirt.engine.ui.common.widget.renderer.DiskSizeRenderer;
import org.ovirt.engine.ui.common.widget.table.column.AbstractLinkColumn;
import org.ovirt.engine.ui.common.widget.table.column.AbstractTextColumn;
import org.ovirt.engine.ui.uicommonweb.models.whitelists.WhitelistListModel;
import org.ovirt.engine.ui.uicommonweb.models.quota.QuotaListModel;
import org.ovirt.engine.ui.uicommonweb.place.WebAdminApplicationPlaces;
import org.ovirt.engine.ui.webadmin.ApplicationConstants;
import org.ovirt.engine.ui.webadmin.ApplicationMessages;
import org.ovirt.engine.ui.webadmin.gin.AssetProvider;
import org.ovirt.engine.ui.webadmin.section.main.presenter.MainWhitelistPresenter;
import org.ovirt.engine.ui.webadmin.section.main.presenter.MainQuotaPresenter;
import org.ovirt.engine.ui.webadmin.widget.table.column.AbstractQuotaPercentColumn;
import org.ovirt.engine.ui.webadmin.widget.table.column.QuotaDcStatusColumn;

import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.inject.Inject;

public class MainWhitelistView extends AbstractMainWithDetailsTableView<Whitelist, WhitelistListModel> 
        implements MainWhitelistPresenter.ViewDef {

    interface ViewIdHandler extends ElementIdHandler<MainWhitelistView> {
        ViewIdHandler idHandler = GWT.create(ViewIdHandler.class);
    }

    private static final ApplicationConstants constants = AssetProvider.getConstants();

    @Inject
    public MainWhitelistView(MainModelProvider<Whitelist, WhitelistListModel> modelProvider) {
        super(modelProvider);
        ViewIdHandler.idHandler.generateAndSetIds(this);
        initTable();
        initWidget(getTable());
    }

    void initTable() {
        getTable().enableColumnResizing();

        AbstractTextColumn<Whitelist> whitelistDbIdColumn =
                new AbstractTextColumn<Whitelist>() {
                    @Override
                    public String getValue(Whitelist whitelist) {
                        return whitelist.getId().toString();
                    }
                };
        whitelistDbIdColumn.makeSortable(WhitelistConditionFieldAutoCompleter.WHITELIST_DB_ID);
        getTable().addColumn(whitelistDbIdColumn, constants.whitelistDbId(), "200px"); //$NON-NLS-1$

        AbstractTextColumn<Whitelist> ipAddressColumn =
                new AbstractTextColumn<Whitelist>() {
                    @Override
                    public String getValue(Whitelist whitelist) {
                        return whitelist.getIpAddress();
                    }
                };
        ipAddressColumn.makeSortable(WhitelistConditionFieldAutoCompleter.IP_ADDRESS);
        getTable().addColumn(ipAddressColumn, constants.whitelistIpAddr(), "200px"); //$NON-NLS-1$

        AbstractTextColumn<Whitelist> userNameColumn =
                new AbstractTextColumn<Whitelist>() {
                    @Override
                    public String getValue(Whitelist whitelist) {
                        return whitelist.getUserName();
                    }
                };
        userNameColumn.makeSortable(WhitelistConditionFieldAutoCompleter.USER_NAME);
        getTable().addColumn(userNameColumn, constants.whitelistUser(), "200px"); //$NON-NLS-1$

        AbstractTextColumn<Whitelist> descriptionColumn =
        new AbstractTextColumn<Whitelist>() {
            @Override
            public String getValue(Whitelist whitelist) {
                return whitelist.getUserName();
            }
        };
        descriptionColumn.makeSortable(WhitelistConditionFieldAutoCompleter.USER_NAME);
        getTable().addColumn(descriptionColumn, constants.whitelistDescription(), "200px"); //$NON-NLS-1$
        
        final DateTimeFormat dateFormat = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_TIME_MEDIUM);

        AbstractTextColumn<Whitelist> registrationTimeColumn =
                new AbstractTextColumn<Whitelist>() {
                    @Override
                    public String getValue(Whitelist whitelist) {
                        return whitelist.getRegistrationTime() == null ?
                                "" : //$NON-NLS-1$
                                dateFormat.format(whitelist.getRegistrationTime());
                    }
                };
        registrationTimeColumn.makeSortable(Comparator.comparing(Whitelist::getRegistrationTime));
        getTable().addColumn(registrationTimeColumn, constants.sessionStartTime(), "200px"); //$NON-NLS-1$
    }
}
