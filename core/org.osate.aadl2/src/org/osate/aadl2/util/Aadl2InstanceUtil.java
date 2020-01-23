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
package org.osate.aadl2.util;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;

public class Aadl2InstanceUtil {

	/**
	 * get outgoing connection instances from the component instance or any contained component instance
	 * @param ci component instance
	 * @return list of connection instances
	 */
	public static EList<ConnectionInstance> getOutgoingConnections(ComponentInstance ci) {
		EList<ConnectionInstance> result = new BasicEList<ConnectionInstance>();
		Iterable<ConnectionInstance> it = ci.allEnclosingConnectionInstances();
		for (ConnectionInstance connectionInstance : it) {
			ConnectionInstanceEnd src = connectionInstance.getSource();
			ConnectionInstanceEnd dst = connectionInstance.getDestination();
			if (containedIn(src, ci) && !containedIn(dst, ci)) {
				result.add(connectionInstance);
			}
		}
		return result;
	}

	/**
	 * get outgoing connection instances from the component instance or any contained component instance
	 * @param ci component instance
	 * @return list of connection references
	 */
	public static EList<ConnectionReference> getOutgoingConnectionReferences(ComponentInstance ci) {
		EList<ConnectionReference> result = new BasicEList<ConnectionReference>();
		Iterable<ConnectionInstance> it = ci.getSystemInstance().getAllConnectionInstances();// allEnclosingConnectionInstances();
		for (ConnectionInstance connectionInstance : it) {
			ConnectionInstanceEnd src = connectionInstance.getSource();
			ConnectionInstanceEnd dst = connectionInstance.getDestination();
			if (containedIn(src, ci) && !containedIn(dst, ci)) {
				EList<ConnectionReference> connreflist = connectionInstance.getConnectionReferences();
				for (ConnectionReference connectionReference : connreflist) {
					ComponentInstance pci = connectionReference.getContext();
					if (pci == ci.getContainingComponentInstance()) {
						result.add(connectionReference);
					}
				}
			}
		}
		return result;
	}

	/**
	 * get incoming connection instances from the component instance or any contained component instance
	 * @param ci component instance
	 * @return list of connection instances
	 */
	public static EList<ConnectionInstance> getIncomingConnections(ComponentInstance ci) {
		EList<ConnectionInstance> result = new BasicEList<ConnectionInstance>();
		Iterable<ConnectionInstance> it = ci.getSystemInstance().getAllConnectionInstances();// allEnclosingConnectionInstances();
		for (ConnectionInstance connectionInstance : it) {
			ConnectionInstanceEnd src = connectionInstance.getSource();
			ConnectionInstanceEnd dst = connectionInstance.getDestination();
			if (!containedIn(src, ci) && containedIn(dst, ci)) {
				result.add(connectionInstance);
			}
		}
		return result;
	}

	/**
	 * get incoming connection instances from the component instance or any contained component instance
	 * @param ci component instance
	 * @return list of connection instances
	 */
	public static EList<ConnectionReference> getIncomingConnectionReferences(ComponentInstance ci) {
		EList<ConnectionReference> result = new BasicEList<ConnectionReference>();
		Iterable<ConnectionInstance> it = ci.getSystemInstance().getAllConnectionInstances();// allEnclosingConnectionInstances();
		for (ConnectionInstance connectionInstance : it) {
			ConnectionInstanceEnd src = connectionInstance.getSource();
			ConnectionInstanceEnd dst = connectionInstance.getDestination();
			if ((!containedIn(src, ci) || src.getContainingComponentInstance() == ci) && containedIn(dst, ci)) {
				EList<ConnectionReference> connreflist = connectionInstance.getConnectionReferences();
				for (ConnectionReference connectionReference : connreflist) {
					ComponentInstance pci = connectionReference.getContext();
					if (pci == ci) {
						result.add(connectionReference);
					}
				}
			}
		}
		return result;
	}

	/**
	 * find outgoing connection that goes through the feature of the specified component instance
	 * @param ci Component instance
	 * @param fi Feature instance
	 * @return list of connection instances going through the feature
	 */
	public static EList<ConnectionInstance> getOutgoingConnection(ComponentInstance ci, FeatureInstance fi) {
		Feature f = fi.getFeature();
		EList<ConnectionInstance> result = new BasicEList<ConnectionInstance>();
		Iterable<ConnectionInstance> it = ci.getSystemInstance().getAllConnectionInstances();// allEnclosingConnectionInstances();
		for (ConnectionInstance connectionInstance : it) {
			ConnectionInstanceEnd src = connectionInstance.getSource();
			ComponentInstance srcci = src.getContainingComponentInstance();
			if (containedIn(srcci, ci)) {
				EList<ConnectionReference> connreflist = connectionInstance.getConnectionReferences();
				for (ConnectionReference connectionReference : connreflist) {
					ComponentInstance pci = connectionReference.getContext();
					Connection conn = connectionReference.getConnection();
					ConnectionEnd ce = conn.getAllSource();
					if (pci == ci.getContainingComponentInstance() && ce == f) {
						// add connection if it goes through feature instance
						result.add(connectionInstance);
					}
				}
			}
		}
		return result;
	}

	/**
	 * find incoming connection that goes through the feature of the specified component instance
	 * @param ci Component instance
	 * @param fi Feature instance
	 * @return list of connection instances going through the feature
	 */
	public static EList<ConnectionInstance> getIncomingConnection(ComponentInstance ci, FeatureInstance fi) {
		Feature f = fi.getFeature();
		EList<ConnectionInstance> result = new BasicEList<ConnectionInstance>();
		Iterable<ConnectionInstance> it = ci.getSystemInstance().getAllConnectionInstances();// allEnclosingConnectionInstances();
		for (ConnectionInstance connectionInstance : it) {
			ConnectionInstanceEnd dest = connectionInstance.getDestination();
			ComponentInstance destci = dest.getContainingComponentInstance();
			if (containedIn(destci, ci)) {
				EList<ConnectionReference> connreflist = connectionInstance.getConnectionReferences();
				for (ConnectionReference connectionReference : connreflist) {
					ComponentInstance pci = connectionReference.getContext();
					Connection conn = connectionReference.getConnection();
					ConnectionEnd ce = conn.getAllSource();
					if (pci == ci.getContainingComponentInstance() && ce == f) {
						result.add(connectionInstance);
					}
				}
			}
		}
		return result;
	}

	public static boolean isOutgoingConnection(ConnectionInstance connectionInstance, ComponentInstance ci) {
		ConnectionInstanceEnd src = connectionInstance.getSource();
		if (containedIn(src, ci)) {
			return true;
		}
		return false;
	}

	public static boolean isIncomingConnection(ConnectionInstance connectionInstance, ComponentInstance ci) {
		ConnectionInstanceEnd dst = connectionInstance.getDestination();
		if (containedIn(dst, ci)) {
			return true;
		}
		return false;
	}

	public static boolean containedIn(InstanceObject element, InstanceObject parent) {
		while (element != null) {
			if (element == parent) {
				return true;
			}
			element = (InstanceObject) element.getOwner();
		}
		return false;
	}

	public static ConnectionReference getTopConnectionReference(ConnectionInstance conni) {
		EList<ConnectionReference> connrefs = conni.getConnectionReferences();
		for (ConnectionReference connectionReference : connrefs) {
			ComponentInstance cxt = connectionReference.getContext();
			if (cxt != connectionReference.getSource().getComponentInstance()
					&& cxt != connectionReference.getDestination().getComponentInstance()) {
				// going across
				return connectionReference;
			}
		}
		ConnectionReference connectionReference = connrefs.get(0);
		ComponentInstance cxt = connectionReference.getContext();
		if (cxt == connectionReference.getSource().getComponentInstance()) {
			// incoming top conn ref
			return connectionReference;
		}
		connectionReference = connrefs.get(connrefs.size() - 1);
		cxt = connectionReference.getContext();
		if (cxt == connectionReference.getDestination().getComponentInstance()) {
			// outgoing top conn ref
			return connectionReference;
		}
		return null;
	}

	public static ConnectionReference getNextConnectionReference(ConnectionInstance conni,
			ConnectionReference connref) {
		EList<ConnectionReference> crlist = conni.getConnectionReferences();
		int idx = crlist.indexOf(connref);
		if (idx < crlist.size() - 1) {
			return crlist.get(crlist.indexOf(connref) + 1);
		}
		return null;
	}

	public static ConnectionReference getPreviousConnectionReference(ConnectionInstance conni,
			ConnectionReference connref) {
		EList<ConnectionReference> crlist = conni.getConnectionReferences();
		int idx = crlist.indexOf(connref);
		if (idx > 0) {
			return crlist.get(crlist.indexOf(connref) - 1);
		}
		return null;
	}

	public static int getFeatureIndex(FeatureInstance fi) {
		Element fgi = fi.getOwner();
		if (fgi instanceof FeatureInstance) {
			EList<FeatureInstance> flist = ((FeatureInstance) fgi).getFeatureInstances();
			return flist.indexOf(fi);
		}
		return -1;
	}

	public static boolean isSame(FeatureInstance up, FeatureInstance down) {
		if (up.getName().equalsIgnoreCase(down.getName())) {
			return true;
		}
		FeatureGroupType upfgt = ((FeatureGroup) ((FeatureInstance) up.getOwner()).getFeature()).getFeatureGroupType();
		FeatureGroupType downfgt = ((FeatureGroup) ((FeatureInstance) down.getOwner()).getFeature())
				.getFeatureGroupType();
		if (upfgt == null || downfgt == null) {
			return false;
		}
		if (upfgt.isInverseOf(downfgt) && !upfgt.getAllFeatures().isEmpty() && !downfgt.getAllFeatures().isEmpty()) {
			return (getFeatureIndex(up) == getFeatureIndex(down));
		}
		return false;
	}

	public static Collection<ConnectionInstance> getBidirectionalConnectionInstances(
			Collection<ConnectionInstance> connList) {
		Collection<ConnectionInstance> result = new BasicEList<ConnectionInstance>();
		for (ConnectionInstance connectionInstance : connList) {
			if (connectionInstance.isBidirectional()) {
				result.add(connectionInstance);
			}
		}
		return result;
	}

	public static boolean inOnly(ConnectionInstance conni) {
		EList<ConnectionReference> connrefs = conni.getConnectionReferences();
		ConnectionReference first = connrefs.get(0);
		return (first.getSource().getComponentInstance() == first.getContext());
	}

	public static boolean outOnly(ConnectionInstance conni) {
		EList<ConnectionReference> connrefs = conni.getConnectionReferences();
		ConnectionReference last = connrefs.get(connrefs.size() - 1);
		return (last.getDestination().getComponentInstance() == last.getContext());

	}

	public static boolean isOpposite(ConnectionInstance conni) {
		final ConnectionReference topref = getTopConnectionReference(conni);
		return topref.isReverse();
	}

}
