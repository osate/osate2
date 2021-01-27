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
package org.osate.ui.utils;

import org.eclipse.jface.preference.IPreferenceStore;
import org.osate.core.OsateCorePlugin;

/**
 * @since 6.0
 */
public class PropertySetModel {
	public static final String separator = "&~!";
	public static final String PREFS_ALL_NAMES = "org.osate.ui.internal.propertysetnames";
	public static final String PREFS_QUALIFIER = "org.osate.ui.internal.propertyset";

	public static final boolean getPreference(String propertySetName) {
		final IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		return store.getBoolean(PREFS_QUALIFIER + " " + propertySetName);
	}

	/*
	 * Preferences are meant to store the property sets that need to be ignored
	 * If preference set to true, ignore the property set
	 * If preference set to false, property set should be used
	 */
	public static final void setPreference(boolean value, String propertySetName) {
		final IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		store.setValue(PREFS_QUALIFIER + " " + propertySetName, value);

		// since the property set name is typed in by the user, record the name with known key
		// for preference store, so we can retrieve the added preferences as needed
		String currentValue = store.getString(PREFS_ALL_NAMES);
		if (currentValue == null || currentValue.isEmpty()) {
			store.setValue(PREFS_ALL_NAMES, propertySetName);
		} else {
			store.setValue(PREFS_ALL_NAMES, currentValue + separator + propertySetName);
		}
	}

	public static final String[] getAllAddedPropertySetNames() {
		String[] result = null;

		final IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		String allNames = store.getString(PREFS_ALL_NAMES);
		if (allNames != null && !allNames.isEmpty()) {
			result = allNames.split(separator);
		}

		return result;
	}
}