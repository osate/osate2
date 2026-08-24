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
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.IntStream;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.ModeInstance;
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
import org.osate.aadl2.instantiation.internal.ResolutionFailures;
import org.osate.aadl2.instantiation.internal.SeedDiscovery;
import org.osate.aadl2.instantiation.internal.ConnectionInstancePath;
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
	private final HashMap<InstanceObject, InstantiatedClassifier> classifierCache;

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
		instanceSwitch = new InstanceSwitch<>() {

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
	 * Enumerate and materialize every connection instance under {@code root} with
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
		final var systemInstance = root.getSystemInstance();
		final var failures = new ResolutionFailures();
		final var legResolver = new LegResolver(classifierCache, root, failures);

		for (var seed : SeedDiscovery.discover(root, classifierCache, failures)) {
			List<LegResult> sourceLegs = List.of();
			List<LegResult> destinationLegs = List.of();
			/*
			 * Exhaustive over the sealed seed hierarchy, so a seed kind added later does not
			 * silently resolve no legs at all.
			 */
			switch (seed) {
			case TraversalSeed.Across across -> {
				sourceLegs = legResolver.resolve(across.segment().source(), LegRole.SOURCE_LEG,
						across.segment().declaration());
				destinationLegs = legResolver.resolve(across.segment().destination(), LegRole.DESTINATION_LEG);
			}
			/*
			 * A boundary seed has one leg. An incoming boundary feature leads inwards, so the model
			 * supplies the destination; an outgoing one leads towards the ultimate source inside.
			 */
			case TraversalSeed.Boundary boundary when boundary.incoming() ->
				destinationLegs = legResolver.resolve(boundary.feature(), LegRole.DESTINATION_LEG);
			case TraversalSeed.Boundary boundary ->
				sourceLegs = legResolver.resolve(boundary.feature(), LegRole.SOURCE_LEG);
			case TraversalSeed.Trigger trigger ->
				sourceLegs = legResolver.resolve(trigger.feature(), LegRole.SOURCE_LEG);
			}
			for (var path : PathAssembler.join(seed, sourceLegs, destinationLegs)) {
				if (path.deadEnd()) {
					reportDeadEnd(path);
					continue;
				}
				for (var endpoints : LeafExpansion.expand(path)) {
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
		for (var failure : failures.collected()) {
			error(failure.target(), failure.message());
		}
	}

	/**
	 * Report a path that arrives where the connection can go no further and cannot end
	 * either, so that the connection it would have carried is not lost silently. The report is
	 * made here, where the path's end is known, and its wording is the one issue #3044 settled;
	 * {@code Issue3037MemberPairingTest} asserts it exactly.
	 */
	private void reportDeadEnd(final ConnectionInstancePath path) {
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
	private void attachAcrossFirst(final SystemInstance systemInstance, final ConnectionInstancePath path,
			final LeafExpansion.Endpoints endpoints) {
		var container = PathMaterializer.container(systemInstance, path);
		var conni = PathMaterializer.materialize(systemInstance, path, endpoints);
		for (var existing : container.getConnectionInstances()) {
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
		var ours = one.getConnectionReferences();
		var theirs = other.getConnectionReferences();
		if (ours.size() != theirs.size()) {
			return false;
		}
		return IntStream.range(0, ours.size()).allMatch(i -> sameReference(ours.get(i), theirs.get(i)));
	}

	private static boolean sameReference(ConnectionReference one, ConnectionReference other) {
		return one.getConnection() == other.getConnection() && one.getContext() == other.getContext()
				&& one.isReverse() == other.isReverse();
	}
	// ------------------------------------------------------------------------
	// Helper methods related to modes
	// ------------------------------------------------------------------------

	private void fillInModeTransitions(ConnectionInstance conni) {
		var ci = conni.getContainingComponentInstance();

		for (var connRef : conni.getConnectionReferences()) {
			for (var mt : connRef.getConnection().getAllInModeTransitions()) {
				var mti = ci.findModeTransitionInstance(mt);
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
		var refIter = conni.getConnectionReferences().listIterator();

		while (refIter.hasNext()) {
			var connRef = refIter.next();
			var ci = connRef.getContext();

			// the source, the connection declarations, or the destination may be modal, in that order
			var mis = getComponentModes(conni.getSource().getComponentInstance());
			if (mis == null) {
				mis = declaredModes(connRef, ci);
			}
			if (mis == null) {
				mis = getComponentModes(conni.getDestination().getComponentInstance());
			}
			if (mis != null) {
				for (var mi : mis) {
					generateModeCombinations(conni, refIter, new ArrayList<>(List.of(mi)));
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
			var si = (SystemInstance) conni.getElementRoot();
			for (var som : si.getSystemOperationModesFor(mis)) {
				if (isActiveIn(conni, som)) {
					conni.getInSystemOperationModes().add(som);
				}
			}
		} else {
			var connRef = refIter.next();
			var nextMis = declaredModes(connRef, connRef.getContext());

			if (nextMis == null) {
				generateModeCombinations(conni, refIter, mis);
			} else {
				for (var mi : nextMis) {
					mis.add(mi);
					generateModeCombinations(conni, refIter, mis);
					mis.remove(mi);
				}
			}
			refIter.previous();
		}
	}

	/**
	 * The modes a reference's own declaration names, or the modes of the component it is
	 * declared in when it names none, or null when neither is modal.
	 */
	private List<ModeInstance> declaredModes(ConnectionReference connRef, ComponentInstance ci) {
		var connModes = connRef.getConnection().getAllInModes();
		return connModes.isEmpty() ? getComponentModes(ci) : connModes.stream().map(ci::findModeInstance).toList();
	}

	/** Whether every part of the connection, its ends and every context it traverses, is active. */
	private static boolean isActiveIn(ConnectionInstance conni, SystemOperationMode som) {
		return conni.getSource().isActive(som) && conni.getDestination().isActive(som) && conni
				.getConnectionReferences()
				.stream()
				.allMatch(reference -> reference.getContext().isActive(som));
	}

	/**
	 * The modes of the innermost modal component at or above {@code component}, or null when
	 * nothing from there up to the system instance is modal.
	 */
	private List<ModeInstance> getComponentModes(ComponentInstance component) {
		for (var ci = component; !(ci instanceof SystemInstance); ci = ci.getContainingComponentInstance()) {
			if (!ci.getInModes().isEmpty()) {
				return ci.getInModes();
			}
		}
		return null;
	}
}
