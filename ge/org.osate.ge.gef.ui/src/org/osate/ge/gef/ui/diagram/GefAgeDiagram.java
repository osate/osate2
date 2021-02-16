/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.gef.ui.diagram;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.gef.fx.anchors.IAnchor;
import org.eclipse.swt.widgets.Display;
import org.osate.ge.gef.BaseConnectionNode;
import org.osate.ge.gef.ConnectionNode;
import org.osate.ge.gef.ContainerShape;
import org.osate.ge.gef.DockedShape;
import org.osate.ge.gef.FeatureConstants;
import org.osate.ge.gef.FeatureGroupNode;
import org.osate.ge.gef.FlowIndicatorNode;
import org.osate.ge.gef.FxStyle;
import org.osate.ge.gef.FxStyleApplier;
import org.osate.ge.gef.ImageManager;
import org.osate.ge.gef.LabelNode;
import org.osate.ge.gef.PreferredPosition;
import org.osate.ge.gef.RootNode;
import org.osate.ge.gef.StyleRoot;
import org.osate.ge.graphics.Dimension;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.graphics.internal.FeatureGraphic;
import org.osate.ge.graphics.internal.FeatureGraphicType;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.BeforeModificationsCompletedEvent;
import org.osate.ge.internal.diagram.runtime.DiagramConfigurationChangedEvent;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;
import org.osate.ge.internal.diagram.runtime.DiagramModification;
import org.osate.ge.internal.diagram.runtime.DiagramModificationListener;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.DockArea;
import org.osate.ge.internal.diagram.runtime.ElementAddedEvent;
import org.osate.ge.internal.diagram.runtime.ElementRemovedEvent;
import org.osate.ge.internal.diagram.runtime.ElementUpdatedEvent;
import org.osate.ge.internal.diagram.runtime.ModificationsCompletedEvent;
import org.osate.ge.internal.diagram.runtime.botree.Completeness;
import org.osate.ge.internal.diagram.runtime.layout.DiagramElementLayoutUtil;
import org.osate.ge.internal.diagram.runtime.layout.LayoutInfoProvider;
import org.osate.ge.internal.diagram.runtime.styling.StyleCalculator;
import org.osate.ge.internal.services.ActionExecutor;
import org.osate.ge.internal.services.ActionExecutor.ExecutionMode;
import org.osate.ge.internal.services.ColoringService;

import com.google.common.base.Strings;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;

/**
 * Provides and updates a JavaFX node representing an {@link AgeDiagram}.
 * Handles updating the JavaFX nodes to reflect the changes in the AgeDiagram.
 */
public class GefAgeDiagram implements AutoCloseable, LayoutInfoProvider {
	private static final String INCOMPLETE_INDICATOR = "*";

	/**
	 * Value for the diagram element map. Contains details regarding the JavaFX node that was created for a diagram element
	 */
	// TODO: Rename
	private static class ElementMapValue {
		public ElementMapValue(final DiagramElement diagramElement) {
			this.diagramElement = diagramElement;
		}

		final DiagramElement diagramElement;
		Graphic sourceGraphic; // TODO: Rename
		Node node; // TODO: REname to scene node?
		Node parentDiagramElementSceneNode; // TODO: Rename and use
		boolean docked;
		boolean parentIsConnection;
		LabelNode primaryLabel;
		LabelNode annotationLabel;
	}

	/**
	 * The diagram for which nodes are created and updated.
	 */
	private final AgeDiagram diagram;

	/**
	 * A mapping between the diagram elements and associated data
	 */
	private final Map<DiagramElement, ElementMapValue> diagramElementMap = new HashMap<>();

	/**
	 * Root node which contains all the shape and connection nodes for the diagram.
	 */
	private final RootNode diagramNode = new RootNode();

	/**
	 * Image manager for the images referenced by the diagram.
	 */
	private final ImageManager imageManager = new ImageManager((path) -> {
		final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		final IResource imageResource = workspaceRoot.findMember(path.toString());
		return imageResource == null ? null : imageResource.getRawLocation().makeAbsolute().toFile();
	});

	/**
	 * Converter for converting the renderer independent {@link Style} tp {@link FxStyle}.
	 */
	private final StyleToFx styleToFx = new StyleToFx(imageManager);

	/**
	 * Service for determining whether the style for a diagram element should be overriden.
	 */
	private final ColoringService coloringService;

	/**
	 * Map containing override styles. Values in this style will supersede styles contained in the diagram element.
	 */
	private Map<DiagramElement, Style> overrideStyles = Collections.emptyMap();

	/**
	 * {@link StyleCalculator} which uses the {@link #overrideForegroundColorMap} to override the styles of elements.
	 */
	private final StyleCalculator finalStyleProvider;

	// TODO
	private boolean syncingWithSceneGraph = false;

	/**
	 * Listener for modifications to the {@link AgeDiagram}. Updates scene graph when the diagram changes.
	 */
	private DiagramModificationListener modificationListener = new DiagramModificationListener() {
		private boolean inBeforeModificationsCompleted = false;
		private boolean needFullUpdate = false;
		private final Set<DiagramElement> elementsToUpdate = new LinkedHashSet<>();
		private final Set<DiagramElement> elementsToRemove = new LinkedHashSet<>();

		@Override
		public void diagramConfigurationChanged(final DiagramConfigurationChangedEvent e) {
			needFullUpdate = true;
			// TODO:
			// finalStyleProvider.setDiagramConfiguration(ageDiagram.getConfiguration());
		}

		@Override
		public void elementAdded(final ElementAddedEvent e) {
			if (!inBeforeModificationsCompleted) {
				onElementAdded(e.element);
			}
		}

		private void onElementAdded(final DiagramElement element) {
			elementsToRemove.remove(element);
			needFullUpdate = true;
			elementsToUpdate.clear(); // Clear all elements to update. They will not be processed if an element has been added.
		}

		@Override
		public void elementRemoved(final ElementRemovedEvent e) {
			if (!inBeforeModificationsCompleted) {
				elementsToRemove.add(e.element);
				elementsToUpdate.remove(e.element);
			}
		}

		@Override
		public void elementUpdated(final ElementUpdatedEvent e) {
			// If a full update is going to be performed, don't track the elements that have been updated
			if (!needFullUpdate && e.element.getGraphicalConfiguration() != null && !inBeforeModificationsCompleted
					&& !syncingWithSceneGraph) {
				// If the element has been removed, don't store it as an update.
				if (!elementsToRemove.contains(e.element)) {
					// If the element is already in the elements to update set, remove it so that it will be inserted at the end of the set
					if (elementsToUpdate.contains(e.element)) {
						elementsToUpdate.remove(e.element);
					}

					elementsToUpdate.add(e.element);
				}

			}
		}

		@Override
		public void beforeModificationsCompleted(final BeforeModificationsCompletedEvent e) {
			if (syncingWithSceneGraph) {
				return;
			}

			// TODO
			Display.getDefault().syncExec(() -> {
				try {
					inBeforeModificationsCompleted = true;

					// Remove elements
					for (final DiagramElement element : elementsToRemove) {
						// Remove any contained connections first. Connections are stored at the diagram level so they need to be
						// deleted individually.
						removeContainedConnections(element);

						final ElementMapValue v = diagramElementMap.get(element); // TODO: Rename
						if (v != null && v.node != null) {
							removeNode(v.node);
						}

						// Remove the mapping
						removeMappingForBranch(element);
					}

					// TODO: Is the current full update requirements a bit aggresive? Document potential for updating.

					if (needFullUpdate) {
						fullUpdate();

						// TODO: This is likely not up to date
						// TODO: Should use the current modification? Nesting okay now?
						updateDiagramLayoutFromSceneGraph();
					} else {
						// Refresh override styles to prepare to apply styles to updated elements
						refreshOverrideStyles();

						// Ensure that the scene graph nodes have been created and/or switched to the appropriate type
						for (final DiagramElement element : elementsToUpdate) {
							final ElementMapValue v = diagramElementMap.get(element);
							if (v != null) {
								createOrUpdate(v, v.parentDiagramElementSceneNode);
							}
						}

						// Update modified elements
						for (final DiagramElement element : elementsToUpdate) {
							final ElementMapValue info = diagramElementMap.get(element);
							updateChildDiagramElement(info);
							calculateAndApplyStyle(info);
						}

						// TODO: This is likely not correct. Need to test.
						// TODO: Should use the current modification? Nesting okay now?
						// TODO: Only update selected elements. Get working first
						updateDiagramLayoutFromSceneGraph();
					}
				} finally {
					inBeforeModificationsCompleted = false;
				}
			});

		}

		@Override
		public void modificationsCompleted(final ModificationsCompletedEvent e) {
			needFullUpdate = false;
			elementsToRemove.clear();
			elementsToUpdate.clear();
		}

		/**
		 * Removes the mapping for the specified diagram node and all children
		 * @param dn
		 */
		private void removeMappingForBranch(final DiagramElement de) {
			// Remove mapping for children
			for (final DiagramElement child : de.getDiagramElements()) {
				removeMappingForBranch(child);
			}

			// Remove mapping for the element itself
			diagramElementMap.remove(de);
		}

		/**
		 * Removes all connections contained in the specified element or its descendants.
		 */
		private void removeContainedConnections(final DiagramElement e) {
			for (final DiagramElement child : e.getDiagramElements()) {
				final ElementMapValue childElementValue = diagramElementMap.get(child); // TODO: Rename
				removeContainedConnections(child);

				if (childElementValue != null && childElementValue.node instanceof ConnectionNode) {
					removeNode(childElementValue.node);
				}
			}
		}
	};

	/**
	 * Creates a new instance
	 * @param diagram the diagram for which JavaFX node will be created and updated.
	 * @param coloringService service to use to support determining the final style of nodes.
	 * @param actionExecutor the action executor to use to perform undoable operations.
	 */
	public GefAgeDiagram(final AgeDiagram diagram, final ColoringService coloringService,
			final ActionExecutor actionExecutor) {
		this.coloringService = Objects.requireNonNull(coloringService, "coloringService must not be null");
		this.diagram = Objects.requireNonNull(diagram, "diagram must not be null");
		this.finalStyleProvider = new StyleCalculator(diagram.getConfiguration(), de -> overrideStyles.get(de));

		fullUpdate();

		// Register our modification listener to update the scene graph based on changes
		diagram.addModificationListener(modificationListener);

		// Listen for the completion of the first layout by waiting for the needs layout property to be false.
		// Once this occurs, update the diagram to match the scene graph layout and stop listening
		this.diagramNode.needsLayoutProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue) {
					actionExecutor.execute("Initial diagram layout sync", ExecutionMode.HIDE, () -> {
						diagramNode.needsLayoutProperty().removeListener(this);
						syncingWithSceneGraph = true;
						diagram.modify("Initial diagram layout sync", m -> updateDiagramElementsWithFxLayout(m, true));
						syncingWithSceneGraph = false;
						return null;
					});
				}
			}
		});
	}

	@Override
	public void close() {
		diagram.removeModificationListener(modificationListener);
		imageManager.close();
	};

	// TODO: Rename
	private void fullUpdate() {
		ensureNodesExist(diagram, diagramNode);
		updateChildren(diagram);
		refreshDiagramStyles();
	}

	// TODO: Rename function. Rename arguments to distiguish between diagram nad java fx. Recursive
	private void ensureNodesExist(final DiagramNode parentDiagramNode, final Node parentSceneNode) {
		for (final DiagramElement childElement : parentDiagramNode.getDiagramElements()) {
			final Node childSceneNode = createOrUpdate(parentSceneNode, childElement); // TODO: Rename
			ensureNodesExist(childElement, childSceneNode);
		}
	}

	// TODO: Need to update comments to make it clear how this is different from updateDiagramElement
	/**
	 * Create or updates the appropriate node and adds it to the scene graph as appropriate
	 * @param parentDiagramElementSceneNode the JavaFX node for the parent diagram element.
	 * @param childDiagramElement the diagram element which is being updated.
	 * @return the created or updated JavaFX node
	 */
	private Node createOrUpdate(final Node parentDiagramElementSceneNode, final DiagramElement childDiagramElement) {
		final ElementMapValue elementInfo = diagramElementMap.computeIfAbsent(childDiagramElement,
				e -> new ElementMapValue(childDiagramElement)); // TODO: Rename
		return createOrUpdate(elementInfo, parentDiagramElementSceneNode);
	}

	// TODO: Rename to match other. Rename parmaeters. parent element scnee nodem ust not be null
	private Node createOrUpdate(ElementMapValue elementInfo, final Node parentDiagramElementSceneNode) {
		Objects.requireNonNull(parentDiagramElementSceneNode, "parentDiagramElementScenenNode must not be null");
		final Graphic graphic = Objects.requireNonNull(elementInfo.diagramElement.getGraphic(),
				"graphic must not be null");

		final DiagramElement childDiagramElement = elementInfo.diagramElement;

		//
		// The following final variables determine the operations that needs to be performed by the remainder of the function.
		// They are set by comparing the previous state with the current state of the diagram element.
		//
		final boolean docked = childDiagramElement.getDockArea() != null;
		final boolean parentIsConnection = parentDiagramElementSceneNode instanceof BaseConnectionNode;
		final boolean create = !Objects.equals(graphic, elementInfo.sourceGraphic) || docked != elementInfo.docked
				|| parentIsConnection != elementInfo.parentIsConnection;
		final boolean addToScene = create || elementInfo.parentDiagramElementSceneNode != parentDiagramElementSceneNode;
		final boolean removeFromScene = addToScene && elementInfo.node != null;

		// Update other fields
		elementInfo.sourceGraphic = graphic;
		elementInfo.docked = docked;
		elementInfo.parentIsConnection = parentIsConnection;

		// Remove the node for the scene graph
		if (removeFromScene) {
			removeNode(elementInfo.node);
		}

		//
		// Create a new node for the diagram element
		//
		if (create) {
			// Create the new node. Create a graphic and then a wrapper as appropriate
			final Node graphicNode = GraphicToFx.createNode(graphic);
			if (graphicNode instanceof BaseConnectionNode) {
				final BaseConnectionNode newConnectionNode = (BaseConnectionNode) graphicNode;
				elementInfo.node = graphicNode;

				// Create the primary label node
				final LabelNode primaryLabel = new LabelNode();
				newConnectionNode.getPrimaryLabels().add(primaryLabel);
				elementInfo.primaryLabel = primaryLabel;
			} else if (graphicNode instanceof LabelNode) {
				elementInfo.node = graphicNode;
			} else if (parentIsConnection) {
				// NOTE: This should only occur for fixed sized graphics
				// Rotate midpoint decorations 180.0 degrees because our connection not expects midpoint decorations to be oriented as if
				// the connection was left to right and that is not how graphics are specified in the graphical editor.
				final Group rotationWrapper = new Group();
				rotationWrapper.getChildren().add(graphicNode);
				rotationWrapper.setRotate(180.0);
				elementInfo.node = rotationWrapper;
			} else {
				if (docked) {
					final DockedShape newDockedShape = new DockedShape();
					newDockedShape.setGraphic(graphicNode);
					elementInfo.node = newDockedShape;

					// Create the primary label node
					final LabelNode primaryLabel = new LabelNode();
					newDockedShape.getPrimaryLabels().add(primaryLabel);
					elementInfo.primaryLabel = primaryLabel;

					// Create annotation node
					final LabelNode annotationLabel = new LabelNode();
					newDockedShape.getSecondaryLabels().add(annotationLabel);
					elementInfo.annotationLabel = annotationLabel;
				} else {
					final ContainerShape newContainerShape = new ContainerShape();
					newContainerShape.setGraphic(graphicNode);
					elementInfo.node = newContainerShape;

					// Create the primary label node
					final LabelNode primaryLabel = new LabelNode();
					newContainerShape.getPrimaryLabels().add(primaryLabel);
					elementInfo.primaryLabel = primaryLabel;
				}
			}

			StyleRoot.set(elementInfo.node, true);
		}

		//
		// Add the node to the appropriate parent
		//
		if (addToScene) {
			if (elementInfo.node instanceof BaseConnectionNode) {
				if (elementInfo.node instanceof FlowIndicatorNode) {
					if (parentDiagramElementSceneNode instanceof ContainerShape) {
						((ContainerShape) parentDiagramElementSceneNode).getFreeChildren().add(elementInfo.node);
					} else {
						throw new RuntimeException(
								"Unexpected parent node for flow indicator: " + parentDiagramElementSceneNode);
					}
				} else {
					diagramNode.getChildren().add(elementInfo.node);
				}
			} else if (elementInfo.node instanceof LabelNode) {
				// Add label to parent
				if (parentDiagramElementSceneNode instanceof ContainerShape) {
					((ContainerShape) parentDiagramElementSceneNode).getSecondaryLabels().add(elementInfo.node);
				} else if (parentDiagramElementSceneNode instanceof DockedShape) {
					((DockedShape) parentDiagramElementSceneNode).getSecondaryLabels().add(elementInfo.node);
				} else if (parentDiagramElementSceneNode instanceof BaseConnectionNode) {
					((BaseConnectionNode) parentDiagramElementSceneNode).getSecondaryLabels().add(elementInfo.node);
				} else {
					throw new RuntimeException("Unexpected parent node for label: " + parentDiagramElementSceneNode);
				}
			} else if (parentIsConnection) {
				((BaseConnectionNode) parentDiagramElementSceneNode).getMidpointDecorations().add(elementInfo.node);
			} else {
				final DockArea dockArea = childDiagramElement.getDockArea();
				if (elementInfo.node instanceof DockedShape) {
					final DockedShape dockedShape = (DockedShape) elementInfo.node;

					// Add the docked shape to the appropriate list
					if (parentDiagramElementSceneNode instanceof ContainerShape) {
						final ContainerShape containerShapeParent = (ContainerShape) parentDiagramElementSceneNode;
						switch (dockArea) {
						case LEFT:
							containerShapeParent.getLeftChildren().add(dockedShape);
							break;
						case RIGHT:
							containerShapeParent.getRightChildren().add(dockedShape);
							break;
						case TOP:
							containerShapeParent.getTopChildren().add(dockedShape);
							break;
						case BOTTOM:
							containerShapeParent.getBottomChildren().add(dockedShape);
							break;
						default:
							throw new RuntimeException(
									"Unexpected dock area for child of container shape: " + dockArea);
						}
					} else if (parentDiagramElementSceneNode instanceof DockedShape) {
						final DockedShape dockedShapeParent = (DockedShape) parentDiagramElementSceneNode;
						dockedShapeParent.getNestedChildren().add(dockedShape);
					} else {
						throw new RuntimeException(
								"Unexpected parent for docked shape: " + parentDiagramElementSceneNode);
					}
				} else {
					if (parentDiagramElementSceneNode instanceof ContainerShape) {
						final ContainerShape containerShapeParent = (ContainerShape) parentDiagramElementSceneNode;
						containerShapeParent.getFreeChildren().add(elementInfo.node);
					} else if (parentDiagramElementSceneNode instanceof Group) {
						((Group) parentDiagramElementSceneNode).getChildren().add(elementInfo.node);
					} else {
						throw new RuntimeException(
								"Unexpected parent node for container shape: " + parentDiagramElementSceneNode);
					}
				}
			}

			elementInfo.parentDiagramElementSceneNode = parentDiagramElementSceneNode;
		}

		return elementInfo.node;
	}

	private void removeNode(final Node node) {
		// Remove the old node from the scene graph. In order to remove the old node the parent is assumed to be a child of a Group
		final Parent graphParent = node.getParent();
		if (graphParent instanceof Group) {
			((Group) graphParent).getChildren().remove(node);
		} else {
			throw new RuntimeException("Unexpected case. Parent is not a group. Child: " + node);
		}
	}

	// TODO: COuld update all but that would be expensive...
	private void updateChildren(final DiagramNode parentDiagramNode) {
		for (final DiagramElement childDiagramElement : parentDiagramNode.getDiagramElements()) {
			updateChildDiagramElement(diagramElementMap.get(childDiagramElement));
			updateChildren(childDiagramElement);
		}
	}

	// TODO: Not recursive. REname?
	// TODO: Rename to childInfo?
	private void updateChildDiagramElement(final ElementMapValue info) {
		final DiagramElement childDiagramElement = info.diagramElement;

		// TODO: Null check. Rename
		final Node node = info.node;

		// Update connections
		if (node instanceof BaseConnectionNode) {
			final BaseConnectionNode connectionNode = (BaseConnectionNode) node;
			final Point transformPoint; // TODO: Rename
			if (node instanceof FlowIndicatorNode) {
				// TODO; Avoid duplication?
				PreferredPosition.set(node, convertPoint(childDiagramElement.getPosition()));

				final Point parentPosition = DiagramElementLayoutUtil.getAbsolutePosition(childDiagramElement);
				transformPoint = new Point(parentPosition.x + childDiagramElement.getX(),
						parentPosition.y + childDiagramElement.getY());
			} else {
				transformPoint = Point.ZERO;
			}

			// Update the connection anchor
			updateConnectionAnchors(childDiagramElement, (BaseConnectionNode) node);

			// Set bendpoints. Coordinates are specified in the diagram model relative to the diagram. The need to be specified relative to the
			// connection's parent node. For regular connection this is the same because the node's parent is the diagram node.
			// However, flow indicators are added as a child to another node based on the parent diagram element.
			connectionNode.setBendpoints(childDiagramElement.getBendpoints().stream()
					.map(p -> new org.eclipse.gef.geometry.planar.Point(p.x - transformPoint.x, p.y - transformPoint.y))
					.collect(Collectors.toList()));

			// TODO: Need to replace connection labels instead of just creating.. Fixed number of primary labels? Could create early and set
			// info

			PreferredPosition.set(info.primaryLabel,
					convertPoint(childDiagramElement.getConnectionPrimaryLabelPosition()));

		} else if (node instanceof LabelNode) {
			// Such a label represents a secondary label
			final LabelNode label = (LabelNode) node; // TODO: Rename?
			label.setText(Strings.nullToEmpty(childDiagramElement.getLabelName()));
			updateLabelNodeVisibilityAndManagement(label);

			// Update element position
			if (info.parentIsConnection) {
				PreferredPosition.set(label, convertPoint(childDiagramElement.getPosition()));
			}
		} else if (node instanceof ContainerShape) {
			final ContainerShape containerShape = (ContainerShape) node;

			// TODO: Can just do this for all things?
			PreferredPosition.set(node, convertPoint(childDiagramElement.getPosition()));

			// TODO: Needed for docked shapes too. Need common interface
			// Set configured size
			final Dimension size = childDiagramElement.getSize();
			if (size == null) {
				containerShape.setConfiguredWidth(ContainerShape.NOT_SPECIFIED);
				containerShape.setConfiguredHeight(ContainerShape.NOT_SPECIFIED);
			} else {
				containerShape.setConfiguredWidth(size.width);
				containerShape.setConfiguredHeight(size.height);
			}
		} else if (node instanceof DockedShape) {
			final DockedShape n = (DockedShape) node; // TODO: Rename

			// TODO: Can just do this for all things?
			PreferredPosition.set(node, convertPoint(childDiagramElement.getPosition()));

			// TODO: Needed for docked shapes too. Need common interface
			// Set configured size
			final Dimension size = childDiagramElement.getSize();
			if (size == null) {
				n.setConfiguredWidth(ContainerShape.NOT_SPECIFIED);
				n.setConfiguredHeight(ContainerShape.NOT_SPECIFIED);
			} else {
				n.setConfiguredWidth(size.width);
				n.setConfiguredHeight(size.height);
			}
		}

		// TODO; Same issue as above
		if (info.primaryLabel != null) {
			// TODO: Compare to avoid excessive update.. Text doesn't appear to do it. Could do it in our label node?
			info.primaryLabel.setText(getPrimaryLabelText(childDiagramElement));
			updateLabelNodeVisibilityAndManagement(info.primaryLabel);
		}

		if (info.annotationLabel != null) {
			// TODO: Compare to avoid excessive update.. see above
			final String annotation = childDiagramElement.getGraphicalConfiguration().getAnnotation();
			info.annotationLabel.setText(Strings.nullToEmpty(annotation));
			updateLabelNodeVisibilityAndManagement(info.annotationLabel);
		}
	}

	// TODO: Rename. Is there already a similar method somewhere?
	private void updateLabelNodeVisibilityAndManagement(final LabelNode n) {
		final boolean visible = !Strings.isNullOrEmpty(n.getText());
		n.setVisible(visible);
		n.setManaged(visible);
	}

	private void updateConnectionAnchors(final DiagramElement de, final BaseConnectionNode node) {
		// TODO: Handle start / end not being valid? Is that allowed? Avoid creating node in that case? Or remove it here if anchor can't be found?

		if (node instanceof FlowIndicatorNode) {
			final FlowIndicatorNode fi = (FlowIndicatorNode) node;
			fi.setStartAnchor(getAnchor(de.getStartElement(), true));
		} else if (node instanceof ConnectionNode) {
			// TODO; Is this inefficient. THe whole use interior anchor thing only makes sense if one of them id a docked shape
			final ConnectionNode cn = (ConnectionNode) node;
			// TODO: Consider whether there is a way to determine whether to use the interior anchor that doesn't involve two function calls
			cn.setStartAnchor(
					getAnchor(de.getStartElement(), useInteriorAnchor(de.getStartElement(), de.getEndElement())));
			cn.setEndAnchor(getAnchor(de.getEndElement(), useInteriorAnchor(de.getEndElement(), de.getStartElement())));
		} else {
			throw new RuntimeException("Unexpected node: " + node);
		}
	}

	// TODO; Should label be created for null values.. This always returns non-null
	// TODO: Rename
	private String getPrimaryLabelText(final DiagramElement de) {
		final String completenessSuffix = de.getCompleteness() == Completeness.INCOMPLETE ? INCOMPLETE_INDICATOR : "";
		final String labelName = de.getLabelName();
		return labelName == null ? "" : (labelName + completenessSuffix);
	}

	// TODO: Rename. Document. Use in more places
	private Point2D convertPoint(final Point p) {
		return p == null ? null : new Point2D(p.x, p.y);
	}

	// TODO: Document
	private IAnchor getAnchor(final DiagramElement de, final boolean useInteriorAnchor) {
		final ElementMapValue info = diagramElementMap.get(de); // TODO: Rename
		if (info == null || info.node == null) {
			return null;
		}

		if (info.node instanceof ContainerShape) {
			return ((ContainerShape) info.node).getAnchor();
		} else if (info.node instanceof DockedShape) {
			final DockedShape ds = (DockedShape) info.node;
			return useInteriorAnchor ? ds.getInteriorAnchor() : ds.getExteriorAnchor();
		} else if (info.node instanceof BaseConnectionNode) {
			return ((BaseConnectionNode) info.node).getMidpointAnchor();
		} else {
			throw new RuntimeException(
					"Unexpected case. Attempt to get anchor for node of type : " + info.node.getClass().getName());
		}
	}

	/**
	 * Refreshes the style of all elements in the diagram
	 */
	public void refreshDiagramStyles() {
		refreshOverrideStyles();

		// Refresh Coloring
		calculateAndApplyStylesForChildren(diagram);
	}

	/**
	 * Rebuilds the override style information using the {@link #refreshOverrideStyles()} and then calculates and applies the final style of the
	 * specified elements. Does not refresh the style of descendant diagram elements.
	 * If the override style information is up to date, it is better to call {@link #calculateAndApplyStyle} for each element
	 * @param elements the element for which to refresh the style.
	 */
	public void refreshStyle(final Collection<DiagramElement> elements) {
		refreshOverrideStyles();
		for (final DiagramElement de : elements) {
			calculateAndApplyStyle(diagramElementMap.get(de));
		}
	}

	/**
	 * Determines the final style and applies it to the diagram element
	 * Assumes override style information has been updated using {@link #refreshOverrideStyles()}
	 * @paraminfo the info for which to refresh the style
	 */
	private void calculateAndApplyStyle(final ElementMapValue info) {
		if (info != null && info.node != null) {
			final Style style = finalStyleProvider.getStyle(info.diagramElement);
			final FxStyle fxStyle = styleToFx.createStyle(style);
			FxStyleApplier.applyStyle(info.node, fxStyle);
		}
	}

	/**
	 * Visits the children of the specified diagram node and their descendants and calculates and applies the style
	 * Assumes override style information has been updated using {@link #refreshOverrideStyles()}
	 * using {@link #calculateAndApplyStyle(DiagramElement)}.
	 * @param n the node to calculate apply the style for
	 */
	private void calculateAndApplyStylesForChildren(final DiagramNode n) {
		for (final DiagramElement child : n.getDiagramElements()) {
			calculateAndApplyStylesForChildren(child);
			calculateAndApplyStyle(diagramElementMap.get(child));
		}
	}

	/**
	 * Updates the cache of override style using {@link ColoringService}.
	 */
	private void refreshOverrideStyles() {
		overrideStyles = coloringService.buildForegroundColorMap().entrySet().stream()
				.collect(Collectors.toMap(Entry::getKey, v -> {
					return StyleBuilder.create().foregroundColor(v.getValue()).build();
				}));
	}

	/**
	 * Triggers a layout of the scene graph nodes and then updates the diagram with the layout.
	 */
	// TODO: Need to confirm that if an element is added that its bounds are correct at the time this is called. Could have an issue similar to
	// to the initial update. Will it work for scene graph nodes that are newly added or if the scene is not being displayed?
	private void updateDiagramLayoutFromSceneGraph() {
		syncingWithSceneGraph = true;
		diagramNode.layout();
		diagram.modify("Sync Layout", m -> updateDiagramElementsWithFxLayout(m, false));
		syncingWithSceneGraph = false;
	}

	// TODO; Rename
	// TODO: Rename arguments
	// TODO; special handling of feature groups and ports, etc at least for initial. Or an appropriately named flag
	// TODO; is this really the best way?
	// On the initial update, values that are stored in the diagram element but which are determined by the JavaFX nodes are not updated.
	// An example of this is the X value for shapes docked to the left or right side of a container.
	// The goal is is to avoid changing diagram elements when diagrams created with Graphiti.
	// Due to the changes in text rendering, the calculated sizes for labels are different.
	private void updateDiagramElementsWithFxLayout(final DiagramModification m, final boolean initial) {
		for (final Entry<DiagramElement, ElementMapValue> e : this.diagramElementMap.entrySet()) {
			final DiagramElement de = e.getKey();
			final Node n = e.getValue().node;

			final DiagramNode parent = de.getParent();
			if (DiagramElementPredicates.isMoveable(de) && (!(parent instanceof DiagramElement)
					|| !DiagramElementPredicates.isConnection((DiagramElement) parent))) {

				if (initial && n instanceof DockedShape && de.hasPosition()) {
					final DockedShape ds = (DockedShape) n;

					// TODO; Different check needed?
					if (ds.getSide().vertical) {
						m.setPosition(de, new Point(de.getX(), n.getLayoutY()));
					} else {
						m.setPosition(de, new Point(n.getLayoutX(), de.getY()));
					}
				} else {
					m.setPosition(de, new Point(n.getLayoutX(), n.getLayoutY()));
				}
			}

			// Set the size for all elements. Even for non-resizable elements, the layout engine uses the sizes in the diagram.
			// This is important for secondary labels of connections.
			final Bounds layoutBounds = n.getLayoutBounds();

			if (initial && n instanceof DockedShape && de.hasSize()) {
				final DockedShape ds = (DockedShape) n;
				if (ds.getSide().vertical) {
					m.setSize(de, new Dimension(de.getWidth(), layoutBounds.getHeight()));
				} else {
					m.setSize(de, new Dimension(layoutBounds.getWidth(), de.getHeight()));
				}
			} else {
				m.setSize(de, new Dimension(layoutBounds.getWidth(), layoutBounds.getHeight()));
			}

			// TODO: Ignore preferred position and just try to set?

			// TODO: Need to handle different node types and also transform points in some cases?

			// TODO; Configured size.. That doesn't need to be configured either.. may need to be compared with? Or just set or certain elements?

			// TODO; What needs to be synchronized

		}
	}

	// TODO: Rename?
	public Group getNode() {
		return diagramNode;
	}

	/**
	 * Returns whether the connection going from e1 to e2 should use the interior anchor for e1 if it exists.
	 * @param e1
	 * @param e2
	 * @return
	 */
	private static boolean useInteriorAnchor(final DiagramElement e1, final DiagramElement e2) {
		return isInsideUndockedContainer(e2, e1);
	}

	/**
	 * Returns whether e1 is inside the first undocked container in the hierarchy of e2
	 * @param e1
	 * @param e2
	 * @return
	 */
	private static boolean isInsideUndockedContainer(final DiagramElement e1, final DiagramElement e2) {
		// Get the first diagram element in each hierarchy which doesn't have a dock area set.
		DiagramNode nd2 = e2;
		while (nd2 instanceof DiagramElement && ((DiagramElement) nd2).getDockArea() != null) {
			nd2 = nd2.getParent();
		}

		if (!(nd2 instanceof DiagramElement)) {
			return false;
		}

		// Check if e1 is inside the first undocked element in the e2 hierarchy
		for (DiagramNode t1 = e1; t1 != null; t1 = t1.getParent()) {
			if (t1 == nd2) {
				return true;
			}
		}

		return false;
	}

	@Override
	public Dimension getPrimaryLabelSize(final DiagramElement de) {
		// TODO: Check managed state?
		final ElementMapValue v = diagramElementMap.get(de);
		if (v == null || v.primaryLabel == null) {
			return Dimension.ZERO;
		}

		return new Dimension(v.primaryLabel.getWidth(), v.primaryLabel.getHeight());
	}

	@Override
	public Dimension getAnnotationLabelSize(final DiagramElement de) {
		// TODO: Check managed state?
		final ElementMapValue v = diagramElementMap.get(de);
		if (v == null || v.annotationLabel == null) {
			return Dimension.ZERO;
		}

		return new Dimension(v.annotationLabel.getWidth(), v.annotationLabel.getHeight());
	}

	// TODO: Does this needto be part of GefAgeDiagram?
	// TODO ;REname. Move
	private static final Dimension FEATURE_GROUP_CIRCLE_SIZE = new Dimension(FeatureGroupNode.CIRCLE_DIAMETER,
			FeatureGroupNode.CIRCLE_DIAMETER);
	private static final Dimension DEFAULT_FEATURE_SIZE = new Dimension(FeatureConstants.WIDTH,
			FeatureConstants.HEIGHT);

	@Override
	public Dimension getPortGraphicSize(final DiagramElement dockedElement) {
		final Graphic g = dockedElement.getGraphic();
		if (g instanceof FeatureGraphic) {
			final FeatureGraphic fg = (FeatureGraphic) g;
			if (fg.featureType == FeatureGraphicType.FEATURE_GROUP) {
				return FEATURE_GROUP_CIRCLE_SIZE;
			}
		}

		// Return the default feature size regardless of the type of graphic
		return DEFAULT_FEATURE_SIZE;
	}

	@Override
	public Dimension getDockedElementLabelsSize(final DiagramElement dockedElement) {
		final ElementMapValue v = diagramElementMap.get(dockedElement);
		if (v != null && v.node instanceof DockedShape) {
			final DockedShape ds = (DockedShape) v.node;
			return new Dimension(ds.getMaxLabelWidth(), ds.getTotalLabelHeight());
		} else {
			return Dimension.ZERO;
		}
	}
}
