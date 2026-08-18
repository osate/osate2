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
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.util.InstanceUtil;
import org.osate.aadl2.instance.util.InstanceUtil.InstantiatedClassifier;
import org.osate.aadl2.instantiation.internal.EndpointResolver.ResolvedEnd;

/**
 * Finds every point an across-first traversal starts from.
 *
 * <p>
 * Seeds are produced in a deterministic order derived from stable keys, never from
 * hash iteration or object identity, because the order in which seeds are expanded
 * decides the order connection instances end up in.
 * </p>
 */
public final class SeedDiscovery {

	private SeedDiscovery() {
	}

	/**
	 * Every seed in the tree under {@code root}, in deterministic key order.
	 *
	 * @param root the instantiation root
	 * @param classifierCache resolved classifiers for prototypes, may be null
	 */
	public static List<TraversalSeed> discover(ComponentInstance root,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache) {
		List<TraversalSeed> seeds = new ArrayList<>();
		if (root instanceof SystemInstance system) {
			boundarySeeds(system, seeds);
		}
		acrossSeeds(root, classifierCache, seeds);
		triggerSeeds(root, classifierCache, seeds);
		seeds.sort(Comparator.comparing(TraversalSeed::key));
		return List.copyOf(seeds);
	}

	/**
	 * Two seeds per top-level feature of the system instance: one for a connection that
	 * arrives from outside and continues inwards, one for a connection that starts inside
	 * and ends here.
	 *
	 * <p>
	 * The feature's own direction does not decide which of the two exists. Source-first
	 * only starts at an incoming boundary feature
	 * ({@code CreateConnectionsSwitch.processIncomingFeature()}), but it reaches an
	 * outgoing path's end from the other side, walking up from the feature inside that
	 * starts it and stopping at whatever boundary feature it arrives at, whichever way that
	 * feature faces. An {@code in} boundary feature therefore still ends an upward
	 * connection, which the baseline creates and connection validation then reports.
	 * </p>
	 *
	 * <p>
	 * The direction each end must face is decided per expanded leaf pair, so a seed that
	 * cannot produce a path produces none.
	 * </p>
	 */
	private static void boundarySeeds(SystemInstance system, List<TraversalSeed> seeds) {
		for (FeatureInstance feature : system.getFeatureInstances()) {
			if (feature.getFlowDirection() == null) {
				continue;
			}
			seeds.add(new TraversalSeed.Boundary(system, feature, true));
			seeds.add(new TraversalSeed.Boundary(system, feature, false));
		}
	}

	private static void acrossSeeds(ComponentInstance container,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache, List<TraversalSeed> seeds) {
		ComponentImplementation implementation = InstanceUtil.getComponentImplementation(container, 0, classifierCache);
		if (implementation != null && isFirstArrayElement(container)) {
			for (Connection declaration : implementation.getAllConnections()) {
				if (declaration.isAcross()) {
					addOrientations(container, declaration, seeds);
				}
			}
		}
		for (ComponentInstance child : container.getComponentInstances()) {
			acrossSeeds(child, classifierCache, seeds);
		}
	}

	/**
	 * Whether {@code container} is the innermost first element of every array it lies in.
	 *
	 * <p>
	 * A declaration inside an array of components is enumerated once, for the first
	 * element, and the connection instance it produces is replicated to the other elements
	 * by {@code InstantiateModel.finalizeConnections()}. Seeding every element instead
	 * would look equivalent but is not: a replica is named with {@code " --> "} and has its
	 * reference contexts relocated, so enumerating it directly changes an externally
	 * visible name. Source-first applies the same rule before calling
	 * {@code instantiateConnections()}.
	 * </p>
	 */
	private static boolean isFirstArrayElement(ComponentInstance container) {
		for (ComponentInstance level = container; level != null
				&& !(level instanceof SystemInstance); level = level.getContainingComponentInstance()) {
			for (Long index : level.getIndices()) {
				if (index > 1) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Add one seed per legal traversal orientation of {@code declaration}: the declared
	 * direction always, and the opposite direction as well when the declaration is
	 * bidirectional. The baseline materializes one connection instance per legal
	 * orientation, so both must be enumerated.
	 */
	private static void addOrientations(ComponentInstance container, Connection declaration,
			List<TraversalSeed> seeds) {
		segment(container, declaration, false).asOptional()
				.ifPresent(segment -> seeds.add(new TraversalSeed.Across(segment)));
		if (declaration.isAllBidirectional()) {
			segment(container, declaration, true).asOptional()
					.ifPresent(segment -> seeds.add(new TraversalSeed.Across(segment)));
		}
	}

	/**
	 * One seed per event port of a subcomponent that triggers a mode transition in the
	 * component containing it and that no declaration continues from.
	 *
	 * <p>
	 * A trigger consumes the connection, so an upward path may end there. Where the
	 * containing component does continue from the port, only the longer path exists, which
	 * is why the continuation test decides whether the seed is created at all rather than
	 * leaving both to be enumerated.
	 * </p>
	 */
	private static void triggerSeeds(ComponentInstance container,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache, List<TraversalSeed> seeds) {
		for (ComponentInstance child : container.getComponentInstances()) {
			for (FeatureInstance feature : child.getFeatureInstances()) {
				if (triggersModeTransition(container, feature)
						&& !continuesOutward(container, feature, classifierCache)) {
					seeds.add(new TraversalSeed.Trigger(child, feature));
				}
			}
			triggerSeeds(child, classifierCache, seeds);
		}
	}

	/** Whether {@code feature} triggers one of {@code container}'s mode transitions. */
	static boolean triggersModeTransition(ComponentInstance container, FeatureInstance feature) {
		return feature.getCategory() == FeatureCategory.EVENT_PORT && container.getModeTransitionInstances()
				.stream()
				.anyMatch(transition -> transition.getTriggers().contains(feature));
	}

	/**
	 * Whether a declaration of {@code container} carries a connection further from
	 * {@code feature}, which belongs to one of its subcomponents.
	 */
	private static boolean continuesOutward(ComponentInstance container, FeatureInstance feature,
			HashMap<InstanceObject, InstantiatedClassifier> classifierCache) {
		ComponentImplementation implementation = InstanceUtil.getComponentImplementation(container, 0, classifierCache);
		if (implementation == null) {
			return false;
		}
		for (Connection declaration : implementation.getAllConnections()) {
			for (boolean reverse : new boolean[] { false, true }) {
				if (reverse && !declaration.isAllBidirectional()) {
					continue;
				}
				if (segment(container, declaration, reverse) instanceof Resolution.Resolved<ResolvedSegment> resolved
						&& LegResolver.touches(resolved.value().source(), feature)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Resolve {@code declaration} in {@code container} in one orientation. A traversal
	 * that is reversed swaps which declared side the path enters from.
	 */
	public static Resolution<ResolvedSegment> segment(ComponentInstance container, Connection declaration,
			boolean reverse) {
		Connection root = declaration.getRootConnection();
		Resolution<ResolvedEnd> from = EndpointResolver.resolve(container,
				reverse ? root.getDestination() : root.getSource(), container);
		if (!(from instanceof Resolution.Resolved<ResolvedEnd> resolvedFrom)) {
			return carryOver(from);
		}
		Resolution<ResolvedEnd> to = EndpointResolver.resolve(container,
				reverse ? root.getSource() : root.getDestination(), container);
		if (!(to instanceof Resolution.Resolved<ResolvedEnd> resolvedTo)) {
			return carryOver(to);
		}
		return Resolution.resolved(new ResolvedSegment(declaration, container, resolvedFrom.value().endpoint(),
				resolvedTo.value().endpoint(), reverse, resolvedFrom.value().path(), resolvedTo.value().path()));
	}



	/** Re-type a non-resolved endpoint outcome as a segment outcome. */
	private static Resolution<ResolvedSegment> carryOver(Resolution<ResolvedEnd> outcome) {
		if (outcome instanceof Resolution.Failed<ResolvedEnd> failed) {
			return Resolution.failed(failed.target(), failed.message());
		}
		return Resolution.notApplicable(((Resolution.NotApplicable<ResolvedEnd>) outcome).reason());
	}
}
