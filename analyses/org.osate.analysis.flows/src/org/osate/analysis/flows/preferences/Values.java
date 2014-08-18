package org.osate.analysis.flows.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.osate.analysis.flows.FlowanalysisPlugin;
import org.osate.analysis.flows.preferences.Constants.PartitioningPolicy;

public class Values {
	public static PartitioningPolicy getPartitioningPolicy() {
		IPreferenceStore store = FlowanalysisPlugin.getDefault().getPreferenceStore();
		String policy = store.getString(Constants.PARTITONING_POLICY);

		if (policy.equalsIgnoreCase(Constants.PARTITIONING_POLICY_IMMEDIATE_STR)) {
			return Constants.PartitioningPolicy.IMMEDIATE;
		}
		return Constants.PartitioningPolicy.DELAYED;
	}
}
