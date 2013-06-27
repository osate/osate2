package edu.uah.rsesc.aadl.age.util;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

public class PropertyUtil {
	private static final String TYPE_NAME_KEY = "type";
	
	public static final String getTypeName(final PictogramElement pe) {
		return Graphiti.getPeService().getPropertyValue(pe, TYPE_NAME_KEY);
	}
	
	public static final void setTypeName(final PictogramElement pe, final String typeName) {
		Graphiti.getPeService().setPropertyValue(pe, TYPE_NAME_KEY, typeName);
	}
}
