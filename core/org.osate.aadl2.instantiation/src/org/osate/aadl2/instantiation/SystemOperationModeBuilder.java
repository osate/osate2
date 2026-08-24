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
package org.osate.aadl2.instantiation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceFactory;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;

/**
 * Enumerates the system operation modes of an instance model: every combination of one mode per modal
 * component that the mode maps of the model allow. A component that is not active in the mode of its
 * containing component contributes no mode of its own to a combination.
 * <p>
 * A system with no modal component at all gets the single system operation mode
 * {@link InstantiateModel#NORMAL_SOM_NAME}.
 * <p>
 * The number of combinations grows with the product of the mode counts, so enumeration stops at a
 * limit. One builder enumerates the modes of one system instance once.
 */
class SystemOperationModeBuilder {
	private final SystemInstance root;
	private final int limit;
	private final Map<ModeInstance, List<SystemOperationMode>> mode2som;
	private final AnalysisErrorReporterManager errManager;
	private final IProgressMonitor monitor;

	/**
	 * The modal components of the instance model, in the order a depth first walk finds them. The state
	 * of every node is the mode it currently contributes, so a node is one digit of the combination the
	 * recursion is at.
	 */
	private final List<Node> workState = new ArrayList<>();

	/** The number of modal components, which is the number of digits of a combination. */
	private int modalCount;

	/** The number of system operation modes created so far, which is also the number of the next one. */
	private int somCount;

	/** Whether the limit stopped the enumeration, leaving the list of system operation modes partial. */
	private boolean limitReached;

	/**
	 * A modal component instance and the mode it contributes to the combination the enumeration is
	 * currently at. Both fields change as the enumeration proceeds, so this is not a record.
	 */
	private static final class Node {
		private final ComponentInstance ci;
		private final Node parentNode;
		private State state;

		private Node(ComponentInstance ci, Node parentNode) {
			this.ci = ci;
			this.parentNode = parentNode;
		}
	}

	/**
	 * The contribution of one modal component to the combination the enumeration is currently at: the
	 * mode it is in, or that it is not active at all, in which case the mode is ignored.
	 */
	private static final class State {
		private final boolean active;
		private ModeInstance mode;

		private State(boolean active) {
			this.active = active;
		}
	}

	/**
	 * @param root the system instance to enumerate the system operation modes of
	 * @param limit the maximum number of system operation modes to create
	 * @param mode2som the map from a mode instance to the system operation modes that contain it, which
	 *            this builder fills in
	 * @param errManager the error manager to report an incomplete enumeration to
	 * @param monitor the progress monitor
	 */
	SystemOperationModeBuilder(SystemInstance root, int limit,
			Map<ModeInstance, List<SystemOperationMode>> mode2som, AnalysisErrorReporterManager errManager,
			IProgressMonitor monitor) {
		this.root = root;
		this.limit = limit;
		this.mode2som = mode2som;
		this.errManager = errManager;
		this.monitor = monitor;
	}

	/**
	 * Create the system operation modes of the system instance and report it if the limit cut the
	 * enumeration short.
	 *
	 * @throws InterruptedException if instantiation is canceled
	 */
	void createSystemOperationModes() throws InterruptedException {
		Node rootNode = new Node(null, null);
		rootNode.state = new State(true);
		initWorkState(root, rootNode);
		modalCount = workState.size();
		if (modalCount == 0) {
			/*
			 * We have no modal components, but we need to create a special SOM to
			 * represent our single normal operating state.
			 */
			final SystemOperationMode som = InstanceFactory.eINSTANCE.createSystemOperationMode();
			som.setName(InstantiateModel.NORMAL_SOM_NAME);
			root.getSystemOperationModes().add(som);
		} else {
			enumerateSoms(0);
		}
		if (limitReached) {
			errManager.warning(root,
					"List of system operation modes is incomplete (see project property 'Instantiation')");
		}
	}

	/**
	 * Collect the modal components below a component instance, so that a component appears behind the
	 * modal component that contains it.
	 *
	 * @param ci the component instance to walk
	 * @param parentNode the innermost modal component that contains it
	 * @throws InterruptedException if instantiation is canceled
	 */
	private void initWorkState(ComponentInstance ci, Node parentNode) throws InterruptedException {
		checkCanceled();
		if (!ci.getModeInstances().isEmpty()) {
			parentNode = new Node(ci, parentNode);
			workState.add(parentNode);
		}
		for (ComponentInstance sub : ci.getComponentInstances()) {
			initWorkState(sub, parentNode);
		}
	}

	/**
	 * Enumerate the modes of the modal component at {@code depth} and of every modal component behind
	 * it, adding one system operation mode per combination. Returns early once {@link #limitReached} is
	 * set, which abandons the remaining combinations at every depth.
	 *
	 * @param depth the index into {@link #workState} of the modal component to enumerate
	 * @throws InterruptedException if instantiation is canceled
	 */
	private void enumerateSoms(int depth) throws InterruptedException {
		checkCanceled();

		Node node = workState.get(depth);
		State parentState = node.parentNode.state;
		Iterator<ModeInstance> modes = parentState.active ? getActiveModes(node.ci, parentState.mode)
				: Collections.emptyIterator();
		boolean active = parentState.active && modes.hasNext();

		State state = new State(active);
		node.state = state;

		if (depth + 1 == modalCount) {
			// here we add one or more SOMs
			if (active) {
				while (modes.hasNext()) {
					checkCanceled();
					state.mode = modes.next();
					addSom();
					if (limitReached) {
						return;
					}
				}
			} else {
				addSom();
				if (limitReached) {
					return;
				}
			}
		} else {
			if (active) {
				while (modes.hasNext()) {
					state.mode = modes.next();
					enumerateSoms(depth + 1);
					if (limitReached) {
						return;
					}
				}
			} else {
				enumerateSoms(depth + 1);
			}
		}
		node.state = null;
	}

	/**
	 * Add a system operation mode for the combination the enumeration is at, and set
	 * {@link #limitReached} if it was the last one the limit allows.
	 *
	 * @throws InterruptedException if instantiation is canceled
	 */
	private void addSom() throws InterruptedException {
		root.getSystemOperationModes().add(createSom(somCount + 1));
		if (++somCount >= limit) {
			limitReached = true;
		}
	}

	/**
	 * The modes of a component instance that are reachable while its containing component is in a given
	 * mode. A derived mode is reachable only through its parent mode, and a component that is not active
	 * in the mode of its containing component has no reachable mode at all.
	 *
	 * @param ci the component instance
	 * @param parentMode the mode of the innermost modal component that contains it, or {@code null} if
	 *            it is the system instance
	 * @return the reachable modes
	 */
	private Iterator<ModeInstance> getActiveModes(ComponentInstance ci, ModeInstance parentMode) {
		List<ModeInstance> modes = ci.getModeInstances();
		if (parentMode == null) {
			// system instance
			return modes.iterator();
		} else if (!ci.getInModes().isEmpty() && !ci.getInModes().contains(parentMode)) {
			// component not active in parent mode
			return Collections.emptyIterator();
		} else {
			// limit derived modes to mapping
			return modes.stream().filter(mi -> !mi.isDerived() || mi.getParents().contains(parentMode)).iterator();
		}
	}

	/**
	 * Create the system operation mode of the combination the enumeration is at, and record it for every
	 * mode instance it contains.
	 *
	 * @param somNo the number of the system operation mode, which names it
	 * @return the new system operation mode
	 * @throws InterruptedException if instantiation is canceled
	 */
	private SystemOperationMode createSom(int somNo) throws InterruptedException {
		final SystemOperationMode som = InstanceFactory.eINSTANCE.createSystemOperationMode();
		for (Node node : workState) {
			checkCanceled();
			if (!node.state.active) {
				continue;
			}
			ModeInstance mi = node.state.mode;
			mode2som.computeIfAbsent(mi, key -> new ArrayList<>()).add(som);
			som.getCurrentModes().add(mi);
		}
		som.setName("som_" + somNo);
		return som;
	}

	/**
	 * Stop the current instantiation if the user canceled it.
	 *
	 * @throws InterruptedException if the progress monitor reports cancellation
	 */
	private void checkCanceled() throws InterruptedException {
		if (monitor.isCanceled()) {
			throw new InterruptedException();
		}
	}
}
