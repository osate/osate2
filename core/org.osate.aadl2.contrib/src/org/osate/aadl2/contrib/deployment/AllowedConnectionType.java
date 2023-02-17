/*******************************************************************************
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.aadl2.contrib.deployment;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum AllowedConnectionType implements GeneratedEnumeration {
	SAMPLED_DATA_CONNECTION("Sampled_Data_Connection", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Deployment_Properties.aadl#/0/@ownedProperty.20/@ownedPropertyType/@ownedElementType/@ownedLiteral.0"),
	IMMEDIATE_DATA_CONNECTION("Immediate_Data_Connection", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Deployment_Properties.aadl#/0/@ownedProperty.20/@ownedPropertyType/@ownedElementType/@ownedLiteral.1"),
	DELAYED_DATA_CONNECTION("Delayed_Data_Connection", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Deployment_Properties.aadl#/0/@ownedProperty.20/@ownedPropertyType/@ownedElementType/@ownedLiteral.2"),
	PORT_CONNECTION("Port_Connection", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Deployment_Properties.aadl#/0/@ownedProperty.20/@ownedPropertyType/@ownedElementType/@ownedLiteral.3"),
	DATA_ACCESS_CONNECTION("Data_Access_Connection", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Deployment_Properties.aadl#/0/@ownedProperty.20/@ownedPropertyType/@ownedElementType/@ownedLiteral.4"),
	SUBPROGRAM_ACCESS_CONNECTION("Subprogram_Access_Connection", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Deployment_Properties.aadl#/0/@ownedProperty.20/@ownedPropertyType/@ownedElementType/@ownedLiteral.5");
	
	private final String originalName;
	private final URI uri;
	
	private AllowedConnectionType(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static AllowedConnectionType valueOf(PropertyExpression propertyExpression) {
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
