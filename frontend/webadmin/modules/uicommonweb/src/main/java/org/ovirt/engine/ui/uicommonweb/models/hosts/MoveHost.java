package org.ovirt.engine.ui.uicommonweb.models.hosts;

import org.ovirt.engine.core.common.businessentities.VDS;
import org.ovirt.engine.core.common.businessentities.VDSGroup;
import org.ovirt.engine.core.common.businessentities.VDSStatus;
import org.ovirt.engine.core.compat.Event;
import org.ovirt.engine.core.compat.EventArgs;
import org.ovirt.engine.core.compat.Guid;
import org.ovirt.engine.ui.frontend.AsyncQuery;
import org.ovirt.engine.ui.frontend.INewAsyncCallback;
import org.ovirt.engine.ui.uicommonweb.Extensions;
import org.ovirt.engine.ui.uicommonweb.Linq;
import org.ovirt.engine.ui.uicommonweb.dataprovider.AsyncDataProvider;
import org.ovirt.engine.ui.uicommonweb.models.EntityModel;
import org.ovirt.engine.ui.uicommonweb.models.ListModel;
import org.ovirt.engine.ui.uicommonweb.validation.IValidation;
import org.ovirt.engine.ui.uicommonweb.validation.NotEmptyValidation;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class MoveHost extends ListModel
{
    private ListModel privateCluster;

    public ListModel getCluster()
    {
        return privateCluster;
    }

    private void setCluster(ListModel value)
    {
        privateCluster = value;
    }

    private ArrayList<VDS> privateSelectedHosts;

    public ArrayList<VDS> getSelectedHosts()
    {
        return privateSelectedHosts;
    }

    public void setSelectedHosts(ArrayList<VDS> value)
    {
        privateSelectedHosts = value;
    }

    private boolean isMultiSelection = true;

    public boolean isMultiSelection() {
        return isMultiSelection;
    }

    public void setMultiSelection(boolean isMultiSelection) {
        this.isMultiSelection = isMultiSelection;
    }

    public MoveHost()
    {
        setCluster(new ListModel());
        getCluster().getSelectedItemChangedEvent().addListener(this);
    }

    private void Cluster_SelectedItemChanged()
    {
        if (getCluster().getSelectedItem() != null)
        {
            AsyncDataProvider.GetHostList(new AsyncQuery(this, new INewAsyncCallback() {
                @Override
                public void OnSuccess(Object target, Object returnValue) {

                    MoveHost moveHost = (MoveHost) target;
                    ArrayList<VDS> hosts = (ArrayList<VDS>) returnValue;
                    moveHost.PostGetHostList(hosts);
                }
            }));
        }
    }

    private void PostGetHostList(ArrayList<VDS> hosts) {

        VDSGroup cluster = (VDSGroup) getCluster().getSelectedItem();
        ArrayList<VDSGroup> clusters = (ArrayList<VDSGroup>) getCluster().getItems();
        ArrayList<EntityModel> items = new ArrayList<EntityModel>();

        for (VDS vds : hosts)
        {
            if (Linq.FirstOrDefault(clusters, new Linq.ClusterPredicate(vds.getvds_group_id())) == null
                && (vds.getstatus() == VDSStatus.Maintenance || vds.getstatus() == VDSStatus.PendingApproval)
                && (vds.getVersion() == null || Extensions.GetFriendlyVersion(vds.getVersion()).compareTo(cluster.getcompatibility_version()) >= 0))
            {
                EntityModel entity = new EntityModel();
                entity.setEntity(vds);
                items.add(entity);
            }
        }

        ArrayList<Guid> previouslySelectedHostIDs = new ArrayList<Guid>();
        if (getItems() != null)
        {
            for (Object item : getItems())
            {
                EntityModel entity = (EntityModel) item;
                if (entity.getIsSelected())
                {
                    previouslySelectedHostIDs.add(((VDS) entity.getEntity()).getId());
                }
            }
        }
        setItems(items);
        for (EntityModel entity : items)
        {
            entity.setIsSelected(previouslySelectedHostIDs.contains(((VDS) entity.getEntity()).getId()));
        }
    }

    @Override
    public void eventRaised(Event ev, Object sender, EventArgs args)
    {
        super.eventRaised(ev, sender, args);

        if (ev.equals(SelectedItemChangedEventDefinition) && sender == getCluster())
        {
            Cluster_SelectedItemChanged();
        }
    }

    public boolean Validate()
    {
        getCluster().ValidateSelectedItem(new IValidation[] { new NotEmptyValidation() });

        return getCluster().getIsValid();
    }
}
