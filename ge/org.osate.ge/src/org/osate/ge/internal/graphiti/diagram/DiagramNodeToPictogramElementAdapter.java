package org.osate.ge.internal.graphiti.diagram;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.osate.ge.internal.diagram.DiagramNode;

// TODO: Rename. Two way map
interface DiagramNodeToPictogramElementAdapter {
	PictogramElement getPictogramElement(DiagramNode diagramNode);
	DiagramNode getDiagramNode(PictogramElement pe);
}
