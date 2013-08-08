package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

public class PropertyUtil {
	private static final String TYPE_NAME_KEY = "type";
	private static final String NAME_KEY = "name";
	private static final String SIDE_KEY = "side";
	
	public static final String getTypeName(final PictogramElement pe) {
		return Graphiti.getPeService().getPropertyValue(pe, TYPE_NAME_KEY);
	}
	
	public static final void setTypeName(final PictogramElement pe, final String typeName) {
		Graphiti.getPeService().setPropertyValue(pe, TYPE_NAME_KEY, typeName);
	}
	
	public static final String getName(final PictogramElement pe) {
		return Graphiti.getPeService().getPropertyValue(pe, NAME_KEY);
	}
	
	public static final void setName(final PictogramElement pe, final String typeName) {
		Graphiti.getPeService().setPropertyValue(pe, NAME_KEY, typeName);
	}
	
	// Is on the left side of the container
	public static final boolean getIsLeft(final PictogramElement pe) {
		return "left".equals(Graphiti.getPeService().getPropertyValue(pe, SIDE_KEY));
	}
	
	public static final void setIsLeft(final PictogramElement pe, final boolean value) {
		Graphiti.getPeService().setPropertyValue(pe, SIDE_KEY, value ? "left" : "right");
	}
	
}
