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

import static org.osate.aadl2.ComponentCategory.DEVICE;
import static org.osate.aadl2.ComponentCategory.PROCESSOR;
import static org.osate.aadl2.ComponentCategory.THREAD;
import static org.osate.aadl2.ComponentCategory.VIRTUAL_PROCESSOR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Connection;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
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
import org.osate.aadl2.instance.util.InstanceUtil.InstantiatedClassifier;
import org.osate.aadl2.instantiation.internal.LeafExpansion;
import org.osate.aadl2.instantiation.internal.LegResolver;
import org.osate.aadl2.instantiation.internal.LegResult;
import org.osate.aadl2.instantiation.internal.LegRole;
import org.osate.aadl2.instantiation.internal.PathAssembler;
import org.osate.aadl2.instantiation.internal.PathMaterializer;
import org.osate.aadl2.instantiation.internal.Resolution;
import org.osate.aadl2.instantiation.internal.ResolutionFailures;
import org.osate.aadl2.instantiation.internal.SeedDiscovery;
import org.osate.aadl2.instantiation.internal.SemanticConnectionPath;
import org.osate.aadl2.instantiation.internal.TraversalSeed;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;

/**
 * Adds all connection instances to an instance model.
 *
 * <p>
 * This is the public entry point for the connection phase, and it stays one whatever the
 * enumeration behind it does. Since issue #3037 the enumeration is the across-first traversal of
 * {@code org.osate.aadl2.instantiation.internal}: seeds are discovered once over the whole root,
 * each seed's legs are resolved, joined and expanded, and each resulting endpoint pair is
 * materialized and attached here. What remains in this class besides that is the mode and system
 * operation mode assignment every connection instance goes through.
 * </p>
 */
public class CreateConnectionsSwitch extends AadlProcessingSwitchWithProgress {

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
	 * The component the across-first traversal was rooted at, so that its seed-driven
	 * enumeration runs once rather than once per visited component.
	 */
	private ComponentInstance traversalRoot = null;

	/**
	 * @param pm
	 *            the progress monitor
	 * @param errMgr
	 *            the error manager
	 * @param classifierCache
	 *            cache of known instantiated classifiers, may be null
	 */
	public CreateConnectionsSwitch(final IProgressMonitor pm, final AnalysisErrorReporterManager errMgr,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache) {
		super(pm, PROCESS_PRE_ORDER_ALL, errMgr);
		this.classifierCache = classifierCache;
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
				/*
				 * Enumeration is driven by seeds over the whole root rather than by visiting one
				 * component at a time, so it runs once, at the first component the traversal
				 * reaches, which is the root.
				 */
				if (traversalRoot == null) {
					traversalRoot = ci;
					instantiateAcrossFirst(ci);
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
	 * operation modes are then filled in.
	 * </p>
	 */
	private void instantiateAcrossFirst(final ComponentInstance root) {
		final SystemInstance systemInstance = root.getSystemInstance();
		final ResolutionFailures failures = new ResolutionFailures();
		final LegResolver legResolver = new LegResolver(classifierCache, root, failures);

		for (TraversalSeed seed : SeedDiscovery.discover(root, classifierCache, failures)) {
			List<LegResult> sourceLegs = List.of();
			List<LegResult> destinationLegs = List.of();
			if (seed instanceof TraversalSeed.Across across) {
				sourceLegs = legResolver.resolve(across.segment().source(), LegRole.SOURCE_LEG,
						across.segment().declaration());
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
			for (SemanticConnectionPath path : PathAssembler.join(seed, sourceLegs, destinationLegs)) {
				if (path.deadEnd()) {
					reportDeadEnd(path);
					continue;
				}
				for (LeafExpansion.Endpoints endpoints : LeafExpansion.expand(path)) {
					attachAcrossFirst(systemInstance, path, endpoints);
				}
			}
			if (monitor.isCanceled()) {
				return;
			}
		}

		/*
		 * An endpoint a declaration names and the instance model does not have is a model or
		 * implementation error, and it is the reason the connection it belonged to is absent.
		 * Enumeration itself reports nothing, so that a path can be explored and discarded
		 * without leaving anything behind; the failures it gathered are reported here, once
		 * each, after every seed has been examined.
		 */
		for (Resolution.Failed<?> failure : failures.collected()) {
			error(failure.target(), failure.message());
		}
	}

	/**
	 * Report a path that arrives where the connection can go no further and cannot end
	 * either, so that the connection it would have carried is not lost silently. The
	 * baseline reports the same fact from {@code addConnectionInstance()} once the end of
	 * such a path is known.
	 */
	private void reportDeadEnd(final SemanticConnectionPath path) {
		warning(path.destination(),
				"Could not continue connection from "
						+ LeafExpansion.correspondingSource(path).getInstanceObjectPath() + " through "
						+ path.destination().getInstanceObjectPath() + ". No connection instance created.");
	}

	/**
	 * Materialize one expanded endpoint pair, attach it, and fill in its modes. Nothing is
	 * suppressed as a duplicate here: paths are already deduplicated by structured identity
	 * before expansion, so a duplicate would mean two identities produced the same connection,
	 * which is an enumeration defect rather than something to absorb silently.
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

	private boolean isConnectionEndingCategory(final ComponentCategory cat) {
		return cat == THREAD || cat == DEVICE || cat == PROCESSOR || cat == VIRTUAL_PROCESSOR;
	}
}
