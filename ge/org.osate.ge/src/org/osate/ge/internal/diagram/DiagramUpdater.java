package org.osate.ge.internal.diagram;

import java.util.List;
import java.util.Objects;

/**
 * Updates the diagram's elements based on the diagram configuration.
 *
 */
// TODO: Document purpose, etc
public class DiagramUpdater {
	private final BusinessObjectTreeFactory boTreeFactory;
	private final Listener listener;
	
	public static interface Listener {
		
	}
	
	// What is the purpose?
	// To simply provide the business objects that should be shown.
	// The updater is responsible for adding and removing elements as necessary.
	public static interface BusinessObjectTreeFactory {
		BusinessObjectTree createBusinessObjectTree(final DiagramConfiguration configuration);
	}
	
	public static interface BusinessObjectTree {
		List<BusinessObjectTreeNode> getRootNodes();
	}
	
	public static interface BusinessObjectTreeNode {
		Object getBusinessObject();
		List<BusinessObjectTreeNode> getChildren();
	}
	
	public DiagramUpdater(final BusinessObjectTreeFactory boTreeFactory, final Listener listener) {
		this.boTreeFactory = Objects.requireNonNull(boTreeFactory, "boTreeFactory must not be null");
		this.listener = Objects.requireNonNull(listener, "listener must not be null");
	}
	
	private void updateElement(final DiagramElement parent, final List<BusinessObjectTreeNode> boChildren) {
		for(final BusinessObjectTreeNode n : boChildren) {
			final DiagramElement element = new DiagramElement(parent, n.getBusinessObject());
			parent.children.add(element);
		}
	}
	
	public void updateDiagram(final AgeDiagram diagram) {
		final BusinessObjectTree boTree = Objects.requireNonNull(boTreeFactory.createBusinessObjectTree(diagram.getConfiguration()), "Business Object Tree Factory returned null");
		for(final BusinessObjectTreeNode n : boTree.getRootNodes()) {
			final DiagramElement element = new DiagramElement(diagram, n.getBusinessObject());
			diagram.elements.add(element);
			updateElement(element, n.getChildren());			
		}		
	
		// TODO: Need to use references instead of just business objects. Will need to compare them. Might be optimal to supply both.
		// TODO: Create/Update/Ghost as appropriate instead of just creating.
		
		// Notify listener so that it can handle specialized processing(ghosting and graphiti specific behavior).
	}
}
