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

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;

/**
 * A complete enumerated semantic connection, before anything is materialized.
 *
 * <p>
 * Nothing here is an EMF instance object of the connection itself: enumeration
 * produces values, and only materialization attaches a {@code ConnectionInstance}.
 * A rejected path leaves nothing behind, so exploring a partial path is safe.
 * </p>
 *
 * <p>
 * The endpoints are the <em>ultimate</em> source and destination, which for a
 * connection reaching into a feature group sit below the endpoints of the first and
 * last segments. That relationship is established when the path is materialized and
 * is not asserted here.
 * </p>
 *
 * @param source the ultimate source
 * @param destination the ultimate destination
 * @param segments the traversed segments, from the ultimate source towards the
 *            ultimate destination
 * @param complete whether the path crosses between peers, which is exactly whether
 *            it has an across segment
 * @param allSegmentsBidirectional whether every segment could also be followed the
 *            other way. Internal traversal state only: the materializer must not
 *            copy it to {@code ConnectionInstance.bidirectional}, which normal
 *            instantiation leaves {@code false}
 * @param modes the modal declarations the path passes through
 * @param deadEnd whether the path arrives at a feature that can neither carry it
 *            further nor end it. Such a path is reported rather than materialized, so
 *            no connection instance exists for it
 */
public record SemanticConnectionPath(ConnectionInstanceEnd source, ConnectionInstanceEnd destination,
		List<ResolvedSegment> segments, boolean complete, boolean allSegmentsBidirectional, ModeConstraint modes,
		boolean deadEnd) {

	/** A path that ends somewhere a connection may end. */
	public SemanticConnectionPath(ConnectionInstanceEnd source, ConnectionInstanceEnd destination,
			List<ResolvedSegment> segments, boolean complete, boolean allSegmentsBidirectional, ModeConstraint modes) {
		this(source, destination, segments, complete, allSegmentsBidirectional, modes, false);
	}

	public SemanticConnectionPath {
		if (source == null || destination == null) {
			throw new IllegalArgumentException("A semantic connection path needs both ultimate endpoints, but got "
					+ PathKeys.instance(source) + " -> " + PathKeys.instance(destination));
		}
		if (modes == null) {
			throw new IllegalArgumentException("A semantic connection path needs a mode constraint");
		}
		segments = List.copyOf(segments);
		if (segments.isEmpty()) {
			throw new IllegalArgumentException("A semantic connection path needs at least one segment");
		}

		/*
		 * A semantic connection has one containment turning point: it travels up zero or
		 * more levels, crosses between peers once, and travels down zero or more levels.
		 * More than one across segment is an implementation defect rather than a legal
		 * path, so it fails here. Source-first traversal overwrote its record of the
		 * across segment and its container when it met a second one.
		 */
		long across = segments.stream().filter(ResolvedSegment::isAcross).count();
		if (across > 1) {
			throw new IllegalStateException("A semantic connection path may cross between peers at most once, but "
					+ PathKeys.instance(source) + " -> " + PathKeys.instance(destination) + " has " + across
					+ " across segments");
		}
		if (complete != (across == 1)) {
			throw new IllegalStateException("A semantic connection path is complete exactly when it crosses between "
					+ "peers, but " + PathKeys.instance(source) + " -> " + PathKeys.instance(destination)
					+ " has complete=" + complete + " with " + across + " across segments");
		}
	}

	/** The across segment, or {@code null} for a one-leg boundary or incomplete path. */
	public ResolvedSegment acrossSegment() {
		return segments.stream().filter(ResolvedSegment::isAcross).findFirst().orElse(null);
	}

	/**
	 * The component instance that will contain the connection instance, or {@code null}
	 * for an incomplete path.
	 *
	 * <p>
	 * A complete path is contained by the component where it crosses between peers. An
	 * incomplete path has no such component and belongs to the instantiation root; the
	 * root is not reachable from a path, so the materializer substitutes it. Returning
	 * the last segment's context instead would put an inward boundary connection inside
	 * the subcomponent it descends into, and connection names are relative to the
	 * container, so the name would change too.
	 * </p>
	 */
	public ComponentInstance container() {
		return acrossSegment() != null ? acrossSegment().context() : null;
	}

	public int length() {
		return segments.size();
	}

	/**
	 * Structured identity of this path, for suppressing redundant enumeration. Built
	 * from stable keys, never from object identity or display names.
	 */
	public SemanticConnectionKey key() {
		return SemanticConnectionKey.of(this);
	}
}
