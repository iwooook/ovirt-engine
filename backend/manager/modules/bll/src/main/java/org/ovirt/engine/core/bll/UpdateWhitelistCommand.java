package org.ovirt.engine.core.bll;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.ovirt.engine.core.bll.context.CommandContext;
import org.ovirt.engine.core.common.action.WhitelistParameters;
import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.core.common.errors.EngineMessage;
import org.ovirt.engine.core.common.AuditLogType;
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
    protected void init() {
        getWhitelist().setUserName(getUserName());
        Date time = new Date();
        getWhitelist().setRegistrationTime(time);
    }

    @Override
    protected void executeCommand() {
        whitelistDao.update(getWhitelist());
        setSucceeded(true);
    }

    @Override
    protected boolean validate() {
        if (!super.validate()) {
            return false;
        }
        // Check if same ip address entry exists
        Whitelist whitelist = whitelistDao.getByIpAddress(getWhitelist().getIpAddress());
        if (whitelist != null) {
            return failValidation(EngineMessage.WHITELIST_ALREADY_EXISTS);
        }
        return true;
    }

    @Override
    public AuditLogType getAuditLogTypeValue() {
        return getSucceeded() ? AuditLogType.WHITELIST_UPDATED : AuditLogType.WHITELIST_UPDATE_FAILED;
    }
}
