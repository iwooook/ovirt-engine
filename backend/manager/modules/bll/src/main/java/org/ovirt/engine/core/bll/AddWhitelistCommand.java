package org.ovirt.engine.core.bll;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.ovirt.engine.core.bll.context.CommandContext;
import org.ovirt.engine.core.common.action.WhitelistParameters;
import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.core.common.errors.EngineMessage;
import org.ovirt.engine.core.compat.Guid;
import org.ovirt.engine.core.dao.WhitelistDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddWhitelistCommand extends AbstractWhitelistCommand<WhitelistParameters> {

    @Inject
    private WhitelistDao whitelistDao;

    private static final Logger log = LoggerFactory.getLogger(AddWhitelistCommand.class);

    public AddWhitelistCommand(WhitelistParameters parameters, CommandContext commandContext) {
        super(parameters, commandContext);
    }

    @Override
    protected void init() {
        getWhitelist().setId(Guid.newGuid());
        getWhitelist().setUserName(getUserName());
        Date time = new Date();
        getWhitelist().setRegistrationTime(time);
    }

    @Override
    protected void executeCommand() {
        whitelistDao.save(getWhitelist());
        setSucceeded(true);
    }

    @Override
    protected boolean validate() {
        if (!super.validate()) {
            return false;
        }
        // FIXME: Check if same ip address entry exist?
        return true;
    }
}
