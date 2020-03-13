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
package org.osate.analysis.flows.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.analysis.flows.FlowanalysisPlugin;

public class Initializer extends AbstractPreferenceInitializer {

	/**
	 * Initialize defaults value for preferences of the plug-in.
	 *
	 * If this changes, {@link org.osate.analysis.flows.FlowLatencyAnalysisSwitch#invoke(SystemInstance, SystemOperationMode)}
	 * must also be changed for handling default settings.
	 */
	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = FlowanalysisPlugin.getDefault().getPreferenceStore();

		store.setDefault(Constants.PARTITONING_POLICY, Constants.PARTITIONING_POLICY_MAJOR_FRAME_DELAYED_STR);
		store.setDefault(Constants.WORST_CASE_DEADLINE, Constants.WORST_CASE_DEADLINE_YES);
		store.setDefault(Constants.BESTCASE_EMPTY_QUEUE, Constants.BESTCASE_EMPTY_QUEUE_YES);
		store.setDefault(Constants.ASYNCHRONOUS_SYSTEM, Constants.ASYNCHRONOUS_SYSTEM_YES);
		store.setDefault(Constants.DISABLE_QUEUING_LATENCY, Constants.DISABLE_QUEUING_LATENCY_NO);
		store.setDefault(Constants.DONT_SHOW_DIALOG, false);

		store.setDefault(Constants.PARTITONING_POLICY_LAST_USED, Constants.PARTITIONING_POLICY_MAJOR_FRAME_DELAYED_STR);
		store.setDefault(Constants.WORST_CASE_DEADLINE_LAST_USED, Constants.WORST_CASE_DEADLINE_YES);
		store.setDefault(Constants.BESTCASE_EMPTY_QUEUE_LAST_USED, Constants.BESTCASE_EMPTY_QUEUE_YES);
		store.setDefault(Constants.ASYNCHRONOUS_SYSTEM_LAST_USED, Constants.ASYNCHRONOUS_SYSTEM_YES);
		store.setDefault(Constants.DISABLE_QUEUING_LATENCY_LAST_USED, Constants.DISABLE_QUEUING_LATENCY_NO);
	}
}
