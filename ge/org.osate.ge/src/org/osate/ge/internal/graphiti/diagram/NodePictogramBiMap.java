package org.osate.ge.internal.graphiti.diagram;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.internal.diagram.DiagramNode;

public interface NodePictogramBiMap {
	PictogramElement getPictogramElement(DiagramNode diagramNode);
	DiagramNode getDiagramNode(PictogramElement pe);
}
