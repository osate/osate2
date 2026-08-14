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
import java.util.function.Predicate;

import org.osate.aadl2.Access;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.Port;
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
 * One operation resolves both legs. A leg always moves the same way, into the
 * component that owns the current feature and then into its subcomponents, and the
 * {@link LegRole} decides only which declared side of a candidate declaration the leg
 * arrives from. Source-first traversal grows a path forwards while tracking whether
 * it may currently go up, across, or down.
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
	private final ComponentInstance root;

	/**
	 * @param classifierCache resolved classifiers for prototypes, may be null
	 * @param root the instantiation root, which is always descended into whatever its
	 *            category
	 */
	public LegResolver(HashMap<InstanceObject, InstantiatedClassifier> classifierCache, ComponentInstance root) {
		this.classifierCache = classifierCache;
		this.root = root;
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
		if (owner == null) {
			results.add(new LegResult(role, current, segments, featurePath, modes, allBidirectional,
					"no owning component"));
			return;
		}

		/*
		 * Terminal policy: a connection-ending component. A thread, device, processor, or
		 * virtual processor ends a semantic connection at a port or feature group, so the
		 * leg stops there. It does not stop for an access feature: shared access reaches
		 * through such a component into what it contains.
		 *
		 * When a feature group holds both, the leg both stops here and continues for the
		 * access part, which is why this adds a result and carries on rather than
		 * returning. Source-first reaches the same two outcomes by separate means: its
		 * start rule creates the path that stops at the component, and enumeration from
		 * the inner subcomponent creates the one that continues.
		 */
		/*
		 * The connection-ending rule applies to components the traversal descends into, not
		 * to the root. A thread implementation instantiated on its own is the whole model,
		 * and its internals are still reached; source-first likewise applies the rule while
		 * examining subcomponents and never to the root it walks the features of.
		 */
		boolean endingCategory = owner != root && isConnectionEndingCategory(owner.getCategory());
		if (endingCategory && (includesPort(feature) || includesNestedFeatureGroup(feature))) {
			results.add(new LegResult(role, current, segments, featurePath, modes, allBidirectional,
					"connection ending component"));
			if (!includesAccess(feature)) {
				return;
			}
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

		List<ResolvedSegment> continuations = continuations(owner, feature, role, visited, endingCategory);
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
	 * continue into a subcomponent, which keeps this a descent rather than a general
	 * graph walk. A candidate already traversed in this orientation on this branch is
	 * skipped, so a cyclic model terminates.
	 * </p>
	 */
	private List<ResolvedSegment> continuations(ComponentInstance owner, FeatureInstance feature, LegRole role,
			Set<String> visited, boolean endingCategory) {
		List<ResolvedSegment> continuations = new ArrayList<>();
		ComponentImplementation implementation = InstanceUtil.getComponentImplementation(owner, 0, classifierCache);
		for (Connection declaration : implementation.getAllConnections()) {
			/*
			 * Inside a connection-ending component only an access connection continues a
			 * semantic connection: shared access reaches through such a component, while a
			 * port or feature group connection ends at it.
			 */
			if (endingCategory && !(declaration instanceof AccessConnection)) {
				continue;
			}
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
	 * group the leg stands at, connecting one member of it, and it may connect a whole
	 * feature group while the leg stands at a member of it. Both continue the same
	 * semantic connection and differ only in how much of the group the connection
	 * covers, which the feature chain records.
	 * </p>
	 *
	 * <p>
	 * Requiring an exact match loses every connection that reaches into a feature
	 * group. This is the narrowing source-first traversal performs with its two shared
	 * stacks, and the reason two distinct semantic paths can share an endpoint pair.
	 * </p>
	 */
	static boolean touches(ConnectionInstanceEnd near, FeatureInstance position) {
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

	/** Whether the feature is a port, or is a feature group with a port member. */
	private static boolean includesPort(FeatureInstance feature) {
		return includes(feature, member -> member instanceof Port);
	}

	/**
	 * Whether the feature is a feature group with a feature group member. A feature group
	 * that is not nested does not count, which matches
	 * {@code CreateConnectionsSwitch.FeatureInfo.hasFeatureGroup()}: that flag is only
	 * ever set while scanning the members of a group.
	 */
	private static boolean includesNestedFeatureGroup(FeatureInstance feature) {
		return feature.getFeature() instanceof FeatureGroup && includes(feature, member -> member instanceof FeatureGroup);
	}

	/** Whether the feature is an access feature, or is a feature group with one. */
	private static boolean includesAccess(FeatureInstance feature) {
		return includes(feature, member -> member instanceof Access);
	}

	/**
	 * Test the immediate members of a feature group, or the feature itself when it is not
	 * one. These are the two cases {@code FeatureInfo} distinguishes, so the answers match
	 * the source-first rule they feed.
	 */
	private static boolean includes(FeatureInstance feature, Predicate<Feature> test) {
		if (!(feature.getFeature() instanceof FeatureGroup)) {
			return test.test(feature.getFeature());
		}
		for (FeatureInstance member : feature.getFeatureInstances()) {
			if (test.test(member.getFeature())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Whether a component of this category ends a semantic connection. Mirrors the
	 * source-first rule, so maximal paths stay the same length.
	 */
	static boolean isConnectionEndingCategory(ComponentCategory category) {
		return category == THREAD || category == DEVICE || category == PROCESSOR || category == VIRTUAL_PROCESSOR;
	}
}
