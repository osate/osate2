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
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.query.FilterArguments;
import org.osate.ge.query.Query;
import org.osate.ge.query.QueryResult;

public abstract class DefaultQuery<T> implements Query<T> {
	private DefaultQuery<T> prev;

	public DefaultQuery(final DefaultQuery<T> prev) {
		this.prev = prev;
	}

	public final DefaultQuery<T> getPrev() {
		return prev;
	}

	abstract void run(final Deque<DefaultQuery<T>> remainingQueries, final BusinessObjectContext ctx,
			final QueryExecutionState<T> state, final QueryResults result);

	protected void processResultValue(final Deque<DefaultQuery<T>> remainingQueries, final BusinessObjectContext value,
			final QueryExecutionState<T> state, final QueryResults result) {
		if (remainingQueries.size() == 0) {
			result.results.add(new QueryResult(value, state.partial));
			return;
		}

		final DefaultQuery<T> nextQuery = remainingQueries.pop();
		final boolean wasPartial = state.partial;
		nextQuery.run(remainingQueries, value, state, result);
		state.partial = wasPartial;
		remainingQueries.push(nextQuery);
	}

	@Override
	public DefaultQuery<T> first(int count) {
		return new FirstQuery<>(this, count);
	}

	@Override
	public DefaultQuery<T> first() {
		return new FirstQuery<>(this);
	}

	@Override
	public DefaultQuery<T> filter(final Predicate<FilterArguments<T>> filter) {
		return new FilterByPredicate<>(this, filter);
	}

	@Override
	public DefaultQuery<T> filterByBusinessObjectRelativeReference(final Function<T, Object> boSupplier) {
		return new FilterByBusinessObjectRelativeReferenceQuery<>(this, boSupplier);
	}

	@Override
	public DefaultQuery<T> filterByBusinessObjectCanonicalReference(final Function<T, Object> boSupplier) {
		return new FilterByBusinessObjectCanonicalReferenceQuery<>(this, boSupplier);
	}

	@Override
	public DefaultQuery<T> children() {
		return new ChildrenQuery<>(this);
	}

	@Override
	public DefaultQuery<T> descendants() {
		return new DescendantsQuery<>(this);
	}

	@Override
	public DefaultQuery<T> ancestor(final int depth) {
		return new AncestorQuery<>(this, depth);
	}

	@Override
	public DefaultQuery<T> ancestors() {
		return new AncestorsQuery<>(this);
	}

	@Override
	public DefaultQuery<T> commonAncestors(Query<T> q2) {
		if (!(q2 instanceof DefaultQuery)) {
			throw new RuntimeException("q2 must be of type PictogramQuery");
		}

		return new CommonAncestorsQuery<>(this, (DefaultQuery<T>) q2);
	}

	@Override
	public DefaultQuery<T> ifElse(final Function<ConditionArguments<T>, Boolean> cond,
			final UnaryOperator<Query<T>> trueQuerySupplier, final UnaryOperator<Query<T>> falseQuerySupplier) {
		return new IfElseQuery<>(this, cond, trueQuerySupplier, falseQuerySupplier);
	}

	@Override
	public DefaultQuery<T> descendantsByBusinessObjectsRelativeReference(final Function<T, Object[]> bosSupplier) {
		return new DescendantsByBusinessObjectRelativeReferencesQuery<>(this, bosSupplier);
	}

	@Override
	public Query<T> descendantsByBusinessObjectsRelativeReference(final Function<T, Object[]> bosSupplier,
			final int minSegments) {
		return new DescendantsByBusinessObjectRelativeReferencesQuery<>(this, bosSupplier,
				minSegments);
	}
}
