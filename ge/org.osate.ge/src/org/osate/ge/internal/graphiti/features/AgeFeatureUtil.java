package org.osate.ge.internal.graphiti.features;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.internal.query.AncestorUtil;
import org.osate.ge.internal.services.ConnectionService;
import org.osate.ge.internal.services.PropertyService;

public class AgeFeatureUtil {
	public static PictogramElement getLogicalPictogramElement(PictogramElement pe, final PropertyService propertyService, final ConnectionService connectionService){
		if(pe == null) {
			return null;
		}
		
		if(propertyService.isLogicalTreeNode(pe)) {
			return pe;
		}
		
		//TODO: Migrate! return AncestorUtil.getParent(pe, propertyService, connectionService);
		return null;
	}
}
