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
import java.util.List;
import java.util.Map;

import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
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
	 * Every seed in the tree under {@code root}, in deterministic key order, discarding
	 * whatever a failed endpoint resolution reports.
	 *
	 * @param root the instantiation root
	 * @param classifierCache resolved classifiers for prototypes, may be null
	 */
	public static List<TraversalSeed> discover(ComponentInstance root,
			Map<InstanceObject, InstantiatedClassifier> classifierCache) {
		return discover(root, classifierCache, new ResolutionFailures());
	}

	/**
	 * Every seed in the tree under {@code root}, in deterministic key order.
	 *
	 * @param root the instantiation root
	 * @param classifierCache resolved classifiers for prototypes, may be null
	 * @param failures collects the endpoint resolutions that should have succeeded, so
	 *            that the caller can report them
	 */
	public static List<TraversalSeed> discover(ComponentInstance root,
			Map<InstanceObject, InstantiatedClassifier> classifierCache, ResolutionFailures failures) {
		var seeds = new ArrayList<TraversalSeed>();
		if (root instanceof SystemInstance system) {
			boundarySeeds(system, seeds);
		}
		acrossSeeds(root, classifierCache, failures, seeds);
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
	 * The feature's own direction does not decide which of the two exists. An upward
	 * connection ends at whatever boundary feature it arrives at, whichever way that
	 * feature faces, so an {@code in} boundary feature still ends one: the connection
	 * instance exists and connection validation reports the direction. Seeding only the
	 * direction the feature faces loses it, and losing the inward one for a nested boundary
	 * group is issue #3040.
	 * </p>
	 *
	 * <p>
	 * The direction each end must face is decided per expanded leaf pair, so a seed that
	 * cannot produce a path produces none.
	 * </p>
	 */
	private static void boundarySeeds(SystemInstance system, List<TraversalSeed> seeds) {
		for (var feature : system.getFeatureInstances()) {
			if (feature.getFlowDirection() == null) {
				continue;
			}
			seeds.add(new TraversalSeed.Boundary(system, feature, true));
			seeds.add(new TraversalSeed.Boundary(system, feature, false));
		}
	}

	private static void acrossSeeds(ComponentInstance container,
			Map<InstanceObject, InstantiatedClassifier> classifierCache, ResolutionFailures failures,
			List<TraversalSeed> seeds) {
		var implementation = InstanceUtil.getComponentImplementation(container, 0, classifierCache);
		if (implementation != null && isFirstArrayElement(container)) {
			for (var declaration : implementation.getAllConnections()) {
				if (declaration.isAcross()) {
					addOrientations(container, declaration, failures, seeds);
				} else {
					checkComponentEnds(container, declaration, failures);
				}
			}
		}
		for (var child : container.getComponentInstances()) {
			acrossSeeds(child, classifierCache, failures, seeds);
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
	 * visible name.
	 * </p>
	 */
	private static boolean isFirstArrayElement(ComponentInstance container) {
		for (ComponentInstance level = container; level != null
				&& !(level instanceof SystemInstance); level = level.getContainingComponentInstance()) {
			for (var index : level.getIndices()) {
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
	 * bidirectional. One connection instance exists per legal orientation, so both have to
	 * be enumerated; collapsing them is on the list of changes issue #3037 did not permit.
	 */
	private static void addOrientations(ComponentInstance container, Connection declaration,
			ResolutionFailures failures, List<TraversalSeed> seeds) {
		for (boolean reverse : orientations(declaration)) {
			addOrientation(container, declaration, reverse, failures, seeds);
		}
	}

	/** The legal traversal orientations of {@code declaration}, forward first. */
	private static boolean[] orientations(Connection declaration) {
		return declaration.isAllBidirectional() ? new boolean[] { false, true } : new boolean[] { false };
	}

	private static void addOrientation(ComponentInstance container, Connection declaration, boolean reverse,
			ResolutionFailures failures, List<TraversalSeed> seeds) {
		var resolution = segment(container, declaration, reverse);
		failures.add(resolution);
		resolution.asOptional().ifPresent(segment -> seeds.add(new TraversalSeed.Across(segment)));
	}

	/**
	 * Report a declaration that names a subcomponent at both ends.
	 *
	 * <p>
	 * Such a declaration connects a component to a component, which no connection instance
	 * can express: an access connection reaches a shared component from a feature, never
	 * from another component. AS5506B disallows it, and the error has to be reported.
	 * </p>
	 *
	 * <p>
	 * Nothing else in the traversal reaches such a declaration: {@code Connection.isAcross()}
	 * is false when neither end has a context, so nothing seeds it and no leg continues
	 * through it. The check therefore stands on its own, here, where every declaration is
	 * examined once. It is a declarative test: only the two ends need resolving, and only to
	 * name them in the report.
	 * </p>
	 */
	private static void checkComponentEnds(ComponentInstance container, Connection declaration,
			ResolutionFailures failures) {
		var root = declaration.getRootConnection();
		if (root.getAllSourceContext() != null || root.getAllDestinationContext() != null
				|| !(root.getAllSource() instanceof Subcomponent source)
				|| !(root.getAllDestination() instanceof Subcomponent destination)) {
			return;
		}
		var sourceInstance = container.findSubcomponentInstance(source);
		var destinationInstance = container.findSubcomponentInstance(destination);
		if (sourceInstance == null || destinationInstance == null) {
			// A subcomponent the instance model does not have is reported where it is resolved.
			return;
		}
		failures.add(Resolution.failed(container.getSystemInstance(),
				"Connection source and destination are components: " + sourceInstance.getInstanceObjectPath() + " => "
						+ destinationInstance.getInstanceObjectPath()));
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
			Map<InstanceObject, InstantiatedClassifier> classifierCache, List<TraversalSeed> seeds) {
		for (var child : container.getComponentInstances()) {
			for (var feature : child.getFeatureInstances()) {
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
			Map<InstanceObject, InstantiatedClassifier> classifierCache) {
		var implementation = InstanceUtil.getComponentImplementation(container, 0, classifierCache);
		if (implementation == null) {
			return false;
		}
		for (var declaration : implementation.getAllConnections()) {
			for (boolean reverse : orientations(declaration)) {
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
		var root = declaration.getRootConnection();
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
