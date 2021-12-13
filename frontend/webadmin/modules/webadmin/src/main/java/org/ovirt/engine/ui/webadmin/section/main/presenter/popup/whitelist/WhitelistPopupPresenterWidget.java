package org.ovirt.engine.ui.webadmin.section.main.presenter.popup.whitelist;

import org.ovirt.engine.ui.common.presenter.AbstractModelBoundPopupPresenterWidget;
import org.ovirt.engine.ui.common.widget.HasUiCommandClickHandlers;
import org.ovirt.engine.ui.uicommonweb.models.providers.ProviderModel;
import org.ovirt.engine.ui.uicommonweb.models.whitelists.WhitelistModel;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.Inject;

public class WhitelistPopupPresenterWidget extends AbstractModelBoundPopupPresenterWidget<WhitelistModel, WhitelistPopupPresenterWidget.ViewDef> {

    private static final String IS_AVAILABLE = "IsAvailable"; //$NON-NLS-1$

    public interface ViewDef extends AbstractModelBoundPopupPresenterWidget.ViewDef<WhitelistModel> {
        HasUiCommandClickHandlers getTestButton();
        void setTestResult(String errorMessage);
        void setCurrentActiveProviderWidget();
        void updatePasswordTitle();
    }

    @Inject
    public WhitelistPopupPresenterWidget(EventBus eventBus, ViewDef view) {
        super(eventBus, view);
    }

    @Override
    public void init(final WhitelistModel model) {
        super.init(model);

        /*
        registerHandler(getView().getTestButton().addClickHandler(event -> model.getTestCommand().execute()));

        model.getTestResult().getEntityChangedEvent().addListener((ev, sender, args) ->
                getView().setTestResult(model.getTestResult().getEntity()));
        model.getDataCenter().getPropertyChangedEvent().addListener((ev, sender, args) -> {
            if (IS_AVAILABLE.equals(args.propertyName)) {
                getView().setCurrentActiveProviderWidget();
            }
        });
        model.getKvmPropertiesModel().getPropertyChangedEvent().addListener((ev, sender, args) -> {
            if (IS_AVAILABLE.equals(args.propertyName)) {
                getView().setCurrentActiveProviderWidget();
            }
        });
        model.getVmwarePropertiesModel().getPropertyChangedEvent().addListener((ev, sender, args) -> {
            if (IS_AVAILABLE.equals(args.propertyName)) {
                getView().setCurrentActiveProviderWidget();
            }
        });
        model.getXenPropertiesModel().getPropertyChangedEvent().addListener((ev, sender, args) -> {
            if (IS_AVAILABLE.equals(args.propertyName)) {
                getView().setCurrentActiveProviderWidget();
            }
        });
        model.getNeutronAgentModel().getPropertyChangedEvent().addListener((ev, sender, args) -> {
            if (IS_AVAILABLE.equals(args.propertyName)) {
                getView().setCurrentActiveProviderWidget();
            }
        });
        model.getKubevirtPropertiesModel().getPropertyChangedEvent().addListener((ev, sender, args) -> {
            if (IS_AVAILABLE.equals(args.propertyName)) {
                getView().setCurrentActiveProviderWidget();
            }
        });
        model.getType().getSelectedItemChangedEvent().addListener((ev, sender, args) -> {
            getView().updatePasswordTitle();
        });
        */
    }

}
