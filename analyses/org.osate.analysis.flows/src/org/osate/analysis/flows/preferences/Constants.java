package org.osate.analysis.flows.preferences;

public class Constants {
	public static final String PARTITONING_POLICY = "org.osate.analysis.flows.partitioning_policy";
	public static final String PARTITONING_POLICY_LAST_USED = "org.osate.analysis.flows.partitioning_policy_last_used";

	public static final String PARTITIONING_POLICY_MAJOR_FRAME_DELAYED_STR = "major partition frame";
	public static final String PARTITIONING_POLICY_PARTITION_END_STR = "partition end";

	public enum PartitioningPolicy {
		PARTITIONEND, MAJORFRAMEDELAYED
	};


	public static final String WORST_CASE_DEADLINE = "org.osate.analysis.flows.report_worstcasedeadline";
	public static final String WORST_CASE_DEADLINE_LAST_USED = "org.osate.analysis.flows.report_worstcasedeadline_last_used";

	public static final String WORST_CASE_DEADLINE_YES = "worst case as deadline";
	public static final String WORST_CASE_DEADLINE_NO = "worst case as max compute execution time";


	public static final String BESTCASE_EMPTY_QUEUE = "org.osate.analysis.flows.bestcase_empty_queue";
	public static final String BESTCASE_EMPTY_QUEUE_LAST_USED = "org.osate.analysis.flows.bestcase_empty_queue_last_used";

	public static final String BESTCASE_EMPTY_QUEUE_YES = "best case as empty queue";
	public static final String BESTCASE_EMPTY_QUEUE_NO = "best case as full queue min compute execution time";


	public static final String ASYNCHRONOUS_SYSTEM = "org.osate.analysis.flows.asynchronous_system";
	public static final String ASYNCHRONOUS_SYSTEM_LAST_USED = "org.osate.analysis.flows.asynchronous_system_last_used";

	public static final String ASYNCHRONOUS_SYSTEM_YES = "asynchronous system";
	public static final String ASYNCHRONOUS_SYSTEM_NO = "synchronous system";


	public static final String DONT_SHOW_DIALOG = "org.osate.analysis.flows.dont_show_dialog";
}
