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

import static org.osate.aadl2.ComponentCategory.DEVICE;
import static org.osate.aadl2.ComponentCategory.PROCESSOR;
import static org.osate.aadl2.ComponentCategory.THREAD;
import static org.osate.aadl2.ComponentCategory.VIRTUAL_PROCESSOR;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.util.InstanceUtil;
import org.osate.aadl2.instance.util.InstanceUtil.InstantiatedClassifier;

/**
 * Descends component containment from a seed endpoint until a terminal policy stops
 * the walk.
 *
 * <p>
 * One operation resolves both legs. A leg always moves in the same direction
 * physically — downwards, into the component that owns the current feature and then
 * into its subcomponents — and the {@link LegRole} decides only which declared side
 * of a candidate declaration the leg arrives from. Source-first traversal instead
 * grows a path forwards while tracking whether it is currently allowed to go up,
 * across, or down, which is the state that made its direction handling hard to
 * follow.
 * </p>
 *
 * <p>
 * Branching produces several results from one seed. Each branch carries its own
 * feature chain, mode constraint, and visited set, so extending one branch cannot
 * disturb another; source-first shares that state across every path under
 * enumeration.
 * </p>
 */
public final class LegResolver {

	private final HashMap<InstanceObject, InstantiatedClassifier> classifierCache;

	public LegResolver(HashMap<InstanceObject, InstantiatedClassifier> classifierCache) {
		this.classifierCache = classifierCache;
	}

	/**
	 * Every leg that descends from {@code start}, in deterministic key order.
	 *
	 * @param start the endpoint the pivot resolved to on this side
	 * @param role which side of the pivot this leg descends towards
	 */
	public List<LegResult> resolve(ConnectionInstanceEnd start, LegRole role) {
		List<LegResult> results = new ArrayList<>();
		descend(start, role, List.of(), FeaturePath.EMPTY, ModeConstraint.UNCONSTRAINED, true, new HashSet<>(), results);
		results.sort(Comparator.comparing(LegResult::key));
		return List.copyOf(results);
	}

	private void descend(ConnectionInstanceEnd current, LegRole role, List<ResolvedSegment> segments,
			FeaturePath featurePath, ModeConstraint modes, boolean allBidirectional, Set<String> visited,
			List<LegResult> results) {

		/*
		 * Terminal policy: a shared data, bus, virtual bus, subprogram, or subprogram group
		 * that an access connection ends at. The endpoint is the component itself, so there
		 * is no feature to continue from.
		 */
		if (!(current instanceof FeatureInstance feature)) {
			results.add(new LegResult(role, current, segments, featurePath, modes, allBidirectional,
					"endpoint is a component"));
			return;
		}

		ComponentInstance owner = feature.getContainingComponentInstance();

		/*
		 * Terminal policy: a connection-ending component. A thread, device, processor, or
		 * virtual processor ends a semantic connection, so its internals are not descended
		 * into even when it has some.
		 */
		if (owner == null || isConnectionEndingCategory(owner.getCategory())) {
			results.add(new LegResult(role, current, segments, featurePath, modes, allBidirectional,
					owner == null ? "no owning component" : "connection ending component"));
			return;
		}

		/*
		 * Terminal policy: an incomplete boundary. A component type without an
		 * implementation has no internals to descend into, so the leg ends at its feature.
		 */
		ComponentImplementation implementation = InstanceUtil.getComponentImplementation(owner, 0, classifierCache);
		if (implementation == null) {
			results.add(new LegResult(role, current, segments, featurePath, modes, allBidirectional,
					"component type only"));
			return;
		}

		List<ResolvedSegment> continuations = continuations(owner, feature, role, visited);
		if (continuations.isEmpty()) {
			results.add(new LegResult(role, current, segments, featurePath, modes, allBidirectional,
					"no continuing declaration"));
			return;
		}

		for (ResolvedSegment segment : continuations) {
			List<ResolvedSegment> extended = new ArrayList<>(segments);
			extended.add(segment);
			Set<String> branchVisited = new HashSet<>(visited);
			branchVisited.add(orientedKey(segment));
			descend(segment.destination(), role, extended, segment.destinationPath(),
					modes.and(segment.declaration(), owner),
					allBidirectional && segment.declaration().isAllBidirectional(), branchVisited, results);
		}
	}

	/**
	 * The declarations inside {@code owner} that continue a leg standing at
	 * {@code feature}, each resolved so that its destination is the deeper endpoint.
	 *
	 * <p>
	 * A candidate must arrive at {@code feature} on the side the role dictates and
	 * continue into a subcomponent, which is what makes this a descent rather than a
	 * general graph walk. A candidate already traversed in this orientation on this
	 * branch is skipped, so a cyclic model terminates.
	 * </p>
	 */
	private List<ResolvedSegment> continuations(ComponentInstance owner, FeatureInstance feature, LegRole role,
			Set<String> visited) {
		List<ResolvedSegment> continuations = new ArrayList<>();
		ComponentImplementation implementation = InstanceUtil.getComponentImplementation(owner, 0, classifierCache);
		for (Connection declaration : implementation.getAllConnections()) {
			for (boolean declaredOrientation : new boolean[] { false, true }) {
				if (declaredOrientation && !declaration.isAllBidirectional()) {
					continue;
				}
				/*
				 * The leg arrives from one declared side and leaves by the other. A source leg
				 * arrives at the destination side, so it is resolved reversed, which makes the
				 * segment's own source the deeper endpoint it continues to.
				 */
				boolean reverse = role.arrivesAtDeclaredDestination() != declaredOrientation;
				Resolution<ResolvedSegment> resolution = SeedDiscovery.segment(owner, declaration, reverse);
				if (!(resolution instanceof Resolution.Resolved<ResolvedSegment> resolved)) {
					continue;
				}
				ResolvedSegment segment = resolved.value();
				if (!touches(segment.source(), feature) || visited.contains(orientedKey(segment))) {
					continue;
				}
				// Only a descent continues a leg: the far end must be inside a subcomponent.
				ComponentInstance destinationOwner = segment.destination() instanceof FeatureInstance destination
						? destination.getContainingComponentInstance()
						: (ComponentInstance) segment.destination();
				if (destinationOwner == null || destinationOwner == owner) {
					continue;
				}
				continuations.add(segment);
			}
		}
		continuations.sort(Comparator.comparing(ResolvedSegment::key));
		return continuations;
	}

	/**
	 * Whether a candidate declaration touches the feature a leg is standing at.
	 *
	 * <p>
	 * An exact match is not enough. A declaration may reach <em>into</em> a feature
	 * group the leg stands at, connecting only one member of it, and it may equally
	 * connect a whole feature group while the leg stands at a member of it. Both
	 * continue the same semantic connection; they differ only in how much of the group
	 * the connection covers, which the feature chain records.
	 * </p>
	 *
	 * <p>
	 * Requiring an exact match instead loses every connection that reaches into a
	 * feature group, which is most of them in practice. This is the narrowing that
	 * source-first traversal performs with its two shared stacks, and it is the reason
	 * two distinct semantic paths can share an endpoint pair.
	 * </p>
	 */
	private static boolean touches(ConnectionInstanceEnd near, FeatureInstance position) {
		if (near == position || isNestedIn(near, position)) {
			return true;
		}
		return near instanceof FeatureInstance nearFeature && isNestedIn(position, nearFeature);
	}

	/** Whether {@code inner} sits inside the feature {@code outer}. */
	private static boolean isNestedIn(ConnectionInstanceEnd inner, FeatureInstance outer) {
		for (Object owner = inner.getOwner(); owner instanceof FeatureInstance feature; owner = feature.getOwner()) {
			if (feature == outer) {
				return true;
			}
		}
		return false;
	}

	private static String orientedKey(ResolvedSegment segment) {
		return PathKeys.declarative(segment.declaration()) + '@' + PathKeys.instance(segment.context())
				+ (segment.reverse() ? "|r" : "|f");
	}

	/**
	 * Whether a component of this category ends a semantic connection. Mirrors the
	 * source-first rule exactly, so that maximal paths stay the same length.
	 */
	private static boolean isConnectionEndingCategory(ComponentCategory category) {
		return category == THREAD || category == DEVICE || category == PROCESSOR || category == VIRTUAL_PROCESSOR;
	}
}
