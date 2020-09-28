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
package org.osate.analysis.resource.budgets.busload.model;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

/**
 * @since 3.0
 */
public final class BusLoadModel extends ModelElement {
	private final Map<ComponentInstance, Bus> buses = new HashMap<>();
	private final Map<ComponentInstance, VirtualBus> virtualBuses = new HashMap<>();

	private final List<Bus> rootBuses = new ArrayList<>();

	/**
	 * Use {@link #buildModel(SystemInstance, SystemOperationMode)} to get an instance of the
	 * model.
	 */
	private BusLoadModel() {
		super();
	}

	private Bus getBus(final ComponentInstance ci) {
		if (ci.getCategory() != ComponentCategory.BUS) {
			throw new IllegalArgumentException("Component instance is not a bus");
		}
		Bus bus = buses.get(ci);
		if (bus == null) {
			bus = new Bus(ci);
			buses.put(ci, bus);
		}
		return bus;
	}

	private VirtualBus getVirtualBus(final ComponentInstance ci) {
		if (ci.getCategory() != ComponentCategory.VIRTUAL_BUS) {
			throw new IllegalArgumentException("Component instance is not a virtual bus");
		}
		VirtualBus vb = virtualBuses.get(ci);
		if (vb == null) {
			vb = new VirtualBus(ci);
			virtualBuses.put(ci, vb);
		}
		return vb;
	}

	void addBus(final Bus bus) {
		rootBuses.add(bus);
	}

	public Iterable<Bus> getRootBuses() {
		return rootBuses;
	}

	@Override
	void visitSelfPrefix(final Visitor visitor) {
		visitor.visitModelPrefix(this);
	}

	@Override
	void visitChildren(final Visitor visitor) {
		visit(rootBuses, visitor);
	}

	@Override
	void visitSelfPostfix(final Visitor visitor) {
		visitor.visitModelPostfix(this);
	}

	public void print(final PrintWriter pw) {
		visit(new Visitor() {
			private Deque<String> stack = new LinkedList<>();
			private String prefix = "";

			@Override
			public void visitConnection(final Connection c) {
				pw.println(prefix + "Connection " + c.getConnectionInstance().getName());
				stack.push(prefix);
				prefix = prefix + "  ";
				pw.println(prefix + "Budget = " + c.getBudget() + " KB/s");
				pw.println(prefix + "Actual usage = " + c.getActual() + " KB/s");
				prefix = stack.pop();
			}

			@Override
			public void visitBroadcastPrefix(final Broadcast b) {
				pw.println(prefix + "Broadcast from " + b.getSource().getName());
				stack.push(prefix);
				prefix = prefix + "  ";
				pw.println(prefix + "Budget = " + b.getBudget() + " KB/s");
				pw.println(prefix + "Actual usage = " + b.getActual() + " KB/s");
			}

			@Override
			public void visitBroadcastPostfix(final Broadcast b) {
				prefix = stack.pop();
			}

			@Override
			public void visitBusPrefix(final Bus b) {
				pw.println(prefix + "Bus " + b.getBusInstance().getName());
				stack.push(prefix);
				prefix = prefix + "  ";
				pw.println(prefix + "Capacity = " + b.getCapacity() + " KB/s");
				pw.println(prefix + "Budget = " + b.getBudget() + " KB/s");
				pw.println(prefix + "Required budget = " + b.getTotalBudget() + " KB/s");
				pw.println(prefix + "Actual usage = " + b.getActual() + " KB/s");
			}

			@Override
			public void visitBusPostfix(final Bus b) {
				prefix = stack.pop();
			}

			@Override
			public void visitVirtualBusPrefix(final VirtualBus b) {
				pw.println(prefix + "Virtual Bus " + b.getBusInstance().getName());
				stack.push(prefix);
				prefix = prefix + "  ";
				pw.println(prefix + "Capacity = " + b.getCapacity() + " KB/s");
				pw.println(prefix + "Budget = " + b.getBudget() + " KB/s");
				pw.println(prefix + "Required budget = " + b.getTotalBudget() + " KB/s");
				pw.println(prefix + "Actual usage = " + b.getActual() + " KB/s");
			}

			@Override
			public void visitVirtualBusPostfix(final VirtualBus b) {
				prefix = stack.pop();
			}
		});
	}

	// ==== Methods to build the model ====

	public static BusLoadModel buildModel(final SystemInstance root, final SystemOperationMode som) {
		final BusLoadModel model = new BusLoadModel();
		final ForAllElement mal = new ForAllElement() {
			@Override
			protected void process(final Element obj) {
				final ComponentInstance ci = (ComponentInstance) obj;
				final ComponentCategory cat = ci.getCategory();
				if (cat == ComponentCategory.BUS) {
					addBus(model, ci, som);
				} else if (cat == ComponentCategory.VIRTUAL_BUS) {
					addVirtualBus(model, ci, som);
				}
			}
		};
		mal.processPreOrderComponentInstance(root);
		return model;
	}

	private static void addBus(final BusLoadModel model, final ComponentInstance bus, final SystemOperationMode som) {
		final Bus theBus = model.getBus(bus);
		model.addBus(theBus);
		addBusOrVirtualBus(model, theBus, bus, som);
	}

	private static void addVirtualBus(final BusLoadModel model, final ComponentInstance vb,
			final SystemOperationMode som) {
		final VirtualBus theVirtualBus = model.getVirtualBus(vb);
		// Node will attached to the model by the (virtual) bus that it is bound to
		addBusOrVirtualBus(model, theVirtualBus, vb, som);
	}

	private static void addBusOrVirtualBus(final BusLoadModel model, final BusOrVirtualBus bus,
			final ComponentInstance ci,
			final SystemOperationMode som) {
		final boolean isBroadcast = GetProperties.isBroadcastProtocol(ci);
		List<ConnectionInstance> budgetedConnections = InstanceModelUtil.getBoundConnections(ci);
		List<ComponentInstance> budgetedVBs = InstanceModelUtil.getBoundVirtualBuses(ci);

		// Make sure the connections exist in the current mode
		budgetedConnections = filterInMode(budgetedConnections, som);

		/*
		 * If the bus is broadcast only send a message from each source feature once. So we only keep one connection
		 * for each source feature.
		 */
		if (isBroadcast) {
			budgetedConnections = findBroadcasts(budgetedConnections, bus);
		}

		// Make sure the virtual buses exist in the current mode
		budgetedVBs = filterInMode(budgetedVBs, som);

		budgetedConnections.forEach(connection -> bus.addBoundConnection(connection));
		budgetedVBs.forEach(vb -> bus.addBoundBus(model.getVirtualBus(vb)));
	}

	private static <E extends InstanceObject> List<E> filterInMode(final List<E> instanceObjects,
			final SystemOperationMode som) {
		final List<E> result = new ArrayList<>();
		for (final E io : instanceObjects) {
			if (io.isActive(som)) {
				result.add(io);
			}
		}
		return result;
	}

	private static final class FeatureComparator implements Comparator<ConnectionInstanceEnd> {
		public static final FeatureComparator INSTANCE = new FeatureComparator();

		private FeatureComparator() {
			super();
		}

		@Override
		public int compare(final ConnectionInstanceEnd o1, final ConnectionInstanceEnd o2) {
			final String name1 = o1.getInstanceObjectPath();
			final String name2 = o2.getInstanceObjectPath();
			return name1.compareTo(name2);
		}
	}

	/*
	 * Build go through the list of connections and sort based on the connection source. For each
	 * group, create a new Broadcast child of the bus. Returns the list of remaining individual connections.
	 */
	private static List<ConnectionInstance> findBroadcasts(final List<ConnectionInstance> connections,
			final BusOrVirtualBus bus) {
		// Linked list is better for removals, below
		final List<ConnectionInstance> nonBroadcast = new LinkedList<>(connections);

		// Group all the connections by their source feature
		final Map<ConnectionInstanceEnd, List<ConnectionInstance>> broadcastGroups = new TreeMap<>(
				FeatureComparator.INSTANCE);
		for (final ConnectionInstance ci : connections) {
			final ConnectionInstanceEnd src = ci.getSource();
			List<ConnectionInstance> list = broadcastGroups.get(src);
			if (list == null) {
				list = new ArrayList<ConnectionInstance>();
				broadcastGroups.put(src, list);
			}
			list.add(ci);
		}

		/*
		 * Create a Broadcast object for each group with size > 1, and then remove the
		 * connections from the noBroadcast list. We do this, instead of building a new
		 * list with the groups of size 1 so that the order of the list remains deterministic
		 * and not influencing by hashing in the map.
		 *
		 * So we should have alphabetical order for the broadcast groups (from the TreeMap)
		 * and declarative order for the singletons.
		 */
		for (final Map.Entry<ConnectionInstanceEnd, List<ConnectionInstance>> group : broadcastGroups.entrySet()) {
			final ConnectionInstanceEnd groupSource = group.getKey();
			final List<ConnectionInstance> groupedConnections = group.getValue();
			if (groupedConnections.size() > 1) {
				nonBroadcast.removeAll(groupedConnections);
				final Broadcast broadcast = new Broadcast(groupSource);
				groupedConnections.forEach(c -> broadcast.addConnection(c));
				bus.addBoundBroadcast(broadcast);
			}
		}

		return nonBroadcast;
	}
}
