/*
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
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
 *
 * </copyright>
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
