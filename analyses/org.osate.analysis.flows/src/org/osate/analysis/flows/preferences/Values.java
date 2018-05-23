package org.osate.analysis.flows.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.osate.analysis.flows.FlowanalysisPlugin;

public class Values {
	public static boolean doSynchronousSystem() {
		IPreferenceStore store = FlowanalysisPlugin.getDefault().getPreferenceStore();
		String policy = store.getString(Constants.SYNCHRONOUS_SYSTEM);
		return policy.equalsIgnoreCase(Constants.SYNCHRONOUS_SYSTEM_YES);
	}

	public static boolean doMajorFrameDelay() {
		IPreferenceStore store = FlowanalysisPlugin.getDefault().getPreferenceStore();
		String policy = store.getString(Constants.PARTITONING_POLICY);
		return policy.equalsIgnoreCase(Constants.PARTITIONING_POLICY_MAJOR_FRAME_DELAYED_STR);
	}

	public static boolean doWorstCaseDeadline() {
		IPreferenceStore store = FlowanalysisPlugin.getDefault().getPreferenceStore();
		String policy = store.getString(Constants.WORST_CASE_DEADLINE);
		return policy.equalsIgnoreCase(Constants.WORST_CASE_DEADLINE_YES);
	}

	public static boolean doBestcaseEmptyQueue() {
		IPreferenceStore store = FlowanalysisPlugin.getDefault().getPreferenceStore();
		String policy = store.getString(Constants.BESTCASE_EMPTY_QUEUE);
		return policy.equalsIgnoreCase(Constants.BESTCASE_EMPTY_QUEUE_YES);
	}

}
