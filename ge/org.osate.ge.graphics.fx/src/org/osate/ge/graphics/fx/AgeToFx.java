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
package org.osate.ge.graphics.fx;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.DoubleStream;

import org.osate.ge.gef.FxStyle;
import org.osate.ge.gef.graphics.BusNode;
import org.osate.ge.gef.graphics.DeviceNode;
import org.osate.ge.gef.graphics.EllipseNode;
import org.osate.ge.gef.graphics.FeatureGroupTypeNode;
import org.osate.ge.gef.graphics.FolderNode;
import org.osate.ge.gef.graphics.LabelNode;
import org.osate.ge.gef.graphics.MemoryNode;
import org.osate.ge.gef.graphics.ModeNode;
import org.osate.ge.gef.graphics.ParallelogramNode;
import org.osate.ge.gef.graphics.PolygonNode;
import org.osate.ge.gef.graphics.PolylineNode;
import org.osate.ge.gef.graphics.ProcessorNode;
import org.osate.ge.gef.graphics.RectangleNode;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.LabelPosition;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.internal.BusGraphic;
import org.osate.ge.graphics.internal.DeviceGraphic;
import org.osate.ge.graphics.internal.Ellipse;
import org.osate.ge.graphics.internal.FeatureGroupTypeGraphic;
import org.osate.ge.graphics.internal.FolderGraphic;
import org.osate.ge.graphics.internal.Label;
import org.osate.ge.graphics.internal.MemoryGraphic;
import org.osate.ge.graphics.internal.ModeGraphic;
import org.osate.ge.graphics.internal.Parallelogram;
import org.osate.ge.graphics.internal.Poly;
import org.osate.ge.graphics.internal.ProcessorGraphic;
import org.osate.ge.graphics.internal.Rectangle;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import javafx.geometry.Dimension2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

// TODO: Rename.. Stop using Age prefix?
// TODO: Need to require instantiation? Something will need an ImageManager. Should be shared at the application level.
public class AgeToFx {
	private static final Map<Class<? extends Graphic>, Function<? extends Graphic, Node>> creatorMap;

	private static <G extends Graphic> void addCreator(
			ImmutableMap.Builder<Class<? extends Graphic>, Function<? extends Graphic, Node>> mapBuilder, Class<G> c,
			Function<G, Node> creator) {
		mapBuilder.put(c, creator);
	}

	// TODO: Review. Ensure that all graphics and appropriate fields are supported.
	static {
		final ImmutableMap.Builder<Class<? extends Graphic>, Function<? extends Graphic, Node>> mapBuilder = new ImmutableMap.Builder<>();
		addCreator(mapBuilder, Rectangle.class, rg -> new RectangleNode(rg.rounded));
		addCreator(mapBuilder, Ellipse.class, eg -> new EllipseNode());
		addCreator(mapBuilder, FolderGraphic.class, fg -> new FolderNode());
		addCreator(mapBuilder, DeviceGraphic.class, dg -> new DeviceNode());
		addCreator(mapBuilder, Poly.class, poly -> {
			final double[] points = Arrays.stream(poly.getPoints()).flatMapToDouble(p -> DoubleStream.of(p.x, p.y))
					.toArray();
			final Dimension2D fixedSize = poly.fixedSize == null ? null
					: new Dimension2D(poly.fixedSize.width, poly.fixedSize.height);
			switch (poly.type) {
			case POLYGON:
				return new PolygonNode(
						fixedSize,
						points);

			case POLYLINE:
				return new PolylineNode(fixedSize, points);

			default:
				throw new RuntimeException("Unhandled type: " + poly.type);
			}
		});
		addCreator(mapBuilder, Parallelogram.class, pg -> new ParallelogramNode(pg.horizontalOffset));
		addCreator(mapBuilder, BusGraphic.class, bg -> new BusNode());
		addCreator(mapBuilder, ProcessorGraphic.class, pg -> new ProcessorNode());
		addCreator(mapBuilder, MemoryGraphic.class, pg -> new MemoryNode());
		addCreator(mapBuilder, FeatureGroupTypeGraphic.class, fgtg -> new FeatureGroupTypeNode());
		addCreator(mapBuilder, ModeGraphic.class, mg -> {
			final ModeNode mn = new ModeNode();
			mn.setInitialMode(mg.isInitialMode);
			return mn;
		});
		addCreator(mapBuilder, Label.class, lg -> new LabelNode());
//		addGraphicsAlgorithmCreator(map, FeatureGraphic.class,

		creatorMap = mapBuilder.build();

	}

	// TODO: Document what graphics are supported
	public static Node createNode(final Graphic graphic) {
		@SuppressWarnings("unchecked")
		final Function<Graphic, Node> c = (Function<Graphic, Node>) creatorMap.get(graphic.getClass());
		if (c == null) {
			throw new RuntimeException("Unsupported object: " + graphic);
		}

		return c.apply(graphic);
	}

	public static FxStyle createStyle(final Style style) {
		if (!style.isComplete()) {
			throw new RuntimeException("Specified style must be complete");
		}

		// TODO: Add additional fields
		return new FxStyle.Builder().backgroundColor(ageToFxColor(style.getBackgroundColor()))
				.outlineColor(ageToFxColor(style.getOutlineColor())).fontColor(ageToFxColor(style.getFontColor()))
				.font(new Font("Arial", style.getFontSize())).strokeDashOffset(1.0) // TODO: Convert line style to stroke dash offset
				.strokeDashArray(ImmutableList.of()) // TODO: Convert line style to stroke dash array
				.lineWidth(style.getLineWidth()).horizontalLabelPosition(convert(style.getHorizontalLabelPosition()))
				.verticalLabelPosition(convert(style.getVerticalLabelPosition()))
				.primaryLabelVisible(style.getPrimaryLabelVisible()).
				build();
	}

	private static org.osate.ge.gef.LabelPosition convert(final LabelPosition value) {
		switch (value) {
		case BEFORE_GRAPHIC:
			// The output type doesn't have a matching value. Use beginning.
			return org.osate.ge.gef.LabelPosition.BEGINNING;
		case GRAPHIC_BEGINNING:
			return org.osate.ge.gef.LabelPosition.BEGINNING;
		case GRAPHIC_CENTER:
			return org.osate.ge.gef.LabelPosition.CENTER;
		case GRAPHIC_END:
			return org.osate.ge.gef.LabelPosition.END;
		case AFTER_GRAPHIC:
			// The output type doesn't have a matching value. Use end.
			return org.osate.ge.gef.LabelPosition.END;
		default:
			throw new IllegalArgumentException("Unexpected value: " + value);
		}
	}

	private static Color ageToFxColor(final org.osate.ge.graphics.Color color) {
		return Color.rgb(color.getRed(), color.getGreen(), color.getBlue());
	}
}
