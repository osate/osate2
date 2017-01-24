package org.osate.ge.internal.graphiti.features;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.osate.ge.internal.services.PropertyService;

class AgeFeatureUtil {
	public static PictogramElement getLogicalPictogramElement(PictogramElement pe, final PropertyService propertyService){
		while(pe instanceof Shape) {
			if(propertyService.isLogicalTreeNode(pe)) {
				break;
			}
			
			pe = ((Shape)pe).getContainer();
		}
		
		return pe;
	}
}
