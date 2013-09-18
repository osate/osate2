package edu.uah.rsesc.aadl.age.diagrams.common.util.impl;

import java.util.List;

import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.aadl2.Element;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ConnectionCreationService;
import edu.uah.rsesc.aadl.age.diagrams.common.util.ConnectionService;

public class DefaultConnectionCreationService implements ConnectionCreationService {
	private final ConnectionService connectionService;
	private final IFeatureProvider fp;
	
	public DefaultConnectionCreationService(final ConnectionService connectionService, final IFeatureProvider fp) {
		this.connectionService = connectionService;
		this.fp = fp;
	}

	@Override
	public void createUpdateConnections(final ContainerShape ownerShape, final List<? extends Element> elements) {
		for(final Element el : elements) {
			createUpdateConnection(ownerShape, el);
		}
	}
	
	@Override
	public void createUpdateConnection(final ContainerShape ownerShape, final Element el) {
		final PictogramElement pictogramElement = connectionService.getConnection(ownerShape, el);
		if(pictogramElement == null) {			
			final Anchor[] anchors = connectionService.getAnchors(ownerShape, el);
			if(anchors != null) {
				final AddConnectionContext addContext = new AddConnectionContext(anchors[0], anchors[1]);
				addContext.setNewObject(new AadlElementWrapper(el));
				addContext.setTargetContainer(ownerShape);
				
				final IAddFeature addFeature = fp.getAddFeature(addContext);
				if(addFeature != null && addFeature.canAdd(addContext)) {
					addFeature.add(addContext);
				}
			}
		} else {
			final UpdateContext updateContext = new UpdateContext(pictogramElement);
			final IUpdateFeature updateFeature = fp.getUpdateFeature(updateContext);
			
			// Update the connection regardless of whether it is "needed" or not.
			if(updateFeature != null && updateFeature.canUpdate(updateContext)) {
				updateFeature.update(updateContext);
			}
		}
	}
}
