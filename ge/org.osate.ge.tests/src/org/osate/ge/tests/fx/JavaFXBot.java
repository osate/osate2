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

import org.eclipse.gef.fx.nodes.Connection;
import org.eclipse.gef.geometry.planar.Point;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.osate.ge.gef.BaseConnectionNode;
import org.osate.ge.tests.endToEnd.util.UiTestUtil;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;

// TODO: Rename and document
public class JavaFXBot {
	private java.awt.Robot robot;

	public JavaFXBot() {
		try {
			robot = new java.awt.Robot();
		} catch (AWTException ex) {
			throw new RuntimeException(ex);
		}
	}

	public void click(final Node node) {
		// TODO; Improve visibility check. Stage must be visible, clipping ,etc
		// TODO; Scroll if necessary
		// TODO; Scrolling could affect position

		UiTestUtil.waitUntil(() -> isVisible(node), "Node " + node + " is not visible");

		// TODO: Need to scroll things
		ensureVisible(node);

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

	// TODO: Document. only one level of scrolling supported..
	// TODO: Rename... ALready check if "visible"
	private static void ensureVisible(final Node node) {
		final ScrollPane sp = getFirstScrollPane(node);
		if (sp == null) {
			return;
		}

		final Node scrollPaneContent = sp.getContent();

		Point2D p = new Point2D(0, 0);
		for (Node t = node; t != null; t = t.getParent()) {
			if (t == scrollPaneContent) {
				// TODO: How to know if it is a X or Y scroll
				final Bounds contentBounds = scrollPaneContent.getBoundsInLocal();
				final double normalScrollX = p.getX() / contentBounds.getWidth(); // TODO; Rename
				final double normalScrollY = p.getY() / contentBounds.getHeight(); // TODO: Rename
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

	// TODO; Rename
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

		// TODO: Check viewport and clipping for each parent?

		return true;
	}
}
