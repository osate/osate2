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

public final class DeploymentProperties {
	private DeploymentProperties() {
	}

	public static final String _NAME = "Deployment_Properties";
	public static final String ALLOWED_PROCESSOR_BINDING_CLASS = "Allowed_Processor_Binding_Class";
	public static final String ALLOWED_PROCESSOR_BINDING = "Allowed_Processor_Binding";
	public static final String ACTUAL_PROCESSOR_BINDING = "Actual_Processor_Binding";
	public static final String ALLOWED_MEMORY_BINDING_CLASS = "Allowed_Memory_Binding_Class";
	public static final String ALLOWED_MEMORY_BINDING = "Allowed_Memory_Binding";
	public static final String ACTUAL_MEMORY_BINDING = "Actual_Memory_Binding";
	public static final String ALLOWED_CONNECTION_BINDING_CLASS = "Allowed_Connection_Binding_Class";
	public static final String ALLOWED_CONNECTION_BINDING = "Allowed_Connection_Binding";
	public static final String ACTUAL_CONNECTION_BINDING = "Actual_Connection_Binding";
	public static final String ALLOWED_SUBPROGRAM_CALL_BINDING = "Allowed_Subprogram_Call_Binding";
	public static final String ALLOWED_SUBPROGRAM_CALL = "Allowed_Subprogram_Call";
	public static final String ACTUAL_SUBPROGRAM_CALL_BINDING = "Actual_Subprogram_Call_Binding";
	public static final String ACTUAL_SUBPROGRAM_CALL = "Actual_Subprogram_Call";
	public static final String ALLOWED_DISPATCH_PROTOCOL = "Allowed_Dispatch_Protocol";

	public static final String PROVIDED_VIRTUAL_BUS_CLASS = "Provided_Virtual_Bus_Class";
	public static final String REQUIRED_VIRTUAL_BUS_CLASS = "Required_Virtual_Bus_Class";
	public static final String PROVIDED_CONNECTION_QUALITY_OF_SERVICE = "Provided_Connection_Quality_Of_Service";
	public static final String REQUIRED_CONNECTION_QUALITY_OF_SERVICE = "Required_Connection_Quality_Of_Service";

	public static final String ACTUAL_FUNCTION_BINDING = "Actual_Function_Binding";

	public static final String NOT_COLLOCATED = "Not_Collocated";
	public static final String SCHEDULING_PROTOCOL = "Scheduling_Protocol";
	public static final String CONCURRENCY_CONTROL_PROTOCOL = "Concurrency_Control_Protocol";
	public static final String REQUIRED_CONNECTION = "Required_Connection";
}