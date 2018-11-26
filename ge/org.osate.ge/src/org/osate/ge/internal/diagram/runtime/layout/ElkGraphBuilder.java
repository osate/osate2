package org.osate.ge.internal.diagram.runtime.layout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.elk.core.math.ElkPadding;
import org.eclipse.elk.core.math.KVector;
import org.eclipse.elk.core.options.CoreOptions;
import org.eclipse.elk.core.options.Direction;
import org.eclipse.elk.core.options.HierarchyHandling;
import org.eclipse.elk.core.options.NodeLabelPlacement;
import org.eclipse.elk.core.options.PortConstraints;
import org.eclipse.elk.core.options.PortSide;
import org.eclipse.elk.core.options.SizeConstraint;
import org.eclipse.elk.core.options.SizeOptions;
import org.eclipse.elk.core.service.LayoutMapping;
import org.eclipse.elk.graph.ElkConnectableShape;
import org.eclipse.elk.graph.ElkEdge;
import org.eclipse.elk.graph.ElkGraphElement;
import org.eclipse.elk.graph.ElkLabel;
import org.eclipse.elk.graph.ElkNode;
import org.eclipse.elk.graph.ElkPort;
import org.eclipse.elk.graph.util.ElkGraphUtil;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.ge.DockingPosition;
import org.osate.ge.graphics.Dimension;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.internal.AgeConnection;
import org.osate.ge.graphics.internal.AgeShape;
import org.osate.ge.graphics.internal.Label;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementPredicates;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.diagram.runtime.DockArea;
import org.osate.ge.internal.diagram.runtime.styling.StyleProvider;

class ElkGraphBuilder {
	// Filter for diagram elements for which ELK ports will be created.
	private final Predicate<DiagramElement> dockedShapeFilter = de -> de.getGraphic() instanceof AgeShape
			&& !(de.getGraphic() instanceof Label) && de.getDockArea() != null;

	private final double paddingSize = 10;
	private final double portAndContentsPadding = 12.0; // Padding between ports and other contents

	private final StyleProvider styleProvider;
	private final LayoutInfoProvider layoutInfoProvider;
	private final LayoutOptions options;
	private final boolean omitNestedPorts;
	private final FixedPortPositionProvider fixedPortPositionProvider;

	/**
	 * Provides information used to position ports when fixed port positions are being used. If null is returned, the graph builder will assign a default position.
	 * Fixed port positions are used when nested ports are included in the graph. If the position of a port is provided, then the provider must provide the position for all
	 * sibling ports.
	 */
	public static interface FixedPortPositionProvider {
		PortSide getPortSide(final DiagramElement de);

		Double getPortPosition(final DiagramElement de); // Gets position along axis

		// Implementation that returns null for all values
		public static final FixedPortPositionProvider NO_OP = new FixedPortPositionProvider() {
			@Override
			public PortSide getPortSide(DiagramElement de) {
				return null;
			}

			@Override
			public Double getPortPosition(DiagramElement de) {
				return null;
			}
		};
	}

	private ElkGraphBuilder(final StyleProvider styleProvider, final LayoutInfoProvider layoutInfoProvider,
			final LayoutOptions options, final boolean omitNestedPorts,
			final FixedPortPositionProvider fixedPortPositionProvider) {
		this.styleProvider = Objects.requireNonNull(styleProvider, "styleProvider must not be null");
		this.layoutInfoProvider = Objects.requireNonNull(layoutInfoProvider, "layoutInfoProvider must not be null");
		this.options = Objects.requireNonNull(options, "options must not be null");
		this.omitNestedPorts = omitNestedPorts;
		this.fixedPortPositionProvider = Objects.requireNonNull(fixedPortPositionProvider,
				"fixedPortPositionProvider must not be null");
	}

	/**
	 *
	 * @param rootDiagramNode
	 * @param styleProvider is a style provider which provides the style for the diagram elements. The style provider is expected to return a final style. The style must not contain null values.
	 * @param layoutInfoProvider is the layout info provider which is used to determine label sizes.
	 * @param options
	 * @param ignoreNestedPorts must be false if layout ports on default sides is true.
	 * @param portPlacementInfoProvider
	 * @return
	 */
	static LayoutMapping buildLayoutGraph(final DiagramNode rootDiagramNode, final StyleProvider styleProvider,
			final LayoutInfoProvider layoutInfoProvider, final LayoutOptions options, final boolean omitNestedPorts,
			final FixedPortPositionProvider portPlacementInfoProvider) {
		// This case would indicate that we are using a multi-pass layout even though fixed position ports are being used.
		// Fixed side port positioning is not reliable because exceptions can be thrown in cases involving edges between nodes.
		if(omitNestedPorts && options.layoutPortsOnDefaultSides) {
			throw new IllegalArgumentException("Omitting nested ports while position ports on default sides is not supported");
		}

		final ElkGraphBuilder graphBuilder = new ElkGraphBuilder(styleProvider, layoutInfoProvider, options,
				omitNestedPorts, portPlacementInfoProvider);
		return graphBuilder.buildLayoutGraph(rootDiagramNode);
	}

	private LayoutMapping buildLayoutGraph(final DiagramNode rootDiagramNode) {
		// Create the graph
		final LayoutMapping mapping = new LayoutMapping(null);
		final ElkNode rootNode = ElkGraphUtil.createGraph();
		rootNode.setProperty(CoreOptions.DIRECTION, Direction.RIGHT);
		mapping.setLayoutGraph(rootNode);

		// As of 2017-11-28, INCLUDE_CHILDREN causes an exception with hierarchical connections with fixed position ports
		// If fixed position ports are used, the hierarchy handling will be adjusted accordingly.
		// rootNode.setProperty(CoreOptions.HIERARCHY_HANDLING, HierarchyHandling.INCLUDE_CHILDREN);

		// As of 20180-03-15, INCLUDE_CHILDREN causes ports to be positioned incorrectly and nodes to be sized incorrectly under certain conditions.
		// https://github.com/eclipse/elk/issues/316
		rootNode.setProperty(CoreOptions.HIERARCHY_HANDLING, HierarchyHandling.SEPARATE_CHILDREN);

		if (rootDiagramNode instanceof AgeDiagram) {
			final ElkNode diagramElkNode = ElkGraphUtil.createNode(rootNode);
			mapping.getGraphMap().put(diagramElkNode, rootDiagramNode);
			createElkGraphElementsForNonLabelChildShapes(rootDiagramNode, diagramElkNode, mapping);
		} else if (rootDiagramNode instanceof DiagramElement) {
			createElkGraphElementsForElements(Collections.singleton((DiagramElement) rootDiagramNode), rootNode,
					mapping);
		}

		createElkGraphElementsForConnections(rootDiagramNode, mapping);

		return mapping;
	}

	private void createElkGraphElementsForNonLabelChildShapes(final DiagramNode parentNode, final ElkNode parent,
			final LayoutMapping mapping) {
		createElkGraphElementsForElements(parentNode.getDiagramElements(), parent, mapping);
	}

	private void createElkGraphElementsForElements(final Collection<DiagramElement> elements, final ElkNode parent,
			final LayoutMapping mapping) {
		elements.stream()
		.filter(de -> de.getGraphic() instanceof AgeShape && !(de.getGraphic() instanceof Label)
				&& de.getDockArea() == null)
		.forEachOrdered(de -> createElkGraphElementForNonLabelAndUndockedShape(de, parent, mapping));

		// Create ports
		createElkPortsForElements(elements, parent, mapping);
	}

	/**
	 * Before calling this method, all labels for the parent node should have already been created and the node labels placement property must be set for the parent.
	 * @param elements
	 * @param parent
	 * @param mapping
	 */
	private void createElkPortsForElements(final Collection<DiagramElement> elements, final ElkNode parent,
			final LayoutMapping mapping) {

		final EnumSet<NodeLabelPlacement> nodeLabelPlacement = parent.getProperty(CoreOptions.NODE_LABELS_PLACEMENT);
		final boolean labelsAtTop = nodeLabelPlacement != null && nodeLabelPlacement.contains(NodeLabelPlacement.V_TOP);
		final double topPadding = labelsAtTop
				? parent.getLabels().stream().mapToDouble(l -> l.getY() + l.getHeight()).sum()
						: 0.0;

				// Group children by the port side to which they should be assigned.
				final List<DiagramElement> dockedShapes = elements.stream().filter(dockedShapeFilter)
						.collect(Collectors.toList());
				final boolean diagramElementIncludesNestedPorts = dockedShapes.stream()
						.flatMap(de -> de.getDiagramElements().stream()).anyMatch(dockedShapeFilter);

				// Set the flag to indicate that there are nested ports which will not be included in the final layout graph
				if (omitNestedPorts && diagramElementIncludesNestedPorts) {
					mapping.getLayoutGraph().setProperty(AgeLayoutOptions.NESTED_PORTS_WERE_OMITTED, true);
				}

				// Set port constraints and graph hierarchy handling of the parent based on whether the diagram element actually has nested ports.
				final boolean hasNestedPorts = !omitNestedPorts && diagramElementIncludesNestedPorts;
				PortConstraints portConstraints;
				if (dockedShapes.size() == 0) {
					// Don't constrain ports if there aren't any. As of 2017-10-11, some other values can affect the layout even if the node does not contain ports.
					portConstraints = PortConstraints.FREE;
				} else {
					if (hasNestedPorts || options.layoutPortsOnDefaultSides) {
						portConstraints = PortConstraints.FIXED_POS;
						// If using fixed port positions, adjust the hierarchy handling so that ELK will not throw an exception due to missing dummy ports.
						mapping.getLayoutGraph().setProperty(CoreOptions.HIERARCHY_HANDLING,
								HierarchyHandling.SEPARATE_CHILDREN);
					} else {
						portConstraints = PortConstraints.FREE;
					}
				}
				parent.setProperty(CoreOptions.PORT_CONSTRAINTS, portConstraints);

				final Map<PortSide, List<DiagramElement>> groupedDockedElements = dockedShapes.stream()
						.collect(Collectors.groupingBy(de -> getPortSide(de, hasNestedPorts), HashMap::new,
								Collectors.toCollection(ArrayList::new)));

				// Determine padding
				final ElkPadding parentPadding = new ElkPadding(portAndContentsPadding);
				for (final Entry<PortSide, List<DiagramElement>> entry : groupedDockedElements.entrySet()) {
					final PortSide side = entry.getKey();

					double maxSize = 0;
					for (final DiagramElement de : entry.getValue()) {
						maxSize = Math.max(maxSize, getOrthogonalSize(de, side));
					}

					// Update padding for the side
					final double sidePadding = maxSize + portAndContentsPadding;
					switch (side) {
					case NORTH:
						parentPadding.top = sidePadding;
						break;

					case SOUTH:
						parentPadding.bottom = sidePadding;
						break;

					case EAST:
						parentPadding.right = sidePadding;
						break;

					case WEST:
						parentPadding.left = sidePadding;
						break;

					default:
						// Ignore
						break;
					}
				}

				// Create and position the ports
				for (final Entry<PortSide, List<DiagramElement>> portSideToElementsEntry : groupedDockedElements.entrySet()) {
					final PortSide side = portSideToElementsEntry.getKey();
					final double additionalPadding;
					if (PortSide.SIDES_NORTH_SOUTH.contains(side)) {
						additionalPadding = Math.max(parentPadding.left, parentPadding.right);
					} else {
						additionalPadding = topPadding;
					}
					createAndPositionPorts(parent, portSideToElementsEntry.getValue(), portSideToElementsEntry.getKey(),
							additionalPadding, mapping, hasNestedPorts);
				}

				// Set the padding
				parent.setProperty(CoreOptions.PADDING, parentPadding);
	}

	// Create and position ports for an elk node
	private void createAndPositionPorts(final ElkNode parentNode, final List<DiagramElement> dockedDiagramElements,
			final PortSide side, final double additionalPadding, final LayoutMapping mapping,
			final boolean parentHasNestedPorts) {
		// Create and position ports
		double position = paddingSize + additionalPadding;
		double maxPosition = position;
		for (final DiagramElement dockedElement : dockedDiagramElements) {
			final ElkPort newPort = createPort(parentNode, side, dockedElement, 0, mapping);

			// Determine if the position has been provided by the fixed port position provider
			if (parentHasNestedPorts) {
				final Double overridePosition = fixedPortPositionProvider.getPortPosition(dockedElement);
				if (overridePosition != null) {
					position = overridePosition;
				}
			}

			setPositionAlongSide(newPort, side, position);
			addPositionOffsets((DiagramElement) mapping.getGraphMap().get(newPort), 0.0, side, mapping);

			position += getSize(newPort, side) + paddingSize;

			// The max position may not always be increasing because the fixed port position provider may override the position.
			maxPosition = Math.max(maxPosition, position);
		}

		maxPosition += 5; // Additional padding

		if (parentHasNestedPorts) {
			// Create a dummy port so that the last port on the side will have the minimum padding
			final ElkPort newPort = ElkGraphUtil.createPort(parentNode);
			newPort.setProperty(CoreOptions.PORT_SIDE, side);
			newPort.setY(maxPosition);
			newPort.setWidth(0);
			newPort.setHeight(0);
		}
	}

	/**
	 *
	 * @param parent
	 * @param side
	 * @param dockedElement
	 * @param portBorderOffset additional offset from the border. Used to set the ELK port border offset for nested ports.
	 * @param mapping
	 * @return
	 */
	private ElkPort createPort(final ElkNode parent, final PortSide side, final DiagramElement dockedElement,
			final double portBorderOffset, final LayoutMapping mapping) {
		final List<DiagramElement> dockedChildren = getDockedChildren(dockedElement);

		final Dimension untransformedGraphicSize = layoutInfoProvider.getPortGraphicSize(dockedElement);
		final Dimension transformedGraphicSize = transformDimension(untransformedGraphicSize, side);

		final Dimension untransformedLabelsSize = layoutInfoProvider.getLabelsSize(dockedElement);
		final Dimension transformedLabelsSize = transformDimension(untransformedLabelsSize, side);

		// Create child ports and sort them by the size of the dimension parallel to the docked side
		final List<ElkPort> childPorts = dockedChildren.stream()
				.map(ce -> createPort(parent, side, ce, getOrthogonalSize(transformedGraphicSize, side), mapping))
				.sorted((p1, p2) -> Double.compare(getSize(p1, side), getSize(p1, side)))
				.collect(Collectors.toCollection(ArrayList::new));

		// If the port has child ports, then we assume it is a feature group.
		// The child ports are split into two bins and positioned such that they do not overlap the center of the feature group.
		// The parent port will be sized accordingly.
		final double maxChildBinSize;
		if (childPorts.size() > 0) {
			// Split the ports into two lists which have roughly equal heights/widths(depending on the docked side)
			double[] binSize = { 0.0, 0.0 };
			@SuppressWarnings("unchecked")
			final List<ElkPort>[] binLists = new ArrayList[] { new ArrayList<>(), new ArrayList<>() };

			for (final ElkPort childPort : childPorts) {
				final double size = getSize(childPort, side);
				final int binIndex = binSize[0] <= binSize[1] ? 0 : 1;
				binLists[binIndex].add(childPort);
				binSize[binIndex] += size + paddingSize;
			}

			// Determine the total size of the feature
			maxChildBinSize = Math.max(binSize[0], binSize[1]);

			// Set the position of the port relative to its parent because the size and position of the parent will be selected after its children are sized.
			for (int i = 0; i < 2; i++) {
				double childPosition = transformedLabelsSize.height
						+ i * (maxChildBinSize + transformedGraphicSize.height);
				for (final ElkPort childPort : binLists[i]) {
					setPositionAlongSide(childPort, side, childPosition);
					childPosition += getSize(childPort, side) + paddingSize;
				}
			}
		} else {
			maxChildBinSize = 0.0;
		}

		// Size the parent port based on the bin size.
		final double newGraphicSize = 2.0 * maxChildBinSize + transformedGraphicSize.height;
		final double totalSize = transformedLabelsSize.height + newGraphicSize;

		final ElkPort newPort = ElkGraphUtil.createPort(parent);
		mapping.getGraphMap().put(newPort, dockedElement);
		newPort.setProperty(CoreOptions.PORT_SIDE, side);

		// Determine max orthogonal size of children
		double maxChildOrthogonalSize = 0;
		for (final ElkPort childPort : childPorts) {
			maxChildOrthogonalSize = Math.max(maxChildOrthogonalSize, getOrthogonalSize(childPort, side));
		}

		// Determine size and position
		final Dimension newSize;
		if (DiagramElementPredicates.isResizeable(dockedElement)) {
			newSize = new Dimension(Math.max(untransformedLabelsSize.width,
					maxChildOrthogonalSize + getOrthogonalSize(transformedGraphicSize, side)), totalSize);
		} else {
			newSize = new Dimension(Math.max(untransformedLabelsSize.width, untransformedGraphicSize.width),
					transformedLabelsSize.height + untransformedGraphicSize.height);
		}

		// If omitting nested ports, remove any child ports. They still need to be created as part of the sizing process, but are not supported for the
		// final graph.
		if (omitNestedPorts) {
			for (final ElkPort childPort : childPorts) {
				mapping.getGraphMap().remove(childPort);
				EcoreUtil.remove(childPort);
			}
		}

		final Dimension transformedNewSize = transformDimension(newSize, side);
		newPort.setWidth(transformedNewSize.width);
		newPort.setHeight(transformedNewSize.height);

		// Set port border offset
		if (PortSide.SIDES_NORTH_SOUTH.contains(side)) {
			newPort.setProperty(CoreOptions.PORT_BORDER_OFFSET, -newPort.getHeight() - portBorderOffset);
		} else {
			newPort.setProperty(CoreOptions.PORT_BORDER_OFFSET, -newPort.getWidth() - portBorderOffset);
		}

		// Set the port anchor based on where the actual graphic will be.
		final Dimension transformedPortAnchor = transformDimension(new Dimension(untransformedGraphicSize.width / 2,
				transformedLabelsSize.height + maxChildBinSize + untransformedGraphicSize.height / 2.0), side);
		newPort.setProperty(CoreOptions.PORT_ANCHOR,
				new KVector(transformedPortAnchor.width, transformedPortAnchor.height));

		return newPort;
	}

	private PortSide getPortSide(final DiagramElement de, final boolean usingFixedPortPositions) {
		// If the container has nested ports, attempt to determine the port position from the fixed port position provider
		if (usingFixedPortPositions) {
			PortSide portSide = fixedPortPositionProvider.getPortSide(de);
			if (portSide != null) {
				return portSide;
			}
		}

		final DockingPosition defaultDockingPosition = de.getGraphicalConfiguration().defaultDockingPosition;
		return PortSideUtil.getPortSideForNonGroupDockArea(
				(defaultDockingPosition == DockingPosition.ANY && de.getDockArea() != null) ? de.getDockArea()
						: defaultDockingPosition.getDefaultDockArea());

	}

	public List<DiagramElement> getDockedChildren(final DiagramElement de) {
		return de.getDiagramElements().stream()
				.filter(child -> child.getGraphic() instanceof AgeShape && !(child.getGraphic() instanceof Label)
						&& child.getDockArea() != null)
				.collect(Collectors.toCollection(ArrayList::new));
	}

	private Optional<ElkGraphElement> createElkGraphElementForNonLabelAndUndockedShape(final DiagramElement de,
			final ElkNode layoutParent, final LayoutMapping mapping) {
		final ElkNode newNode = ElkGraphUtil.createNode(layoutParent);
		mapping.getGraphMap().put(newNode, de);

		if (de.hasPosition()) {
			newNode.setLocation(de.getX(), de.getY());
		}

		// Setting the size is disabled because setting it causes shapes which have a flow path(along with corresponding ports) to grow.
//		if (de.hasSize()) {
//			newNode.setDimensions(de.getWidth(), de.getHeight());
//		}

		final EnumSet<SizeConstraint> nodeSizeConstraints = EnumSet.of(SizeConstraint.PORTS,
				SizeConstraint.MINIMUM_SIZE, SizeConstraint.NODE_LABELS);
		newNode.setProperty(CoreOptions.NODE_SIZE_CONSTRAINTS, nodeSizeConstraints);
		newNode.setProperty(CoreOptions.INSIDE_SELF_LOOPS_ACTIVATE, true);

		newNode.setProperty(CoreOptions.NODE_SIZE_OPTIONS,
				EnumSet.of(SizeOptions.DEFAULT_MINIMUM_SIZE, SizeOptions.ASYMMETRICAL));

		// Create labels
		createElkLabels(de, newNode, mapping);

		// Create Children
		createElkGraphElementsForNonLabelChildShapes(de, newNode, mapping);

		return Optional.of(newNode);
	}

	private void createElkLabels(final DiagramElement parentElement, final ElkGraphElement parentLayoutElement,
			final LayoutMapping mapping) {
		// Don't create labels for ElkPort. The bounds of the port contain their labels.
		if (parentLayoutElement instanceof ElkPort) {
			return;
		}

		final boolean isConnection = parentElement.getGraphic() instanceof AgeConnection;

		final Style style = styleProvider.getStyle(parentElement);
		if (style.getPrimaryLabelVisible()) {
			// Create Primary Label
			if (parentElement.getLabelName() != null) {
				final ElkLabel elkLabel = createElkLabel(parentLayoutElement, parentElement.getLabelName(),
						layoutInfoProvider.getPrimaryLabelSize(parentElement));
				if (isConnection) {
					mapping.getGraphMap().put(elkLabel, new PrimaryConnectionLabelReference(parentElement));
				}
			}
		}

		// Create label for annotations which are part of the graphic configuration. These are only supported by non-connections.
		if (!isConnection && parentElement.getGraphicalConfiguration().annotation != null) {
			createElkLabel(parentLayoutElement, parentElement.getGraphicalConfiguration().annotation,
					layoutInfoProvider.getAnnotationLabelSize(parentElement));
		}

		// Create Secondary Labels
		parentElement.getDiagramElements().stream().filter(c -> c.getGraphic() instanceof Label)
		.forEachOrdered(labelElement -> {
			final ElkLabel elkLabel = createElkLabel(parentLayoutElement, labelElement.getLabelName(),
					labelElement.getSize());
			if (isConnection) {
				mapping.getGraphMap().put(elkLabel, new SecondaryConnectionLabelReference(labelElement));
			}
		});

		if (parentLayoutElement instanceof ElkNode) {
			parentLayoutElement.setProperty(CoreOptions.NODE_LABELS_PLACEMENT, getNodeLabelPlacement(style));
		}
	}

	private static EnumSet<NodeLabelPlacement> getNodeLabelPlacement(final Style s) {
		// Determine horizontal node label placement
		NodeLabelPlacement horizontalNodeLabelPlacement = NodeLabelPlacement.H_CENTER;
		if (s.getHorizontalLabelPosition() != null) {
			switch (s.getHorizontalLabelPosition()) {
			case BEFORE_GRAPHIC:
			case GRAPHIC_BEGINNING:
				horizontalNodeLabelPlacement = NodeLabelPlacement.H_LEFT;
				break;
			case GRAPHIC_CENTER:
				horizontalNodeLabelPlacement = NodeLabelPlacement.H_CENTER;
				break;
			case GRAPHIC_END:
			case AFTER_GRAPHIC:
				horizontalNodeLabelPlacement = NodeLabelPlacement.H_RIGHT;
				break;
			}
		}

		// Determine vertical node label placement
		NodeLabelPlacement verticalNodeLabelPlacement = NodeLabelPlacement.V_CENTER;
		if (s.getVerticalLabelPosition() != null) {
			switch (s.getVerticalLabelPosition()) {
			case BEFORE_GRAPHIC:
			case GRAPHIC_BEGINNING:
				verticalNodeLabelPlacement = NodeLabelPlacement.V_TOP;
				break;
			case GRAPHIC_CENTER:
				verticalNodeLabelPlacement = NodeLabelPlacement.V_CENTER;
				break;
			case GRAPHIC_END:
			case AFTER_GRAPHIC:
				verticalNodeLabelPlacement = NodeLabelPlacement.V_BOTTOM;
				break;
			}
		}

		// Build the node label placement set
		// Assume the placement of the nodes is inside because outside labels are only supported for docked shapes.
		// However, the ELK graph we build does not contain labels for ports, such labels are considered part of the port itself.
		return EnumSet.of(horizontalNodeLabelPlacement, verticalNodeLabelPlacement, NodeLabelPlacement.INSIDE);
	}

	/**
	 * Adds position offset along axis for the specified port, graphic port, and children
	 * @param de
	 * @param offset
	 * @param side
	 * @param mapping
	 */
	private void addPositionOffsets(final DiagramElement de, final double offset, final PortSide side,
			final LayoutMapping mapping) {
		final ElkPort childPort = (ElkPort) mapping.getGraphMap().inverse().get(de);

		final double newPosition = addPositionOffset(childPort, side, offset);

		// Only attempt to update child ports if nested ports are not being omitted.
		if (!omitNestedPorts) {
			de.getDiagramElements().stream()
			.filter(child -> child.getGraphic() instanceof AgeShape && !(child.getGraphic() instanceof Label)
					&& child.getDockArea() != null)
			.forEach(
					childDiagramElement -> addPositionOffsets(childDiagramElement, newPosition, side, mapping));
		}
	}

	/**
	 * Adds an offset to the position along the side's axis and returns the position along the axis.
	 * @param port
	 * @param side
	 * @param position
	 * @return
	 */
	private static double addPositionOffset(final ElkPort port, final PortSide side, final double position) {
		if (PortSide.SIDES_EAST_WEST.contains(side)) {
			final double newPosition = port.getY() + position;
			port.setY(newPosition);
			return newPosition;
		} else if (PortSide.SIDES_NORTH_SOUTH.contains(side)) {
			final double newPosition = port.getX() + position;
			port.setX(newPosition);
			return newPosition;
		} else {
			throw new RuntimeException("Unexpected side: " + side);
		}
	}

	private static ElkLabel createElkLabel(final ElkGraphElement parentLayoutElement, final String txt,
			final Dimension labelSize) {
		final ElkLabel newLabel = ElkGraphUtil.createLabel(parentLayoutElement);
		newLabel.setText(txt);

		if (labelSize != null) {
			newLabel.setWidth(labelSize.width);
			newLabel.setHeight(labelSize.height);
		}

		return newLabel;
	}

	/**
	 * Creates ELK edges for connection diagram nodes which are descendants of the specified node.
	 * Even though the results of the ELK edge routing are not used, it is still important because it affects the placements of shapes.
	 */
	private void createElkGraphElementsForConnections(final DiagramNode dn, final LayoutMapping mapping) {
		for (final DiagramElement de : dn.getDiagramElements()) {
			if (de.getGraphic() instanceof AgeConnection) {
				final ElkConnectableShape edgeStart = getConnectableShape(de.getStartElement(), mapping);
				final ElkConnectableShape edgeEnd = getConnectableShape(de.getEndElement(), mapping);
				if (edgeStart != null && edgeEnd != null) {
					final ElkConnectableShape start = edgeStart;
					final ElkConnectableShape end = edgeEnd;

					final ElkEdge newEdge = ElkGraphUtil.createSimpleEdge(start, end);
					// Ensure the edge has at least one section. Fixes NPE that can occur when laying out connections
					// with the same source and destination port.
					ElkGraphUtil.createEdgeSection(newEdge);

					// As of ELK 0.3.0 and 2018-02-26, an exception will be thrown when using a self loop with fixed ports which are on the same side.
					// See https://github.com/eclipse/elk/issues/297
					// As of ELK 0.3.0 and 2018-02-26, an exception will be thrown in certain cases where a self loop references a south/north port.
					// See https://github.com/eclipse/elk/issues/298
					boolean insideSelfLoopsYo = true;
					if (start instanceof ElkPort && end instanceof ElkPort) {
						if (start.eContainer() == end.eContainer()) {
							final PortSide startSide = start.getProperty(CoreOptions.PORT_SIDE);
							final PortSide endSide = end.getProperty(CoreOptions.PORT_SIDE);
							if (startSide == endSide || startSide == PortSide.NORTH || startSide == PortSide.SOUTH
									|| endSide == PortSide.NORTH || endSide == PortSide.SOUTH) {
								insideSelfLoopsYo = false;
							}
						}
					}

					// If the start and end of the edge is the same element, route the edge outside of the element.
					// An example of this sort of edge is a steady state state transition in the EMV2
					if (start == end) {
						insideSelfLoopsYo = false;
					}

					newEdge.setProperty(CoreOptions.INSIDE_SELF_LOOPS_YO, insideSelfLoopsYo);
					mapping.getGraphMap().put(newEdge, de);

					createElkLabels(de, newEdge, mapping);
				}
			}

			createElkGraphElementsForConnections(de, mapping);
		}
	}

	private ElkConnectableShape getConnectableShape(final DiagramElement de, final LayoutMapping mapping) {
		if (de == null) {
			return null;
		}

		final ElkGraphElement elkElement = mapping.getGraphMap().inverse().get(de);
		if (elkElement instanceof ElkConnectableShape) {
			return (ElkConnectableShape) elkElement;
		}

		// If omitting nested ports, use the first non-nested port for connection edges.
		// This is intended to encourage ELK to position ports on a more appropriate location.
		if (omitNestedPorts) {
			if (de.getDockArea() == DockArea.GROUP && de.getParent() instanceof DiagramElement) {
				return getConnectableShape((DiagramElement) de.getParent(), mapping);
			}
		}

		return null;
	}

	// These helper functions are useful for working with the size and position of an element with respect to a single axis as determined by a port side.

	/**
	 * Returns the size orthogonal to the specified side. For example for a WEST side, this method would return the width of the element.
	 * @param de
	 * @param side
	 * @return
	 */
	private static double getOrthogonalSize(final DiagramElement de, final PortSide side) {
		if (PortSide.SIDES_EAST_WEST.contains(side)) {
			return de.getWidth();
		} else if (PortSide.SIDES_NORTH_SOUTH.contains(side)) {
			return de.getHeight();
		} else {
			throw new RuntimeException("Unexpected side: " + side);
		}
	}

	private static double getOrthogonalSize(final ElkPort port, final PortSide side) {
		if (PortSide.SIDES_EAST_WEST.contains(side)) {
			return port.getWidth();
		} else if (PortSide.SIDES_NORTH_SOUTH.contains(side)) {
			return port.getHeight();
		} else {
			throw new RuntimeException("Unexpected side: " + side);
		}
	}

	private static double getOrthogonalSize(final Dimension dim, final PortSide side) {
		if (PortSide.SIDES_EAST_WEST.contains(side)) {
			return dim.width;
		} else if (PortSide.SIDES_NORTH_SOUTH.contains(side)) {
			return dim.height;
		} else {
			throw new RuntimeException("Unexpected side: " + side);
		}
	}

	private static double getSize(final ElkPort port, final PortSide side) {
		if (PortSide.SIDES_EAST_WEST.contains(side)) {
			return port.getHeight();
		} else if (PortSide.SIDES_NORTH_SOUTH.contains(side)) {
			return port.getWidth();
		} else {
			throw new RuntimeException("Unexpected side: " + side);
		}
	}

	/**
	 * Set the position of a port along a specified side. For example, if the side is a west side, it sets the Y coordinate.
	 * @param port
	 * @param side
	 * @param position
	 */
	private static void setPositionAlongSide(final ElkPort port, final PortSide side, final double position) {
		if (PortSide.SIDES_EAST_WEST.contains(side)) {
			port.setY(position);
		} else if (PortSide.SIDES_NORTH_SOUTH.contains(side)) {
			port.setX(position);
		} else {
			throw new RuntimeException("Unexpected side: " + side);
		}
	}

	/**
	 * Rotates the specified dimension based on the side.
	 * @param dim is the width and height specified as if it was along the east/west side
	 * @param side
	 * @return
	 */
	private static Dimension transformDimension(final Dimension dim, final PortSide side) {
		if (PortSide.SIDES_EAST_WEST.contains(side)) {
			return dim;
		} else if (PortSide.SIDES_NORTH_SOUTH.contains(side)) {
			return new Dimension(dim.height, dim.width);
		} else {
			throw new RuntimeException("Unexpected side: " + side);
		}
	}
}
