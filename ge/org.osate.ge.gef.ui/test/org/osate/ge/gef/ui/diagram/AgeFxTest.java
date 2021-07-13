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
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.gef.fx.anchors.StaticAnchor;
import org.osate.ge.gef.ConnectionNode;
import org.osate.ge.gef.ContainerShape;
import org.osate.ge.gef.EllipseNode;
import org.osate.ge.gef.FlowIndicatorNode;
import org.osate.ge.gef.FxStyle;
import org.osate.ge.gef.FxStyleApplier;
import org.osate.ge.gef.ImageManager;
import org.osate.ge.gef.LabelNode;
import org.osate.ge.graphics.ArrowBuilder;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.EllipseBuilder;
import org.osate.ge.graphics.FlowIndicatorBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.LabelBuilder;
import org.osate.ge.graphics.LineStyle;
import org.osate.ge.graphics.Point;
import org.osate.ge.graphics.PolyBuilder;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.graphics.internal.BusGraphicBuilder;
import org.osate.ge.graphics.internal.DeviceGraphicBuilder;
import org.osate.ge.graphics.internal.FeatureGraphicBuilder;
import org.osate.ge.graphics.internal.FeatureGroupTypeGraphicBuilder;
import org.osate.ge.graphics.internal.FolderGraphicBuilder;
import org.osate.ge.graphics.internal.MemoryGraphicBuilder;
import org.osate.ge.graphics.internal.ModeGraphicBuilder;
import org.osate.ge.graphics.internal.NoteGraphicBuilder;
import org.osate.ge.graphics.internal.OrthogonalLineBuilder;
import org.osate.ge.graphics.internal.ParallelogramBuilder;
import org.osate.ge.graphics.internal.ProcessorGraphicBuilder;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Interactive test application that creates JavaFX nodes and apply a style based on the types used in the public
 * graphical editor API.
 */
public class AgeFxTest extends Application {
	private final StyleToFx styleToFx = new StyleToFx(new ImageManager());
	private Style baseStyle;
	private boolean dashed = false;
	private GridPane container;

	public static void main(final String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(final Stage primaryStage) throws Exception {
		container = new GridPane();
		container.setHgap(10.0);
		container.setVgap(10.0);
		container.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

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
				ModeGraphicBuilder.create().initialMode().build(), NoteGraphicBuilder.create().build(),
				LabelBuilder.create().build(),
				FeatureGraphicBuilder.create().abstractFeature().bidirectional().build(),
				FeatureGraphicBuilder.create().abstractFeature().input().build(),
				FeatureGraphicBuilder.create().abstractFeature().output().build(),
				FeatureGraphicBuilder.create().eventPort().bidirectional().build(),
				FeatureGraphicBuilder.create().eventPort().input().build(),
				FeatureGraphicBuilder.create().eventPort().output().build(),
				FeatureGraphicBuilder.create().dataPort().bidirectional().build(),
				FeatureGraphicBuilder.create().dataPort().input().build(),
				FeatureGraphicBuilder.create().dataPort().output().build(),
				FeatureGraphicBuilder.create().eventDataPort().bidirectional().build(),
				FeatureGraphicBuilder.create().eventDataPort().input().build(),
				FeatureGraphicBuilder.create().eventDataPort().output().build(),
				FeatureGraphicBuilder.create().subprogramAccess().input().build(),
				FeatureGraphicBuilder.create().subprogramAccess().output().build(),
				FeatureGraphicBuilder.create().subprogramGroupAccess().input().build(),
				FeatureGraphicBuilder.create().subprogramGroupAccess().output().build(),
				FeatureGraphicBuilder.create().dataAccess().input().build(),
				FeatureGraphicBuilder.create().dataAccess().output().build(),
				FeatureGraphicBuilder.create().featureGroup().build(),
				ConnectionBuilder.create().build(),
				ConnectionBuilder.create().sourceTerminator(OrthogonalLineBuilder.create().build()).build(),
				ConnectionBuilder.create().sourceTerminator(ArrowBuilder.create().filled().build())
						.destinationTerminator(ArrowBuilder.create().filled().small().build()).build(),
				ConnectionBuilder.create()
						.destinationTerminator(ArrowBuilder.create().line().build()).build(),
				FlowIndicatorBuilder.create().build(),
				FlowIndicatorBuilder.create().sourceTerminator(ArrowBuilder.create().small().reverse().build())
						.destinationTerminator(OrthogonalLineBuilder.create().build()).build() };

		final List<Node> nodes = Arrays.stream(graphics).map(GraphicToFx::createNode).collect(Collectors.toList());

		// Create a container shape. This is useful for ensuring image in style is applied,.
		final ContainerShape cs = new ContainerShape();
		cs.setGraphic(new EllipseNode());
		nodes.add(cs);

		final CheckBox dashedCheckBox = new CheckBox("Dashed");
		nodes.add(dashedCheckBox);
		dashedCheckBox.selectedProperty().addListener((ChangeListener<Boolean>) (observable, oldValue, newValue) -> {
			dashed = newValue;
			refreshStyle();
		});

		// Finish additional configuraton for labels and connections
		for (final Node n : nodes) {
			if (n instanceof LabelNode) {
				((LabelNode) n).setText("This is a test");
			} else if (n instanceof ConnectionNode) {
				final ConnectionNode cn = (ConnectionNode) n;
				final StaticAnchor start = new StaticAnchor(new org.eclipse.gef.geometry.planar.Point(0, 5));
				final StaticAnchor end = new StaticAnchor(new org.eclipse.gef.geometry.planar.Point(100, 5));
				cn.setStartAnchor(start);
				cn.setEndAnchor(end);
			} else if (n instanceof FlowIndicatorNode) {
				final FlowIndicatorNode fi = (FlowIndicatorNode) n;
				final StaticAnchor startAnchor = new StaticAnchor(new org.eclipse.gef.geometry.planar.Point(0, 5));
				fi.setTranslateX(100.0);
				fi.setTranslateY(5.0);
				fi.setStartAnchor(startAnchor);
			}
		}

		final List<String> args = getParameters().getRaw();
		final IPath imagePath = args.size() > 0 ? new Path(args.get(0)) : null;
		baseStyle = StyleBuilder.create(Style.DEFAULT).fontSize(20.0)
				.outlineColor(org.osate.ge.graphics.Color.BLUE).backgroundColor(org.osate.ge.graphics.Color.CYAN)
				.imagePath(imagePath).build();

		// Add Nodes and Assign them to Rows and Columns
		final int numberOfColumns = 4;
		int row = 0, col = -1;
		for (final Node node : nodes) {
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
			RowConstraints rc = new RowConstraints(20, 20, Double.MAX_VALUE);
			rc.setVgrow(Priority.SOMETIMES);
			container.getRowConstraints().add(rc);
		}

		// Style the nodes
		refreshStyle();

		primaryStage.setScene(new Scene(container));

		// Setup the stage
		primaryStage.setResizable(true);
		primaryStage.setWidth(1920);
		primaryStage.setHeight(1080);
		primaryStage.setTitle("GEF Graphics");
		primaryStage.show();
	}

	private void refreshStyle() {
		final Style style = StyleBuilder.create(baseStyle).lineStyle(dashed ? LineStyle.DASHED : LineStyle.SOLID)
				.build();
		final FxStyle fxStyle = styleToFx.createStyle(style);
		for (final Node node : container.getChildrenUnmodifiable()) {
			FxStyleApplier.applyStyle(node, fxStyle);
		}
	}
}
