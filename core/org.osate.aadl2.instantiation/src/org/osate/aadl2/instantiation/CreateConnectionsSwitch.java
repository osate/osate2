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

import static org.osate.aadl2.ComponentCategory.BUS;
import static org.osate.aadl2.ComponentCategory.DATA;
import static org.osate.aadl2.ComponentCategory.DEVICE;
import static org.osate.aadl2.ComponentCategory.PROCESSOR;
import static org.osate.aadl2.ComponentCategory.SUBPROGRAM;
import static org.osate.aadl2.ComponentCategory.SUBPROGRAM_GROUP;
import static org.osate.aadl2.ComponentCategory.THREAD;
import static org.osate.aadl2.ComponentCategory.VIRTUAL_BUS;
import static org.osate.aadl2.ComponentCategory.VIRTUAL_PROCESSOR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Access;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupConnection;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.ParameterConnection;
import org.osate.aadl2.Port;
import org.osate.aadl2.ProcessorFeature;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.contrib.modeling.ClassifierMatchingRule;
import org.osate.aadl2.contrib.modeling.ModelingProperties;
import org.osate.aadl2.impl.ParameterImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.instance.util.InstanceUtil;
import org.osate.aadl2.instance.util.InstanceUtil.InstantiatedClassifier;
import org.osate.aadl2.instantiation.internal.ConnectionTraversalStrategy;
import org.osate.aadl2.instantiation.internal.LeafExpansion;
import org.osate.aadl2.instantiation.internal.LegResolver;
import org.osate.aadl2.instantiation.internal.LegResult;
import org.osate.aadl2.instantiation.internal.LegRole;
import org.osate.aadl2.instantiation.internal.PathAssembler;
import org.osate.aadl2.instantiation.internal.PathMaterializer;
import org.osate.aadl2.instantiation.internal.SeedDiscovery;
import org.osate.aadl2.instantiation.internal.SemanticConnectionPath;
import org.osate.aadl2.instantiation.internal.TraversalSeed;
import org.osate.aadl2.instantiation.internal.TraversalObservations;
import org.osate.aadl2.instantiation.internal.TraversalObservations.Counter;
import org.osate.aadl2.instantiation.testing.DuplicateCandidateObservation;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2InstanceUtil;

/**
 * This class adds all connection instances to an instance model.
 */
public class CreateConnectionsSwitch extends AadlProcessingSwitchWithProgress {

	/**
	 * A stack of indices into feature groups. If the connections goes into
	 * feature #n when going up the hierarchy, it must come out at feature #n
	 * when going down the hierarchy. This can happen at any level, so we need a
	 * stack.
	 */
	private Stack<FeatureInstance> upFeature = new Stack<FeatureInstance>();

	/**
	 * Keeps track of indices used when going down into feature groups after we
	 * run out of indices in the up stack.
	 */
	private Stack<FeatureInstance> downFeature = new Stack<FeatureInstance>();

	/**
	 * A classifier for an instance object when it is a prototype in the
	 * declarative model. The classifier is the result of resolving the
	 * prototype. It's either the classifier that is instantiated as a
	 * subcomponent or feature group instance or the classifier referenced by a
	 * feature or subprogram call. If the classifier is anonymous, then its
	 * bindings are included also.
	 */
	private HashMap<InstanceObject, InstantiatedClassifier> classifierCache = null;

	/**
	 * Which enumeration strategy this run uses. Per-instance state, because
	 * instantiation runs happen concurrently.
	 */
	private final ConnectionTraversalStrategy strategy;

	/**
	 * Measurements and pre-materialization observations for this run. Disabled, and
	 * therefore free, unless a characterization run asked for them.
	 */
	private final TraversalObservations observations;

	/**
	 * The component the across-first traversal was rooted at, so that its seed-driven
	 * enumeration runs once rather than once per visited component.
	 */
	private ComponentInstance traversalRoot = null;

	/**
	 * Create a new instance that uses the production traversal strategy and collects
	 * no measurements.
	 *
	 * @param pm
	 *            the progress monitor
	 * @param errMgr
	 *            the error manager
	 * @param classifierCache
	 *            cache of known instantiated classifiers, may be null
	 */
	public CreateConnectionsSwitch(final IProgressMonitor pm, final AnalysisErrorReporterManager errMgr,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache) {
		this(pm, errMgr, classifierCache, ConnectionTraversalStrategy.productionDefault(),
				TraversalObservations.disabled());
	}

	/**
	 * Create a new instance with an explicit traversal strategy and measurement
	 * collector.
	 *
	 * <p>
	 * Package-private on purpose: strategy selection is migration support for the
	 * across-first traversal work, and making it public would add API to an exported
	 * package.
	 * </p>
	 *
	 * @param pm
	 *            the progress monitor
	 * @param errMgr
	 *            the error manager
	 * @param classifierCache
	 *            cache of known instantiated classifiers, may be null
	 * @param strategy
	 *            the enumeration strategy to use
	 * @param observations
	 *            where to record measurements and candidate observations
	 */
	CreateConnectionsSwitch(final IProgressMonitor pm, final AnalysisErrorReporterManager errMgr,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache,
			final ConnectionTraversalStrategy strategy, final TraversalObservations observations) {
		super(pm, PROCESS_PRE_ORDER_ALL, errMgr);
		this.strategy = strategy;
		this.observations = observations;
		this.classifierCache = classifierCache;
	}

	private boolean isOpposite(Feature feature, Subcomponent sub, Connection connection) {
		List<Feature> features = feature.getAllFeatureRefinements();
		EList<Subcomponent> subs = sub.getAllSubcomponentRefinements();
		if (features.contains(connection.getAllSource()) && subs.contains(connection.getAllSourceContext())) {
			return false;
		} else {
			if (connection.isAllBidirectional() && features.contains(connection.getAllDestination())
					&& subs.contains(connection.getAllDestinationContext())) {
				// we are going the other way on a bi-directional connection
				return true;
			}
		}
		return false;
	}

	private boolean isOpposite(Feature feature, Connection connection) {
		List<Feature> features = feature.getAllFeatureRefinements();
		if (features.contains(connection.getAllSource())) {
			return false;
		} else {
			if (connection.isAllBidirectional() && features.contains(connection.getAllDestination())) {
				// we are going the other way on a bi-directional connection
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch#initSwitches
	 * ()
	 */
	@Override
	protected void initSwitches() {
		instanceSwitch = new InstanceSwitch<String>() {

			@Override
			public String caseComponentInstance(final ComponentInstance ci) throws UnsupportedOperationException {
				if (monitor.isCanceled()) {
					cancelTraversal();
					return DONE;
				}
				if (strategy == ConnectionTraversalStrategy.ACROSS_FIRST) {
					/*
					 * Across-first enumeration is driven by seeds over the whole root rather than by
					 * visiting one component at a time, so it runs once, at the first component the
					 * traversal reaches, which is the root.
					 */
					if (traversalRoot == null) {
						traversalRoot = ci;
						instantiateAcrossFirst(ci);
					}
					return DONE;
				}
				if (!(ci instanceof SystemInstance)) {
					if (ci.getSubcomponent() != null && isFirstArrayElement(ci)) {
						// don't process instantiated referenced classifiers
						// process first component of innermost array only
						instantiateConnections(ci);
					}
				} else {
					instantiateExternalConnections((SystemInstance) ci);
				}
				return DONE;
			}
		};
	}

	/**
	 * Enumerate and materialize every semantic connection under {@code root} with
	 * across-first traversal.
	 *
	 * <p>
	 * Seeds are found once for the whole root, each seed's legs are resolved, compatible
	 * legs are joined into paths, each path is expanded to the leaf pairs that become
	 * connection instances, and each pair is materialized and attached. Modes and system
	 * operation modes are then filled in by the same code source-first uses.
	 * </p>
	 */
	private void instantiateAcrossFirst(final ComponentInstance root) {
		final SystemInstance systemInstance = root.getSystemInstance();
		final LegResolver legResolver = new LegResolver(classifierCache, root);

		for (TraversalSeed seed : SeedDiscovery.discover(root, classifierCache)) {
			observations.addSeed(seed.key());
			List<LegResult> sourceLegs = List.of();
			List<LegResult> destinationLegs = List.of();
			if (seed instanceof TraversalSeed.Across across) {
				sourceLegs = legResolver.resolve(across.segment().source(), LegRole.SOURCE_LEG);
				destinationLegs = legResolver.resolve(across.segment().destination(), LegRole.DESTINATION_LEG);
			} else if (seed instanceof TraversalSeed.Boundary boundary) {
				if (boundary.incoming()) {
					destinationLegs = legResolver.resolve(boundary.feature(), LegRole.DESTINATION_LEG);
				} else {
					sourceLegs = legResolver.resolve(boundary.feature(), LegRole.SOURCE_LEG);
				}
			} else if (seed instanceof TraversalSeed.Trigger trigger) {
				sourceLegs = legResolver.resolve(trigger.feature(), LegRole.SOURCE_LEG);
			}
			sourceLegs.forEach(leg -> observations.addLeg(leg.key()));
			destinationLegs.forEach(leg -> observations.addLeg(leg.key()));

			for (SemanticConnectionPath path : PathAssembler.join(seed, sourceLegs, destinationLegs)) {
				observations.addPath((path.complete() ? "complete|" : "incomplete|") + path.key().render());
				for (LeafExpansion.Endpoints endpoints : LeafExpansion.expand(path)) {
					observations.addExpanded(endpoints.key());
					attachAcrossFirst(systemInstance, path, endpoints);
				}
			}
			if (monitor.isCanceled()) {
				return;
			}
		}
	}

	/**
	 * Materialize one expanded endpoint pair, attach it, and fill in its modes. The
	 * duplicate check source-first needs is not repeated here: paths are already
	 * deduplicated by structured identity before expansion, so a duplicate would mean
	 * two identities produced the same connection, which is an enumeration defect rather
	 * than something to absorb silently.
	 */
	private void attachAcrossFirst(final SystemInstance systemInstance, final SemanticConnectionPath path,
			final LeafExpansion.Endpoints endpoints) {
		ComponentInstance container = PathMaterializer.container(systemInstance, path);
		ConnectionInstance conni = PathMaterializer.materialize(systemInstance, path, endpoints);
		for (ConnectionInstance existing : container.getConnectionInstances()) {
			if (existing.getSource() == conni.getSource() && existing.getDestination() == conni.getDestination()
					&& sameReferences(existing, conni)) {
				throw new IllegalStateException("Across-first traversal enumerated " + conni.getName() + " in "
						+ container.getInstanceObjectPath() + " twice");
			}
		}
		container.getConnectionInstances().add(conni);
		observations.increment(Counter.FINAL_PATHS);
		fillInModes(conni);
		fillInModeTransitions(conni);
	}

	private static boolean sameReferences(ConnectionInstance one, ConnectionInstance other) {
		if (one.getConnectionReferences().size() != other.getConnectionReferences().size()) {
			return false;
		}
		for (int i = 0; i < one.getConnectionReferences().size(); i++) {
			ConnectionReference a = one.getConnectionReferences().get(i);
			ConnectionReference b = other.getConnectionReferences().get(i);
			if (a.getConnection() != b.getConnection() || a.getContext() != b.getContext()
					|| a.isReverse() != b.isReverse()) {
				return false;
			}
		}
		return true;
	}

	private boolean isFirstArrayElement(ComponentInstance ci) {
		while (ci != null && !(ci instanceof SystemInstance)) {
			for (Long index : ci.getIndices()) {
				if (index > 1) {
					return false;
				}
			}
			ci = ci.getContainingComponentInstance();
		}
		return true;
	}

	/**
	 * Create all connection instances that start at a component instance.
	 *
	 * @param ci
	 *            The component that is the ultimate source; this should be a
	 *            thread, processor or device
	 * @throws InstantiationException
	 */
	// TODO-LW: handle access to subprograms and subprogram groups
	// TODO-LW: connections inside threads (mode conn, access)
	// TODO-LW: warning if connection incomplete
	private void instantiateConnections(final ComponentInstance ci) throws UnsupportedOperationException {
		ComponentCategory cat = ci.getCategory();
		Subcomponent sub = ci.getSubcomponent();
		ComponentInstance parentci = ci.getContainingComponentInstance();
		List<Connection> parentConns = InstanceUtil.getComponentImplementation(parentci, 0, classifierCache)
				.getAllConnections();

		if (parentci instanceof SystemInstance) {
			monitor.subTask("Creating connections in  " + ci.getName());
		}

		if (cat == DATA || cat == BUS || cat == VIRTUAL_BUS || cat == SUBPROGRAM || cat == SUBPROGRAM_GROUP) {
			// connection instance may start at a shared component
			for (Connection conn : filterStartingConnections(parentConns, sub)) {
				observations.increment(Counter.DECLARATIONS_EXAMINED);
				boolean opposite = sub.getAllSubcomponentRefinements().contains(conn.getAllDestination());

				appendSegment(ConnectionInfo.newConnectionInfo(ci), conn, parentci, opposite);
				if (monitor.isCanceled()) {
					return;
				}
			}
		}
		// connection instance may start at a feature
		List<Connection> outsideSubConns = filterOutgoingConnections(parentConns, sub);
		ComponentImplementation cimpl = InstanceUtil.getComponentImplementation(ci, 0, classifierCache);
		@SuppressWarnings("unchecked")
		List<Connection> insideSubConns = cimpl != null ? cimpl.getAllConnections() : Collections.EMPTY_LIST;
		boolean hasOutgoingFeatureSubcomponents = AadlUtil.hasOutgoingFeatureSubcomponents(ci.getComponentInstances());
		// prevFi is used to skip all but the first element in a feature array
		// TODO inspect index, instead
		FeatureInstance prevFi = null;
		for (FeatureInstance featurei : ci.getFeatureInstances()) {
			if (prevFi == null || !prevFi.getName().equalsIgnoreCase(featurei.getName())) {
				Feature feature = featurei.getFeature();
				// TODO warning if subcomponents with outgoing features
				// exist
				if (AadlUtil.hasOutgoingFeatures(featurei)) {
					List<Connection> outgoingConns = filterOutgoingConnections(outsideSubConns, feature, sub);
					/*
					 * We only care about internal connections if (1) they exist and (2) the component is either not connection ending or it is connection
					 * ending but the feature has an access feature. (Here we are deliberately ignoring any connections between a port on thread
					 * and feature of a abstract subcomponent. Such connections are currently legal but seem wrong.)
					 */
					final FeatureInfo fInfo = FeatureInfo.init(featurei);
					final boolean isConnectionEndingCategory = isConnectionEndingCategory(cat);
					final boolean lookInside = hasOutgoingFeatureSubcomponents && (!isConnectionEndingCategory || fInfo.hasAccess());
					final boolean connectedInside = lookInside && isConnectionEnd(insideSubConns, feature);
					final boolean destinationFromInside = lookInside && isDestination(insideSubConns, feature);

					for (final Connection conn : outgoingConns) {
						observations.increment(Counter.DECLARATIONS_EXAMINED);
						// conn is first segment if it can't continue inside
						// the subcomponent

						/*
						 * We start from inside the component in the following cases
						 * - The feature is a destination from inside (we have already dealt with the connection ending component case above)
						 * - The outside connection is bidirectional and the the feature is connected inside (again, we have already filtered out the connection
						 * ending component case)
						 *
						 * So, we start AT THE Component in the following cases
						 * - The disjunction of the above is false
						 * - The component is connection ending and the feature has ports or feature groups.  (This case is only relevant when
						 *   the feature is a feature group.)
						 */
						if ((!destinationFromInside && !(conn.isAllBidirectional() && connectedInside))
								|| (isConnectionEndingCategory && (fInfo.hasFeatureGroup() || fInfo.hasPort()))) {
							prevFi = featurei;
							boolean opposite = isOpposite(feature, sub, conn);
							appendSegment(ConnectionInfo.newConnectionInfo(featurei), conn, parentci, opposite);
							if (monitor.isCanceled()) {
								return;
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Create all connection instances that with an incoming port of the
	 * SystemInstance.
	 *
	 * @param si
	 *            The component that is the ultimate source;
	 */
	private void instantiateExternalConnections(final SystemInstance si) {
		List<Connection> sysConns = InstanceUtil.getComponentImplementation(si, 0, classifierCache).getAllConnections();

		for (FeatureInstance featurei : si.getFeatureInstances()) {
			processIncomingFeature(featurei, si, sysConns);
			for (FeatureInstance contained : featurei.getFeatureInstances()) {
				processIncomingFeature(contained, si, sysConns);
			}
		}
	}

	private void processIncomingFeature(FeatureInstance featurei, SystemInstance si, List<Connection> sysConns) {
		if (featurei.getFlowDirection().incoming()) {
			if (featurei.getIndex() <= 1) {
				List<Connection> inConns = filterIngoingConnections(si, sysConns, featurei);
				for (Connection conn : inConns) {
					observations.increment(Counter.DECLARATIONS_EXAMINED);
					boolean opposite = isOpposite(featurei.getFeature(), conn);

					appendSegment(ConnectionInfo.newConnectionInfo(featurei), conn, si, opposite);
					if (monitor.isCanceled()) {
						return;
					}
				}
			}
		}
	}

	/**
	 * appendSegment Append a segment to a connection instance.
	 *
	 * @param newSegment
	 *            the declarative connection to be added to the connection
	 *            instance
	 * @param ci
	 *            the component that contains the new segment
	 * @param goOpposite
	 *            the current declarative connection is bidirectional and we are
	 *            following it toward its source
	 * @param conni
	 *            the connection instance representing the semantic connection
	 */
	// TODO-LW: set 'complete' in conn info
	private void appendSegment(ConnectionInfo connInfo, final Connection newSegment, final ComponentInstance ci,
			final boolean goOpposite) {
		/*
		 * One comparable traversal state: an attempt to extend a partial semantic
		 * connection by one oriented declarative segment. Across-first traversal counts
		 * the same unit when it extends a leg, so the two strategies' state counts mean
		 * the same thing.
		 */
		observations.increment(Counter.TRAVERSAL_STATES);
		final ConnectionEnd fromEnd = goOpposite ? newSegment.getAllDestination() : newSegment.getAllSource();
		final Context fromCtx = goOpposite ? newSegment.getAllDestinationContext() : newSegment.getAllSourceContext();
		ConnectionEnd toEnd = goOpposite ? newSegment.getAllSource() : newSegment.getAllDestination();
		final Context toCtx = goOpposite ? newSegment.getAllSourceContext() : newSegment.getAllDestinationContext();
		final ComponentInstance toCi = (toCtx instanceof Subcomponent)
				? ci.findSubcomponentInstance((Subcomponent) toCtx)
				: null;
		final boolean finalComponent = isConnectionEndingComponent(toCtx);
		ConnectionInstanceEnd fromFi = null;
		ConnectionInstanceEnd toFi = null;
		FeatureInstance pushedFeature = null;
		FeatureInstance poppedFeature = null;
		FeatureInstance downedFeature = null;

		/*
		 * FIX JD If we have a data component directly connected to a subprogram
		 * parameter, we do not handle it because we do not deal with parameter
		 * connection within the instance model. See bug #220
		 */
		if ((toEnd instanceof ParameterImpl)
				&& (fromEnd instanceof DataSubcomponent || fromEnd instanceof DataAccess
						|| ci instanceof SystemInstance)) {
			return;
		}

		/*
		 * Fix JD bug #222.
		 * Tweaked again for Issue #2162: changed to check if the context is a subprogram call
		 * rather than just checking if the feature is contained in a subprogram.
		 */
		if ((toEnd instanceof DataAccess) && (toCtx instanceof SubprogramCall)) {
			return;
		}

		if (toCtx instanceof Subcomponent && toCi == null) {
			if (!(toCtx instanceof SubprogramSubcomponent)) {
				error(ci, "Instantiation error: no component instance for subcomponent " + toCtx.getName());
			}
			return;
		}

		// 'toCi' is known to exist if the destination context is a subcomponent
		final boolean dstEmpty = toCtx instanceof Subcomponent && toCi.getComponentInstances().isEmpty();

		if (!(fromEnd instanceof Subcomponent)) {
			// fromEnd is a feature
			final ComponentInstance fromCi = (fromCtx instanceof Subcomponent)
					? ci.findSubcomponentInstance((Subcomponent) fromCtx)
					: null;
			if (fromCtx instanceof Subcomponent && fromCi == null) {
				if (!(fromCtx instanceof SubprogramSubcomponent)) {
					error(ci, "Instantiation error: no component instance for subcomponent " + fromCtx.getName());
				}
				return;
			}
			List<FeatureInstance> fiList = null;

			if (fromCtx instanceof FeatureGroup) {
				// TODO phf: find index and compare with stack
				FeatureInstance fgi = (FeatureInstance) AadlUtil.findNamedElementInList(ci.getFeatureInstances(),
						fromCtx.getName());
				if (fgi != null) {
					fiList = fgi.getFeatureInstances();
					fromFi = (FeatureInstance) AadlUtil.findNamedElementInList(fiList, fromEnd.getName());
				}
				if (fromFi != null) {
					if (!upFeature.empty()) {
						FeatureInstance popfi = upFeature.peek();
						// match against stack only if we don't reach deeper into feature group
						if (connInfo.dstToMatch == null && !Aadl2InstanceUtil.isSame(popfi, (FeatureInstance) fromFi)) {
							// did not match
							return;
						} else {
							poppedFeature = upFeature.pop();
						}
					} else {
						downFeature.push((FeatureInstance) fromFi);
						downedFeature = (FeatureInstance) fromFi;
					}
				}
			} else {
				fiList = (fromCi != null ? fromCi : ci).getFeatureInstances();
				fromFi = (FeatureInstance) AadlUtil.findNamedElementInList(fiList, fromEnd.getName());
			}
		} else {
			fromFi = ci.findSubcomponentInstance((Subcomponent) fromEnd);
		}
		if (!(toEnd instanceof Subcomponent)) {
			List<FeatureInstance> fiList = null;

			if (toCtx instanceof FeatureGroup) {

				FeatureInstance fgi = (FeatureInstance) AadlUtil.findNamedElementInList(ci.getFeatureInstances(),
						toCtx.getName());
				if (fgi != null) {
					fiList = fgi.getFeatureInstances();
					toFi = (FeatureInstance) AadlUtil.findNamedElementInList(fiList, toEnd.getName());
				}
				if (toFi != null) {
					upFeature.push((FeatureInstance) toFi);
					pushedFeature = (FeatureInstance) toFi;
				}
			} else {
				fiList = (toCi != null ? toCi : ci).getFeatureInstances();
				toFi = (FeatureInstance) AadlUtil.findNamedElementInList(fiList, toEnd.getName());
			}
		} else {
			toFi = ci.findSubcomponentInstance((Subcomponent) toEnd);
		}

		/*
		 * Issue 2032: We do not want connections that go from abstract subcomponent to the ports of
		 * their containing components if the containing component is final. We specifically are
		 * checking that the connection starts at a port feature and ends at a feature that is a feature
		 * of the containing component and the containing component is a connection ending component. We don't
		 * have to check that the end feature is a port because AADL semantics guarantee that it will be.
		 */
		if (fromFi instanceof FeatureInstance && ((FeatureInstance) fromFi).getFeature() instanceof Port
				&& toFi != null && toFi.eContainer().equals(ci) && isConnectionEndingCategory(ci.getCategory())) {
			return;
		}

		try {
			boolean[] keep = { false };
			connInfo.addSegment(newSegment, fromFi, toFi, ci, goOpposite, keep);
			if (!keep[0]) {
				return;
			}
			// first check if the connection must end with the new segment
			if (toEnd instanceof Subcomponent) {
				ComponentInstance toInstance = ci.findSubcomponentInstance((Subcomponent) toEnd);
				if (toInstance == null) {
					// happens if conn leaves system to aggregate data port
					warning(ci, "Connection to " + toEnd.getQualifiedName() + " could not be instantiated.");
				} else {
					// connection ends at a shared data, bus, or subprogram (group)
					connInfo.complete = true;
					finalizeConnectionInstance(ci.getSystemInstance(), connInfo, toInstance);
				}
			} else if (toEnd instanceof InternalFeature || toEnd instanceof ProcessorFeature) {
				// can't handle these
				// FIXME: What if a connection from outside goes to one of these?
				warning(ci, "Connection to " + toEnd.getQualifiedName() + " could not be instantiated.");
			} else {
				Feature toFeature = (Feature) toEnd;

				if (toEnd instanceof Parameter) {
					// connection ends at a parameter
					FeatureInstance dstFi = toCi.findFeatureInstance(toFeature);
					if (dstFi == null) {
						error(toCi,
								"Destination feature " + toFeature.getName() + " not found. No connection created.");
					} else {
						connInfo.complete = true;
						finalizeConnectionInstance(ci, connInfo, dstFi);
					}
				} else if (dstEmpty) {
					// connection ends because the destination component does not
					// contain any subcomponents
					FeatureInstance dstFi = toCi.findFeatureInstance(toFeature);
					if (dstFi == null) {
						error(toCi,
								"Destination feature " + toFeature.getName() + " not found. No connection created.");
					} else {
						connInfo.complete = true;
						finalizeConnectionInstance(ci, connInfo, dstFi);
					}
				} else if (!(toCtx instanceof Subcomponent)) {
					// the connection may have more segments
					// going up hierarchy, connection goes to a feature in the
					// component
					// implementation
					if (ci instanceof SystemInstance) {
						if (toCtx instanceof FeatureGroup) {
							// XXX: PHF: going up into an element of a feature group
							// should we go to the FG or to the feature?
							finalizeConnectionInstance(ci, connInfo, ci.findFeatureInstance((FeatureGroup) toCtx));
						} else {
							finalizeConnectionInstance(ci, connInfo, ci.findFeatureInstance(toFeature));
						}
					} else {
						if (toCtx instanceof FeatureGroup) {
							toFeature = (FeatureGroup) toCtx;
							// toFeature now points to the enclosing feature group
							// this should be the starting feature for the next
							// connection
						}

						ComponentInstance nextCi = ci.getContainingComponentInstance();
						List<Connection> parentConns = InstanceUtil
								.getComponentImplementation(nextCi, 0, classifierCache).getAllConnections();
						FeatureInstance dstFi = ci.findFeatureInstance(toFeature);
						List<Connection> conns = filterOutgoingConnections(parentConns, dstFi.getFeature(),
								ci.getSubcomponent());

						if (conns.isEmpty()) {
							if (isModeTransitionTrigger(nextCi, toFi)) {
								connInfo.complete = true;
								finalizeConnectionInstance(ci, connInfo, toFi);
							} else if (ci instanceof SystemInstance) {
								finalizeConnectionInstance(ci, connInfo, ci.findFeatureInstance(toFeature));
							} else {
								warning(toFi,
										"Could not continue connection from " + connInfo.src.getInstanceObjectPath()
												+ "  through " + toFi.getInstanceObjectPath()
												+ ". No connection instance created.");
							}
						} else {
							for (Connection nextConn : conns) {
								// note: nextConn goes either up or across
								final ConnectionInfo clone = connInfo.cloneInfo();
								boolean opposite = false;

								/*
								 * XXX: LAST COMMENT OF THE NIGHT: I think all of this opposite stuff here works. I need
								 * to better enumerate all the cases (what the src/dest ctx would be). I think the real
								 * problem for 2318 is with the NAME-BASED look up.
								 */

								if (nextConn.isAllBidirectional()) {
									/*
									 * The next connection is bidirectional, but we need to figure out if we are
									 * traveling from its src to dest or from its dest to src.
									 *
									 * Put another way, we traverse the next connection in the opposite direction
									 * only if the destination feature instance of the next connection is equal to
									 * the destination feature instance of the current connection (based on "toFeature" which
									 * already takes it's own opposite direction into account via "goOpposite" at
									 * the start of the method).
									 */
									final ConnectionEnd nextConnDest = nextConn.getAllDestination();

									if (nextConnDest instanceof Feature) {
										final Feature nextConnDstFeature = (Feature) nextConnDest;
										FeatureInstance nextConnDstFi = nextCi.findFeatureInstance(nextConnDstFeature);

										/*
										 * If we find the connection destination in the containing component instance, then
										 * the connection is a normal (not reversed) traversal of the connection. The
										 * value of `opposite` will stay `false`.
										 */
										if (nextConnDstFi == null) {
											/*
											 * Didn't find the next destination in the containing component, so the question
											 * still is, is the destination in a sibling subcomponent or is it a reversed
											 * traversal from the containing component, or even a reversed traversal from
											 * a sibling subcomponent?
											 */
											// next goes across, maybe?
											Context nextConnDstCtx = nextConn.getAllDestinationContext();

											if (nextConnDstCtx instanceof Subcomponent) {
												final ComponentInstance nextConnDstSubi = nextCi
														.findSubcomponentInstance((Subcomponent) nextConnDstCtx);
												nextConnDstFi = nextConnDstSubi.findFeatureInstance(nextConnDstFeature);
											}

											if (nextConnDstFi != null) {
												/*
												 * Opposite is true if the dest of the next connection the same feature instance as the
												 * dest of the current connection.
												 */
												opposite = ci.findFeatureInstance(toFeature) == nextConnDstFi;
											}
										}
									}
								} else {
									/*
									 * not bidirectional, so the src of nextConn is a feature of 'ci', and the dest
									 * is a feature of either 'nextCi` or a sibling subcomponent. We are following
									 * the connection in its natural direction, so `opposite` is `false`.
									 */
								}
								appendSegment(clone, nextConn, nextCi, opposite);
							}
						}
					}
				} else {
					// going down hierarchy or across

					if (toCtx instanceof Subcomponent && toCi == null) {
						if (!(toCtx instanceof SubprogramSubcomponent)) {
							error(ci, "Instantiation error: no component instance for subcomponent " + toCtx.getName());
						}
						return;
					}

					toFi = toCi.findFeatureInstance(toFeature);

					if (toFi == null) {
						error(ci, "Could not find instance object for feature " + toEnd.getName() + " of subcomponent "
								+ ((Subcomponent) toCtx).getName() + ". No connection instance created.");
						return;
					}

					ComponentImplementation toImpl = InstanceUtil.getComponentImplementation(toCi, 0, classifierCache);
					if (toImpl == null) {
						connInfo.complete = true;
						finalizeConnectionInstance(ci, connInfo, toFi);
					} else {
						// there is a toImpl

						/*
						 * Issue 2032: Get the connections internal to the destination component that connect
						 * to the feature. Two cases here. (1) If the component is final (thread/device/processor),
						 * we only follow access features inside, (2) otherwise we follow all the internal connections
						 * except for the parameter connections. We keep track of whether any internal connections were
						 * ignored so we know if we should create a connection instance that stops at the component itself.
						 */
						final AtomicBoolean hasIgnoredConnection = new AtomicBoolean(false);
						List<Connection> conns = AadlUtil.getIngoingConnections(toImpl, toFeature,
								c -> {
									if (c instanceof AccessConnection) {
										return true; // never ignore access connections
									} else if (c instanceof ParameterConnection) {
										// always ignore parameter connections
										hasIgnoredConnection.set(true);
										return false;
									} else {
										// Ignore other connections only if the component is connection ending
										if (finalComponent) {
											hasIgnoredConnection.set(true);
											return false;
										} else {
											return true;
										}
									}
								});

						if (conns.isEmpty()) {
							// No internal connections, or they are all parameter connections, so we stop here
							List<Subcomponent> subs = toImpl.getAllSubcomponents();

							if (!subs.isEmpty()) {
								if (!finalComponent) {
									warning(ci,
											"No connection declaration from feature " + toEnd.getName()
													+ " of component " + ((Subcomponent) toCtx).getName()
													+ " to subcomponents. Connection instance ends at "
													+ ((Subcomponent) toCtx).getName());
								}
								connInfo.complete = true;
								finalizeConnectionInstance(ci, connInfo, toFi);
							}
						} else {
							// we may need to stop at the processor in addition to
							// going in

							/*
							 * Issue 2032: If we get here then destination component has internal connections,
							 * not all of which are parameter connections. We definitely are going to proceed
							 * inside the component with the connection. However, if there are internal
							 * connections that were ignored, we also need to create a connection instance that
							 * ends at the component.
							 *
							 * NB. Not possible to have an ignored parameter connection from a feature and have a
							 * another not ignored connection from that feature because the only place a
							 * parameter connection can exist is in a subprogram or a thread, and it's
							 * not possible to have a regular port connections internal to
							 * either one of those (with the exception of abstract components, but those
							 * should probably be illegal anyway and we ignore those too).
							 */
							if (hasIgnoredConnection.get()) {
								final ConnectionInfo clone = connInfo.cloneInfo();
								clone.complete = true;
								finalizeConnectionInstance(ci, clone, toFi);
							} else {
								/*
								 * Issue 3044: The flag above answers the question for the destination feature as
								 * a whole, but a feature group answers it member by member. The connections we
								 * keep may continue only some of its members, an access member reaching a
								 * subprogram for instance, and leave the rest with nowhere to go.
								 */
								stopAtUncontinuedMembers(ci, connInfo, toFeature, toFi, toCi, conns, finalComponent);
							}

							// we have ingoing connections that start with toFeature
							// as End or as Cxt
							for (Connection nextConn : conns) {
								final ConnectionInfo clone = connInfo.cloneInfo();

								EList<Feature> toflist = toFeature.getAllFeatureRefinements();
								Context dstCtx = nextConn.getAllDestinationContext();
								// dstCtx is null if we're going down and in opposite direction
								final boolean opposite = toflist.contains(nextConn.getAllDestination())
										&& (dstCtx == null || toCtx == dstCtx) || toflist.contains(dstCtx);
								appendSegment(clone, nextConn, toCi, opposite);
							}
						}
					}
				}
			}
		} finally {
			if (pushedFeature != null) {
				if (!upFeature.empty()) {
					upFeature.pop();
				} else {
					warning(ci, "Popping from empty upindex");
				}
			}
			if (poppedFeature != null) {
				if (downFeature.empty()) {
					upFeature.push(poppedFeature);
				} else {
					// remove from downIndex
					warning(ci, "Trying to push back on while downIndex is not empty");
				}
			}
			if (downedFeature != null) {
				// remove from downIndex
				FeatureInstance popfeature = downFeature.pop();
				if (!Aadl2InstanceUtil.isSame(popfeature, downedFeature)) {
					// should be the same
					warning(ci, "Did not match popped downIndex");
				}
			}
		}
	}

	/**
	 * Issue 3044: Stop the path at the destination component for the members of the destination
	 * feature that the internal connections of that component do not continue.
	 *
	 * <p>
	 * Nothing happens when every part of the feature continues inside, and nothing happens when the
	 * connections cannot be related to the feature at all, which leaves the traversal as it was for
	 * a shape we did not recognize. Otherwise the path is finalized with the members it may not end
	 * at recorded on it, because which member it ends at is only decided while it is finalized: the
	 * feature group stack narrows the end for a path that already identifies a member, and
	 * expansion pairs up the members for a path that does not.
	 * </p>
	 *
	 * <p>
	 * A connection ending component ends the connection for every member with nowhere to go.
	 * Anywhere else, only a member that triggers a mode transition of the component ends one, since
	 * a mode transition is an end in itself. The other members can reach no component that ends a
	 * connection, so stopping at them would materialize an incomplete connection; they are recorded
	 * as dead ends and reported when the path resolves to one of them.
	 * </p>
	 *
	 * @param ci the component that contains the segment that arrives at the destination component
	 * @param connInfo the path that arrives at the destination component
	 * @param toFeature the feature of the destination component the path arrives at
	 * @param toFi the instance of that feature
	 * @param toCi the destination component
	 * @param conns the internal connections of the destination component the traversal continues with
	 * @param finalComponent whether the destination component is connection ending
	 */
	private void stopAtUncontinuedMembers(final ComponentInstance ci, final ConnectionInfo connInfo,
			final Feature toFeature, final ConnectionInstanceEnd toFi, final ComponentInstance toCi,
			final List<Connection> conns, final boolean finalComponent) {
		if (!(toFi instanceof FeatureInstance dstFi) || dstFi.getFeatureInstances().isEmpty()) {
			return;
		}

		final Set<FeatureInstance> continued = continuedFeatures(dstFi, toFeature, conns);

		if (continued.isEmpty()) {
			return;
		}

		final List<FeatureInstance> uncontinued = new ArrayList<>();
		collectUncontinuedLeaves(dstFi, continued, uncontinued);
		if (uncontinued.isEmpty()) {
			return;
		}

		final Set<FeatureInstance> deadEnds = new LinkedHashSet<>();
		if (!finalComponent) {
			collectDeadEnds(dstFi, continued, toCi, deadEnds);
		}

		final ConnectionInfo clone = connInfo.cloneInfo();
		clone.complete = true;
		clone.setContinuedEnds(continued);
		clone.setDeadEnds(deadEnds);
		finalizeConnectionInstance(ci, clone, dstFi);
	}

	/**
	 * The feature instances under the feature a path arrives at that the internal connections of
	 * the destination component continue.
	 *
	 * <p>
	 * A connection names a path below the feature it reaches the component through, {@code fg.inner.p}
	 * for instance, so what continues is the feature itself or a feature nested below it at any
	 * depth.
	 * </p>
	 */
	private static Set<FeatureInstance> continuedFeatures(final FeatureInstance dstFi, final Feature toFeature,
			final List<Connection> conns) {
		final Set<FeatureInstance> continued = new LinkedHashSet<>();

		for (final Connection conn : conns) {
			final Connection root = conn.getRootConnection();
			addContinuedFeature(dstFi, toFeature, root.getSource(), continued);
			addContinuedFeature(dstFi, toFeature, root.getDestination(), continued);
		}
		return continued;
	}

	/**
	 * Add the feature instance that one end of an internal connection continues, if that end names
	 * the feature the path arrives at or something below it.
	 */
	private static void addContinuedFeature(final FeatureInstance dstFi, final Feature toFeature,
			final ConnectedElement end, final Set<FeatureInstance> continued) {
		if (end == null) {
			return;
		}

		final Context context = end.getContext();

		if (context == null) {
			// the end is the feature itself, so the whole feature continues inside
			if (namesFeature(end.getConnectionEnd(), toFeature)) {
				continued.add(dstFi);
			}
			return;
		}
		if (!namesFeature(context, toFeature)) {
			// the end is inside the component, or in another feature of it
			return;
		}

		// walk the named path down the feature instance hierarchy
		FeatureInstance current = dstFi;
		for (ConnectedElement step = end; step != null && current != null; step = step.getNext()) {
			current = (FeatureInstance) AadlUtil.findNamedElementInList(current.getFeatureInstances(),
					step.getConnectionEnd().getName());
		}
		if (current != null) {
			continued.add(current);
		}
	}

	private static boolean namesFeature(final NamedElement element, final Feature feature) {
		// a refinement keeps the name of the feature it refines
		return element instanceof Feature named && feature.getName().equalsIgnoreCase(named.getName());
	}

	/**
	 * Collect the features under the feature a path stops at that can neither be continued nor end
	 * a connection there, including a feature whose every part is one of those.
	 *
	 * <p>
	 * A feature the traversal continues into is not dead: it ends a connection instance created
	 * further in, which the continued ends take care of. A feature that triggers a mode transition
	 * of the component is not dead either, because the mode transition ends the connection. Neither
	 * makes the feature group containing it dead.
	 * </p>
	 *
	 * @return whether this feature is dead
	 */
	private static boolean collectDeadEnds(final FeatureInstance fi, final Set<FeatureInstance> continued,
			final ComponentInstance toCi, final Set<FeatureInstance> dead) {
		if (continued.contains(fi) || isModeTransitionTrigger(toCi, fi)) {
			return false;
		}
		if (fi.getFeatureInstances().isEmpty()) {
			dead.add(fi);
			return true;
		}

		boolean allDead = true;

		for (final FeatureInstance member : fi.getFeatureInstances()) {
			allDead &= collectDeadEnds(member, continued, toCi, dead);
		}
		if (allDead) {
			dead.add(fi);
		}
		return allDead;
	}

	/**
	 * Collect the leaves under a feature that the traversal does not continue. A leaf is continued
	 * when the traversal continues into it or into a feature that contains it.
	 */
	private static void collectUncontinuedLeaves(final FeatureInstance fi, final Set<FeatureInstance> continued,
			final List<FeatureInstance> result) {
		if (continued.contains(fi)) {
			return;
		}
		if (fi.getFeatureInstances().isEmpty()) {
			result.add(fi);
		} else {
			for (final FeatureInstance member : fi.getFeatureInstances()) {
				collectUncontinuedLeaves(member, continued, result);
			}
		}
	}

	private static final class FeatureInfo {
		private final boolean isFeatureGroup;
		private final boolean hasAccess;
		private final boolean hasPort;
		private final boolean hasParameter;
		private final boolean hasFeatureGroup;

		private FeatureInfo(final boolean isFeatureGroup, final boolean hasAccess, final boolean hasPort,
				final boolean hasParameter, final boolean hasFeatureGroup) {
			this.isFeatureGroup = isFeatureGroup;
			this.hasAccess = hasAccess;
			this.hasPort = hasPort;
			this.hasParameter = hasParameter;
			this.hasFeatureGroup = hasFeatureGroup;
		}

		public static FeatureInfo init(final FeatureInstance fi) {
			Feature end = fi.getFeature();
			if (fi.getFeature() instanceof FeatureGroup) {
				return init(fi.getFeatureInstances().iterator(), false, false, false, false);
			} else if (end instanceof Access) {
				return new FeatureInfo(false, true, false, false, false);
			} else if (end instanceof Parameter) {
				return new FeatureInfo(false, false, false, true, false);
			} else if (end instanceof Port) {
				return new FeatureInfo(false, false, true, false, false);
			} else {
				return new FeatureInfo(false, false, false, false, false);
			}
		}

		private static FeatureInfo init(final Iterator<FeatureInstance> iter, final boolean hasAccess, final boolean hasPort, final boolean hasParameter, final boolean hasFeatureGroup) {
			if (iter.hasNext()) {
				final Feature f = iter.next().getFeature();
				return init(iter, hasAccess || f instanceof Access, hasPort || f instanceof Port,
						hasParameter || f instanceof Parameter, hasFeatureGroup || f instanceof FeatureGroup);
			} else {
				return new FeatureInfo(true, hasAccess, hasPort, hasParameter, hasFeatureGroup);
			}
		}

		public boolean isFeatureGroup() {
			return isFeatureGroup;
		}

		public boolean hasAccess() {
			return hasAccess;
		}

		public boolean hasPort() {
			return hasPort;
		}

		public boolean hasParameter() {
			return hasParameter;
		}

		public boolean hasFeatureGroup() {
			return hasFeatureGroup;
		}
	}

	// ------------------------------------------------------------------------
	// Post-process completed connection instance
	// ------------------------------------------------------------------------

	protected void finalizeConnectionInstance(ComponentInstance parentci, final ConnectionInfo connInfo,
			ConnectionInstanceEnd dstEnd) {

		FeatureInstance upFi = null;
		if (dstEnd instanceof FeatureInstance) {
			FeatureInstance dstFi = (FeatureInstance) dstEnd;
			EList<FeatureInstance> flist = dstFi.getFeatureInstances();

			if (dstFi.getCategory() == FeatureCategory.FEATURE_GROUP && !upFeature.isEmpty()) {
				upFi = upFeature.pop();
				if (upFi.eContainer() == dstFi) {
					dstFi = upFi;
				} else {
					FeatureGroup upfg = ((FeatureGroup) ((FeatureInstance) upFi.getOwner()).getFeature());
					FeatureGroup downfg = ((FeatureGroup) dstFi.getFeature());
					FeatureGroupType upfgt = upfg.getAllFeatureGroupType();
					FeatureGroupType downfgt = downfg.getAllFeatureGroupType();
					if (downfgt == null) {
						warning(dstFi.getContainingComponentInstance(),
								"In " + dstFi.getContainingComponentInstance().getName() + " (classifier "
										+ dstFi.getContainingComponentInstance().getComponentClassifier().getName()
										+ ") feature group " + dstFi.getName() + " has no type");
					}
					if (upfgt != null && downfgt != null && upfg.isInverseOf(downfg)
							&& !upfgt.getAllFeatures().isEmpty() && !downfgt.getAllFeatures().isEmpty()) {
						dstFi = flist.get(Aadl2InstanceUtil.getFeatureIndex(upFi));
					}
				}
			}
			if (connInfo.src instanceof FeatureInstance) {
				FeatureInstance srcFi = (FeatureInstance) connInfo.src;

				if (srcFi.getFeatureInstances().isEmpty() && dstFi.getFeatureInstances().isEmpty()) {
					addConnectionInstance(parentci.getSystemInstance(), connInfo, dstFi);
				} else {
					// src and/or dst is a feature group
					balanceFeatureGroupEnds(parentci, connInfo, srcFi, dstFi);
				}
			} else if (connInfo.src instanceof ComponentInstance) {
				ComponentInstance srcCi = (ComponentInstance) connInfo.src;

				if (dstFi.getFeatureInstances().isEmpty()) {
					addConnectionInstance(parentci.getSystemInstance(), connInfo, dstFi);
				} else {
					// dst is a feature group
					balanceFeatureGroupEnds(parentci, connInfo, srcCi, dstFi);
				}
			} else {
				error(parentci.getSystemInstance(), "Connection source is neither a feature nor a component: "
						+ connInfo.src.getInstanceObjectPath() + " => " + connInfo.src.getInstanceObjectPath());
			}
			if (upFi != null) {
				upFeature.push(upFi);
			}
		} else {
			// Component Instance
			ComponentInstance dstCi = (ComponentInstance) dstEnd;

			if (connInfo.src instanceof FeatureInstance) {
				FeatureInstance srcFi = (FeatureInstance) connInfo.src;

				if (srcFi.getFeatureInstances().isEmpty()) {
					addConnectionInstance(parentci.getSystemInstance(), connInfo, dstCi);
				} else {
					// src is a feature group
					balanceFeatureGroupEnds(parentci, connInfo, srcFi, dstCi);
				}
			} else if (connInfo.src instanceof ComponentInstance) {
				error(parentci.getSystemInstance(), "Connection source and destination are components: "
						+ connInfo.src.getInstanceObjectPath() + " => " + dstCi.getInstanceObjectPath());
			} else {
				error(parentci.getSystemInstance(), "Connection source is neither a feature nor a component: "
						+ connInfo.src.getInstanceObjectPath() + " => " + dstCi.getInstanceObjectPath());
			}
		}
	}

	protected ConnectionInstance addConnectionInstance(final SystemInstance systemInstance,
			final ConnectionInfo connInfo, final ConnectionInstanceEnd dstI) {
		Element diagnosticTarget = connInfo.container != null ? connInfo.container : systemInstance;
		boolean unresolvedEndpoint = false;
		if (connInfo.src == null) {
			error(diagnosticTarget, "Connection source not found");
			unresolvedEndpoint = true;
		}
		if (dstI == null) {
			error(diagnosticTarget, "Connection destination not found");
			unresolvedEndpoint = true;
		}
		if (unresolvedEndpoint) {
			return null;
		}

		/*
		 * Issue 3044: This path stops at a component that the traversal continues into for some of
		 * the members of the feature it stops at. A member the traversal continues into ends a
		 * connection instance created further in, so this path must not end at it. A member that
		 * the traversal can neither continue into nor stop at ends no connection instance at all,
		 * and that is reported here because this is where the end of the path is known.
		 */
		if (dstI instanceof FeatureInstance dstFi) {
			if (connInfo.isContinuedEnd(dstFi)) {
				return null;
			}
			if (connInfo.isDeadEnd(dstFi)) {
				warning(dstFi, "Could not continue connection from " + connInfo.src.getInstanceObjectPath() + " through "
						+ dstFi.getInstanceObjectPath() + ". No connection instance created.");
				return null;
			}
		}

		// with aggregate data ports will be sources/destinations missing
		int numConns = connInfo.connections.size();
		if (connInfo.sources.size() != numConns || connInfo.destinations.size() != numConns) {
			// happens if conn leaves system to aggregate data port
			warning(connInfo.container, "Connection from " + connInfo.sources.get(0).getInstanceObjectPath() + " to "
					+ dstI.getInstanceObjectPath() + " could not be instantiated.");
			return null;
		}

		// check for duplicate connection instance
		// with arrays we can get duplicates that we don't need
		ComponentInstance container = connInfo.container;
		List<Connection> conns = connInfo.connections;

		if (container == null) {
			container = systemInstance;
		}
		boolean suppressedAsDuplicate = false;
		for (ConnectionInstance test : container.getConnectionInstances()) {
			// check for duplicates and do not create
			if (connInfo.src == test.getSource() && dstI == test.getDestination()
					&& conns.size() == test.getConnectionReferences().size()) {
				ListIterator<Connection> i = conns.listIterator();
				boolean isDuplicate = true;
				for (ConnectionReference ref : test.getConnectionReferences()) {
					if (ref.getConnection() != i.next()) {
						isDuplicate = false;
						break;
					}
				}
				if (!isDuplicate) {
					// also test reverse direction
					isDuplicate = true;
					i = conns.listIterator(conns.size());
					for (ConnectionReference ref : test.getConnectionReferences()) {
						if (ref.getConnection() != i.previous()) {
							isDuplicate = false;
							break;
						}
					}
				}
				if (isDuplicate) {
					suppressedAsDuplicate = true;
					break;
				}
			}
		}
		/*
		 * A suppressed candidate is never attached, so this is the only point at which it
		 * can be observed at all. Across-first traversal must know whether the
		 * candidates this check removes differ from the ones it keeps in any way that
		 * could reach a materialized descriptor.
		 */
		observeDuplicateCandidate(connInfo, dstI, container, !suppressedAsDuplicate);
		if (suppressedAsDuplicate) {
			return null;
		}
		boolean duplicate = false;

		// Generate a name for the connection
		String containerPath = (connInfo.container != null) ? container.getInstanceObjectPath()
				: systemInstance.getName();
		int len = containerPath.length() + 1;
		String srcPath = connInfo.src.getInstanceObjectPath();
		StringBuffer sb = new StringBuffer();
		String dstPath = "xxx";
		int i = (srcPath.startsWith(containerPath)) ? len : 0;
		srcPath = srcPath.substring(i);
		sb.append(srcPath);
		sb.append(" -> ");
		if (dstI != null) {
			dstPath = dstI.getInstanceObjectPath();
			i = (dstPath.startsWith(containerPath)) ? len : 0;
			dstPath = dstPath.substring(i);
			sb.append(dstPath);
		}

		ConnectionInstance conni = null;
		if (!duplicate) {
			conni = connInfo.createConnectionInstance(sb.toString(), dstI);

			if (conni == null) {
				warning(container, "Connection sequence from " + srcPath + " to " + dstPath
						+ " is only outgoing. No connection instance created.");
				return null;
			} else {
				container.getConnectionInstances().add(conni);
				observations.increment(Counter.FINAL_PATHS);
			}

			fillInModes(conni);
			fillInModeTransitions(conni);
		}
		return conni;
	}

	/**
	 * Record a candidate connection and the duplicate check's verdict on it.
	 *
	 * <p>
	 * Nothing is attached to the model here. A suppressed candidate stays a value
	 * observation, so that inspecting it cannot change what the traversal produces.
	 * </p>
	 *
	 * <p>
	 * Temporary migration support for the across-first traversal work; removed with
	 * the rest of the instrumentation.
	 * </p>
	 */
	private void observeDuplicateCandidate(final ConnectionInfo connInfo, final ConnectionInstanceEnd dstI,
			final ComponentInstance container, final boolean accepted) {
		if (!observations.isCollectingCandidates()) {
			observations.increment(Counter.DUPLICATE_CANDIDATES);
			return;
		}
		List<String> declarations = connInfo.connections.stream()
				.map(connection -> String.valueOf(EcoreUtil.getURI(connection)))
				.toList();
		List<String> contexts = connInfo.contexts.stream().map(CreateConnectionsSwitch::pathOf).toList();
		List<String> segmentSources = connInfo.sources.stream().map(CreateConnectionsSwitch::pathOf).toList();
		List<String> segmentDestinations = connInfo.destinations.stream()
				.map(CreateConnectionsSwitch::pathOf)
				.toList();
		observations.addDuplicateCandidate(new DuplicateCandidateObservation(pathOf(container), pathOf(connInfo.src),
				pathOf(dstI), declarations, contexts, List.copyOf(connInfo.opposites), segmentSources,
				segmentDestinations, connInfo.complete, accepted));
	}

	private static String pathOf(InstanceObject object) {
		return object == null ? null : object.getInstanceObjectPath();
	}

	private FeatureInstance getTopFeatureInstance(FeatureInstance fi) {
		FeatureInstance topfi = fi;
		while (topfi.getOwner() instanceof FeatureInstance) {
			topfi = (FeatureInstance) topfi.getOwner();
		}
		return topfi;
	}

	/**
	 * Handle the case where one of the ends (or both) is a feature group.
	 * Create multiple connection instances.
	 *
	 * @param parentci
	 * @param connInfo
	 * @param srcEnd
	 * @param dstEnd
	 */
	private void balanceFeatureGroupEnds(final ComponentInstance parentci, final ConnectionInfo connInfo,
			ConnectionInstanceEnd srcEnd, ConnectionInstanceEnd dstEnd) {

		if (!upFeature.isEmpty()) {
			// dstEnd is higher up in the hierarchy than srcEnd:
			// we need to match from latest to the oldest in stack going down into the FG nesting hierarchy
			for (int count = upFeature.size() - 1; count >= 0; count--) {
				FeatureInstance upFi = upFeature.get(count);
				if (upFi == dstEnd) {
					// this entry names the level dstEnd already stands at, see the down case
					continue;
				}
				EList<FeatureInstance> flist = ((FeatureInstance) dstEnd).getFeatureInstances();
				if (connInfo.dstToMatch != null) {
					String name = connInfo.dstToMatch.getConnectionEnd().getName();
					dstEnd = (FeatureInstance) AadlUtil.findNamedElementInList(flist, name);
					connInfo.dstToMatch = connInfo.dstToMatch.getNext();
				} else {
					FeatureGroup upfg = (FeatureGroup) ((FeatureInstance) upFi.getOwner()).getFeature();
					FeatureGroup downfg = (FeatureGroup) ((FeatureInstance) dstEnd).getFeature();
					FeatureGroupType upfgt = upfg.getAllFeatureGroupType();
					FeatureGroupType downfgt = downfg.getAllFeatureGroupType();
					if (upfgt != null && downfgt != null && upfg.isInverseOf(downfg)
							&& !upfgt.getAllFeatures().isEmpty() && !downfgt.getAllFeatures().isEmpty()) {
						dstEnd = flist.get(Aadl2InstanceUtil.getFeatureIndex(upFi));
					} else {
						String name = upFi.getName();
						dstEnd = (FeatureInstance) AadlUtil.findNamedElementInList(flist, name);
					}
				}
				if (dstEnd == null) {
					// this level does not exist below dstEnd, see the comment in the down case
					return;
				}
			}
		} else if (!downFeature.isEmpty()) {
			// dstEnd is further down in the hierarchy than srcEnd: find feature corresponding to dstEnd
			// We need to match from the oldest to the latest in stack.
			// This is a down stack, i.e., the highest element got pushed first and is the oldest.
			for (int count = 0; count < downFeature.size(); count++) {
				FeatureInstance downFi = downFeature.get(count);
				if (downFi == srcEnd) {
					/*
					 * Issue 3040: This entry names the level the end already stands at, so there is
					 * nothing to narrow for it.
					 *
					 * The stack counts feature group levels from the outermost boundary feature, but
					 * instantiateExternalConnections() seeds a traversal from a boundary feature and
					 * from each feature contained in one. A traversal seeded at a contained member
					 * therefore starts one or more levels below where the stack starts counting.
					 * Narrowing such an entry would look for a feature among its own children and
					 * find nothing, abandoning a path that should produce a connection instance.
					 */
					continue;
				}
				EList<FeatureInstance> flist = ((FeatureInstance) srcEnd).getFeatureInstances();
				if (connInfo.srcToMatch != null) {
					String name = connInfo.srcToMatch.getConnectionEnd().getName();
					srcEnd = (FeatureInstance) AadlUtil.findNamedElementInList(flist, name);
					connInfo.srcToMatch = connInfo.srcToMatch.getNext();
				} else {
					FeatureGroup downfg = ((FeatureGroup) ((FeatureInstance) downFi.getOwner()).getFeature());
					FeatureGroupType downfgt = downfg.getFeatureGroupType();
					FeatureGroup upfg = ((FeatureGroup) ((FeatureInstance) srcEnd).getFeature());
					FeatureGroupType upfgt = upfg.getFeatureGroupType();
					if (upfgt != null && downfgt != null && upfg.isInverseOf(downfg)
							&& !upfgt.getAllFeatures().isEmpty() && !downfgt.getAllFeatures().isEmpty()) {
						srcEnd = flist.get(Aadl2InstanceUtil.getFeatureIndex(downFi));
					} else {
						String name = downFi.getName();
						srcEnd = (FeatureInstance) AadlUtil.findNamedElementInList(flist, name);
					}
				}
				if (srcEnd == null) {
					/*
					 * Issue 3038: narrowing found no matching feature, so the path cannot be
					 * continued and must not be dereferenced.
					 *
					 * The common cause, a stack entry naming the level the end already stands at, is
					 * handled by the skip above since issue 3040; do not assume that some other seed
					 * covers whatever reaches here, because for the nested boundary shape that
					 * assumption was wrong and a connection instance went missing.
					 */
					return;
				}
			}
			connInfo.src = srcEnd;
		}

		if (srcEnd instanceof ComponentInstance && dstEnd instanceof ComponentInstance) {
			// TODO-LW: error
		} else if (srcEnd instanceof ComponentInstance || dstEnd instanceof ComponentInstance) {
			addConnectionInstance(parentci.getSystemInstance(), connInfo, dstEnd);
		} else {
			expandFeatureGroupConnection(parentci, connInfo, srcEnd, dstEnd, connInfo.srcToMatch, connInfo.dstToMatch);
		}
	}

	/**
	 * Expand feature groups as much as possible
	 *
	 * @param parentci
	 * @param connInfo
	 * @param srcEnd
	 * @param dstEnd
	 */
	private void expandFeatureGroupConnection(final ComponentInstance parentci, final ConnectionInfo connInfo,
			ConnectionInstanceEnd srcEnd, ConnectionInstanceEnd dstEnd, ConnectedElement srcToMatch,
			ConnectedElement dstToMatch) {
		ConnectionInstanceEnd oldSrc = connInfo.src;

		if (srcEnd instanceof FeatureInstance && dstEnd instanceof FeatureInstance) {
			FeatureInstance srcFi = (FeatureInstance) srcEnd;
			FeatureInstance dstFi = (FeatureInstance) dstEnd;

			if (srcToMatch != null) {
				for (FeatureInstance fi : srcFi.getFeatureInstances()) {
					if (srcToMatch.getConnectionEnd() == fi.getFeature()) {
						expandFeatureGroupConnection(parentci, connInfo, fi, dstFi, srcToMatch.getNext(), dstToMatch);
						break;
					}
				}
			} else if (dstToMatch != null) {
				for (FeatureInstance fi : dstFi.getFeatureInstances()) {
					if (dstToMatch.getConnectionEnd() == fi.getFeature()) {
						expandFeatureGroupConnection(parentci, connInfo, srcFi, fi, srcToMatch, dstToMatch.getNext());
						break;
					}
				}
			} else {
				/*
				 * One of three possible situations
				 * - both ends are feature groups without or with an empty type
				 * - one end is empty and the other is not
				 * - both ends are not empty, in this case they have the same internal structure
				 */
				if (isLeafFeature(srcFi) && isLeafFeature(dstFi)) {
					// both ends are empty
					if (connInfo.isAcross()) {
						if (srcFi.getFlowDirection().outgoing() && dstFi.getFlowDirection().incoming()) {
							connInfo.src = srcFi;
							addConnectionInstance(parentci.getSystemInstance(), connInfo, dstFi);
						}
					} else {
						boolean upOnly = isUpOnly(connInfo, srcFi, dstFi);
						if (upOnly && srcFi.getFlowDirection().outgoing() && dstFi.getFlowDirection().outgoing()
								|| !upOnly && srcFi.getFlowDirection().incoming()
										&& dstFi.getFlowDirection().incoming()) {
							connInfo.src = srcFi;
							addConnectionInstance(parentci.getSystemInstance(), connInfo, dstFi);
						}
					}
				} else if (isLeafFeature(srcFi)) {
					// first find the feature instance as an element of the other end
					FeatureInstance dst = findDestinationFeatureInstance(connInfo, dstFi);
					// we need to deal with outgoing/incoming only and check the direction correctly
					if (dst != null && ((connInfo.isAcross() && dst.getFlowDirection().incoming())
							|| dst.getFlowDirection().outgoing())) {
						expandFeatureGroupConnection(parentci, connInfo, srcFi, dst, srcToMatch, dstToMatch);
					} else if (srcFi.getCategory() == FeatureCategory.FEATURE_GROUP) {
						// we may have a feature group with no FGT or an empty FGT
						boolean upOnly = isUpOnly(connInfo, srcFi, dstFi);
						for (FeatureInstance dstelem : dstFi.getFeatureInstances()) {
							if (upOnly) {
								if (dstelem.getFlowDirection().outgoing()) {
									expandFeatureGroupConnection(parentci, connInfo, srcFi, dstelem, srcToMatch,
											dstToMatch);
								}
							} else if (dstelem.getFlowDirection().incoming()) {
								expandFeatureGroupConnection(parentci, connInfo, srcFi, dstelem, srcToMatch,
										dstToMatch);
							}
						}
					} else {
						// create the unexpanded connection instance
						connInfo.src = srcFi;
						addConnectionInstance(parentci.getSystemInstance(), connInfo, dstFi);
					}
				} else if (isLeafFeature(dstFi)) {
					FeatureInstance target = findSourceFeatureInstance(connInfo, srcFi);
					// we need to deal with outgoing/incoming only and check the direction correctly
					if (target != null && ((connInfo.isAcross() && target.getFlowDirection().outgoing())
							|| target.getFlowDirection().incoming())) {
						expandFeatureGroupConnection(parentci, connInfo, target, dstFi, srcToMatch, dstToMatch);
					} else if (dstFi.getCategory() == FeatureCategory.FEATURE_GROUP || connInfo.srcToMatch != null) {
						// we may have a feature group with no FGT or an empty FGT
						boolean downOnly = !connInfo.isAcross() && !isUpOnly(connInfo, srcFi, dstFi);
						for (FeatureInstance srcelem : srcFi.getFeatureInstances()) {
							if (downOnly) {
								if (srcelem.getFlowDirection().incoming()) {
									expandFeatureGroupConnection(parentci, connInfo, srcelem, dstFi, srcToMatch,
											dstToMatch);
								}
							} else if (srcelem.getFlowDirection().outgoing()) {
								expandFeatureGroupConnection(parentci, connInfo, srcelem, dstFi, srcToMatch,
										dstToMatch);
							}
						}
					} else {
						// create the unexpanded connection instance
						connInfo.src = srcFi;
						addConnectionInstance(parentci.getSystemInstance(), connInfo, dstFi);
					}
				} else {
					boolean isSubset = subsetMatch(connInfo.connections);
					if (!isSubset) {
						Iterator<FeatureInstance> srcIter = srcFi.getFeatureInstances().iterator();
						Iterator<FeatureInstance> dstIter = dstFi.getFeatureInstances().iterator();
						while (srcIter.hasNext() && dstIter.hasNext()) {
							FeatureInstance src = srcIter.next();
							FeatureInstance dst = dstIter.next();
							expandFeatureGroupConnection(parentci, connInfo, src, dst, srcToMatch, dstToMatch);
						}
						Assert.isTrue(!srcIter.hasNext() && !dstIter.hasNext(),
								"Connected feature groups do not have the same number of features");
					} else {
						// subset matching features by name
						for (FeatureInstance dst : dstFi.getFeatureInstances()) {
							if ((connInfo.isAcross() && dst.getFlowDirection().incoming())
									|| dst.getFlowDirection().outgoing()) {
								FeatureInstance src = findFeatureInstance(srcFi, dst.getName());
								if (src != null) {
									expandFeatureGroupConnection(parentci, connInfo, src, dst, srcToMatch, dstToMatch);
								}
							}
						}
					}
				}
			}
		}
		connInfo.src = oldSrc;

	}

	/**
	 * Does the connection go only up in the hierarchy?
	 * @param connInfo
	 * @param srcFi
	 * @param dstFi
	 * @param upOnly
	 * @return
	 */
	private boolean isUpOnly(ConnectionInfo connInfo, FeatureInstance srcFi, FeatureInstance dstFi) {
		if (!connInfo.isAcross()) {
			// if src contained in dst we're going up only
			ComponentInstance dstComponent = dstFi.getContainingComponentInstance();
			Element srcComponent = srcFi.getContainingComponentInstance();

			while (srcComponent != null) {
				if (srcComponent == dstComponent) {
					return true;
				}
				srcComponent = srcComponent.getOwner();
			}
		}
		return false;
	}

	/**
	 * find feature instance with matching name that is a leaf under fgfi
	 * @param fgfi
	 * @param name
	 * @return FeatureInstance
	 */
	FeatureInstance findFeatureInstance(FeatureInstance fgfi, String name) {
		TreeIterator<EObject> fiall = fgfi.eAllContents();
		while (fiall.hasNext()) {
			FeatureInstance fi = (FeatureInstance) fiall.next();
			if (isLeafFeature(fi) && fi.getName().equalsIgnoreCase(name)) {
				return fi;
			}
		}
		return null;

	}

	private boolean isLeafFeature(FeatureInstance fi) {
		return fi.getFeatureInstances().isEmpty();
	}

	/**
	 * Find the feature instance under FGI, whose name matches the the Feature at the other end
	 * We do this by finding the connection declaration that goes down at the other end
	 * It is found by matching the FGT name and then retrieving the feature instance matching the name
	 * @param connInfo
	 * @param fgi
	 * @return FeatureInstance
	 */

	FeatureInstance findSourceFeatureInstance(ConnectionInfo connInfo, FeatureInstance fgi) {
		List<ConnectionInstanceEnd> srclist = connInfo.sources;
		List<ConnectionInstanceEnd> dstlist = connInfo.destinations;
		ConnectionInstanceEnd target = null;
		for (int i = srclist.size() - 1; i >= 0; i--) {
			ConnectionInstanceEnd src = srclist.get(i);
			ConnectionInstanceEnd dst = dstlist.get(i);
			if (target != null && target != dst) {
				if (dst == target.eContainer()) {
					// we have a feature in a FG
					FeatureInstance targetFI = findFeatureInstance(fgi, target.getName());
					if (targetFI == null) {
						// name does not match. We may have an inverse of feature group type with its own set of feature names
						// In this case it is an index based match
						int idx = ((FeatureInstance) dst).getFeatureInstances().indexOf(target);
						if (idx >= 0) {
							targetFI = fgi.getFeatureInstances().get(idx);
						}
					}
					return targetFI;
				} else {
					target = src;
				}
			} else {
				target = src;
			}
		}
		return null;

	}

	/**
	 * Find the feature instance under FGI, whose name matches the the Feature at the other end
	 * We do this by finding the connection declaration that goes down at the other end
	 * It is found by matching the FGT name and then retrieving the feature instance matching the name
	 * @param connInfo
	 * @param fgi
	 * @return FeatureInstance
	 */
	FeatureInstance findDestinationFeatureInstance(ConnectionInfo connInfo, FeatureInstance fgi) {
		List<ConnectionInstanceEnd> srclist = connInfo.sources;
		List<ConnectionInstanceEnd> dstlist = connInfo.destinations;
		ConnectionInstanceEnd target = null;
		for (int i = 0; i < srclist.size(); i++) {
			ConnectionInstanceEnd src = srclist.get(i);
			ConnectionInstanceEnd dst = dstlist.get(i);
			if (target != null && target != src) {
				if (src == target.eContainer()) {
					// we have a feature in a FG
					FeatureInstance targetFI = findFeatureInstance(fgi, target.getName());
					if (targetFI == null) {
						// name does not match. We may have an inverse of feature group type with its own set of feature names
						// In this case it is an index based match
						int idx = ((FeatureInstance) src).getFeatureInstances().indexOf(target);
						if (idx >= 0) {
							targetFI = fgi.getFeatureInstances().get(idx);
						}
					}
					return targetFI;
				} else {
					target = dst;
				}
			} else {
				target = dst;
			}
		}
		return null;

	}

	private static boolean isModeTransitionTrigger(ComponentInstance component, ConnectionInstanceEnd end) {
		return end instanceof FeatureInstance feature && feature.getCategory() == FeatureCategory.EVENT_PORT
				&& component.getModeTransitionInstances()
						.stream()
						.anyMatch(transition -> transition.getTriggers().contains(feature));
	}

	// ------------------------------------------------------------------------
	// Helper methods related to modes
	// ------------------------------------------------------------------------

	private void fillInModeTransitions(ConnectionInstance conni) {
		ComponentInstance ci = conni.getContainingComponentInstance();

		for (ConnectionReference connRef : conni.getConnectionReferences()) {
			Connection conn = connRef.getConnection();

			for (ModeTransition mt : conn.getAllInModeTransitions()) {
				ModeTransitionInstance mti = ci.findModeTransitionInstance(mt);

				if (mti != null) {
					conni.getInModeTransitions().add(mti);
				}
			}
		}
	}

	/**
	 * For the given connection instance, identify all connection declarations
	 * with "in modes." For all possible mode combinations of those "in modes,"
	 * add those SOMs that contain the mode instance combinations.
	 *
	 * @param conni
	 *            the connection instance
	 */
	private void fillInModes(ConnectionInstance conni) {
		ListIterator<ConnectionReference> refIter = conni.getConnectionReferences().listIterator();

		while (refIter.hasNext()) {
			ConnectionReference connRef = refIter.next();
			Connection conn = connRef.getConnection();
			ComponentInstance ci = connRef.getContext();
			List<ModeInstance> mis = null;

			// source modal
			mis = getComponentModes(conni.getSource().getComponentInstance());
			// conns modal
			if (mis == null) {
				var connModes = conn.getAllInModes();
				if (connModes.isEmpty()) {
					mis = getComponentModes(ci);
				} else {
					mis = connModes.stream().map(ci::findModeInstance).collect(Collectors.toList());
				}
			}
			// destination modal
			if (mis == null) {
				mis = getComponentModes(conni.getDestination().getComponentInstance());
			}
			if (mis != null) {
				for (ModeInstance mi : mis) {
					generateModeCombinations(conni, refIter, new ArrayList<>(Collections.singletonList(mi)));
				}
				if (conni.getInSystemOperationModes().isEmpty()) {
					warning(conni.getContainingComponentInstance(), "Connection " + conni.getName()
							+ " was removed because it is not active in any system operation mode");
					EcoreUtil.delete(conni);
				}
				break;
			}
		}
	}

	private void generateModeCombinations(ConnectionInstance conni, ListIterator<ConnectionReference> refIter,
			List<ModeInstance> mis) {
		if (!refIter.hasNext()) {
			// add SOMs based on mis
			SystemInstance si = (SystemInstance) conni.getElementRoot();
			List<SystemOperationMode> somList = si.getSystemOperationModesFor(mis);

			// check if all parts of the connection exist
			outer: for (SystemOperationMode som : somList) {
				if (conni.getSource().isActive(som) && conni.getDestination().isActive(som)) {
					for (ConnectionReference cr : conni.getConnectionReferences()) {
						if (!cr.getContext().isActive(som)) {
							continue outer;
						}
					}
					conni.getInSystemOperationModes().add(som);
				}
			}
		} else {
			ConnectionReference connRef = refIter.next();
			Connection conn = connRef.getConnection();
			ComponentInstance ci = connRef.getContext();
			EList<Mode> connModes = conn.getAllInModes();
			List<ModeInstance> nextMis = null;

			if (connModes.isEmpty()) {
				nextMis = getComponentModes(ci);
			} else {
				nextMis = connModes.stream().map(ci::findModeInstance).collect(Collectors.toList());
			}
			if (nextMis != null) {
				for (ModeInstance mi : nextMis) {
					mis.add(mi);
					generateModeCombinations(conni, refIter, mis);
					mis.remove(mi);
				}
			} else {
				generateModeCombinations(conni, refIter, mis);
			}
			refIter.previous();
		}
	}

	private List<ModeInstance> getComponentModes(ComponentInstance ci) {
		while (!(ci instanceof SystemInstance)) {
			if (ci.getInModes().isEmpty()) {
				ci = ci.getContainingComponentInstance();
			} else {
				return ci.getInModes();
			}
		}
		return null;
	}

	// ------------------------------------------------------------------------
	// Helper methods for filtering connection lists
	// ------------------------------------------------------------------------

	/**
	 * Filter all (port or access) connections that start with a subcomponent.
	 *
	 * @param connlist
	 *            all connections in the component instance that contains the
	 *            subcomponent
	 * @param sub
	 *            a subcomponent
	 * @return the connections from connlist that start with the subcomponent
	 */
	protected List<Connection> filterStartingConnections(List<Connection> connlist, Subcomponent sub) {
		List<Connection> result = new ArrayList<Connection>(connlist.size());
		EList<Subcomponent> sublist = sub.getAllSubcomponentRefinements();
		for (Connection conn : connlist) {
			if (sublist.contains(conn.getAllSource())
					|| (conn.isAllBidirectional() && sublist.contains(conn.getAllDestination()))) {
				result.add(conn);
			}
		}
		return result;
	}

	/**
	 * Filter connections that leave a subcomponent through one of its features.
	 *
	 * @param connlist
	 *            all connections in the component instance that contains the
	 *            subcomponent
	 * @param sub
	 *            a subcomponent
	 * @return those connections from connlist that go out of the subcomponent
	 */
	private List<Connection> filterOutgoingConnections(List<Connection> connlist, Subcomponent sub) {
		List<Connection> result = new ArrayList<Connection>();
		List<Subcomponent> subs = sub.getAllSubcomponentRefinements();

		for (Connection conn : connlist) {
			if (subs.contains(conn.getAllSourceContext())
					|| conn.isAllBidirectional() && subs.contains(conn.getAllDestinationContext())) {
				result.add(conn);
			}
		}
		return result;
	}

	/**
	 * get ingoing connections for specified feature
	 *
	 * @param incomingconnlist
	 * @param feature
	 *            subcomponent feature that is the source of a connection
	 * @return connections with feature as destination
	 */
	public List<Connection> filterIngoingConnections(SystemInstance si, List<Connection> incomingconnlist,
			FeatureInstance fi) {
		List<Connection> result = new ArrayList<Connection>(incomingconnlist.size());
		List<Feature> features = fi.getFeature().getAllFeatureRefinements();
		List<Feature> parents;

		for (Connection conn : incomingconnlist) {
			ConnectionEnd srcEnd = conn.getAllSource();

			// a candidate end is a feature of the component or in a feature group
			// then the feature must match the passed-in feature instance
			if (srcEnd instanceof Feature) {
				Context srcCtx = conn.getAllSourceContext();
				if (srcCtx == null && features.contains(srcEnd)) {
					result.add(conn);
				} else if (srcCtx instanceof FeatureGroup && features.contains(srcEnd)) {
					parents = ((FeatureInstance) fi.getOwner()).getFeature().getAllFeatureRefinements();
					if (parents.contains(srcCtx)) {
						result.add(conn);
					}
				}
			}
			if (conn.isAllBidirectional()) {
				ConnectionEnd dstEnd = conn.getAllDestination();
				// check other end
				if (dstEnd instanceof Feature) {
					Context dstCtx = conn.getAllDestinationContext();
					if (dstCtx == null && features.contains(dstEnd)) {
						result.add(conn);
					} else if (dstCtx instanceof FeatureGroup && features.contains(dstEnd)) {
						parents = ((FeatureInstance) fi.getOwner()).getFeature().getAllFeatureRefinements();
						if (parents.contains(dstCtx)) {
							result.add(conn);
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * Get outgoing connections for specified feature port group connections are
	 * non-directional, i.e., they are always added
	 *
	 * @param conns
	 *            a list of connections that go away from a subcomponent
	 * @param feature
	 *            subcomponent feature that can be the source of a connection
	 * @return connections with feature as source for ConnectionInstances
	 */
	public List<Connection> filterOutgoingConnections(List<Connection> conns, Feature feature) {
		List<Connection> result = new ArrayList<Connection>(conns.size());
		List<Feature> features = feature.getAllFeatureRefinements();

		for (Connection conn : conns) {
			if (features.contains(conn.getAllSource())
					|| conn.isAllBidirectional() && features.contains(conn.getAllDestination())) {
				result.add(conn);
			}
		}
		return result;
	}

	/**
	 * Get outgoing connections for specified feature port group connections are
	 * non-directional, i.e., they are always added
	 *
	 * @param conns
	 *            a list of connections that go away from a subcomponent
	 * @param feature
	 *            subcomponent feature that can be the source of a connection
	 * @return connections with feature as source for ConnectionInstances
	 */
	public List<Connection> filterOutgoingConnections(List<Connection> conns, Feature feature, Subcomponent sub) {
		List<Connection> result = new ArrayList<Connection>(conns.size());
		List<Feature> features = feature.getAllFeatureRefinements();
		EList<Subcomponent> subs = sub.getAllSubcomponentRefinements();
		for (Connection conn : conns) {
			if ((features.contains(conn.getAllSource()) && subs.contains(conn.getAllSourceContext()))
					|| (conn.isAllBidirectional() && features.contains(conn.getAllDestination())
							&& subs.contains(conn.getAllDestinationContext()))) {
				result.add(conn);
			}
		}
		return result;
	}

	/**
	 * Check if one of the connections in a list points to a feature.
	 *
	 * @param conns
	 *            a list of connections owned by a subcomponent
	 * @param feature
	 *            a subcomponent feature
	 * @return whether one of the connections points to the feature
	 */
	public boolean isDestination(List<Connection> conns, Feature feature) {
		List<Feature> features = feature.getAllFeatureRefinements();

		for (Connection conn : conns) {
			// ignore parameter connections
			if (!(conn instanceof ParameterConnection)) {
				if (features.contains(conn.getAllDestination())
						|| conn.isAllBidirectional() && features.contains(conn.getAllSource())) {
					return true;
				}
				if ((features.contains(conn.getAllDestinationContext())
						|| conn.isAllBidirectional() && features.contains(conn.getAllSourceContext()))) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Check if one of the connections in a list has a feature as its end.
	 *
	 * @param conns
	 *            a list of connections owned by a subcomponent
	 * @param feature
	 *            a subcomponent feature
	 * @return whether the feature is an end of one of the connections
	 */
	public boolean isConnectionEnd(List<Connection> conns, Feature feature) {
		List<Feature> features = feature.getAllFeatureRefinements();

		for (Connection conn : conns) {
			// ignore parameter connections
			if (!(conn instanceof ParameterConnection)) {
				if (features.contains(conn.getAllDestination()) || features.contains(conn.getAllSource())) {
					return true;
				}
				if ((features.contains(conn.getAllDestinationContext())
						|| features.contains(conn.getAllSourceContext()))) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param ctx
	 * @return
	 */
	private boolean isConnectionEndingComponent(final Context ctx) {
		if (ctx instanceof Subcomponent) {
			return isConnectionEndingCategory(((Subcomponent) ctx).getCategory());
		} else {
			return false;
		}
	}

	private boolean isConnectionEndingCategory(final ComponentCategory cat) {
		return cat == THREAD || cat == DEVICE || cat == PROCESSOR || cat == VIRTUAL_PROCESSOR;
	}

	private boolean isSubsetMatch(Connection conn) {
		return ModelingProperties.getClassifierMatchingRule(conn).orElse(null) == ClassifierMatchingRule.SUBSET;
	}

	boolean subsetMatch(List<Connection> conns) {
		boolean isSubset = false; // find it in connection declaration
		for (Connection connection : conns) {
			isSubset = isSubset || isSubsetMatch(connection);
		}
		return isSubset;
	}

}
