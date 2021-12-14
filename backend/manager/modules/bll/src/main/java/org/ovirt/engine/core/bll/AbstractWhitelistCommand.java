package org.ovirt.engine.core.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.ovirt.engine.core.bll.context.CommandContext;
import org.ovirt.engine.core.bll.utils.PermissionSubject;
import org.ovirt.engine.core.bll.validator.VmWatchdogValidator;
import org.ovirt.engine.core.common.VdcObjectType;
import org.ovirt.engine.core.common.action.WhitelistParameters;
import org.ovirt.engine.core.common.businessentities.Whitelist;
import org.ovirt.engine.core.common.errors.EngineMessage;
import org.ovirt.engine.core.dao.VmDeviceDao;

/**
 * Abstract base-class for whitelist manipulation commands.
 */
public abstract class AbstractWhitelistCommand<T extends WhitelistParameters> extends CommandBase<T> {

    public AbstractWhitelistCommand(T parameters, CommandContext commandContext) {
        super(parameters, commandContext);
    }

    @Override
    public List<PermissionSubject> getPermissionCheckSubjects() {
        List<PermissionSubject> permissionList = new ArrayList<>();
        //permissionList.add(new PermissionSubject(getParameters().getId(),
        //        VdcObjectType.Whitelist,
        //        getActionType().getActionGroup()));
        return permissionList;
    }
}
