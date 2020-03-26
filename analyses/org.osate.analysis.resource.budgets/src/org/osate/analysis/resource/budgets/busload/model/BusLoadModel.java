package org.osate.analysis.resource.budgets.busload.model;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

	// may not need this?
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
			}

			@Override
			public void visitBusPrefix(final Bus b) {
				pw.println(prefix + "Bus " + b.getBusInstance().getName());
				stack.push(prefix);
				prefix = prefix + "  ";
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
			budgetedConnections = filterSameSourceConnections(budgetedConnections);
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

	private static List<ConnectionInstance> filterSameSourceConnections(final List<ConnectionInstance> connections) {
		final List<ConnectionInstance> result = new ArrayList<>();
		for (final ConnectionInstance conni : connections) {
			if (!hasConnectionSource(result, conni)) {
				result.add(conni);
			}
		}
		return result;
	}

	private static boolean hasConnectionSource(final List<ConnectionInstance> connections,
			final ConnectionInstance conni) {
		final ConnectionInstanceEnd src = conni.getSource();
		for (final ConnectionInstance connectionInstance : connections) {
			if (connectionInstance.getSource() == src) {
				return true;
			}
		}
		return false;
	}
}
