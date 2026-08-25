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
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.Mode;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;

/**
 * The mode arithmetic of end-to-end flow instantiation: which mode instances a declaration is constrained to, and which
 * system operation modes a flow instance ends up active in.
 * <p>
 * Both computations are reached through the protected {@code getModeInstances} and {@code fillinModes} methods of
 * {@code CreateEndToEndFlowsSwitch}, which remain the extension points a subclass overrides. Instantiation always calls
 * them through the switch, never the methods here directly, so an override still decides the outcome.
 * <p>
 * {@link #assignSystemOperationModes} needs a committed flow instance: it navigates to the system instance and asks flow
 * elements whether they are active in a system operation mode.
 */
public final class EndToEndFlowModes {

	private EndToEndFlowModes() {
	}

	/**
	 * Resolve an element's mode constraints relative to a component instance. If the element has no explicit modes, use
	 * the nearest containing component instance with inherited mode constraints.
	 *
	 * @param ci the component instance used to resolve modes
	 * @param e the modal declarative element
	 * @return list of mode instances
	 */
	public static EList<ModeInstance> modeInstances(ComponentInstance ci, ModalElement e) {
		EList<ModeInstance> mis = new BasicEList<>();
		var mlist = e.getAllInModes();

		if (!mlist.isEmpty()) {
			for (var m : mlist) {
				var mi = ci.findModeInstance(m);

				if (mi != null) {
					mis.add(mi);
				}
			}
		} else {
			// Get modes from the containment hierarchy.
			while (!(ci instanceof SystemInstance)) {
				if (ci.getInModes().isEmpty()) {
					ci = ci.getContainingComponentInstance();
				} else {
					mis = ci.getInModes();
					break;
				}
			}
		}
		return mis;
	}

	/**
	 * Compute the system operation modes a flow instance is active in from its elements and its accumulated mode
	 * constraints, and consume those constraints.
	 *
	 * @param etei the committed flow instance
	 */
	public static void assignSystemOperationModes(EndToEndFlowInstance etei) {

		if (etei.getSystemInstance().getSystemOperationModes().size() <= 1) {
			return;
		}

		// first, calculate intersection of all connection and ete instance SOMs
		var feis = etei.getFlowElements();
		var soms = new ArrayList<>(etei.getSystemInstance().getSystemOperationModes());

		for (var fei : feis) {
			if (fei instanceof ConnectionInstance conni) {
				if (!conni.getInSystemOperationModes().isEmpty()) {
					soms.removeIf(som -> !conni.getInSystemOperationModes().contains(som));
				}
			} else if (fei instanceof EndToEndFlowInstance efi) {
				if (!efi.getInSystemOperationModes().isEmpty()) {
					soms.removeIf(som -> !efi.getInSystemOperationModes().contains(som));
				}
			}
		}

		// then, keep those SOMs where all other flow elements are active
		for (var fei : feis) {
			if (fei instanceof FlowSpecificationInstance fsi) {
				soms.removeIf(som -> !fsi.isActive(som));
			} else if (fei instanceof ComponentInstance ci) {
				soms.removeIf(som -> !ci.isActive(som));
			}
		}

		// finally, keep those SOMs where the ete and used flow implementations are active
		for (var som : soms) {
			if (containsModeInstances(som, etei.getModesList())) {
				etei.getInSystemOperationModes().add(som);
			}
		}

		etei.getModesList().clear();
	}

	private static boolean containsModeInstances(SystemOperationMode som, List<EList<ModeInstance>> modeLists) {
		outer: for (List<ModeInstance> mis : modeLists) {
			if (!mis.isEmpty()) {
				for (var mi : mis) {
					if (som.getCurrentModes().contains(mi)) {
						continue outer;
					}
				}
				return false;
			}
		}
		return true;
	}
}
