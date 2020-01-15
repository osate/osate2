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
package org.osate.aadl2.modelsupport.util;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.osate.aadl2.Connection;
import org.osate.aadl2.FeatureGroupConnection;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.ConnectionReference;

public class ConnectionGroupIterator {
	EList<Connection> done = null;
	Iterator<ConnectionInstance> internalit = null;
	ConnectionInstance nextObject = null;

	public ConnectionGroupIterator(EList<ConnectionInstance> list) {
		done = new UniqueEList<Connection>();
		internalit = list.iterator();
	}

	public boolean hasNext() {
		if (nextObject == null) {
			nextObject = doNext();
			return (nextObject != null);
		}
		return false;
	}

	public ConnectionInstance next() {
		if (nextObject != null) {
			ConnectionInstance conni = nextObject;
			nextObject = null;
			return conni;
		} else {
			return doNext();
		}
	}

	protected ConnectionInstance doNext() {
		while (internalit.hasNext()) {
			ConnectionInstance conni = internalit.next();
			if (conni.getKind() == ConnectionKind.PORT_CONNECTION
					|| conni.getKind() == ConnectionKind.FEATURE_GROUP_CONNECTION) {
				Connection top = getActualConnection(conni);
				if (top instanceof FeatureGroupConnection) {
					if (!done.contains(top)) {
						done.add(top);
						return conni;
					}
				} else {
					return conni;
				}
			}
		}
		return null;
	}

	protected Connection getActualConnection(ConnectionInstance ci) {
		for (ConnectionReference ref : ci.getConnectionReferences()) {
			Connection conn = ref.getConnection();

			if (conn.getAllSourceContext() instanceof Subcomponent
					&& conn.getAllDestinationContext() instanceof Subcomponent) {
				return conn;
			}
		}
		return null;
	}
}
