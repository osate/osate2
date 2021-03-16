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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.osate.core.OsateCorePlugin;

/**
 * @since 6.0
 */
public class PropertySetModel {
	public static final String separator = "&~!";
	public static final String PREFS_IGNORED_PROPERTY_SET_NAMES = "org.osate.ui.internal.propertysetnames";
	public static final String PREFS_SHOW_WARNING = "org.osate.ui.internal.propertysetnames.showWarning";

	// keep below for new page
	public static final void deletePropertySetFromIgnoredList(String propertySetNames) {
		List<String> ignored = getAllAddedPropertySetNames();
		ignored.remove(propertySetNames);

		final IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		store.setValue(PREFS_IGNORED_PROPERTY_SET_NAMES, String.join(separator, ignored));
	}

	public static final List<String> getAllAddedPropertySetNames() {
		String[] result = new String[] {};

		final IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		String allNames = store.getString(PREFS_IGNORED_PROPERTY_SET_NAMES);
		if (allNames != null && !allNames.isEmpty()) {
			result = allNames.split(separator);
		}

		List<String> unique_strings = new ArrayList<String>(new HashSet<String>(Arrays.asList(result)));
		Collections.sort(unique_strings);

		return unique_strings;
	}

	public static final Boolean getShowWarning() {
		final IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		return store.getBoolean(PREFS_SHOW_WARNING);
	}

	public static final void resetIgnoredPropertySetPreference() {
		final IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		store.setValue(PREFS_IGNORED_PROPERTY_SET_NAMES, "");
	}

	public static final void setIgnoredPropertySetPreference(String propertySetNames) {
		final IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();

		// since the property set name is typed in by the user, record the name with known key
		// for preference store, so we can retrieve the added preferences as needed
		String currentValue = store.getString(PREFS_IGNORED_PROPERTY_SET_NAMES);
		if (currentValue == null || currentValue.isEmpty()) {
			store.setValue(PREFS_IGNORED_PROPERTY_SET_NAMES, propertySetNames);
		} else {
			store.setValue(PREFS_IGNORED_PROPERTY_SET_NAMES, currentValue + separator + propertySetNames);
		}
	}

	public static final void setShowWarning(Boolean showWarning) {
		final IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		store.setValue(PREFS_SHOW_WARNING, showWarning);
	}
}