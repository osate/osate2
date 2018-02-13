package org.osate.analysis.flows.preferences;

public class Constants {
	public static String PARTITONING_POLICY = "org.osate.analysis.flows.partitioning_policy";

	public static String PARTITIONING_POLICY_MAJOR_FRAME_DELAYED_STR = "major partition frame";
	public static String PARTITIONING_POLICY_PARTITION_END_STR = "partition end";

	public enum PartitioningPolicy {
		PARTITIONEND, MAJORFRAMEDELAYED
	};

//	public static String REPORT_SUBTOTALS = "org.osate.analysis.flows.report_subtotals";
//
//	public static String REPORT_SUBTOTALS_YES = "yes";
//	public static String REPORT_SUBTOTALS_NO = "no";

	public static String WORST_CASE_DEADLINE = "org.osate.analysis.flows.report_worstcasedeadline";

	public static String WORST_CASE_DEADLINE_YES = "worst case as deadline";
	public static String WORST_CASE_DEADLINE_NO = "worst case as max compute execution time";


	public static String BESTCASE_EMPTY_QUEUE = "org.osate.analysis.flows.bestcase_empty_queue";

	public static String BESTCASE_EMPTY_QUEUE_YES = "best case as empty queue";
	public static String BESTCASE_EMPTY_QUEUE_NO = "best case as full queue min compute execution time";

	public static String SYNCHRONOUS_SYSTEM = "org.osate.analysis.flows.synchronous_system";

	public static String SYNCHRONOUS_SYSTEM_YES = "synchronous system";
	public static String SYNCHRONOUS_SYSTEM_NO = "asynchronous system";

}
