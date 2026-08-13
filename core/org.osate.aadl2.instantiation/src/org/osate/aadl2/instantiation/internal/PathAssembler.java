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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
 * Every source leg is joined with every destination leg. Comparing the two legs'
 * feature chains to filter pairs does not work, because those chains describe
 * features of different components and so never match; a predicate built on them
 * rejected every pair where both legs had descended, which lost the connection
 * entirely. What pairs correctly is decided instead by the pivot, whose two endpoints
 * are already resolved against each other, and by leaf expansion, which pairs feature
 * group members and filters on direction.
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
		Map<SemanticConnectionKey, SemanticConnectionPath> unique = new LinkedHashMap<>();
		if (seed instanceof TraversalSeed.Across across) {
			for (LegResult sourceLeg : sourceLegs) {
				for (LegResult destinationLeg : destinationLegs) {
					add(unique, assembleComplete(across, sourceLeg, destinationLeg));
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
					add(unique, assembleBoundary(boundary, leg));
				}
			}
		}
		List<SemanticConnectionPath> paths = new ArrayList<>(unique.values());
		paths.sort(Comparator.comparing(path -> SemanticConnectionKey.of(path).toString()));
		return List.copyOf(paths);
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
				combine(sourceLeg, destinationLeg));
	}

	/**
	 * An incomplete boundary path, which has no pivot. An outgoing boundary feature is
	 * the destination of a path that starts inside the model, so its leg is reversed; an
	 * incoming one is the source of a path that continues inwards, so its leg is used as
	 * it stands.
	 */
	private static SemanticConnectionPath assembleBoundary(TraversalSeed.Boundary boundary, LegResult leg) {
		if (boundary.incoming()) {
			return new SemanticConnectionPath(boundary.feature(), leg.terminal(), leg.segments(), false,
					leg.allSegmentsBidirectional(), leg.modes());
		}
		return new SemanticConnectionPath(leg.terminal(), boundary.feature(), reversed(leg), false,
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
			if (!SeedDiscovery.directionsValidInPathOrder(segment)) {
				return;
			}
		}
		unique.putIfAbsent(SemanticConnectionKey.of(path), path);
	}
}
