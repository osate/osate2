/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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

	/**
	 * @since org.ostate.analysis.flows 3.0
	 */
	public static final String DISABLE_QUEUING_LATENCY = "org.osate.analysis.flows.disable_queuing_latency";
	/**
	 * @since org.ostate.analysis.flows 3.0
	 */
	public static final String DISABLE_QUEUING_LATENCY_LAST_USED = "org.osate.analysis.flows.disable_queuing_latency_last_used";

	/**
	 * @since org.ostate.analysis.flows 3.0
	 */
	public static final String DISABLE_QUEUING_LATENCY_YES = "disabled";
	/**
	 * @since org.ostate.analysis.flows 3.0
	 */
	public static final String DISABLE_QUEUING_LATENCY_NO = "enabled";

	public static final String DONT_SHOW_DIALOG = "org.osate.analysis.flows.dont_show_dialog";
}
