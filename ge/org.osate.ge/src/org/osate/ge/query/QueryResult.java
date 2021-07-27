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
package org.osate.ge.query;

import java.util.Objects;

import org.osate.ge.BusinessObjectContext;

/**
 * A value produced from executing a query. Queries are executed using {@link org.osate.ge.services.QueryService}
 * @since 2.0
 */
public class QueryResult {
	private final BusinessObjectContext boc;

	/**
	 * The value was a result of a partial match by the query.
	 */
	private final boolean partial;

	/**
	 * Create a new instance
	 * @param boc the business object context contained in this value.
	 * @param partial whether the value is a partial match by the query
	 * @noreference This constructor is not intended to be referenced by clients.
	 */
	public QueryResult(final BusinessObjectContext boc, final boolean partial) {
		this.boc = Objects.requireNonNull(boc, "boc must not be null");
		this.partial = partial;
	}

	/**
	 * Returns the business object context which matched the query.
	 * @return the business object context matching the query
	 */
	public final BusinessObjectContext getBusinessObjectContext() {
		return boc;
	}

	/**
	 * Returns the business object context's business object
	 * @return the business object context's business object
	 * @see #getBusinessObjectContext()
	 */
	public final Object getBusinessObject() {
		return boc.getBusinessObject();
	}

	/**
	 * Indicates that the query results represents a partial match.
	 * @return whether this result was created from a partial match.
	 * @see Query#descendantsByBusinessObjectsRelativeReference(java.util.function.Function, int)
	 */
	public final boolean isPartial() {
		return partial;
	}
}
