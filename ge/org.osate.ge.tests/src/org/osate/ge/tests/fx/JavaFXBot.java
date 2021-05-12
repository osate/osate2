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
package org.osate.ge.tests.fx;

import static org.junit.Assert.*;

import org.eclipse.gef.fx.nodes.Connection;
import org.eclipse.gef.geometry.planar.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.osate.ge.gef.BaseConnectionNode;
import org.osate.ge.tests.endToEnd.util.UiTestUtil;

import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.robot.Robot;

/**
 * Robot class for working with JavaFX nodes.
 */
public class JavaFXBot {
	private Robot robot;

	public JavaFXBot() {

	}

	private void ensureRobotCreated() {
		if (robot == null) {
			Platform.runLater(() -> {
				this.robot = new Robot();
			});
		}
	}


	/**
	 * Clicks a scene graph node.
	 * If the node is contained in a {@link ScrollPane}, this function will scroll the pane so that it is visible.
	 * @param node the node to click.
	 */
	public void click(final Node node) {
		ensureRobotCreated();
		UiTestUtil.waitUntil(() -> UIThreadRunnable.syncExec(() -> isVisible(node)),
				"Node " + node + " is not visible");

		Display.getDefault().syncExec(() -> {
			ensureVisible(node);

			final Point2D p;
			if (node instanceof BaseConnectionNode) {
				final BaseConnectionNode cn = (BaseConnectionNode) node;
				final Connection ic = cn.getInnerConnection();
				final Point startPoint = ic.getStartPoint();
				p = ic.localToScreen(startPoint.x, startPoint.y);
			} else {
				p = node.localToScreen(4, 4);
			}

			robot.mouseMove(p.getX(), p.getY());
			robot.mousePress(MouseButton.PRIMARY);
			robot.mouseRelease(MouseButton.PRIMARY);
		});
	}

	/**
	 * Generate key press and release events for the specified text. Underscores and other alpha-numeric characters are
	 * not supported and may cause an exception to be thrown. Such characters could be supported by generating a
	 * combination of keys but the implementation would depend on a particular keyboard layout.
	 * @param value the text to type.
	 */
	public void type(final String value) {
		ensureRobotCreated();
		for (char ch : value.toCharArray()) {
			type(ch);
		}
	}

	private void type(final char ch) {
		final KeyCode code;
		if (ch == '_') {
			code = KeyCode.UNDERSCORE;
		} else {
			final String codeName = Character.toString(Character.toUpperCase(ch));
			code = KeyCode.getKeyCode(codeName);
		}

		assertNotNull("code for character `" + ch + "` is null", code);
		final boolean isUpper = Character.isUpperCase(ch);
		Display.getDefault().syncExec(() -> {
			if (isUpper) {
				robot.keyPress(KeyCode.SHIFT);
			}

			robot.keyPress(code);
			robot.keyRelease(code);

			if (isUpper) {
				robot.keyRelease(KeyCode.SHIFT);
			}
		});
	}

	/**
	 * Presses and then releases the key with the specified code.
	 * @param code the key code
	 */
	public void pressAndReleaseKey(final KeyCode code) {
		ensureRobotCreated();
		Display.getDefault().syncExec(() -> {
			robot.keyPress(code);
			robot.keyRelease(code);
		});
	}

	private static void ensureVisible(final Node node) {
		final ScrollPane sp = getFirstScrollPane(node);
		if (sp == null) {
			return;
		}

		final Node scrollPaneContent = sp.getContent();

		Point2D p = new Point2D(0, 0);
		for (Node t = node; t != null; t = t.getParent()) {
			if (t == scrollPaneContent) {
				final Bounds contentBounds = scrollPaneContent.getBoundsInLocal();
				final Bounds spBounds = sp.getLayoutBounds();
				final double normalScrollX = Math.max(0,
						Math.min(1.0, p.getX() / (contentBounds.getWidth() - spBounds.getWidth())));
				final double normalScrollY = Math.max(0,
						Math.min(1.0, p.getY() / (contentBounds.getHeight() - spBounds.getHeight())));
				final double newScrollH = (sp.getHmax() - sp.getHmin()) * normalScrollX + sp.getHmin();
				final double newScrollV = (sp.getVmax() - sp.getVmin()) * normalScrollY + sp.getVmin();
				sp.setHvalue(newScrollH);
				sp.setVvalue(newScrollV);
				return;
			} else {
				p = t.localToParent(p);
			}
		}
	}

	private static ScrollPane getFirstScrollPane(final Node node) {
		for (Node t = node; t != null; t = t.getParent()) {
			if (t instanceof ScrollPane) {
				return (ScrollPane) t;
			}
		}
		return null;
	}

	private static boolean isVisible(final Node node) {
		for (Node t = node; t != null; t = t.getParent()) {
			if (!t.isVisible()) {
				return false;
			}
		}

		return true;
	}
}
