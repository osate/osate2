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
package org.osate.ge;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Interface for objects which are part of a hierarchical structure where each node references a business object.
 *
 */
public interface BusinessObjectContext {
	/**
	 * Returns the parent of the context.
	 * @return the parent of the context. May return null.
	 */
	BusinessObjectContext getParent();

	/**
	 * The children which are available for this context.
	 * @return the context's children.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	Collection<? extends BusinessObjectContext> getChildren();

	/**
	 * Returns the business object associated with this context.
	 * @return the business object for the context.
	 */
	Object getBusinessObject();

	/**
	 * @since 2.0
	 */
	public default Stream<BusinessObjectContext> getAllDescendants() {
		return Stream.concat(Stream.of(this), getChildren().stream().flatMap(BusinessObjectContext::getAllDescendants));
	}

	/**
	 * Returns the ancestors which has a specified depth relative to this query.
	 * @param depth must be {@literal >} 0. A value of 1 returns the immediate ancestor.
	 * @return the new query
	 */
	public default BusinessObjectContext getAncestor(final int depth) {
		BusinessObjectContext e = this;
		for (int i = 0; i < depth && e != null; i++) {
			e = e.getParent();
		}

		return e;
	}

	/**
	 * Retrieves the business object contained in the business object context if it is an instance of the specified class.
	 * @param <T> is the requested type.
	 * @param c is the class to which to cast the business object.
	 * @return an optional containing the context's business object. An empty optional if the context's business object is not
	 * an instance the specified class.
	 *
	 * @since 2.0
	 */
	public default <T> Optional<T> getBusinessObject(final Class<T> c) {
		final Object bo = getBusinessObject();
		return c.isInstance(bo) ? Optional.of(c.cast(bo)) : Optional.empty();
	}

	/**
	 * @since 2.0
	 */
	static Optional<BusinessObjectContext> getFirstCommonAncestor(final BusinessObjectContext q1,
			final BusinessObjectContext q2) {
		BusinessObjectContext temp1 = q1;
		while (temp1 != null) {
			BusinessObjectContext temp2 = q2;
			while (temp2 != null) {
				if (temp1 == temp2) {
					return Optional.of(temp1);
				}
				temp2 = temp2.getParent();
			}

			temp1 = temp1.getParent();
		}

		return Optional.empty();
	}
}
