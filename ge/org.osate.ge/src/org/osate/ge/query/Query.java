/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.query;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.query.ConditionArguments;

/**
 * <p>
 * Describes how to retrieve {@link BusinessObjectContext} from a {@link BusinessObjectContext} tree.
 * </p>
 * <p>
 * Each method of this interface returns a new query based on this query.
 * </p>
 * @param <T> the query parameter type
 * @noextend
 * @noimplement
 */
public interface Query<T> {
	/**
	 * Returns a query whose results contain only the first count results of this query.
	 * @param count is the maximum number of results of the resulting query.
	 * @return the new query
	 */
	Query<T> first(int count);

	/**
	 * Returns a query whose results contain only the first result of this query.
	 * @return the new query
	 */
	Query<T> first();

	/**
	 * Returns a query whose results are all the results of this query for which the specified filter is true.
	 * @param filter the filter which determine which results are filtered.
	 * @return the new query
	 */
	Query<T> filter(Predicate<FilterArguments<T>> filter);

	/**
	 * Returns a query whose results are all the results of this query for which the associated business object's relative reference
	 * matches the relative reference of the business object provided by the specified supplier.
	 * @param boSupplier a function which is passed the query argument and returns the business object whose relative reference is used for filtering.
	 * @return the new query
	 * @since 3.0
	 */
	Query<T> filterByBusinessObjectRelativeReference(Function<T, Object> boSupplier);

	/**
	 * Returns a query whose results are all the results of this query for which the associated business object's canonical reference
	 * matches the canonical reference of the business object provided by the specified supplier.
	 * @param boSupplier a function which is passed the query argument and returns the business object whose canonical reference is used for filtering.
	 * @return the new query
	 * @since 3.0
	 */
	Query<T> filterByBusinessObjectCanonicalReference(Function<T, Object> boSupplier);

	/**
	 * Returns a query whose results are the children of all the results of this query.
	 * @return the new query
	 */
	Query<T> children();

	/**
	 * Returns a query whose results are all the descendants of this query.
	 * @return the new query
	 */
	Query<T> descendants();

	/**
	 * Returns a query whose results are all the ancestors of the results of this query which have a specified depth relative to this query.
	 * @param depth must be {@literal >} 0. A value of 1 returns the immediate ancestor.
	 * @return the new query
	 */
	Query<T> ancestor(int depth);

	/**
	 * Returns a query whose results are all the ancestors of the results of this query.
	 * @return the new query
	 */
	Query<T> ancestors();

	/**
	 * Returns a query whose results are the direct parent of the results of this query.
	 * @return the new query.
	 */
	default Query<T> parent() {
		return ancestor(1);
	}

	/**
	 * Returns a query whose results are all the common ancestors of the result of this query and the result of the specified query.
	 * Both this query and the specified query must return at most 1 result.
	 * @param q2 the query with which to find the common ancestors
	 * @return the new query
	 */
	Query<T> commonAncestors(Query<T> q2);

	/**
	 * Returns a query whose results are the results of one of two queries. The query used is dependent on a boolean condition.
	 * @param cond a function which returns a boolean which determines the query to use.
	 * @param trueQuerySupplier is used when the condition returns true.
	 * @param falseQuerySupplier is used when the condition returns false.
	 * @return the new query
	 * @since 3.0
	 */
	Query<T> ifElse(Function<ConditionArguments<T>, Boolean> cond, final UnaryOperator<Query<T>> trueQuerySupplier,
			final UnaryOperator<Query<T>> falseQuerySupplier);

	/**
	 * A version of {@link #descendantsByBusinessObjectsRelativeReference(Function, int)} which requires that results match the entire path.
	 * See {@link #descendantsByBusinessObjectsRelativeReference(Function, int)}
	 * @param bosSupplier see {@link #descendantsByBusinessObjectsRelativeReference(Function, int)}
	 * @return the new query
	 * @see #descendantsByBusinessObjectsRelativeReference(Function, int)
	 * @since 3.0
	 */
	Query<T> descendantsByBusinessObjectsRelativeReference(final Function<T, Object[]> bosSupplier);

	/**
	 * Returns a query whose results are all the results which can be found match traversing a specified path from the
	 * results of this query. The path is determined by the relative references of a the supplied business object array.
	 * For example: an array of [Classifier A, Subcomponent B] would look for child with the business object Classifier A and then a grandchild
	 * with the business object Subcomponent B. The query will return all results that match the first {@code minSegments} number of segments.
	 * @param bosSupplier a function which is passed the query argument and returned an array of business objects which specify the path.
	 * @param minSegments if greater than 0, then all results which match at least the first {@code minSegments} number of business objects will be returned. {@link QueryResult#isPartial()} will
	 * return true for all results which do not match all supplied business objects.
	 * @return the new query
	 * @since 3.0
	 */
	Query<T> descendantsByBusinessObjectsRelativeReference(final Function<T, Object[]> bosSupplier,
			final int minSegments);
}
