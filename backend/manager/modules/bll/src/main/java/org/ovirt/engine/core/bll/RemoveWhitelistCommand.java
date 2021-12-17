package org.ovirt.engine.core.bll;

import javax.inject.Inject;

import org.ovirt.engine.core.bll.context.CommandContext;
import org.ovirt.engine.core.common.action.WhitelistParameters;
import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.core.common.errors.EngineMessage;
import org.ovirt.engine.core.common.AuditLogType;
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
        whitelistDao.remove(getWhitelist().getId());
        setSucceeded(true);
    }

    @Override
    public AuditLogType getAuditLogTypeValue() {
        return getSucceeded() ? AuditLogType.WHITELIST_REMOVED : AuditLogType.WHITELIST_REMOVAL_FAILED;
    }
}
