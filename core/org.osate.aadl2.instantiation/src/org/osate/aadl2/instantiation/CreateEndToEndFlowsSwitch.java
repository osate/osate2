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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.instance.util.InstanceUtil;
import org.osate.aadl2.instance.util.InstanceUtil.InstantiatedClassifier;
import org.osate.aadl2.instantiation.internal.ETEInfo;
import org.osate.aadl2.instantiation.internal.EndToEndFlowModes;
import org.osate.aadl2.instantiation.internal.EndToEndFlowSession;
import org.osate.aadl2.instantiation.internal.FlowInstantiationHost;
import org.osate.aadl2.instantiation.internal.FlowIterator;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;

/**
 * Instantiates declarative end-to-end flows for each component instance.
 * <p>
 * This is the public entry point for the end-to-end flow phase, and it stays one whatever the discovery behind it does.
 * It visits component instances, resolves the implementation instantiated for each of them, watches for cancellation,
 * and declares the protected methods a subclass may override. Discovery itself belongs to
 * {@link EndToEndFlowSession}: one session per visited component instance owns that component's candidates, traversal
 * state, deferred diagnostics, and its single atomic commit, and reaches every overridable step back through this class
 * so that an override still decides the outcome. Connection lookup and compatibility are the stateless predicates of
 * {@code FlowConnectionMatcher}, and mode arithmetic is {@code EndToEndFlowModes}, which the two protected mode methods
 * below delegate to.
 * <p>
 * A session is detached from the instance model while it discovers candidates and attaches the ones that completed in
 * one commit, so cancellation and internal-consistency failures leave a component's existing end-to-end flows
 * unchanged. {@code doc/e2e_instantiation.md} describes discovery, commit, and diagnostics in full.
 *
 * @author lwrage
 */
public class CreateEndToEndFlowsSwitch extends AadlProcessingSwitchWithProgress {

	/**
	 * A classifier for an instance object when it is a prototype in the
	 * declarative model. The classifier is the result of resolving the
	 * prototype. It's either the classifier that is instantiated as a
	 * subcomponent or feature group instance or the classifier referenced by a
	 * feature or subprogram call. If the classifier is anonymous, then its
	 * bindings are included also.
	 */
	private final Map<InstanceObject, InstantiatedClassifier> classifierCache;

	/**
	 * The view a session has of this switch. It is an object of its own rather than the switch itself so that routing a
	 * traversal step back to an overridable method does not require making that method public.
	 */
	private final FlowInstantiationHost host = new SessionHost();

	/** The session of the component instance being instantiated, or null outside instantiation. */
	private EndToEndFlowSession activeSession;

	/**
	 * Create an end-to-end flow instantiation pass.
	 *
	 * @param pm the progress monitor
	 * @param errMgr the error manager
	 * @param classifierCache cache of known instantiated classifiers, may be
	 *            null
	 */
	public CreateEndToEndFlowsSwitch(final IProgressMonitor pm, final AnalysisErrorReporterManager errMgr,
			Map<InstanceObject, InstantiatedClassifier> classifierCache) {
		super(pm, PROCESS_PRE_ORDER_ALL, errMgr);
		this.classifierCache = classifierCache;
	}

	@Override
	protected final void initSwitches() {
		instanceSwitch = new InstanceSwitch<String>() {
			@Override
			public String caseComponentInstance(final ComponentInstance ci) {
				if (monitor.isCanceled()) {
					cancelTraversal();
					return DONE;
				}
				if (ci.getContainingComponentInstance() instanceof SystemInstance) {
					monitor.subTask("Creating end-to-end flows in " + ci.getName());
				}
				EndToEndFlowSession previousSession = activeSession;
				EndToEndFlowSession session = new EndToEndFlowSession(host, ci);
				activeSession = session;
				try {
					ComponentImplementation impl = getComponentImplementation(ci);
					if (impl != null) {
						for (EndToEndFlow ete : impl.getAllEndToEndFlows()) {
							if (monitor.isCanceled()) {
								session.cancel();
								cancelTraversal();
								break;
							}
							if (!session.isExpanded(ete)) {
								instantiateEndToEndFlow(ci, ete, null);
							}
						}
					}
					if (!session.isCanceled() && !monitor.isCanceled()) {
						session.commit();
					}
				} finally {
					activeSession = previousSession;
				}
				return DONE;
			}
		};
	}

	/**
	 * The implementation instantiated for a component instance, with prototypes resolved through the classifier cache.
	 */
	private ComponentImplementation getComponentImplementation(ComponentInstance ci) {
		return InstanceUtil.getComponentImplementation(ci, 0, classifierCache);
	}

	/**
	 * The session that is instantiating flows right now.
	 *
	 * @throws IllegalStateException if there is no instantiation in progress, which means a traversal step was reached
	 *             from outside an instantiation
	 */
	private EndToEndFlowSession session() {
		if (activeSession == null) {
			throw new IllegalStateException("No active end-to-end flow instantiation context");
		}
		return activeSession;
	}

	int ETEInstanceCloneCount = 1;

	protected void setCloneName(EndToEndFlowInstance etei) {
		etei.setName(etei.getEndToEndFlow().getName() + "_" + ETEInstanceCloneCount++);
	}

	protected void resetETECloneCount() {
		ETEInstanceCloneCount = 1;
	}

	/**
	 * Expand one declaration and optionally publish its legacy compatibility view. Internal callers pass {@code null};
	 * the map parameter is retained for protected API compatibility.
	 * <p>
	 * The declaration is expanded in the session of the component instance being visited. Called outside a traversal, it
	 * starts a session of its own for {@code ci} and commits it before returning.
	 */
	protected void instantiateEndToEndFlow(ComponentInstance ci, EndToEndFlow ete,
			HashMap<EndToEndFlow, List<ETEInfo>> ete2info) {
		EndToEndFlowSession previousSession = activeSession;
		boolean standalone = activeSession == null;
		if (standalone) {
			activeSession = new EndToEndFlowSession(host, ci);
		} else if (activeSession.owner() != ci) {
			// EndToEndFlow is not a FlowElement, so a nested ETE segment can only be expanded at its declaration's level.
			throw new IllegalStateException("End-to-end flow expansion crossed component contexts");
		}

		try {
			EndToEndFlowSession session = activeSession;
			session.expand(ete);
			if (ete2info != null) {
				ete2info.put(ete, session.compatibilityInfo(ete));
			}
			if (standalone && !session.isCanceled() && !monitor.isCanceled()) {
				session.commit();
			}
		} finally {
			if (standalone) {
				activeSession = previousSession;
			}
		}
	}

	protected void processETE(final ComponentInstance ci, final EndToEndFlowInstance etei, final EndToEndFlow ete) {
		session().processETE(ci, etei, ete);
	}

	/**
	 * Consume one declarative flow segment. Connection declarations are accumulated until a concrete flow element
	 * resolves them; other segment kinds delegate to their specialized traversal methods and may fork the candidate.
	 *
	 * @param ci the component instance we're in
	 * @param etei the current flow instance
	 * @param fs the next flow segment
	 * @param iter the position in the current ETE declaration
	 * @param errorElement the model element that we attach errors to
	 */
	protected void processETESegment(ComponentInstance ci, EndToEndFlowInstance etei, Element fs, FlowIterator iter,
			NamedElement errorElement) {
		session().processETESegment(ci, etei, fs, iter, errorElement);
	}

	/**
	 * Instantiate a component flow specification. Each matching flow implementation creates an alternative path and is
	 * followed recursively. If no implementation exists, the flow specification itself is added as a leaf step.
	 *
	 * @param ci the component whose flow specification is to be processed
	 * @param etei the end to end flow instance
	 * @param fs the flow specification to be processed
	 * @param iter the continuation in the enclosing flow declaration
	 */
	protected void processSubcomponentFlow(final ComponentInstance ci, EndToEndFlowInstance etei,
			final FlowSpecification fs, FlowIterator iter) {
		session().processSubcomponentFlow(ci, etei, fs, iter);
	}

	/**
	 * Continue the current ETE instance with a flow implementation.
	 *
	 * @param ci the component instance whose flow implementation is being
	 *            processed
	 * @param etei the end to end flow instance
	 * @param flowImpl the flow implementation to be processed
	 * @return whether traversal entered the flow implementation; false if it has fewer than two segments
	 */
	protected boolean processFlowImpl(ComponentInstance ci, EndToEndFlowInstance etei, FlowImplementation flowImpl) {
		return session().processFlowImpl(ci, etei, flowImpl);
	}

	/**
	 * Continue through a leaf flow element, forking the candidate once for each matching connection instance.
	 *
	 * @param ci the component instance containing the leaf
	 * @param etei the current end to end flow instance
	 * @param leaf the next ETE element
	 * @param iter the position in the current end to end flow declaration
	 */
	protected void processFlowStep(ComponentInstance ci, EndToEndFlowInstance etei, Element leaf, FlowIterator iter) {
		processFlowStep(ci, etei, leaf, null, iter);
	}

	/**
	 * Continue through a leaf flow element and constrain the incoming connection to the start of the next flow
	 * implementation when one is known.
	 */
	protected void processFlowStep(ComponentInstance ci, EndToEndFlowInstance etei, Element leaf,
			FlowImplementation nextFlowImpl, FlowIterator iter) {
		session().processFlowStep(ci, etei, leaf, nextFlowImpl, iter);
	}

	// -------------------------------------------------------------------------
	// Mode utilities
	// -------------------------------------------------------------------------

	/**
	 * Resolve an element's mode constraints relative to a component instance. If the element has no explicit modes, use
	 * the nearest containing component instance with inherited mode constraints.
	 *
	 * @param ci the component instance used to resolve modes
	 * @param e the modal declarative element
	 * @return list of mode instances
	 */
	protected EList<ModeInstance> getModeInstances(ComponentInstance ci, ModalElement e) {
		return EndToEndFlowModes.modeInstances(ci, e);
	}

	/**
	 * Compute the system operation modes a committed flow instance is active in and consume its accumulated mode
	 * constraints.
	 *
	 * @param etei the committed flow instance
	 */
	protected void fillinModes(EndToEndFlowInstance etei) {
		EndToEndFlowModes.fillInModes(etei);
	}

	/**
	 * Routes what a session needs back to this switch, so that discovery reaches the protected methods above and an
	 * override of any of them stays in effect however deep in the traversal it is reached from.
	 */
	private final class SessionHost implements FlowInstantiationHost {

		@Override
		public boolean isCanceled() {
			return monitor.isCanceled();
		}

		@Override
		public ComponentImplementation componentImplementation(ComponentInstance ci) {
			return getComponentImplementation(ci);
		}

		@Override
		public void reportError(Element target, String message) {
			error(target, message);
		}

		@Override
		public void expandNestedFlow(ComponentInstance ci, EndToEndFlow ete) {
			instantiateEndToEndFlow(ci, ete, null);
		}

		@Override
		public void processETE(ComponentInstance ci, EndToEndFlowInstance etei, EndToEndFlow ete) {
			CreateEndToEndFlowsSwitch.this.processETE(ci, etei, ete);
		}

		@Override
		public void processETESegment(ComponentInstance ci, EndToEndFlowInstance etei, Element fs, FlowIterator iter,
				NamedElement errorElement) {
			CreateEndToEndFlowsSwitch.this.processETESegment(ci, etei, fs, iter, errorElement);
		}

		@Override
		public void processSubcomponentFlow(ComponentInstance ci, EndToEndFlowInstance etei, FlowSpecification fs,
				FlowIterator iter) {
			CreateEndToEndFlowsSwitch.this.processSubcomponentFlow(ci, etei, fs, iter);
		}

		@Override
		public boolean processFlowImpl(ComponentInstance ci, EndToEndFlowInstance etei, FlowImplementation flowImpl) {
			return CreateEndToEndFlowsSwitch.this.processFlowImpl(ci, etei, flowImpl);
		}

		@Override
		public void processFlowStep(ComponentInstance ci, EndToEndFlowInstance etei, Element leaf, FlowIterator iter) {
			CreateEndToEndFlowsSwitch.this.processFlowStep(ci, etei, leaf, iter);
		}

		@Override
		public void processFlowStep(ComponentInstance ci, EndToEndFlowInstance etei, Element leaf,
				FlowImplementation nextFlowImpl, FlowIterator iter) {
			CreateEndToEndFlowsSwitch.this.processFlowStep(ci, etei, leaf, nextFlowImpl, iter);
		}

		@Override
		public void resetCloneCount() {
			resetETECloneCount();
		}

		@Override
		public void setCloneName(EndToEndFlowInstance etei) {
			CreateEndToEndFlowsSwitch.this.setCloneName(etei);
		}

		@Override
		public EList<ModeInstance> modeInstances(ComponentInstance ci, ModalElement element) {
			return getModeInstances(ci, element);
		}

		@Override
		public void fillInModes(EndToEndFlowInstance etei) {
			fillinModes(etei);
		}
	}
}
