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
		store.setDefault(Constants.DONT_SHOW_DIALOG, false);

		store.setDefault(Constants.PARTITONING_POLICY_LAST_USED, Constants.PARTITIONING_POLICY_MAJOR_FRAME_DELAYED_STR);
		store.setDefault(Constants.WORST_CASE_DEADLINE_LAST_USED, Constants.WORST_CASE_DEADLINE_YES);
		store.setDefault(Constants.BESTCASE_EMPTY_QUEUE_LAST_USED, Constants.BESTCASE_EMPTY_QUEUE_YES);
		store.setDefault(Constants.ASYNCHRONOUS_SYSTEM_LAST_USED, Constants.ASYNCHRONOUS_SYSTEM_YES);
	}
}
