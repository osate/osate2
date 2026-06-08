/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.swt;

import java.util.function.Consumer;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Widget;

/**
 * Contains static utility functions including.
 * @since 1.1
  */
public final class SwtUtil {
	private static final String AUTOMATED_SWTBOT_TESTING_KEY = "org.eclipse.swtbot.widget.key";

	private SwtUtil() {
	}

	/**
	 * Sets up the display, creates a shell, and provides the specified consumer with it. Exits when the shell is disposed.
	 * @param run is the consumer to call after setting up the window.
	 */
	public static void run(final Consumer<Shell> run) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setText("View Test");
		shell.setSize(640, 480);
		shell.setLayout(new FillLayout());

		run.accept(shell);

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	/**
	 * Creates a display and runs the specified runnable. Useful for testing dialogs.
	 * @param runnable is the runnable to call after creating the display.
	 */
	public static void runDialog(final Runnable runnable) {
		final Display display = new Display();
		runnable.run();
		display.dispose();
	}

	/**
	 * Sets the visibility of a control and the exclude field of its layout data. Throws exception if layout data is not a GridData
	 * @param c the control for which to set visibility and exclusion.
	 * @param visible the new value for control visibility.
	 */
	public static void setVisibilityAndExclusion(final Control c, final boolean visible) {
		c.setVisible(visible);

		final Object layoutData = c.getLayoutData();
		if (layoutData == null) {
			throw new IllegalArgumentException("Specified control has invalid layout data. Layout data is null");
		} else if (layoutData instanceof GridData) {
			((GridData) layoutData).exclude = !visible;
		} else {
			throw new IllegalArgumentException(
					"Specified control has unsupported layout data type: " + layoutData.getClass().getName());
		}
	}

	/**
	 * Sets the background and foreground color of a control to that of its parent.
	 * @param c the control of which to update the background and foreground colors
	 */
	public static void setColorsToMatchParent(final Control c) {
		c.setBackground(c.getParent().getBackground());
		c.setForeground(c.getParent().getForeground());
	}

	/**
	 * Assigns an identifier to a widget to allow identification during automated testing.
	 * @param widget is the widget for which to test the id.
	 * @param value is the id to assign.
	 */
	public static void setTestingId(final Widget widget, final String value) {
		widget.setData(SwtUtil.AUTOMATED_SWTBOT_TESTING_KEY, value);
	}

	/**
	 * Returns the value of the id assigned to the widget for allow identification during automated testing
	 * @param widget is the widget for which to return the id.
	 * @return the id for the widget or null if one has not been assigned.
	 */
	public static String getTestingId(final Widget widget) {
		final Object value = widget.getData(SwtUtil.AUTOMATED_SWTBOT_TESTING_KEY);
		return value == null ? null : value.toString();
	}
}
