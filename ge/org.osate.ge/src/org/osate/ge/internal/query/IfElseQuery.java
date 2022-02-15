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
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.query.Query;
import org.osate.ge.query.QueryResult;

class IfElseQuery<T> extends DefaultQuery<T> {
	private final Function<ConditionArguments<T>, Boolean> cond;
	private final DefaultQuery<T> trueQuery;
	private final DefaultQuery<T> falseQuery;
	private final RootQuery<T> innerRootQuery = new RootQuery<>(() -> this.innerRootValue);
	private BusinessObjectContext innerRootValue;

	public IfElseQuery(final DefaultQuery<T> prev,
			final Function<ConditionArguments<T>, Boolean> cond, final Function<Query<T>, Query<T>> trueQuerySupplier,
			final Function<Query<T>, Query<T>> falseQuerySupplier) {
		super(prev);
		this.cond = Objects.requireNonNull(cond, "cond must not be null");
		Objects.requireNonNull(trueQuerySupplier, "trueQuerySupplier must not be null");
		Objects.requireNonNull(falseQuerySupplier, "falseQuerySupplier must not be null");
		this.trueQuery = (DefaultQuery<T>) Objects.requireNonNull(trueQuerySupplier.apply((Query<T>) innerRootQuery),
				"trueQuery must not be null");
		this.falseQuery = (DefaultQuery<T>) Objects.requireNonNull(falseQuerySupplier.apply((Query<T>) innerRootQuery),
				"falseQuery must not be null");
	}

	@Override
	void run(final Deque<DefaultQuery<T>> remainingQueries, final BusinessObjectContext ctx,
			final QueryExecutionState<T> state, final QueryResults result) {
		try {
			this.innerRootValue = ctx;

			// Set Condition Arguments
			@SuppressWarnings("unchecked")
			final ExpressionArguments<T> conditionArgs = (ExpressionArguments<T>) state.cache
			.computeIfAbsent(this, t -> new ExpressionArguments<>());
			conditionArgs.update(state, ctx);

			// Evaluate the condition
			final Boolean condResult = cond.apply(conditionArgs);
			final DefaultQuery<T> innerQuery = condResult.booleanValue() ? trueQuery : falseQuery;

			// Process the results of the inner query.
			// NOTE: Ideally this would be lazily evaluated instead of retrieving all the results. However, in the current use cases, only one result will be
			// returned by the inner query.
			final List<QueryResult> containers = state.queryRunner.getResults(innerQuery, state.arg);
			for (final QueryResult container : containers) {
				processResultValue(remainingQueries, container.getBusinessObjectContext(), state, result);

				if(result.isDone()) {
					return;
				}
			}
		} finally {
			innerRootValue = null;
		}
	}
}
