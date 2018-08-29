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