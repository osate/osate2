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
package org.osate.aadl2.errormodel.FaultTree.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osate.core.OsateCorePlugin;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

/**
 * @since 5.0
 */
public class FaultTreeModel {
	public static final String PREFS_QUALIFIER = "org.osate.aadl2.errormodel.faulttree";
	public static final String PREF_PRECISION = "org.osate.aadl2.errormodel.faulttree.precision";
	public static final String PREF_PRECISION_USE_WORKSPACE = "org.osate.aadl2.errormodel.faulttree.precision_use_workspace";

	// Methods
	public static final boolean getWorkspacePref(IProject project) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);
		return prefs.getBoolean(FaultTreeModel.PREF_PRECISION_USE_WORKSPACE, true);
	}

	public static final int getPrecision() {
		final IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		return store.getInt(PREF_PRECISION);
	}

	public static final int getPrecision(final IProject project) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);

		int precision = -1;
		if (!prefs.getBoolean(PREF_PRECISION_USE_WORKSPACE, true)) {
			precision = prefs.getInt(PREF_PRECISION, -1);
		}
		// It's possible the above may have failed for some reason, in which case we revert to the workspace preferences
		if (precision == -1) {
			precision = getPrecision();
		}

		if (precision < 1) {
			precision = 1; // use default setting
		}

		return precision;
	}

	public static final void setPrecision(int value, IProject project) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);
		if (!prefs.getBoolean(PREF_PRECISION_USE_WORKSPACE, true)) {
			prefs.putInt(PREF_PRECISION, value);
			try {
				prefs.flush();
			} catch (BackingStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static final void setPrecision(int value) {
		final IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		store.setValue(PREF_PRECISION, value);
	}

	public static final void setWorkspacePref(boolean useWorkspace, IProject project) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);
		prefs.putBoolean(FaultTreeModel.PREF_PRECISION_USE_WORKSPACE, useWorkspace);
	}
}