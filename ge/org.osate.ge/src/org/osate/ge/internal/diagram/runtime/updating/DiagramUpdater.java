/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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

import org.osate.ge.CanonicalBusinessObjectReference;
import org.osate.ge.DockingPosition;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.RelativeBusinessObjectReference;
import org.osate.ge.aadl2.internal.model.PropertyValueGroup;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.internal.AgeConnection;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramConfigurationBuilder;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;
import org.osate.ge.internal.diagram.runtime.DiagramModification;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.DockArea;
import org.osate.ge.internal.model.EmbeddedBusinessObject;
import org.osate.ge.internal.services.ActionExecutor;
import org.osate.ge.internal.services.AgeAction;
import org.osate.ge.services.ReferenceBuilderService;
import org.osate.ge.services.ReferenceResolutionService;

/**
 * Updates the diagram's elements based on the diagram configuration.
 * The DiagramUpdater updates the diagram using information provided by objects passed into the constructor.
 */
public class DiagramUpdater {
	private final BusinessObjectTreeUpdater boTreeUpdater;
	private final DiagramElementInformationProvider infoProvider;
	private final ActionExecutor actionExecutor;
	private final ReferenceResolutionService referenceResolver;
	private final ReferenceBuilderService referenceBuilder;

	private final Map<DiagramNode, Map<RelativeBusinessObjectReference, DiagramElement>> containerToRelativeReferenceToGhostMap = new HashMap<>();

	// Holds information regarding diagram elements which have not been created. The DiagramNode is the parent of the new element.
	private final Map<DiagramNode, Map<RelativeBusinessObjectReference, FutureElementInfo>> futureElementInfoMap = new HashMap<>();

	/**
	 * Creates an instance which will be used to update a diagram.
	 * @param boTreeUpdater the tree updater
	 * @param infoProvider the diagram element info provider
	 * @param actionExecutor the action executor to use to execute action
	 * @param referenceResolver the reference resolver. Must not be null but only used when a diagram has a diagram context.
	 * @param referenceBuilder the reference builder. Must not be null but only used when a diagram has a diagram context.
	 */
	public DiagramUpdater(final BusinessObjectTreeUpdater boTreeUpdater,
			final DiagramElementInformationProvider infoProvider, final ActionExecutor actionExecutor,
			final ReferenceResolutionService referenceResolver, final ReferenceBuilderService referenceBuilder) {
		this.boTreeUpdater = Objects.requireNonNull(boTreeUpdater, "boTreeUpdater must not be null");
		this.infoProvider = Objects.requireNonNull(infoProvider, "infoProvider must not be null"); // Adjust message after rename
		this.actionExecutor = Objects.requireNonNull(actionExecutor, "actionExecutor must not be null");
		this.referenceResolver = Objects.requireNonNull(referenceResolver, "referenceResolver must not be null");
		this.referenceBuilder = Objects.requireNonNull(referenceBuilder, "referenceBuilder must not be null");
	}

	/**
	 * Instructs the updater to create an element for the reference business object if the business object exists during the next
	 * update. Also allows settings additional information such as the initial position of the diagram element.
	 *
	 * This is the mechanism by which a position can be specified for a diagram element which doesn't exist yet.
	 * This is used to set the initial position of an element being created by the palette. When the diagram is updated the diagram element
	 * is created and then the position is set to the specified value. The specified values are cleared after each update.
	 * @param parentDiagramNode the diagram node which will be the parent of the new element
	 * @param ref the relative reference used to identify the element
	 * @param newElementInfo the information to use when initializing the diagram element. Must not be null.
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

	/**
	 * Updates the specified diagram.
	 * @param diagram the diagram to update. See {@link DiagramUpdater#updateDiagram(AgeDiagram, BusinessObjectNode)}
	 */
	public void updateDiagram(final AgeDiagram diagram) {
		// Create an updated business object tree based on the current state of the diagram and pending elements
		final BusinessObjectNode tree = DiagramToBusinessObjectTreeConverter.createBusinessObjectNode(diagram, futureElementInfoMap, containerToRelativeReferenceToGhostMap);
		updateDiagram(diagram, tree);
	}

	/**
	 * Updates a diagram
	 * @param diagram the diagram to update. Because the diagram updater is typically initialized with fields which are specific to a project,
	 * a diagram updater should only be used with diagrams for which it was created.
	 * @param inputTree is the input business object tree. The input tree is not modified.
	 */
	public void updateDiagram(final AgeDiagram diagram, final BusinessObjectNode inputTree) {
		// Create a tree by updating the input tree.
		final BusinessObjectNode tree = boTreeUpdater.updateTree(diagram.getConfiguration(), inputTree);
		final List<DiagramElement> connectionElements = new LinkedList<>();

		diagram.modify("Update Diagram", m -> {
			refreshDiagramContextReference(m, diagram);

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
	 * Rebuilds the diagram context's reference and updated the diagram context accordingly. This ensures the diagram is updated with the correct
	 * case.
	 * @param m
	 * @param diagram
	 */
	private void refreshDiagramContextReference(final DiagramModification m, final AgeDiagram diagram) {
		final CanonicalBusinessObjectReference diagramContextRef = diagram.getConfiguration().getContextBoReference();
		if (diagramContextRef != null) {
			final Object contextBo = referenceResolver.resolve(diagram.getConfiguration().getContextBoReference());
			if (contextBo != null) {
				final CanonicalBusinessObjectReference newDiagramContextRef = referenceBuilder
						.getCanonicalReference(contextBo);

				// If the new reference isn't equal to the old reference, then something isn't correct. Don't use the new reference.
				if (Objects.equals(diagramContextRef, newDiagramContextRef)) {
					m.setDiagramConfiguration(new DiagramConfigurationBuilder(diagram.getConfiguration())
							.contextBoReference(newDiagramContextRef).build());
				}
			}
		}
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
			DiagramElement element = container.getChildByRelativeReference(n.getRelativeReference());

			// Create the element if it does not exist
			if(element == null) {
				final DiagramElement removedGhost = removeGhost(container, n.getRelativeReference());
				if(removedGhost == null) {
					final BusinessObjectHandler boh = infoProvider
							.getApplicableBusinessObjectHandler(n.getBusinessObject());
					if(boh == null) {
						// Ignore the object
						continue;
					}

					element = new DiagramElement(container, n.getBusinessObject(), boh, n.getRelativeReference(),
							n.getId());
				} else {
					element = removedGhost;
					m.updateBusinessObject(element, n.getBusinessObject(), n.getRelativeReference());
				}

				m.addElement(element);
			} else {
				// Update the business object and relative reference. Although the reference matches. The business object may be new and the
				// relative reference may have case differences.
				m.updateBusinessObject(element, n.getBusinessObject(),
						n.getRelativeReference());
			}

			// Set the business object handler if it is null
			if(element.getBusinessObjectHandler() == null) {
				final BusinessObjectHandler boh = infoProvider
						.getApplicableBusinessObjectHandler(n.getBusinessObject());
				if(boh == null) {
					ghostAndRemove(m, element);
					continue;
				} else {
					m.setBusinessObjectHandler(element, boh);
				}
			}

			// Update the element's children
			updateStructure(m, element, n.getChildren());
		}

		// Remove elements whose business objects are not in the business object tree
		// At this point, it is assumed that there is a diagram element for each business object. Elements that are incomplete may be pruned later.
		// If the collections are the same size, there is nothing to remove
		if (bos.size() != container.getChildren().size()) {
			// Build Set of Relative References of All the Objects in the Business Object Tree
			final Set<RelativeBusinessObjectReference> boTreeRelativeReferenceSet = bos.stream().map((n) -> n.getRelativeReference()).collect(Collectors.toCollection(HashSet::new));
			Iterator<DiagramElement> childrenIt = container.getChildren().iterator();
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
			final DiagramElement element = container.getChildByRelativeReference(n.getRelativeReference());
			if(element == null) {
				continue;
			}

			// Set fields
			m.setCompleteness(element, n.getCompleteness());

			// Set name fields
			m.setLabelName(element, infoProvider.getLabelName(element));
			m.setUserInterfaceName(element, infoProvider.getUserInterfaceName(element));

			// Set the graphical Configuration
			final GraphicalConfiguration graphicalConfiguration = infoProvider.getGraphicalConfiguration(element);
			if(graphicalConfiguration == null) {
				ghostAndRemove(m, element);
			} else {
				// Reset position of flow indicators if the start element has changed. This can occur when feature groups are expanded for example.
				if (element.hasPosition() && DiagramElementPredicates.isFlowIndicator(element)
						&& graphicalConfiguration.getConnectionSource() != element.getStartElement()) {
					m.setPosition(element, null);
				}

				m.setGraphicalConfiguration(element, graphicalConfiguration);

				// Set the dock area based on the default docking position
				final DockingPosition defaultDockingPosition = graphicalConfiguration.getDefaultDockingPosition();
				final boolean dockable = defaultDockingPosition != DockingPosition.NOT_DOCKABLE;
				if(dockable) {
					// If parent is docked, the child should use the group docking area
					if(container instanceof DiagramElement && ((DiagramElement) container).getDockArea() != null) {
						m.setDockArea(element, DockArea.GROUP);
					} else if(element.getDockArea() == null) {
						m.setDockArea(element, DockArea.fromDockingPosition(defaultDockingPosition));
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
	/**
	 * Clear ghosts. Ghosts are elements which have been removed from the diagram but which are retained until ghosts are cleared. They are
	 * retained to allow the diagram element to be restored if the element was removed due to a transient issue. An example of that would
	 * be a broken reference. One way ghosts can be restored is by using {@link org.osate.ge.internal.ui.handlers.RestoreMissingDiagramElementsHandler}.
	 */
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

		/**
		 * Creates an instance
		 * @param element the diagram element which was ghosted
		 */
		public GhostedElement(final DiagramElement element) {
			this.element = Objects.requireNonNull(element, "element mustnot be null");
		}

		/**
		 * Return the relative reference of the ghosted diagram element
		 * @return the relative reference of the ghosted diagram element
		 */
		public RelativeBusinessObjectReference getRelativeReference() {
			return element.getRelativeReference();
		}

		/**
		 * Return the parent of the ghosted diagram element
		 * @return the parent of the ghosted diagram element
		 */
		public DiagramNode getParent() {
			return element.getParent();
		}

		/**
		 * Update the business object and relative reference of the ghosted element. The ghosted element map will be updated with the new mapping.
		 * @param m the modification to use to update the ghost
		 * @param bo the new business object
		 * @param newRelativeReference the relative reference for the business object
		 */
		public void updateBusinessObject(final DiagramModification m, final Object bo,
				final RelativeBusinessObjectReference newRelativeReference) {
			removeGhost(element.getParent(), getRelativeReference());
			m.updateBusinessObject(element, bo, newRelativeReference);
			addGhost(element);
		}
	}

	/**
	 * Returns a collection containing the ghosted children for the specified node.
	 * @param node the node for which to retrieve the ghosted children
	 * @return a collection containing the ghosted children for the specified node.
	 */
	public Collection<GhostedElement> getGhosts(final DiagramNode node) {
		return containerToRelativeReferenceToGhostMap.getOrDefault(node, Collections.emptyMap()).values().stream()
				.map(e -> new GhostedElement(e)).collect(Collectors.toList());
	}

	private class AddGhostAction implements AgeAction {
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
			final DiagramNode container = ghost.getParent();

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

	private class RemoveGhostAction implements AgeAction {
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
