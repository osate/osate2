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

/**
 * Standalone test application which utilizes various nodes. Not exhaustive. It focuses primarily on
 * {@link ContainerShape} and {@link DockedShape}
 */
public class GefTest {
	private GefTest() {
	}

	public static void main(final String[] args) {
		try (final ImageManager images = new ImageManager()) {
			NodeApplication.run(() -> {
				final DiagramRootNode root = new DiagramRootNode();

				//
				// Create Top Level Node
				//
				final ContainerShape top1 = new ContainerShape();
				top1.setGraphic(new RectangleNode(true));
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
				// Left Features
				//
				final DockedShape lfg1 = createDockedShape("lfg1", new FeatureGroupNode());
				top1.getLeftChildren().add(lfg1);
				lfg1.setConfiguredWidth(400.0);
				lfg1.setConfiguredHeight(50.0);
				PreferredPosition.set(lfg1, new Point2D(0, 300));

				final DockedShape lfg1Child1 = createDockedShape("lfg1Child1",
						new PortNode(false, true, FeatureDirection.IN));
				lfg1Child1.getSecondaryLabels().add(new LabelNode("<internal>"));
				PreferredPosition.set(lfg1Child1, new Point2D(0, 20));
				lfg1.getNestedChildren().add(lfg1Child1);

				final DockedShape lfg1Child2 = createDockedShape("lfg1Child2",
						new PortNode(false, true, FeatureDirection.OUT));
				PreferredPosition.set(lfg1Child2, new Point2D(0, 50));
				lfg1.getNestedChildren().add(lfg1Child2);

				// Nested feature groups
				final DockedShape nestedFg = createDockedShape("nestedFg", new FeatureGroupNode());
				lfg1.getNestedChildren().add(nestedFg);
				nestedFg.getNestedChildren()
						.add(createDockedShape("c1", new PortNode(false, true, FeatureDirection.IN_OUT)));
				nestedFg.getNestedChildren()
						.add(createDockedShape("c2", new PortNode(false, true, FeatureDirection.IN)));

				//
				// Right Features
				//
				final DockedShape rf1 = createDockedShape("rf1", new PortNode(false, true, FeatureDirection.OUT));
				rf1.getSecondaryLabels().add(new LabelNode("<internal>"));
				top1.getRightChildren().add(rf1);
				PreferredPosition.set(rf1, new Point2D(0, 230));

				final DockedShape rf2 = createDockedShape("rf2", new PortNode(false, true, FeatureDirection.OUT));
				top1.getRightChildren().add(rf2);

				//
				// Create Free Children
				//
				// mode
				final ContainerShape mode1 = new ContainerShape();
				final ModeNode mode1Graphic = new ModeNode();
				mode1Graphic.setInitialMode(true);
				mode1.setGraphic(mode1Graphic);
				mode1.getPrimaryLabels().setAll(new LabelNode("m1"));
				mode1.getSecondaryLabels().setAll(new LabelNode("<initial>"));
				PreferredPosition.set(mode1, new Point2D(400, 200));
				top1.getFreeChildren().add(mode1);

				// subcomponent
				final ContainerShape sc1 = new ContainerShape();
				sc1.setHorizontalLabelPosition(LabelPosition.CENTER);
				sc1.setVerticalLabelPosition(LabelPosition.BEGINNING);
				sc1.setGraphic(new DeviceNode());
				sc1.getPrimaryLabels().setAll(new LabelNode("sys1"));
				top1.getFreeChildren().add(sc1);
				PreferredPosition.set(sc1, new Point2D(200, 300));
				sc1.setConfiguredWidth(310);
				sc1.setConfiguredHeight(100);

				final DockedShape sys1In1 = createDockedShape("in1",
						new PortNode(true, true, FeatureDirection.IN));
				sc1.getLeftChildren().add(sys1In1);

				final DockedShape sys1In2 = createDockedShape("in2", new PortNode(true, true, FeatureDirection.IN));
				sc1.getLeftChildren().add(sys1In2);

				final DockedShape sys1Out1 = createDockedShape("out1",
						new PortNode(false, true, FeatureDirection.OUT));
				sc1.getRightChildren().add(sys1Out1);

				//
				// Connections
				//
				// Flow Indicator
				final FlowIndicatorNode fsnk1 = new FlowIndicatorNode();
				fsnk1.getPrimaryLabels().setAll(new LabelNode("fsnk1"));
				fsnk1.setStartDecoration(new PolygonNode(new Dimension2D(20.0, 12.0), 1.0, 1.0, 0.0, 0.5, 1.0, 0.0));
				fsnk1.setEndDecoration(new PolylineNode(new Dimension2D(0.0, 16.0), 0.0, 0.0, 0.0, 1.0));
				PreferredPosition.set(fsnk1, new Point2D(80.0, 30.0));
				fsnk1.setStartAnchor(sys1In1.getInteriorAnchor());
				sc1.getFreeChildren().add(fsnk1);

				// Connection
				final ConnectionNode c1 = new ConnectionNode();
				c1.setStartAnchor(sys1In2.getExteriorAnchor());
				c1.setEndAnchor(lfg1Child1.getInteriorAnchor());
				c1.getPrimaryLabels().setAll(new LabelNode("c1"));
				c1.getMidpointDecorations().setAll(
						new PolygonNode(new Dimension2D(20.0, 12.0), 1.0, 1.0, 0.0, 0.5, 1.0, 0.0),
						new PolygonNode(new Dimension2D(10.0, 12.0), 1.0, 1.0, 0.0, 0.5, 1.0, 0.0));
				c1.setStartDecoration(new PolygonNode(new Dimension2D(8.0, 12.0), 1.0, 1.0, 0.0, 0.5, 1.0, 0.0));
				c1.setEndDecoration(new PolygonNode(new Dimension2D(20.0, 10.0), 1.0, 1.0, 0.0, 0.5, 1.0, 0.0));
				root.getChildren().add(c1);

				final ConnectionNode fp1 = new ConnectionNode();
				fp1.getPrimaryLabels().setAll(new LabelNode("fp1"));
				fp1.getSecondaryLabels().setAll(new LabelNode("Latency := 30ms>"));
				fp1.setStartAnchor(sys1In2.getInteriorAnchor());
				fp1.setEndAnchor(sys1Out1.getInteriorAnchor());
				fp1.getInnerConnection()
						.setControlPoints(ImmutableList.of(new org.eclipse.gef.geometry.planar.Point(350, 380),
						new org.eclipse.gef.geometry.planar.Point(350, 330)));
				root.getChildren().add(fp1);

				final ConnectionNode c2 = new ConnectionNode();
				c2.setStartAnchor(sys1Out1.getExteriorAnchor());
				c2.setEndAnchor(rf2.getInteriorAnchor());
				root.getChildren().add(c2);

				final BaseConnectionNode c3 = new ConnectionNode();
				c3.setStartAnchor(mode1.getAnchor());
				c3.setEndAnchor(c2.getMidpointAnchor());
				root.getChildren().add(c3);

				mode1.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
					System.err.println("MODE1 clicked");
					PreferredPosition.set(mode1, new Point2D(300, 200));
					event.consume();

				});

				final InfiniteCanvas canvas = new InfiniteCanvas();
				canvas.getContentGroup().getChildren().add(root);

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
				final Font f1 = Font.font("Arial", FontWeight.NORMAL, 14.0);
				final FxStyle s1 = new FxStyle.Builder().primaryLabelsVisible(true).font(f1).image(testImage).build();
				final FxStyle s2 = new FxStyle.Builder().outlineColor(Color.BLUE).primaryLabelsVisible(true)
						.lineWidth(4).build();
				StyleRoot.set(top1, true);
				StyleRoot.set(mode1, true);
				StyleRoot.set(sc1, true);
				FxStyleApplier.applyStyle(mode1, s2);
				FxStyleApplier.applyStyle(sc1, s2);
				FxStyleApplier.applyStyle(top1, s1);

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
