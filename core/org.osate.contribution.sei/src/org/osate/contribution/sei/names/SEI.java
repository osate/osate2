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
package org.osate.contribution.sei.names;

/**
 * String constants for the members of the "SEI" property set.
 * @author aarong
 */
public final class SEI {
	/** The name of the property set itself. */
	public static final String _NAME = "SEI";

	public static final String SECURITY_LEVEL = "SecurityLevel";
	public static final String SAFETY_CRITICALITY = "SafetyCriticality";
	public static final String STREAM_MISS_RATE = "StreamMissRate";
//	public static final String PRIORITY = "Priority"; now in ThreadPriorties.java in aadl2/properties
	public static final String PARTITION_LATENCY = "Partition_Latency";
	public static final String IS_PARTITION = "Is_Partition";
	public static final String INSTRUCTIONSPERDISPATCH = "InstructionsPerDispatch";
	public static final String MIPS_CAPACITY = "MIPSCapacity";
	public static final String MIPS_BUDGET = "MIPSBudget";
	public static final String RAM_CAPACITY = "RAMCapacity";
	public static final String RAM_BUDGET = "RAMBudget";
	public static final String ROM_CAPACITY = "ROMCapacity";
	public static final String ROM_BUDGET = "ROMBudget";
	public static final String POWER_CAPACITY = "PowerCapacity";
	public static final String POWER_SUPPLY = "PowerSupply";
	public static final String POWER_BUDGET = "PowerBudget";
	public static final String BANDWIDTH_CAPACITY = "BandWidthCapacity";
	public static final String BANDWIDTH_BUDGET = "BandWidthBudget";
	public static final String RAM_ACTUAL = "RAMActual";
	public static final String ROM_ACTUAL = "ROMActual";

	public static final String BROADCAST_PROTOCOL = "Broadcast_Protocol";

	public static final String NETWEIGHT = "NetWeight";
	public static final String GROSSWEIGHT = "GrossWeight";
	public static final String WEIGHTLIMIT = "WeightLimit";

	public static final String INSTRUCTIONVOLUMEUNITS = "InstructionVolumeUnits";
	public static final String IPD_LITERAL = "IPD";
	public static final String KIPD_LITERAL = "KIPD";
	public static final String MIPD_LITERAL = "MIPD";
	public static final String GIPD_LITERAL = "GIPD";

	public static final String PROCESSOR_SPEED_UNITS = "Processor_Speed_Units";
	public static final String KIPS_LITERAL = "KIPS";
	public static final String MIPS_LITERAL = "MIPS";
	public static final String GIPS_LITERAL = "GIPS";

	public static final String POWER_UNITS = "Power_Units";
	public static final String MW_LITERAL = "mW";
	public static final String W_LITERAL = "W";
	public static final String KW_LITERAL = "KW";

	public static final String DATA_RATE = "Data_Rate";
	public static final String MESSAGE_RATE = "Message_Rate";

	public static final String NSLOC = "nsloc";
	public static final String VDID_INSPECT = "vdid_inspect";

	public static final String MODEL_REFERENCES = "model_references";
	public static final String PLATFORM = "platform";

	public static final String PRICE = "price";
}
