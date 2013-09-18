package edu.uah.rsesc.aadl.age.services.impl;

import org.eclipse.graphiti.features.IMappingProvider;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;
import edu.uah.rsesc.aadl.age.services.BusinessObjectResolutionService;

public class DefaultBusinessObjectResolutionService implements BusinessObjectResolutionService {
	private IMappingProvider mappingProvider;
	public DefaultBusinessObjectResolutionService(final IMappingProvider mp) {
		this.mappingProvider = mp;
	}
	
	@Override
	public Object getBusinessObjectForPictogramElement(PictogramElement pe) {
		return AadlElementWrapper.unwrap(mappingProvider.getBusinessObjectForPictogramElement(pe));
	}
}
