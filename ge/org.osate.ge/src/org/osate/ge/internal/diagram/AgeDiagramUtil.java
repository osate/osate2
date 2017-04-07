package org.osate.ge.internal.diagram;

import org.osate.ge.internal.DockingPosition;
import org.osate.ge.internal.services.ReferenceService;

public class AgeDiagramUtil {
	public static DockingPosition determineDockingPosition(final DiagramNode container, final int x, final int y, final int width, final int height) {
		if(!(container instanceof DiagramElement)) {
			return DockingPosition.ANY;
		}		
		
		final DiagramElement containerElement = (DiagramElement)container;
		
		final int distanceToLeft = Math.max(0, x);
		final int distanceToRight = containerElement.getWidth() - Math.min(x + width, containerElement.getWidth());
		final int distanceToTop = Math.max(0, y);
		final int distanceToBottom = containerElement.getHeight() - Math.min(y + height, containerElement.getHeight());

		// Find the closest dock area while giving priority to the left, right, top, and bottom.
		if(distanceToLeft <= distanceToRight && distanceToLeft <= distanceToTop && distanceToLeft <= distanceToBottom) {
			return DockingPosition.LEFT;
		} else if(distanceToRight <= distanceToTop && distanceToRight <= distanceToBottom) {
			return DockingPosition.RIGHT;
		} else if(distanceToTop <= distanceToBottom) {
			return DockingPosition.TOP;
		} else {
			return DockingPosition.BOTTOM;
		}
	}

	// Diagrams are no longer directly associated with a business object. Use the diagram configuration to determine the diagram business object.
	// This function returns the business object references by the diagram's configuration. Will return null if the object cannot be found
	// or if the configuration does not reference a business object.
	public static Object getConfigurationBusinessObject(final AgeDiagram diagram, final ReferenceService referenceService) {
		final CanonicalBusinessObjectReference rootBoReference = diagram.getConfiguration().getRootBoReference();
		final Object diagramBo;
		if(rootBoReference == null) {
			diagramBo = null;
		} else {
			diagramBo = referenceService.resolve(rootBoReference);
		}
		
		return diagramBo;
	}
}
