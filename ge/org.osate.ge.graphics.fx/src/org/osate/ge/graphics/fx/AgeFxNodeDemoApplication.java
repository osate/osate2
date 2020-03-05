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
import java.util.List;
import java.util.stream.Collectors;

import org.osate.ge.fx.LabelNode;
import org.osate.ge.graphics.EllipseBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.LabelBuilder;
import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.PolyBuilder;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.graphics.internal.BusGraphicBuilder;
import org.osate.ge.graphics.internal.DeviceGraphicBuilder;
import org.osate.ge.graphics.internal.FeatureGroupTypeGraphicBuilder;
import org.osate.ge.graphics.internal.FolderGraphicBuilder;
import org.osate.ge.graphics.internal.MemoryGraphicBuilder;
import org.osate.ge.graphics.internal.ModeGraphicBuilder;
import org.osate.ge.graphics.internal.ParallelogramBuilder;
import org.osate.ge.graphics.internal.ProcessorGraphicBuilder;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AgeFxNodeDemoApplication extends Application {
	public static void main(final String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(final Stage primaryStage) throws Exception {
		final GridPane container = new GridPane();// VBox container = new VBox();
		container.setHgap(10.0);
		container.setVgap(10.0);
		container.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

		// TODO: Need with various style. Default and other. Columns?
		// TODO: Need polygon and polyline

		final Graphic[] graphics = new Graphic[] { RectangleBuilder.create().build(),
				RectangleBuilder.create().rounded().build(), EllipseBuilder.create().build(),
				FolderGraphicBuilder.create().build(), DeviceGraphicBuilder.create().build(),
				ParallelogramBuilder.create().horizontalOffset(20).build(), BusGraphicBuilder.create().build(),
				PolyBuilder.create().polygon().points(new Point(0.0, 1.0), new Point(1.0, 1.0), new Point(0.5, 0.0))
						.build(),
				PolyBuilder.create().polyline().points(new Point(0.0, 0.0), new Point(1.0, 0.5), new Point(0.0, 1.0))
						.build(),
				ProcessorGraphicBuilder.create().build(), MemoryGraphicBuilder.create().build(),
				FeatureGroupTypeGraphicBuilder.create().build(), ModeGraphicBuilder.create().build(),
				ModeGraphicBuilder.create().initialMode().build(), LabelBuilder.create().build() };

		final List<Node> nodes = Arrays.stream(graphics).map(AgeToFx::createNode).collect(Collectors.toList());

		// Set the text for label nodes
		for (final Node n : nodes) {
			if (n instanceof LabelNode) {
				((LabelNode) n).setText("This is a test");
			}
		}

		final Style style = StyleBuilder.create(Style.DEFAULT).fontSize(32.0)
				.outlineColor(org.osate.ge.graphics.Color.BLUE).backgroundColor(org.osate.ge.graphics.Color.CYAN)
				.build();

		// Add Nodes and Assign them to Rows and Columns
		final int numberOfColumns = 2;
		int row = 0, col = -1;
		for (final Node node : nodes) {
			AgeToFx.applyStyle(node, style); // TODO: Need to continually test without style.. Have option to disable?

			// Increment the row and column first so that the final values will be the indices of the last node
			col++;
			if (col > (numberOfColumns - 1)) {
				col = 0;
				row++;
			}

			container.add(node, col, row);
		}

		// Create Row and Column Constraints
		for (int i = 0; i < numberOfColumns; i++) {
			ColumnConstraints c = new ColumnConstraints(100, 100, Double.MAX_VALUE);
			c.setHgrow(Priority.SOMETIMES);
			container.getColumnConstraints().add(c);
		}

		for (int i = 0; i <= row; i++) {
			RowConstraints rc = new RowConstraints(100, 100, Double.MAX_VALUE);
			rc.setVgrow(Priority.SOMETIMES);
			container.getRowConstraints().add(rc);
		}

		primaryStage.setScene(new Scene(container));

		// Setup the stage
		primaryStage.setResizable(true);
		primaryStage.setWidth(640);
		primaryStage.setHeight(900);
		primaryStage.setTitle("GEF Graphics");
		primaryStage.show();
	}
}
