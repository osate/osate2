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
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import org.osate.aadl2.Access;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.ParameterConnection;
import org.osate.aadl2.Port;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.util.InstanceUtil;
import org.osate.aadl2.instance.util.InstanceUtil.InstantiatedClassifier;
import org.osate.aadl2.modelsupport.util.AadlUtil;

/**
 * Descends component containment from a seed endpoint until a terminal policy stops
 * the walk.
 *
 * <p>
 * One operation resolves both legs. A leg always moves the same way, into the
 * component that owns the current feature and then into its subcomponents, and the
 * {@link LegRole} decides only which declared side of a candidate declaration the leg
 * arrives from.
 * </p>
 *
 * <p>
 * Branching produces several results from one seed. Each branch carries its own
 * feature chain, mode constraint, and visited set, so extending one branch cannot
 * disturb another.
 * </p>
 */
public final class LegResolver {

	private final HashMap<InstanceObject, InstantiatedClassifier> classifierCache;
	private final ComponentInstance root;
	private final ResolutionFailures failures;

	/**
	 * Resolved segments per component, so that a declaration is resolved once per
	 * instantiation rather than once per leg step. Enumeration asks the same question many
	 * times over: every branch of every leg of every seed that passes through a component
	 * examines all of its declarations, and endpoint resolution is the expensive part of the
	 * answer. Identity keyed, because it caches instance objects of one run.
	 */
	private final Map<ComponentInstance, List<ResolvedSegment>> resolvedByContainer = new IdentityHashMap<>();

	/**
	 * A resolver that discards whatever a failed endpoint resolution reports.
	 *
	 * @param classifierCache resolved classifiers for prototypes, may be null
	 * @param root the instantiation root, which is always descended into whatever its
	 *            category
	 */
	public LegResolver(HashMap<InstanceObject, InstantiatedClassifier> classifierCache, ComponentInstance root) {
		this(classifierCache, root, new ResolutionFailures());
	}

	/**
	 * @param classifierCache resolved classifiers for prototypes, may be null
	 * @param root the instantiation root, which is always descended into whatever its
	 *            category
	 * @param failures collects the endpoint resolutions that should have succeeded, so
	 *            that the caller can report them
	 */
	public LegResolver(HashMap<InstanceObject, InstantiatedClassifier> classifierCache, ComponentInstance root,
			ResolutionFailures failures) {
		this.classifierCache = classifierCache;
		this.root = root;
		this.failures = failures;
	}

	/**
	 * Every leg that descends from {@code start}, in deterministic key order.
	 *
	 * @param start the endpoint the pivot resolved to on this side
	 * @param role which side of the pivot this leg descends towards
	 */
	public List<LegResult> resolve(ConnectionInstanceEnd start, LegRole role) {
		return resolve(start, role, null);
	}

	/**
	 * Every leg that descends from {@code start}, in deterministic key order.
	 *
	 * @param start the endpoint the pivot resolved to on this side
	 * @param role which side of the pivot this leg descends towards
	 * @param seedDeclaration the declaration the finished path leaves the seed endpoint by,
	 *            which a source leg that stops where it started needs in order to decide
	 *            whether the ultimate source may be there; null for a seed that has no outer
	 *            declaration, which is every boundary and trigger seed
	 */
	public List<LegResult> resolve(ConnectionInstanceEnd start, LegRole role, Connection seedDeclaration) {
		var results = new ArrayList<LegResult>();
		descend(start, role, List.of(), FeaturePath.EMPTY, ModeConstraint.UNCONSTRAINED, true, new HashSet<>(),
				seedDeclaration, results);
		/*
		 * Sorted by stable key, computed once per leg rather than once per comparison: building
		 * one walks the leg's segments.
		 */
		return results.stream()
				.map(leg -> Map.entry(leg.key(), leg))
				.sorted(Map.Entry.comparingByKey())
				.map(Map.Entry::getValue)
				.toList();
	}

	private void descend(ConnectionInstanceEnd current, LegRole role, List<ResolvedSegment> segments,
			FeaturePath featurePath, ModeConstraint modes, boolean allBidirectional, Set<String> visited,
			Connection seedDeclaration, List<LegResult> results) {

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

		var owner = feature.getContainingComponentInstance();
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
		 * returning. Both connections exist, and issue #3044 is the report that they did
		 * not: a port sharing a feature group with a connected access feature got no
		 * connection instance at all.
		 */
		/*
		 * The rule applies to components the traversal descends into, not to the root. A
		 * thread implementation instantiated on its own is the whole model, and its
		 * internals are still reached.
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
		var implementation = InstanceUtil.getComponentImplementation(owner, 0, classifierCache);
		if (implementation == null) {
			results.add(new LegResult(role, current, segments, featurePath, modes, allBidirectional,
					"component type only"));
			return;
		}

		var continuations = continuations(owner, feature, role, visited, endingCategory);
		if (continuations.isEmpty()) {
			Connection leaving = segments.isEmpty() ? seedDeclaration
					: segments.getLast().declaration();
			if (role == LegRole.SOURCE_LEG
					&& !mayBeUltimateSource(owner, feature, implementation, leaving, endingCategory)) {
				return;
			}
			results.add(new LegResult(role, current, segments, featurePath, modes, allBidirectional,
					"no continuing declaration"));
			return;
		}

		if (role == LegRole.DESTINATION_LEG && !endingCategory) {
			stopAtUncontinuedMembers(owner, feature, segments, featurePath, modes, allBidirectional, continuations,
					results);
		}

		for (var segment : continuations) {
			var extended = new ArrayList<>(segments);
			extended.add(segment);
			var branchVisited = new HashSet<>(visited);
			branchVisited.add(orientedKey(segment));
			descend(LeafExpansion.continuation(segment.source(), segment.destination(), feature), role, extended,
					segment.destinationPath(),
					modes.and(segment.declaration(), owner),
					allBidirectional && segment.declaration().isAllBidirectional(), branchVisited, seedDeclaration,
					results);
		}
	}

	/**
	 * Whether a source leg that found nothing to descend into may take the feature it stopped
	 * at as the ultimate source.
	 *
	 * <p>
	 * It may not when the component routes that feature internally: the connection then starts
	 * deeper, and a path starting at the component's own feature would not be maximal. The
	 * question is only worth asking when there is something inside that could be the source,
	 * which is a subcomponent with outgoing features.
	 * </p>
	 *
	 * <p>
	 * Two internal routings refuse the start. A declaration that delivers <em>to</em> the
	 * feature refuses it outright. A declaration that merely names the feature refuses it when
	 * the declaration the path leaves by is bidirectional, because that path could equally be
	 * followed from inside. Where the internal declaration cannot in fact be followed the
	 * other way, no connection exists at all.
	 * </p>
	 *
	 * <p>
	 * A connection ending component is the exception: a semantic connection ends at its port
	 * or feature group whatever it does internally, so it starts there too. Its access
	 * features are not exempt, because shared access reaches through such a component into
	 * what it contains, so the source can be deeper.
	 * </p>
	 */
	private boolean mayBeUltimateSource(ComponentInstance owner, FeatureInstance feature,
			ComponentImplementation implementation, Connection leaving, boolean endingCategory) {
		/*
		 * The root's own features are seeded as boundaries, so there is no maximality
		 * question to ask about them: nothing encloses the root for a longer path to
		 * reach in from.
		 */
		if (owner == root) {
			return true;
		}
		/*
		 * The question is about the component's own feature, not about the member a leg
		 * happens to stand at: what routes onwards internally is declared against the
		 * whole feature.
		 */
		var outermost = outermost(feature);
		if (endingCategory && (includesNestedFeatureGroup(outermost) || includesPort(outermost))) {
			return true;
		}
		if (!AadlUtil.hasOutgoingFeatureSubcomponents(owner.getComponentInstances())
				|| (endingCategory && !includesAccess(outermost))) {
			return true;
		}
		var inside = implementation.getAllConnections();
		var declared = outermost.getFeature();
		if (isDestinationInside(inside, declared)) {
			return false;
		}
		return leaving == null || !leaving.isAllBidirectional() || !isEndInside(inside, declared);
	}

	/** The feature of the component that {@code feature} is, or is a member of. */
	private static FeatureInstance outermost(FeatureInstance feature) {
		var outermost = feature;
		while (outermost.getOwner() instanceof FeatureInstance parent) {
			outermost = parent;
		}
		return outermost;
	}

	/**
	 * Whether one of a component's own declarations delivers to {@code feature}, counting a
	 * bidirectional declaration whichever end names it, and a declaration that names a member
	 * of it. A feature the component delivers to is not where a semantic connection starts.
	 */
	private static boolean isDestinationInside(List<Connection> inside, Feature feature) {
		var refinements = feature.getAllFeatureRefinements();
		for (var declaration : inside) {
			if (declaration instanceof ParameterConnection) {
				continue;
			}
			if (refinements.contains(declaration.getAllDestination())
					|| refinements.contains(declaration.getAllDestinationContext())
					|| declaration.isAllBidirectional() && (refinements.contains(declaration.getAllSource())
							|| refinements.contains(declaration.getAllSourceContext()))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Whether one of a component's own declarations has {@code feature}, or a member of it, as
	 * either end. This is the weaker of the two questions, and it only refuses a start when
	 * the declaration the path leaves by is bidirectional.
	 */
	private static boolean isEndInside(List<Connection> inside, Feature feature) {
		var refinements = feature.getAllFeatureRefinements();
		for (var declaration : inside) {
			if (declaration instanceof ParameterConnection) {
				continue;
			}
			if (refinements.contains(declaration.getAllSource()) || refinements.contains(declaration.getAllDestination())
					|| refinements.contains(declaration.getAllSourceContext())
					|| refinements.contains(declaration.getAllDestinationContext())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Stop the leg at each member of a feature group that the declarations continuing it
	 * leave with nowhere to go.
	 *
	 * <p>
	 * Whether a leg continues into a component is a question about a feature group's
	 * members, not about the group. The declarations that continue it may name only some
	 * members, an access member reaching a subprogram for instance, and leave the rest
	 * with no path onwards. Asking it of the group instead is issue #3044, where a port
	 * sharing a feature group with a connected access feature got no connection instance
	 * at all.
	 * </p>
	 *
	 * <p>
	 * A member with nowhere to go ends the connection only if it triggers a mode
	 * transition of the component, since a mode transition is an end in itself. Any other
	 * such member can reach nothing that ends a connection, so a path to it is recorded as
	 * a dead end and reported rather than materialized. A connection ending component is
	 * left out because the leg already stopped at the whole feature before reaching here,
	 * and expansion narrows that stop to its members.
	 * </p>
	 *
	 * <p>
	 * Nothing is added when the declarations continue the whole feature, and nothing when
	 * they cannot be related to it at all, which leaves an unrecognized shape as it was
	 * rather than guessing at it.
	 * </p>
	 */
	private void stopAtUncontinuedMembers(ComponentInstance owner, FeatureInstance feature,
			List<ResolvedSegment> segments, FeaturePath featurePath, ModeConstraint modes, boolean allBidirectional,
			List<ResolvedSegment> continuations, List<LegResult> results) {
		if (feature.getFeatureInstances().isEmpty()) {
			return;
		}

		var continued = new HashSet<FeatureInstance>();
		for (var continuation : continuations) {
			if (!(continuation.source() instanceof FeatureInstance near)) {
				continue;
			}
			if (near == feature || isNestedIn(feature, near)) {
				return;
			}
			continued.add(near);
		}
		if (continued.isEmpty()) {
			return;
		}

		var uncontinued = new ArrayList<FeatureInstance>();
		collectUncontinuedLeaves(feature, continued, uncontinued);
		for (var member : uncontinued) {
			boolean triggersTransition = SeedDiscovery.triggersModeTransition(owner, member);
			results.add(new LegResult(LegRole.DESTINATION_LEG, member, segments, featurePath, modes, allBidirectional,
					!triggersTransition,
					triggersTransition ? "member triggers a mode transition" : "nothing continues this member"));
		}
	}

	/**
	 * The leaves under {@code feature} that no continuing declaration reaches. A leaf is
	 * reached when a declaration names it or names a feature group that contains it.
	 */
	private static void collectUncontinuedLeaves(FeatureInstance feature, Set<FeatureInstance> continued,
			List<FeatureInstance> uncontinued) {
		if (continued.contains(feature)) {
			return;
		}
		if (feature.getFeatureInstances().isEmpty()) {
			uncontinued.add(feature);
			return;
		}
		for (var member : feature.getFeatureInstances()) {
			collectUncontinuedLeaves(member, continued, uncontinued);
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
		var continuations = new ArrayList<ResolvedSegment>();
		for (var segment : resolved(owner)) {
			/*
			 * Inside a connection-ending component only an access connection continues a
			 * semantic connection: shared access reaches through such a component, while a
			 * port or feature group connection ends at it.
			 */
			if (endingCategory && !(segment.declaration() instanceof AccessConnection)) {
				continue;
			}
			/*
			 * The leg arrives from one declared side and leaves by the other. A source leg
			 * arrives at the declared destination, so the resolution it needs is the one whose
			 * reverse flag says so, and that makes the segment's own source the deeper endpoint
			 * it continues to. The opposite orientation is only available where the declaration
			 * is bidirectional.
			 */
			if (segment.reverse() != role.arrivesAtDeclaredDestination()
					&& !segment.declaration().isAllBidirectional()) {
				continue;
			}
			if (!touches(segment.source(), feature) || visited.contains(orientedKey(segment))) {
				continue;
			}
			// Only a descent continues a leg: the far end must be inside a subcomponent.
			var destinationOwner = switch (segment.destination()) {
			case FeatureInstance destination -> destination.getContainingComponentInstance();
			case ComponentInstance component -> component;
			default -> null;
			};
			if (destinationOwner == null || destinationOwner == owner) {
				continue;
			}
			continuations.add(segment);
		}
		return continuations.stream()
				.map(segment -> Map.entry(segment.key(), segment))
				.sorted(Map.Entry.comparingByKey())
				.map(Map.Entry::getValue)
				.toList();
	}

	/**
	 * Every declaration of {@code owner}, resolved in both orientations, computed once per
	 * component. Which orientations a leg may use is the caller's question: the resolution
	 * itself only says which declared side is the near end.
	 *
	 * <p>
	 * A resolution that failed is reported once, here, rather than once per leg step that met
	 * it: the failure belongs to the declaration and not to the walk that noticed it.
	 * </p>
	 */
	private List<ResolvedSegment> resolved(ComponentInstance owner) {
		return resolvedByContainer.computeIfAbsent(owner, container -> {
			var segments = new ArrayList<ResolvedSegment>();
			ComponentImplementation implementation = InstanceUtil.getComponentImplementation(container, 0,
					classifierCache);
			if (implementation == null) {
				return List.of();
			}
			for (var declaration : implementation.getAllConnections()) {
				for (boolean reverse : new boolean[] { false, true }) {
					var resolution = SeedDiscovery.segment(container, declaration, reverse);
					failures.add(resolution);
					if (resolution instanceof Resolution.Resolved<ResolvedSegment> value) {
						segments.add(value.value());
					}
				}
			}
			return List.copyOf(segments);
		});
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
	 * group. It is also the reason two distinct semantic paths can share an endpoint
	 * pair, and therefore why identity has to include the feature chains and not only
	 * the endpoints; see {@link SemanticConnectionKey}.
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
	 * that contains no feature group does not count, so it does not by itself stop a leg
	 * at a connection ending component: what stops the leg there is a port, which
	 * {@link #includesPort} answers, or a nested group that may contain one.
	 *
	 * <p>
	 * This barely decides anything on its own, and no test pins it. For the stop it is
	 * redundant: inside a connection ending component only an access connection continues a
	 * leg, so a group holding no access member stops anyway, as "no continuing declaration".
	 * Both fixtures in {@code Issue3037RefusedSegmentTest} were written to catch a change here
	 * and neither does. What is left is the source side, where the stop is unconditional while
	 * "no continuing declaration" has to ask {@link #mayBeUltimateSource} first, and no fixture
	 * reaches that difference. Treat it as unverified rather than as a rule with evidence
	 * behind it.
	 * </p>
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
	 * one. Immediate members only: a group two levels up does not inherit what a nested
	 * group contains, which is what makes {@link #includesNestedFeatureGroup} a separate
	 * question from the one it asks about its own members.
	 */
	private static boolean includes(FeatureInstance feature, Predicate<Feature> test) {
		if (!(feature.getFeature() instanceof FeatureGroup)) {
			return test.test(feature.getFeature());
		}
		for (var member : feature.getFeatureInstances()) {
			if (test.test(member.getFeature())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Whether a component of this category ends a semantic connection. These are the four
	 * categories AS5506B treats as the ultimate destination of a connection: a thread, a
	 * device, a processor and a virtual processor consume what arrives at their ports
	 * rather than routing it onwards. Adding or removing a category changes how long every
	 * semantic connection through it is.
	 */
	static boolean isConnectionEndingCategory(ComponentCategory category) {
		return category == THREAD || category == DEVICE || category == PROCESSOR || category == VIRTUAL_PROCESSOR;
	}
}
