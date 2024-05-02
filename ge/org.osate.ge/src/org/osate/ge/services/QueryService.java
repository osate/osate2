/**
 * Copyright (c) 2004-2024 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.services;

import java.util.List;
import java.util.Optional;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.query.ExecutableQuery;
import org.osate.ge.query.QueryResult;

/**
 * Editor service for executing {@link ExecutableQuery}
 *
 */
public interface QueryService {
	/**
	 * Executes a query and returns the business object from the first result.
	 * @param <T> the type of argument parameter
	 * @param query the query to execute
	 * @param boc the business object context which provides the result of the root query
	 * @param arg the query argument
	 * @return an optional containing the business object of the first returned result. An empty optional is returned if a result is not found.
	 * @since 3.0
	 */
	default <T> Optional<Object> getFirstBusinessObject(final ExecutableQuery<T> query, final BusinessObjectContext boc,
			final T arg) {
		return getFirstResult(query, boc, arg).map(result -> result.getBusinessObjectContext().getBusinessObject());
	}

	/**
	 * Executes a query and returns the business object context from the first result.
	 * @param <T> the type of argument parameter
	 * @param query the query to execute
	 * @param boc the business object context which provides the result of the root query
	 * @param arg the query argument
	 * @return the business object context from the first result. Returns null if a business object context is not available.
	 * @since 3.0
	 */
	default <T> BusinessObjectContext getFirstBusinessObjectContextOrNull(final ExecutableQuery<T> query,
			final BusinessObjectContext boc, final T arg) {
		final QueryResult value = getFirstResult(query, boc, arg).orElse(null);
		return value == null ? null : value.getBusinessObjectContext();
	}

	/**
	 * Executes a query and returns the first result.
	 * @param <T> the type of argument parameter
	 * @param query the query to execute
	 * @param boc the business object context which provides the result of the root query
	 * @param arg the query argument
	 * @return an optional containing the first result. Returns an empty optional if a result is not returned.
	 * @since 3.0
	 */
	<T> Optional<QueryResult> getFirstResult(ExecutableQuery<T> query, BusinessObjectContext boc, final T arg);

	/**
	 * Executes a query and returns all the results.
	 * @param <T> the type of argument parameter
	 * @param query the query to execute
	 * @param boc the business object context which provides the result of the root query
	 * @param arg the query argument
	 * @return the results of executing the query.
	 * @since 3.0
	 */
	<T> List<QueryResult> getResults(ExecutableQuery<T> query, BusinessObjectContext boc, final T arg);
}
