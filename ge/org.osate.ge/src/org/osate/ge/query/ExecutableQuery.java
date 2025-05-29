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

import java.util.List;
import java.util.Optional;
import java.util.function.UnaryOperator;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.query.DefaultQuery;
import org.osate.ge.internal.query.QueryRunner;
import org.osate.ge.internal.query.RootQuery;
import org.osate.ge.services.QueryService;

/**
 * Represents a query which can be executed by @link QueryService} to retrieve results
 * @param <T> the query parameter type
 * @noextend This class is not intended to be subclassed by clients.
 * @since 3.0
 */
public final class ExecutableQuery<T> {
	private final DefaultQuery<T> rootQuery = new RootQuery<>(() -> this.root);
	private BusinessObjectContext root;
	private final DefaultQuery<T> query;

	/**
	 * Private constructor to prevent direct instantiation.
	 * @param queryCreator the function called to create the query.
	 * @see #create(Class, UnaryOperator)
	 */
	private ExecutableQuery(final UnaryOperator<Query<T>> queryCreator) {
		this.query = (DefaultQuery<T>) queryCreator.apply(rootQuery);
	}

	/**
	 * Executes a query and returns the first result
	 * @param qr the query runner used to execute the query
	 * @param root the business object context which provides the result of the root query
	 * @param arg the query argument
	 * @return the first query result or an empty value if there are no results
	 * @noreference This method is not intended to be referenced by clients. Use {@link QueryService} to execute queries.
	 */
	public Optional<QueryResult> getFirstResult(final QueryRunner qr, final BusinessObjectContext root,
			final T arg) {
		try {
			this.root = root;
			return qr.getFirstResult(query, arg);
		} finally {
			this.root = null;
		}
	}

	/**
	 * Executes a query and returns all the results
	 * @param qr the query runner used to execute the query
	 * @param root the business object context which provides the result of the root query
	 * @param arg the query argument
	 * @return the result of executing the query
	 * @noreference This method is not intended to be referenced by clients. Use {@link QueryService} to execute queries.
	 */
	public List<QueryResult> getResults(final QueryRunner qr, final BusinessObjectContext root, final T arg) {
		try {
			this.root = root;
			return qr.getResults(query, arg);
		} finally {
			this.root = null;
		}
	}

	/**
	 * Creates an executable query by calling a function to build a query
	 * @param <T> the query parameter type
	 * @param queryCreator the function to call to create the query. Passed the root query.
	 * @return the new query
	 * @since 3.0
	 */
	public static <T> ExecutableQuery<T> create(final UnaryOperator<Query<T>> queryCreator) {
		return new ExecutableQuery<>(queryCreator);
	}
}
