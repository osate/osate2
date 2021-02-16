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

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.DoubleStream;

import org.osate.ge.gef.AbstractFeatureNode;
import org.osate.ge.gef.BaseConnectionNode;
import org.osate.ge.gef.BusNode;
import org.osate.ge.gef.ConnectionNode;
import org.osate.ge.gef.DataOrBusAccessFeatureNode;
import org.osate.ge.gef.DeviceNode;
import org.osate.ge.gef.EllipseNode;
import org.osate.ge.gef.FeatureDirection;
import org.osate.ge.gef.FeatureGroupNode;
import org.osate.ge.gef.FeatureGroupTypeNode;
import org.osate.ge.gef.FlowIndicatorNode;
import org.osate.ge.gef.FolderNode;
import org.osate.ge.gef.LabelNode;
import org.osate.ge.gef.MemoryNode;
import org.osate.ge.gef.ModeNode;
import org.osate.ge.gef.NoteNode;
import org.osate.ge.gef.ParallelogramNode;
import org.osate.ge.gef.PolygonNode;
import org.osate.ge.gef.PolylineNode;
import org.osate.ge.gef.PortNode;
import org.osate.ge.gef.ProcessorNode;
import org.osate.ge.gef.RectangleNode;
import org.osate.ge.gef.SubprogramAccessNode;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.internal.AgeConnection;
import org.osate.ge.graphics.internal.AgeConnectionTerminator;
import org.osate.ge.graphics.internal.BusGraphic;
import org.osate.ge.graphics.internal.ConnectionTerminatorSize;
import org.osate.ge.graphics.internal.DeviceGraphic;
import org.osate.ge.graphics.internal.Direction;
import org.osate.ge.graphics.internal.Ellipse;
import org.osate.ge.graphics.internal.FeatureGraphic;
import org.osate.ge.graphics.internal.FeatureGroupTypeGraphic;
import org.osate.ge.graphics.internal.FolderGraphic;
import org.osate.ge.graphics.internal.Label;
import org.osate.ge.graphics.internal.MemoryGraphic;
import org.osate.ge.graphics.internal.ModeGraphic;
import org.osate.ge.graphics.internal.NoteGraphic;
import org.osate.ge.graphics.internal.Parallelogram;
import org.osate.ge.graphics.internal.Poly;
import org.osate.ge.graphics.internal.ProcessorGraphic;
import org.osate.ge.graphics.internal.Rectangle;

import com.google.common.collect.ImmutableMap;

import javafx.geometry.Dimension2D;
import javafx.scene.Node;

/**
 * Class responsible for creating JavaFX nodes based on graphical editor {@link Graphic} instances used by the
 * graphical editor's public API.
 */
public class GraphicToFx {
	private static final Map<Class<? extends Graphic>, Function<? extends Graphic, Node>> factoryMap;
	private static final double[] arrowPoints = { 1.0, 1.0, 0.0, 0.5, 1.0, 0.0 };
	private static final double[] mirroredArrowPoints = { 0.0, 1.0, 1.0, 0.5, 0.0, 0.0 };

	private static <G extends Graphic> void addFactory(
			ImmutableMap.Builder<Class<? extends Graphic>, Function<? extends Graphic, Node>> mapBuilder, Class<G> c,
			Function<G, Node> factory) {
		mapBuilder.put(c, factory);
	}

	// Build the map that contains the factory for each type of graphic
	static {
		final ImmutableMap.Builder<Class<? extends Graphic>, Function<? extends Graphic, Node>> mapBuilder = new ImmutableMap.Builder<>();
		addFactory(mapBuilder, Rectangle.class, rg -> new RectangleNode(rg.rounded));
		addFactory(mapBuilder, Ellipse.class,
				eg -> new EllipseNode(eg.getFixedSize().map(s -> new Dimension2D(s.width, s.height)).orElse(null)));
		addFactory(mapBuilder, FolderGraphic.class, fg -> new FolderNode());
		addFactory(mapBuilder, DeviceGraphic.class, dg -> new DeviceNode());
		addFactory(mapBuilder, Poly.class, poly -> {
			final double[] points = Arrays.stream(poly.getPoints()).flatMapToDouble(p -> DoubleStream.of(p.x, p.y))
					.toArray();
			final Dimension2D fixedSize = poly.fixedSize == null ? null
					: new Dimension2D(poly.fixedSize.width, poly.fixedSize.height);
			switch (poly.type) {
			case POLYGON:
				return new PolygonNode(fixedSize, points);

			case POLYLINE:
				return new PolylineNode(fixedSize, points);

			default:
				throw new RuntimeException("Unhandled type: " + poly.type);
			}
		});
		addFactory(mapBuilder, Parallelogram.class, pg -> new ParallelogramNode(pg.horizontalOffset));
		addFactory(mapBuilder, BusGraphic.class, bg -> new BusNode());
		addFactory(mapBuilder, ProcessorGraphic.class, pg -> new ProcessorNode());
		addFactory(mapBuilder, MemoryGraphic.class, pg -> new MemoryNode());
		addFactory(mapBuilder, FeatureGroupTypeGraphic.class, fgtg -> new FeatureGroupTypeNode());
		addFactory(mapBuilder, ModeGraphic.class, mg -> {
			final ModeNode mn = new ModeNode();
			mn.setInitialMode(mg.isInitialMode);
			return mn;
		});
		addFactory(mapBuilder, NoteGraphic.class, ng -> new NoteNode());
		addFactory(mapBuilder, Label.class, lg -> new LabelNode());
		addFactory(mapBuilder, FeatureGraphic.class, fg -> {
			switch (fg.featureType) {
			case ABSTRACT:
				return new AbstractFeatureNode(convert(fg.direction));
			case BUS_OR_DATA_ACCESS:
				return new DataOrBusAccessFeatureNode(fg.direction == Direction.IN);
			case DATA_PORT:
				return new PortNode(false, true, convert(fg.direction));
			case EVENT_DATA_PORT:
				return new PortNode(true, true, convert(fg.direction));
			case EVENT_PORT:
				return new PortNode(true, false, convert(fg.direction));
			case FEATURE_GROUP:
				return new FeatureGroupNode();
			case SUBPROGRAM_ACCESS:
				return new SubprogramAccessNode(fg.direction == Direction.IN, true);
			case SUBPROGRAM_GROUP_ACCESS:
				return new SubprogramAccessNode(fg.direction == Direction.IN, false);
			default:
				throw new RuntimeException("Unexpected feature type: " + fg.featureType);
			}
		});
		addFactory(mapBuilder, AgeConnection.class, c -> {
			final BaseConnectionNode n;
			if (c.isFlowIndicator) {
				n = new FlowIndicatorNode();
			} else {
				n = new ConnectionNode();
			}

			if (c.srcTerminator != null) {
				n.setStartDecoration(createNode(c.srcTerminator));
			}

			if (c.dstTerminator != null) {
				n.setEndDecoration(createNode(c.dstTerminator));
			}

			return n;
		});

		factoryMap = mapBuilder.build();

	}

	/**
	 * Creates a JavaFX node for the specified graphic.
	 * @param graphic the graphic for which to create the node.
	 * @return the new node.
	 */
	public static Node createNode(final Graphic graphic) {
		@SuppressWarnings("unchecked")
		final Function<Graphic, Node> c = (Function<Graphic, Node>) factoryMap.get(graphic.getClass());
		if (c == null) {
			throw new RuntimeException("Unsupported object: " + graphic);
		}

		return c.apply(graphic);
	}

	private static Node createNode(final AgeConnectionTerminator t) {
		switch (t.type) {
		case FILLED_ARROW:
			return createPolygonArrow(t.size, t.reversed);
		case LINE_ARROW:
			return createLineArrow(t.size, t.reversed);
		case ORTHOGONAL_LINE:
			return new PolylineNode(new Dimension2D(0.0, 16.0), 0.0, 1.0, 0.0, 0.0);
		default:
			throw new RuntimeException("Unsupported connection terminator type: " + t.type);
		}
	}

	private static Node createPolygonArrow(final ConnectionTerminatorSize size, final boolean reverse) {
		final Dimension2D dim;
		switch (size) {
		case REGULAR:
			dim = new Dimension2D(12.0, 12.0);
			break;
		case SMALL:
			dim = new Dimension2D(8.0, 8.0);
			break;
		default:
			throw new RuntimeException("Unsupported connection terminator size: " + size);
		}

		return new PolygonNode(dim, reverse ? mirroredArrowPoints : arrowPoints);
	}

	private static Node createLineArrow(final ConnectionTerminatorSize size, final boolean reverse) {
		final Dimension2D dim;
		switch (size) {
		case REGULAR:
			dim = new Dimension2D(16.0, 16.0);
			break;
		case SMALL:
			dim = new Dimension2D(8.0, 10.0);
			break;
		default:
			throw new RuntimeException("Unsupported connection terminator size: " + size);
		}

		return new PolylineNode(dim, reverse ? mirroredArrowPoints : arrowPoints);
	}

	private static FeatureDirection convert(final Direction value) {
		switch (value) {
		case IN:
			return FeatureDirection.IN;
		case IN_OUT:
			return FeatureDirection.IN_OUT;
		case OUT:
			return FeatureDirection.OUT;
		default:
			throw new RuntimeException("Unsupported value: " + value);
		}
	}
}
