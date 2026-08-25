/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.instantiation.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Connection;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.SystemInstance;

/**
 * Matches the declarative connections of an end-to-end flow against the semantic connections of an instance model.
 * <p>
 * Every method here is a pure question about a connection instance and asks nothing about how the flow was reached.
 * Discovery uses them in two ways: {@link #collectConnectionInstances} looks up the connection instances that carry a
 * pending declarative path, and the {@code isValidContinuation} predicates plus
 * {@link #isCompatibleNestedConnection} decide which of those can continue the flow.
 */
public final class FlowConnectionMatcher {

	private FlowConnectionMatcher() {
	}

	/**
	 * Get all enclosing connection instances that pass through the given declarative connection sequence and continue
	 * from the candidate's current endpoint.
	 */
	public static List<ConnectionInstance> collectConnectionInstances(ComponentInstance ci, EndToEndFlowInstance etei,
			List<Connection> connections) {
		List<ConnectionInstance> result = new ArrayList<>();

		for (ConnectionInstance conni : ci.allEnclosingConnectionInstances()) {
			if (testConnection(conni, etei, connections)) {
				result.add(conni);
			}
		}
		return result;
	}

	/**
	 * Check whether a connection instance ends at the input feature of a flow implementation.
	 *
	 * @param conni the connection instance
	 * @param fimpl the flow implementation that must follow the connection
	 * @return whether the connection destination is the flow input
	 */
	public static boolean isValidContinuation(ConnectionInstance conni, FlowImplementation fimpl) {
		boolean result = false;
		ConnectionInstanceEnd dst = conni.getDestination();
		if (dst instanceof FeatureInstance featureInstance) {
			Feature flowIn = fimpl.getInEnd().getFeature();
			Feature connDst = featureInstance.getFeature();
			result = flowIn == connDst;
		}
		return result;
	}

	/**
	 * Check whether a connection instance ends at a flow specification's source feature. A connection to the source
	 * feature itself or to a feature nested within it is accepted by walking up the feature-instance containment chain.
	 *
	 * @param flowComponent the component that owns the flow specification instance
	 * @param conni the connection instance
	 * @param fspec the flow specification that must follow the connection
	 * @return whether the connection destination reaches the flow source
	 */
	public static boolean isValidContinuation(ComponentInstance flowComponent, ConnectionInstance conni,
			FlowSpecification fspec) {
		ConnectionInstanceEnd cie = conni.getDestination();
		if (cie instanceof FeatureInstance conniFi) {
			FlowSpecificationInstance fsi = flowComponent.findFlowSpecInstance(fspec);
			if (fsi != null) {
				FeatureInstance fsSrcFi = fsi.getSource();
				EObject e = conniFi;
				while (e instanceof FeatureInstance fi) {
					if (fi == fsSrcFi) {
						return true;
					}
					e = fi.eContainer();
				}
			}
		}
		return false;
	}

	/**
	 * Check whether a connection instance starts at the output feature of a flow implementation.
	 *
	 * @param fimpl the flow implementation that must precede the connection
	 * @param conni the connection instance
	 * @return whether the connection source is the flow output
	 */
	public static boolean isValidContinuation(FlowImplementation fimpl, ConnectionInstance conni) {
		boolean result = false;
		ConnectionInstanceEnd src = conni.getSource();
		if (src instanceof FeatureInstance featureInstance) {
			Feature flowOut = fimpl.getOutEnd().getFeature();
			Feature connSrc = featureInstance.getFeature();
			result = flowOut == connSrc;
		}
		return result;
	}

	/**
	 * Check whether an incoming connection reaches the start of a nested end-to-end flow variant.
	 *
	 * @param connection the connection instance that would precede the nested flow
	 * @param nestedPreConnections the declarative connections the nested variant expects before its first element
	 * @param nestedInstance the nested flow instance
	 * @return whether the connection can continue into that nested variant
	 */
	public static boolean isCompatibleNestedConnection(ConnectionInstance connection,
			List<Connection> nestedPreConnections, EndToEndFlowInstance nestedInstance) {
		if (!containsConnectionPath(connection, nestedPreConnections)) {
			return false;
		}

		ConnectionInstanceEnd destination = connection.getDestination();
		ConnectionInstanceEnd nestedStart = getFirstConnectionEnd(nestedInstance);
		if (destination instanceof FeatureInstance destinationFeature
				&& nestedStart instanceof FeatureInstance nestedFeature) {
			return isSameorContains(nestedFeature, destinationFeature);
		}
		if (nestedStart instanceof ComponentInstance nestedComponent) {
			return destination == nestedComponent || destination.getComponentInstance() == nestedComponent;
		}
		return destination == nestedStart;
	}

	/**
	 * Match a connection instance against a contiguous sequence of declarative connections. Refined connections are
	 * considered equivalent; single-connection paths are also checked for flow direction; feature-group expansion is
	 * checked against the candidate's last feature.
	 *
	 * @param conni the connection instance to test
	 * @param etei the candidate whose current endpoint constrains the match
	 * @param connections the declarative connection sequence
	 * @return whether the connection instance continues the candidate along the requested sequence
	 */
	private static boolean testConnection(ConnectionInstance conni, EndToEndFlowInstance etei,
			List<Connection> connections) {
		Iterator<ConnectionReference> refIter = conni.getConnectionReferences().iterator();
		boolean match = false;

		while (refIter.hasNext()) {
			if (isSameOrRefinedConnection(refIter.next().getConnection(), connections.get(0))) {
				Iterator<Connection> connIter = connections.iterator();

				connIter.next();
				match = true;
				while (match && refIter.hasNext() && connIter.hasNext()) {
					match &= isSameOrRefinedConnection(refIter.next().getConnection(), connIter.next());
				}
				if (!refIter.hasNext() && connIter.hasNext()) {
					match = false;
				}
			}
		}
		if (match && connections.size() == 1) {
			// make sure connection instance goes in the same direction as the flow
			ComponentInstance connci = conni.getSource().getComponentInstance();
			FlowElementInstance fei = etei;

			while (fei instanceof EndToEndFlowInstance nested) {
				fei = nested.getFlowElements().getLast();
			}
			if (fei instanceof FlowSpecificationInstance flowSpecification) {
				fei = flowSpecification.getComponentInstance();
			}
			ComponentInstance flowci = (ComponentInstance) fei;

			match = false;
			ComponentInstance ci = connci;
			while (!(ci instanceof SystemInstance)) {
				if (ci == flowci) {
					match = true;
					break;
				}
				ci = ci.getContainingComponentInstance();
			}
		}
		if (match) {
			// test if the connection instance is connected to the end of the ete instance
			// relevant if the flow goes through a port of a feature group and the connection
			// instance comes from an expanded fg connection
			ConnectionInstanceEnd src = conni.getSource();

			if (src instanceof FeatureInstance firstFeature) {
				FeatureInstance lastFeature = getLastFeature(etei);
				if (lastFeature != null) {
					match = isSameorContains(lastFeature, firstFeature);
				}
			}
		}
		return match;
	}

	/**
	 * Check whether a connection instance contains a declarative connection path as a contiguous sequence.
	 */
	private static boolean containsConnectionPath(ConnectionInstance connectionInstance,
			List<Connection> connectionPath) {
		if (connectionPath.isEmpty()) {
			return true;
		}

		EList<ConnectionReference> references = connectionInstance.getConnectionReferences();
		for (int start = 0; start <= references.size() - connectionPath.size(); start++) {
			boolean match = true;
			for (int offset = 0; match && offset < connectionPath.size(); offset++) {
				match = references.get(start + offset).getConnection() == connectionPath.get(offset);
			}
			if (match) {
				return true;
			}
		}
		return false;
	}

	private static boolean isSameOrRefinedConnection(Connection first, Connection second) {
		for (Connection connection = first; connection != null; connection = connection.getRefined()) {
			if (connection == second) {
				return true;
			}
		}
		for (Connection connection = second; connection != null; connection = connection.getRefined()) {
			if (connection == first) {
				return true;
			}
		}
		return false;
	}

	private static boolean isSameorContains(FeatureInstance flowFeature, FeatureInstance connFeature) {
		EObject matchme = connFeature;
		while (matchme instanceof FeatureInstance featureInstance) {
			if (featureInstance == flowFeature) {
				return true;
			}
			matchme = featureInstance.eContainer();
		}
		return false;
	}

	private static FeatureInstance getLastFeature(EndToEndFlowInstance etei) {
		EList<FlowElementInstance> feis = etei.getFlowElements();
		if (feis.isEmpty()) {
			return null;
		}

		return switch (feis.getLast()) {
		case EndToEndFlowInstance nested -> getLastFeature(nested);
		case FlowSpecificationInstance flowSpecification -> flowSpecification.getDestination();
		case ConnectionInstance connection -> connection.getDestination() instanceof FeatureInstance featureInstance
				? featureInstance
				: null;
		case null, default -> null;
		};
	}

	private static ConnectionInstanceEnd getFirstConnectionEnd(EndToEndFlowInstance etei) {
		EList<FlowElementInstance> elements = etei.getFlowElements();
		if (elements.isEmpty()) {
			return null;
		}

		return switch (elements.getFirst()) {
		case EndToEndFlowInstance nested -> getFirstConnectionEnd(nested);
		case FlowSpecificationInstance flowSpecification -> flowSpecification.getSource();
		case ConnectionInstance connection -> connection.getSource();
		case ComponentInstance component -> component;
		case null, default -> null;
		};
	}
}
