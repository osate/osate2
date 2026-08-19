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

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
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
import org.osate.aadl2.Feature;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.ThreadClassifier;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceFactory;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.instance.util.InstanceUtil;
import org.osate.aadl2.instance.util.InstanceUtil.InstantiatedClassifier;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.modelsupport.util.AadlUtil;

/**
 * Instantiates declarative end-to-end flows for each component instance.
 * <p>
 * Flow discovery builds detached candidates with branch-local traversal state. A declaration may produce multiple
 * candidates when several flow implementations, connection instances, access targets, or nested end-to-end flow
 * variants match. Only completed candidates are attached to the component, in one commit after discovery finishes.
 * Cancellation therefore leaves the component's existing end-to-end flows unchanged.
 * <p>
 * Nested end-to-end flows are expanded once per component context. Their leading and trailing declarative connection
 * paths are retained so parent candidates can select compatible nested variants and continue after them.
 * <p>
 * Internal consistency failures throw {@link IllegalStateException} intentionally. Continuing after an invariant has
 * failed could publish an instance model whose flow graph cannot be trusted.
 *
 * @author lwrage
 */
public class CreateEndToEndFlowsSwitch extends AadlProcessingSwitchWithProgress {

	static class FlowIterator implements Iterator<Element> {

		private final List<? extends Element> segments;

		private int index;

		public FlowIterator(EndToEndFlow ete) {
			this(ete.getAllFlowSegments(), 0);
		}

		public FlowIterator(FlowImplementation flowImpl) {
			this(flowImpl.getOwnedFlowSegments(), 0);
		}

		private FlowIterator(List<? extends Element> segments, int index) {
			this.segments = segments;
			this.index = index;
		}

		@Override
		public boolean hasNext() {
			return index < segments.size();
		}

		@Override
		public Element next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return segments.get(index++);
		}

		private FlowIterator copy() {
			return new FlowIterator(segments, index);
		}
	}

	static class ETEInfo {
		List<Connection> preConns;
		EndToEndFlowInstance etei;
		List<Connection> postConns = new ArrayList<>();

		public ETEInfo(EndToEndFlowInstance etei) {
			preConns = new ArrayList<>();
			this.etei = etei;
		}

		public ETEInfo(List<Connection> preConns, EndToEndFlowInstance etei) {
			this.preConns = preConns;
			this.etei = etei;
		}
	}

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

	/**
	 * All discovery and commit state for one component instance.
	 */
	private static final class FlowInstantiationContext {
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

		private FlowInstantiationContext(ComponentInstance owner) {
			this.owner = owner;
			initialFlows = List.copyOf(owner.getEndToEndFlows());
		}
	}

	/**
	 * A classifier for an instance object when it is a prototype in the
	 * declarative model. The classifier is the result of resolving the
	 * prototype. It's either the classifier that is instantiated as a
	 * subcomponent or feature group instance or the classifier referenced by a
	 * feature or subprogram call. If the classifier is anonymous, then its
	 * bindings are included also.
	 */
	private final HashMap<InstanceObject, InstantiatedClassifier> classifierCache;

	private FlowInstantiationContext activeContext;
	private TraversalState activeState;

	/**
	 * Create an end-to-end flow instantiation pass.
	 *
	 * @param pm the progress monitor
	 * @param errMgr the error manager
	 * @param classifierCache cache of known instantiated classifiers, may be
	 *            null
	 */
	public CreateEndToEndFlowsSwitch(final IProgressMonitor pm, final AnalysisErrorReporterManager errMgr,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache) {
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
				ComponentImplementation impl;

				if (ci.getContainingComponentInstance() instanceof SystemInstance) {
					monitor.subTask("Creating end-to-end flows in " + ci.getName());
				}
				FlowInstantiationContext previousContext = activeContext;
				TraversalState previousState = activeState;
				FlowInstantiationContext context = new FlowInstantiationContext(ci);
				activeContext = context;
				activeState = null;
				try {
					impl = InstanceUtil.getComponentImplementation(ci, 0, classifierCache);
					if (impl != null) {
						for (EndToEndFlow ete : impl.getAllEndToEndFlows()) {
							if (monitor.isCanceled()) {
								context.canceled = true;
								cancelTraversal();
								break;
							}
							if (!context.expansions.containsKey(ete)) {
								instantiateEndToEndFlow(ci, ete, null);
							}
						}
					}
					if (!context.canceled && !monitor.isCanceled()) {
						commit(context);
					}
				} finally {
					activeContext = previousContext;
					activeState = previousState;
				}
				return DONE;
			}
		};
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
	 */
	protected void instantiateEndToEndFlow(ComponentInstance ci, EndToEndFlow ete,
			HashMap<EndToEndFlow, List<ETEInfo>> ete2info) {
		FlowInstantiationContext previousContext = activeContext;
		TraversalState previousState = activeState;
		boolean standalone = activeContext == null;
		if (standalone) {
			activeContext = new FlowInstantiationContext(ci);
		} else if (activeContext.owner != ci) {
			// EndToEndFlow is not a FlowElement, so a nested ETE segment can only be expanded at its declaration's level.
			throw new IllegalStateException("End-to-end flow expansion crossed component contexts");
		}

		try {
			FlowExpansion expansion = expandEndToEndFlow(activeContext, ci, ete);
			updateCompatibilityInfo(expansion, ete2info);
			if (standalone && !activeContext.canceled && !monitor.isCanceled()) {
				commit(activeContext);
			}
		} finally {
			if (standalone) {
				activeContext = previousContext;
				activeState = previousState;
			}
		}
	}

	private FlowExpansion expandEndToEndFlow(FlowInstantiationContext context, ComponentInstance ci,
			EndToEndFlow ete) {
		FlowExpansion existing = context.expansions.get(ete);
		if (existing != null) {
			return existing;
		}

		FlowExpansion expansion = new FlowExpansion(ete);
		context.expansions.put(ete, expansion);
		context.expansionOrder.add(expansion);
		context.activeDeclarations.add(ete);

		EndToEndFlowInstance etei = InstanceFactory.eINSTANCE.createEndToEndFlowInstance();
		etei.setName(ete.getName());
		etei.setEndToEndFlow(ete);
		FlowCandidate candidate = createCandidate(context, expansion, etei, new ArrayList<>());
		TraversalState previousState = activeState;
		activeState = new TraversalState(candidate);
		etei.getModesList().add(getModeInstances(ci, ete));
		try {
			processETE(ci, etei, ete);
		} finally {
			context.activeDeclarations.removeLast();
			if (monitor.isCanceled()) {
				context.canceled = true;
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
		return expansion;
	}

	private FlowCandidate createCandidate(FlowInstantiationContext context, FlowExpansion expansion,
			EndToEndFlowInstance instance, List<Connection> preConnections) {
		FlowCandidate candidate = new FlowCandidate(context.owner, expansion, instance, preConnections,
				context.nextCandidateSequence++);
		expansion.candidates.add(candidate);
		context.candidates.add(candidate);
		context.candidatesByInstance.put(instance, candidate);
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
		FlowCandidate candidate = createCandidate(activeContext, source.candidate.expansion, instance, preConnections);
		return source.copy(candidate);
	}

	private void updateCompatibilityInfo(FlowExpansion expansion, HashMap<EndToEndFlow, List<ETEInfo>> ete2info) {
		if (ete2info == null) {
			return;
		}
		List<ETEInfo> infos = new ArrayList<>();
		for (FlowCandidate candidate : expansion.candidates) {
			ETEInfo info = new ETEInfo(candidate.preConnections, candidate.instance);
			info.postConns = candidate.postConnections;
			infos.add(info);
		}
		ete2info.put(expansion.declaration, infos);
	}

	private FlowCandidate getCandidate(EndToEndFlowInstance etei) {
		if (activeContext == null) {
			throw new IllegalStateException("No active end-to-end flow instantiation context");
		}
		FlowCandidate candidate = activeContext.candidatesByInstance.get(etei);
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
		activeContext.diagnostics.add(new PendingDiagnostic(activeContext.nextDiagnosticSequence++,
				DiagnosticTarget.OWNER, candidate, null, message));
	}

	private void reportCandidateError(FlowCandidate candidate, String message) {
		activeContext.diagnostics.add(new PendingDiagnostic(activeContext.nextDiagnosticSequence++,
				DiagnosticTarget.CANDIDATE, candidate, null, message));
	}

	private void reportExistingElementError(FlowCandidate candidate, Element element, String message) {
		activeContext.diagnostics.add(new PendingDiagnostic(activeContext.nextDiagnosticSequence++,
				DiagnosticTarget.EXISTING_ELEMENT, candidate, element, message));
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

	/**
	 * Publish all completed candidates for a component. Candidate names are assigned deterministically, nested
	 * references are checked before attachment, and modes are finalized with nested flows before their parents. If mode
	 * finalization fails, attachment and transient mode state are rolled back before the exception is propagated.
	 * Diagnostics are emitted only after a successful commit. Diagnostics for completed candidates target the attached
	 * flow instance; diagnostics for discarded candidates target the owning component instance.
	 */
	private void commit(FlowInstantiationContext context) {
		if (context.canceled || monitor.isCanceled()) {
			return;
		}
		if (!context.owner.getEndToEndFlows().equals(context.initialFlows)) {
			throw new IllegalStateException("End-to-end flow list changed during candidate discovery");
		}

		for (FlowExpansion expansion : context.expansionOrder) {
			List<FlowCandidate> successful = expansion.candidates.stream()
					.filter(candidate -> candidate.status == CandidateStatus.COMPLETE)
					.sorted(Comparator.comparingLong(candidate -> candidate.sequence))
					.toList();
			if (successful.size() == 1) {
				successful.get(0).instance.setName(expansion.declaration.getName());
			} else if (successful.size() > 1) {
				resetETECloneCount();
				for (FlowCandidate candidate : successful) {
					setCloneName(candidate.instance);
				}
			}
		}

		List<FlowCandidate> successful = context.candidates.stream()
				.filter(candidate -> candidate.status == CandidateStatus.COMPLETE)
				.sorted(Comparator.comparingLong(candidate -> candidate.sequence))
				.toList();
		for (FlowCandidate candidate : successful) {
			for (FlowElementInstance element : candidate.instance.getFlowElements()) {
				if (element instanceof EndToEndFlowInstance nested) {
					FlowCandidate nestedCandidate = context.candidatesByInstance.get(nested);
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

		context.owner.getEndToEndFlows().addAll(instances);
		try {
			Map<FlowCandidate, Boolean> finalized = new IdentityHashMap<>();
			Map<FlowCandidate, Boolean> finalizing = new IdentityHashMap<>();
			for (FlowCandidate candidate : successful) {
				finalizeModes(context, candidate, finalized, finalizing);
			}
		} catch (RuntimeException | Error exception) {
			context.owner.getEndToEndFlows().removeAll(instances);
			for (FlowCandidate candidate : successful) {
				candidate.instance.getModesList().clear();
				candidate.instance.getModesList().addAll(modeSnapshots.get(candidate));
				candidate.instance.getInSystemOperationModes().clear();
				candidate.instance.getInSystemOperationModes().addAll(somSnapshots.get(candidate));
			}
			throw exception;
		}

		for (PendingDiagnostic diagnostic : context.diagnostics.stream()
				.sorted(Comparator.comparingLong(PendingDiagnostic::sequence))
				.toList()) {
			switch (diagnostic.target()) {
			case OWNER -> error(diagnostic.candidate().owner, diagnostic.message());
			case CANDIDATE -> {
				if (diagnostic.candidate().status == CandidateStatus.COMPLETE) {
					error(diagnostic.candidate().instance, diagnostic.message());
				} else {
					error(diagnostic.candidate().owner,
							diagnostic.candidate().instance.getName() + " could not be instantiated: "
									+ diagnostic.message());
				}
			}
			case EXISTING_ELEMENT -> error(diagnostic.existingElement(), diagnostic.message());
			}
		}
	}

	/**
	 * Finalize a candidate's system operation modes after finalizing any nested candidates it references.
	 */
	private void finalizeModes(FlowInstantiationContext context, FlowCandidate candidate,
			Map<FlowCandidate, Boolean> finalized, Map<FlowCandidate, Boolean> finalizing) {
		if (finalized.containsKey(candidate)) {
			return;
		}
		if (finalizing.put(candidate, Boolean.TRUE) != null) {
			throw new IllegalStateException("Cyclic committed end-to-end flow graph");
		}
		for (FlowElementInstance element : candidate.instance.getFlowElements()) {
			if (element instanceof EndToEndFlowInstance nested) {
				FlowCandidate nestedCandidate = context.candidatesByInstance.get(nested);
				if (nestedCandidate != null && nestedCandidate.status == CandidateStatus.COMPLETE) {
					finalizeModes(context, nestedCandidate, finalized, finalizing);
				}
			}
		}
		fillinModes(candidate.instance);
		candidate.instance.getModesList().clear();
		finalizing.remove(candidate);
		finalized.put(candidate, Boolean.TRUE);
	}

	protected void processETE(final ComponentInstance ci, final EndToEndFlowInstance etei, final EndToEndFlow ete) {
		FlowIterator iter = new FlowIterator(ete);
		EndToEndFlowSegment fe = (EndToEndFlowSegment) iter.next();

		processETESegment(ci, etei, fe, iter, ete);
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
				processSubcomponentFlow(sci, etei, flowSpecification, iter);
			} else {
				reportOwnerError(candidate,
						"Incomplete End-to-end flow instance " + etei.getName()
								+ ": Could not find component instance for subcomponent " + sc.getName()
								+ " in flow implementation " + errorElement.getName());
			}
		} else if (fe instanceof Subcomponent subcomponent) {
			ComponentInstance sci = ci.findSubcomponentInstance(subcomponent);
			processFlowStep(sci, etei, fe, iter);
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
	protected void processSubcomponentFlow(final ComponentInstance ci, EndToEndFlowInstance etei,
			final FlowSpecification fs, FlowIterator iter) {
		FlowCandidate candidate = getCandidate(etei);
		final ComponentImplementation subImpl = InstanceUtil.getComponentImplementation(ci, 0, classifierCache);
		final EList<FlowImplementation> flowImpls = new BasicEList<>(10);

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
			int errorsBefore = activeContext.diagnostics.size();
			processFlowStep(ci, etei, fs, iter);
			if (subImpl != null && AadlUtil.hasPortComponents(subImpl)
					&& activeContext.diagnostics.size() == errorsBefore) {
				reportOwnerError(candidate, "Cannot create end to end flow '" + etei.getName()
						+ "' because component '" + ci.getName()
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
					etei.getModesList().add(getModeInstances(ci, flowImpl));
					getState(etei).continuations.pop();

					processFlowStep(ci, etei, fs, iter);
				} else {
					if (!processFlowImpl(ci, etei, flowImpl)) {
						processFlowStep(ci, etei, fs, flowImpl, iter);
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
	protected boolean processFlowImpl(ComponentInstance ci, EndToEndFlowInstance etei, FlowImplementation flowImpl) {
		etei.getModesList().add(getModeInstances(ci, flowImpl));

		if (flowImpl.getOwnedFlowSegments().size() < 2) {
			// the flow impl doesn't include a subcomponent, nothing to do
			getState(etei).continuations.pop();
			return false;
		}

		continueFlow(ci, etei, new FlowIterator(flowImpl), ci);
		return true;
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
			List<ConnectionInstance> connis = collectConnectionInstances(ci, etei, traversal.connections);

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
					if ((flowFilter == null || isValidContinuation(flowFilter, ciToCheck))
							&& (nextFlowImpl == null
									? (leaf instanceof FlowSpecification flowSpecification
											? isValidContinuation(ci, ciToCheck, flowSpecification)
											: true)
									: isValidContinuation(ciToCheck, nextFlowImpl))) {
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
	 * Check whether a connection instance ends at the input feature of a flow implementation.
	 *
	 * @param conni the connection instance
	 * @param fimpl the flow implementation that must follow the connection
	 * @return whether the connection destination is the flow input
	 */
	boolean isValidContinuation(ConnectionInstance conni, FlowImplementation fimpl) {
		boolean result = false;
		ConnectionInstanceEnd dst = conni.getDestination();
		if (dst instanceof FeatureInstance featureInstance) {
			Feature flowIn = fimpl.getInEnd().getFeature();
			Feature connDst = featureInstance.getFeature();
			result = flowIn == connDst;
		}
		return result;
	}

	/**
	 * Check whether a connection instance ends at a flow specification's source feature. A connection to the source
	 * feature itself or to a feature nested within it is accepted by walking up the feature-instance containment chain.
	 *
	 * @param flowComponent the component that owns the flow specification instance
	 * @param conni the connection instance
	 * @param fspec the flow specification that must follow the connection
	 * @return whether the connection destination reaches the flow source
	 */
	boolean isValidContinuation(ComponentInstance flowComponent, ConnectionInstance conni, FlowSpecification fspec) {
		ConnectionInstanceEnd cie = conni.getDestination();
		if (cie instanceof FeatureInstance conniFi) {
			FlowSpecificationInstance fsi = flowComponent.findFlowSpecInstance(fspec);
			if (fsi != null) {
				FeatureInstance fsSrcFi = fsi.getSource();
				EObject e = conniFi;
				while (e instanceof FeatureInstance fi) {
					if (fi == fsSrcFi) {
						return true;
					}
					e = fi.eContainer();
				}
			}
		}
		return false;
	}

	/**
	 * Check whether a connection instance starts at the output feature of a flow implementation.
	 *
	 * @param fimpl the flow implementation that must precede the connection
	 * @param conni the connection instance
	 * @return whether the connection source is the flow output
	 */
	boolean isValidContinuation(FlowImplementation fimpl, ConnectionInstance conni) {
		boolean result = false;
		ConnectionInstanceEnd src = conni.getSource();
		if (src instanceof FeatureInstance featureInstance) {
			Feature flowOut = fimpl.getOutEnd().getFeature();
			Feature connSrc = featureInstance.getFeature();
			result = flowOut == connSrc;
		}
		return result;
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
			List<ConnectionInstance> connis = collectConnectionInstances(ci, etei, traversal.connections);

			if (connis.isEmpty()) {
				reportCandidateError(candidate, "Incomplete end-to-end flow instance " + etei.getName()
						+ ": Missing connection instance to " + a.getName());
				traversal.connections.clear();
			} else {
				record AccessMatch(ConnectionInstance connection, ComponentInstance target,
						EndToEndFlowElement leaf) {
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

		int cycleStart = activeContext.activeDeclarations.indexOf(ete);
		if (cycleStart >= 0) {
			for (int i = cycleStart; i < activeContext.activeDeclarations.size(); i++) {
				FlowExpansion failedExpansion = activeContext.expansions.get(activeContext.activeDeclarations.get(i));
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
		if (!activeContext.expansions.containsKey(ete)) {
			instantiateEndToEndFlow(ci, ete, null);
		}
		FlowExpansion nestedExpansion = activeContext.expansions.get(ete);
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
			List<ConnectionInstance> connis = collectConnectionInstances(ci, etei, traversal.connections);

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
						if (isCompatibleNestedConnection(conni, nested)) {
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
	 * Check whether an incoming connection reaches the start of a nested end-to-end flow candidate.
	 */
	private boolean isCompatibleNestedConnection(ConnectionInstance connection, FlowCandidate nested) {
		if (!containsConnectionPath(connection, nested.preConnections)) {
			return false;
		}

		ConnectionInstanceEnd destination = connection.getDestination();
		ConnectionInstanceEnd nestedStart = getFirstConnectionEnd(nested.instance);
		if (destination instanceof FeatureInstance destinationFeature
				&& nestedStart instanceof FeatureInstance nestedFeature) {
			return isSameorContains(nestedFeature, destinationFeature);
		}
		if (nestedStart instanceof ComponentInstance nestedComponent) {
			return destination == nestedComponent || destination.getComponentInstance() == nestedComponent;
		}
		return destination == nestedStart;
	}

	/**
	 * Check whether a connection instance contains a declarative connection path as a contiguous sequence.
	 */
	private static boolean containsConnectionPath(ConnectionInstance connectionInstance,
			List<Connection> connectionPath) {
		if (connectionPath.isEmpty()) {
			return true;
		}

		EList<ConnectionReference> references = connectionInstance.getConnectionReferences();
		for (int start = 0; start <= references.size() - connectionPath.size(); start++) {
			boolean match = true;
			for (int offset = 0; match && offset < connectionPath.size(); offset++) {
				match = references.get(start + offset).getConnection() == connectionPath.get(offset);
			}
			if (match) {
				return true;
			}
		}
		return false;
	}

	private ConnectionInstanceEnd getFirstConnectionEnd(EndToEndFlowInstance etei) {
		EList<FlowElementInstance> elements = etei.getFlowElements();
		if (elements.isEmpty()) {
			return null;
		}

		return switch (elements.getFirst()) {
		case EndToEndFlowInstance nested -> getFirstConnectionEnd(nested);
		case FlowSpecificationInstance flowSpecification -> flowSpecification.getSource();
		case ConnectionInstance connection -> connection.getSource();
		case ComponentInstance component -> component;
		case null, default -> null;
		};
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
			if (monitor.isCanceled()) {
				activeContext.canceled = true;
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
				processETESegment(ci, etei, e, iter, errorElement);
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

	// -------------------------------------------------------------------------
	// Helper methods
	// -------------------------------------------------------------------------

	private static Connection getConnection(Element segment) {
		if (segment instanceof FlowSegment fs) {
			return fs.getFlowElement() instanceof Connection connection ? connection : null;
		}
		if (segment instanceof EndToEndFlowSegment eefs) {
			return eefs.getFlowElement() instanceof Connection connection ? connection : null;
		}
		return null;
	}

	/**
	 * Get all enclosing connection instances that pass through the given declarative connection sequence and continue
	 * from the candidate's current endpoint.
	 */
	private List<ConnectionInstance> collectConnectionInstances(ComponentInstance ci, EndToEndFlowInstance etei,
			List<Connection> connections) {
		List<ConnectionInstance> result = new ArrayList<>();

		for (ConnectionInstance conni : ci.allEnclosingConnectionInstances()) {
			if (testConnection(conni, etei, connections)) {
				result.add(conni);
			}
		}
		return result;
	}

	/**
	 * Match a connection instance against a contiguous sequence of declarative connections. Refined connections are
	 * considered equivalent; single-connection paths are also checked for flow direction; feature-group expansion is
	 * checked against the candidate's last feature.
	 *
	 * @param conni the connection instance to test
	 * @param etei the candidate whose current endpoint constrains the match
	 * @param connections the declarative connection sequence
	 * @return whether the connection instance continues the candidate along the requested sequence
	 */
	private boolean testConnection(ConnectionInstance conni, EndToEndFlowInstance etei,
			List<Connection> connections) {
		Iterator<ConnectionReference> refIter = conni.getConnectionReferences().iterator();
		boolean match = false;

		while (refIter.hasNext()) {
			if (isSameOrRefinedConnection(refIter.next().getConnection(), connections.get(0))) {
				Iterator<Connection> connIter = connections.iterator();

				connIter.next();
				match = true;
				while (match && refIter.hasNext() && connIter.hasNext()) {
					match &= isSameOrRefinedConnection(refIter.next().getConnection(), connIter.next());
				}
				if (!refIter.hasNext() && connIter.hasNext()) {
					match = false;
				}
			}
		}
		if (match && connections.size() == 1) {
			// make sure connection instance goes in the same direction as the flow
			ComponentInstance connci = conni.getSource().getComponentInstance();
			FlowElementInstance fei = etei;

			while (fei instanceof EndToEndFlowInstance nested) {
				fei = nested.getFlowElements().getLast();
			}
			if (fei instanceof FlowSpecificationInstance flowSpecification) {
				fei = flowSpecification.getComponentInstance();
			}
			ComponentInstance flowci = (ComponentInstance) fei;

			match = false;
			ComponentInstance ci = connci;
			while (!(ci instanceof SystemInstance)) {
				if (ci == flowci) {
					match = true;
					break;
				}
				ci = ci.getContainingComponentInstance();
			}
		}
		if (match) {
			// test if the connection instance is connected to the end of the ete instance
			// relevant if the flow goes through a port of a feature group and the connection
			// instance comes from an expanded fg connection
			ConnectionInstanceEnd src = conni.getSource();

			if (src instanceof FeatureInstance firstFeature) {
				FeatureInstance lastFeature = getLastFeature(etei);
				if (lastFeature != null) {
					match = isSameorContains(lastFeature, firstFeature);
				}
			}
		}
		return match;
	}

	private boolean isSameOrRefinedConnection(Connection first, Connection second) {
		for (Connection connection = first; connection != null; connection = connection.getRefined()) {
			if (connection == second) {
				return true;
			}
		}
		for (Connection connection = second; connection != null; connection = connection.getRefined()) {
			if (connection == first) {
				return true;
			}
		}
		return false;
	}

	private boolean isSameorContains(FeatureInstance flowFeature, FeatureInstance connFeature) {
		EObject matchme = connFeature;
		while (matchme instanceof FeatureInstance featureInstance) {
			if (featureInstance == flowFeature) {
				return true;
			}
			matchme = featureInstance.eContainer();
		}
		return false;
	}

	private FeatureInstance getLastFeature(EndToEndFlowInstance etei) {
		EList<FlowElementInstance> feis = etei.getFlowElements();
		if (feis.isEmpty()) {
			return null;
		}

		return switch (feis.getLast()) {
		case EndToEndFlowInstance nested -> getLastFeature(nested);
		case FlowSpecificationInstance flowSpecification -> flowSpecification.getDestination();
		case ConnectionInstance connection -> connection.getDestination() instanceof FeatureInstance featureInstance
				? featureInstance
				: null;
		case null, default -> null;
		};
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
		EList<ModeInstance> mis = new BasicEList<>();
		List<Mode> mlist = e.getAllInModes();

		if (!mlist.isEmpty()) {
			for (Mode m : mlist) {
				ModeInstance mi = ci.findModeInstance(m);

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

	protected void fillinModes(EndToEndFlowInstance etei) {

		if (etei.getSystemInstance().getSystemOperationModes().size() <= 1) {
			return;
		}

		// first, calculate intersection of all connection and ete instance SOMs
		EList<FlowElementInstance> feis = etei.getFlowElements();
		List<SystemOperationMode> soms = new ArrayList<>(etei.getSystemInstance().getSystemOperationModes());

		for (FlowElementInstance fei : feis) {
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
		for (FlowElementInstance fei : feis) {
			if (fei instanceof FlowSpecificationInstance fsi) {
				soms.removeIf(som -> !fsi.isActive(som));
			} else if (fei instanceof ComponentInstance ci) {
				soms.removeIf(som -> !ci.isActive(som));
			}
		}

		// finally, keep those SOMs where the ete and used flow implementations are active
		for (SystemOperationMode som : soms) {
			if (containsModeInstances(som, etei.getModesList())) {
				etei.getInSystemOperationModes().add(som);
			}
		}

		etei.getModesList().clear();
	}

	private boolean containsModeInstances(SystemOperationMode som, List<EList<ModeInstance>> modeLists) {
		outer: for (List<ModeInstance> mis : modeLists) {
			if (!mis.isEmpty()) {
				for (ModeInstance mi : mis) {
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
