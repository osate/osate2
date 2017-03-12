package org.osate.ge.internal.diagram;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.osate.ge.graphics.Graphic;
import org.osate.ge.internal.graphics.AgeConnection;

/**
 * Updates the diagram's elements based on the diagram configuration.
 *
 */
// TODO: Document purpose, etc
public class DiagramUpdater {
	private final BusinessObjectTreeFactory boTreeFactory;
	private final GraphicProvider graphicProvider;
	private final ConnectionEndProvider connectionEndProvider;
	private final List<DiagramElement> connectionElements = new LinkedList<>();
	
	// This interface provides the business objects that should be included in the diagram.
	// The updater is responsible for adding and removing elements as necessary.
	public static interface BusinessObjectTreeFactory {
		BusinessObjectTree createBusinessObjectTree(final DiagramConfiguration configuration);
	}
	
	public static interface BusinessObjectTree {
		Collection<BusinessObjectTreeNode> getRootNodes();
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
		Graphic getGraphic(DiagramElement element);
	}
	
	public static interface ConnectionEndProvider {
		DiagramElement getConnectionStart(final DiagramElement e);
		DiagramElement getConnectionEnd(final DiagramElement e);
	}
	
	public static interface BusinessObjectTreeNode {
		Object getBusinessObject();
		RelativeBusinessObjectReference getRelativeReference();
		CanonicalBusinessObjectReference getCanonicalReference();
		Collection<BusinessObjectTreeNode> getChildren();
	}
	
	public DiagramUpdater(final BusinessObjectTreeFactory boTreeFactory, 
			final GraphicProvider graphicProvider,
			final ConnectionEndProvider connectionEndProvider) {
		this.boTreeFactory = Objects.requireNonNull(boTreeFactory, "boTreeFactory must not be null");
		this.graphicProvider = Objects.requireNonNull(graphicProvider, "graphicProvider must not be null");
		this.connectionEndProvider = Objects.requireNonNull(connectionEndProvider, "connectionEndProvider must not be null");
	}

	public void updateDiagram(final AgeDiagram diagram) {
		try {
			final BusinessObjectTree boTree = Objects.requireNonNull(boTreeFactory.createBusinessObjectTree(diagram.getConfiguration()), "Business Object Tree Factory returned null");
			
			// Perform first stage update. Ensure that the structure of the tree is correct and that graphics have be set.
			updateElements(diagram, boTree.getRootNodes());
	
			// Set connection ends
			for(final DiagramElement e : connectionElements) {
				e.setStartElement(connectionEndProvider.getConnectionStart(e));
				e.setEndElement(connectionEndProvider.getConnectionEnd(e));
			}
			
			// Build Collection of All Invalid Connections
			final Set<DiagramElement> invalidConnectionElements = new HashSet<>();
			Iterator<DiagramElement> connectionElementsIt = connectionElements.iterator();
			while(connectionElementsIt.hasNext()) {
				final DiagramElement e = connectionElementsIt.next();
				
				if(e.getStartElement() == null || e.getEndElement() == null) {
					invalidConnectionElements.add(e);
					
					// Remove the connection from the connection collection and the diagram
					connectionElementsIt.remove();
					e.getContainer().getDiagramElements().remove(e);
				}
			}
			
			// Loop through the connections repeatedly until there are no longer any invalid connections referenced.
			for(int lastSize = 0; (invalidConnectionElements.size() - lastSize) > 0; lastSize = invalidConnectionElements.size()) {
				connectionElementsIt = connectionElements.iterator();
				while(connectionElementsIt.hasNext()) {
					final DiagramElement e = connectionElementsIt.next();
					if(invalidConnectionElements.contains(e.getStartElement()) || invalidConnectionElements.contains(e.getEndElement())) {
						invalidConnectionElements.add(e);
						
						connectionElements.remove(e);
						e.getContainer().getDiagramElements().remove(e);
					}
				}
			}

			// Remove All Invalid Connections from the Diagram
			for(final DiagramElement invalidElement : invalidConnectionElements) {
				invalidElement.getContainer().getDiagramElements().remove(invalidElement);
			}
		} finally {
			connectionElements.clear();
		}
	}
	
	private void updateElements(final DiagramElementContainer container, final Collection<BusinessObjectTreeNode> bos) {
		for(final BusinessObjectTreeNode n : bos) {
			// Get existing element if it exists.
			DiagramElement element = container.getDiagramElements().getByRelativeReference(n.getRelativeReference());
			
			// Create the element if it does not exist
			if(element == null) { 
				element = new DiagramElement(container, n.getBusinessObject(), n.getRelativeReference(), n.getCanonicalReference());	
			} else {
				// Update the business object. Although the reference matches. The business object may be new.
				element.setBusinessObject(n.getBusinessObject());
			}
			
			// Set the graphic
			element.setGraphic(graphicProvider.getGraphic(element));			
			
			// Add connection elements to the list so that they can be easily accessed in later stages of the update process
			if(element.getGraphic() instanceof AgeConnection) {
				connectionElements.add(element);
			}
			
			// Update the element's children
			updateElements(element, n.getChildren());
		}
		
		// Remove elements whose business objects are not in the business object tree
		// At this point, it is assumed that there is a diagram element for each business object. Elements that are incomplete may be pruned later.
		// If the collections are the same size, there is nothing to remove
		if(bos.size() != container.getDiagramElements().size()) {
			container.getDiagramElements().removeIf((e) -> !bos.stream().anyMatch((n) -> n.getRelativeReference().equals(e.getRelativeReference())));
		}
	}
}
