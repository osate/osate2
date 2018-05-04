/*
 * <copyright>
 * Copyright  2009 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
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
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.xtext.aadl2.properties.util;

public final class MemoryProperties {
	private MemoryProperties() {
	}

	public static final String _NAME = "Memory_Properties";
	public static final String ACCESS_RIGHT = "Access_Right";
	public static final String READ_ONLY = "read_only";
	public static final String WRITE_ONLY = "write_only";
	public static final String READ_WRITE = "read_write";
	public static final String BY_METHOD = "by_method";

	public static final String DATA_SIZE = "Data_Size";
	public static final String CODE_SIZE = "Code_Size";
	public static final String STACK_SIZE = "Stack_Size";
	public static final String HEAP_SIZE = "Heap_Size";
	public static final String MEMORY_SIZE = "Memory_Size";
	public static final String BASE_ADDRESS = "Base_Address";

	/**
	 * Backward compatibility. The Source_* were removed.
	 * So, the Source_Data_Size is now Data_Size. To ensure
	 * plugin compatibility, we keep the following definitions.
	 * The change has been discussed and approved during the
	 * April 14 AADL committee meeting.
	 */
	public static final String SOURCE_DATA_SIZE = "Source_Data_Size";
	public static final String SOURCE_CODE_SIZE = "Source_Code_Size";
	public static final String SOURCE_STACK_SIZE = "Source_Stack_Size";
	public static final String SOURCE_HEAP_SIZE = "Source_Heap_Size";
	public static final String BYTE_COUNT = "Byte_Count";

	/**
	 * access is read/write or write
	 * @return boolean true it does write
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public static boolean isWrite(String access) {
		return READ_WRITE.equalsIgnoreCase(access) || WRITE_ONLY.equalsIgnoreCase(access);
	}

	/**
	 * DirectionType is IN or IN_OUT
	 * @return boolean true if IN or IN_OUT
	 */
	// XXX: [AADL 1 -> AADL 2] Added to make instantiation work.
	public static boolean isRead(String access) {
		return READ_WRITE.equalsIgnoreCase(access) || READ_ONLY.equalsIgnoreCase(access);
	}

	/**
	 * changes the access right direction
	 *
	 */
	public static String getInverseDirection(String access) {
		if (READ_WRITE.equalsIgnoreCase(access)) {
			return access;
		} else if (READ_ONLY.equalsIgnoreCase(access)) {
			return WRITE_ONLY;
		} else {
			return READ_ONLY;
		}
	}

}