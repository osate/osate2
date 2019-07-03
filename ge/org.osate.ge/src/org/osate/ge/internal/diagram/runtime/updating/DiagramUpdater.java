package org.osate.ge.internal.diagram.runtime.updating;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.osate.ge.DockingPosition;
import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.internal.AgeConnection;
import org.osate.ge.graphics.internal.AgeGraphicalConfiguration;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramModification;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.DockArea;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.diagram.runtime.boTree.BusinessObjectNode;
import org.osate.ge.internal.diagram.runtime.boTree.Completeness;
import org.osate.ge.internal.diagram.runtime.boTree.DiagramToBusinessObjectTreeConverter;
import org.osate.ge.internal.diagram.runtime.boTree.TreeUpdater;
import org.osate.ge.internal.model.EmbeddedBusinessObject;
import org.osate.ge.internal.model.PropertyValueGroup;
import org.osate.ge.internal.services.ActionExecutor;
import org.osate.ge.internal.services.AgeAction;

/**
 * Updates the diagram's elements based on the diagram configuration.
 * The DiagramUpdater updates the diagram using information provided by objects passed into the constructor.
 */
public class DiagramUpdater {
	private final TreeUpdater boTreeExpander;
	private final DiagramElementInformationProvider infoProvider;
	private final ActionExecutor actionExecutor;

	private final Map<DiagramNode, Map<RelativeBusinessObjectReference, DiagramElement>> containerToRelativeReferenceToGhostMap = new HashMap<>();

	// Holds information regarding diagram elements which have not been created. The DiagramNode is the parent of the new element.
	private final Map<DiagramNode, Map<RelativeBusinessObjectReference, FutureElementInfo>> futureElementInfoMap = new HashMap<>();

	public DiagramUpdater(final TreeUpdater boTreeExpander,
			final DiagramElementInformationProvider infoProvider, final ActionExecutor actionExecutor) {
		this.boTreeExpander = Objects.requireNonNull(boTreeExpander, "boTreeExpander must not be null");
		this.infoProvider = Objects.requireNonNull(infoProvider, "infoProvider must not be null"); // Adjust message after rename
		this.actionExecutor = Objects.requireNonNull(actionExecutor, "actionExecutor must not be null");
	}

	/**
	 * Add a position to be used for the initial position for the next element that is created with the specified canonical reference.
	 * All future positions are cleared after each update.
	 * @param ref
	 * @param newElementPosition
	 */
	public void addToNextUpdate(final DiagramNode parentDiagramNode,
			final RelativeBusinessObjectReference ref,
			final FutureElementInfo newElementInfo) {
		Map<RelativeBusinessObjectReference, FutureElementInfo> m = futureElementInfoMap.get(parentDiagramNode);
		if(m == null) {
			m = new HashMap<>();
			futureElementInfoMap.put(parentDiagramNode, m);
		}
		m.put(ref, newElementInfo);
	}

	// Updates the diagram.
	public void updateDiagram(final AgeDiagram diagram) {
		// Create an updated business object tree based on the current state of the diagram and pending elements
		final BusinessObjectNode tree = DiagramToBusinessObjectTreeConverter.createBusinessObjectNode(diagram, futureElementInfoMap, containerToRelativeReferenceToGhostMap);
		updateDiagram(diagram, tree);
	}

	/**
	 *
	 * @param diagram
	 * @param inputTree is the input business object tree. The input tree is not modified.
	 */
	public void updateDiagram(final AgeDiagram diagram, final BusinessObjectNode inputTree) {
		// Create a tree by updating the input tree.
		final BusinessObjectNode tree = boTreeExpander.expandTree(diagram.getConfiguration(), inputTree);
		final List<DiagramElement> connectionElements = new LinkedList<>();

		diagram.modify("Update Diagram", m -> {
			// Update the structure. By doing this in a separate pass, updateElements() will have access to the complete diagram structure.
			// However, connections will later be purged from the diagram if they do not refer to valid elements.
			updateStructure(m, diagram, tree.getChildren());

			updateElements(m, diagram, tree.getChildren(), connectionElements);
			removeInvalidConnections(m, connectionElements);
		});

		// Remove all entries from the future elements map regardless of whether they were created or not. This ensures that unused positions aren't retained indefinitely
		futureElementInfoMap.clear();
	}

	/**
	 * Updates the structure of the diagram based on the business object tree.
	 * Creates/Unghosts elements to match the business object tree. Ghosts diagram elements which are not in the diagram element tree.
	 * @param m
	 * @param container
	 * @param bos
	 */
	private void updateStructure(final DiagramModification m, final DiagramNode container, final Collection<BusinessObjectNode> bos) {
		for(final BusinessObjectNode n : bos) {
			// Get existing element if it exists.
			DiagramElement element = container.getByRelativeReference(n.getRelativeReference());

			// Create the element if it does not exist
			if(element == null) {
				final DiagramElement removedGhost = removeGhost(container, n.getRelativeReference());
				if(removedGhost == null) {
					final Object boh = infoProvider.getApplicableBusinessObjectHandler(n.getBusinessObject());
					if(boh == null) {
						// Ignore the object
						continue;
					}

					element = new DiagramElement(container, n.getBusinessObject(), boh, n.getRelativeReference(),
							n.getId());
				} else {
					element = removedGhost;
					m.updateBusinessObjectWithSameRelativeReference(element, n.getBusinessObject());
				}

				m.addElement(element);
			} else {
				// Update the business object. Although the reference matches. The business object may be new.
				m.updateBusinessObjectWithSameRelativeReference(element, n.getBusinessObject());
			}

			// Set the business object handler if it is null
			if(element.getBusinessObjectHandler() == null) {
				final Object boh = infoProvider.getApplicableBusinessObjectHandler(n.getBusinessObject());
				if(boh == null) {
					ghostAndRemove(m, element);
					continue;
				} else {
					element.setBusinessObjectHandler(boh);
				}
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
	private void ghostAndRemove(final DiagramModification m, final DiagramElement e) {
		addGhost(e);
		m.removeElement(e);

		// Ignore property result groups and embedded business objects when determining if an element completeness
		if (e.getParent() instanceof DiagramElement && !(e.getBusinessObject() instanceof PropertyValueGroup)
				&& (!(e.getBusinessObject() instanceof EmbeddedBusinessObject))) {
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
			// Get existing element. The updateStructure() pass should have ensured that it exists if a valid element could be created.
			final DiagramElement element = container.getByRelativeReference(n.getRelativeReference());
			if(element == null) {
				continue;
			}

			// Set fields
			m.setCompleteness(element, n.getCompleteness());

			// Set name fields
			m.setLabelName(element, infoProvider.getLabelName(element));
			m.setUserInterfaceName(element, infoProvider.getUserInterfaceName(element));

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
						m.setDockArea(element, defaultDockingPosition.getDefaultDockArea());
					}
				} else {
					// Ensure the dock area is null
					m.setDockArea(element, null);
				}

				// Set the initial position if there is a value in the future element position map
				// Set the position after the dock area so that setPosition() will know whether the element is dockable.
				final Map<RelativeBusinessObjectReference, FutureElementInfo> futureElementInfos = futureElementInfoMap
						.get(container);
				final FutureElementInfo futureElementInfo = futureElementInfos == null ? null
						: futureElementInfos.get(n.getRelativeReference());
				final Point initialPosition = futureElementInfo != null ? futureElementInfo.position
						: null;
				if(initialPosition != null) {
					m.setPosition(element, initialPosition);
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
		actionExecutor.execute("Add Ghost", ActionExecutor.ExecutionMode.NORMAL, new AddGhostAction(ghost));
	}

	private DiagramElement removeGhost(final DiagramNode container, final RelativeBusinessObjectReference relativeReference) {
		final RemoveGhostAction action = new RemoveGhostAction(container, relativeReference);
		actionExecutor.execute("Remove Ghost", ActionExecutor.ExecutionMode.NORMAL, action);
		return action.removedGhost;
	}

	/**
	 * Wrapper for a ghosted DiagramElement. Intended to prevent corrupting containerToRelativeReferenceToGhostMap caused by changing the element's relative reference directly.
	 *
	 */
	public class GhostedElement {
		private final DiagramElement element;

		public GhostedElement(final DiagramElement element) {
			this.element = Objects.requireNonNull(element, "element mustnot be null");
		}

		public RelativeBusinessObjectReference getRelativeReference() {
			return element.getRelativeReference();
		}

		public DiagramNode getParent() {
			return element.getParent();
		}

		public void updateBusinessObject(final DiagramModification m, final Object bo,
				final RelativeBusinessObjectReference newRelativeReference) {
			removeGhost(element.getContainer(), getRelativeReference());
			m.updateBusinessObject(element, bo, newRelativeReference);
			addGhost(element);
		}
	}

	/**
	 * Returns a collection containing the ghosted children for the specified node.
	 * @param node
	 * @return
	 */
	public Collection<GhostedElement> getGhosts(final DiagramNode node) {
		return containerToRelativeReferenceToGhostMap.getOrDefault(node, Collections.emptyMap()).values().stream()
				.map(e -> new GhostedElement(e)).collect(Collectors.toList());
	}

	class AddGhostAction implements AgeAction {
		private final DiagramElement ghost;

		public AddGhostAction(final DiagramElement ghost) {
			this.ghost = Objects.requireNonNull(ghost, "ghost must not be null");
		}

		@Override
		public boolean canExecute() {
			return true;
		}

		@Override
		public AgeAction execute() {
			final DiagramNode container = ghost.getContainer();

			// Get the mapping from relative reference to the ghost for the container
			Map<RelativeBusinessObjectReference, DiagramElement> relativeReferenceToGhostMap = containerToRelativeReferenceToGhostMap
					.get(container);
			if (relativeReferenceToGhostMap == null) {
				relativeReferenceToGhostMap = new HashMap<>();
				containerToRelativeReferenceToGhostMap.put(container, relativeReferenceToGhostMap);
			}

			// Add the ghost to the map
			relativeReferenceToGhostMap.put(ghost.getRelativeReference(), ghost);

			return new RemoveGhostAction(container, ghost.getRelativeReference());
		}
	}

	class RemoveGhostAction implements AgeAction {
		private final DiagramNode container;
		private final RelativeBusinessObjectReference relativeReference;

		private DiagramElement removedGhost;

		public RemoveGhostAction(final DiagramNode container, final RelativeBusinessObjectReference relativeReference) {
			this.container = container;
			this.relativeReference = relativeReference;
		}

		@Override
		public boolean canExecute() {
			return true;
		}

		@Override
		public AgeAction execute() {
			final Map<RelativeBusinessObjectReference, DiagramElement> relativeReferenceToGhostMap = containerToRelativeReferenceToGhostMap
					.get(container);
			if (relativeReferenceToGhostMap == null) {
				return null;
			}

			removedGhost = relativeReferenceToGhostMap.remove(relativeReference);

			return removedGhost == null ? null : new AddGhostAction(removedGhost);
		}
	}
}
