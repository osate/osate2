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
package org.osate.ge.swt.util;

import org.eclipse.swt.widgets.Widget;

/**
 * Contains functions for putting together tests to interactively test single components outside the Eclipse workbench.
 *
 */
public final class SwtTestUtil {
	private static String AUTOMATED_SWTBOT_TESTING_KEY = "org.eclipse.swtbot.widget.key";

	private SwtTestUtil() {
	}

	/**
	 * Assigns an identifier to a widget to allow identification during automated testing.
	 * @param widget is the widget for which to test the id.
	 * @param value is the id to assign.
	 */
	public static void setTestingId(final Widget widget, final String value) {
		widget.setData(AUTOMATED_SWTBOT_TESTING_KEY, value);
	}

	/**
	 * Returns the value of the id assigned to the widget for allow identification during automated testing
	 * @param widget is the widget for which to return the id.
	 * @return the id for the widget or null if one has not been assigned.
	 */
	public static String getTestingId(final Widget widget) {
		final Object value = widget.getData(AUTOMATED_SWTBOT_TESTING_KEY);
		return value == null ? null : value.toString();
	}
}
