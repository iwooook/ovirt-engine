package org.ovirt.engine.core.bll;

import javax.inject.Inject;

import org.ovirt.engine.core.bll.context.CommandContext;
import org.ovirt.engine.core.common.action.WhitelistParameters;
import org.ovirt.engine.core.common.businessentities.VmDevice;
import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.core.common.errors.EngineMessage;
import org.ovirt.engine.core.dao.WhitelistDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoveWhitelistCommand extends AbstractWhitelistCommand<WhitelistParameters> {

    private static final Logger log = LoggerFactory.getLogger(RemoveWhitelistCommand.class);

    @Inject
    private WhitelistDao whitelistDao;

    public RemoveWhitelistCommand(WhitelistParameters parameters, CommandContext commandContext) {
        super(parameters, commandContext);
    }


    @Override
    protected void executeCommand() {
        log.info("RemoveWhitelistCommand, executeCommand() called");
        /*
        for (Whitelist whitelist : getWhitelists()) {
            whitelistDao.remove(whitelist.getId());
        }
        */
        setSucceeded(true);
    }

    @Override
    protected boolean validate() {
        if (!super.validate()) {
            return false;
        }
        // FIXME
        /*
        if (getWatchdogs().isEmpty()) {
            return failValidation(EngineMessage.WATCHDOG_NOT_FOUND);
        }
        */
        return true;
    }

}
