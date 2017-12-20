package org.osate.analysis.flows.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.osate.analysis.flows.FlowanalysisPlugin;

public class Initializer extends AbstractPreferenceInitializer {

	/**
	 * Initialize defaults value for preferences of the plug-in
	 */
	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = FlowanalysisPlugin.getDefault().getPreferenceStore();

		store.setDefault(Constants.PARTITONING_POLICY, Constants.PARTITIONING_POLICY_MAJOR_FRAME_DELAYED_STR);
		store.setDefault(Constants.REPORT_SUBTOTALS, Constants.REPORT_SUBTOTALS_NO);
		store.setDefault(Constants.WORST_CASE_DEADLINE, Constants.WORST_CASE_DEADLINE_YES);
		store.setDefault(Constants.BESTCASE_EMPTY_QUEUE, Constants.BESTCASE_EMPTY_QUEUE_YES);
		store.setDefault(Constants.SYNCHRONOUS_SYSTEM, Constants.SYNCHRONOUS_SYSTEM_NO);

	}

}
