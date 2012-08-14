package org.ovirt.engine.ui.webadmin.widget.renderer;

import com.google.gwt.text.shared.AbstractRenderer;
import org.ovirt.engine.core.compat.RpmVersion;
import org.ovirt.engine.core.compat.Version;
import org.ovirt.engine.ui.common.widget.renderer.EmptyValueRenderer;
import org.ovirt.engine.ui.uicommonweb.Extensions;
import org.ovirt.engine.ui.webadmin.gin.ClientGinjectorProvider;

public class VersionRenderer extends AbstractRenderer<Version> {

    @Override
    public String render(Version version) {

        String formattedVersion;
        if (version instanceof RpmVersion) {
            formattedVersion = ((RpmVersion) version).getRpmName();
        } else {
            formattedVersion = Extensions.GetFriendlyVersion(version).toString();
        }

        return new EmptyValueRenderer<String>(
            ClientGinjectorProvider.instance().getApplicationConstants().unAvailablePropertyLabel()).render(formattedVersion);
    }
}
