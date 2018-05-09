package org.osate.analysis.flows.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.osate.analysis.flows.FlowanalysisPlugin;

public class Values {

	private static String[] prefs;

	public static boolean doSynchronousSystem() {
		if (prefs != null && prefs.length > 0) {
			return prefs[0].equals("SS");
		}
		IPreferenceStore store = FlowanalysisPlugin.getDefault().getPreferenceStore();
		String policy = store.getString(Constants.SYNCHRONOUS_SYSTEM);
		return policy.equalsIgnoreCase(Constants.SYNCHRONOUS_SYSTEM_YES);
	}

	public static boolean doMajorFrameDelay() {
		if (prefs != null && prefs.length > 1) {
			return prefs[1].equals("MF");
		}
		IPreferenceStore store = FlowanalysisPlugin.getDefault().getPreferenceStore();
		String policy = store.getString(Constants.PARTITONING_POLICY);
		return policy.equalsIgnoreCase(Constants.PARTITIONING_POLICY_MAJOR_FRAME_DELAYED_STR);
	}

	public static boolean doWorstCaseDeadline() {
		if (prefs != null && prefs.length > 2) {
			return prefs[2].equals("DL");
		}
		IPreferenceStore store = FlowanalysisPlugin.getDefault().getPreferenceStore();
		String policy = store.getString(Constants.WORST_CASE_DEADLINE);
		return policy.equalsIgnoreCase(Constants.WORST_CASE_DEADLINE_YES);
	}

	public static boolean doBestcaseEmptyQueue() {
		if (prefs != null && prefs.length > 3) {
			return prefs[3].equals("EQ");
		}
		IPreferenceStore store = FlowanalysisPlugin.getDefault().getPreferenceStore();
		String policy = store.getString(Constants.BESTCASE_EMPTY_QUEUE);
		return policy.equalsIgnoreCase(Constants.BESTCASE_EMPTY_QUEUE_YES);
	}

	public static String getMajorFrameDelayLabel() {
		return Values.doMajorFrameDelay() ? "MF" : "PE";
	}

	public static String getMajorFrameDelayDescription() {
		return Values.doMajorFrameDelay() ? Constants.PARTITIONING_POLICY_MAJOR_FRAME_DELAYED_STR
				: Constants.PARTITIONING_POLICY_PARTITION_END_STR;
	}

	public static String getSynchronousSystemLabel() {
		return Values.doSynchronousSystem() ? "SS" : "AS";
	}

	public static String getSynchronousSystemDescription() {
		return Values.doSynchronousSystem() ? Constants.SYNCHRONOUS_SYSTEM_YES : Constants.SYNCHRONOUS_SYSTEM_NO;
	}

	public static String getWorstCaseDeadlineLabel() {
		return Values.doWorstCaseDeadline() ? "DL" : "ET";
	}

	public static String getWorstCaseDeadlineDescription() {
		return Values.doWorstCaseDeadline() ? Constants.WORST_CASE_DEADLINE_YES : Constants.WORST_CASE_DEADLINE_NO;
	}


	public static String getBestcaseEmptyQueueLabel() {
		return Values.doBestcaseEmptyQueue() ? "EQ" : "FQ";
	}

	public static String getBestcaseEmptyQueueDescription() {
		return Values.doBestcaseEmptyQueue() ? Constants.BESTCASE_EMPTY_QUEUE_YES : Constants.BESTCASE_EMPTY_QUEUE_NO;
	}

	public static void setPrefs(String[] prefs) {
		Values.prefs = prefs;
	}

}
