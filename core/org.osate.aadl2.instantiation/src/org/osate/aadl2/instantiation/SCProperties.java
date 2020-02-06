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
package org.osate.aadl2.instantiation;

import java.util.HashMap;
import java.util.Map;

import org.osate.aadl2.Connection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.instance.ConnectionInstance;

/**
 * Very crude encapsulation of the multi-level map used to cache contained
 * property associations that apply to semantic connections.
 * in {@link org.osate.aadl2.instantiation.CheckInstanceSemanticsSwitch#checkPropertyConsistency(ConnectionInstance)}.
 *
 * @author aarong
 */
public class SCProperties {
	private final Map<ConnectionInstance, Map<Property, Map<Connection, PropertyAssociation>>> scProps;

	public SCProperties() {
		scProps = new HashMap<ConnectionInstance, Map<Property, Map<Connection, PropertyAssociation>>>();
	}

	private static <KOuter, KInner, VInner> Map<KInner, VInner> get(final Map<KOuter, Map<KInner, VInner>> map,
			KOuter key) {
		Map<KInner, VInner> val = map.get(key);
		if (val == null) {
			val = new HashMap<KInner, VInner>();
			map.put(key, val);
		}
		return val;
	}

	public void recordSCProperty(ConnectionInstance conni, Property prop, Connection conn, PropertyAssociation pa) {
		get(get(scProps, conni), prop).put(conn, pa);
	}

	public PropertyAssociation retrieveSCProperty(ConnectionInstance conni, Property prop, Connection conn) {
		PropertyAssociation result = null;

		while (conn != null && result == null) {
			result = get(get(scProps, conni), prop).get(conn);
			conn = conn.getRefined();
		}
		return result;
	}

	public Map<Property, Map<Connection, PropertyAssociation>> get(ConnectionInstance sc) {
		return scProps.get(sc);
	}

}
