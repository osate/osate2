package org.osate.analysis.flows.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.osate.analysis.flows.FlowanalysisPlugin;

public class Values {

	public static boolean doMajorFrameDelay() {
		IPreferenceStore store = FlowanalysisPlugin.getDefault().getPreferenceStore();
		String policy = store.getString(Constants.PARTITONING_POLICY);
		return policy.equalsIgnoreCase(Constants.PARTITIONING_POLICY_MAJOR_FRAME_DELAYED_STR);
	}

	public static boolean doReportSubtotals() {
		IPreferenceStore store = FlowanalysisPlugin.getDefault().getPreferenceStore();
		String policy = store.getString(Constants.REPORT_SUBTOTALS);
		return policy.equalsIgnoreCase(Constants.REPORT_SUBTOTALS_YES);
	}

	public static boolean doWorstCaseDeadline() {
		IPreferenceStore store = FlowanalysisPlugin.getDefault().getPreferenceStore();
		String policy = store.getString(Constants.WORST_CASE_DEADLINE);
		return policy.equalsIgnoreCase(Constants.WORST_CASE_DEADLINE_YES);
	}

}
