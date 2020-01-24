/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.ge.internal.query;

import java.util.Deque;
import java.util.Objects;

import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.query.Supplier;

public class DescendantsByBusinessObjectRelativeReferencesQuery extends DefaultQuery {
	private final static RelativeBusinessObjectReference[] nullBoRefs = new RelativeBusinessObjectReference[0];
	private final Supplier<Object, Object[]> bosSupplier;
	private final int minSegments;

	private static class Match {
		Queryable value;
		int depth = -1;
	}

	public DescendantsByBusinessObjectRelativeReferencesQuery(final DefaultQuery prev,
			final Supplier<?, Object[]> bosSupplier) {
		this(prev, bosSupplier, -1);
	}

	@SuppressWarnings("unchecked")
	public DescendantsByBusinessObjectRelativeReferencesQuery(final DefaultQuery prev,
			final Supplier<?, Object[]> bosSupplier,
					final int minSegments) {
		super(prev);
		this.bosSupplier = (Supplier<Object, Object[]>) Objects.requireNonNull(bosSupplier, "bosSupplier must not be null");
		this.minSegments = minSegments;
	}

	@Override
	void run(final Deque<DefaultQuery> remainingQueries, final Queryable ctx, final QueryExecutionState state, final QueryResult result) {
		// Look in the cache for the reference and build a new reference string if it is not found
		RelativeBusinessObjectReference[] boRefs = (RelativeBusinessObjectReference[])state.cache.get(this);
		if(boRefs == null) {
			final Object[] bos = bosSupplier.get(state.arg);
			boRefs = bos == null ? nullBoRefs : getReferences(bos, state.refBuilder);
			if(boRefs == null) {
				boRefs = nullBoRefs;
			}
			state.cache.put(this, boRefs);
		}

		if(boRefs == nullBoRefs) {
			return;
		}

		final Match bestMatch = new Match();
		findMatchingDescendants(remainingQueries, ctx, state, result, boRefs, bestMatch, 0);

		// Return a partial match if a result has not been processed and a partial match was found
		if(!result.done &&
				allowPartialMatch() &&
				bestMatch.depth >= minSegments &&
				bestMatch.depth < boRefs.length) {
			processResultValue(remainingQueries, bestMatch.value, state, result);
		}
	}

	private boolean allowPartialMatch() {
		return minSegments > 0;
	}

	void findMatchingDescendants(final Deque<DefaultQuery> remainingQueries,
			final Queryable container,
			final QueryExecutionState state,
			final QueryResult result,
			final RelativeBusinessObjectReference[] boRefs,
			final Match bestMatch,
			final int currentDepth) {
		if(currentDepth > bestMatch.depth) {
			bestMatch.value = container;
			bestMatch.depth = currentDepth;
		}

		if(currentDepth >= boRefs.length) {
			processResultValue(remainingQueries, container, state, result);
		} else {
			final RelativeBusinessObjectReference boRef = boRefs[currentDepth];
			for(final Queryable child : container.getChildren()) {
				// Check the business object reference
				final RelativeBusinessObjectReference childRef = InternalQueryUtil.getRelativeReference(child,
						state.refBuilder);
				if (boRef.equals(childRef)) {
					findMatchingDescendants(remainingQueries, child, state, result, boRefs, bestMatch,
							currentDepth + 1);
				}

				if (result.done) {
					return;
				}
			}
		}
	}

	/**
	 * Returns an array of references for an array of business objects.
	 * @param bos
	 * @param refBuilder
	 * @return an array of references. null if any of the business objects or their references are null.
	 */
	private static RelativeBusinessObjectReference[] getReferences(final Object[] bos, final ReferenceService refBuilder) {
		if(bos == null) {
			return null;
		}

		final RelativeBusinessObjectReference[] references = new RelativeBusinessObjectReference[bos.length];
		for(int i = 0; i < bos.length; i++) {
			final Object bo = bos[i];
			if(bo == null) {
				return null;
			}

			final RelativeBusinessObjectReference ref = refBuilder.getRelativeReference(bo);
			if(ref == null) {
				return null;
			}

			references[i] = ref;
		}

		return references;
	}
}
