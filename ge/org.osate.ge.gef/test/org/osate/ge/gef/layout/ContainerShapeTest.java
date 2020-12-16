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
package org.osate.ge.gef.layout;

import java.nio.file.Paths;

import org.eclipse.gef.fx.nodes.InfiniteCanvas;
import org.osate.ge.gef.FxStyle;
import org.osate.ge.gef.FxStyleUtil;
import org.osate.ge.gef.LabelPosition;
import org.osate.ge.gef.StyleRoot;
import org.osate.ge.gef.graphics.BusNode;
import org.osate.ge.gef.graphics.DataPortNode;
import org.osate.ge.gef.graphics.FeatureGroupNode;
import org.osate.ge.gef.graphics.ImageManager;
import org.osate.ge.gef.graphics.ImageReference;
import org.osate.ge.gef.graphics.LabelNode;
import org.osate.ge.gef.graphics.NodeApplication;
import org.osate.ge.gef.graphics.PolygonNode;
import org.osate.ge.gef.graphics.PolylineNode;
import org.osate.ge.gef.graphics.RectangleNode;

import com.google.common.collect.ImmutableList;

import javafx.beans.value.ChangeListener;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.geometry.Bounds;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

// TODO: Rename?
public class ContainerShapeTest {
	private ContainerShapeTest() {
	}

	public static void main(final String[] args) {
		NodeApplication.run(() -> {
			//
			// Create Top Level Node
			//
			final ContainerShape top = new ContainerShape();
			top.getGraphics().setAll(new RectangleNode(true));

			//
			// Create Labels
			//
			final LabelNode label1 = new LabelNode("Top Node");
			final LabelNode label2 = new LabelNode(
					"Longer single-line label. This should be truncated if there isn't space.");
			final LabelNode label3 = new LabelNode(
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
			label3.setWrapText(true);
			top.getLabels().setAll(label1, label2, label3);

			//
			// Create Free Children
			//
			final ContainerShape freeChild1 = new ContainerShape();
			freeChild1.getGraphics().setAll(new BusNode());
			freeChild1.getLabels().setAll(new LabelNode("Child Node #1"));
			PreferredPosition.set(freeChild1, new Point2D(200, 200));
			top.getFreeChildren().add(freeChild1);

			// TODO: Set position. Set an explicit preferred size
			final ContainerShape freeChild2 = new ContainerShape();
			freeChild2.setHorizontalLabelPosition(LabelPosition.CENTER);
			freeChild2.setVerticalLabelPosition(LabelPosition.BEGINNING);
			freeChild2.getGraphics().setAll(new RectangleNode());
			freeChild2.getLabels().setAll(new LabelNode("Child Node #2"));
			top.getFreeChildren().add(freeChild2);
			PreferredPosition.set(freeChild2, new Point2D(50, 400));

			// TODO: Suggest a size
			freeChild2.setConfiguredWidth(300);
			freeChild2.setConfiguredHeight(100);

			//
			// TODO: Docking test
			//
			// TODO; Change node types to distinguish them
			// TODO: Create docked children(features)
//			final DockedShape leftChild1 = createDockedShape("Data Port", new DataPortNode());
//			top.getLeftChildren().add(leftChild1);
//			ContainerShape.setPrefPosition(leftChild1, new Point2D(0, 100));

			// TODO: Reenable when layout bounds issue is worked out
			final DockedShape fg = createDockedShape("Feature Group", new FeatureGroupNode());
			// top.getLeftChildren().add(fg);
			top.getRightChildren().add(fg);
			// top.getTopChildren().add(fg);
			// top.getBottomChildren().add(fg);
			fg.setConfiguredWidth(400.0);
			fg.setConfiguredHeight(50.0);
			PreferredPosition.set(fg, new Point2D(0, 388));

			final DockedShape fgChild1 = createDockedShape("FG Child #1", new DataPortNode());
			fg.getNestedChildren().add(fgChild1);
			// TODO: Need a way to set a preferred position for feature group child

			final DockedShape fgChild2 = createDockedShape("FG Child #2", new DataPortNode());
			fg.getNestedChildren().add(fgChild2);
			// TODO: Need a way to set a preferred position for feature group child

			//
			// Nested feature groups
			//
			final DockedShape nestedFg = createDockedShape("Feature Group", new FeatureGroupNode());
			fg.getNestedChildren().add(nestedFg);
			nestedFg.getNestedChildren().add(createDockedShape("NFG Child #1", new DataPortNode()));
			nestedFg.getNestedChildren().add(createDockedShape("NFG Child #2", new DataPortNode()));

			// Features for free children
			final DockedShape freeChild2Port1 = createDockedShape("Data Port", new DataPortNode());
			freeChild2.getRightChildren().add(freeChild2Port1);

			// Flow Indicator
			final FlowIndicatorNode fi1 = new FlowIndicatorNode();
			fi1.setPrimaryLabel(new LabelNode("<FLOW INDICATOR>"));
			fi1.setStartDecoration(new PolygonNode(new Dimension2D(20.0, 12.0), 1.0, 1.0, 0.0, 0.5, 1.0, 0.0));
			fi1.setEndDecoration(new PolylineNode(new Dimension2D(0.0, 16.0), 0.0, 0.0, 0.0, 1.0));
			PreferredPosition.set(fi1, new Point2D(50.0, 26.0));
			fi1.setBendpoints(ImmutableList.of(new org.eclipse.gef.geometry.planar.Point(120, 0),
					new org.eclipse.gef.geometry.planar.Point(120, 50),
					new org.eclipse.gef.geometry.planar.Point(80, 50),
					new org.eclipse.gef.geometry.planar.Point(80, 0)));

// TDO: Add labels

			fi1.setStartAnchor(freeChild2Port1.getInteriorAnchor());
			freeChild2.getFreeChildren().add(fi1);

			//
			// Connections
			//
			// TODO: Decide what to add connections to. Could replace top with an infinite canvas but then resizing
			// of the top node wouldn't be demonstrated. Could do that another way?
			// TODO: Add connections to docked and undocked.

			// TODO: Instead of being a group, should be its own type of node to ensure consistent behavior?
			final BaseConnectionNode c1 = new ConnectionNode();
			c1.setStartAnchor(fgChild1.getInteriorAnchor());
			c1.setEndAnchor(freeChild2Port1.getExteriorAnchor());
			c1.setPrimaryLabel(new LabelNode("Connection #1"));
			c1.getOtherLabels().setAll(new LabelNode("Label 2"), new LabelNode("L2"));
//			c1.setBendpoints(ImmutableList.of(new org.eclipse.gef.geometry.planar.Point(530, 200),
//					new org.eclipse.gef.geometry.planar.Point(480, 200),
//					new org.eclipse.gef.geometry.planar.Point(480, 430)));

			//			c1.getCenterDecorators().setAll(new PolygonNode(new Dimension2D(20.0, 12.0), 1.0, 1.0, 0.0, 0.5, 1.0, 0.0));
			c1.getMidpointDecorations().setAll(new PolygonNode(new Dimension2D(20.0, 12.0), 1.0, 1.0, 0.0, 0.5, 1.0, 0.0),
					new PolygonNode(new Dimension2D(10.0, 12.0), 1.0, 1.0, 0.0, 0.5, 1.0, 0.0));
			// TODO: Test with another decorator

			// TODO: Decorators must be sized by something... prefWIdth and prefHeight not enough
			// TODO: Unless conenction wrapper handles it..
			c1.setStartDecoration(new PolygonNode(new Dimension2D(8.0, 12.0), 1.0, 1.0, 0.0, 0.5, 1.0, 0.0));
			c1.setEndDecoration(new PolygonNode(new Dimension2D(20.0, 10.0), 1.0, 1.0, 0.0, 0.5, 1.0, 0.0));

			final BaseConnectionNode c2 = new ConnectionNode();
			c2.setStartAnchor(freeChild1.getAnchor());
			c2.setEndAnchor(c1.getMidpointAnchor());// nestedFg.getInteriorAnchor()); // TODO

			//
			// TODO: Integrate with a connection object that will support layout, etc
			//

//			final Group cg1 = new Group();
//			cg1.getChildren().add(connection);
//			final Label connectionLabel = new LabelNode("connection #1");
//			cg1.getChildren().add(connectionLabel);
//			connection.getChildren().add(new LabelNode("test 2"));
//			connection.pointsUnmodifiableProperty()
//					.addListener((ChangeListener<ObservableList<org.eclipse.gef.geometry.planar.Point>>) (observable,
//							oldValue, newValue) -> {
//			});
//
//			c1.pointsUnmodifiableProperty().addListener((InvalidationListener) observable -> {
//				// TODO Auto-generated method stub
//			});
			// TODO: Check invalidation listener too
			// TODO: this appears to work but it it realy a good idea? Should do it as part of layout instead
			// of listening? If caching is needed.. use invalidation listener..
//			c1.pointsUnmodifiableProperty()
//					.addListener((ListChangeListener<Point>) c -> {
//						final Point center = c1.getCenter();
//						connectionLabel.relocate(center.x, center.y);
//					});
			// connection.setRouter(new OrthogonalRouter()); // TODO

			// Add a click listener to perform changes.
			// TODO: Remove? Temporary code
			top.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
				System.err.println("Clicked");
				// TODO: Move - Free shape
				PreferredPosition.set(freeChild1, new Point2D(100, 250));

				PreferredPosition.set(freeChild2, new Point2D(10, 350));

				// TODO: Move Feature group
				PreferredPosition.set(fg, new Point2D(0, 200));

				// TODO: Move feature
				PreferredPosition.set(fgChild1, new Point2D(0, 100));

				// TODO: Resize container
			});

			final InfiniteCanvas canvas = new InfiniteCanvas();
			canvas.getContentGroup().getChildren().add(top);

			// TODO:
			canvas.getContentGroup().getChildren().add(c1);
			canvas.getContentGroup().getChildren().add(c2);

			// Resize the top node to match the size of the canvas
			canvas.boundsInLocalProperty().addListener((ChangeListener<Bounds>) (observable, oldValue, newValue) -> {
				top.setConfiguredWidth(newValue.getWidth());
				top.setConfiguredHeight(newValue.getHeight());
			});

			// Image manager
			final ImageManager images = new ImageManager();

			// Start a service which will reload images
			ScheduledService<Void> svc = new ScheduledService<Void>() {
				@Override
				protected Task<Void> createTask() {
					return new Task<Void>() {
						@Override
						protected Void call() {
							images.refreshImages();
							return null;
						}
					};
				}
			};
			svc.setPeriod(Duration.seconds(1));
			svc.start();

			final ImageReference testImage = args.length > 0 ? images.getImageReference(Paths.get(args[0])) : null;

			//
			// Style test
			//
			final FxStyle s1 = new FxStyle.Builder().primaryLabelVisible(false).image(testImage)
					.build();
			final FxStyle s2 = new FxStyle.Builder().outlineColor(Color.BLUE).primaryLabelVisible(false).build();
			StyleRoot.set(top, true);
			StyleRoot.set(freeChild1, true);
			StyleRoot.set(freeChild2, true);
//			FxStyleUtil.applyStyle(freeChild1, s2);
//			FxStyleUtil.applyStyle(freeChild2, s2);
			FxStyleUtil.applyStyle(top, s1);
//			FxStyleUtil.applyStyle(canvas, s1);

			return canvas;
		});
	}

	private static DockedShape createDockedShape(final String label, final Node graphic) {
		final DockedShape newNode = new DockedShape();
		newNode.getLabels().setAll(new LabelNode(label));
		newNode.setGraphic(graphic);
		return newNode;
	}
}
