package org.osate.ge.errormodel.pictogramHandlers;

import javax.inject.Named;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.osate.ge.ext.Names;
import org.osate.ge.ext.annotations.CanRefresh;
import org.osate.ge.ext.annotations.Refresh;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;

public class ErrorModelLibraryPictogramHandler {	
	@CanRefresh
	public boolean canRefresh(final @Named(Names.BUSINESS_OBJECT) Object bo) {
		System.err.println("CAN REFRESH: " + bo);
		return bo instanceof ErrorModelLibrary;
	}

	@Refresh
	public void refresh(final @Named(Names.CONTAINER) ContainerShape container, final @Named(Names.BUSINESS_OBJECT) ErrorModelLibrary lib) {
		System.err.println("REFRESH: " + container);
		// TODO
	}
}
