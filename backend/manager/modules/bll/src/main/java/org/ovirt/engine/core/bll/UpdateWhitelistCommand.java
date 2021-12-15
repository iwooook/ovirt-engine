package org.ovirt.engine.core.bll;

import java.util.List;

import javax.inject.Inject;

import org.ovirt.engine.core.bll.context.CommandContext;
import org.ovirt.engine.core.common.action.WhitelistParameters;
import org.ovirt.engine.core.common.businessentities.VmDevice;
import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.core.common.errors.EngineMessage;
import org.ovirt.engine.core.dao.WhitelistDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ValidateSupportsTransaction
public class UpdateWhitelistCommand extends AbstractWhitelistCommand<WhitelistParameters> {

    private static final Logger log = LoggerFactory.getLogger(UpdateWhitelistCommand.class);

    @Inject
    private WhitelistDao whitelistDao;

    public UpdateWhitelistCommand(WhitelistParameters parameters, CommandContext commandContext) {
        super(parameters, commandContext);
    }

    @Override
    protected void executeCommand() {
        // FIXME
        log.info("UpdateWhitelistCommand, executeCommand() called");
        setSucceeded(true);
    }

    @Override
    protected boolean validate() {
        if (!super.validate()) {
            return false;
        }
        /*
        List<VmDevice> watchdogs = getWatchdogs();
        if (watchdogs.isEmpty()) {
            return failValidation(EngineMessage.WATCHDOG_NOT_FOUND);
        }

        if (!validate(validateWatchdog())) {
            return false;
        }
        */
        return true;
    }

}
