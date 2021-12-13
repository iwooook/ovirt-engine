package org.ovirt.engine.ui.webadmin.section.main.view.popup.whitelist;

import org.gwtbootstrap3.client.ui.Row;
import org.ovirt.engine.core.common.businessentities.OpenStackApiVersionType;
import org.ovirt.engine.core.common.businessentities.OpenStackProtocolType;
import org.ovirt.engine.core.common.businessentities.ProviderType;
import org.ovirt.engine.core.common.businessentities.StoragePool;
import org.ovirt.engine.ui.common.editor.UiCommonEditorDriver;
import org.ovirt.engine.ui.common.idhandler.ElementIdHandler;
import org.ovirt.engine.ui.common.idhandler.WithElementId;
import org.ovirt.engine.ui.common.view.popup.AbstractModelBoundPopupView;
import org.ovirt.engine.ui.common.widget.Align;
import org.ovirt.engine.ui.common.widget.HasUiCommandClickHandlers;
import org.ovirt.engine.ui.common.widget.UiCommandButton;
import org.ovirt.engine.ui.common.widget.dialog.SimpleDialogPanel;
import org.ovirt.engine.ui.common.widget.dialog.tab.DialogTab;
import org.ovirt.engine.ui.common.widget.editor.ListModelListBoxEditor;
import org.ovirt.engine.ui.common.widget.editor.generic.EntityModelCheckBoxEditor;
import org.ovirt.engine.ui.common.widget.editor.generic.ListModelSuggestBoxEditor;
import org.ovirt.engine.ui.common.widget.editor.generic.StringEntityModelPasswordBoxEditor;
import org.ovirt.engine.ui.common.widget.editor.generic.StringEntityModelTextBoxEditor;
import org.ovirt.engine.ui.common.widget.panel.AlertPanel;
import org.ovirt.engine.ui.common.widget.renderer.EnumRenderer;
import org.ovirt.engine.ui.common.widget.renderer.NameRenderer;
import org.ovirt.engine.ui.uicommonweb.models.providers.ProviderModel;
import org.ovirt.engine.ui.uicommonweb.models.whitelists.WhitelistModel;
import org.ovirt.engine.ui.uicompat.ConstantsManager;
import org.ovirt.engine.ui.webadmin.ApplicationConstants;
import org.ovirt.engine.ui.webadmin.gin.AssetProvider;
import org.ovirt.engine.ui.webadmin.section.main.presenter.popup.provider.ProviderPopupPresenterWidget;
import org.ovirt.engine.ui.webadmin.section.main.presenter.popup.whitelist.WhitelistPopupPresenterWidget;
import org.ovirt.engine.ui.webadmin.widget.provider.KVMPropertiesWidget;
import org.ovirt.engine.ui.webadmin.widget.provider.KubevirtPropertiesWidget;
import org.ovirt.engine.ui.webadmin.widget.provider.VmwarePropertiesWidget;
import org.ovirt.engine.ui.webadmin.widget.provider.XENPropertiesWidget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.inject.Inject;

public class WhitelistPopupView extends AbstractModelBoundPopupView<WhitelistModel> implements WhitelistPopupPresenterWidget.ViewDef {

    interface Driver extends UiCommonEditorDriver<WhitelistModel, WhitelistPopupView> {}

    private final Driver driver = GWT.create(Driver.class);

    interface ViewUiBinder extends UiBinder<SimpleDialogPanel, WhitelistPopupView> {
        ViewUiBinder uiBinder = GWT.create(ViewUiBinder.class);
    }

    interface ViewIdHandler extends ElementIdHandler<WhitelistPopupView> {
        ViewIdHandler idHandler = GWT.create(ViewIdHandler.class);
    }

    private static final ApplicationConstants constants = AssetProvider.getConstants();

    @UiField
    @Path(value = "name.entity")
    @WithElementId
    StringEntityModelTextBoxEditor nameEditor;

    @UiField
    @Path(value = "description.entity")
    @WithElementId
    StringEntityModelTextBoxEditor descriptionEditor;

    private WhitelistModel whitelistModel;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Inject
    public WhitelistPopupView(EventBus eventBus) {
        super(eventBus);

        initWidget(ViewUiBinder.uiBinder.createAndBindUi(this));
        ViewIdHandler.idHandler.generateAndSetIds(this);
        driver.initialize(this);
    }

    @Override
    public void edit(WhitelistModel model) {
        whitelistModel = model;
        driver.edit(model);
        /*
        providerModel = model;
        driver.edit(model);
        vmwarePropertiesWidget.edit(model.getVmwarePropertiesModel());
        kvmPropertiesWidget.edit(model.getKvmPropertiesModel());
        xenPropertiesWidget.edit(model.getXenPropertiesModel());
        kubevirtPropertiesWidget.edit(model.getKubevirtPropertiesModel());

        if (model.isEditProviderMode()) {
            setCurrentActiveProviderWidget();
        }

        updatePasswordTitle();
        */
    }

    @Override
    public WhitelistModel flush() {
        return driver.flush();
    }

    @Override
    public void cleanup() {
        driver.cleanup();
    }

    @Override
    public void focusInput() {
        nameEditor.setFocus(true);
    }

    interface Style extends CssResource {
        String contentStyle();
        String headerSeparator();
    }

    @Override
    public int setTabIndexes(int nextTabIndex) {
        nameEditor.setTabIndex(nextTabIndex++);
        descriptionEditor.setTabIndex(nextTabIndex++);
        return nextTabIndex;
    }
}
