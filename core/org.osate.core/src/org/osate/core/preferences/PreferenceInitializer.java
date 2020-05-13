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
package org.osate.core.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osate.core.OsateCorePlugin;

/**
 * @author lwrage
 * @version $Id: PreferenceInitializer.java,v 1.9 2007-06-18 18:47:25 jseibel
 *          Exp $
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 *
	 * @seeorg.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#
	 * initializeDefaultPreferences()
	 */
	@Override
	public void initializeDefaultPreferences() {
		/**
		 * Sets the default values of the preferences.
		 */
		IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		store.setDefault(OsateCorePlugin.EXPAND_DEFAULT_FLAG, false);
		store.setDefault(OsateCorePlugin.MAX_SOM, OsateCorePlugin.MAX_SOM_DEFAULT);
		store.setDefault(OsateCorePlugin.AUTO_REINSTANTIATE, true);
		store.setDefault(OsateCorePlugin.AUTO_INDENT, true);
		store.setDefault(OsateCorePlugin.AUTO_COMPLETE, true);
		store.setDefault(OsateCorePlugin.CAPITALIZE, false);
		store.setDefault(OsateCorePlugin.INDENT_SECTIONS, true);
		store.setDefault(OsateCorePlugin.ALWAYS_SHOW_INSTANTIATION_AADL_DIALOG,
				OsateCorePlugin.ALWAYS_SHOW_INSTANTIATION_AADL_DIALOG_DEFAULT);
		store.setDefault(OsateCorePlugin.ONLY_INSTANTIATE_SYSTEM_IMPLS,
				OsateCorePlugin.ONLY_INSTANTIATE_SYSTEM_IMPLS_DEFAULT);
	}
}
