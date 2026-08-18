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
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.Port;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.SystemInstance;

/**
 * Joins legs into whole semantic connection paths.
 *
 * <p>
 * A path reads from ultimate source to ultimate destination, so the source leg is
 * reversed and each of its segments re-oriented: the leg walked outwards from the
 * pivot, entering each declaration from the side the finished path leaves it by. The
 * baseline agrees on both points. For the issue #3019 model it reports declarations in
 * the order {@code up, nested_up, across} with every reverse flag false, while the
 * legs that produced them were resolved reversed.
 * </p>
 *
 * <p>
 * Structural properties are not consulted here. {@code Connection_Pattern} and
 * {@code Connection_Set} are cached on materialized connection instances, and
 * expansion branches on materialized orientation, so they constrain the final
 * expansion stage rather than this join.
 * </p>
 *
 * <p>
 * Two legs pair when the members of the pivot they leave from correspond. Comparing the
 * legs' whole feature chains to filter pairs does not work, because those chains describe
 * features of different components and so never match; a predicate built on them rejected
 * every pair where both legs had descended, which lost the connection entirely. What can
 * be compared is where each leg attaches to its own end of the pivot, because the pivot's
 * two endpoints are already resolved against each other: a leg leaving one member of a
 * connected feature group belongs with the leg leaving the member that pairs with it and
 * with no other. Everything below that, and direction, is left to leaf expansion.
 * </p>
 *
 * <p>
 * Directions are not checked here. Since issue #3042 a connection whose direction does
 * not work out is materialized and reported by connection validation, so filtering such
 * a path out during enumeration would suppress the diagnostic that both strategies are
 * expected to produce.
 * </p>
 *
 * <p>
 * Mode constraints are carried, not enforced. A topologically valid path whose modes
 * have no compatible system operation mode is still assembled, so that the existing
 * pipeline can materialize it, compute its system operation modes, emit the existing
 * warning when none are active, and delete it. Deciding earlier would change which
 * diagnostics a model produces.
 * </p>
 */
public final class PathAssembler {

	private PathAssembler() {
	}

	/**
	 * Every path that can be built from {@code seed} and the given legs, deduplicated
	 * by structured identity and returned in deterministic key order.
	 *
	 * @param seed the pivot or boundary the legs were resolved from
	 * @param sourceLegs legs towards the ultimate source; a single trivial leg when the
	 *            seed endpoint is itself the ultimate source
	 * @param destinationLegs legs towards the ultimate destination
	 */
	public static List<SemanticConnectionPath> join(TraversalSeed seed, List<LegResult> sourceLegs,
			List<LegResult> destinationLegs) {
		return join(seed, sourceLegs, destinationLegs, TraversalObservations.disabled());
	}

	/**
	 * Every path that can be built from {@code seed} and the given legs, counting the join
	 * attempts in {@code observations} so that the work can be compared with what source-first
	 * spends on the same model.
	 */
	public static List<SemanticConnectionPath> join(TraversalSeed seed, List<LegResult> sourceLegs,
			List<LegResult> destinationLegs, TraversalObservations observations) {
		Map<SemanticConnectionKey, SemanticConnectionPath> unique = new LinkedHashMap<>();
		if (seed instanceof TraversalSeed.Across across) {
			for (LegResult sourceLeg : sourceLegs) {
				for (LegResult destinationLeg : destinationLegs) {
					observations.increment(TraversalObservations.Counter.JOIN_CANDIDATES);
					if (attachedMembersCorrespond(across, sourceLeg, destinationLeg)) {
						add(unique, assembleComplete(across, sourceLeg, destinationLeg));
					}
				}
			}
		} else if (seed instanceof TraversalSeed.Boundary boundary) {
			for (LegResult leg : boundary.incoming() ? destinationLegs : sourceLegs) {
				/*
				 * A boundary feature with nothing connected inside it yields a leg that stopped
				 * where it started. There is no semantic connection, so there is no path: a
				 * boundary seed contributes no pivot of its own.
				 */
				if (!leg.isTrivial()) {
					add(unique, assembleOneLeg(boundary.incoming(), leg));
				}
			}
		} else if (seed instanceof TraversalSeed.Trigger) {
			for (LegResult leg : sourceLegs) {
				if (!leg.isTrivial()) {
					add(unique, assembleOneLeg(false, leg));
				}
			}
		}
		/*
		 * Sorted by structured identity, with the key computed once per path rather than once per
		 * comparison: building one walks the whole path.
		 */
		return unique.entrySet()
				.stream()
				.sorted(Comparator.comparing(entry -> entry.getKey().toString()))
				.map(Map.Entry::getValue)
				.toList();
	}

	/** A complete path: source leg reversed, then the pivot, then the destination leg. */
	private static SemanticConnectionPath assembleComplete(TraversalSeed.Across across, LegResult sourceLeg,
			LegResult destinationLeg) {
		List<ResolvedSegment> segments = new ArrayList<>(reversed(sourceLeg));
		segments.add(across.segment());
		segments.addAll(destinationLeg.segments());
		return new SemanticConnectionPath(sourceLeg.terminal(), destinationLeg.terminal(), segments, true,
				across.segment().declaration().isAllBidirectional() && sourceLeg.allSegmentsBidirectional()
						&& destinationLeg.allSegmentsBidirectional(),
				combine(sourceLeg, destinationLeg), destinationLeg.deadEnd());
	}

	/**
	 * Whether the two legs leave members of the pivot that pair with each other.
	 *
	 * <p>
	 * The member a leg covers is its footprint on the pivot endpoint, not merely the feature
	 * its first declaration names: a leg that descends several levels narrows the connection
	 * at each of them, and only the leg whose whole chain pairs with this one's continues the
	 * same semantic connection. Without this, a feature group connecting two components that
	 * each route several members onwards produces a path for every combination of them, and
	 * comparing only the first level lets the combinations below it through.
	 * </p>
	 *
	 * <p>
	 * A leg that covers the pivot endpoint itself, or a feature group containing it,
	 * constrains nothing: the connection then covers the whole endpoint and which members
	 * it pairs is leaf expansion's decision. The same holds level by level, which is why
	 * only the levels both footprints reach are compared.
	 * </p>
	 */
	private static boolean attachedMembersCorrespond(TraversalSeed.Across across, LegResult sourceLeg,
			LegResult destinationLeg) {
		List<FeatureInstance> sourceMembers = LeafExpansion.membersBelow(across.segment().source(),
				footprint(sourceLeg));
		List<FeatureInstance> destinationMembers = LeafExpansion.membersBelow(across.segment().destination(),
				footprint(destinationLeg));
		ConnectionInstanceEnd destinationParent = across.segment().destination();
		for (int level = 0; level < Math.min(sourceMembers.size(), destinationMembers.size()); level++) {
			FeatureInstance destination = destinationMembers.get(level);
			if (!pairs(sourceMembers.get(level), destinationParent, destination)) {
				return false;
			}
			destinationParent = destination;
		}
		return true;
	}

	/**
	 * The feature at or below the pivot endpoint that a leg covers: its terminal mapped back
	 * up through every segment it traversed, so that what a declaration deep inside the leg
	 * narrowed is still visible at the pivot. A leg that traversed nothing covers its own
	 * terminal, which is the pivot endpoint.
	 */
	private static ConnectionInstanceEnd footprint(LegResult leg) {
		ConnectionInstanceEnd covered = leg.terminal();
		List<ResolvedSegment> segments = leg.segments();
		for (int i = segments.size() - 1; i >= 0; i--) {
			ResolvedSegment segment = segments.get(i);
			covered = LeafExpansion.continuation(segment.destination(), segment.source(), covered);
		}
		return covered;
	}

	/**
	 * Whether two members of two connected feature groups are the pair the group mapping
	 * makes them, decided the same way {@link LeafExpansion} pairs members.
	 */
	private static boolean pairs(FeatureInstance source, ConnectionInstanceEnd destinationParent,
			FeatureInstance destination) {
		if (!(destinationParent instanceof FeatureInstance destinationGroup)) {
			return source.getName().equalsIgnoreCase(destination.getName());
		}
		return LeafExpansion.matchingMember(destinationGroup, source) == destination;
	}

	/**
	 * An incomplete one-leg path, which has no pivot. A seed the path travels
	 * <em>towards</em> is the destination of a path that starts inside, so its leg is
	 * reversed; a seed the path travels away from is the source of a path that continues
	 * inwards, so its leg is used as it stands.
	 *
	 * <p>
	 * The endpoint at the seed is where the leg's own first declaration meets it, not the
	 * seed feature. A declaration may reach <em>into</em> a boundary feature group and
	 * connect one member of it, and then that member is the endpoint: the seed feature
	 * names where the traversal started looking, not how far the connection reaches.
	 * Source-first arrives at the same feature by narrowing the group end afterwards with
	 * its {@code upFeature} and {@code downFeature} stacks.
	 * </p>
	 */
	private static SemanticConnectionPath assembleOneLeg(boolean inwards, LegResult leg) {
		ConnectionInstanceEnd seedEnd = leg.segments().get(0).source();
		if (inwards) {
			return new SemanticConnectionPath(seedEnd, leg.terminal(), leg.segments(), false,
					leg.allSegmentsBidirectional(), leg.modes(), leg.deadEnd());
		}
		return new SemanticConnectionPath(leg.terminal(), seedEnd, reversed(leg), false,
				leg.allSegmentsBidirectional(), leg.modes());
	}

	/**
	 * A leg's segments in path order: the list reversed, and every segment re-oriented,
	 * because the finished path traverses each declaration the opposite way from the leg
	 * that discovered it.
	 */
	private static List<ResolvedSegment> reversed(LegResult leg) {
		List<ResolvedSegment> reversed = new ArrayList<>();
		for (int i = leg.segments().size() - 1; i >= 0; i--) {
			ResolvedSegment segment = leg.segments().get(i);
			reversed.add(new ResolvedSegment(segment.declaration(), segment.context(), segment.destination(),
					segment.source(), !segment.reverse(), segment.destinationPath(), segment.sourcePath()));
		}
		return reversed;
	}

	private static ModeConstraint combine(LegResult sourceLeg, LegResult destinationLeg) {
		List<ModeConstraint.Requirement> requirements = new ArrayList<>(sourceLeg.modes().requirements());
		requirements.addAll(destinationLeg.modes().requirements());
		return new ModeConstraint(requirements);
	}

	/**
	 * Keep one path per structured identity. Two routes through the seed index can reach
	 * the same path, and enumerating it twice is wasted work. This is bookkeeping, so it
	 * must not collapse two paths that differ in any identity field.
	 */
	private static void add(Map<SemanticConnectionKey, SemanticConnectionPath> unique, SemanticConnectionPath path) {
		for (ResolvedSegment segment : path.segments()) {
			if (!traversable(segment)) {
				return;
			}
		}
		unique.putIfAbsent(SemanticConnectionKey.of(path), path);
	}

	/**
	 * Whether a segment may be traversed, read in path order.
	 *
	 * <p>
	 * A connection ending component ends a semantic connection, so a path that leaves a
	 * port and arrives at something the component itself contains is not a path: it would
	 * connect a component to its own insides. Source-first refuses the same segment at
	 * {@code CreateConnectionsSwitch.java:641}, added for issue #2032 to stop a connection
	 * from an abstract subcomponent's port to a port of its containing thread.
	 * </p>
	 *
	 * <p>
	 * As written there the rule reaches further than its comment describes, because a
	 * subcomponent instance is also contained in the component: a port connection into a
	 * data subcomponent of a thread is refused too, which is why {@code DataTest.aadl}
	 * produces no connection instance for {@code port input -> myData}. That is baseline
	 * behavior and is reproduced here rather than corrected.
	 * </p>
	 *
	 * <p>
	 * Only path order can decide this, since it names which end the path leaves and which
	 * it arrives at. A leg resolves its segments in the opposite orientation, so the check
	 * belongs here, after {@link #reversed} has flipped them.
	 * </p>
	 */
	private static boolean traversable(ResolvedSegment segment) {
		if (segment.source() instanceof FeatureInstance source && source.getFeature() instanceof Port
				&& segment.destination() != null && segment.destination().eContainer() == segment.context()
				&& LegResolver.isConnectionEndingCategory(segment.context().getCategory())) {
			return false;
		}
		return !arrivesAtUnreachableParameter(segment);
	}

	/**
	 * Whether a segment arrives at a parameter the baseline refuses to reach.
	 *
	 * <p>
	 * A parameter belongs to a subprogram or a subprogram call, and the instance model has
	 * never carried a connection that arrives at one from a data component or from the
	 * top-level instance. Source-first refuses those at
	 * {@code CreateConnectionsSwitch.java:543}, recorded there as bug #220. Its third
	 * condition tests the component the declaration sits in for being the instantiation
	 * root, which is why the same model produces different connections depending on
	 * whether it is instantiated on its own or as a subcomponent.
	 * </p>
	 *
	 * <p>
	 * Nothing refuses a segment that <em>leaves</em> a parameter, so a connection out of
	 * one is still built.
	 * </p>
	 */
	private static boolean arrivesAtUnreachableParameter(ResolvedSegment segment) {
		if (!(segment.destination() instanceof FeatureInstance destination)
				|| !(destination.getFeature() instanceof Parameter)) {
			return false;
		}
		if (segment.context() instanceof SystemInstance) {
			return true;
		}
		if (segment.source() instanceof ComponentInstance source) {
			return source.getSubcomponent() instanceof DataSubcomponent;
		}
		return ((FeatureInstance) segment.source()).getFeature() instanceof DataAccess;
	}
}
