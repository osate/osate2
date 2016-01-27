package org.osate.ge.errormodel.pictogramHandlers;

import javax.inject.Named;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.osate.ge.ext.Names;
import org.osate.ge.ext.annotations.CanRefresh;
import org.osate.ge.ext.annotations.Refresh;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;

public class ErrorModelSubclausePictogramHandler {	
	@CanRefresh
	public boolean canRefresh(final @Named(Names.BUSINESS_OBJECT) Object bo) {
		return bo instanceof ErrorModelSubclause;
	}

	@Refresh
	public void refresh(final @Named(Names.CONTAINER) ContainerShape container, final @Named(Names.BUSINESS_OBJECT) ErrorModelSubclause subclause) {
		System.err.println("SC-REFRESH: " + container);
		// TODO
	}
}
