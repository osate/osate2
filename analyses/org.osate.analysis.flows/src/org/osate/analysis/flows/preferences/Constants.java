package org.osate.analysis.flows.preferences;

public class Constants {
	public static String PARTITONING_POLICY = "org.osate.analysis.flows.partitioning_policy";

	public static String PARTITIONING_POLICY_MAJOR_FRAME_DELAYED_STR = "frame delayed";
	public static String PARTITIONING_POLICY_PARTITION_END_STR = "partition end";

	public enum PartitioningPolicy {
		PARTITIONEND, MAJORFRAMEDELAYED
	};

	public static String REPORT_SUBTOTALS = "org.osate.analysis.flows.report_subtotals";

	public static String REPORT_SUBTOTALS_YES = "yes";
	public static String REPORT_SUBTOTALS_NO = "no";

	public enum YesNoAnswer {
		YES, NO
	};

	public static String WORST_CASE_DEADLINE = "org.osate.analysis.flows.report_worstcasedeadline";

	public static String WORST_CASE_DEADLINE_YES = "yes";
	public static String WORST_CASE_DEADLINE_NO = "no";

	public static String DETAILS_MARKERS = "org.osate.analysis.flows.details_markers";

	public static String DETAILS_MARKERS_YES = "yes";
	public static String DETAILS_MARKERS_NO = "no";

}
