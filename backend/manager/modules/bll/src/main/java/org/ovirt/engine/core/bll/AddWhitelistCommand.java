package org.ovirt.engine.core.bll;

import java.util.List;

import javax.inject.Inject;

import org.ovirt.engine.core.bll.context.CommandContext;
import org.ovirt.engine.core.bll.utils.PermissionSubject;
import org.ovirt.engine.core.bll.utils.VmDeviceUtils;
import org.ovirt.engine.core.common.action.WatchdogParameters;
import org.ovirt.engine.core.common.action.WhitelistParameters;
import org.ovirt.engine.core.common.businessentities.VmDevice;
import org.ovirt.engine.core.common.errors.EngineMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//public class AddWhitelistCommand extends AbstractVmWatchdogCommand<WatchdogParameters> {
public class AddWhitelistCommand extends AbstractWhitelistCommand<WhitelistParameters> {

    private static final Logger log = LoggerFactory.getLogger(AddWhitelistCommand.class);

    public AddWhitelistCommand(WhitelistParameters parameters, CommandContext commandContext) {
        super(parameters, commandContext);
    }

    @Override
    protected void executeCommand() {
        log.info("AddWhitelistCommand, executeCommand()");
        setSucceeded(true);
    }
}
