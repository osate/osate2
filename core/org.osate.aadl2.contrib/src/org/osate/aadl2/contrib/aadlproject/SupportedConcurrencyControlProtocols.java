/*******************************************************************************
 * Copyright (c) 2004-2022 Carnegie Mellon University and others. (see Contributors file). 
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 *******************************************************************************/
package org.osate.aadl2.contrib.aadlproject;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum SupportedConcurrencyControlProtocols implements GeneratedEnumeration {
	NONE_SPECIFIED("None_Specified", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.2/@ownedLiteral.0"),
	INTERRUPT_MASKING("Interrupt_Masking", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.2/@ownedLiteral.1"),
	MAXIMUM_PRIORITY("Maximum_Priority", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.2/@ownedLiteral.2"),
	PRIORITY_INHERITANCE("Priority_Inheritance", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.2/@ownedLiteral.3"),
	PRIORITY_CEILING("Priority_Ceiling", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.2/@ownedLiteral.4"),
	SPIN_LOCK("Spin_Lock", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.2/@ownedLiteral.5"),
	SEMAPHORE("Semaphore", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.2/@ownedLiteral.6"),
	PROTECTED_ACCESS("Protected_Access", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl#/0/@ownedPropertyType.2/@ownedLiteral.7");
	
	private final String originalName;
	private final URI uri;
	
	private SupportedConcurrencyControlProtocols(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static SupportedConcurrencyControlProtocols valueOf(PropertyExpression propertyExpression) {
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
