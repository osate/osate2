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
package org.osate.ge.internal.util;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.ComponentImplementation;

public class AadlConnectionUtil {
	private final static Map<EClass, String> connectionTypeToMethodNameMap = createConnectionTypeToMethodMap();
	
	/**
	 * Returns an unmodifiable map that contains the connection type to create method name mapping
	 */
	private static Map<EClass,String> createConnectionTypeToMethodMap() {
		final LinkedHashMap<EClass, String> map = new LinkedHashMap<EClass, String>();
		final Aadl2Package p = Aadl2Factory.eINSTANCE.getAadl2Package();
		map.put(p.getAccessConnection(), "createOwnedAccessConnection");
		map.put(p.getFeatureConnection(), "createOwnedFeatureConnection");
		map.put(p.getFeatureGroupConnection(), "createOwnedFeatureGroupConnection");
		map.put(p.getParameterConnection(), "createOwnedParameterConnection");
		map.put(p.getPortConnection(), "createOwnedPortConnection");
		
		return Collections.unmodifiableMap(map);
	}
	
	public static Collection<EClass> getConnectionTypes() {
		return connectionTypeToMethodNameMap.keySet();
	}
	
	public static org.osate.aadl2.Connection createConnection(final ComponentImplementation ci, final EClass connectionClass) {
		try {
			return (org.osate.aadl2.Connection)getConnectionCreateMethod(ci, connectionClass).invoke(ci);
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private static Method getConnectionCreateMethod(final ComponentImplementation ci, final EClass connectionType) {
		// Determine the method name for the type of feature
		final String methodName = connectionTypeToMethodNameMap.get(connectionType);
		if(methodName == null) {
			return null;
		}
		
		// Get the method
		try {
			final Method method = ci.getClass().getMethod(methodName);
			return method;
		} catch(final Exception ex) {
			return null;
		}
	}
	
}
