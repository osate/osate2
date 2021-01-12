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
package org.osate.ge.gef;

import java.nio.file.Paths;

import org.eclipse.gef.fx.nodes.InfiniteCanvas;

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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

// TODO: Rename?
public class GefTest {
	private GefTest() {
	}

	public static void main(final String[] args) {
		try (final ImageManager images = new ImageManager()) {
			NodeApplication.run(() -> {
				final RootNode root = new RootNode();

				//
				// Create Top Level Node
				//
				final ContainerShape top1 = new ContainerShape();
				top1.getGraphics().setAll(new RectangleNode(true));
				root.getChildren().setAll(top1);

				//
				// Create Labels
				//
				final LabelNode label1 = new LabelNode("Top Node");
				final LabelNode label2 = new LabelNode(
						"Longer single-line label. This should be truncated if there isn't space.");
				final LabelNode label3 = new LabelNode(
						"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
				label3.setWrapText(true);
				top1.getPrimaryLabels().setAll(label1);
				top1.getSecondaryLabels().setAll(label2, label3);

				//
				// Create Free Children
				//
				final ContainerShape freeChild1 = new ContainerShape();
				freeChild1.getGraphics().setAll(new BusNode());
				freeChild1.getPrimaryLabels().setAll(new LabelNode("Child Node #1"));
				freeChild1.getSecondaryLabels().setAll(new LabelNode("<Additional Label>"));
				PreferredPosition.set(freeChild1, new Point2D(300, 250));
				top1.getFreeChildren().add(freeChild1);

				// TODO: Set position. Set an explicit preferred size
				final ContainerShape freeChild2 = new ContainerShape();
				freeChild2.setHorizontalLabelPosition(LabelPosition.CENTER);
				freeChild2.setVerticalLabelPosition(LabelPosition.BEGINNING);
				freeChild2.getGraphics().setAll(new RectangleNode());
				freeChild2.getPrimaryLabels().setAll(new LabelNode("Child Node #2")); // TODO
				top1.getFreeChildren().add(freeChild2);
				PreferredPosition.set(freeChild2, new Point2D(150, 400));

				// TODO: Suggest a size
				freeChild2.setConfiguredWidth(310);
				freeChild2.setConfiguredHeight(100);

				//
				// TODO: Docking test
				//
				// TODO; Change node types to distinguish them
				// TODO: Create docked children(features)

				// TODO: Remove
				final DockedShape if1 = createDockedShape("at_impl_new_feature",
						new PortNode(false, true, FeatureDirection.IN));
				if1.getSecondaryLabels().add(new LabelNode("<internal>"));
				top1.getLeftChildren().add(if1);

				final DockedShape if2 = createDockedShape("at_new_feature20",
						new PortNode(false, true, FeatureDirection.IN));
				top1.getLeftChildren().add(if2);

				final DockedShape fgt1 = createDockedShape("d1", new FeatureGroupNode());
				top1.getLeftChildren().add(fgt1);
				final DockedShape fgt2 = createDockedShape("c1", new FeatureGroupNode());
				fgt1.getNestedChildren().add(fgt2);

				final DockedShape fgt2c1 = createDockedShape("c_new_feature",
						new PortNode(false, true, FeatureDirection.IN));
				fgt2.getNestedChildren().add(fgt2c1);

				final DockedShape fgt2c2 = createDockedShape("c_new_feature2",
						new PortNode(false, true, FeatureDirection.IN));
				fgt2.getNestedChildren().add(fgt2c2);

				// TODO: Reenable when layout bounds issue is worked out
				final DockedShape fg = createDockedShape("Feature Group", new FeatureGroupNode());
				top1.getLeftChildren().add(fg);
				// top1.getRightChildren().add(fg);

				// top.getTopChildren().add(fg);
				// top.getBottomChildren().add(fg);
				fg.setConfiguredWidth(400.0);
				fg.setConfiguredHeight(50.0);
				// PreferredPosition.set(fg, new Point2D(0, 388));
				PreferredPosition.set(fg, new Point2D(0, 200));

				final DockedShape fgChild1 = createDockedShape("FG Child #1",
						new PortNode(false, true, FeatureDirection.IN));
				fgChild1.getSecondaryLabels().add(new LabelNode("<internal>"));
				fg.getNestedChildren().add(fgChild1);
				// TODO: Need a way to set a preferred position for feature group child

				final DockedShape fgChild2 = createDockedShape("c_new_feature2",
						new PortNode(false, true, FeatureDirection.OUT));
				fg.getNestedChildren().add(fgChild2);
				// TODO: Need a way to set a preferred position for feature group child

				//
				// Nested feature groups
				//
				final DockedShape nestedFg = createDockedShape("Feature Group", new FeatureGroupNode());
				fg.getNestedChildren().add(nestedFg);
				nestedFg.getNestedChildren()
						.add(createDockedShape("NFG Child #1", new PortNode(false, true, FeatureDirection.IN_OUT)));
				nestedFg.getNestedChildren()
						.add(createDockedShape("NFG Child #2", new PortNode(false, true, FeatureDirection.IN)));

				// Features for free children
				final DockedShape freeChild2Port1 = createDockedShape("Data Port",
						new PortNode(false, true, FeatureDirection.IN));
				freeChild2Port1.getSecondaryLabels().add(new LabelNode("<Additional Label>"));
				freeChild2.getRightChildren().add(freeChild2Port1);

				// Flow Indicator
				final FlowIndicatorNode fi1 = new FlowIndicatorNode();
				fi1.getPrimaryLabels().setAll(new LabelNode("<FLOW INDICATOR>"));
				fi1.setStartDecoration(new PolygonNode(new Dimension2D(20.0, 12.0), 1.0, 1.0, 0.0, 0.5, 1.0, 0.0));
				fi1.setEndDecoration(new PolylineNode(new Dimension2D(0.0, 16.0), 0.0, 0.0, 0.0, 1.0));
				PreferredPosition.set(fi1, new Point2D(50.0, 26.0));
				fi1.setBendpoints(ImmutableList.of(new org.eclipse.gef.geometry.planar.Point(120, 0),
						new org.eclipse.gef.geometry.planar.Point(120, 50),
						new org.eclipse.gef.geometry.planar.Point(80, 50),
						new org.eclipse.gef.geometry.planar.Point(80, 0)));

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
				c1.getPrimaryLabels().setAll(new LabelNode("Connection #1"), new LabelNode("Connection #1 B"));
				c1.getSecondaryLabels().setAll(new LabelNode("Label 2"), new LabelNode("L2"));
				c1.setBendpoints(ImmutableList.of(new org.eclipse.gef.geometry.planar.Point(530, 200),
						new org.eclipse.gef.geometry.planar.Point(480, 200),
						new org.eclipse.gef.geometry.planar.Point(480, 430)));

				// c1.getCenterDecorators().setAll(new PolygonNode(new Dimension2D(20.0, 12.0), 1.0, 1.0, 0.0, 0.5, 1.0, 0.0));
				c1.getMidpointDecorations().setAll(
						new PolygonNode(new Dimension2D(20.0, 12.0), 1.0, 1.0, 0.0, 0.5, 1.0, 0.0),
						new PolygonNode(new Dimension2D(10.0, 12.0), 1.0, 1.0, 0.0, 0.5, 1.0, 0.0));
				// TODO: Test with another decorator

				// TODO: Decorators must be sized by something... prefWIdth and prefHeight not enough
				// TODO: Unless connection wrapper handles it..
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
				top1.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
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
				canvas.getContentGroup().getChildren().add(root);

				root.getChildren().add(c1);
				root.getChildren().add(c2);

				canvas.boundsInLocalProperty()
						.addListener((ChangeListener<Bounds>) (observable, oldValue, newValue) -> {
							top1.setConfiguredWidth(newValue.getWidth());
							top1.setConfiguredHeight(newValue.getHeight());
						});

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
				final Font f1 = Font.font("Arial", FontWeight.NORMAL, 14.0); // TODO: Adjust
				final FxStyle s1 = new FxStyle.Builder().primaryLabelsVisible(true).font(f1).image(testImage).build();
				final FxStyle s2 = new FxStyle.Builder().outlineColor(Color.BLUE).primaryLabelsVisible(true).build();
				StyleRoot.set(top1, true);
				StyleRoot.set(freeChild1, true);
				StyleRoot.set(freeChild2, true);
				// StyleRoot.set(c1, true);
				// StyleRoot.set(fi1, true);
				FxStyleApplier.applyStyle(freeChild1, s2);
				FxStyleApplier.applyStyle(freeChild2, s2);
				FxStyleApplier.applyStyle(top1, s1);

				// FxStyleApplier.applyStyle(c1, s1);
				// FxStyleUtil.applyStyle(canvas, s1);

				// FxStyleUtil.applyStyle(fi1, s2);

				return canvas;
			});
		}
	}

	private static DockedShape createDockedShape(final String label, final Node graphic) {
		final DockedShape newNode = new DockedShape();
		newNode.getPrimaryLabels().setAll(new LabelNode(label));
		newNode.setGraphic(graphic);
		return newNode;
	}
}
