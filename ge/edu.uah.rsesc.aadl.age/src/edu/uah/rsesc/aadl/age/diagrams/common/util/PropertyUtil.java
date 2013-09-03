package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;

public class PropertyUtil {
	private static final String TYPE_NAME_KEY = "type";
	private static final String NAME_KEY = "name";
	private static final String SIDE_KEY = "side"; // Which side the shape is on
	private static final String LAYOUT_SIDE_KEY = "layout_side"; // Which side the shape is layed out as
	private static final String SELECTED_MODE_KEY = "selected_mode"; // The name of the mode the user has selected in the UI
	private static final String SELECTED_FLOW_KEY = "selected_flowe"; // The name of the flow the user has selected in the UI
	
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
	
	// Is on the left side of the container. Defaults to true if there isn't a value assigned to the property
	public static final boolean getIsLeft(final PictogramElement pe) {
		return !("right".equals(Graphiti.getPeService().getPropertyValue(pe, SIDE_KEY)));
	}
	
	public static final void setIsLeft(final PictogramElement pe, final boolean value) {
		Graphiti.getPeService().setPropertyValue(pe, SIDE_KEY, value ? "left" : "right");
	}
	
	// If it is layed out such that it is on the left side of the layout container. Defaults to true if there isn't a value assigned to the property
	public static final boolean getIsLeftLayout(final PictogramElement pe) {
		return !("right".equals(Graphiti.getPeService().getPropertyValue(pe, LAYOUT_SIDE_KEY)));
	}
	
	public static final void setIsLeftLayout(final PictogramElement pe, final boolean value) {
		Graphiti.getPeService().setPropertyValue(pe, LAYOUT_SIDE_KEY, value ? "left" : "right");
	}
	
	public static final String getSelectedMode(final Diagram diagram) {
		final String modeName = Graphiti.getPeService().getPropertyValue(diagram, SELECTED_MODE_KEY);
		return (modeName == null) ? "" : modeName;
	}
	
	public static final void setSelectedMode(final Diagram diagram, final String modeName) {
		Graphiti.getPeService().setPropertyValue(diagram, SELECTED_MODE_KEY, modeName);
	}
	
	public static final String getSelectedFlow(final Diagram diagram) {
		final String modeName = Graphiti.getPeService().getPropertyValue(diagram, SELECTED_FLOW_KEY);
		return (modeName == null) ? "" : modeName;
	}
	
	public static final void setSelectedFlow(final Diagram diagram, final String flowName) {
		Graphiti.getPeService().setPropertyValue(diagram, SELECTED_FLOW_KEY, flowName);
	}
}
