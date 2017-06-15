package org.osate.ge.internal.diagram.boTree;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.osate.ge.internal.diagram.AgeDiagram;
import org.osate.ge.internal.diagram.DiagramElement;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.internal.diagram.Point;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;

/**
 * Helper class which builds a business object tree from a AgeDiagram
 *
 */
public class DiagramToBusinessObjectTreeConverter {
	public static BusinessObjectNode createBusinessObjectNode(final AgeDiagram diagram) {
		return createBusinessObjectNode(diagram, Collections.emptyMap());
	}
	
	/**
	 * 
	 * @param diagram
	 * @param futureElementPositionMap a mapping from parent DiagramNode objects to a map for which a business object node will be created for each entry with the position specified in the map. 
	 * @return
	 */
	public static BusinessObjectNode createBusinessObjectNode(final AgeDiagram diagram, 
			final Map<DiagramNode, Map<RelativeBusinessObjectReference, Point>> futureElementPositionMap) {
		final BusinessObjectNode rootNode = new BusinessObjectNode(null, null, null, false, null, Completeness.UNKNOWN);
		createBusinessObjectNodesForElements(rootNode, diagram.getDiagramElements(), futureElementPositionMap);
		createBusnessObjectNodesForFutureElements(rootNode, diagram, futureElementPositionMap);
		return rootNode;
	}
	
	public static void createBusnessObjectNodesForFutureElements(final BusinessObjectNode parent, 
			final DiagramNode diagramNode,
			final Map<DiagramNode, Map<RelativeBusinessObjectReference, Point>> futureElementPositionMap) {
		final Map<RelativeBusinessObjectReference, Point> futureElements = futureElementPositionMap.get(diagramNode);
		if(futureElements != null) {
			for(final RelativeBusinessObjectReference ref : futureElements.keySet()) {
				// An incomplete node is created. The tree expander will fill in missing fields.
				if(parent.getChild(ref) == null) {
					new BusinessObjectNode(parent, ref, null, true, null, Completeness.UNKNOWN);
				}
			}
		}
	}
	
	private static void createBusinessObjectNodesForElements(final BusinessObjectNode parent, 
			final Collection<DiagramElement> elements,
			final Map<DiagramNode, Map<RelativeBusinessObjectReference, Point>> futureElementPositionMap) {
		for(final DiagramElement e : elements) {
			final BusinessObjectNode childNode = new BusinessObjectNode(parent, e.getRelativeReference(), e.getBusinessObject(), e.isManual(), e.getAutoContentsFilter(), Completeness.UNKNOWN);
			createBusinessObjectNodesForElements(childNode, e.getDiagramElements(), futureElementPositionMap);
			createBusnessObjectNodesForFutureElements(childNode, e, futureElementPositionMap);
		}
	}
}
