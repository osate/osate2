/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
import org.eclipse.swt.widgets.Display;
import org.osate.ge.gef.AgeGefRuntimeException;
import org.osate.ge.gef.BaseConnectionNode;
import org.osate.ge.gef.ConnectionNode;
import org.osate.ge.gef.ContainerShape;
import org.osate.ge.gef.DiagramRootNode;
import org.osate.ge.gef.DockedShape;
import org.osate.ge.gef.FeatureConstants;
import org.osate.ge.gef.FeatureGroupNode;
import org.osate.ge.gef.FlowIndicatorNode;
import org.osate.ge.gef.FxStyle;
import org.osate.ge.gef.FxStyleApplier;
import org.osate.ge.gef.ImageManager;
import org.osate.ge.gef.LabelNode;
import org.osate.ge.gef.PreferredPosition;
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
import org.osate.ge.internal.services.ColoringService;

import com.google.common.base.Strings;

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
	private static final Dimension FEATURE_GROUP_CIRCLE_SIZE = new Dimension(FeatureGroupNode.CIRCLE_DIAMETER,
			FeatureGroupNode.CIRCLE_DIAMETER);
	private static final Dimension DEFAULT_FEATURE_SIZE = new Dimension(FeatureConstants.WIDTH,
			FeatureConstants.HEIGHT);

	/**
	 * Contains the details regarding how a diagram element is represented in the scene graph.
	 */
	private static class GefDiagramElement {
		public GefDiagramElement(final DiagramElement diagramElement) {
			this.diagramElement = diagramElement;
		}

		final DiagramElement diagramElement;

		/**
		 * The node which represents the diagram element in the scene graph
		 */
		Node sceneNode;

		/**
		 * The graphic which was used to create the current scene node.
		 */
		Graphic sourceGraphic;

		/**
		 * The scene node which represents the diagram element's parent in the scene graph
		 */
		Node parentDiagramNodeSceneNode;

		LabelNode primaryLabel;
		LabelNode annotationLabel;
	}

	/**
	 * The diagram for which nodes are created and updated.
	 */
	private final AgeDiagram diagram;

	/**
	 * A mapping between the diagram elements and {@link GefDiagramElement} instances.
	 */
	private final Map<DiagramElement, GefDiagramElement> diagramElementToGefDiagramElementMap = new HashMap<>();

	/**
	 * A mapping between scene nodes and {@link GefDiagramElement} instances.
	 */
	private final Map<Node, GefDiagramElement> sceneNodeToGefDiagramElementMap = new HashMap<>();

	/**
	 * Root node which contains all the shape and connection nodes for the diagram.
	 */
	private final DiagramRootNode diagramNode = new DiagramRootNode();

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

	/**
	 * True if the diagram is currently being updated based on the position and size of scene graph nodes. Avoids changing
	 * the scene graph nodes based on such changes to the diagram.
	 */
	private boolean updatingDiagramFromSceneGraph = false;

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
					&& !updatingDiagramFromSceneGraph) {
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
			if (updatingDiagramFromSceneGraph) {
				return;
			}

			// Ensure that the modification is executed in the user interface thread.
			Display.getDefault().syncExec(() -> {
				try {
					inBeforeModificationsCompleted = true;

					// Remove elements
					for (final DiagramElement de : elementsToRemove) {
						// Remove any contained connections first. Connections are stored at the diagram level so they need to be
						// deleted individually.
						removeContainedConnections(de);

						final GefDiagramElement ge = diagramElementToGefDiagramElementMap.get(de);
						if (ge != null && ge.sceneNode != null) {
							removeNode(ge.sceneNode);
						}

						// Remove the mapping
						removeMappingForBranch(de);
					}

					if (needFullUpdate) {
						updateSceneGraph();
						forceLayout();
					} else {
						// Refresh override styles to prepare to apply styles to updated elements
						refreshOverrideStyles();

						// Ensure that the scene graph nodes have been created and/or switched to the appropriate type
						for (final DiagramElement de : elementsToUpdate) {
							final GefDiagramElement ge = diagramElementToGefDiagramElementMap.get(de);
							if (ge != null) {
								ensureSceneNodeExists(ge, ge.parentDiagramNodeSceneNode);
							}
						}

						// Update modified elements
						for (final DiagramElement de : elementsToUpdate) {
							final GefDiagramElement ge = diagramElementToGefDiagramElementMap.get(de);
							updateSceneNode(ge);
							calculateAndApplyStyle(ge);
						}

						forceLayout();
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
			final GefDiagramElement removed = diagramElementToGefDiagramElementMap.remove(de);
			if (removed != null && removed.sceneNode != null) {
				sceneNodeToGefDiagramElementMap.remove(removed.sceneNode);
			}
		}

		/**
		 * Removes all connections contained in the specified element or its descendants.
		 */
		private void removeContainedConnections(final DiagramElement e) {
			for (final DiagramElement childDiagramElement : e.getDiagramElements()) {
				final GefDiagramElement childGefDiagramElement = diagramElementToGefDiagramElementMap
						.get(childDiagramElement);
				removeContainedConnections(childDiagramElement);

				if (childGefDiagramElement != null && childGefDiagramElement.sceneNode instanceof ConnectionNode) {
					removeNode(childGefDiagramElement.sceneNode);
				}
			}
		}
	};

	/**
	 * Creates a new instance
	 * @param diagram the diagram for which JavaFX node will be created and updated.
	 * @param coloringService service to use to support determining the final style of nodes.
	 */
	public GefAgeDiagram(final AgeDiagram diagram, final ColoringService coloringService) {
		this.coloringService = Objects.requireNonNull(coloringService, "coloringService must not be null");
		this.diagram = Objects.requireNonNull(diagram, "diagram must not be null");
		this.finalStyleProvider = new StyleCalculator(diagram.getConfiguration(), de -> overrideStyles.get(de));

		updateSceneGraph();
		updateDiagramFromSceneGraph();

		// Register our modification listener to update the scene graph based on changes
		diagram.addModificationListener(modificationListener);
	}

	@Override
	public void close() {
		diagram.removeModificationListener(modificationListener);
		imageManager.close();
	};

	/**
	 * Finds the diagram element for a scene node. Only works for the node that serves as the root of the branch for the diagram element.
	 * @param sceneNode the node for which to find the diagram element
	 * @return the diagram element which the node represents or null if one cannot be found.
	 */
	public DiagramElement getDiagramElement(final Node sceneNode) {
		final GefDiagramElement ge = sceneNodeToGefDiagramElementMap.get(sceneNode);
		return ge == null ? null : ge.diagramElement;
	}

	/**
	 * Finds the scene node for a diagram element.
	 * @param diagramNode the diagram node for which to find the scene node
	 * @return the scene node which represents the diagram node or null if one cannot be found.
	 */
	public Node getSceneNode(final DiagramNode diagramNode) {
		if (diagramNode == diagram) {
			return this.diagramNode;
		}

		final GefDiagramElement ge = diagramElementToGefDiagramElementMap.get(diagramNode);
		return ge == null ? null : ge.sceneNode;
	}

	/**
	 * Check for changes in refrenced images and updates the diagram as appropriate.
	 */
	public void refreshImages() {
		imageManager.refreshImages();
	}

	/**
	 * Performs a full update of the scene graph based on the diagram. Ensures nodes exist, that they are updated, and have appropriate styles.
	 */
	public void updateSceneGraph() {
		ensureSceneNodesExistForChildren(diagram, diagramNode);
		updateSceneNodesForChildren(diagram);
		refreshDiagramStyles();
	}

	/**
	 * Ensures the scene node exists for the children of a diagram node.
	 * Creates or recreates scene graph nodes and adds to the scene graph as necessary. Populates {@link #diagramElementToGefDiagramElementMap}.
	 * @param parentDiagramNode the diagram node for which scene nodes will be created for its children.
	 * @param parentDiagramNodeSceneNode the scene node for the parent diagram node
	 * @return the created or updated JavaFX node
	 */
	private void ensureSceneNodesExistForChildren(final DiagramNode parentDiagramNode,
			final Node parentDiagramNodeSceneNode) {
		for (final DiagramElement childDiagramElement : parentDiagramNode.getDiagramElements()) {
			final GefDiagramElement childGefDiagramElement = diagramElementToGefDiagramElementMap
					.computeIfAbsent(childDiagramElement, e -> new GefDiagramElement(childDiagramElement));
			final Node childSceneNode = ensureSceneNodeExists(childGefDiagramElement, parentDiagramNodeSceneNode);
			ensureSceneNodesExistForChildren(childDiagramElement, childSceneNode);
		}
	}

	/**
	 * Ensures that a scene node exists for the specified GEF diagram element.
	 * Creates or recreates scene nodes and adds to the scene graph as necessary. Updates the specified GEF diagram element.
	 * @param gefDiagramElement the GEF diagram element for which to ensure that the scene node exists.
	 * @param parentDiagramElementSceneNode the scene node for the parent of the GEF diagram element. This is specified instead of using
	 * the value contained in the GEF diagram element because it may not be up to date.
	 * @return the scene node for the diagram element. This specified GEF diagram element will be updated to hold this value.
	 */
	private Node ensureSceneNodeExists(GefDiagramElement gefDiagramElement, final Node parentDiagramElementSceneNode) {
		Objects.requireNonNull(parentDiagramElementSceneNode, "parentDiagramElementScenenNode must not be null");
		final Graphic graphic = Objects.requireNonNull(gefDiagramElement.diagramElement.getGraphic(),
				"graphic must not be null");

		final DiagramElement childDiagramElement = gefDiagramElement.diagramElement;

		//
		// The following final variables determine the operations that needs to be performed by the remainder of the function.
		// They are set by comparing the previous state with the current state of the diagram element.
		//
		final boolean docked = childDiagramElement.getDockArea() != null;
		final boolean parentIsConnection = parentDiagramElementSceneNode instanceof BaseConnectionNode;
		final boolean create = !Objects.equals(graphic, gefDiagramElement.sourceGraphic)
				|| docked != gefDiagramElement.sceneNode instanceof DockedShape
				|| parentIsConnection != gefDiagramElement.parentDiagramNodeSceneNode instanceof BaseConnectionNode;
		final boolean addToScene = create
				|| gefDiagramElement.parentDiagramNodeSceneNode != parentDiagramElementSceneNode;
		final boolean removeFromScene = addToScene && gefDiagramElement.sceneNode != null;

		// Update other fields
		gefDiagramElement.sourceGraphic = graphic;

		// Remove the node for the scene graph
		if (removeFromScene) {
			removeNode(gefDiagramElement.sceneNode);
		}

		//
		// Create a new node for the diagram element
		//
		if (create) {
			// Remove mapping to old scene node
			if (gefDiagramElement.sceneNode != null) {
				sceneNodeToGefDiagramElementMap.remove(gefDiagramElement.sceneNode);
			}

			// Create the new node. Create a graphic and then a wrapper as appropriate
			final Node graphicNode = GraphicToFx.createNode(graphic);
			if (graphicNode instanceof BaseConnectionNode) {
				final BaseConnectionNode newConnectionNode = (BaseConnectionNode) graphicNode;
				gefDiagramElement.sceneNode = graphicNode;

				// Create the primary label node
				final LabelNode primaryLabel = new LabelNode();
				newConnectionNode.getPrimaryLabels().add(primaryLabel);
				gefDiagramElement.primaryLabel = primaryLabel;
			} else if (graphicNode instanceof LabelNode) {
				gefDiagramElement.sceneNode = graphicNode;
			} else if (parentIsConnection) {
				// NOTE: This should only occur for fixed sized graphics
				// Rotate midpoint decorations 180.0 degrees because our connection not expects midpoint decorations to be oriented as if
				// the connection was left to right and that is not how graphics are specified in the graphical editor.
				final Group rotationWrapper = new Group();
				rotationWrapper.getChildren().add(graphicNode);
				rotationWrapper.setRotate(180.0);
				gefDiagramElement.sceneNode = rotationWrapper;
			} else {
				if (docked) {
					final DockedShape newDockedShape = new DockedShape();
					newDockedShape.setGraphic(graphicNode);
					gefDiagramElement.sceneNode = newDockedShape;

					// Create the primary label node
					final LabelNode primaryLabel = new LabelNode();
					newDockedShape.getPrimaryLabels().add(primaryLabel);
					gefDiagramElement.primaryLabel = primaryLabel;

					// Create annotation node
					final LabelNode annotationLabel = new LabelNode();
					newDockedShape.getSecondaryLabels().add(annotationLabel);
					gefDiagramElement.annotationLabel = annotationLabel;
				} else {
					final ContainerShape newContainerShape = new ContainerShape();
					newContainerShape.setGraphic(graphicNode);
					gefDiagramElement.sceneNode = newContainerShape;

					// Create the primary label node
					final LabelNode primaryLabel = new LabelNode();
					newContainerShape.getPrimaryLabels().add(primaryLabel);
					gefDiagramElement.primaryLabel = primaryLabel;
				}
			}

			// Add mapping to scene node
			if (gefDiagramElement.sceneNode != null) {
				sceneNodeToGefDiagramElementMap.put(gefDiagramElement.sceneNode, gefDiagramElement);
			}

			StyleRoot.set(gefDiagramElement.sceneNode, true);
		}

		//
		// Add the node to the appropriate parent
		//
		if (addToScene) {
			if (gefDiagramElement.sceneNode instanceof BaseConnectionNode) {
				diagramNode.getChildren().add(gefDiagramElement.sceneNode);

				// Flow indicators are positioned relative to the scene node of the parent diagram element
				if (gefDiagramElement.sceneNode instanceof FlowIndicatorNode) {
					if (parentDiagramElementSceneNode instanceof ContainerShape) {
						((FlowIndicatorNode) gefDiagramElement.sceneNode)
								.setPositioningReference(parentDiagramElementSceneNode);
					} else {
						throw new AgeGefRuntimeException(
								"Unexpected parent diagram element scene node for flow indicator: "
										+ parentDiagramElementSceneNode);
					}
				}
			} else if (gefDiagramElement.sceneNode instanceof LabelNode) {
				// Add label to parent
				if (parentDiagramElementSceneNode instanceof ContainerShape) {
					((ContainerShape) parentDiagramElementSceneNode).getSecondaryLabels()
							.add(gefDiagramElement.sceneNode);
				} else if (parentDiagramElementSceneNode instanceof DockedShape) {
					((DockedShape) parentDiagramElementSceneNode).getSecondaryLabels().add(gefDiagramElement.sceneNode);
				} else if (parentDiagramElementSceneNode instanceof BaseConnectionNode) {
					((BaseConnectionNode) parentDiagramElementSceneNode).getSecondaryLabels()
							.add(gefDiagramElement.sceneNode);
				} else {
					throw new AgeGefRuntimeException(
							"Unexpected parent node for label: " + parentDiagramElementSceneNode);
				}
			} else if (parentIsConnection) {
				((BaseConnectionNode) parentDiagramElementSceneNode).getMidpointDecorations()
						.add(gefDiagramElement.sceneNode);
			} else {
				final DockArea dockArea = childDiagramElement.getDockArea();
				if (gefDiagramElement.sceneNode instanceof DockedShape) {
					final DockedShape dockedShape = (DockedShape) gefDiagramElement.sceneNode;

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
							throw new AgeGefRuntimeException(
									"Unexpected dock area for child of container shape: " + dockArea);
						}
					} else if (parentDiagramElementSceneNode instanceof DockedShape) {
						final DockedShape dockedShapeParent = (DockedShape) parentDiagramElementSceneNode;
						dockedShapeParent.getNestedChildren().add(dockedShape);
					} else {
						throw new AgeGefRuntimeException(
								"Unexpected parent for docked shape: " + parentDiagramElementSceneNode);
					}
				} else {
					if (parentDiagramElementSceneNode instanceof ContainerShape) {
						final ContainerShape containerShapeParent = (ContainerShape) parentDiagramElementSceneNode;
						containerShapeParent.getFreeChildren().add(gefDiagramElement.sceneNode);
					} else if (parentDiagramElementSceneNode instanceof Group) {
						((Group) parentDiagramElementSceneNode).getChildren().add(gefDiagramElement.sceneNode);
					} else {
						throw new AgeGefRuntimeException(
								"Unexpected parent node for container shape: " + parentDiagramElementSceneNode);
					}
				}
			}

			gefDiagramElement.parentDiagramNodeSceneNode = parentDiagramElementSceneNode;
		}

		return gefDiagramElement.sceneNode;
	}

	private void removeNode(final Node node) {
		// Remove the old node from the scene graph. In order to remove the old node the parent is assumed to be a child of a Group
		final Parent graphParent = node.getParent();
		if (graphParent instanceof Group) {
			((Group) graphParent).getChildren().remove(node);
		} else {
			throw new AgeGefRuntimeException("Unexpected case. Parent is not a group. Child: " + node);
		}
	}

	/**
	 * Updates the properties of the scene nodes for the children of the specified diagram node.
	 * Only updates properties which do not effect the structure of the scene graph. Recursive
	 * @param parentDiagramNode the diagram node for which scene nodes associated with its children will be updated.
	 */
	private void updateSceneNodesForChildren(final DiagramNode parentDiagramNode) {
		for (final DiagramElement childDiagramElement : parentDiagramNode.getDiagramElements()) {
			updateSceneNode(diagramElementToGefDiagramElementMap.get(childDiagramElement));
			updateSceneNodesForChildren(childDiagramElement);
		}
	}

	/**
	 * Updates the scene nodes related to the specified GEF diagram element based on the diagram element.
	 * Only updates properties which do not effect the structure of the scene graph. Not-recursive
	 * @param gefDiagramElement is the GEF diagram element for which scene nodes will be updated.
	 */
	private void updateSceneNode(final GefDiagramElement gefDiagramElement) {
		final DiagramElement diagramElement = gefDiagramElement.diagramElement;
		final Node sceneNode = gefDiagramElement.sceneNode;

		// Update connections
		if (sceneNode instanceof BaseConnectionNode) {
			final BaseConnectionNode connectionNode = (BaseConnectionNode) sceneNode;
			final Point controlPointOrigin;
			if (sceneNode instanceof FlowIndicatorNode) {
				PreferredPosition.set(sceneNode, convertPoint(diagramElement.getPosition()));

				final Point parentPosition = DiagramElementLayoutUtil.getAbsolutePosition(diagramElement);
				controlPointOrigin = new Point(parentPosition.x + diagramElement.getX(),
						parentPosition.y + diagramElement.getY());
			} else {
				controlPointOrigin = Point.ZERO;
			}

			// Update the connection anchor
			updateConnectionAnchors(diagramElement, (BaseConnectionNode) sceneNode);

			// Set control points. Coordinates are specified in the diagram model relative to the diagram. The need to be specified relative to the
			// connection position. For regular connection this is the same because the node's parent is the diagram node.
			// However, flow indicators have a position and have parent nodes other than the diagram.
			connectionNode.getInnerConnection().setControlPoints(diagramElement.getBendpoints().stream().map(
					p -> new org.eclipse.gef.geometry.planar.Point(p.x - controlPointOrigin.x, p.y - controlPointOrigin.y))
					.collect(Collectors.toList()));

			PreferredPosition.set(gefDiagramElement.primaryLabel,
					convertPoint(diagramElement.getConnectionPrimaryLabelPosition()));

		} else if (sceneNode instanceof LabelNode) {
			// Such a label represents a secondary label
			final LabelNode label = (LabelNode) sceneNode;
			label.setText(Strings.nullToEmpty(diagramElement.getLabelName()));
			setLabelVisibility(label);

			// Update element position
			if (gefDiagramElement.parentDiagramNodeSceneNode instanceof BaseConnectionNode) {
				PreferredPosition.set(label, convertPoint(diagramElement.getPosition()));
			}
		} else if (sceneNode instanceof ContainerShape) {
			final ContainerShape containerShape = (ContainerShape) sceneNode;

			PreferredPosition.set(sceneNode, convertPoint(diagramElement.getPosition()));

			// Set configured size
			final Dimension size = diagramElement.getSize();
			if (size == null) {
				containerShape.setConfiguredWidth(ContainerShape.NOT_SPECIFIED);
				containerShape.setConfiguredHeight(ContainerShape.NOT_SPECIFIED);
			} else {
				containerShape.setConfiguredWidth(size.width);
				containerShape.setConfiguredHeight(size.height);
			}
		} else if (sceneNode instanceof DockedShape) {
			final DockedShape n = (DockedShape) sceneNode;

			PreferredPosition.set(sceneNode, convertPoint(diagramElement.getPosition()));

			// Set configured size
			final Dimension size = diagramElement.getSize();
			if (size == null) {
				n.setConfiguredWidth(ContainerShape.NOT_SPECIFIED);
				n.setConfiguredHeight(ContainerShape.NOT_SPECIFIED);
			} else {
				n.setConfiguredWidth(size.width);
				n.setConfiguredHeight(size.height);
			}
		}

		// Update the primary label
		if (gefDiagramElement.primaryLabel != null) {
			gefDiagramElement.primaryLabel.setText(getPrimaryLabelText(diagramElement));
			setLabelVisibility(gefDiagramElement.primaryLabel);
			gefDiagramElement.primaryLabel
					.setWrapText(diagramElement.getGraphicalConfiguration().isPrimaryLabelIsMultiline());
		}

		// Update the secondary label
		if (gefDiagramElement.annotationLabel != null) {
			final String annotation = diagramElement.getGraphicalConfiguration().getAnnotation();
			gefDiagramElement.annotationLabel.setText(Strings.nullToEmpty(annotation));
			setLabelVisibility(gefDiagramElement.annotationLabel);
		}
	}

	private void updateConnectionAnchors(final DiagramElement de, final BaseConnectionNode node) {
		if (node instanceof FlowIndicatorNode) {
			final FlowIndicatorNode fi = (FlowIndicatorNode) node;
			fi.setStartAnchor(GefAgeDiagramUtil.getAnchor(this, de.getStartElement(), null));
		} else if (node instanceof ConnectionNode) {
			final ConnectionNode cn = (ConnectionNode) node;
			cn.setStartAnchor(GefAgeDiagramUtil.getAnchor(this, de.getStartElement(), de.getEndElement()));
			cn.setEndAnchor(GefAgeDiagramUtil.getAnchor(this, de.getEndElement(), de.getStartElement()));
		} else {
			throw new AgeGefRuntimeException("Unexpected node: " + node);
		}
	}

	/**
	 * Determines the text to use for the primary label.
	 * @param de the diagram element to determine the primary label text for
	 * @return the primary label text. Guaranteed to be non-null.
	 */
	private String getPrimaryLabelText(final DiagramElement de) {
		final String completenessSuffix = de.getCompleteness() == Completeness.INCOMPLETE ? INCOMPLETE_INDICATOR : "";
		final String labelName = de.getLabelName();
		return labelName == null ? "" : (labelName + completenessSuffix);
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
			calculateAndApplyStyle(diagramElementToGefDiagramElementMap.get(de));
		}
	}

	/**
	 * Determines the final style and applies it to the diagram element
	 * Assumes override style information has been updated using {@link #refreshOverrideStyles()}
	 * @param gefDiagramElement the GEF diagram element for which to refresh the style
	 */
	private void calculateAndApplyStyle(final GefDiagramElement gefDiagramElement) {
		if (gefDiagramElement != null && gefDiagramElement.sceneNode != null) {
			final Style style = finalStyleProvider.getStyle(gefDiagramElement.diagramElement);
			final FxStyle fxStyle = styleToFx.createStyle(style);
			FxStyleApplier.applyStyle(gefDiagramElement.sceneNode, fxStyle);
		}
	}

	/**
	 * Visits the children of the specified diagram node and their descendants and calculates and applies the style
	 * Assumes override style information has been updated using {@link #refreshOverrideStyles()}
	 * using {@link #calculateAndApplyStyle(DiagramElement)}.
	 * @param n the node to calculate apply the style for
	 */
	private void calculateAndApplyStylesForChildren(final DiagramNode n) {
		for (final DiagramElement childDiagramElement : n.getDiagramElements()) {
			calculateAndApplyStylesForChildren(childDiagramElement);
			calculateAndApplyStyle(diagramElementToGefDiagramElementMap.get(childDiagramElement));
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
	 * Triggers an immediate layout
	 */
	private void forceLayout() {
		diagramNode.applyCss();
		diagramNode.layout();
	}

	/**
	 * Triggers a layout of the scene graph nodes and then updates the diagram based on the layout of the scene graph nodes.
	 * Only position and size are set because those fields are calculated by the scene graph node during layout.	 *
	 * Should only be called after the root node has been added to a scene.
	 * @param m the modification to use to modify the diagram elements
	 */
	public void updateDiagramFromSceneGraph() {
		updatingDiagramFromSceneGraph = true;
		forceLayout();
		diagram.modify("Update Diagram from Scene Graph", m -> {
			for (final Entry<DiagramElement, GefDiagramElement> e : this.diagramElementToGefDiagramElementMap
					.entrySet()) {
				final DiagramElement de = e.getKey();
				final Node sceneNode = e.getValue().sceneNode;

				final DiagramNode parent = de.getParent();
				if (DiagramElementPredicates.isMoveable(de) && (!(parent instanceof DiagramElement)
						|| !DiagramElementPredicates.isConnection((DiagramElement) parent))) {
					final double newX = sceneNode.getLayoutX();
					final double newY = sceneNode.getLayoutY();
					if (de.hasPosition() || (newX != 0.0 || newY != 0)) {
						m.setPosition(de, new Point(newX, newY));
					}
				}

				// Set the size for all elements. Even for non-resizable elements, the layout engine uses the sizes in the diagram.
				// This is important for secondary labels of connections.
				final Bounds layoutBounds = sceneNode.getLayoutBounds();
				if (de.hasSize() || (layoutBounds.getWidth() != 0.0 || layoutBounds.getHeight() != 0)) {
					m.setSize(de, new Dimension(layoutBounds.getWidth(), layoutBounds.getHeight()));
				}
			}
		});
		updatingDiagramFromSceneGraph = false;
	}

	/**
	 * Return the JavaFX node for the diagram.
	 * @return the root scene graph node for the diagram.
	 */
	public DiagramRootNode getSceneNode() {
		return diagramNode;
	}

	/**
	 * Provides access to the diagram represented by the scene graph.
	 * @return the diagram which is represented by the scene graph.
	 */
	public AgeDiagram getDiagram() {
		return diagram;
	}

	@Override
	public Dimension getPrimaryLabelSize(final DiagramElement de) {
		final GefDiagramElement ge = diagramElementToGefDiagramElementMap.get(de);
		if (ge == null || ge.primaryLabel == null || !ge.primaryLabel.isManaged()) {
			return Dimension.ZERO;
		}

		return new Dimension(ge.primaryLabel.computePrefWidth(-1), ge.primaryLabel.computePrefHeight(-1));
	}

	@Override
	public Dimension getAnnotationLabelSize(final DiagramElement de) {
		final GefDiagramElement ge = diagramElementToGefDiagramElementMap.get(de);
		if (ge == null || ge.annotationLabel == null || !ge.annotationLabel.isManaged()) {
			return Dimension.ZERO;
		}

		return new Dimension(ge.annotationLabel.computePrefWidth(-1), ge.annotationLabel.computePrefHeight(-1));
	}

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
	public Dimension getDockedElementLabelsSize(final DiagramElement dockedDiagramElement) {
		final GefDiagramElement dockedGefDiagramElement = diagramElementToGefDiagramElementMap
				.get(dockedDiagramElement);
		if (dockedGefDiagramElement != null && dockedGefDiagramElement.sceneNode instanceof DockedShape) {
			final DockedShape ds = (DockedShape) dockedGefDiagramElement.sceneNode;
			return new Dimension(ds.getMaxPrefLabelWidth(), ds.getTotalLabelHeight());
		} else {
			return Dimension.ZERO;
		}
	}

	/**
	 * Sets whether the label is managed and visible based on whether the label is empty.
	 * @param label the label to update.
	 */
	private static void setLabelVisibility(final LabelNode label) {
		final boolean visible = !Strings.isNullOrEmpty(label.getText());
		label.setVisible(visible);
		label.setManaged(visible);
	}

	/**
	 * Converts a graphical editor point to a JavaFX point object.
	 * @param p the graphical editor point
	 * @return the JavaFX point.
	 */
	private static Point2D convertPoint(final Point p) {
		return p == null ? null : new Point2D(p.x, p.y);
	}
}
