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
package org.osate.analysis.resource.budgets.internal.busload.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class NotBoundModel {
	private final List<Processor> rootProcessors = new ArrayList<>();
	private final Map<ComponentInstance, Processor> processors = new HashMap<>();

	private int resources = 0;
	private int capacityResources = 0;
	/*
	 * Use {@link #buildModel(SystemInstance, SystemOperationMode)} to get an instance of the
	 * model.
	 */
	public NotBoundModel() {
		super();
	}

	private Processor getProcessor(final ComponentInstance ci, String somName) {
		if (ci.getCategory() != ComponentCategory.PROCESSOR) {
			throw new IllegalArgumentException("Component instance is not a processor");
		}
		Processor proc = processors.get(ci);
		if (proc == null) {
			proc = new Processor(ci, somName);
			processors.put(ci, proc);
		}
		return proc;
	}

	// ==== Methods to build the model ====

	public static NotBoundModel buildModel(final SystemInstance root, final SystemOperationMode som) {
		final NotBoundModel model = new NotBoundModel();
		final ForAllElement mal = new ForAllElement() {
			@Override
			protected void process(final Element obj) {
				final ComponentInstance ci = (ComponentInstance) obj;
				final ComponentCategory cat = ci.getCategory();
				if (cat == ComponentCategory.PROCESSOR) {
					UnitLiteral mipsliteral = GetProperties.getMIPSUnitLiteral(root);

					@SuppressWarnings("unchecked")
					EList<ComponentInstance> proclist = (EList<ComponentInstance>) (EList<?>) new ForAllElement()
							.processPreOrderComponentInstance(root, ComponentCategory.PROCESSOR);
					double capacity = sumCapacity(proclist, ResourceKind.MIPS, "processor", mipsliteral);
					proclist.forEach(comp -> {
						addProcessor(model, comp, som);
					});

				} else if (cat == ComponentCategory.VIRTUAL_BUS) {
					// addVirtualBus(model, ci, som);
				}
			}
		};
		mal.processPreOrderComponentInstance(root);
		return model;
	}

	private static void addProcessor(final NotBoundModel model, final ComponentInstance ci,
			final SystemOperationMode som) {
		final Processor theProcessor = model.getProcessor(ci, Aadl2Util.getPrintableSOMName(som));
		model.addProcessor(theProcessor);
	}

	void addProcessor(final Processor proc) {
		rootProcessors.add(proc);
	}

	public Iterable<Processor> getProcessors() {
		return rootProcessors;
	}

	protected enum ResourceKind {
		MIPS, RAM, ROM, Memory
	}

	private double sumCapacity(EList<ComponentInstance> ilist, ResourceKind rk, String resourceName, UnitLiteral unit) {
		double total = 0.0;
		for (ComponentInstance io : ilist) {
			double capacity = getCapacity(io, rk, unit);
			total += capacity;
			// detailedLogTotal1(io, capacity, unit);
			resources++;
			if (capacity > 0) {
				capacityResources++; // might need to be moved into child model
			}
		}
		return total;
	}

	private double getCapacity(ComponentInstance ne, ResourceKind kind, UnitLiteral unit) {
		switch (kind) {
		case MIPS:
			if (ne.getCategory().equals(ComponentCategory.PROCESSOR)) {
				return GetProperties.getProcessorMIPS(ne);
			}
			if (ne.getCategory().equals(ComponentCategory.VIRTUAL_PROCESSOR)) {
				return GetProperties.getMIPSBudgetInMIPS(ne);
			}
		case RAM:
			return GetProperties.getRAMCapacityInKB(ne, 0.0);
		case ROM:
			return GetProperties.getROMCapacityInKB(ne, 0.0);
		case Memory:
			return GetProperties.getMemorySize(ne, unit);
		}
		return 0.0;
	}
}