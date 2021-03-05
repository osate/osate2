/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.osate.ge.internal.services.ReferenceService;
import org.osate.ge.query.QueryResult;

public class QueryRunner {
	private final ReferenceService refBuilder;

	public QueryRunner(final ReferenceService refBuilder) {
		this.refBuilder = Objects.requireNonNull(refBuilder, "refBuilder must not be null");
	}

	/**
	 * same as run() but returns the first result. Returns an empty optional if there are no results.
	 * @param query
	 * @param arg
	 * @return
	 */
	public final Optional<QueryResult> getFirstResult(final DefaultQuery query, final Object arg) {
		final List<QueryResult> results = getResults(query, arg);
		if(results.size() == 0) {
			return Optional.empty();
		}

		return Optional.of(results.get(0));
	}

	public final List<QueryResult> getResults(final DefaultQuery query, final Object arg) {
		Objects.requireNonNull(query, "query must not be null");

		final Deque<DefaultQuery> queryStack = new ArrayDeque<>();
		for(DefaultQuery q = query; q != null; q = q.getPrev()) {
			queryStack.push(q);
		}

		final DefaultQuery initialQuery = queryStack.pop();
		final QueryExecutionState state = new QueryExecutionState(this, refBuilder, arg);
		final QueryResults result = new QueryResults();
		initialQuery.run(queryStack, null, state, result);

		return result.results;
	}
}
