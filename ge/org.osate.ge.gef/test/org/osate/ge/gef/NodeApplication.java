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

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Helper class intended for testing purposes.
 *
 */
public class NodeApplication extends Application {
	private static Supplier<Node[]> nodeSupplier;

	/**
	 * Runs the node application. The nodeSupplier is called in the application's start() method.
	 * @param nodeSupplier
	 */
	public static void runNodes(final Supplier<Node[]> nodeSupplier) {
		if (NodeApplication.nodeSupplier != null) {
			throw new RuntimeException("NodeApplication.run() may only be called once.");
		}

		NodeApplication.nodeSupplier = Objects.requireNonNull(nodeSupplier, "nodeSupplier  must not be null");
		Application.launch();
	}

	/**
	 * Runs the node application. The nodeSupplier is called in the application's start() method.
	 * @param nodeSupplier
	 */
	public static void run(final Supplier<Node> nodeSupplier) {
		runNodes(() -> new Node[] { nodeSupplier.get() });
	}

	@Override
	public void start(final Stage primaryStage) throws Exception {
		final VBox container = new VBox();
		container.setPadding(new Insets(10.0));
		container.setSpacing(10);

		final Node[] nodesToTest = nodeSupplier.get();
		for (final Node n : nodesToTest) {
			VBox.setVgrow(n, Priority.ALWAYS);
		}

		container.getChildren().setAll(nodesToTest);

		primaryStage.setScene(new Scene(container));

		// Setup the stage
		primaryStage.setResizable(true);
		primaryStage.setWidth(640);
		primaryStage.setHeight(640);
		primaryStage.setTitle(
				Arrays.stream(nodesToTest).map(n -> n.getClass().getSimpleName()).collect(Collectors.joining(" : ")));
		primaryStage.show();
	}
}
