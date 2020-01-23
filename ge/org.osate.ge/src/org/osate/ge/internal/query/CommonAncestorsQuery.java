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
import java.util.List;
import java.util.Objects;
import java.util.Optional;

class CommonAncestorsQuery extends DefaultQuery {
	private final DefaultQuery q1;
	private final DefaultQuery q2;

	public CommonAncestorsQuery(final DefaultQuery q1, final DefaultQuery q2) {
		super(null);
		this.q1 = Objects.requireNonNull(q1, "q1 must not be null");
		this.q2 = Objects.requireNonNull(q2, "q2 must not be null");
	}

	@Override
	void run(final Deque<DefaultQuery> remainingQueries, final Queryable ctx, final QueryExecutionState state, final QueryResult result) {
		final List<Queryable> q1Result = state.queryRunner.getResults(q1, state.arg);
		final List<Queryable> q2Result = state.queryRunner.getResults(q2, state.arg);

		// Check sizes
		if(q1Result.size() == 0 || q2Result.size() == 0) {
			return;
		}

		if(q1Result.size() > 1) {
			throw new RuntimeException("q1 returns more than one element");
		}

		if(q2Result.size() > 1) {
			throw new RuntimeException("q2 returns more than one element");
		}

		final Optional<Queryable> commonAncestor = Queryable.getFirstCommonAncestor(q1Result.get(0).getParent(),
				q2Result.get(0).getParent());
		if (commonAncestor.isPresent()) {
			// Process common ancestors
			for (Queryable tmp = commonAncestor.get(); tmp != null && !result.done; tmp = tmp.getParent()) {
				processResultValue(remainingQueries, tmp, state, result);
			}
		}
	}
}
