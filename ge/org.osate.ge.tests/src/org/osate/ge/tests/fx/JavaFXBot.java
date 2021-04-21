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

import java.awt.AWTException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.eclipse.gef.fx.nodes.Connection;
import org.eclipse.gef.geometry.planar.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.osate.ge.gef.BaseConnectionNode;
import org.osate.ge.tests.endToEnd.util.UiTestUtil;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;

/**
 * Robot class for working with JavaFX nodes. Currently uses the AWT Robot class. The JavaFX Robot class is not available
 * in JavaFX 8.
 */
public class JavaFXBot {
	private java.awt.Robot robot;

	public JavaFXBot() {
		try {
			robot = new java.awt.Robot();
		} catch (AWTException ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * Clicks a scene graph node.
	 * If the node is contained in a {@link ScrollPane}, this function will scroll the pane so that it is visible.
	 * @param node the node to click.
	 */
	public void click(final Node node) {
		UiTestUtil.waitUntil(() -> UIThreadRunnable.syncExec(() -> isVisible(node)),
				"Node " + node + " is not visible");

		Display.getDefault().syncExec(() -> ensureVisible(node));

		final Point2D p = UIThreadRunnable.syncExec(() -> {
			if (node instanceof BaseConnectionNode) {
				final BaseConnectionNode cn = (BaseConnectionNode) node;
				final Connection ic = cn.getInnerConnection();
				final Point startPoint = ic.getStartPoint();
				return ic.localToScreen(startPoint.x, startPoint.y);
			} else {
				return node.localToScreen(4, 4);
			}
		});

		robot.mouseMove((int) p.getX(), (int) p.getY());
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}

	/**
	 * Generate key press and release events for the specified text. Underscores and other alpha-numeric characters are
	 * not supported and may cause an exception to be thrown. Such characters could be supported by generating a
	 * combination of keys but the implementation would depend on a particular keyboard layout.
	 * @param value the text to type.
	 */
	public void type(final String value) {
		for (char ch : value.toCharArray()) {
			final boolean isUpper = Character.isUpperCase(ch);
			if (isUpper) {
				robot.keyPress(KeyEvent.VK_SHIFT);
			}

			pressAndReleaseKey(KeyEvent.getExtendedKeyCodeForChar(ch));

			if (isUpper) {
				robot.keyRelease(KeyEvent.VK_SHIFT);
			}
		}
	}

	/**
	 * Presses and then releases the key with the specified code.
	 * @param code the key code
	 */
	public void pressAndReleaseKey(final int code) {
		robot.keyPress(code);
		robot.keyRelease(code);
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
