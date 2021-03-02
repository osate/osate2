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
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.NamedElement;
import org.osate.core.OsateCorePlugin;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

/**
 * @since 3.1
 */
public class AnnexModel {
	/*
	 * Handles preferences for annexes\plugins.
	 * Default: If no preference is set for specific annex name, then parses is used/turned on
	 * If preferences for specific annex name is set to true, then parser is used/turned on
	 * If preferences for specific annex name is set to false, then parser is NOT used/turned OFF
	 *
	 * Preferences are tracked per workspace and per project
	 */
	public static final Boolean DEFAULT_PREF_VALUE = true;
	public static final String PREFS_QUALIFIER = "org.osate.ui.internal.annex";
	public static final String PREF_ANNEX_USE_WORKSPACE = "org.osate.ui.internal.annex_use_workspace";

	private static enum UserSetting {
		USE_WORKSPACE_PREFERENCE, USE_PROJECT_PREFERENCE
	};

	// Methods
	/**
	 * User can choose to set preference per workspace or per project.
	 * The preference is stored in PREF_ANNEX_USE_WORKSPACE in project scope
	 *
	 * @param project that is being parsed
	 * @return True if workspace preference should be used OR if @param project is NULL; False if project preference should be used
	 */
	public static final UserSetting getUserPreference(IProject project) {
		if (project == null) {
			return UserSetting.USE_WORKSPACE_PREFERENCE; // if can not access project preferences, return use workspace preference = true
		}

		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);
		boolean useWorkspace = prefs.getBoolean(PREF_ANNEX_USE_WORKSPACE, DEFAULT_PREF_VALUE);

		return useWorkspace ? UserSetting.USE_WORKSPACE_PREFERENCE : UserSetting.USE_PROJECT_PREFERENCE;
	}

	/**
	 * Check if workspace preference is set to enabled for provided annex name
	 *
	 * @param annexExtensionId Annex name to check
	 * @return True if @param annexExtensionId is enabled per workspace preference
	 */
	public static final boolean getAnnexEnabled(String annexExtensionId) {
		final IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		if (store.contains(annexExtensionId.toLowerCase())) {
			return store.getBoolean(annexExtensionId.toLowerCase());
		}

		return DEFAULT_PREF_VALUE;
	}

	/**
	 * Check if project preference is set to enabled for provided annex name
	 *
	 * @param project that is being parsed
	 * @param annexExtensionId Annex name to check
	 * @return True if @param annexExtensionId is enabled per workspace preference
	 */
	public static final boolean getAnnexEnabled(final IProject project, String annexExtensionId) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);

		Boolean annexTurnedOn = null;
		if (!prefs.getBoolean(PREF_ANNEX_USE_WORKSPACE, DEFAULT_PREF_VALUE)) {
			annexTurnedOn = prefs.getBoolean(annexExtensionId.toLowerCase(), DEFAULT_PREF_VALUE);
		}

		// It's possible the above may have failed for some reason, in which case we revert to the workspace preferences
		if (annexTurnedOn == null) {
			annexTurnedOn = getAnnexEnabled(annexExtensionId);
		}

		return annexTurnedOn;
	}

	/**
	 * Check if this annex plugin is enabled in osate annex preferences
	 * This methods decides if workspace or project preference needs to be used
	 *
	 * @param project that is being parsed
	 * @param annexExtensionId annex name to check user preference for
	 * @return True if annex is enabled, False if annex is disabled
	 */

	public static final boolean isAnnexNameEnabled(final IProject project, String annexExtensionId) {
		if (getUserPreference(project).equals(UserSetting.USE_WORKSPACE_PREFERENCE)) {
			return getAnnexEnabled(annexExtensionId); // preferences set per workspace
		}

		return getAnnexEnabled(project, annexExtensionId); // preference set per project
	}

	/**
	 *
	 * @param enabled True if @param annexExtensionId is enabled in @param project; False if disabled
	 * @param project Project for which to set a setting for
	 * @param annexExtensionId Annex name to set a preference for
	 */
	public static final void setAnnexEnabled(boolean enabled, IProject project, String annexExtensionId) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);
		if (!prefs.getBoolean(PREF_ANNEX_USE_WORKSPACE, DEFAULT_PREF_VALUE)) {
			prefs.putBoolean(annexExtensionId.toLowerCase(), enabled);
			try {
				prefs.flush();
			} catch (BackingStoreException e) {
				AnnexPlugin.logError(e);
			}
		}
	}

	/**
	 *
	 * @param enabled True if @param annexExtensionId is enabled in workspace; False if disabled
	 * @param annexExtensionId Annex name to set a preference for
	 */
	public static final void setAnnexEnabled(boolean enabled, String annexExtensionId) {
		final IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		store.setValue(annexExtensionId.toLowerCase(), enabled);
	}

	/**
	 * Set PREF_ANNEX_USE_WORKSPACE setting that indicates if workspace OR project preferences should be used for @param project
	 *
	 * @param useWorkspace Set to True if Workspace preferences should be applied for this @param project; Set to False if project preferences are applied to this @param project
	 * @param project to which the setting is applied
	 */
	public static final void setWorkspacePref(boolean useWorkspace, IProject project) {
		final IScopeContext context = new ProjectScope(project);
		final Preferences prefs = context.getNode(PREFS_QUALIFIER);
		prefs.putBoolean(PREF_ANNEX_USE_WORKSPACE, useWorkspace);
	}

	/**
	 *
	 * @param <A> Type of the resulting annex section. Expected to be {@link AnnexLibrary} or {@link AnnexSubclause}.
	 * @param <D> Type of the default annex section. Expected to be {@link DefaultAnnexLibrary} or
	 *            {@link DefaultAnnexSubclause}.
	 * @param defaultAnnexSection Either the {@link DefaultAnnexLibrary} or {@link DefaultAnnexSubclause}
	 * @param annexName for which the check is done to see if it is enabled
	 * @return @param annexName if Annex is enabled; default annex name if @param annexName is disabled
	 */
	public static <A extends NamedElement, D extends A> String filterDisabledAnnexes(
			D defaultAnnexSection,
			String annexName) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = null;

		if (defaultAnnexSection.eResource() != null
				&& defaultAnnexSection.eResource().getURI().toPlatformString(true) != null) {
			IFile file = root.getFile(new Path(defaultAnnexSection.eResource().getURI().toPlatformString(true)));
			project = file.getProject();
		}
		// check if this annex plugin is enabled in osate annex preferences
		if (isAnnexNameEnabled(project, annexName)) {
			return annexName;
		}

		return "*";
	}
}