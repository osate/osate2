package org.osate.ge.internal.diagram;

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
import org.osate.ge.internal.diagram.AgeDiagram.Modification;
import org.osate.ge.internal.diagram.AgeDiagram.Modifier;
import org.osate.ge.internal.graphics.AgeConnection;

/**
 * Updates the diagram's elements based on the diagram configuration.
 *
 */
// TODO: Document purpose, etc
public class DiagramUpdater {
	private final BusinessObjectTreeFactory boTreeFactory;
	private final GraphicProvider graphicProvider;
	private final DockingConfigurationProvider dockingConfigurationProvider;
	private final ConnectionEndProvider connectionEndProvider;
	
	private final Map<DiagramElementContainer, Map<RelativeBusinessObjectReference, AgeDiagramElement>> containerToRelativeReferenceToGhostMap = new HashMap<>();
		
	// This interface provides the business objects that should be included in the diagram.
	// The updater is responsible for adding and removing elements as necessary.
	public static interface BusinessObjectTreeFactory {
		BusinessObjectTree createBusinessObjectTree(final DiagramConfiguration configuration);
	}
	
	public static interface BusinessObjectTree {
		Collection<BusinessObjectTreeNode> getRootNodes();
	}
	
	public static interface BusinessObjectTreeNode {
		Object getBusinessObject();
		RelativeBusinessObjectReference getRelativeReference();
		CanonicalBusinessObjectReference getCanonicalReference();
		Collection<BusinessObjectTreeNode> getChildren();
	}
	
	/**
	 * Provides the graphic that should be used for a business object. 
	 *
	 */
	public static interface GraphicProvider {
		/**
		 * The specified diagram element may not be fully initialized. Only the business object and container fields are guaranteed to be initialized.
		 * @param element
		 * @return
		 */
		Graphic getGraphic(AgeDiagramElement element);
	}
	
	// TODO: RENAME?
	public static interface DockingConfigurationProvider {
		/**
		 * The specified diagram element may not be fully initialized. Only the business object and container fields are guaranteed to be initialized.
		 * @param element
		 * @return
		 */
		DockingPosition getDefaultDockingPosition(AgeDiagramElement element);
	}
	
	public static interface ConnectionEndProvider {
		AgeDiagramElement getConnectionStart(final AgeDiagramElement e);
		AgeDiagramElement getConnectionEnd(final AgeDiagramElement e);
	}
		
	public DiagramUpdater(final BusinessObjectTreeFactory boTreeFactory, 
			final GraphicProvider graphicProvider,
			final DockingConfigurationProvider dockingConfigurationProvider,
			final ConnectionEndProvider connectionEndProvider) {
		this.boTreeFactory = Objects.requireNonNull(boTreeFactory, "boTreeFactory must not be null");
		this.graphicProvider = Objects.requireNonNull(graphicProvider, "graphicProvider must not be null");
		this.dockingConfigurationProvider = Objects.requireNonNull(dockingConfigurationProvider, "dockingConfigurationProvider must not be null");
		this.connectionEndProvider = Objects.requireNonNull(connectionEndProvider, "connectionEndProvider must not be null");
	}

	public void updateDiagram(final AgeDiagram diagram) {
		final List<AgeDiagramElement> connectionElements = new LinkedList<>();
		final BusinessObjectTree boTree = Objects.requireNonNull(boTreeFactory.createBusinessObjectTree(diagram.getConfiguration()), "Business Object Tree Factory returned null");
		
		diagram.modify(new Modifier() {
			@Override
			public void modify(final Modification m) {
				updateElements(m, diagram, boTree.getRootNodes(), connectionElements);
				removeInvalidConnections(m, connectionElements);
			}			
		});
	}
	
	/**
	 * 
	 * @param container is the container for which to update the elements
	 * @param bos 
	 * @param connectionElements is a collection to populate with connection elements.
	 */
	private void updateElements(final Modification m, final DiagramElementContainer container, final Collection<BusinessObjectTreeNode> bos, final Collection<AgeDiagramElement> connectionElements) {
		for(final BusinessObjectTreeNode n : bos) {
			// Get existing element if it exists.
			AgeDiagramElement element = container.getByRelativeReference(n.getRelativeReference());
			
			// Create the element if it does not exist
			if(element == null) {
				final AgeDiagramElement removedGhost = removeGhost(container, n.getRelativeReference());
				if(removedGhost == null) {
					element = new AgeDiagramElement(container, n.getBusinessObject(), n.getRelativeReference(), n.getCanonicalReference());
				} else {
					element = removedGhost;
				}
				
				m.addElement(element);
			} else {
				// Update the business object. Although the reference matches. The business object may be new.
				m.updateBusinessObjectWithSameRelativeReference(element, n.getBusinessObject());
			}
			
			// Set the graphic
			m.setGraphic(element, graphicProvider.getGraphic(element));
			
			final DockingPosition defaultDockingPosition = Objects.requireNonNull(dockingConfigurationProvider.getDefaultDockingPosition(element), "getDefaultDockingPosition() must not return null");
			final boolean dockable = defaultDockingPosition != DockingPosition.NOT_DOCKABLE;
			if(dockable) {
				// If parent is docked, the child should use the group docking area
				if(container instanceof AgeDiagramElement && ((AgeDiagramElement) container).getDockArea() != null) { 								 
					m.setDockArea(element, DockArea.GROUP);
				} else if(element.getDockArea() == null) {
					m.setDockArea(element, defaultDockingPosition.getDockArea());
				}
			} else {
				// Ensure the dock area is null
				m.setDockArea(element, null);
			}		
			
			// Add connection elements to the list so that they can be easily accessed in later stages of the update process
			if(element.getGraphic() instanceof AgeConnection) {
				connectionElements.add(element);
			}
			
			// Update the element's children
			updateElements(m, element, n.getChildren(), connectionElements);
		}
		
		// Remove elements whose business objects are not in the business object tree
		// At this point, it is assumed that there is a diagram element for each business object. Elements that are incomplete may be pruned later.
		// If the collections are the same size, there is nothing to remove
		if(bos.size() != container.getDiagramElements().size()) {
			// Build Set of Relative References of All the Objects in the Business Object Tree
			final Set<RelativeBusinessObjectReference> boTreeRelativeReferenceSet = bos.stream().map((n) -> n.getRelativeReference()).collect(Collectors.toCollection(HashSet::new));
			Iterator<AgeDiagramElement> childrenIt = container.getDiagramElements().iterator();
			while(childrenIt.hasNext()) {
				final AgeDiagramElement child = childrenIt.next();
				if(!boTreeRelativeReferenceSet.contains(child.getRelativeReference())) {
					addGhost(child);
					m.removeElement(child);
				}
			}
		}
	}
	
	private void removeInvalidConnections(final Modification m, final Collection<AgeDiagramElement> connectionElements) {
		// Set connection ends
		for(final AgeDiagramElement e : connectionElements) {
			connectionEndProvider.getConnectionStart(e);
			
			m.setConnectionStart(e, connectionEndProvider.getConnectionStart(e));
			m.setConnectionEnd(e, connectionEndProvider.getConnectionEnd(e));
		}
		
		// Build Collection of All Invalid Connections
		final Set<AgeDiagramElement> invalidConnectionElements = new HashSet<>();
		Iterator<AgeDiagramElement> connectionElementsIt = connectionElements.iterator();
		while(connectionElementsIt.hasNext()) {
			final AgeDiagramElement e = connectionElementsIt.next();
			
			if(e.getStartElement() == null || e.getEndElement() == null) {
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
				final AgeDiagramElement e = connectionElementsIt.next();
				if(invalidConnectionElements.contains(e.getStartElement()) || invalidConnectionElements.contains(e.getEndElement())) {
					invalidConnectionElements.add(e);
					
					// Remove the connection from the connection collection and the diagram
					connectionElements.remove(e);
					addGhost(e);
					m.removeElement(e);
				}
			}
		}
	}
	
	// Ghosting
	public void clearGhosts() {
		containerToRelativeReferenceToGhostMap.clear();
	}
	
	public void addGhost(final AgeDiagramElement ghost) {
		final DiagramElementContainer container = ghost.getContainer();
		
		// Get the mapping from relative reference to the ghost for the container
		Map<RelativeBusinessObjectReference, AgeDiagramElement> relativeReferenceToGhostMap = containerToRelativeReferenceToGhostMap.get(container);
		if(relativeReferenceToGhostMap == null) {
			relativeReferenceToGhostMap = new HashMap<>();
			containerToRelativeReferenceToGhostMap.put(container, relativeReferenceToGhostMap);
		}
		
		// Add the ghost to the map		
		relativeReferenceToGhostMap.put(ghost.getRelativeReference(), ghost);		
	}
	
	public AgeDiagramElement removeGhost(final DiagramElementContainer container, final RelativeBusinessObjectReference relativeReference) {
		final Map<RelativeBusinessObjectReference, AgeDiagramElement> relativeReferenceToGhostMap = containerToRelativeReferenceToGhostMap.get(container);
		if(relativeReferenceToGhostMap == null) {
			return null;
		}
		
		return relativeReferenceToGhostMap.remove(relativeReference);
	}	
}
