/**
 * Copyright (c) 2004-2022 Carnegie Mellon University and others. (see Contributors file).
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
import java.util.function.Function;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.RelativeBusinessObjectReference;

class FilterByBusinessObjectRelativeReferenceQuery<T> extends DefaultQuery<T> {
	private final Function<T, Object> boSupplier;
	private RelativeBusinessObjectReference nullBoRef = new RelativeBusinessObjectReference("<null>");

	public FilterByBusinessObjectRelativeReferenceQuery(final DefaultQuery<T> prev,
			final Function<T, Object> boSupplier) {
		super(prev);
		this.boSupplier = Objects.requireNonNull(boSupplier, "boSupplier must not be null");
	}

	@Override
	void run(final Deque<DefaultQuery<T>> remainingQueries, final BusinessObjectContext ctx,
			final QueryExecutionState<T> state, final QueryResults result) {
		// Look in the cache for the reference and build a new reference string if it is not found
		final RelativeBusinessObjectReference boRef = (RelativeBusinessObjectReference) state.cache
				.computeIfAbsent(this, t -> {
					final Object bo = boSupplier.apply(state.arg);
					RelativeBusinessObjectReference newValue = bo == null ? nullBoRef
							: state.refBuilder.getRelativeReference(bo);
					if (newValue == null) {
						newValue = nullBoRef;
					}
					return newValue;
				});

		if(boRef == nullBoRef) {
			return;
		}

		// Compare references
		if(ctx.getBusinessObject() != null) {
			final RelativeBusinessObjectReference ctxRelativeReference = InternalQueryUtil.getRelativeReference(ctx,
					state.refBuilder);
			if(ctxRelativeReference != null && ctxRelativeReference.equals(boRef)) {
				processResultValue(remainingQueries, ctx, state, result);
			}
		}
	}
}
