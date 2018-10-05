package org.osate.ge.internal.diagram.runtime;

public class DiagramNodePredicates {

	public static boolean isDiagramOrUndockedShape(final DiagramNode dstDiagramNode) {
		if (dstDiagramNode instanceof AgeDiagram) {
			return true;
		} else if (dstDiagramNode instanceof DiagramElement) {
			final DiagramElement dstDiagramElement = (DiagramElement) dstDiagramNode;
			return DiagramElementPredicates.isShape(dstDiagramElement)
					&& DiagramElementPredicates.isUndocked(dstDiagramElement);
		} else {
			return false;
		}
	}
}
