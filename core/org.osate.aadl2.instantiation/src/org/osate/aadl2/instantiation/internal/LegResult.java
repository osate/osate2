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

import java.util.List;

import org.osate.aadl2.instance.ConnectionInstanceEnd;

/**
 * One complete leg: where it ended, and everything it traversed to get there.
 *
 * <p>
 * A leg is produced by descending containment from a seed until a terminal policy
 * stops it. Branching produces several results from one seed, which is why
 * resolution returns a list.
 * </p>
 *
 * <p>
 * The segments are in <em>traversal</em> order, which for a source leg runs from
 * the pivot outwards towards the ultimate source. Assembling a path reverses the
 * source leg so that the result reads from ultimate source to ultimate
 * destination.
 * </p>
 *
 * @param role which side of the pivot this leg descends towards
 * @param terminal the endpoint the leg stopped at
 * @param segments the declarations traversed, in traversal order; empty when the
 *            seed endpoint is itself terminal
 * @param featurePath the feature chain at the terminal endpoint
 * @param modes the modal declarations traversed
 * @param allSegmentsBidirectional whether every traversed segment could also be
 *            followed the other way
 * @param deadEnd whether the leg stopped at a feature that can neither carry the
 *            connection further nor end it, so that a path through it is reported
 *            rather than materialized
 * @param reason why the leg stopped, for tests and diagnostics only
 */
public record LegResult(LegRole role, ConnectionInstanceEnd terminal, List<ResolvedSegment> segments,
		FeaturePath featurePath, ModeConstraint modes, boolean allSegmentsBidirectional, boolean deadEnd,
		String reason) {

	/** A leg that stopped somewhere a connection may end. */
	public LegResult(LegRole role, ConnectionInstanceEnd terminal, List<ResolvedSegment> segments,
			FeaturePath featurePath, ModeConstraint modes, boolean allSegmentsBidirectional, String reason) {
		this(role, terminal, segments, featurePath, modes, allSegmentsBidirectional, false, reason);
	}

	public LegResult {
		if (role == null || terminal == null || featurePath == null || modes == null) {
			throw new IllegalArgumentException("A leg result needs a role, a terminal, a feature path, and modes");
		}
		segments = List.copyOf(segments);
	}

	/** Whether the leg stopped where it started, having found nothing to descend into. */
	public boolean isTrivial() {
		return segments.isEmpty();
	}

	/** Stable identity, for deterministic ordering and for tests. Never object identity. */
	public String key() {
		StringBuilder key = new StringBuilder(role.name());
		key.append('|').append(PathKeys.instance(terminal)).append('|');
		for (ResolvedSegment segment : segments) {
			key.append(PathKeys.declarative(segment.declaration())).append(segment.reverse() ? "(r)" : "(f)").append(',');
		}
		return key.append('|').append(reason).toString();
	}
}
