package org.osate.ge.ext.services.impl;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.ext.services.PictogramElementService;
import org.osate.ge.services.BusinessObjectResolutionService;
import org.osate.ge.services.ConnectionCreationService;
import org.osate.ge.services.ShapeCreationService;

public class DefaultPictogramElementService implements PictogramElementService {
	private final BusinessObjectResolutionService bor;
	private final ShapeCreationService shapeCreationService;
	private final ConnectionCreationService connectionCreationService;
	
	public DefaultPictogramElementService(final BusinessObjectResolutionService bor, final ShapeCreationService shapeCreationService, final ConnectionCreationService connectionCreationService) {
		this.bor = bor;
		this.shapeCreationService = shapeCreationService;
		this.connectionCreationService = connectionCreationService;
	}
	
	@Override
	public Object getBusinessObject(final PictogramElement pe) {
		return bor.getBusinessObjectForPictogramElement(pe);
	}

	@Override
	public final void refreshShapesForBusinessObject(final ContainerShape container, final Object bo) {
		shapeCreationService.createUpdateShape(container, bo);
	}
	
	@Override
	public final void refreshShapesForBusinessObjects(final ContainerShape container, final List<?> bos) {
		shapeCreationService.createUpdateShapes(container, bos, 0, false, 0, 0, false, 0);
	}
	
	@Override
	public void refreshConnectionsForBusinessObjects(final ContainerShape ownerShape, final List<?> bos) {
		connectionCreationService.createUpdateConnections(ownerShape, bos);
	}
}
