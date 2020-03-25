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
package org.osate.analysis.resource.budgets.busload;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.modelsupport.modeltraversal.SOMIterator;
import org.osate.analysis.resource.budgets.busload.model.Bus;
import org.osate.analysis.resource.budgets.busload.model.BusLoadModel;
import org.osate.analysis.resource.budgets.busload.model.BusOrVirtualBus;
import org.osate.analysis.resource.budgets.busload.model.Connection;
import org.osate.analysis.resource.budgets.busload.model.VirtualBus;
import org.osate.analysis.resource.budgets.busload.model.Visitor;
import org.osate.ui.dialogs.Dialog;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

public class NewBusLoadAnalysis {
	private final String actionName;

	public NewBusLoadAnalysis(final String actionName) {
		this.actionName = actionName;
	}

	public void analysisBody(final IProgressMonitor monitor, final Element obj) {
		if (obj instanceof InstanceObject) {
			SystemInstance root = ((InstanceObject) obj).getSystemInstance();
			monitor.beginTask(actionName, IProgressMonitor.UNKNOWN);
			final SOMIterator soms = new SOMIterator(root);
			while (soms.hasNext()) {
				final SystemOperationMode som = soms.nextSOM();
				final BusLoadModel model = buildModel(root, som);

				System.out.println("Model for system operation mode " + som);
				System.out.println();

				model.visit(new Visitor() {
					private Deque<String> stack = new LinkedList<>();
					private String prefix = "";

					@Override
					public void visitConnection(final Connection c) {
						System.out.println(prefix + "Connection " + c.getConnectionInstance().getName());
					}

					@Override
					public void visitBusPrefix(final Bus b) {
						System.out.println(prefix + "Bus " + b.getBusInstance().getName());
						stack.addFirst(prefix);
						prefix = prefix + "  ";
					}

					@Override
					public void visitBusPostfix(final Bus b) {
						prefix = stack.removeFirst();
					}

					@Override
					public void visitVirtualBusPrefix(final VirtualBus b) {
						System.out.println(prefix + "Virtual Bus " + b.getBusInstance().getName());
						stack.addFirst(prefix);
						prefix = prefix + "  ";
					}

					@Override
					public void visitVirtualBusPostfix(final VirtualBus b) {
						prefix = stack.removeFirst();
					}
				});

				System.out.println();
				System.out.println("===============================================");
				System.out.println();

			}
			monitor.done();
		} else {
			Dialog.showError("Bound Bus Bandwidth Analysis Error", "Can only check system instances");
		}
	}

	private BusLoadModel buildModel(final SystemInstance root, final SystemOperationMode som) {
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

	private void addBus(final BusLoadModel model, final ComponentInstance bus, final SystemOperationMode som) {
		final Bus theBus = model.getBus(bus);
		model.addBus(theBus);
		addBusOrVirtualBus(model, theBus, bus, som);
	}

	private void addVirtualBus(final BusLoadModel model, final ComponentInstance vb, final SystemOperationMode som) {
		final VirtualBus theVirtualBus = model.getVirtualBus(vb);
		// Node will attached to the model by the (virtual) bus that it is bound to
		addBusOrVirtualBus(model, theVirtualBus, vb, som);
	}

	private void addBusOrVirtualBus(final BusLoadModel model, final BusOrVirtualBus bus, final ComponentInstance ci,
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

	private <E extends InstanceObject> List<E> filterInMode(final List<E> instanceObjects,
			final SystemOperationMode som) {
		final List<E> result = new ArrayList<>();
		for (final E io : instanceObjects) {
			if (io.isActive(som)) {
				result.add(io);
			}
		}
		return result;
	}

	private List<ConnectionInstance> filterSameSourceConnections(final List<ConnectionInstance> connections) {
		final List<ConnectionInstance> result = new ArrayList<>();
		for (final ConnectionInstance conni : connections) {
			if (!hasConnectionSource(result, conni)) {
				result.add(conni);
			}
		}
		return result;
	}

	private boolean hasConnectionSource(final List<ConnectionInstance> connections, final ConnectionInstance conni) {
		final ConnectionInstanceEnd src = conni.getSource();
		for (final ConnectionInstance connectionInstance : connections) {
			if (connectionInstance.getSource() == src) {
				return true;
			}
		}
		return false;
	}
}