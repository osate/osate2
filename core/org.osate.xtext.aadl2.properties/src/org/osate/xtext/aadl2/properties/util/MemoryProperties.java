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