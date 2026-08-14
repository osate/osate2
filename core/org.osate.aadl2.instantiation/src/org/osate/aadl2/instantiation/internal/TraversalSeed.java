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

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.SystemInstance;

/**
 * Where an across-first traversal starts.
 *
 * <p>
 * A complete internal semantic connection is seeded at its across declaration, the
 * one point where it crosses between peers. That declaration identifies the
 * containing component instance and supplies both endpoint feature chains up front,
 * rather than leaving them to be reconstructed once a destination is reached.
 * </p>
 *
 * <p>
 * A connection with no across declaration gets an explicit degenerate seed instead
 * of a special case in the traversal: a system input is a boundary seed plus a
 * destination leg, a system output is a source leg plus a boundary seed, and any
 * other incomplete connection is a one-leg seed.
 * </p>
 */
public sealed interface TraversalSeed {

	/** The component instance the seed belongs to. */
	ComponentInstance container();

	/** Stable identity, for deterministic ordering and for tests. Never object identity. */
	String key();

	/**
	 * A seed at an across declaration, the pivot of a complete semantic connection.
	 *
	 * @param segment the across declaration, resolved in one orientation
	 */
	record Across(ResolvedSegment segment) implements TraversalSeed {

		public Across {
			if (segment == null) {
				throw new IllegalArgumentException("An across seed needs a segment");
			}
			if (!segment.isAcross()) {
				throw new IllegalArgumentException(
						"An across seed needs an across declaration, but " + segment.declaration().getQualifiedName()
								+ " does not cross between peers");
			}
		}

		@Override
		public ComponentInstance container() {
			return segment.context();
		}

		@Override
		public String key() {
			return "across|" + segment.key();
		}
	}

	/**
	 * A seed at a feature of the system instance, where a connection enters or leaves
	 * the model.
	 *
	 * <p>
	 * Only a top-level feature of the system instance is seeded, never a feature
	 * contained in one. Source-first traversal seeds both, so the contained-member seed
	 * re-enumerates a path the enclosing seed already covers; that redundant seed is the
	 * one that crashed in issue #3038. Reaching into the feature group is the job of the
	 * declaration's own connected-element chain, which resolves the deeper endpoint
	 * directly.
	 * </p>
	 *
	 * @param container the system instance
	 * @param feature the boundary feature
	 * @param incoming whether the traversal leads inwards from this feature, as
	 *            opposed to outwards towards it
	 */
	record Boundary(SystemInstance container, FeatureInstance feature, boolean incoming) implements TraversalSeed {

		public Boundary {
			if (container == null || feature == null) {
				throw new IllegalArgumentException("A boundary seed needs a system instance and a feature");
			}
			if (feature.getOwner() instanceof FeatureInstance) {
				throw new IllegalArgumentException(
						"A boundary seed must be a top-level feature of the system instance, but "
								+ feature.getInstanceObjectPath() + " is contained in another feature");
			}
		}

		@Override
		public String key() {
			return "boundary|" + PathKeys.instance(feature) + (incoming ? "|in" : "|out");
		}
	}

	/**
	 * A seed at an event port of a subcomponent that triggers a mode transition in the
	 * component containing it.
	 *
	 * <p>
	 * Such a port ends a semantic connection even though the connection reaches no peer
	 * and leaves no boundary: the trigger is the connection's consumer. Source-first
	 * creates it in {@code appendSegment()} when an upward path can go no further and
	 * {@code isModeTransitionTrigger()} holds; where that test fails it warns instead and
	 * creates nothing, which is why this seed exists only for a port that really is a
	 * trigger.
	 * </p>
	 *
	 * <p>
	 * The seed is outward only. A connection arrives at the trigger from inside the
	 * subcomponent; nothing starts at a trigger and travels down.
	 * </p>
	 *
	 * @param container the subcomponent whose feature this is
	 * @param feature the triggering event port
	 */
	record Trigger(ComponentInstance container, FeatureInstance feature) implements TraversalSeed {

		public Trigger {
			if (container == null || feature == null) {
				throw new IllegalArgumentException("A trigger seed needs a component instance and a feature");
			}
		}

		@Override
		public String key() {
			return "trigger|" + PathKeys.instance(feature);
		}
	}
}
