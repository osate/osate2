package org.osate.ge.ext.services.impl;

import org.eclipse.graphiti.features.IMappingProvider;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.aadl2.Element;
import org.osate.ge.diagrams.common.AadlElementWrapper;
import org.osate.ge.ext.services.BusinessObjectService;
import org.osate.ge.services.BusinessObjectResolutionService;

public class DefaultBusinessObjectService implements BusinessObjectService {
	private final BusinessObjectResolutionService bor;
	private IMappingProvider mappingProvider; // TODO: Remove if not needed

	public DefaultBusinessObjectService(final BusinessObjectResolutionService bor, final IMappingProvider mappingProvider) {
		this.bor = bor;
		this.mappingProvider = mappingProvider;
	}
	
	@Override
	public Object getBusinessObject(final PictogramElement pe) {
		return bor.getBusinessObjectForPictogramElement(pe);
	}

	// TODO: Remove if not needed
	/*
	@Override
	public void link(final PictogramElement pe, final Object bo) {
		this.mappingProvider.link(pe, bo instanceof Element ? new AadlElementWrapper((Element)bo) : bo);
	}
	*/
}
