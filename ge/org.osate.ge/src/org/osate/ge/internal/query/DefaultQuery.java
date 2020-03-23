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
import java.util.function.Predicate;
import org.osate.ge.query.Query;
import org.osate.ge.query.FilterArguments;
import org.osate.ge.query.Supplier;

public abstract class DefaultQuery implements Query {
	private DefaultQuery prev;
	
	public DefaultQuery(final DefaultQuery prev) {
		this.prev = prev;
	}
	
	public final DefaultQuery getPrev() {
		return prev;
	}
	
	abstract void run(final Deque<DefaultQuery> remainingQueries, final Queryable ctx, final QueryExecutionState state, final QueryResult result);
	
	protected void processResultValue(final Deque<DefaultQuery> remainingQueries, final Queryable value, final QueryExecutionState state, final QueryResult result) {
		if(remainingQueries.size() == 0) {
			result.result.add(value);
			return;
		}
		
		final DefaultQuery nextQuery = remainingQueries.pop();
		nextQuery.run(remainingQueries, value, state, result);
		remainingQueries.push(nextQuery);
	}
	
	
	@Override
	public DefaultQuery first(int count) {
		return new FirstQuery(this, count);
	}
	
	@Override
	public DefaultQuery first() {
		return new FirstQuery(this);
	}

	@Override
	public DefaultQuery filter(final Predicate<FilterArguments> filter) {
		return new FilterByPredicate(this, filter);
	}
	
	@Override
	public DefaultQuery filterByBusinessObjectRelativeReference(final Supplier<?, Object> boSupplier) {
		return new FilterByBusinessObjectRelativeReferenceQuery(this, boSupplier);
	}

	@Override
	public DefaultQuery filterByBusinessObjectCanonicalReference(final Supplier<?, Object> boSupplier) {
		return new FilterByBusinessObjectCanonicalReferenceQuery(this, boSupplier);
	}
	
	@Override
	public DefaultQuery children() {
		return new ChildrenQuery(this);
	}
	
	@Override
	public DefaultQuery descendants() {
		return new DescendantsQuery(this);
	}
	
	@Override
	public DefaultQuery ancestor(final int depth) {
		return new AncestorQuery(this, depth);
	}

	@Override
	public DefaultQuery ancestors() {
		return new AncestorsQuery(this);
	}

	@Override
	public DefaultQuery commonAncestors(Query q2) {
		if(!(q2 instanceof DefaultQuery)) {
			throw new RuntimeException("q2 must be of type PictogramQuery");
		}
		
		return new CommonAncestorsQuery(this, (DefaultQuery)q2);
	}
	
	@Override
	public DefaultQuery ifElse(Supplier<ConditionArguments, Boolean> cond, 
			final Supplier<Query, Query> trueQuerySupplier,
			final Supplier<Query, Query> falseQuerySupplier) {
		return new IfElseQuery(this, cond, trueQuerySupplier, falseQuerySupplier);
	}
	
	@Override
	public DefaultQuery descendantsByBusinessObjectsRelativeReference(final Supplier<?, Object[]> bosSupplier) {
		return new DescendantsByBusinessObjectRelativeReferencesQuery(this, bosSupplier);
	}
	
	@Override 
	public Query descendantsByBusinessObjectsRelativeReference(final Supplier<?, Object[]> bosSupplier, final int minSegments) {
		return new DescendantsByBusinessObjectRelativeReferencesQuery(this, bosSupplier, minSegments);
	}
}
