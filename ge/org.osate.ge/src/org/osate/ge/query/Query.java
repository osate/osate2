/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.query;

import java.util.function.Predicate;

import org.osate.ge.internal.query.ConditionArguments;

/**
 * <p>
 * Describes how to retrieve diagram elements from a diagram.
 * </p>
 * <p>
 * Diagrams are represented as a tree of diagram elements. Each diagram element is associated with a business object.
 * Each method of this interface returns a query whose results will be based on the results of this query.
 * </p>
 * @noextend
 * @noimplement
 */
public interface Query {
	/**
	 * Returns a query whose results contain only the first count results of this query.
	 * @param count is the maximum number of results of the resulting query.
	 * @return the new query
	 */
	Query first(int count);

	/**
	 * Returns a query whose results contain only the first result of this query.
	 * @return the new query
	 */
	Query first();

	/**
	 * Returns a query whose results are all the results of this query for which the specified filter is true.
	 * @param filter the filter which determine which results are filtered.
	 * @return the new query
	 */
	Query filter(Predicate<FilterArguments> filter);

	/**
	 * Returns a query whose results are all the results of this query for which the associated business object's relative reference
	 * matches the relative reference of the business object provided by the specified supplier.
	 * @param boSupplier the supplier of the business object to use for filtering. The supplier's argument is the query argument.
	 * @return the new query
	 */
	Query filterByBusinessObjectRelativeReference(Supplier<?, Object> boSupplier);

	/**
	 * Returns a query whose results are all the results of this query for which the associated business object's canonical reference
	 * matches the canonical reference of the business object provided by the specified supplier.
	 * @param boSupplier the supplier of the business object to use for filtering. The supplier's argument is the query argument.
	 * @return the new query
	 */
	Query filterByBusinessObjectCanonicalReference(Supplier<?, Object> boSupplier);

	/**
	 * Returns a query whose results are the children of all the results of this query.
	 * @return the new query
	 */
	Query children();

	/**
	 * Returns a query whose results are all the descendants of this query.
	 * @return the new query
	 */
	Query descendants();

	/**
	 * Returns a query whose results are all the ancestors of the results of this query which have a specified depth relative to this query.
	 * @param depth must be {@literal >} 0. A value of 1 returns the immediate ancestor.
	 * @return the new query
	 */
	Query ancestor(int depth);

	/**
	 * Returns a query whose results are all the ancestors of the results of this query.
	 * @return the new query
	 */
	Query ancestors();

	default Query parent() {
		return ancestor(1);
	}

	/**
	 * Returns a query whose results are all the common ancestors of the result of this query and the result of the specified query.
	 * Both this query and the specified query must return at most 1 result.
	 * @param q2 the query with which to find the common ancestors
	 * @return the new query
	 */
	Query commonAncestors(Query q2);

	Query ifElse(Supplier<ConditionArguments, Boolean> cond,
			final Supplier<Query, Query> trueQuerySupplier,
			final Supplier<Query, Query> falseQuerySupplier);

	Query descendantsByBusinessObjectsRelativeReference(final Supplier<?, Object[]> bosSupplier);

	Query descendantsByBusinessObjectsRelativeReference(final Supplier<?, Object[]> bosSupplier, final int minSegments);
}
