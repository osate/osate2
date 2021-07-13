/*******************************************************************************
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party
 * beneficiaries to this license with respect to the terms applicable to their Third Party Software. Third Party
 * Software licenses only apply to the Third Party Software and not any other portion of this program or this program
 * as a whole.
 *******************************************************************************/
package org.osate.contribution.sei.arinc653;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

/**
 * @since 1.2
 */
public enum SupportedErrorCode implements GeneratedEnumeration {
	MODULE_CONFIG("Module_Config", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0"),
	MODULE_INIT("Module_Init", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.1"),
	MODULE_SCHEDULING("Module_Scheduling", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.2"),
	PARTITION_SCHEDULING("Partition_Scheduling", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.3"),
	PARTITION_CONFIG("Partition_Config", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.4"),
	PARTITION_HANDLER("Partition_Handler", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.5"),
	PARTITION_INIT("Partition_Init", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.6"),
	DEADLINE_MISS("Deadline_Miss", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.7"),
	APPLICATION_ERROR("Application_Error", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.8"),
	NUMERIC_ERROR("Numeric_Error", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.9"),
	ILLEGAL_REQUEST("Illegal_Request", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.10"),
	STACK_OVERFLOW("Stack_Overflow", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.11"),
	MEMORY_VIOLATION("Memory_Violation", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.12"),
	HARDWARE_FAULT("Hardware_Fault", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.13"),
	POWER_FAIL("Power_Fail", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.14");

	private final String originalName;
	private final URI uri;

	private SupportedErrorCode(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}

	public static SupportedErrorCode valueOf(PropertyExpression propertyExpression) {
		AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
		return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
	}

	@Override
	public URI getURI() {
		return uri;
	}

	@Override
	public String toString() {
		return originalName;
	}
}
