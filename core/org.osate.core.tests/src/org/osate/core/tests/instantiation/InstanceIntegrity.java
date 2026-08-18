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
package org.osate.core.tests.instantiation;

import static org.osate.aadl2.instance.ConnectionKind.MODE_TRANSITION_CONNECTION;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.SystemInstance;

/**
 * Structural invariants that must hold for every instantiated model, regardless
 * of which connection-traversal strategy produced it.
 *
 * <p>
 * Each check returns a human-readable violation rather than asserting directly,
 * so that a characterization run can report the complete set of problems for one
 * model instead of stopping at the first one.
 * </p>
 */
public final class InstanceIntegrity {

	private InstanceIntegrity() {
	}

	/**
	 * Check every invariant and return one message per violation. An empty list
	 * means the model is structurally sound.
	 *
	 * <p>
	 * Every root in the instance resource is checked. A feature whose classifier resolves to
	 * a component classifier gets that classifier instantiated as a further root beside the
	 * system instance, and its connections come from the same pipeline, so the same
	 * invariants hold for it.
	 * </p>
	 */
	public static List<String> check(SystemInstance instance) {
		List<String> violations = new ArrayList<>();
		checkRoot(instance, violations);
		for (EObject root : instance.eResource().getContents()) {
			if (root instanceof ComponentInstance referenced && referenced != instance) {
				checkRoot(referenced, violations);
			}
		}
		Collections.sort(violations);
		return List.copyOf(violations);
	}

	private static void checkRoot(ComponentInstance root, List<String> violations) {
		Set<ConnectionInstance> contained = containedConnections(root);

		for (ConnectionInstance connection : contained) {
			checkEndpoints(connection, violations);
			checkReferenceChain(connection, violations);
			checkAcrossCount(connection, violations);
			checkKindAndFlags(connection, violations);
		}
		checkInverseLists(root, contained, violations);
		checkFlowMembership(root, contained, violations);
	}

	/**
	 * Every connection instance actually attached to the model. Provisional
	 * connections deleted by structural expansion are, by construction, not here.
	 */
	public static Set<ConnectionInstance> containedConnections(ComponentInstance instance) {
		Set<ConnectionInstance> contained = Collections.newSetFromMap(new IdentityHashMap<>());
		collectContained(instance, contained);
		return contained;
	}

	private static void collectContained(ComponentInstance container, Set<ConnectionInstance> contained) {
		contained.addAll(container.getConnectionInstances());
		for (ComponentInstance child : container.getComponentInstances()) {
			collectContained(child, contained);
		}
	}

	private static void checkEndpoints(ConnectionInstance connection, List<String> violations) {
		if (connection.getSource() == null) {
			violations.add(describe(connection) + ": source is null");
		}
		if (connection.getDestination() == null) {
			violations.add(describe(connection) + ": destination is null");
		}
	}

	private static void checkReferenceChain(ConnectionInstance connection, List<String> violations) {
		List<ConnectionReference> references = connection.getConnectionReferences();
		if (references.isEmpty()) {
			violations.add(describe(connection) + ": has no connection references");
			return;
		}
		for (int i = 0; i < references.size() - 1; i++) {
			ConnectionInstanceEnd end = references.get(i).getDestination();
			ConnectionInstanceEnd next = references.get(i + 1).getSource();
			if (!samePoint(end, next)) {
				violations.add(describe(connection) + ": reference chain breaks between index " + i + " and " + (i + 1)
						+ " (" + InstanceKeys.instance(end) + " != " + InstanceKeys.instance(next) + ")");
			}
		}
		ConnectionInstanceEnd first = references.get(0).getSource();
		ConnectionInstanceEnd last = references.get(references.size() - 1).getDestination();
		if (!samePoint(connection.getSource(), first)) {
			violations.add(describe(connection) + ": source does not match first reference source ("
					+ InstanceKeys.instance(connection.getSource()) + " != " + InstanceKeys.instance(first) + ")");
		}
		if (!samePoint(connection.getDestination(), last)) {
			violations.add(describe(connection) + ": destination does not match last reference destination ("
					+ InstanceKeys.instance(connection.getDestination()) + " != " + InstanceKeys.instance(last) + ")");
		}
	}

	/**
	 * Whether two ends describe the same point on a path.
	 *
	 * <p>
	 * A reference may name a feature group where the connection names the member of it that
	 * the connection actually connects, so one end nested in the other is the same point at
	 * a different granularity. That is not an across-first choice: structural expansion
	 * re-resolves a replicated connection's reference endpoints from the declaration, which
	 * names the group, while the connection keeps the member. Both strategies produce it,
	 * identically, for every connection replicated across a component array through a
	 * feature group.
	 * </p>
	 */
	private static boolean samePoint(ConnectionInstanceEnd one, ConnectionInstanceEnd other) {
		return one == other || nestedIn(one, other) || nestedIn(other, one);
	}

	private static boolean nestedIn(ConnectionInstanceEnd inner, ConnectionInstanceEnd outer) {
		for (EObject owner = inner == null ? null : inner.eContainer(); owner instanceof FeatureInstance feature; owner = feature
				.eContainer()) {
			if (feature == outer) {
				return true;
			}
		}
		return false;
	}

	private static void checkAcrossCount(ConnectionInstance connection, List<String> violations) {
		long across = connection.getConnectionReferences()
				.stream()
				.filter(reference -> reference.getConnection() != null && reference.getConnection().isAcross())
				.count();
		long expected = connection.isComplete() ? 1 : 0;
		if (across != expected) {
			violations.add(describe(connection) + ": complete=" + connection.isComplete() + " but has " + across
					+ " across segments, expected " + expected);
		}
	}

	private static void checkKindAndFlags(ConnectionInstance connection, List<String> violations) {
		if (connection.getKind() == MODE_TRANSITION_CONNECTION) {
			violations.add(describe(connection) + ": is a mode transition connection");
		}
		if (connection.getSource() instanceof ModeTransitionInstance
				|| connection.getDestination() instanceof ModeTransitionInstance) {
			violations.add(describe(connection) + ": has a mode transition instance endpoint");
		}
		if (connection.isBidirectional()) {
			violations.add(describe(connection) + ": bidirectional flag is true");
		}
	}

	private static void checkInverseLists(ComponentInstance instance, Set<ConnectionInstance> contained,
			List<String> violations) {
		for (ConnectionInstance connection : contained) {
			ConnectionInstanceEnd source = connection.getSource();
			if (source != null && !containsIdentical(source.getSrcConnectionInstances(), connection)) {
				violations.add(describe(connection) + ": missing from srcConnectionInstances of "
						+ InstanceKeys.instance(source));
			}
			ConnectionInstanceEnd destination = connection.getDestination();
			if (destination != null && !containsIdentical(destination.getDstConnectionInstances(), connection)) {
				violations.add(describe(connection) + ": missing from dstConnectionInstances of "
						+ InstanceKeys.instance(destination));
			}
		}
		for (TreeIterator<EObject> all = instance.eAllContents(); all.hasNext();) {
			EObject next = all.next();
			if (!(next instanceof ConnectionInstanceEnd end)) {
				continue;
			}
			for (ConnectionInstance connection : end.getSrcConnectionInstances()) {
				if (!contained.contains(connection)) {
					violations.add(InstanceKeys.instance(end) + ": srcConnectionInstances references the uncontained "
							+ describe(connection));
				}
			}
			for (ConnectionInstance connection : end.getDstConnectionInstances()) {
				if (!contained.contains(connection)) {
					violations.add(InstanceKeys.instance(end) + ": dstConnectionInstances references the uncontained "
							+ describe(connection));
				}
			}
		}
	}

	private static void checkFlowMembership(ComponentInstance instance, Set<ConnectionInstance> contained,
			List<String> violations) {
		for (TreeIterator<EObject> all = instance.eAllContents(); all.hasNext();) {
			EObject next = all.next();
			if (!(next instanceof EndToEndFlowInstance flow)) {
				continue;
			}
			for (FlowElementInstance element : flow.getFlowElements()) {
				if (element instanceof ConnectionInstance connection && !contained.contains(connection)) {
					violations.add("flow " + flow.getInstanceObjectPath() + ": references the uncontained "
							+ describe(connection));
				}
			}
		}
	}

	private static boolean containsIdentical(List<ConnectionInstance> connections, ConnectionInstance connection) {
		for (ConnectionInstance candidate : connections) {
			if (candidate == connection) {
				return true;
			}
		}
		return false;
	}

	private static String describe(ConnectionInstance connection) {
		ComponentInstance container = connection.getContainingComponentInstance();
		String containerPath = container == null ? InstanceKeys.NULL_KEY : container.getInstanceObjectPath();
		return "connection '" + connection.getName() + "' in " + containerPath;
	}
}
