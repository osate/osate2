package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public interface PropertyService {

	String getTypeName(PictogramElement pe);

	void setTypeName(PictogramElement pe, String typeName);

	String getName(PictogramElement pe);

	void setName(PictogramElement pe, String typeName);

	// Is on the left side of the container. Defaults to true if there isn't a value assigned to the property
	boolean getIsLeft(PictogramElement pe);

	void setIsLeft(PictogramElement pe, boolean value);

	// If it is layed out such that it is on the left side of the layout container. Defaults to true if there isn't a value assigned to the property
	boolean getIsLeftLayout(PictogramElement pe);

	void setIsLeftLayout(PictogramElement pe, boolean value);

	String getSelectedMode(Diagram diagram);

	void setSelectedMode(Diagram diagram, String modeName);

	String getSelectedFlow(Diagram diagram);

	void setSelectedFlow(Diagram diagram, String flowName);

	boolean isLayedOut(PictogramElement pe);

	void setIsLayedOut(PictogramElement pe, boolean value);

	boolean isGhost(PictogramElement pe);

	void setIsGhost(PictogramElement pe, boolean value);

}