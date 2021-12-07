package org.ovirt.engine.ui.webadmin.section.main.presenter.tab.whitelist;

import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.ui.common.presenter.AbstractMainSelectedItems;
import org.ovirt.engine.ui.webadmin.section.main.presenter.WhitelistSelectionChangeEvent;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;

public class WhitelistMainSelectedItems extends AbstractMainSelectedItems<Whitelist>
    implements WhitelistSelectionChangeEvent.WhitelistSelectionChangeHandler {

    @Inject
    WhitelistMainSelectedItems(EventBus eventBus) {
        //This is singleton, so won't leak handlers.
        eventBus.addHandler(WhitelistSelectionChangeEvent.getType(), this);
    }

    @Override
    public void onWhitelistSelectionChange(WhitelistSelectionChangeEvent event) {
        selectedItemsChanged(event.getSelectedItems());
    }
}
