package org.osate.ge.internal.diagram.runtime.layout;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.elk.core.IGraphLayoutEngine;
import org.eclipse.elk.core.RecursiveGraphLayoutEngine;
import org.eclipse.elk.core.math.KVector;
import org.eclipse.elk.core.options.CoreOptions;
import org.eclipse.elk.core.options.NodeLabelPlacement;
import org.eclipse.elk.core.options.PortSide;
import org.eclipse.elk.core.options.SizeConstraint;
import org.eclipse.elk.core.service.LayoutMapping;
import org.eclipse.elk.core.util.BasicProgressMonitor;
import org.eclipse.elk.core.util.ElkUtil;
import org.eclipse.elk.core.util.IGraphElementVisitor;
import org.eclipse.elk.graph.ElkEdge;
import org.eclipse.elk.graph.ElkEdgeSection;
import org.eclipse.elk.graph.ElkGraphElement;
import org.eclipse.elk.graph.ElkGraphPackage;
import org.eclipse.elk.graph.ElkLabel;
import org.eclipse.elk.graph.ElkNode;
import org.eclipse.elk.graph.ElkPort;
import org.eclipse.elk.graph.ElkShape;
import org.eclipse.ui.IEditorPart;
import org.osate.ge.DockingPosition;
import org.osate.ge.graphics.Dimension;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.internal.AgeConnection;
import org.osate.ge.graphics.internal.AgeShape;
import org.osate.ge.graphics.internal.Label;
import org.osate.ge.graphics.internal.ModeGraphic;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;
import org.osate.ge.internal.diagram.runtime.DiagramModification;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.DockArea;
import org.osate.ge.internal.diagram.runtime.styling.StyleCalculator;
import org.osate.ge.internal.diagram.runtime.styling.StyleProvider;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

public class DiagramElementLayoutUtil {
	private static final String incrementalLayoutLabel = "Incremental Layout";
	private static final String layoutAlgorithm = "org.eclipse.elk.layered";
	private static final double portWidthPadding = 40.0;
	private static final double startAndEndBendpointDistance = 4.0;
	private static final double flowIndicatorSpacing = 70.0; // Size allocated for flow indicators

	public static void layout(final String label, final IEditorPart editor,
			final Collection<? extends DiagramNode> diagramNodes, final LayoutOptions options) {
		if (!(editor instanceof AgeDiagramEditor)) {
			throw new RuntimeException("Editor must be an " + AgeDiagramEditor.class.getName());
		}

		final AgeDiagramEditor ageDiagramEditor = ((AgeDiagramEditor) editor);
		final LayoutInfoProvider layoutInfoProvider = Adapters.adapt(ageDiagramEditor, LayoutInfoProvider.class);
		layout(label, ageDiagramEditor.getAgeDiagram(), diagramNodes, layoutInfoProvider, options);
	}

	public static void layout(final String label, final AgeDiagram diagram, final LayoutInfoProvider layoutInfoProvider,
			final LayoutOptions options) {
		layout(label, diagram, null, layoutInfoProvider, options);
	}

	public static void layout(final String label, final AgeDiagram diagram,
			final Collection<? extends DiagramNode> diagramNodes, final LayoutInfoProvider layoutInfoProvider,
			final LayoutOptions options) {
		Objects.requireNonNull(label, "label must not be null");
		Objects.requireNonNull(diagram, "diagram must not be null");
		Objects.requireNonNull(layoutInfoProvider, "layoutInfoProvider must not be null");
		Objects.requireNonNull(options, "options must not be null");

		// Determine the diagram nodes to layout
		final Collection<DiagramNode> nodesToLayout;
		if (diagramNodes == null) {
			nodesToLayout = Collections.singletonList(diagram);
		} else {
			// Only layout shapes. Also filter out any descendants of specified diagram elements
			nodesToLayout = filterUnnecessaryNodes(diagramNodes, true);
		}

		if (nodesToLayout.isEmpty()) {
			return;
		}

		diagram.modify(label, m -> layout(m, nodesToLayout,
				new StyleCalculator(diagram.getConfiguration(), StyleProvider.EMPTY), layoutInfoProvider, options));
	}

	private static void layout(final DiagramModification m, final Collection<? extends DiagramNode> nodesToLayout,
			final StyleProvider styleProvider, final LayoutInfoProvider layoutInfoProvider,
			final LayoutOptions options) {
		Objects.requireNonNull(nodesToLayout, "nodesToLayout must not be null");

		// Layout the nodes
		final IGraphLayoutEngine layoutEngine = new RecursiveGraphLayoutEngine();
		for (final DiagramNode dn : nodesToLayout) {
			LayoutMapping mapping;
			ElkNode layoutGraph;

			// Perform the first layout. This layout will not include nested ports. This will allow ELK additional flexibility when determining port placement.
			mapping = ElkGraphBuilder.buildLayoutGraph(dn, styleProvider, layoutInfoProvider, options,
					!options.layoutPortsOnDefaultSides,
					ElkGraphBuilder.FixedPortPositionProvider.NO_OP);
			layoutGraph = mapping.getLayoutGraph();
			layoutGraph.setProperty(CoreOptions.ALGORITHM, layoutAlgorithm);
			applyProperties(dn, mapping, layoutInfoProvider, options);
			LayoutDebugUtil.saveElkGraphToDebugProject(layoutGraph, "pass1");
			layoutEngine.layout(layoutGraph, new BasicProgressMonitor());

			// If the layout omitted any nested ports, then perform a second layout which will include nested ports. Since nested ports are not supported by
			// ELK, fixed port positions will be used for nodes which contain nested ports. Provide the results from the previous layout to the graph builder so
			// that it can assign the position of the top level ports of such nodes based on the results of the previous layout.
			//
			// Doing a second layout is usually better than assigning all port positions. Ideally, the second pass would just include assigning positions to the
			// nested ports and performing edge routing.
			if (layoutGraph.getProperty(AgeLayoutOptions.NESTED_PORTS_WERE_OMITTED)) {
				final LayoutMapping initialLayoutMapping = mapping;
				mapping = ElkGraphBuilder.buildLayoutGraph(dn, styleProvider, layoutInfoProvider, options, false,
						new ElkGraphBuilder.FixedPortPositionProvider() {

					@Override
					public PortSide getPortSide(final DiagramElement de) {
						final ElkGraphElement ge = initialLayoutMapping.getGraphMap().inverse().get(de);
						if (ge instanceof ElkPort) {
							return ge.getProperty(CoreOptions.PORT_SIDE);
						}
						return null;
					}

					@Override
					public Double getPortPosition(final DiagramElement de) {
						final ElkGraphElement ge = initialLayoutMapping.getGraphMap().inverse().get(de);
						if (ge instanceof ElkPort) {
							final ElkPort port = (ElkPort) ge;
							final PortSide ps = port.getProperty(CoreOptions.PORT_SIDE);
							if (PortSide.SIDES_EAST_WEST.contains(ps)) {
								return port.getY();
							} else {
								return port.getX();
							}
						}

						return null;
					}
				});
				layoutGraph = mapping.getLayoutGraph();
				layoutGraph.setProperty(CoreOptions.ALGORITHM, layoutAlgorithm);
				applyProperties(dn, mapping, layoutInfoProvider, options);
				LayoutDebugUtil.saveElkGraphToDebugProject(layoutGraph, "pass2");
				layoutEngine.layout(layoutGraph, new BasicProgressMonitor());
			}

			applyShapeLayout(mapping, m);
			applyConnectionLayout(mapping, m);

			LayoutDebugUtil.showGraphInLayoutGraphView(layoutGraph);
		}
	}

	/**
	 * Performs layout on elements in the specified diagram which have not been layed out.
	 * @param diagram
	 * @param mod
	 */
	public static void layoutIncrementally(final AgeDiagram diagram, final DiagramModification mod,
			final LayoutInfoProvider layoutInfoProvider) {
		Objects.requireNonNull(diagram, "diagram must not be null");
		Objects.requireNonNull(mod, "mod must not be null");
		Objects.requireNonNull(layoutInfoProvider, "layoutInfoProvider must not be null");

		final IncrementalLayoutMode currentLayoutMode = LayoutPreferences.getCurrentLayoutMode();

		final Collection<DiagramNode> nodesToLayout = DiagramElementLayoutUtil.filterUnnecessaryNodes(
				getNodesToLayoutIncrementally(diagram, currentLayoutMode, new HashSet<>()),
				currentLayoutMode == IncrementalLayoutMode.LAYOUT_DIAGRAM);
		if (nodesToLayout.size() == 0) {
			return;
		}

		final LayoutOptions layoutOptions = LayoutOptions.createFromPreferences();
		if (currentLayoutMode == IncrementalLayoutMode.LAYOUT_DIAGRAM) {
			layout(incrementalLayoutLabel, diagram, layoutInfoProvider, layoutOptions);
		} else {
			layout(mod, nodesToLayout, new StyleCalculator(diagram.getConfiguration(), StyleProvider.EMPTY),
					layoutInfoProvider, layoutOptions);

			// Set Positions of elements which do not have a position set.
			for (final DiagramNode dn : nodesToLayout) {
				if (dn instanceof DiagramElement) {
					final DiagramElement de = (DiagramElement) dn;
					if (!de.hasPosition()) {
						if (de.getDockArea() == null) {
							mod.setPosition(de, new Point(0.0, 0.0));
						} else if (de.getDockArea() != DockArea.GROUP && de.getParent() instanceof DiagramElement) {
							final DiagramElement parent = (DiagramElement) de.getParent();
							final DockingPosition defaultDockingPosition = de
									.getGraphicalConfiguration().defaultDockingPosition;
							final DockArea defaultDockArea = defaultDockingPosition.getDefaultDockArea();

							if (parent.hasSize()) {
								final Stream<DiagramElement> otherElementsAlongSide = parent.getDiagramElements()
										.stream().filter(c -> c.hasPosition() && c.hasSize()
												&& c.getDockArea() == defaultDockArea);

								// Determine the position of the new element along it's preferred docking position.
								double locationAlongSide;
								if (defaultDockingPosition == DockingPosition.TOP
										|| defaultDockingPosition == DockingPosition.BOTTOM) {
									locationAlongSide = otherElementsAlongSide
											.max(Comparator.comparingDouble(c -> c.getY()))
											.map(c -> c.getX() + c.getWidth()).orElse(0.0);
								} else {
									locationAlongSide = otherElementsAlongSide
											.max(Comparator.comparingDouble(c -> c.getY()))
											.map(c -> c.getY() + c.getHeight()).orElse(0.0);
								}

								// Set position based on the docking position
								switch (defaultDockingPosition) {
								case TOP:
									mod.setPosition(de, new Point(locationAlongSide, 0));
									break;
								case BOTTOM:
									mod.setPosition(de, new Point(locationAlongSide, parent.getHeight()));
									break;
								case LEFT:
									mod.setPosition(de, new Point(0, locationAlongSide));
									break;
								case RIGHT:
									mod.setPosition(de, new Point(parent.getWidth(), locationAlongSide));
									break;
								default:
									break;
								}
							}

							mod.setDockArea(de, defaultDockArea);
						}
					}
				}
			}
		}
	}

	private static Set<DiagramNode> getNodesToLayoutIncrementally(final DiagramNode node,
			final IncrementalLayoutMode mode, final Set<DiagramNode> results) {
		final boolean alwaysLayoutContainer = mode != IncrementalLayoutMode.LAYOUT_CONTENTS;

		for (final DiagramElement child : node.getDiagramElements()) {
			if (DiagramElementPredicates.isShape(child)) {
				final boolean positionIsSet = child.hasPosition() || !DiagramElementPredicates.isMoveable(child);
				final boolean sizeIsSet = child.hasSize() || !DiagramElementPredicates.isResizeable(child);

				// The position is set but the size isn't, then layout the child.
				// This occurs when a user has created an element using the palette
				if (positionIsSet && !sizeIsSet) {
					results.add(child);
				} else {
					if (sizeIsSet && positionIsSet) {
						getNodesToLayoutIncrementally(child, mode, results);
					} else {
						// If always layout container is specified, layout container
						// If container does not have any layed out shapes, layout container.
						final boolean layoutContainer = alwaysLayoutContainer
								|| !hasLayedOutShapes(node.getDiagramElements());
						if (layoutContainer) {
							results.add(node);
							break;
						} else {
							results.add(child);
						}
					}
				}
			} else if (DiagramElementPredicates.isConnection(child) && alwaysLayoutContainer
					&& child.getStartElement() != null && child.getEndElement() != null) {
				// Only layout the connection if its bendpoints have not been set regardless of whether it has any bendpoints.
				if (!child.isBendpointsSet()) {
					final Optional<Queryable> ancestor = Queryable.getFirstCommonAncestor(
							child.getStartElement().getContainer(), child.getEndElement().getContainer());
					if (ancestor.isPresent()) {
						results.add((DiagramNode) ancestor.get());
					}
				}
			}
		}

		return results;
	}

	private static boolean hasLayedOutShapes(final Collection<DiagramElement> diagramElements) {
		return diagramElements.stream().anyMatch(de -> {
			final boolean moveable = DiagramElementPredicates.isMoveable(de);
			final boolean resizable = DiagramElementPredicates.isResizeable(de);
			return ((de.hasPosition() && moveable) || !moveable) && ((de.hasSize() && resizable) || !resizable)
					&& (moveable || resizable);
		});
	}

	/**
	 * Sets the ELK properties of elements in the specified layout mapping based on the layout options.
	 * @param layoutMapping
	 * @param options
	 */
	private static void applyProperties(final DiagramNode rootDiagramNode, final LayoutMapping layoutMapping,
			final LayoutInfoProvider layoutInfoProvider, final LayoutOptions options) {
		// Set the minimum node size based on the ports and their assigned sides.
		final IGraphElementVisitor minNodeSizeVisitor = element -> {
			if (element instanceof ElkNode) {
				final ElkNode n = (ElkNode) element;

				final double maxLabelWidth = n.getLabels().stream().mapToDouble(l -> l.getWidth()).max().orElse(0.0);
				final double labelHeightSum = n.getLabels().stream().mapToDouble(l -> l.getHeight()).sum();

				// Determine max width for ports on the left and right sides
				final double maxLeftPortWidth = n.getPorts().stream()
						.filter(p -> p.getProperty(CoreOptions.PORT_SIDE) == PortSide.WEST)
						.mapToDouble(p -> p.getWidth()).max().orElse(0.0);
				final double maxRightPortWidth = n.getPorts().stream()
						.filter(p -> p.getProperty(CoreOptions.PORT_SIDE) == PortSide.EAST)
						.mapToDouble(p -> p.getWidth()).max().orElse(0.0);

				// Determine size needed for flow indicators
				final EnumMap<PortSide, Double> portSidesWithFlowIndicators = new EnumMap<>(PortSide.class);
				final DiagramNode dn = (DiagramNode) layoutMapping.getGraphMap().get(n);
				if (dn != null) {
					for (final DiagramElement child : dn.getDiagramElements()) {
						if (child.getStartElement() != null && child.getGraphic() instanceof AgeConnection
								&& ((AgeConnection) child.getGraphic()).isFlowIndicator) {
							final ElkGraphElement portGraphElement = layoutMapping.getGraphMap().inverse()
									.get(child.getStartElement());
							if (portGraphElement != null) {
								final PortSide portSide = portGraphElement.getProperty(CoreOptions.PORT_SIDE);
								if (portSide != null) {
									portSidesWithFlowIndicators.put(portSide,
											Math.max(portSidesWithFlowIndicators.getOrDefault(portSide, 0.0),
													flowIndicatorSpacing));
									portSidesWithFlowIndicators.put(portSide,
											Math.max(portSidesWithFlowIndicators.getOrDefault(portSide, 0.0),
													20 + layoutInfoProvider.getPrimaryLabelSize(child).width));
								}
							}
						}
					}
				}

				final double widthForFlowIndicators = portSidesWithFlowIndicators.getOrDefault(PortSide.EAST, 0.0)
						+ portSidesWithFlowIndicators.getOrDefault(PortSide.WEST, 0.0);
				final double heightForFlowIndicators = portSidesWithFlowIndicators.getOrDefault(PortSide.NORTH, 0.0)
						+ portSidesWithFlowIndicators.getOrDefault(PortSide.SOUTH, 0.0);

				double minWidth = 0;
				if (n.getProperty(CoreOptions.NODE_LABELS_PLACEMENT).contains(NodeLabelPlacement.H_CENTER)) {
					// Ensure the minimum width is such that the label can be centered without overlapping with ports.
					// This happens because ports are inside the node due to the PORT_BORDER_OFFSET and ELK centers the labels in the remaining space.
					final double widthForPorts = 2 * Math.max(maxLeftPortWidth, maxRightPortWidth);
					minWidth = Math.max(40,
							maxLabelWidth + Math.max(widthForPorts + portWidthPadding, widthForFlowIndicators));
				} else {
					final double widthForPorts = maxLeftPortWidth + maxRightPortWidth + portWidthPadding;
					minWidth = Math.max(40, Math.max(Math.max(maxLabelWidth, widthForPorts), widthForFlowIndicators));
				}

				double minHeight = Math.max(Math.max(35, labelHeightSum), heightForFlowIndicators);

				if (dn instanceof DiagramElement) {
					final DiagramElement de = ((DiagramElement) dn);

					// Special min height handling for initial modes
					final Graphic graphic = de.getGraphic();

					if (graphic instanceof AgeShape && !((AgeShape) graphic).isResizeable() && de.hasSize()) {
						final Dimension dim = de.getSize();
						minHeight = dim.height;
						minWidth = dim.width;

						// Adjust size constraints for fixed sized shapes which do not have contents.
						if (n.getChildren().size() == 0 || n.getLabels().size() == 0 && n.getPorts().size() == 0) {
							final EnumSet<SizeConstraint> nodeSizeConstraints = EnumSet.of(SizeConstraint.MINIMUM_SIZE);
							n.setProperty(CoreOptions.NODE_SIZE_CONSTRAINTS, nodeSizeConstraints);
						}
					}

					if (graphic instanceof ModeGraphic && ((ModeGraphic) graphic).isInitialMode) {
						minHeight += ModeGraphic.initialModeAreaHeight;
					}

					// Special min size handling for elements shown as image
					final Style style = de.getStyle();
					if (style != null && Boolean.TRUE.equals(style.getShowAsImage())) {
						final Dimension dim = ((DiagramElement) dn).getSize();
						minHeight = dim.height;
						minWidth = dim.width;
					}
				}

				// Increase min width and min height for top level nodes.
				if (dn != null && dn.getParent() instanceof AgeDiagram) {
					minWidth = Math.max(minWidth, 200);
					minHeight = Math.max(minHeight, 100);
				}

				n.setProperty(CoreOptions.NODE_SIZE_MINIMUM, new KVector(minWidth, minHeight));
			}
		};

		ElkUtil.applyVisitors(layoutMapping.getLayoutGraph(), minNodeSizeVisitor);

		// If the top level element has a size set, don't shrink it.
		if (rootDiagramNode instanceof DiagramElement) {
			final DiagramElement rootDiagramElement = (DiagramElement) rootDiagramNode;
			final ElkGraphElement rootGraphElement = layoutMapping.getGraphMap().inverse().get(rootDiagramNode);

			if (rootGraphElement != null && rootDiagramElement.hasSize()
					&& DiagramElementPredicates.isResizeable(rootDiagramElement)) {
				final KVector minSize = rootGraphElement.getProperty(CoreOptions.NODE_SIZE_MINIMUM);
				final double newMinWidth = Math.max(rootDiagramElement.getWidth(), minSize == null ? 0.0 : minSize.x);
				final double newMinHeight = Math.max(rootDiagramElement.getHeight(), minSize == null ? 0.0 : minSize.y);
				rootGraphElement.setProperty(CoreOptions.NODE_SIZE_MINIMUM, new KVector(newMinWidth, newMinHeight));
			}
		}
	}

	private static boolean isTopLevel(final ElkGraphElement ge) {
		if (ge instanceof ElkPort) {
			final ElkPort p = (ElkPort) ge;
			return p.getParent() == null || p.getParent().getParent() == null;
		} else if (ge instanceof ElkNode) {
			final ElkNode n = (ElkNode) ge;
			return n.getParent() == null || n.getParent().getParent() == null;
		} else {
			return false;
		}
	}

	/**
	 * Returns a list which contains the specified diagram nodes with unnecessary nodes removed.
	 * It removes nodes which are:
	 *   Not a diagram.
	 *   Not shapes
	 *   Elements which have an ancestor in the specified list.
	 *   Children of a docked element unless the current diagram mode is layout diagram.
	 * @param diagramNodes
	 * @return
	 */
	static Collection<DiagramNode> filterUnnecessaryNodes(final Collection<? extends DiagramNode> diagramNodes,
			final boolean includeGroupChildren) {
		return diagramNodes.stream().filter(dn -> dn instanceof AgeDiagram || (dn instanceof DiagramElement
				&& DiagramElementPredicates.isShape((DiagramElement) dn) && !containsAnyAncestor(diagramNodes, dn)
				&& (includeGroupChildren || ((DiagramElement) dn).getDockArea() != DockArea.GROUP)))
				.collect(Collectors.toList());
	}

	/**
	 * Returns true if the specified collection contains any ancestor for the specified diagram node
	 * @param c
	 * @param e
	 * @return
	 */
	private static boolean containsAnyAncestor(final Collection<? extends DiagramNode> c, final DiagramNode n) {
		for (DiagramNode ancestor = n.getParent(); ancestor != null; ancestor = ancestor.getParent()) {
			if (c.contains(ancestor)) {
				return true;
			}
		}

		return false;
	}

	private static void applyShapeLayout(final LayoutMapping mapping, final DiagramModification m) {
		// Modify shapes
		for (Entry<ElkGraphElement, Object> e : mapping.getGraphMap().entrySet()) {
			final ElkGraphElement elkElement = e.getKey();
			final Object mappedValue = e.getValue();
			final boolean isTopLevelElement = isTopLevel(elkElement);

			if (!(elkElement instanceof ElkShape)) {
				continue;
			}
			final ElkShape elkShape = (ElkShape) elkElement;

			if (!(mappedValue instanceof DiagramElement)) {
				continue;
			}

			final DiagramElement de = (DiagramElement) mappedValue;
			if (!(de.getGraphic() instanceof AgeShape)) {
				continue;
			}

			if (de.getGraphic() instanceof Label) {
				continue;
			}

			// Set Position. Don't set the position of top level elements
			if (!isTopLevelElement && DiagramElementPredicates.isMoveable(de)) {
				// Determine position for the element
				double x = elkShape.getX();
				double y = elkShape.getY();

				// If the diagram element has a parent port, subtract the parent port position from the ELK port position to determine the relative position
				if (de.getDockArea() == DockArea.GROUP) {
					final ElkPort parentPort = (ElkPort) mapping.getGraphMap().inverse().get(de.getParent());
					if (parentPort != null) {
						final PortSide side = parentPort.getProperty(CoreOptions.PORT_SIDE);
						if (PortSide.SIDES_NORTH_SOUTH.contains(side)) {
							x = elkShape.getX() - parentPort.getX();
						} else if (PortSide.SIDES_EAST_WEST.contains(side)) {
							y = elkShape.getY() - parentPort.getY();
						} else {
							throw new RuntimeException("Unexpected side: " + side);
						}
					}
				}

				m.setPosition(de, new Point(x, y));

				// Set the dock area
				if (de.getDockArea() != DockArea.GROUP && de.getDockArea() != null) {
					final DockArea newDockArea = PortSideUtil.getDockArea(elkShape.getProperty(CoreOptions.PORT_SIDE));
					if (newDockArea != null) {
						m.setDockArea(de, newDockArea);
					}
				}
			}

			// Set the size
			if (DiagramElementPredicates.isResizeable(de)) {
				m.setSize(de, new Dimension(elkShape.getWidth(), elkShape.getHeight()));
			}
		}
	}

	private static void applyConnectionLayout(final LayoutMapping mapping, final DiagramModification m) {
		// Modify Connections
		for (Entry<ElkGraphElement, Object> e : mapping.getGraphMap().entrySet()) {
			final ElkGraphElement elkElement = e.getKey();
			final Object mappedValue = e.getValue();

			if (!(elkElement instanceof ElkEdge)) {
				continue;
			}
			final ElkEdge edge = (ElkEdge) elkElement;

			// Ignore edges which do not have exactly one section. This is usually the case where it is a long hierarchical connection that has 0 sections
			if (edge.getSections().size() != 1) {
				continue;
			}
			final ElkEdgeSection edgeSection = edge.getSections().get(0);

			if (!(mappedValue instanceof DiagramElement)) {
				continue;
			}

			final DiagramElement de = (DiagramElement) mappedValue;
			if (!(de.getGraphic() instanceof AgeConnection)) {
				continue;
			}

			// Don't update connections if it wasn't updated. This prevents updating bendpoints to invalid values if an edge is not layed out.
			if (edgeSection.eIsSet(ElkGraphPackage.eINSTANCE.getElkEdgeSection_StartX())
					&& edgeSection.eIsSet(ElkGraphPackage.eINSTANCE.getElkEdgeSection_EndX())) {
				final List<Point> bendpointsInParentCoordinateSystem = edgeSection.getBendPoints().stream()
						.map(bp -> new Point(bp.getX(), bp.getY())).collect(Collectors.toCollection(LinkedList::new));

				//
				// Set bendpoints
				//

				// Add the start and end points to the bendpoints list if the the start/end element is not a node. This is needed
				// because the behavior of Graphiti chopbox anchors differ from ELK routing.
				// For ports the start and end points are unnecessary and will actually be located inside the port graphic.
				final boolean srcIsPort = edge.getSources().size() == 1 ? edge.getSources().get(0) instanceof ElkPort
						: false;
				final boolean dstIsPort = edge.getTargets().size() == 1 ? edge.getTargets().get(0) instanceof ElkPort
						: false;

				if (!srcIsPort) {
					bendpointsInParentCoordinateSystem.add(0,
							new Point(edgeSection.getStartX(), edgeSection.getStartY()));
				}

				if (!dstIsPort) {
					bendpointsInParentCoordinateSystem.add(new Point(edgeSection.getEndX(), edgeSection.getEndY()));
				}

				// Adjust newly added bendpoints so that the connection arrows will face the appropriate direction
				if (!srcIsPort && bendpointsInParentCoordinateSystem.size() >= 2) {
					bendpointsInParentCoordinateSystem.set(0,
							getAdjacentPoint(bendpointsInParentCoordinateSystem.get(0),
									bendpointsInParentCoordinateSystem.get(1), startAndEndBendpointDistance));
				}

				if (!dstIsPort && bendpointsInParentCoordinateSystem.size() >= 2) {
					bendpointsInParentCoordinateSystem.set(bendpointsInParentCoordinateSystem.size() - 1,
							getAdjacentPoint(
									bendpointsInParentCoordinateSystem
									.get(bendpointsInParentCoordinateSystem.size() - 1),
									bendpointsInParentCoordinateSystem
									.get(bendpointsInParentCoordinateSystem.size() - 2),
									startAndEndBendpointDistance));
				}

				// Get the absolute coordinate in the diagram of the edge's ELK container.
				final Point elkContainerPosition;
				if (edge.getContainingNode() == mapping.getLayoutGraph()) {
					// Special handling for edges that are children of the ELK root. Usually occurs when Layout Contents is used. In that case there isn't a
					// Diagram
					// Node available. Use the first and only child of the top level ELK node.
					if (mapping.getLayoutGraph().getChildren().size() == 1) {
						final ElkNode topLayoutElkNode = mapping.getLayoutGraph().getChildren().get(0);
						final Point topLayoutElkNodePosition = getAbsolutePosition(
								(DiagramNode) mapping.getGraphMap().get(topLayoutElkNode));
						elkContainerPosition = new Point(topLayoutElkNodePosition.x - topLayoutElkNode.getX(),
								topLayoutElkNodePosition.y - topLayoutElkNode.getY());
					} else {
						elkContainerPosition = new Point(0, 0);
					}
				} else {
					elkContainerPosition = getAbsolutePosition(
							(DiagramNode) mapping.getGraphMap().get(edge.getContainingNode()));
				}

				final List<Point> bendpointsInAbsoluteCoordinateSystem = bendpointsInParentCoordinateSystem.stream()
						.map(p -> new Point(p.x + elkContainerPosition.x, p.y + elkContainerPosition.y))
						.collect(Collectors.toList());

				m.setBendpoints(de, bendpointsInAbsoluteCoordinateSystem);

				// For the midpoint calculation, the start and end points are needed. Add them if they have not already been added.
				if (srcIsPort) {
					bendpointsInParentCoordinateSystem.add(0,
							new Point(edgeSection.getStartX(), edgeSection.getStartY()));
				}

				if (dstIsPort) {
					bendpointsInParentCoordinateSystem.add(new Point(edgeSection.getEndX(), edgeSection.getEndY()));
				}

				// Set Label Positions
				setLabelPositionsForEdge(mapping, m, edge, findMidpoint(bendpointsInParentCoordinateSystem));
			}
		}
	}

	/**
	 *
	 * @param mapping
	 * @param m
	 * @param edge
	 * @param edgeMidpoint must be relative to the edge's container
	 */
	private static void setLabelPositionsForEdge(final LayoutMapping mapping, DiagramModification m, final ElkEdge edge,
			final Point edgeMidpoint) {
		// Handle labels
		for (final ElkLabel edgeLabel : edge.getLabels()) {
			final Object labelValue = mapping.getGraphMap().get(edgeLabel);
			if (labelValue instanceof ConnectionLabelReference) {
				final double lx = edgeLabel.getX() - edgeMidpoint.x;
				final double ly = edgeLabel.getY() - edgeMidpoint.y;
				((ConnectionLabelReference) labelValue).setPosition(m, new Point(lx, ly));
			}
		}
	}

	private static Point findMidpoint(final List<Point> points) {
		if (points.size() < 2) {
			throw new RuntimeException("At least two points must be specified");
		}

		final double totalLength = length(points);
		double lengthToTarget = totalLength / 2.0;

		for (int i = 1; i < points.size(); i++) {
			final Point p1 = points.get(i - 1);
			final Point p2 = points.get(i);

			final double segmentLength = length(p1, p2);
			if (lengthToTarget > segmentLength) {
				lengthToTarget -= segmentLength;
			} else {
				final double frac = lengthToTarget / segmentLength;
				return new Point(p1.x + (p2.x - p1.x) * frac, p1.y + (p2.y - p1.y) * frac);
			}
		}

		throw new RuntimeException("Unexpected case: midpoint not found");
	}

	private static double length(final List<Point> points) {
		double totalLength = 0;
		for (int i = 1; i < points.size(); i++) {
			totalLength += length(points.get(i - 1), points.get(i));
		}

		return totalLength;
	}

	private static double length(final Point p1, final Point p2) {
		final double dx = p1.x - p2.x;
		final double dy = p1.y - p2.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	/**
	 * Returns a point next to p1 which is on the line segment between p2 and p1.
	 * @param p1
	 * @param p2
	 * @return
	 */
	private static Point getAdjacentPoint(final Point p1, final Point p2, double d) {
		final double dx = p2.x - p1.x;
		final double dy = p2.y - p1.y;
		final double l = Math.sqrt(dx * dx + dy * dy);
		final double ux = dx / l;
		final double uy = dy / l;

		// Ensure that d is less than l. Otherwise the produced point will be further away than the actual point.
		d = Math.min(d, l);

		return new Point(p1.x + d * ux, p1.y + d * uy);
	}

	public static Point getAbsolutePosition(final DiagramNode dn) {
		int x = 0;
		int y = 0;
		for (DiagramNode tmp = dn; tmp instanceof DiagramElement; tmp = tmp.getParent()) {
			final DiagramElement tmpDe = (DiagramElement) tmp;
			if (tmpDe.getGraphic() instanceof AgeShape) { // Ignore connections in case the X and Y values are not 0.
				x += tmpDe.getX();
				y += tmpDe.getY();
			}
		}

		return new Point(x, y);
	}
}
