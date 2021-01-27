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
package org.osate.annexsupport;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osate.aadl2.NamedElement;
import org.osate.core.OsateCorePlugin;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

/**
 * @since 3.1
 */
public class AnnexModel {
	public static final String PREFS_QUALIFIER = "org.osate.ui.internal.annex";
	public static final String PREF_ANNEX_USE_WORKSPACE = "org.osate.ui.internal.annex_use_workspace";

	// Methods
	public static final boolean getWorkspacePref(IProject project) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);
		return prefs.getBoolean(AnnexModel.PREF_ANNEX_USE_WORKSPACE, true);
	}

	public static final boolean getAnnex(String annexExtensionId) {
		final IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		return store.getBoolean(annexExtensionId.toLowerCase());
	}

	public static final boolean getAnnex(final IProject project, String annexExtensionId) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);

		Boolean annexTurnedOn = null;
		if (!prefs.getBoolean(PREF_ANNEX_USE_WORKSPACE, true)) {
			annexTurnedOn = prefs.getBoolean(annexExtensionId.toLowerCase(), true);
		}

		// It's possible the above may have failed for some reason, in which case we revert to the workspace preferences
		if (annexTurnedOn == null) {
			annexTurnedOn = getAnnex(annexExtensionId);
		}

		return annexTurnedOn;
	}

	public static final boolean getAnnexBasedOnWorkspacePreference(final IProject project, String annexExtensionId) {
		if (getWorkspacePref(project)) { // preferences set per workspace
			return getAnnex(annexExtensionId);
		}

		return getAnnex(project, annexExtensionId); // preference set per project
	}

	public static final void setAnnex(boolean value, IProject project, String annexExtensionId) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);
		if (!prefs.getBoolean(PREF_ANNEX_USE_WORKSPACE, true)) {
			prefs.putBoolean(annexExtensionId, value);
			try {
				prefs.flush();
			} catch (BackingStoreException e) {
				AnnexPlugin.logError(e);
			}
		}
	}

	public static final void setAnnex(boolean value, String annexExtensionId) {
		final IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		store.setValue(annexExtensionId, value);
	}

	public static final void setWorkspacePref(boolean useWorkspace, IProject project) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);
		prefs.putBoolean(AnnexModel.PREF_ANNEX_USE_WORKSPACE, useWorkspace);
	}

	public static <A extends NamedElement, D extends A> String filterDisabledAnnexes(
			D defaultAnnexSection,
			String annexName) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IFile file = root.getFile(new Path(defaultAnnexSection.eResource().getURI().toPlatformString(true)));
		IProject project = file.getProject();

		// check if this annex plugin is enabled in osate annex preferences
		if (org.osate.annexsupport.AnnexModel.getAnnexBasedOnWorkspacePreference(project, annexName)) {
			return annexName;
		}

		return "*";
	}
}