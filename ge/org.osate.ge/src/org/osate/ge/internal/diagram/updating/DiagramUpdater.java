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

import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.DockArea;
import org.osate.ge.internal.DockingPosition;
import org.osate.ge.internal.diagram.AgeDiagram;
import org.osate.ge.internal.diagram.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.DiagramElement;
import org.osate.ge.internal.diagram.DiagramModification;
import org.osate.ge.internal.diagram.DiagramModifier;
import org.osate.ge.internal.diagram.DiagramNode;
import org.osate.ge.internal.diagram.Point;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;
import org.osate.ge.internal.graphics.AgeConnection;
import org.osate.ge.internal.labels.AgeLabelConfiguration;

/**
 * Updates the diagram's elements based on the diagram configuration.
 * The DiagramUpdater updates the diagram using information provided by objects passed into the constructor.
 */
public class DiagramUpdater {	
	private final BusinessObjectTreeFactory boTreeFactory;
	private final DiagramElementInfoProvider infoProvider;
	
	private final Map<DiagramNode, Map<RelativeBusinessObjectReference, DiagramElement>> containerToRelativeReferenceToGhostMap = new HashMap<>();
	
	// Holds the positions of diagram elements which have not been created. Uses canonical reference which isn't guaranteed to be unique but
	// it is expected that typically this map will contain 0 or 1 entries and avoids making assumptions about containers.
	private final Map<CanonicalBusinessObjectReference, Point> futureElementPositionMap = new HashMap<>(); 

	public DiagramUpdater(final BusinessObjectTreeFactory boTreeFactory, 
			final DiagramElementInfoProvider infoProvider) {
		this.boTreeFactory = Objects.requireNonNull(boTreeFactory, "boTreeFactory must not be null");
		this.infoProvider = Objects.requireNonNull(infoProvider, "infoProvider must not be null"); // Adjust message after rename
	}

	/**
	 * Add a position to be used for the initial position for the next element that is created with the specified canonical reference. 
	 * All future positions are cleared after each update.
	 * @param ref
	 * @param position
	 */
	public void addFutureElementPosition(final CanonicalBusinessObjectReference ref, final Point position) {
		futureElementPositionMap.put(ref, position);
	}	
	
	public void updateDiagram(final AgeDiagram diagram) {
		final List<DiagramElement> connectionElements = new LinkedList<>();
		final BusinessObjectTree boTree = Objects.requireNonNull(boTreeFactory.createBusinessObjectTree(diagram.getConfiguration()), "Business Object Tree Factory returned null");
		
		diagram.modify(new DiagramModifier() {
			@Override
			public void modify(final DiagramModification m) {
				diagram.setBusinessObject(boTree.getBusinessObject());
				
				// Update the structure. By doing this in a separate pass, updateElements() will have access to the complete diagram structure. 
				// However, connections will later be purged from the diagram if they do not refer to valid elements.
				updateStructure(m, diagram, boTree.getRootNodes());
				
				updateElements(m, diagram, boTree.getRootNodes(), connectionElements);
				removeInvalidConnections(m, connectionElements);
			}			
		});

		// Remove all entries from the future elements map regardless of whether they were created or not. This ensures that unused positions aren't retained indefinitely
		futureElementPositionMap.clear();		
	}
	
	/**
	 * Updates the structure of the diagram. Creates/Unghosts elements to match the business object tree. Ghosts diagram elements which are not in the diagram element tree.
	 * @param m
	 * @param container
	 * @param bos
	 */
	private void updateStructure(final DiagramModification m, final DiagramNode container, final Collection<BusinessObjectTreeNode> bos) {
		for(final BusinessObjectTreeNode n : bos) {
			// Get existing element if it exists.
			DiagramElement element = container.getByRelativeReference(n.getRelativeReference());
			
			// Create the element if it does not exist
			if(element == null) {
				final DiagramElement removedGhost = removeGhost(container, n.getRelativeReference());
				if(removedGhost == null) {
					final Point initialPosition = futureElementPositionMap.get(n.getCanonicalReference());
					element = new DiagramElement(container, n.getBusinessObject(), n.getBusinessObjectHandler(), n.getRelativeReference(), n.getCanonicalReference(), n.getName(), initialPosition);
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
					addGhost(child);
					m.removeElement(child);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param container is the container for which to update the elements
	 * @param bos 
	 * @param connectionElements is a collection to populate with connection elements.
	 */
	private void updateElements(final DiagramModification m, final DiagramNode container, final Collection<BusinessObjectTreeNode> bos, final Collection<DiagramElement> connectionElements) {
		for(final BusinessObjectTreeNode n : bos) {
			// Get existing element. The updateStructure() pass should have ensured that it exists.
			DiagramElement element = Objects.requireNonNull(container.getByRelativeReference(n.getRelativeReference()), "unable to retrieve element");
			
			// Set the graphic
			final Graphic graphic = Objects.requireNonNull(infoProvider.getGraphic(element), "getGraphic() must not return null");
			m.setGraphic(element, graphic);
			
			final DockingPosition defaultDockingPosition = Objects.requireNonNull(infoProvider.getDefaultDockingPosition(element), "getDefaultDockingPosition() must not return null");
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
			
			// Set the label configuration
			final AgeLabelConfiguration labelConfiguration = Objects.requireNonNull(infoProvider.getDefaultLabelConfiguration(element), "getDefaultLabelConfiguration() must not return null");
			m.setLabelConfiguration(element, labelConfiguration);
			
			if(element.getGraphic() instanceof AgeConnection) {
				// Set connection ends
				m.setConnectionStart(element, infoProvider.getConnectionStart(element));
				m.setConnectionEnd(element, infoProvider.getConnectionEnd(element));

				// Add connection elements to the list so that they can be access later.
				connectionElements.add(element);				
			}
			
			// Update the element's children
			updateElements(m, element, n.getChildren(), connectionElements);
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
				addGhost(e);
				m.removeElement(e);
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
					addGhost(e);
					m.removeElement(e);
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
}
