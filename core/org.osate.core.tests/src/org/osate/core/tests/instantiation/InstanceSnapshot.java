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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;

/**
 * A complete normalized view of one instantiated model.
 *
 * <p>
 * This is the unit of comparison for connection-traversal characterization. It
 * deliberately describes only the materialized, publicly reachable instance
 * model plus diagnostics — never internal traversal state — so that the same
 * comparison applies to any traversal strategy.
 * </p>
 *
 * <p>
 * Per-container lists preserve <em>collection order</em>, because that order is
 * an approved intended difference that has to be recorded and checked for
 * determinism. Semantic comparison must use {@link #connectionsByKey()} and
 * {@link #flowsByKey()}, which are order-independent keyed multisets.
 * </p>
 */
public record InstanceSnapshot(Map<String, List<ConnectionDescriptor>> connectionsByContainer,
		Map<String, List<FlowDescriptor>> flowsByContainer, List<DiagnosticDescriptor> diagnostics) {

	public InstanceSnapshot {
		connectionsByContainer = Map.copyOf(connectionsByContainer);
		flowsByContainer = Map.copyOf(flowsByContainer);
		diagnostics = List.copyOf(diagnostics);
	}

	/** Snapshot an instantiated model together with the diagnostics it produced. */
	public static InstanceSnapshot of(SystemInstance instance, AnalysisErrorReporterManager manager) {
		Map<String, List<ConnectionDescriptor>> connections = new LinkedHashMap<>();
		Map<String, List<FlowDescriptor>> flows = new LinkedHashMap<>();
		collect(instance, connections, flows);
		return new InstanceSnapshot(connections, flows,
				DiagnosticDescriptor.of(manager, instance.eResource()));
	}

	private static void collect(ComponentInstance container, Map<String, List<ConnectionDescriptor>> connections,
			Map<String, List<FlowDescriptor>> flows) {
		String containerKey = InstanceKeys.instance(container);

		List<ConnectionDescriptor> containedConnections = new ArrayList<>();
		for (ConnectionInstance connection : container.getConnectionInstances()) {
			containedConnections.add(ConnectionDescriptor.of(container, connection));
		}
		connections.put(containerKey, List.copyOf(containedConnections));

		List<FlowDescriptor> containedFlows = new ArrayList<>();
		for (EndToEndFlowInstance flow : container.getEndToEndFlows()) {
			containedFlows.add(FlowDescriptor.of(container, flow));
		}
		flows.put(containerKey, List.copyOf(containedFlows));

		for (ComponentInstance child : container.getComponentInstances()) {
			collect(child, connections, flows);
		}
	}

	/** Every connection descriptor in the model, in per-container collection order. */
	public List<ConnectionDescriptor> allConnections() {
		return connectionsByContainer.values().stream().flatMap(List::stream).toList();
	}

	/** Every flow descriptor in the model, in per-container collection order. */
	public List<FlowDescriptor> allFlows() {
		return flowsByContainer.values().stream().flatMap(List::stream).toList();
	}

	/**
	 * Order-independent multiset of connections keyed by structured identity. This
	 * is the correct basis for semantic comparison between traversal strategies.
	 */
	public Map<ConnectionDescriptor.Key, List<ConnectionDescriptor>> connectionsByKey() {
		return allConnections().stream().collect(Collectors.groupingBy(ConnectionDescriptor::key));
	}

	/** Order-independent multiset of end-to-end flows keyed by structured identity. */
	public Map<FlowDescriptor.Key, List<FlowDescriptor>> flowsByKey() {
		return allFlows().stream().collect(Collectors.groupingBy(FlowDescriptor::key));
	}

	/**
	 * Per-container connection names in collection order. Used to record the
	 * approved ordering difference and to check determinism within one strategy;
	 * never used as identity.
	 */
	public Map<String, List<String>> connectionOrderByContainer() {
		Map<String, List<String>> order = new LinkedHashMap<>();
		connectionsByContainer.forEach((container, descriptors) -> order.put(container,
				descriptors.stream().map(ConnectionDescriptor::name).toList()));
		return order;
	}

	/** Per-container end-to-end flow names in collection order. */
	public Map<String, List<String>> flowOrderByContainer() {
		Map<String, List<String>> order = new LinkedHashMap<>();
		flowsByContainer.forEach((container, descriptors) -> order.put(container,
				descriptors.stream().map(descriptor -> descriptor.key().name()).toList()));
		return order;
	}
}
