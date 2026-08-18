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

import java.util.Comparator;
import java.util.List;

import org.osate.aadl2.Connection;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.EndToEndFlowInstance;

/**
 * Finds a connection instance or an end-to-end flow instance in a component instance without
 * using its position in the collection.
 *
 * <p>
 * A test that reaches for {@code getConnectionInstances().get(2)} says nothing about which
 * connection it means, and it holds the instantiator to an order that is not part of the
 * model: the order follows how the traversal happened to enumerate, so it changes when the
 * traversal does. Looking a connection up by what it connects keeps the assertion about the
 * model. The order of elements <em>within</em> one connection or one flow is semantic and is
 * not what this is about.
 * </p>
 *
 * <p>
 * Names are not unique in general, because a connection is named after its endpoint paths
 * relative to its container and two distinct semantic paths can share an endpoint pair, so
 * {@link #connection(ComponentInstance, String)} fails rather than choose when a name matches
 * more than once. {@link #connectionBetween(ComponentInstance, String, String)} is the way out
 * for the cases that need it.
 * </p>
 */
public final class InstanceLookup {

	private InstanceLookup() {
	}

	/** The one connection instance of {@code container} with this name. */
	public static ConnectionInstance connection(ComponentInstance container, String name) {
		List<ConnectionInstance> matches = container.getConnectionInstances()
				.stream()
				.filter(connection -> name.equals(connection.getName()))
				.toList();
		if (matches.size() == 1) {
			return matches.get(0);
		}
		throw new AssertionError(matches.isEmpty()
				? "No connection instance named '" + name + "' in " + container.getInstanceObjectPath() + ", only "
						+ connectionNames(container)
				: matches.size() + " connection instances named '" + name + "' in "
						+ container.getInstanceObjectPath() + "; look it up by its endpoints instead");
	}

	/** The one connection instance of {@code container} between these two instance object paths. */
	public static ConnectionInstance connectionBetween(ComponentInstance container, String sourcePath,
			String destinationPath) {
		List<ConnectionInstance> matches = container.getConnectionInstances()
				.stream()
				.filter(connection -> sourcePath.equals(path(connection.getSource()))
						&& destinationPath.equals(path(connection.getDestination())))
				.toList();
		if (matches.size() == 1) {
			return matches.get(0);
		}
		throw new AssertionError(matches.size() + " connection instances from " + sourcePath + " to " + destinationPath
				+ " in " + container.getInstanceObjectPath() + ", which has " + connectionNames(container));
	}

	/** The one end-to-end flow instance of {@code container} with this name. */
	public static EndToEndFlowInstance flow(ComponentInstance container, String name) {
		List<EndToEndFlowInstance> matches = container.getEndToEndFlows()
				.stream()
				.filter(flow -> name.equals(flow.getName()))
				.toList();
		if (matches.size() == 1) {
			return matches.get(0);
		}
		throw new AssertionError(matches.isEmpty()
				? "No end-to-end flow named '" + name + "' in " + container.getInstanceObjectPath() + ", only "
						+ flowNames(container)
				: matches.size() + " end-to-end flows named '" + name + "' in " + container.getInstanceObjectPath());
	}

	/**
	 * The one connection instance of {@code container} that traverses exactly these
	 * declarations, in this order.
	 *
	 * <p>
	 * The ordered declarations are the identity of a semantic connection: two orientations of
	 * one bidirectional path traverse the same declarations in opposite order, and two paths
	 * between the same endpoints differ in which declarations they use.
	 * </p>
	 */
	public static ConnectionInstance connectionThrough(ComponentInstance container, Connection... declarations) {
		List<Connection> wanted = List.of(declarations);
		List<ConnectionInstance> matches = container.getConnectionInstances()
				.stream()
				.filter(connection -> declarationsOf(connection).equals(wanted))
				.toList();
		if (matches.size() == 1) {
			return matches.get(0);
		}
		throw new AssertionError(matches.size() + " connection instances in " + container.getInstanceObjectPath()
				+ " traverse " + wanted.stream().map(Connection::getName).toList() + ", which has "
				+ container.getConnectionInstances()
						.stream()
						.map(connection -> connection.getName() + " through "
								+ declarationsOf(connection).stream().map(Connection::getName).toList())
						.toList());
	}

	/**
	 * The one connection instance of {@code container} that traverses this many declarations.
	 * For a container holding one short connection and one long one, where the length of the
	 * chain is what tells them apart.
	 */
	public static ConnectionInstance connectionWithReferenceCount(ComponentInstance container, int references) {
		List<ConnectionInstance> matches = container.getConnectionInstances()
				.stream()
				.filter(connection -> connection.getConnectionReferences().size() == references)
				.toList();
		if (matches.size() == 1) {
			return matches.get(0);
		}
		throw new AssertionError(matches.size() + " connection instances in " + container.getInstanceObjectPath()
				+ " have " + references + " connection references, out of " + connectionNames(container));
	}

	private static List<Connection> declarationsOf(ConnectionInstance connection) {
		return connection.getConnectionReferences().stream().map(ConnectionReference::getConnection).toList();
	}

	/**
	 * The connection instances of {@code container} in an order derived from the model rather
	 * than from the order the traversal created them in: by name, then by the declarations they
	 * traverse, then by their endpoints.
	 *
	 * <p>
	 * For a test that says "the two of them" rather than naming one, and whose assertion holds
	 * whichever of the two comes first. Indexing this list is stable across a change of
	 * traversal strategy, where indexing the containment list is not.
	 * </p>
	 */
	public static List<ConnectionInstance> connectionsInStableOrder(ComponentInstance container) {
		return container.getConnectionInstances().stream().sorted(Comparator.comparing(InstanceLookup::sortKey)).toList();
	}

	private static String sortKey(ConnectionInstance connection) {
		StringBuilder key = new StringBuilder(String.valueOf(connection.getName()));
		for (ConnectionReference reference : connection.getConnectionReferences()) {
			key.append('|')
					.append(reference.getConnection() == null ? "?" : reference.getConnection().getName())
					.append(reference.isReverse() ? "(r)" : "(f)");
		}
		return key.append('|').append(path(connection.getSource())).append("->").append(path(connection.getDestination()))
				.toString();
	}

	/**
	 * The one connection instance {@code container} contains. For a container that has exactly
	 * one, which is where an index says nothing about which connection is meant and the count
	 * is the real assertion.
	 */
	public static ConnectionInstance onlyConnection(ComponentInstance container) {
		List<ConnectionInstance> connections = container.getConnectionInstances();
		if (connections.size() == 1) {
			return connections.get(0);
		}
		throw new AssertionError("Expected one connection instance in " + container.getInstanceObjectPath()
				+ ", but found " + connectionNames(container));
	}

	/** The one end-to-end flow instance {@code container} contains. */
	public static EndToEndFlowInstance onlyFlow(ComponentInstance container) {
		List<EndToEndFlowInstance> flows = container.getEndToEndFlows();
		if (flows.size() == 1) {
			return flows.get(0);
		}
		throw new AssertionError("Expected one end-to-end flow in " + container.getInstanceObjectPath()
				+ ", but found " + flowNames(container));
	}

	/** The names of the connection instances {@code container} contains, sorted. */
	public static List<String> connectionNames(ComponentInstance container) {
		return container.getConnectionInstances().stream().map(ConnectionInstance::getName).sorted().toList();
	}

	/** The names of the end-to-end flows {@code container} contains, sorted. */
	public static List<String> flowNames(ComponentInstance container) {
		return container.getEndToEndFlows().stream().map(EndToEndFlowInstance::getName).sorted().toList();
	}

	private static String path(ConnectionInstanceEnd end) {
		return end == null ? null : end.getInstanceObjectPath();
	}
}
