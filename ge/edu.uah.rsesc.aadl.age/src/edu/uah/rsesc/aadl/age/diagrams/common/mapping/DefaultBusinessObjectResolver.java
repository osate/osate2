package edu.uah.rsesc.aadl.age.diagrams.common.mapping;

import org.eclipse.graphiti.features.IMappingProvider;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import edu.uah.rsesc.aadl.age.diagrams.common.AadlElementWrapper;

public class DefaultBusinessObjectResolver implements BusinessObjectResolver {
	private IMappingProvider mappingProvider;
	public DefaultBusinessObjectResolver(final IMappingProvider mp) {
		this.mappingProvider = mp;
	}
	
	@Override
	public Object getBusinessObjectForPictogramElement(PictogramElement pe) {
		return AadlElementWrapper.unwrap(mappingProvider.getBusinessObjectForPictogramElement(pe));
	}
}
