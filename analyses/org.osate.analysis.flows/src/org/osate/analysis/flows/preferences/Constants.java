package org.osate.analysis.flows.preferences;

public class Constants {
	public static String PARTITONING_POLICY = "org.osate.analysis.flows.partitioning_policy";

	public static String PARTITIONING_POLICY_MAJOR_FRAME_DELAYED_STR = "delayed";
	public static String PARTITIONING_POLICY_IMMEDIATE_STR = "immediate";

	public enum PartitioningPolicy {
		IMMEDIATE, DELAYED
	};

	public static String REPORT_SUBTOTALS = "org.osate.analysis.flows.report_subtotals";

	public static String REPORT_SUBTOTALS_YES = "yes";
	public static String REPORT_SUBTOTALS_NO = "no";

	public enum ReportSubtotals {
		YES, NO
	};
}
