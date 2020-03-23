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

import static org.osate.aadl2.instance.ConnectionKind.ACCESS_CONNECTION;
import static org.osate.aadl2.instance.ConnectionKind.FEATURE_CONNECTION;
import static org.osate.aadl2.instance.ConnectionKind.FEATURE_GROUP_CONNECTION;
import static org.osate.aadl2.instance.ConnectionKind.MODE_TRANSITION_CONNECTION;
import static org.osate.aadl2.instance.ConnectionKind.PARAMETER_CONNECTION;
import static org.osate.aadl2.instance.ConnectionKind.PORT_CONNECTION;
import static org.osate.aadl2.instance.FeatureCategory.ABSTRACT_FEATURE;
import static org.osate.aadl2.instance.FeatureCategory.BUS_ACCESS;
import static org.osate.aadl2.instance.FeatureCategory.DATA_ACCESS;
import static org.osate.aadl2.instance.FeatureCategory.FEATURE_GROUP;
import static org.osate.aadl2.instance.FeatureCategory.PARAMETER;
import static org.osate.aadl2.instance.FeatureCategory.SUBPROGRAM_ACCESS;
import static org.osate.aadl2.instance.FeatureCategory.SUBPROGRAM_GROUP_ACCESS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupConnection;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceFactory;
import org.osate.aadl2.util.Aadl2InstanceUtil;

/**
 * This class represents intermediate states during the creation of a
 * connection instance. Once it's complete, it can be converted into a
 * connection instance.
 */
class ConnectionInfo {
	private ConnectionKind kind;
	final List<Connection> connections;
	final List<Boolean> opposites;
	final List<ComponentInstance> contexts;
	final List<ConnectionInstanceEnd> sources;
	final List<ConnectionInstanceEnd> destinations;
	ConnectionInstanceEnd src;
	private boolean bidirectional = true;
	boolean complete = false;
	private boolean across = false;
	Connection acrossConnection;
	ConnectedElement srcToMatch;
	ConnectedElement dstToMatch;
	ComponentInstance container;

	private ConnectionInfo(final ConnectionInfo info) {
		kind = info.kind;
		src = info.src;
		connections = new ArrayList<Connection>(info.connections);
		opposites = new ArrayList<Boolean>(info.opposites);
		contexts = new ArrayList<ComponentInstance>(info.contexts);
		sources = new ArrayList<ConnectionInstanceEnd>(info.sources);
		destinations = new ArrayList<ConnectionInstanceEnd>(info.destinations);
		bidirectional = info.bidirectional;
		complete = info.complete;
		across = info.across;
		acrossConnection = info.acrossConnection;
		srcToMatch = info.srcToMatch;
		dstToMatch = info.dstToMatch;
		container = info.container;
	}

	private ConnectionInfo(final ConnectionKind k, final ConnectionInstanceEnd s) {
		this(s);
		kind = k;
	}

	private ConnectionInfo(final ConnectionInstanceEnd s) {
		src = s;
		connections = new ArrayList<Connection>();
		opposites = new ArrayList<Boolean>();
		contexts = new ArrayList<ComponentInstance>();
		sources = new ArrayList<ConnectionInstanceEnd>();
		destinations = new ArrayList<ConnectionInstanceEnd>();
	}

	public static ConnectionInfo newConnectionInfo(final ConnectionInstanceEnd s) {
		return new ConnectionInfo(s);
	}

	public static ConnectionInfo newModeTransition(final ConnectionInstanceEnd s) {
		return new ConnectionInfo(MODE_TRANSITION_CONNECTION, s);
	}

	/**
	 * @param newSeg the connection to be appended
	 * @param srcFi the feature instance at the source of the new segment
	 * @param dstFi the feature instance at the destination of the new
	 *            segment
	 * @param ci the component containing the new segment
	 * @param opposite if we traverse a bidirectional segment opposite to
	 *            the declaration order
	 * @return if the new segment is a valid continuation of the connection
	 *         instance
	 */
	public boolean addSegment(final Connection newSeg, final ConnectionInstanceEnd srcFi,
			final ConnectionInstanceEnd dstFi, final ComponentInstance ci, boolean opposite, boolean[] keep) {
		boolean valid = true;
		final Context srcCtx = opposite ? newSeg.getAllDestinationContext() : newSeg.getAllSourceContext();
		final Context dstCtx = opposite ? newSeg.getAllSourceContext() : newSeg.getAllDestinationContext();
		final ConnectionEnd source = opposite ? newSeg.getAllDestination() : newSeg.getAllSource();
		final ConnectionEnd dest = opposite ? newSeg.getAllSource() : newSeg.getAllDestination();
		final boolean goingUp = !(dstCtx instanceof Subcomponent)
				&& (source instanceof Subcomponent || srcCtx instanceof Subcomponent);
		final boolean goingDown = !(srcCtx instanceof Subcomponent)
				&& (dest instanceof Subcomponent || dstCtx instanceof Subcomponent);
		// TODO can we do these checks on the instance information
		keep[0] = true;

		if (srcFi != null) {
			sources.add(srcFi);
			if (srcFi instanceof FeatureInstance) {
				DirectionType dir = ((FeatureInstance) srcFi).getFlowDirection();

				bidirectional &= (dir == DirectionType.IN_OUT);
				if (goingUp) {
					valid &= dir.outgoing();
				} else if (goingDown) {
					valid &= dir.incoming();
				} else {
					valid &= dir.outgoing();
				}
			}
		}
		bidirectional &= newSeg.isAllBidirectional();
		if (dstFi != null) {
			destinations.add(dstFi);
			if (dstFi instanceof FeatureInstance) {
				DirectionType dir = ((FeatureInstance) dstFi).getFlowDirection();

				bidirectional &= (dir == DirectionType.IN_OUT);
				if (goingUp) {
					valid &= dir.outgoing();
				} else if (goingDown) {
					valid &= dir.incoming();
				} else {
					valid &= dir.incoming();
				}
			}
		}
		if (valid) {
			// handle reaching into feature groups in across connection
			if (newSeg.isAcross()) {
				// segment goes across
				int i = connections.size();
				Connection root = newSeg.getRootConnection();
				srcToMatch = opposite ? root.getDestination() : root.getSource();
				srcToMatch = srcToMatch.getNext();
				while (keep[0] && i > 0 && srcToMatch != null) {
					i -= 1;
					Connection c = connections.get(i);
					// skip connections that don't go into a feature group
					if (!connectsSameFeatureGroup(c)) {
						ConnectionEnd e = opposites.get(i) ? c.getAllSource() : c.getAllDestination();
						ConnectionEnd cce = srcToMatch.getConnectionEnd();
						srcToMatch = srcToMatch.getNext();
						keep[0] = cce == e;
					}
				}
				across = true;
				acrossConnection = newSeg;
				dstToMatch = opposite ? root.getSource() : root.getDestination();
				dstToMatch = dstToMatch.getNext();
				container = ci;
			} else if (across && dstToMatch != null) {
				if (!connectsSameFeatureGroup(newSeg)) {
					ConnectionEnd e = opposite ? newSeg.getAllDestination() : newSeg.getAllSource();
					ConnectionEnd cce = dstToMatch.getConnectionEnd();
					dstToMatch = dstToMatch.getNext();
					keep[0] = cce == e;
				}
			}
		}
		connections.add(newSeg);
		opposites.add(opposite);
		contexts.add(ci);
		return valid;
	}

	protected boolean connectsSameFeatureGroup(Connection c) {
		if (c instanceof FeatureGroupConnection) {
			FeatureGroup s = (FeatureGroup) c.getAllSource();
			FeatureGroup d = (FeatureGroup) c.getAllDestination();
			return !(s.eContainer() instanceof FeatureGroupType || d.eContainer() instanceof FeatureGroupType);
		}
		return false;
	}

	/*
	 * Specialized clone operation that changes the prototype connection
	 * instance to be a mode transition connection instance.
	 */
	public ConnectionInfo convertToModeTransition() {
		kind = MODE_TRANSITION_CONNECTION;
		return this;
	}

	public ConnectionInfo cloneInfo() {
		return new ConnectionInfo(this);
	}

	public ConnectionInstance createConnectionInstance(final String name, final ConnectionInstanceEnd dst) {
		ConnectionInstance conni = InstanceFactory.eINSTANCE.createConnectionInstance();
		conni.setName(name);
		Iterator<Connection> connIter = connections.iterator();
		Iterator<ComponentInstance> ctxIter = contexts.iterator();
		// Iterator<ConnectionInstanceEnd> srcIter = sources.iterator();
		Iterator<ConnectionInstanceEnd> dstIter = destinations.iterator();
		Iterator<Boolean> oppIter = opposites.iterator();
		ConnectionInstanceEnd dosrc = src;
		ConnectionInstanceEnd dodst = null;

		while (connIter.hasNext() && dstIter.hasNext()) {
			ConnectionReference connRef = conni.createConnectionReference();

			connRef.setConnection(connIter.next());
			connRef.setContext(ctxIter.next());
			connRef.setSource(dosrc);
			dodst = resolveFeatureInstance(dosrc, dstIter.next());
			connRef.setDestination(dodst);
			dosrc = dodst;
			connRef.setReverse(oppIter.next());
		}
		conni.setSource(src);
		conni.setDestination(dst);
		conni.setComplete(across);
		kind = getKind(dst);
		conni.setKind(kind);
		return conni;
	}

	protected ConnectionInstanceEnd resolveFeatureInstance(ConnectionInstanceEnd origCIE,
			ConnectionInstanceEnd rootCIE) {
		if (origCIE instanceof ComponentInstance || rootCIE instanceof ComponentInstance) {
			return rootCIE;
		}
		FeatureInstance rootFI = (FeatureInstance) rootCIE;
		if (rootFI.getFeatureInstances().isEmpty()) {
			return rootCIE;
		}
		ConnectionInstanceEnd parentFI = rootFI;
		FeatureInstance origFI = (FeatureInstance) origCIE;
		Element origParent = origFI.getOwner();
		if (origParent instanceof FeatureInstance) {
			FeatureInstance origParentFI = (FeatureInstance) origParent;
			if (origParentFI.getOwner() instanceof FeatureInstance) {
				ConnectionInstanceEnd resFI = resolveFeatureInstance(origParentFI, rootFI);
				if (resFI != null) {
					parentFI = resFI;
				}
			}
			EList<FeatureInstance> filist = ((FeatureInstance) parentFI).getFeatureInstances();
			for (FeatureInstance featureInstance : filist) {
				if (Aadl2InstanceUtil.isSame(origFI, featureInstance)) {
					return featureInstance;
				}
			}
		}
		return rootFI;
	}

	private ConnectionKind getKind(ConnectionInstanceEnd dst) {
		if (isComponent(src) && isAccess(dst) || isAccess(src) && isComponent(dst) || isAccess(src) && isAccess(dst)) {
			return ACCESS_CONNECTION;
		}
		if (isParameter(src) || isParameter(dst)) {
			return PARAMETER_CONNECTION;
		}
		if (isFeatureGroup(src) || isFeatureGroup(dst)) {
			return FEATURE_GROUP_CONNECTION;
		}
		if (isAbstract(src) || isAbstract(dst)) {
			return FEATURE_CONNECTION;
		}
		return PORT_CONNECTION;
	}

	private boolean isComponent(ConnectionInstanceEnd end) {
		return end instanceof ComponentInstance;
	}

	private boolean isAbstract(ConnectionInstanceEnd end) {
		return end instanceof FeatureInstance && ((FeatureInstance) end).getCategory() == ABSTRACT_FEATURE;
	}

	private boolean isFeatureGroup(ConnectionInstanceEnd end) {
		return end instanceof FeatureInstance && ((FeatureInstance) end).getCategory() == FEATURE_GROUP;
	}

	private boolean isAccess(ConnectionInstanceEnd end) {
		if (end instanceof FeatureInstance) {
			FeatureCategory cat = ((FeatureInstance) end).getCategory();

			return cat == BUS_ACCESS || cat == DATA_ACCESS || cat == SUBPROGRAM_ACCESS
					|| cat == SUBPROGRAM_GROUP_ACCESS;
		}
		return false;
	}

	private boolean isParameter(ConnectionInstanceEnd end) {
		return end instanceof FeatureInstance && ((FeatureInstance) end).getCategory() == PARAMETER;
	}

	public boolean isBidirectional() {
		return bidirectional;
	}

	public boolean isAcross() {
		return across;
	}

}
