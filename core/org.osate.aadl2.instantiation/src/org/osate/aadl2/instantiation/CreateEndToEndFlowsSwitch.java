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
import org.osate.aadl2.FlowElement;
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
 * @author lwrage
 */
public class CreateEndToEndFlowsSwitch extends AadlProcessingSwitchWithProgress {

	static class FlowIterator implements Iterator<Element> {

		private EList<EndToEndFlowSegment> eteSegments;

		private EList<FlowSegment> flowSegments;

		private int size;

		private int index;

		public FlowIterator(EndToEndFlow ete) {
			eteSegments = ete.getAllFlowSegments();
			size = eteSegments.size();
			index = 0;
		}

		public FlowIterator(FlowImplementation flowImpl) {
			flowSegments = flowImpl.getOwnedFlowSegments();
			size = flowSegments.size();
			index = 0;
		}

		private FlowIterator(EList<EndToEndFlowSegment> eteSegments, EList<FlowSegment> flowSegments, int index) {
			this.eteSegments = eteSegments;
			this.flowSegments = flowSegments;
			size = eteSegments != null ? eteSegments.size() : flowSegments.size();
			this.index = index;
		}

		@Override
		public boolean hasNext() {
			return index < size;
		}

		@Override
		public Element next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return eteSegments != null ? eteSegments.get(index++) : flowSegments.get(index++);
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see java.lang.Object#clone()
		 */
		@Override
		protected FlowIterator clone() {
			return new FlowIterator(eteSegments, flowSegments, index);
		}
	}

	static class ETEInfo implements Cloneable {
		List<Connection> preConns;
		EndToEndFlowInstance etei;
		List<Connection> postConns = new ArrayList<Connection>();

		/**
		 * @param etei
		 */
		public ETEInfo(EndToEndFlowInstance etei) {
			preConns = new ArrayList<Connection>();
			this.etei = etei;
		}

		public ETEInfo(List<Connection> preConns, EndToEndFlowInstance etei) {
			this.preConns = preConns;
			this.etei = etei;
		}
	}

	private enum CandidateStatus {
		ACTIVE, COMPLETE, FAILED, ABORTED
	}

	private enum ExpansionStatus {
		EXPANDING, COMPLETE, FAILED
	}

	private enum DiagnosticTarget {
		OWNER, CANDIDATE, EXISTING_ELEMENT
	}

	private static final class PendingDiagnostic {
		private final long sequence;
		private final DiagnosticTarget target;
		private final FlowCandidate candidate;
		private final Element existingElement;
		private final String message;

		private PendingDiagnostic(long sequence, DiagnosticTarget target, FlowCandidate candidate,
				Element existingElement, String message) {
			this.sequence = sequence;
			this.target = target;
			this.candidate = candidate;
			this.existingElement = existingElement;
			this.message = message;
		}
	}

	private static final class FlowExpansion {
		private final EndToEndFlow declaration;
		private final List<FlowCandidate> candidates = new ArrayList<>();
		private ExpansionStatus status = ExpansionStatus.EXPANDING;

		private FlowExpansion(EndToEndFlow declaration) {
			this.declaration = declaration;
		}
	}

	private static final class FlowCandidate {
		private final ComponentInstance owner;
		private final FlowExpansion expansion;
		private final EndToEndFlowInstance instance;
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
				copy.continuations.addLast(continuation.clone());
			}
			copy.connections.addAll(connections);
			copy.flowImplementations.addAll(flowImplementations);
			return copy;
		}
	}

	private static final class FlowInstantiationContext {
		private final ComponentInstance owner;
		private final List<EndToEndFlowInstance> initialFlows;
		private final Map<EndToEndFlow, FlowExpansion> expansions = new IdentityHashMap<>();
		private final List<FlowExpansion> expansionOrder = new ArrayList<>();
		private final List<FlowCandidate> candidates = new ArrayList<>();
		private final Map<EndToEndFlowInstance, FlowCandidate> candidatesByInstance = new IdentityHashMap<>();
		private final List<EndToEndFlow> activeDeclarations = new ArrayList<>();
		private final List<PendingDiagnostic> diagnostics = new ArrayList<>();
		private final HashMap<EndToEndFlow, List<ETEInfo>> compatibilityInfo = new HashMap<>();
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
	 * Create a new instance.
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
								instantiateEndToEndFlow(ci, ete, context.compatibilityInfo);
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

	protected void instantiateEndToEndFlow(ComponentInstance ci, EndToEndFlow ete,
			HashMap<EndToEndFlow, List<ETEInfo>> ete2info) {
		FlowInstantiationContext previousContext = activeContext;
		TraversalState previousState = activeState;
		boolean standalone = activeContext == null;
		if (standalone) {
			activeContext = new FlowInstantiationContext(ci);
		} else if (activeContext.owner != ci) {
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
			context.activeDeclarations.remove(context.activeDeclarations.size() - 1);
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
						createdCandidate.status = CandidateStatus.COMPLETE;
					}
				}
				expansion.status = ExpansionStatus.COMPLETE;
			}
			activeState = previousState;
			updateCompatibilityInfo(expansion, context.compatibilityInfo);
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

	private TraversalState forkState(TraversalState source) {
		EndToEndFlowInstance instance = EcoreUtil.copy(source.candidate.instance);
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
				.sorted(Comparator.comparingLong(pending -> pending.sequence))
				.toList()) {
			switch (diagnostic.target) {
			case OWNER:
				error(diagnostic.candidate.owner, diagnostic.message);
				break;
			case CANDIDATE:
				if (diagnostic.candidate.status == CandidateStatus.COMPLETE) {
					error(diagnostic.candidate.instance, diagnostic.message);
				}
				break;
			case EXISTING_ELEMENT:
				error(diagnostic.existingElement, diagnostic.message);
				break;
			default:
				throw new IllegalStateException("Unknown diagnostic target");
			}
		}
	}

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
	 * Add all flow instances that continue through the next flow element.
	 *
	 * @param ci the component instance we're in
	 * @param etei the current flow instance
	 * @param fe the next flow element
	 * @param iter the position in the current ETE declaration
	 * @param errorElement the model element that we attach errors to
	 */
	protected void processETESegment(ComponentInstance ci, EndToEndFlowInstance etei, Element fs, FlowIterator iter,
			NamedElement errorElement) {
		TraversalState traversal = getState(etei);
		FlowCandidate candidate = traversal.candidate;
		final Element fe;

		if (fs instanceof FlowSegment) {
			fe = ((FlowSegment) fs).getFlowElement();
		} else {
			fe = ((EndToEndFlowSegment) fs).getFlowElement();
		}

		if (fe instanceof Connection) {
			if (etei.getFlowElements() == null || etei.getFlowElements().isEmpty()) {
				candidate.preConnections.add((Connection) fe);
			} else {
				traversal.connections.add((Connection) fe);
			}
		} else {
			if (fe instanceof FlowSpecification) {
				final Subcomponent sc = (Subcomponent) (fs instanceof FlowSegment ? ((FlowSegment) fs).getContext()
						: ((EndToEndFlowSegment) fs).getContext());
				final ComponentInstance sci = ci.findSubcomponentInstance(sc);
				if (sci != null) {
					processSubcomponentFlow(sci, etei, (FlowSpecification) fe, iter);
				} else {
					reportOwnerError(candidate,
							"Incomplete End-to-end flow instance " + etei.getName()
									+ ": Could not find component instance for subcomponent " + sc.getName()
									+ " in flow implementation " + errorElement.getName());
				}
			} else if (fe instanceof Subcomponent) {
				ComponentInstance sci = ci.findSubcomponentInstance((Subcomponent) fe);
				processFlowStep(sci, etei, fe, iter);
			} else if (fe instanceof DataAccess da) {
				processAccess(ci, etei, da, iter);
			} else if (fe instanceof SubprogramAccess sa) {
				processAccess(ci, etei, sa, iter);
			} else if (fe instanceof EndToEndFlow) {
				processEndToEndFlow(ci, etei, (EndToEndFlow) fe, iter);
			}
		}
	}

	/**
	 * Instantiate a flow specification by recursively following its
	 * implementation until a leaf element is reached In case of a leaf element
	 * add it as a flow step
	 *
	 * @param ci the component whose flow specification is to be processed
	 * @param etei the end to end flow instance
	 * @param fs the flow specification to be processed
	 */
	protected void processSubcomponentFlow(final ComponentInstance ci, EndToEndFlowInstance etei,
			final FlowSpecification fs, FlowIterator iter) {
		FlowCandidate candidate = getCandidate(etei);
		final ComponentImplementation subImpl = InstanceUtil.getComponentImplementation(ci, 0, classifierCache);
		final EList<FlowImplementation> flowImpls = new BasicEList<FlowImplementation>(10);

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
					iterClone = iter.clone();
				}

				// add all ete instances that continue through flow impl

				/*
				 * Special case for Issue 1953: If flowImpl is a flow in a Thread, and has a non-trivial implementation
				 * (i.e, it doesn't just pass through), then we ignore the flow implementation details and just use the
				 * flow specification. Specifically, we are trying NOT to ignore the case where the flow specification
				 * uses a feature group and the flow implementation refines the feature group to a specific feature
				 * of that feature group. THese cases are necessary to reduce the combinatorics of the instance model.
				 *
				 * CAVEAT: Make sure we don't discard the mode information from the flow implementation, even if we are
				 * ignoring the flow segments.
				 */
				if (subImpl instanceof ThreadClassifier && flowImpl.getOwnedFlowSegments().size() != 0) {
					// Do use the modes from the flow implementation
					etei.getModesList().add(getModeInstances(ci, flowImpl));
					getState(etei).continuations.pop();

					// Revert to using the flow specification
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
	 * @return if elements were added to the end to end flow instance
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
	 * Add all ETE instances that continue through a given leaf flow element.
	 * One instance per matching connection.
	 *
	 * @param ci
	 * @param etei the current end to end flow instance
	 * @param leaf the next ETE element
	 * @param iter the position in the current end to end flow declaration
	 */
	protected void processFlowStep(ComponentInstance ci, EndToEndFlowInstance etei, Element leaf, FlowIterator iter) {
		processFlowStep(ci, etei, leaf, null, iter);
	}

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
			removeLastFlowImplementation(activeState);
		} else {
			List<ConnectionInstance> connis = collectConnectionInstances(ci, etei, traversal.connections);

			if (connis.isEmpty()) {
				traversal.connections.clear();
				failCandidate(candidate);

				if (!traversal.flowImplementations.isEmpty()) {
					FlowImplementation flowFilter = traversal.flowImplementations
							.get(traversal.flowImplementations.size() - 1);
					if (flowFilter != null) {
						/* [**] See note below. */
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
						: traversal.flowImplementations.get(traversal.flowImplementations.size() - 1);

				/*
				 * Issue 1984: isValidContinuation() should be used purely as a filter, and not as an error
				 * reporter. We need to make a first pass through the connection instances and determine which
				 * ones are applicable to the current flow. Only if NONE of them are, do we report an error.
				 * Otherwise, we use the subset of applicable connection instances and continue on normally.
				 */
				final List<ConnectionInstance> connectionsToUse = new ArrayList<>();
				for (final ConnectionInstance ciToCheck : connis) {
					if ((flowFilter == null || isValidContinuation(etei, flowFilter, ciToCheck))
							&& (nextFlowImpl == null
									? (leaf instanceof FlowSpecification
											? isValidContinuation(ci, ciToCheck, (FlowSpecification) leaf)
											: true)
									: isValidContinuation(etei, ciToCheck, nextFlowImpl))) {
						connectionsToUse.add(ciToCheck);
					}
				}

				if (connectionsToUse.isEmpty()) {
					/*
					 * I originally thought that this case couldn't happen, but I've been proven wrong. This happens when the
					 * connections inside a component implementation completely bypass the flow implementation. That is, the
					 * flow implies one path, but the actual connections in the implementation make a different one.
					 *
					 * This error is the opposite of the case above [**].
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
						TraversalState stateClone = null;
						FlowIterator iterClone = null;

						if (prepareNext) {
							stateClone = forkState(getState(etei));
							iterClone = iter.clone();
						}

						getState(etei).flowImplementations.add(nextFlowImpl);
						etei.getFlowElements().add(conni);
						if (addLeafElement(ci, etei, leaf)) {
							// prepare next connection filter
							getState(etei).connections.clear();
							if (iter.hasNext()) {
								Connection conn = getConnection(iter.next());
								if (conn != null) {
									getState(etei).connections.add(conn);
								}
							}

							continueFlow(ci.getContainingComponentInstance(), etei, iter, ci);
						} else {
							getState(etei).connections.clear();
							abortCandidate(getCandidate(etei));
						}

						removeLastFlowImplementation(activeState);

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

	private static void removeLastFlowImplementation(TraversalState state) {
		if (state != null && !state.flowImplementations.isEmpty()) {
			state.flowImplementations.remove(state.flowImplementations.size() - 1);
		}
	}

	/**
	 * Check if a connection destination is the start of a flow implementation
	 * @param conn
	 * @param flow
	 * @return
	 */
	boolean isValidContinuation(EndToEndFlowInstance etei, ConnectionInstance conni, FlowImplementation fimpl) {
		boolean result = false;
		ConnectionInstanceEnd dst = conni.getDestination();
		if (dst instanceof FeatureInstance) {
			Feature flowIn = fimpl.getInEnd().getFeature();
			Feature connDst = ((FeatureInstance) dst).getFeature();
			result = flowIn == connDst;
		}
		return result;
	}

	/**
	 * Check if connection ends at flow specification.
	 *
	 * There are three cases
	 * - same feature instance
	 * - connection end is a feature instance contained in the flow spec src feature instance
	 * - connection end is a feature in an array and the flow spec src is the array without index
	 *
	 * @param flowComponent
	 * @param conni
	 * @param fspec
	 * @return
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
	 * Check if a connection source is the end of a flow implementation
	 * @param conn
	 * @param flow
	 * @return
	 */
	boolean isValidContinuation(EndToEndFlowInstance etei, FlowImplementation fimpl, ConnectionInstance conni) {
		boolean result = false;
		ConnectionInstanceEnd src = conni.getSource();
		if (src instanceof FeatureInstance) {
			Feature flowOut = fimpl.getOutEnd().getFeature();
			Feature connSrc = ((FeatureInstance) src).getFeature();
			result = flowOut == connSrc;
		}
		return result;
	}

	/**
	 * Add the ETE instance that goes through a data access feature. Instead of
	 * the data access feature, add the accessed object to the ETE instance. The
	 * access feature uniquely determines the accessed object.
	 *
	 * @param ci
	 * @param etei
	 * @param fe
	 * @param iter
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
						+ ": Missing connection instance to " + ((NamedElement) a).getName());
				traversal.connections.clear();
			} else {
				Iterator<ConnectionInstance> connIter = connis.iterator();
				boolean errorReported = false;

				traversal.continuations.push(iter);
				while (connIter.hasNext()) {
					TraversalState stateClone = null;
					ConnectionInstance conni = connIter.next();
					boolean prepareNext = connIter.hasNext();
					EndToEndFlowElement leaf = null;
					ComponentInstance target = null;

					if (conni.getDestination() instanceof ComponentInstance) {
						target = (ComponentInstance) conni.getDestination();

						if (target.getCategory() == ComponentCategory.DATA
								|| target.getCategory() == ComponentCategory.SUBPROGRAM) {
							leaf = target.getSubcomponent();
						}
					} else {
						if (!errorReported) {
							errorReported = true;
							reportCandidateError(getCandidate(etei), "Access feature " + a.getQualifiedName()
									+ " is not a proxy for a data or subprogram component.");
						}
					}

					if (leaf != null) {
						if (prepareNext) {
							stateClone = forkState(getState(etei));
							etei.setName(etei.getEndToEndFlow().getName());
						}

						etei.getFlowElements().add(conni);
						addLeafElement(target, etei, leaf);

						// prepare next connection filter
						TraversalState branchState = getState(etei);
						Connection lastConn = branchState.connections.get(branchState.connections.size() - 1);

						branchState.connections.clear();
						if (iter.hasNext()) {
							Connection nextConn = getConnection(iter.next());
							if (nextConn != null) {
								int i = conni.getConnectionReferences().size() - 1;
								Connection preConn = null;

								while (i > 0 && preConn != lastConn) {
									preConn = conni.getConnectionReferences().get(i--).getConnection();
									if (preConn != lastConn) {
										branchState.connections.add(preConn);
									}
								}
								branchState.connections.add(nextConn);
							}
						}

						continueFlow(ci, etei, branchState.continuations.pop(), ci);

						if (prepareNext) {
							activeState = stateClone;
							etei = stateClone.candidate.instance;
						}
					}
				}
			}
		}
	}

	/**
	 *
	 * @param ci
	 * @param etei
	 * @param ete
	 * @param iter
	 */
	// add preConn before addNested
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
			instantiateEndToEndFlow(ci, ete, activeContext.compatibilityInfo);
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

				addNestedETE(etei, nested);

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
						+ ": Missing connection instance to " + ((NamedElement) ete).getName());
				traversal.connections.clear();
			} else {
				int compatibleCount = 0;
				for (ConnectionInstance conni : connis) {
					for (FlowCandidate nested : nestedETEs) {
						if (containsConnectionPath(conni, nested.preConnections)) {
							compatibleCount++;
						}
					}
				}
				if (compatibleCount == 0) {
					reportCandidateError(candidate, "Incomplete end-to-end flow instance " + etei.getName()
							+ ": No compatible nested end to end flow instance for " + ete.getName());
					traversal.connections.clear();
					return;
				}

				Iterator<ConnectionInstance> connIter = connis.iterator();
				traversal.continuations.push(iter);
				while (connIter.hasNext()) {
					TraversalState stateClone = null;
					ConnectionInstance conni = connIter.next();
					Iterator<FlowCandidate> nestedIter = nestedETEs.iterator();

					while (nestedIter.hasNext()) {
						FlowCandidate nested = nestedIter.next();
						if (!containsConnectionPath(conni, nested.preConnections)) {
							continue;
						}
						boolean prepareNext = --compatibleCount > 0;

						if (prepareNext) {
							stateClone = forkState(getState(etei));
							etei.setName(etei.getEndToEndFlow().getName());
						}
						TraversalState branchState = getState(etei);
						FlowIterator continuation = branchState.continuations.pop();

						etei.getFlowElements().add(conni);
						addNestedETE(etei, nested);

						// prepare next connection filter
						branchState.connections.clear();
						branchState.connections.addAll(nested.postConnections);
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
	}

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

	private void addNestedETE(EndToEndFlowInstance etei, FlowCandidate nested) {
		etei.getFlowElements().add(nested.instance);
	}

	/**
	 * @param ci
	 * @param etei
	 * @param leaf
	 * @return whether the leaf was added successfully
	 */
	private boolean addLeafElement(ComponentInstance ci, EndToEndFlowInstance etei, Element leaf) {
		FlowCandidate candidate = getCandidate(etei);
		FlowSpecification fs;
		FlowSpecificationInstance fsi;
		if (leaf instanceof FlowSpecification || leaf instanceof FlowImplementation) {
			// append a flow specification instance
			if (leaf instanceof FlowImplementation) {
				FlowImplementation fi = (FlowImplementation) leaf;
				fs = fi.getSpecification();
			} else {
				fs = (FlowSpecification) leaf;
			}
			fsi = ci.findFlowSpecInstance(fs);
			if (fsi != null) {
				etei.getFlowElements().add(fsi);
			} else if (fs != null) {
				reportOwnerError(candidate, "Incomplete end-to-end flow instance " + etei.getName()
						+ ": Could not find flow spec " + fs.getName() + " of component " + ci.getName());
				return false;
			}
		} else if (leaf instanceof Subcomponent) {
			if (etei.getFlowElements().size() == 0) {
				// append a subcomponent instance
				etei.getFlowElements().add(ci);
			} else {
				ConnectionInstance preConn = (ConnectionInstance) etei.getFlowElements()
						.get(etei.getFlowElements().size() - 1);
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

	private void continueFlow(ComponentInstance ci, EndToEndFlowInstance etei, FlowIterator iter,
			NamedElement errorElement) {
		FlowCandidate candidate = getCandidate(etei);
		while (true) {
			if (monitor.isCanceled()) {
				activeContext.canceled = true;
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
				if (candidate.status == CandidateStatus.ABORTED
						|| activeState == null || activeState.candidate != candidate) {
					return;
				}
			}
			if (candidate.status == CandidateStatus.COMPLETE) {
				return;
			}
			if (traversal.continuations.isEmpty()) {
				if (candidate.status == CandidateStatus.ACTIVE) {
					candidate.postConnections.addAll(traversal.connections);
					traversal.connections.clear();
					candidate.status = CandidateStatus.COMPLETE;
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
	 * Get all connection instances that pass through the sequence of
	 * declarative connections.
	 */
	private List<ConnectionInstance> collectConnectionInstances(ComponentInstance ci, EndToEndFlowInstance etei,
			List<Connection> connections) {
		List<ConnectionInstance> result = new ArrayList<ConnectionInstance>();

		for (ConnectionInstance conni : ci.allEnclosingConnectionInstances()) {
			if (testConnection(conni, etei, connections)) {
				result.add(conni);
			}
		}
		return result;
	}

	/**
	 * @param conni
	 * @param etei
	 * @param result
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

			while (fei instanceof EndToEndFlowInstance) {
				fei = ((EndToEndFlowInstance) fei).getFlowElements()
						.get(((EndToEndFlowInstance) fei).getFlowElements().size() - 1);
			}
			if (fei instanceof FlowSpecificationInstance) {
				fei = fei.getComponentInstance();
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

			if (src instanceof FeatureInstance) {
				FeatureInstance firstFeature = (FeatureInstance) src;
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
		while (matchme instanceof FeatureInstance) {
			if (matchme == flowFeature) {
				return true;
			}
			matchme = matchme.eContainer();
		}
		return false;
	}

	private FeatureInstance getLastFeature(EndToEndFlowInstance etei) {
		EList<FlowElementInstance> feis = etei.getFlowElements();
		FeatureInstance lastFeature = null;

		if (!feis.isEmpty()) {
			FlowElementInstance lastElement = feis.get(feis.size() - 1);

			if (lastElement instanceof EndToEndFlowInstance) {
				lastFeature = getLastFeature((EndToEndFlowInstance) lastElement);
			} else if (lastElement instanceof FlowSpecificationInstance) {
				lastFeature = ((FlowSpecificationInstance) lastElement).getDestination();
			} else if (lastElement instanceof ConnectionInstance) {
				ConnectionInstanceEnd dst = ((ConnectionInstance) lastElement).getDestination();
				if (dst instanceof FeatureInstance) {
					lastFeature = (FeatureInstance) dst;
				}
			}
		}
		return lastFeature;
	}

	// -------------------------------------------------------------------------
	// Mode utilities
	// -------------------------------------------------------------------------

	/**
	 * build mode instance list from mode list relative to the component
	 * instance ci
	 *
	 * @param ci Component Instance
	 * @param mlist mode list
	 * @return list of mode instances
	 */
	protected EList<ModeInstance> getModeInstances(ComponentInstance ci, ModalElement e) {
		EList<ModeInstance> mis = new BasicEList<ModeInstance>();
		List<Mode> mlist = e.getAllInModes();

		if (!mlist.isEmpty()) {
			for (Mode m : mlist) {
				ModeInstance mi = ci.findModeInstance(m);

				if (mi != null) {
					mis.add(mi);
				}
			}
		} else {
			// get modes form containment hierarchy
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
		List<SystemOperationMode> soms = new ArrayList<SystemOperationMode>(
				etei.getSystemInstance().getSystemOperationModes());

		for (FlowElementInstance fei : feis) {
			List<SystemOperationMode> newSoms = new ArrayList<SystemOperationMode>();

			if (fei instanceof ConnectionInstance) {
				ConnectionInstance conni = (ConnectionInstance) fei;

				if (conni.getInSystemOperationModes().isEmpty()) {
					continue;
				}
				for (SystemOperationMode som : soms) {
					if (conni.getInSystemOperationModes().contains(som)) {
						newSoms.add(som);
					}
				}
			} else if (fei instanceof EndToEndFlowInstance) {
				EndToEndFlowInstance efi = (EndToEndFlowInstance) fei;

				if (efi.getInSystemOperationModes().isEmpty()) {
					continue;
				}
				for (SystemOperationMode som : soms) {
					if (efi.getInSystemOperationModes().contains(som)) {
						newSoms.add(som);
					}
				}
			} else {
				continue;
			}
			soms = newSoms;
		}

		// then, keep those SOMs where all other flow elements are active
		for (FlowElementInstance fei : feis) {
			List<SystemOperationMode> newSoms = new ArrayList<SystemOperationMode>();
			if (fei instanceof FlowSpecificationInstance) {
				FlowSpecificationInstance fsi = (FlowSpecificationInstance) fei;

				for (SystemOperationMode som : soms) {
					if (fsi.isActive(som)) {
						newSoms.add(som);
					}
				}
			} else if (fei instanceof ComponentInstance) {
				ComponentInstance ci = (ComponentInstance) fei;

				for (SystemOperationMode som : soms) {
					if (ci.isActive(som)) {
						newSoms.add(som);
					}
				}
			} else {
				continue;
			}
			soms = newSoms;
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
