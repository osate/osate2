/*
 *
 * <copyright>
 * Copyright  2004-2013 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES" ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 *
 *
 * @version $Id: AadlProject.java,v 1.3 2009-10-09 18:49:33 lwrage Exp $
 */

package org.osate.xtext.aadl2.properties.util;

/**
 * @author aarong, julien
 */
public final class AadlProject {
	private AadlProject() {
	}

	public static final String _NAME = "AADL_Project";

	public static final String DEFAULT_ACTIVE_THREAD_HANDLING_PROTOCOL = "Default_Active_Thread_Handling_Protocol";

	public static final String SUPPORTED_ACTIVE_THREAD_HANDLING_PROTOCOLS = "Supported_Active_Thread_Handling_Protocols";
	public static final String ABORT_LITERAL = "abort";
	public static final String COMPLETE_ONE_FLUSH_QUEUE_LITERAL = "complete_one_flush_queue";
	public static final String COMPLETE_ONE_TRANSFER_QUEUE_LITERAL = "complete_one_transfer_queue";
	public static final String COMPLETE_ONE_PRESERVE_QUEUE_LITERAL = "complete_one_preserve_queue";
	public static final String COMPLETE_ALL_LITERAL = "complete_all";

	public static final String SUPPORTED_CONNECTION_PROTOCOLS = "Supported_Connection_Protocols";
	public static final String HTTP_LITERAL = "HTTP";
	public static final String HTTPS_LITERAL = "HTTPS";
	public static final String UDP_LITERAL = "UDP";
	public static final String IP_TCP_LITERAL = "IP_TCP";

	public static final String SUPPORTED_CONCURRENCY_CONTROL_PROTOCOLS = "Supported_Concurrency_Control_Protocols";
	public static final String NONESPECIFIED_LITERAL = "NoneSpecified";
	public static final String INTERRUPT_MASKING_LITERAL = "Interrupt_Masking";

	public static final String SUPPORTED_DISPATCH_PROTOCOLS = "Supported_Dispatch_Protocols";
	public static final String PERIODIC_LITERAL = "Periodic";
	public static final String APERIODIC_LITERAL = "Aperiodic";
	public static final String SPORADIC_LITERAL = "Sporadic";
	public static final String BACKGROUND_LITERAL = "Background";
	public static final String HYBRID_LITERAL = "Hybrid";
	public static final String TIMED_LITERAL = "Timed";

	public static final String SUPPORTED_HARDWARE_SOURCE_LANGUAGES = "Supported_Hardware_Source_Languages";
	public static final String VHDL_LITERAL = "VHDL";

	public static final String SUPPORTED_QUEUE_PROCESSING_PROTOCOLS = "Supported_Queue_Processing_Protocols";
	public static final String FIFO_LITERAL = "FIFO";

	public static final String SUPPORTED_SCHEDULING_PROTOCOLS = "Supported_Scheduling_Protocols";
	public static final String RMS_LITERAL = "RMS";
	public static final String DMS_LITERAL = "DMS";
	public static final String EDF_LITERAL = "EDF";
	public static final String SPORADICSERVER_LITERAL = "Sporadicserver";
	public static final String SLACKSERVER_LITERAL = "SlackServer";
	public static final String ARINC653_LITERAL = "ARINC653";

	public static final String SUPPORTED_SOURCE_LANGUAGES = "Supported_Source_Languages";
	public static final String ADA95_LITERAL = "Ada95";
	public static final String C_LITERAL = "C";
	public static final String SIMULINK_6_5_LITERAL = "Simulink_6_5";

	public static final String SUPPORTED_CLASSIFIER_EQUIVALENCE_MATCHES = "Supported_Classifier_Equivalence_Matches";
	public static final String SUPPORTED_CLASSIFIER_SUBSET_MATCHES = "Supported_Classifier_Subset_Matches";
	public static final String SUPPORTED_TYPE_CONVERSIONS = "Supported_Type_Conversions";
	public static final String SUPPORTED_CLASSIFIER_COMPLEMENT_MATCHES = "Supported_Classifier_Complement_Matches";

	public static final String MAX_AADLINTEGER = "Max_Aadlinteger";
	public static final String MAX_BASE_ADDRESS = "Max_Base_Address";
	public static final String MAX_MEMORY_SIZE = "Max_Memory_Size";
	public static final String MAX_QUEUE_SIZE = "Max_Queue_Size";
	public static final String MAX_THREAD_LIMIT = "Max_Thread_Limit";
	public static final String MAX_TIME = "Max_Time";
	public static final String MAX_URGENCY = "Max_Urgency";
	public static final String MAX_WORD_COUNT = "Max_Word_Count";
	public static final String MAX_WORD_SPACE = "Max_Word_Space";

	public static final String SIZE_UNITS = "Size_Units";
	public static final String BITS_LITERAL = "Bits";
	public static final String B_LITERAL = "Bytes";
	public static final String BYTES_LITERAL = "Bytes";
	public static final String KB_LITERAL = "KByte";
	public static final String MB_LITERAL = "MByte";
	public static final String GB_LITERAL = "GByte";

	public static final String DATA_RATE_UNITS = "Data_Rate_Units";
//
//	public static final String DATA_VOLUME_UNITS = "Data_Volume_Units";
	public static final String BITSPS_LITERAL = "bitsps";
	public static final String KBITSPS_LITERAL = "Kbitsps";
	public static final String MBITSPS_LITERAL = "Mbitsps";
	public static final String GBITSPS_LITERAL = "Gbitsps";
	public static final String BYTESPS_LITERAL = "Bytesps";
	public static final String KBYTESPS_LITERAL = "KBytesps";
	public static final String MBYTESPS_LITERAL = "MBytesps";
	public static final String GBYTESPS_LITERAL = "GBytesps";

	public static final String TIME_UNITS = "Time_Units";
	public static final String PS_LITERAL = "ps";
	public static final String NS_LITERAL = "Ns";
	public static final String US_LITERAL = "Us";
	public static final String MS_LITERAL = "Ms";
	public static final String SEC_LITERAL = "Sec";
	public static final String MIN_LITERAL = "Min";
	public static final String HR_LITERAL = "Hr";

	public static final String MIPS_LITERAL = "MIPS";

}
