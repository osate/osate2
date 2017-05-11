package org.osate.ge.internal.diagram.updating;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.osate.ge.internal.AgeGraphicalConfiguration;
import org.osate.ge.internal.DockArea;
import org.osate.ge.internal.DockingPosition;
import org.osate.ge.internal.diagram.AgeDiagram;
import org.osate.ge.internal.diagram.ContentsFilter;
import org.osate.ge.internal.diagram.DiagramElement;
import org.osate.ge.internal.diagram.DiagramModification;
import org.osate.ge.internal.diagram.DiagramModifier;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.internal.diagram.Point;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.boTree.BusinessObjectNode;
import org.osate.ge.internal.diagram.boTree.Completeness;
import org.osate.ge.internal.diagram.boTree.TreeExpander;
import org.osate.ge.internal.graphics.AgeConnection;

/**
 * Updates the diagram's elements based on the diagram configuration.
 * The DiagramUpdater updates the diagram using information provided by objects passed into the constructor.
 */
public class DiagramUpdater {	
	private final TreeExpander boTreeExpander;
	private final DiagramElementInformationProvider infoProvider;
	
	private final Map<DiagramNode, Map<RelativeBusinessObjectReference, DiagramElement>> containerToRelativeReferenceToGhostMap = new HashMap<>();
	
	// Holds information regarding diagram elements which have not been created. The DiagramNode is the parent of the new element.
	// The Point is the position. It may be null to indicate that an element should be added as a manually added element but that a position hasn't been specified.
	private final Map<DiagramNode, Map<RelativeBusinessObjectReference, Point>> futureElementPositionMap = new HashMap<>(); 

	public DiagramUpdater(final TreeExpander boTreeExpander, 
			final DiagramElementInformationProvider infoProvider) {
		this.boTreeExpander = Objects.requireNonNull(boTreeExpander, "boTreeExpander must not be null");
		this.infoProvider = Objects.requireNonNull(infoProvider, "infoProvider must not be null"); // Adjust message after rename
	}

	/**
	 * Add a position to be used for the initial position for the next element that is created with the specified canonical reference. 
	 * All future positions are cleared after each update.
	 * @param ref
	 * @param newElementPosition
	 */
	public void addToNextUpdate(final DiagramNode parentDiagramNode, 
			final RelativeBusinessObjectReference ref, 
			final Point newElementPosition) {
		Map<RelativeBusinessObjectReference, Point> m = futureElementPositionMap.get(parentDiagramNode);
		if(m == null) {
			m = new HashMap<>();
			futureElementPositionMap.put(parentDiagramNode, m);
		}
		m.put(ref, newElementPosition);
	}	

	// Updates the diagram.
	// As part of the update process the auto content filter settings may be cleared for non-manual nodes.
	public void updateDiagram(final AgeDiagram diagram) {
		// Create an updated business object tree based on the current state of the diagram and pending elements
		BusinessObjectNode tmpTree = createBusinessObjectNode(diagram, futureElementPositionMap);
		tmpTree = BusinessObjectNode.pruneAutomaticBranches(tmpTree);		
		final BusinessObjectNode tree = boTreeExpander.expandTree(diagram.getConfiguration(), tmpTree);
		updateDiagram(diagram, tree);
	}
	
	public void updateDiagram(final AgeDiagram diagram, final BusinessObjectNode tree) {
		final List<DiagramElement> connectionElements = new LinkedList<>();
		
		diagram.modify(new DiagramModifier() {
			@Override
			public void modify(final DiagramModification m) {
				// Update the structure. By doing this in a separate pass, updateElements() will have access to the complete diagram structure. 
				// However, connections will later be purged from the diagram if they do not refer to valid elements.
				updateStructure(m, diagram, tree.getChildren());
				
				updateElements(m, diagram, tree.getChildren(), connectionElements);
				removeInvalidConnections(m, connectionElements);
			}			
		});

		// Remove all entries from the future elements map regardless of whether they were created or not. This ensures that unused positions aren't retained indefinitely
		futureElementPositionMap.clear();		
	}
	
	/**
	 * Updates the structure of the diagram based on the business object tree.
	 * Creates/Unghosts elements to match the business object tree. Ghosts diagram elements which are not in the diagram element tree.
	 * @param m
	 * @param container
	 * @param bos
	 */
	private void updateStructure(final DiagramModification m, final DiagramNode container, final Collection<BusinessObjectNode> bos) {
		final Map<RelativeBusinessObjectReference, Point> futureElementPositions = futureElementPositionMap.get(container);
		for(final BusinessObjectNode n : bos) {
			// Get existing element if it exists.
			DiagramElement element = container.getByRelativeReference(n.getRelativeReference());
			
			// Create the element if it does not exist
			if(element == null) {
				final DiagramElement removedGhost = removeGhost(container, n.getRelativeReference());
				if(removedGhost == null) {
					final Point initialPosition = futureElementPositions == null ? null : futureElementPositions.get(n.getRelativeReference());
					final Object boh = infoProvider.getApplicableBusinessObjectHandler(n.getBusinessObject());
					if(boh == null) {
						// TODO: Proper way of handling?
						continue;
					}

					element = new DiagramElement(container, n.getBusinessObject(), boh, n.getRelativeReference(), initialPosition);
				} else {
					element = removedGhost;
					m.updateBusinessObjectWithSameRelativeReference(element, n.getBusinessObject());
				}
				
				m.addElement(element);
			} else {
				// Update the business object. Although the reference matches. The business object may be new.
				m.updateBusinessObjectWithSameRelativeReference(element, n.getBusinessObject());
			}
			
			// Update the element's children
			updateStructure(m, element, n.getChildren());
		}
		
		// Remove elements whose business objects are not in the business object tree
		// At this point, it is assumed that there is a diagram element for each business object. Elements that are incomplete may be pruned later.
		// If the collections are the same size, there is nothing to remove
		if(bos.size() != container.getDiagramElements().size()) {
			// Build Set of Relative References of All the Objects in the Business Object Tree
			final Set<RelativeBusinessObjectReference> boTreeRelativeReferenceSet = bos.stream().map((n) -> n.getRelativeReference()).collect(Collectors.toCollection(HashSet::new));
			Iterator<DiagramElement> childrenIt = container.getDiagramElements().iterator();
			while(childrenIt.hasNext()) {
				final DiagramElement child = childrenIt.next();
				if(!boTreeRelativeReferenceSet.contains(child.getRelativeReference())) {
					ghostAndRemove(m, child);
				}
			}
		}
	}
	
	/**
	 * Ghosts and removes an element. Updates the parent's complete state.
	 * @param m
	 * @param e
	 */
	private void ghostAndRemove( final DiagramModification m, final DiagramElement e) {
		addGhost(e);
		m.removeElement(e);
		if(e.getParent() instanceof DiagramElement) {
			m.setCompleteness((DiagramElement)e.getParent(), Completeness.INCOMPLETE);
		}
	}
	
	/**
	 * 
	 * @param container is the container for which to update the elements
	 * @param bos 
	 * @param connectionElements is a collection to populate with connection elements.
	 */
	private void updateElements(final DiagramModification m, final DiagramNode container, final Collection<BusinessObjectNode> bos, final Collection<DiagramElement> connectionElements) {
		for(final BusinessObjectNode n : bos) {
			// Get existing element. The updateStructure() pass should have ensured that it exists.
			DiagramElement element = Objects.requireNonNull(container.getByRelativeReference(n.getRelativeReference()), "unable to retrieve element");

			// Set fields
			m.setAutoContentsFilter(element, n.getAutoContentsFilter());
			m.setManual(element, n.isManual());
			m.setCompleteness(element, n.getCompleteness());
			
			// Set the name
			m.setName(element, infoProvider.getName(element)); // TODO: Should be fetched from somewhere else
			
			// Set the graphical Configuration
			final AgeGraphicalConfiguration graphicalConfiguration = infoProvider.getGraphicalConfiguration(element);
			if(graphicalConfiguration == null) {
				ghostAndRemove(m, element);
			} else {
				m.setGraphicalConfiguration(element, graphicalConfiguration);
				
				// Set the dock area based on the default docking position
				final DockingPosition defaultDockingPosition = graphicalConfiguration.defaultDockingPosition;
				final boolean dockable = defaultDockingPosition != DockingPosition.NOT_DOCKABLE;
				if(dockable) {
					// If parent is docked, the child should use the group docking area
					if(container instanceof DiagramElement && ((DiagramElement) container).getDockArea() != null) { 								 
						m.setDockArea(element, DockArea.GROUP);
					} else if(element.getDockArea() == null) {
						m.setDockArea(element, defaultDockingPosition.getDockArea());
					}
				} else {
					// Ensure the dock area is null
					m.setDockArea(element, null);
				}		
							
				if(element.getGraphic() instanceof AgeConnection) {
					// Add connection elements to the list so that they can be access later.
					connectionElements.add(element);				
				}
				
				// Update the element's children
				updateElements(m, element, n.getChildren(), connectionElements);
			}
		}
	}
	
	/**
	 * Removes invalid connections.
	 */
	private void removeInvalidConnections(final DiagramModification m, final Collection<DiagramElement> connectionElements) {		
		// Build Collection of All Invalid Connections
		final Set<DiagramElement> invalidConnectionElements = new HashSet<>();
		Iterator<DiagramElement> connectionElementsIt = connectionElements.iterator();
		while(connectionElementsIt.hasNext()) {
			final DiagramElement e = connectionElementsIt.next();
			
			if(e.getStartElement() == null || (e.getEndElement() == null && !((AgeConnection)e.getGraphic()).isFlowIndicator)) {
				invalidConnectionElements.add(e);
				
				// Remove the connection from the connection collection and the diagram
				connectionElementsIt.remove();
				ghostAndRemove(m, e);
			}
		}
		
		// Loop through the connections repeatedly until there are no longer any invalid connections referenced.
		for(int lastSize = 0; (invalidConnectionElements.size() - lastSize) > 0; lastSize = invalidConnectionElements.size()) {
			connectionElementsIt = connectionElements.iterator();
			while(connectionElementsIt.hasNext()) {
				final DiagramElement e = connectionElementsIt.next();
				if(invalidConnectionElements.contains(e.getStartElement()) || invalidConnectionElements.contains(e.getEndElement())) {
					invalidConnectionElements.add(e);
					
					// Remove the connection from the connection collection and the diagram
					removeConnectionAndDescendantConnections(e, connectionElements);
					ghostAndRemove(m, e);
				}
			}
		}
	}
	
	private static void removeConnectionAndDescendantConnections(DiagramElement e, final Collection<DiagramElement> connections) {
		if(e.getGraphic() instanceof AgeConnection) {
			connections.remove(e);
		}
		
		for(final DiagramElement child : connections) {
			removeConnectionAndDescendantConnections(child, connections);
		}
	}	
	
	// Ghosting
	public void clearGhosts() {
		containerToRelativeReferenceToGhostMap.clear();
	}
	
	private void addGhost(final DiagramElement ghost) {
		final DiagramNode container = ghost.getContainer();
		
		// Get the mapping from relative reference to the ghost for the container
		Map<RelativeBusinessObjectReference, DiagramElement> relativeReferenceToGhostMap = containerToRelativeReferenceToGhostMap.get(container);
		if(relativeReferenceToGhostMap == null) {
			relativeReferenceToGhostMap = new HashMap<>();
			containerToRelativeReferenceToGhostMap.put(container, relativeReferenceToGhostMap);
		}
		
		// Add the ghost to the map		
		relativeReferenceToGhostMap.put(ghost.getRelativeReference(), ghost);		
	}
	
	private DiagramElement removeGhost(final DiagramNode container, final RelativeBusinessObjectReference relativeReference) {
		final Map<RelativeBusinessObjectReference, DiagramElement> relativeReferenceToGhostMap = containerToRelativeReferenceToGhostMap.get(container);
		if(relativeReferenceToGhostMap == null) {
			return null;
		}
		
		return relativeReferenceToGhostMap.remove(relativeReference);
	}
	
	public static BusinessObjectNode createBusinessObjectNode(final AgeDiagram diagram, 
			final Map<DiagramNode, Map<RelativeBusinessObjectReference, Point>> futureElementPositionMap) {
		final BusinessObjectNode rootNode = new BusinessObjectNode(null, null, null, false, ContentsFilter.ALLOW_FUNDAMENTAL, Completeness.UNKNOWN);
		createBusinessObjectNodesForElements(rootNode, diagram.getDiagramElements(), futureElementPositionMap);
		createBusnessObjectNodesForFutureElements(rootNode, diagram, futureElementPositionMap);
		return rootNode;
	}
	
	private static void createBusnessObjectNodesForFutureElements(final BusinessObjectNode parent, 
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
			childNode.setAutoContentsFilter(e.getAutoContentsFilter());			
			createBusinessObjectNodesForElements(childNode, e.getDiagramElements(), futureElementPositionMap);
			createBusnessObjectNodesForFutureElements(childNode, e, futureElementPositionMap);
		}
	}
}
