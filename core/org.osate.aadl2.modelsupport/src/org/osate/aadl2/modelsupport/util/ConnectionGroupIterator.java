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
