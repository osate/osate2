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

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Access;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.ThreadClassifier;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceFactory;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.util.AadlUtil;

/**
 * Instantiates the end-to-end flows declared by one component instance.
 * <p>
 * Flow discovery builds detached candidates with branch-local traversal state. A declaration may produce multiple
 * candidates when several flow implementations, connection instances, access targets, or nested end-to-end flow
 * variants match. Only completed candidates are attached to the component, in one commit after discovery finishes.
 * Cancellation therefore leaves the component's existing end-to-end flows unchanged.
 * <p>
 * Nested end-to-end flows are expanded once per component context. Their leading and trailing declarative connection
 * paths are retained so parent candidates can select compatible nested variants and continue after them.
 * <p>
 * A session belongs to one component instance and cannot be reused for another; the candidate, expansion, and traversal
 * state it holds is meaningful only in that component context. Its traversal steps are reached from the adapter's
 * protected methods and reach the adapter back through {@link FlowInstantiationHost}, so a subclass override remains in
 * control of every step.
 * <p>
 * Internal consistency failures throw {@link IllegalStateException} intentionally. Continuing after an invariant has
 * failed could publish an instance model whose flow graph cannot be trusted.
 *
 * @author lwrage
 */
public final class EndToEndFlowSession {

	/**
	 * Candidate discovery states. A failed candidate has no valid semantic continuation or belongs to a failed
	 * declaration expansion. An aborted candidate could not append a resolved flow element because the instance model
	 * did not satisfy the declaration.
	 */
	private enum CandidateStatus {
		ACTIVE, COMPLETE, FAILED, ABORTED
	}

	private enum ExpansionStatus {
		EXPANDING, COMPLETE, FAILED
	}

	private enum DiagnosticTarget {
		OWNER, CANDIDATE, EXISTING_ELEMENT
	}

	private record PendingDiagnostic(long sequence, DiagnosticTarget target, FlowCandidate candidate,
			Element existingElement, String message) {
	}

	/**
	 * Expansion of one declarative end-to-end flow and all candidate paths derived from it.
	 */
	private static final class FlowExpansion {
		private final EndToEndFlow declaration;
		private final List<FlowCandidate> candidates = new ArrayList<>();
		private ExpansionStatus status = ExpansionStatus.EXPANDING;

		private FlowExpansion(EndToEndFlow declaration) {
			this.declaration = declaration;
		}
	}

	/**
	 * A detached end-to-end flow instance under construction.
	 */
	private static final class FlowCandidate {
		private final ComponentInstance owner;
		private final FlowExpansion expansion;
		private final EndToEndFlowInstance instance;
		/*
		 * Declarative connection paths before the first and after the last concrete flow element. Parent flows use these
		 * paths to select compatible nested candidates and continue beyond them.
		 */
		private final List<Connection> preConnections;
		private final List<Connection> postConnections = new ArrayList<>();
		private final long sequence;
		private CandidateStatus status = CandidateStatus.ACTIVE;

		private FlowCandidate(ComponentInstance owner, FlowExpansion expansion, EndToEndFlowInstance instance,
				List<Connection> preConnections, long sequence) {
			this.owner = owner;
			this.expansion = expansion;
			this.instance = instance;
			this.preConnections = preConnections;
			this.sequence = sequence;
		}
	}

	/**
	 * Branch-local traversal data. Continuations resume enclosing declarations after descending into a flow
	 * implementation or another nested construct; connections are the declarative path awaiting resolution to a
	 * connection instance; flowImplementations constrain the source and destination features accepted for that
	 * connection instance.
	 */
	private static final class TraversalState {
		private final FlowCandidate candidate;
		private final Deque<FlowIterator> continuations = new ArrayDeque<>();
		private final List<Connection> connections = new ArrayList<>();
		private final List<FlowImplementation> flowImplementations = new ArrayList<>();

		private TraversalState(FlowCandidate candidate) {
			this.candidate = candidate;
		}

		private TraversalState copy(FlowCandidate candidate) {
			TraversalState copy = new TraversalState(candidate);
			for (FlowIterator continuation : continuations) {
				copy.continuations.addLast(continuation.copy());
			}
			copy.connections.addAll(connections);
			copy.flowImplementations.addAll(flowImplementations);
			return copy;
		}
	}

	private final FlowInstantiationHost host;
	private final ComponentInstance owner;
	private final List<EndToEndFlowInstance> initialFlows;
	private final Map<EndToEndFlow, FlowExpansion> expansions = new IdentityHashMap<>();
	private final List<FlowExpansion> expansionOrder = new ArrayList<>();
	private final List<FlowCandidate> candidates = new ArrayList<>();
	private final Map<EndToEndFlowInstance, FlowCandidate> candidatesByInstance = new IdentityHashMap<>();
	private final List<EndToEndFlow> activeDeclarations = new ArrayList<>();
	private final List<PendingDiagnostic> diagnostics = new ArrayList<>();
	private long nextCandidateSequence;
	private long nextDiagnosticSequence;
	private boolean canceled;

	/** The branch currently advancing, or null while no branch is being traversed. */
	private TraversalState activeState;

	/**
	 * Start instantiating the end-to-end flows of one component instance.
	 *
	 * @param host the traversal adapter that drives this session
	 * @param owner the component instance whose declarations are instantiated
	 */
	public EndToEndFlowSession(FlowInstantiationHost host, ComponentInstance owner) {
		this.host = host;
		this.owner = owner;
		initialFlows = List.copyOf(owner.getEndToEndFlows());
	}

	/** The component instance this session instantiates flows for. */
	public ComponentInstance owner() {
		return owner;
	}

	/** Whether a declaration has already been expanded in this component context. */
	public boolean isExpanded(EndToEndFlow ete) {
		return expansions.containsKey(ete);
	}

	/** Whether discovery was canceled, which keeps the component's flows unchanged. */
	public boolean isCanceled() {
		return canceled;
	}

	/** Record that discovery was canceled. */
	public void cancel() {
		canceled = true;
	}

	/**
	 * The legacy view of a declaration's candidates, in creation order.
	 */
	public List<ETEInfo> compatibilityInfo(EndToEndFlow ete) {
		FlowExpansion expansion = expansions.get(ete);
		if (expansion == null) {
			return List.of();
		}
		List<ETEInfo> infos = new ArrayList<>();
		for (FlowCandidate candidate : expansion.candidates) {
			infos.add(new ETEInfo(candidate.preConnections, candidate.instance, candidate.postConnections));
		}
		return infos;
	}

	/**
	 * Expand one declaration into candidates, once per component context. The candidates stay detached until
	 * {@link #commit()}.
	 */
	public void expand(EndToEndFlow ete) {
		if (expansions.containsKey(ete)) {
			return;
		}

		FlowExpansion expansion = new FlowExpansion(ete);
		expansions.put(ete, expansion);
		expansionOrder.add(expansion);
		activeDeclarations.add(ete);

		EndToEndFlowInstance etei = InstanceFactory.eINSTANCE.createEndToEndFlowInstance();
		etei.setName(ete.getName());
		etei.setEndToEndFlow(ete);
		FlowCandidate candidate = createCandidate(expansion, etei, new ArrayList<>());
		TraversalState previousState = activeState;
		activeState = new TraversalState(candidate);
		etei.getModesList().add(host.modeInstances(owner, ete));
		try {
			host.processETE(owner, etei, ete);
		} finally {
			activeDeclarations.removeLast();
			if (host.isCanceled()) {
				canceled = true;
			}
			if (expansion.status == ExpansionStatus.FAILED) {
				for (FlowCandidate createdCandidate : expansion.candidates) {
					createdCandidate.status = CandidateStatus.FAILED;
				}
			} else {
				for (FlowCandidate createdCandidate : expansion.candidates) {
					if (createdCandidate.status == CandidateStatus.ACTIVE) {
						createdCandidate.status = createdCandidate.instance.getFlowElements().isEmpty()
								? CandidateStatus.FAILED
								: CandidateStatus.COMPLETE;
					}
				}
				expansion.status = ExpansionStatus.COMPLETE;
			}
			activeState = previousState;
		}
	}

	private FlowCandidate createCandidate(FlowExpansion expansion, EndToEndFlowInstance instance,
			List<Connection> preConnections) {
		FlowCandidate candidate = new FlowCandidate(owner, expansion, instance, preConnections,
				nextCandidateSequence++);
		expansion.candidates.add(candidate);
		candidates.add(candidate);
		candidatesByInstance.put(instance, candidate);
		return candidate;
	}

	/**
	 * Fork the active path before processing another alternative. Both the detached instance and every mutable traversal
	 * structure must be copied so subsequent alternatives cannot modify one another.
	 */
	private TraversalState forkState(TraversalState source) {
		EndToEndFlowInstance instance = EcoreUtil.copy(source.candidate.instance);
		// Preserve accumulated mode constraints, which are not part of the copied flow-element containment tree.
		instance.getModesList().addAll(source.candidate.instance.getModesList());
		List<Connection> preConnections = source.candidate.instance.getFlowElements().isEmpty()
				? new ArrayList<>()
				: new ArrayList<>(source.candidate.preConnections);
		FlowCandidate candidate = createCandidate(source.candidate.expansion, instance, preConnections);
		return source.copy(candidate);
	}

	private FlowCandidate getCandidate(EndToEndFlowInstance etei) {
		FlowCandidate candidate = candidatesByInstance.get(etei);
		if (candidate == null) {
			throw new IllegalStateException("End-to-end flow instance is not part of the active context");
		}
		return candidate;
	}

	private TraversalState getState(EndToEndFlowInstance etei) {
		FlowCandidate candidate = getCandidate(etei);
		if (activeState == null || activeState.candidate != candidate) {
			throw new IllegalStateException("End-to-end flow branch is not active");
		}
		return activeState;
	}

	private void reportOwnerError(FlowCandidate candidate, String message) {
		diagnostics.add(new PendingDiagnostic(nextDiagnosticSequence++, DiagnosticTarget.OWNER, candidate, null,
				message));
	}

	private void reportCandidateError(FlowCandidate candidate, String message) {
		diagnostics.add(new PendingDiagnostic(nextDiagnosticSequence++, DiagnosticTarget.CANDIDATE, candidate, null,
				message));
	}

	private void reportExistingElementError(FlowCandidate candidate, Element element, String message) {
		diagnostics.add(new PendingDiagnostic(nextDiagnosticSequence++, DiagnosticTarget.EXISTING_ELEMENT, candidate,
				element, message));
	}

	private String getProspectivePath(FlowCandidate candidate) {
		return candidate.owner.getInstanceObjectPath() + "." + candidate.instance.getName();
	}

	private void failCandidate(FlowCandidate candidate) {
		if (candidate.status == CandidateStatus.ACTIVE) {
			candidate.status = CandidateStatus.FAILED;
		}
	}

	private void abortCandidate(FlowCandidate candidate) {
		candidate.status = CandidateStatus.ABORTED;
	}

	// -------------------------------------------------------------------------
	// Commit
	// -------------------------------------------------------------------------

	/**
	 * Publish all completed candidates for a component. Candidate names are assigned deterministically, nested
	 * references are checked before attachment, and modes are finalized with nested flows before their parents. If mode
	 * finalization fails, attachment and transient mode state are rolled back before the exception is propagated.
	 * Diagnostics are emitted only after a successful commit. Diagnostics for completed candidates target the attached
	 * flow instance; diagnostics for discarded candidates target the owning component instance.
	 */
	public void commit() {
		if (canceled || host.isCanceled()) {
			return;
		}
		if (!owner.getEndToEndFlows().equals(initialFlows)) {
			throw new IllegalStateException("End-to-end flow list changed during candidate discovery");
		}

		for (FlowExpansion expansion : expansionOrder) {
			List<FlowCandidate> successful = expansion.candidates.stream()
					.filter(candidate -> candidate.status == CandidateStatus.COMPLETE)
					.sorted(Comparator.comparingLong(candidate -> candidate.sequence))
					.toList();
			if (successful.size() == 1) {
				successful.get(0).instance.setName(expansion.declaration.getName());
			} else if (successful.size() > 1) {
				host.resetCloneCount();
				for (FlowCandidate candidate : successful) {
					host.setCloneName(candidate.instance);
				}
			}
		}

		List<FlowCandidate> successful = candidates.stream()
				.filter(candidate -> candidate.status == CandidateStatus.COMPLETE)
				.sorted(Comparator.comparingLong(candidate -> candidate.sequence))
				.toList();
		for (FlowCandidate candidate : successful) {
			for (FlowElementInstance element : candidate.instance.getFlowElements()) {
				if (element instanceof EndToEndFlowInstance nested) {
					FlowCandidate nestedCandidate = candidatesByInstance.get(nested);
					if (nestedCandidate == null || nestedCandidate.status != CandidateStatus.COMPLETE) {
						throw new IllegalStateException("Candidate references an unavailable end-to-end flow");
					}
				}
			}
		}

		List<EndToEndFlowInstance> instances = successful.stream().map(candidate -> candidate.instance).toList();
		Map<FlowCandidate, List<EList<ModeInstance>>> modeSnapshots = new IdentityHashMap<>();
		Map<FlowCandidate, List<SystemOperationMode>> somSnapshots = new IdentityHashMap<>();
		for (FlowCandidate candidate : successful) {
			modeSnapshots.put(candidate, new ArrayList<>(candidate.instance.getModesList()));
			somSnapshots.put(candidate, new ArrayList<>(candidate.instance.getInSystemOperationModes()));
		}

		owner.getEndToEndFlows().addAll(instances);
		try {
			Map<FlowCandidate, Boolean> finalized = new IdentityHashMap<>();
			Map<FlowCandidate, Boolean> finalizing = new IdentityHashMap<>();
			for (FlowCandidate candidate : successful) {
				finalizeModes(candidate, finalized, finalizing);
			}
		} catch (RuntimeException | Error exception) {
			owner.getEndToEndFlows().removeAll(instances);
			for (FlowCandidate candidate : successful) {
				candidate.instance.getModesList().clear();
				candidate.instance.getModesList().addAll(modeSnapshots.get(candidate));
				candidate.instance.getInSystemOperationModes().clear();
				candidate.instance.getInSystemOperationModes().addAll(somSnapshots.get(candidate));
			}
			throw exception;
		}

		for (PendingDiagnostic diagnostic : diagnostics.stream()
				.sorted(Comparator.comparingLong(PendingDiagnostic::sequence))
				.toList()) {
			switch (diagnostic.target()) {
			case OWNER -> host.reportError(diagnostic.candidate().owner, diagnostic.message());
			case CANDIDATE -> {
				if (diagnostic.candidate().status == CandidateStatus.COMPLETE) {
					host.reportError(diagnostic.candidate().instance, diagnostic.message());
				} else {
					host.reportError(diagnostic.candidate().owner,
							diagnostic.candidate().instance.getName() + " could not be instantiated: "
									+ diagnostic.message());
				}
			}
			case EXISTING_ELEMENT -> host.reportError(diagnostic.existingElement(), diagnostic.message());
			}
		}
	}

	/**
	 * Finalize a candidate's system operation modes after finalizing any nested candidates it references.
	 */
	private void finalizeModes(FlowCandidate candidate, Map<FlowCandidate, Boolean> finalized,
			Map<FlowCandidate, Boolean> finalizing) {
		if (finalized.containsKey(candidate)) {
			return;
		}
		if (finalizing.put(candidate, Boolean.TRUE) != null) {
			throw new IllegalStateException("Cyclic committed end-to-end flow graph");
		}
		for (FlowElementInstance element : candidate.instance.getFlowElements()) {
			if (element instanceof EndToEndFlowInstance nested) {
				FlowCandidate nestedCandidate = candidatesByInstance.get(nested);
				if (nestedCandidate != null && nestedCandidate.status == CandidateStatus.COMPLETE) {
					finalizeModes(nestedCandidate, finalized, finalizing);
				}
			}
		}
		host.fillInModes(candidate.instance);
		candidate.instance.getModesList().clear();
		finalizing.remove(candidate);
		finalized.put(candidate, Boolean.TRUE);
	}

	// -------------------------------------------------------------------------
	// Traversal
	// -------------------------------------------------------------------------

	public void processETE(final ComponentInstance ci, final EndToEndFlowInstance etei, final EndToEndFlow ete) {
		FlowIterator iter = new FlowIterator(ete);
		EndToEndFlowSegment fe = (EndToEndFlowSegment) iter.next();

		host.processETESegment(ci, etei, fe, iter, ete);
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
	public void processETESegment(ComponentInstance ci, EndToEndFlowInstance etei, Element fs, FlowIterator iter,
			NamedElement errorElement) {
		TraversalState traversal = getState(etei);
		FlowCandidate candidate = traversal.candidate;
		Element fe = switch (fs) {
		case FlowSegment segment -> segment.getFlowElement();
		case EndToEndFlowSegment segment -> segment.getFlowElement();
		default -> throw new IllegalArgumentException("Unsupported flow segment " + fs.eClass().getName());
		};

		if (fe instanceof Connection connection) {
			if (etei.getFlowElements().isEmpty()) {
				candidate.preConnections.add(connection);
			} else {
				traversal.connections.add(connection);
			}
		} else if (fe instanceof FlowSpecification flowSpecification) {
			Subcomponent sc = (Subcomponent) switch (fs) {
			case FlowSegment segment -> segment.getContext();
			case EndToEndFlowSegment segment -> segment.getContext();
			default -> throw new IllegalArgumentException("Unsupported flow segment " + fs.eClass().getName());
			};
			ComponentInstance sci = ci.findSubcomponentInstance(sc);
			if (sci != null) {
				host.processSubcomponentFlow(sci, etei, flowSpecification, iter);
			} else {
				reportOwnerError(candidate,
						"Incomplete End-to-end flow instance " + etei.getName()
								+ ": Could not find component instance for subcomponent " + sc.getName()
								+ " in flow implementation " + errorElement.getName());
			}
		} else if (fe instanceof Subcomponent subcomponent) {
			ComponentInstance sci = ci.findSubcomponentInstance(subcomponent);
			host.processFlowStep(sci, etei, fe, iter);
		} else if (fe instanceof DataAccess dataAccess) {
			processAccess(ci, etei, dataAccess, iter);
		} else if (fe instanceof SubprogramAccess subprogramAccess) {
			processAccess(ci, etei, subprogramAccess, iter);
		} else if (fe instanceof EndToEndFlow endToEndFlow) {
			processEndToEndFlow(ci, etei, endToEndFlow, iter);
		}
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
	public void processSubcomponentFlow(final ComponentInstance ci, EndToEndFlowInstance etei,
			final FlowSpecification fs, FlowIterator iter) {
		FlowCandidate candidate = getCandidate(etei);
		final ComponentImplementation subImpl = host.componentImplementation(ci);
		final List<FlowImplementation> flowImpls = new ArrayList<>();

		// Collect flow impls for this flow spec
		if (subImpl != null) {
			for (FlowImplementation fl : subImpl.getAllFlowImplementations()) {
				if (fl.getSpecification().getName().equalsIgnoreCase(fs.getName())) {
					flowImpls.add(fl);
				}
			}
		}

		if (flowImpls.isEmpty()) {
			// we are at a leaf
			int errorsBefore = diagnostics.size();
			host.processFlowStep(ci, etei, fs, iter);
			if (subImpl != null && AadlUtil.hasPortComponents(subImpl) && diagnostics.size() == errorsBefore) {
				reportOwnerError(candidate,
						"Cannot create end to end flow '" + etei.getName() + "' because component '" + ci.getName()
								+ "' has subcomponents but no flow implementation for flow '" + fs.getName() + "'");
			}
		} else {
			Iterator<FlowImplementation> itt = flowImpls.iterator();

			getState(etei).continuations.push(iter);
			while (itt.hasNext()) {
				TraversalState stateClone = null;
				FlowIterator iterClone = null;
				FlowImplementation flowImpl = itt.next();
				boolean prepareNext = itt.hasNext();

				if (prepareNext) {
					stateClone = forkState(getState(etei));
					iterClone = iter.copy();
				}

				/*
				 * Issue 1953: Treat a thread flow implementation with owned segments as an atomic flow specification
				 * instead of expanding its internal path, which prevents unnecessary instance-model combinations. An
				 * empty implementation still follows the normal path because it may refine a feature-group endpoint to
				 * one of its features.
				 *
				 * The flow implementation still contributes mode constraints even though its segments are ignored.
				 */
				if (subImpl instanceof ThreadClassifier && !flowImpl.getOwnedFlowSegments().isEmpty()) {
					etei.getModesList().add(host.modeInstances(ci, flowImpl));
					getState(etei).continuations.pop();

					host.processFlowStep(ci, etei, fs, iter);
				} else {
					if (!host.processFlowImpl(ci, etei, flowImpl)) {
						host.processFlowStep(ci, etei, fs, flowImpl, iter);
					}
				}

				if (prepareNext) {
					activeState = stateClone;
					etei = stateClone.candidate.instance;
					iter = iterClone;
				}
			}
		}
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
	public boolean processFlowImpl(ComponentInstance ci, EndToEndFlowInstance etei, FlowImplementation flowImpl) {
		etei.getModesList().add(host.modeInstances(ci, flowImpl));

		if (flowImpl.getOwnedFlowSegments().size() < 2) {
			// the flow impl doesn't include a subcomponent, nothing to do
			getState(etei).continuations.pop();
			return false;
		}

		continueFlow(ci, etei, new FlowIterator(flowImpl), ci);
		return true;
	}

	/**
	 * Continue through a leaf flow element and constrain the incoming connection to the start of the next flow
	 * implementation when one is known.
	 *
	 * @param ci the component instance containing the leaf
	 * @param etei the current end to end flow instance
	 * @param leaf the next ETE element
	 * @param nextFlowImpl the flow implementation the incoming connection must reach, or null
	 * @param iter the position in the current end to end flow declaration
	 */
	public void processFlowStep(ComponentInstance ci, EndToEndFlowInstance etei, Element leaf,
			FlowImplementation nextFlowImpl, FlowIterator iter) {
		TraversalState traversal = getState(etei);
		FlowCandidate candidate = traversal.candidate;
		// add connection(s), will be empty when starting the ETE
		if (traversal.connections.isEmpty()) {
			if (!addLeafElement(ci, etei, leaf)) {
				abortCandidate(candidate);
				return;
			}
			traversal.flowImplementations.add(nextFlowImpl);
			continueFlow(ci.getContainingComponentInstance(), etei, iter, ci);
			traversal.flowImplementations.removeLast();
		} else {
			List<ConnectionInstance> connis = FlowConnectionMatcher.collectConnectionInstances(ci, etei,
					traversal.connections);

			if (connis.isEmpty()) {
				traversal.connections.clear();
				failCandidate(candidate);

				if (!traversal.flowImplementations.isEmpty()) {
					FlowImplementation flowFilter = traversal.flowImplementations.getLast();
					if (flowFilter != null) {
						// A semantic connection was expected after the preceding flow implementation.
						reportOwnerError(candidate,
								"Cannot create end to end flow '" + etei.getName()
										+ "' because there are no semantic connections that continue the flow '"
										+ flowFilter.getSpecification().getName() + "' from feature '"
										+ flowFilter.getOutEnd().getFeature().getName() + "'");
					}
				}
			} else {
				FlowImplementation flowFilter = traversal.flowImplementations.isEmpty()
						? null
						: traversal.flowImplementations.getLast();

				/*
				 * Issue 1984: isValidContinuation() is a filter, not an error reporter. Determine the applicable
				 * connections first and report an error only when none of the candidates can continue this flow.
				 */
				final List<ConnectionInstance> connectionsToUse = new ArrayList<>();
				for (final ConnectionInstance ciToCheck : connis) {
					if ((flowFilter == null || FlowConnectionMatcher.isValidContinuation(flowFilter, ciToCheck))
							&& (nextFlowImpl == null
									? (leaf instanceof FlowSpecification flowSpecification
											? FlowConnectionMatcher.isValidContinuation(ci, ciToCheck, flowSpecification)
											: true)
									: FlowConnectionMatcher.isValidContinuation(ciToCheck, nextFlowImpl))) {
						connectionsToUse.add(ciToCheck);
					}
				}

				if (connectionsToUse.isEmpty()) {
					/*
					 * Connections may bypass the start of the selected flow implementation: the declarative flow and the
					 * actual component connections then describe different paths.
					 */
					if (flowFilter == null && nextFlowImpl == null) {
						final FlowSpecification flowSpec = (FlowSpecification) leaf;
						reportOwnerError(candidate, "Cannot create end to end flow '" + etei.getName()
								+ "' because there are no semantic connections that connect to the start of the flow '"
								+ flowSpec.getName() + "' at feature '" + flowSpec.getAllInEnd().getFeature().getName()
								+ "'");
					} else {
						final FlowImplementation ff = flowFilter == null ? nextFlowImpl : flowFilter;
						reportOwnerError(candidate, "Cannot create end to end flow '" + etei.getName()
								+ "' because there are no semantic connections that connect to the start of the flow '"
								+ ff.getSpecification().getName() + "' at feature '"
								+ ff.getInEnd().getFeature().getName() + "'");
					}
					traversal.connections.clear();
					failCandidate(candidate);
				} else {
					// continue the flow along each eligible connection instance
					Iterator<ConnectionInstance> connIter = connectionsToUse.iterator();
					while (connIter.hasNext()) {
						final ConnectionInstance conni = connIter.next();
						final boolean prepareNext = connIter.hasNext();
						TraversalState branchState = getState(etei);
						TraversalState stateClone = null;
						FlowIterator iterClone = null;

						if (prepareNext) {
							stateClone = forkState(branchState);
							iterClone = iter.copy();
						}

						branchState.flowImplementations.add(nextFlowImpl);
						etei.getFlowElements().add(conni);
						if (addLeafElement(ci, etei, leaf)) {
							// prepare next connection filter
							branchState.connections.clear();
							if (iter.hasNext()) {
								Connection conn = getConnection(iter.next());
								if (conn != null) {
									branchState.connections.add(conn);
								}
							}

							continueFlow(ci.getContainingComponentInstance(), etei, iter, ci);
						} else {
							branchState.connections.clear();
							abortCandidate(getCandidate(etei));
						}

						branchState.flowImplementations.removeLast();

						if (prepareNext) {
							activeState = stateClone;
							etei = stateClone.candidate.instance;
							iter = iterClone;
						}
					}
				}
			}
		}
	}

	/**
	 * Continue through a data or subprogram access. The accessed component instance, rather than the access feature, is
	 * added as the flow element. Multiple matching access connections create independent candidates.
	 *
	 * @param ci the component containing the access
	 * @param etei the current end-to-end flow candidate
	 * @param a the data or subprogram access
	 * @param iter the continuation in the enclosing flow declaration
	 */
	private void processAccess(ComponentInstance ci, EndToEndFlowInstance etei, Access a, FlowIterator iter) {
		TraversalState traversal = getState(etei);
		FlowCandidate candidate = traversal.candidate;
		// add connection(s), will be empty when starting the ETE
		if (traversal.connections.isEmpty()) {
			addLeafElement(ci, etei, a);
			continueFlow(ci.getContainingComponentInstance(), etei, iter, ci);
		} else {
			List<ConnectionInstance> connis = FlowConnectionMatcher.collectConnectionInstances(ci, etei,
					traversal.connections);

			if (connis.isEmpty()) {
				reportCandidateError(candidate, "Incomplete end-to-end flow instance " + etei.getName()
						+ ": Missing connection instance to " + a.getName());
				traversal.connections.clear();
			} else {
				record AccessMatch(ConnectionInstance connection, ComponentInstance target, EndToEndFlowElement leaf) {
				}
				List<AccessMatch> matches = new ArrayList<>();
				boolean invalidTarget = false;
				for (ConnectionInstance conni : connis) {
					if (conni.getDestination() instanceof ComponentInstance target
							&& (target.getCategory() == ComponentCategory.DATA
									|| target.getCategory() == ComponentCategory.SUBPROGRAM)) {
						matches.add(new AccessMatch(conni, target, target.getSubcomponent()));
					} else {
						invalidTarget = true;
					}
				}

				if (invalidTarget) {
					reportCandidateError(candidate, "Access feature " + a.getQualifiedName()
							+ " is not a proxy for a data or subprogram component.");
				}
				if (matches.isEmpty()) {
					traversal.connections.clear();
					failCandidate(candidate);
					return;
				}

				Iterator<AccessMatch> matchIter = matches.iterator();
				traversal.continuations.push(iter);
				while (matchIter.hasNext()) {
					TraversalState branchState = getState(etei);
					TraversalState stateClone = null;
					AccessMatch match = matchIter.next();
					boolean prepareNext = matchIter.hasNext();

					if (prepareNext) {
						stateClone = forkState(branchState);
						etei.setName(etei.getEndToEndFlow().getName());
					}
					FlowIterator continuation = branchState.continuations.pop();

					etei.getFlowElements().add(match.connection());
					addLeafElement(match.target(), etei, match.leaf());

					// prepare next connection filter
					Connection lastConn = branchState.connections.getLast();
					branchState.connections.clear();
					if (continuation.hasNext()) {
						Connection nextConn = getConnection(continuation.next());
						if (nextConn != null) {
							int i = match.connection().getConnectionReferences().size() - 1;
							Connection preConn = null;

							while (i > 0 && preConn != lastConn) {
								preConn = match.connection().getConnectionReferences().get(i--).getConnection();
								if (preConn != lastConn) {
									branchState.connections.add(preConn);
								}
							}
							branchState.connections.add(nextConn);
						}
					}

					continueFlow(ci, etei, continuation, ci);

					if (prepareNext) {
						activeState = stateClone;
						etei = stateClone.candidate.instance;
					}
				}
			}
		}
	}

	/**
	 * Continue through a nested end-to-end flow. The nested declaration is expanded once per component context, and the
	 * parent candidate is forked for every nested candidate whose leading connection path is compatible.
	 */
	private void processEndToEndFlow(ComponentInstance ci, EndToEndFlowInstance etei, EndToEndFlow ete,
			FlowIterator iter) {
		TraversalState traversal = getState(etei);
		FlowCandidate candidate = traversal.candidate;

		int cycleStart = activeDeclarations.indexOf(ete);
		if (cycleStart >= 0) {
			for (int i = cycleStart; i < activeDeclarations.size(); i++) {
				FlowExpansion failedExpansion = expansions.get(activeDeclarations.get(i));
				failedExpansion.status = ExpansionStatus.FAILED;
				for (FlowCandidate failedCandidate : failedExpansion.candidates) {
					failedCandidate.status = CandidateStatus.FAILED;
				}
			}
			reportCandidateError(candidate,
					"Cyclic dependency between end to end flows involving " + ete.getQualifiedName());
			traversal.connections.clear();
			return;
		}

		// instantiate the nested ete if that hasn't been done already
		if (!expansions.containsKey(ete)) {
			host.expandNestedFlow(ci, ete);
		}
		FlowExpansion nestedExpansion = expansions.get(ete);
		if (nestedExpansion.status == ExpansionStatus.FAILED) {
			candidate.expansion.status = ExpansionStatus.FAILED;
			for (FlowCandidate failedCandidate : candidate.expansion.candidates) {
				failedCandidate.status = CandidateStatus.FAILED;
			}
			traversal.connections.clear();
			return;
		}
		List<FlowCandidate> nestedETEs = nestedExpansion.candidates.stream()
				.filter(nested -> nested.status == CandidateStatus.COMPLETE)
				.toList();

		if (nestedETEs.isEmpty()) {
			reportCandidateError(candidate, "No nested end to end flows instantiated for " + ete.getQualifiedName());
			traversal.connections.clear();
			return;
		}
		// add connection(s), will be empty when starting the ETE
		if (traversal.connections.isEmpty()) {
			TraversalState stateClone = null;
			Iterator<FlowCandidate> nestedIter = nestedETEs.iterator();

			traversal.continuations.push(iter);
			while (nestedIter.hasNext()) {
				FlowCandidate nested = nestedIter.next();
				boolean prepareNext = nestedIter.hasNext();

				if (prepareNext) {
					stateClone = forkState(getState(etei));
					etei.setName(etei.getEndToEndFlow().getName());
				}
				TraversalState branchState = getState(etei);
				FlowIterator continuation = branchState.continuations.pop();

				etei.getFlowElements().add(nested.instance);

				// prepare next connection filter
				branchState.connections.clear();
				branchState.connections.addAll(nested.postConnections);
				if (continuation.hasNext()) {
					Connection conn = getConnection(continuation.next());
					if (conn != null) {
						branchState.connections.add(conn);
					}
				}

				continueFlow(ci, etei, continuation, ci);

				if (prepareNext) {
					activeState = stateClone;
					etei = stateClone.candidate.instance;
				}
			}
		} else {
			List<ConnectionInstance> connis = FlowConnectionMatcher.collectConnectionInstances(ci, etei,
					traversal.connections);

			if (connis.isEmpty()) {
				reportCandidateError(candidate, "Incomplete end-to-end flow instance " + etei.getName()
						+ ": Missing connection instance to " + ete.getName());
				traversal.connections.clear();
			} else {
				record NestedMatch(ConnectionInstance connection, FlowCandidate nested) {
				}
				List<NestedMatch> matches = new ArrayList<>();
				for (ConnectionInstance conni : connis) {
					for (FlowCandidate nested : nestedETEs) {
						if (FlowConnectionMatcher.isCompatibleNestedConnection(conni, nested.preConnections,
								nested.instance)) {
							matches.add(new NestedMatch(conni, nested));
						}
					}
				}
				if (matches.isEmpty()) {
					reportCandidateError(candidate, "Incomplete end-to-end flow instance " + etei.getName()
							+ ": No compatible nested end to end flow instance for " + ete.getName());
					traversal.connections.clear();
					return;
				}

				Iterator<NestedMatch> matchIter = matches.iterator();
				traversal.continuations.push(iter);
				while (matchIter.hasNext()) {
					TraversalState stateClone = null;
					NestedMatch match = matchIter.next();
					boolean prepareNext = matchIter.hasNext();

					if (prepareNext) {
						stateClone = forkState(getState(etei));
						etei.setName(etei.getEndToEndFlow().getName());
					}
					TraversalState branchState = getState(etei);
					FlowIterator continuation = branchState.continuations.pop();

					// Preserve path order: the incoming connection precedes the nested flow.
					etei.getFlowElements().add(match.connection());
					etei.getFlowElements().add(match.nested().instance);

					// prepare next connection filter
					branchState.connections.clear();
					branchState.connections.addAll(match.nested().postConnections);
					if (continuation.hasNext()) {
						Connection nextConnection = getConnection(continuation.next());
						if (nextConnection != null) {
							branchState.connections.add(nextConnection);
						}
					}

					continueFlow(ci, etei, continuation, ci);

					if (prepareNext) {
						activeState = stateClone;
						etei = stateClone.candidate.instance;
					}
				}
			}
		}
	}

	/**
	 * Add the concrete instance object represented by a declarative leaf.
	 *
	 * @param ci the component instance containing the leaf
	 * @param etei the candidate receiving the leaf
	 * @param leaf a flow specification, flow implementation, or subcomponent
	 * @return whether the leaf was added successfully
	 */
	private boolean addLeafElement(ComponentInstance ci, EndToEndFlowInstance etei, Element leaf) {
		FlowCandidate candidate = getCandidate(etei);
		FlowSpecification fs = switch (leaf) {
		case FlowImplementation flowImplementation -> flowImplementation.getSpecification();
		case FlowSpecification flowSpecification -> flowSpecification;
		default -> null;
		};
		if (fs != null) {
			// append a flow specification instance
			FlowSpecificationInstance fsi = ci.findFlowSpecInstance(fs);
			if (fsi != null) {
				etei.getFlowElements().add(fsi);
			} else {
				reportOwnerError(candidate, "Incomplete end-to-end flow instance " + etei.getName()
						+ ": Could not find flow spec " + fs.getName() + " of component " + ci.getName());
				return false;
			}
		} else if (leaf instanceof Subcomponent) {
			if (etei.getFlowElements().isEmpty()) {
				// append a subcomponent instance
				etei.getFlowElements().add(ci);
			} else {
				ConnectionInstance preConn = (ConnectionInstance) etei.getFlowElements().getLast();
				ConnectionInstanceEnd end = preConn.getDestination();
				ComponentInstance comp = end.getContainingComponentInstance();
				if (end instanceof ComponentInstance || comp == ci) {
					// append a subcomponent instance
					etei.getFlowElements().add(ci);
				} else {
					reportOwnerError(candidate,
							"Invalid end-to-end flow instance " + etei.getName() + ": Connection "
									+ preConn.getComponentInstancePath() + " continues into component "
									+ ci.getInstanceObjectPath());
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Resume traversal until the active candidate completes, aborts, switches to another branch, or reaches the system
	 * boundary. Exhausted nested continuations move traversal back to the containing component.
	 */
	private void continueFlow(ComponentInstance ci, EndToEndFlowInstance etei, FlowIterator iter,
			NamedElement errorElement) {
		FlowCandidate candidate = getCandidate(etei);
		while (true) {
			if (host.isCanceled()) {
				canceled = true;
				return;
			}
			if (candidate.status == CandidateStatus.ABORTED || candidate.status == CandidateStatus.FAILED) {
				return;
			}
			if (activeState == null || activeState.candidate != candidate) {
				return;
			}
			TraversalState traversal = activeState;
			if (ci == null) {
				reportExistingElementError(candidate, errorElement,
						"Flow instance leaves system instance for flow " + getProspectivePath(candidate));
				traversal.connections.clear();
				return;
			}
			while (iter.hasNext()) {
				Element e = iter.next();
				host.processETESegment(ci, etei, e, iter, errorElement);
				if (candidate.status == CandidateStatus.ABORTED || candidate.status == CandidateStatus.FAILED
						|| activeState == null || activeState.candidate != candidate) {
					return;
				}
			}
			if (candidate.status == CandidateStatus.COMPLETE) {
				return;
			}
			if (traversal.continuations.isEmpty()) {
				if (candidate.status == CandidateStatus.ACTIVE) {
					if (candidate.instance.getFlowElements().isEmpty()) {
						traversal.connections.clear();
						failCandidate(candidate);
					} else {
						candidate.postConnections.addAll(traversal.connections);
						traversal.connections.clear();
						candidate.status = CandidateStatus.COMPLETE;
					}
				}
				break;
			}
			iter = traversal.continuations.pop();
			ci = ci.getContainingComponentInstance();
		}
	}

	private static Connection getConnection(Element segment) {
		if (segment instanceof FlowSegment fs) {
			return fs.getFlowElement() instanceof Connection connection ? connection : null;
		}
		if (segment instanceof EndToEndFlowSegment eefs) {
			return eefs.getFlowElement() instanceof Connection connection ? connection : null;
		}
		return null;
	}
}
