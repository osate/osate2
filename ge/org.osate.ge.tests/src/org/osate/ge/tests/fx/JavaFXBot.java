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

import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.osate.ge.tests.endToEnd.util.UiTestUtil;

import javafx.geometry.Point2D;
import javafx.scene.Node;

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

		UiTestUtil.waitUntil(() -> isVisible(node), "Node " + node + " is not visible");

		final Point2D p = UIThreadRunnable.syncExec(() -> {
			return node.localToScreen(0, 0);
		});

		robot.mouseMove((int) p.getX(), (int) p.getY());
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
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
