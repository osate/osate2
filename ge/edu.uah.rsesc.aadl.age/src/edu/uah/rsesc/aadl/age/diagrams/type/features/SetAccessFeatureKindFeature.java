package edu.uah.rsesc.aadl.age.diagrams.type.features;

import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroupType;

public class SetAccessFeatureKindFeature 
{

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean canDelete(final IDeleteContext context) {
		final Object containerBo = bor.getBusinessObjectForPictogramElement(((Shape)context.getPictogramElement()).getContainer());

		// The container must be a Feature Group Type or a ComponentType
		return containerBo instanceof FeatureGroupType || containerBo instanceof ComponentType;
	}
}
