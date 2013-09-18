package edu.uah.rsesc.aadl.age.diagrams.common.util;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

public interface VisibilityService {

	void setIsGhost(PictogramElement pe, boolean isGhost);

	List<Shape> getNonGhostChildren(ContainerShape shape);

}