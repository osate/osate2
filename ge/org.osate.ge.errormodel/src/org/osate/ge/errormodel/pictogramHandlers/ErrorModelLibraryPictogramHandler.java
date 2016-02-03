package org.osate.ge.errormodel.pictogramHandlers;

import javax.inject.Named;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.osate.ge.ext.Names;
import org.osate.ge.ext.annotations.CanRefresh;
import org.osate.ge.ext.annotations.RefreshShape;
import org.osate.ge.ext.services.PictogramElementService;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;

public class ErrorModelLibraryPictogramHandler {	
	@CanRefresh
	public boolean canRefresh(final @Named(Names.BUSINESS_OBJECT) ErrorModelLibrary lib) {
		return true;
	}

	@RefreshShape
	public void refresh(final @Named(Names.CONTAINER) ContainerShape container, final @Named(Names.BUSINESS_OBJECT) ErrorModelLibrary lib, final PictogramElementService pes) {
		pes.refreshShapesForBusinessObjects(container, lib.getBehaviors());
	}
}
