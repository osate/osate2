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

import org.eclipse.gef.fx.nodes.Connection;
import org.eclipse.gef.fx.nodes.GeometryNode;
import org.eclipse.gef.fx.nodes.InfiniteCanvas;
import org.osate.ge.gef.graphics.BusNode;
import org.osate.ge.gef.graphics.DataPortNode;
import org.osate.ge.gef.graphics.FeatureGroupNode;
import org.osate.ge.gef.graphics.NodeApplication;
import org.osate.ge.gef.graphics.RectangleNode;
import org.osate.ge.gef.layout.ContainerShape.LabelPosition;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

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
			final Label label1 = new Label("Top Node");
			final Label label2 = new Label("Longer single-line label. This should be truncated if there isn't space.");
			final Label label3 = new Label(
					"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
			label3.setWrapText(true);
			top.getLabels().setAll(label1, label2, label3);

			//
			// Create Free Children
			//
			final ContainerShape freeChild1 = new ContainerShape();
			freeChild1.getGraphics().setAll(new BusNode());
			freeChild1.getLabels().setAll(new Label("Child Node #1"));
			PreferredPosition.set(freeChild1, new Point2D(200, 300));
			top.getFreeChildren().add(freeChild1);

			// TODO: Set position. Set an explicit preferred size
			final ContainerShape freeChild2 = new ContainerShape();
			freeChild2.setHorizontalLabelPosition(LabelPosition.CENTER);
			freeChild2.setVerticalLabelPosition(LabelPosition.BEGINNING);
			freeChild2.getGraphics().setAll(new RectangleNode());
			freeChild2.getLabels().setAll(new Label("Child Node #2"));
			top.getFreeChildren().add(freeChild2);
			PreferredPosition.set(freeChild2, new Point2D(100, 400));

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
			PreferredPosition.set(fg, new Point2D(0, 50));

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

			//
			// Connections
			//
			// TODO: Decide what to add connections to. Could replace top with an infinite canvas but then resizing
			// of the top node wouldn't be demonstrated. Could do that another way?
			// TODO: Add connections to docked and undocked.

			// TODO: Instead of being a group, should be its own type of node to ensure consistent behavior?
			final Connection c1 = new Connection();
			final GeometryNode<?> cgn1 = (GeometryNode<?>) c1.getCurve();
			cgn1.setStrokeWidth(2.0);
			cgn1.setClickableAreaWidth(10.0);
			c1.setStartAnchor(fgChild1.getInteriorAnchor());
			c1.setEndAnchor(freeChild2Port1.getExteriorAnchor());

			final Connection c2 = new Connection();
			final GeometryNode<?> cgn2 = (GeometryNode<?>) c1.getCurve();
			cgn2.setStrokeWidth(2.0);
			cgn2.setClickableAreaWidth(10.0);
			c2.setStartAnchor(freeChild1.getAnchor());
			c2.setEndAnchor(nestedFg.getInteriorAnchor());

			//
			// TODO: Integrate with a connection object that will support layout, etc
			//

//			final Group cg1 = new Group();
//			cg1.getChildren().add(connection);
//			final Label connectionLabel = new Label("connection #1");
//			cg1.getChildren().add(connectionLabel);
//			connection.getChildren().add(new Label("test 2"));
//			connection.pointsUnmodifiableProperty()
//					.addListener((ChangeListener<ObservableList<org.eclipse.gef.geometry.planar.Point>>) (observable,
//							oldValue, newValue) -> {
//				System.err.println("ZZZZ");
//			});
//
//			c1.pointsUnmodifiableProperty().addListener((InvalidationListener) observable -> {
//				// TODO Auto-generated method stub
//				System.err.println("BBBDDD");
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
				PreferredPosition.set(freeChild2, new Point2D(200, 400));

				// TODO: Move Feature group
				PreferredPosition.set(fg, new Point2D(0, 200));

				// TODO: Move feature
				PreferredPosition.set(fgChild1, new Point2D(0, 100));

				// TODO: Resize container
			});

			final InfiniteCanvas canvas = new InfiniteCanvas();
			canvas.getContentGroup().getChildren().add(top);
			canvas.getContentGroup().getChildren().add(c1);
			canvas.getContentGroup().getChildren().add(c2);

			// Resize the top node to match the size of the canvas
			canvas.boundsInLocalProperty().addListener((ChangeListener<Bounds>) (observable, oldValue, newValue) -> {
				top.setConfiguredWidth(newValue.getWidth());
				top.setConfiguredHeight(newValue.getHeight());
			});

			return canvas;
		});
	}

	private static DockedShape createDockedShape(final String label, final Node graphic) {
		final DockedShape newNode = new DockedShape();
		newNode.getLabels().setAll(new Label(label));
		newNode.setGraphic(graphic);
		return newNode;
	}
}
