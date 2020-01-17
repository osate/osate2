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
package org.osate.ge.internal.aadlproperties;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.ReferenceValue;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;

/**
 * Contains the reference value and information regarding the start of the path relative to the Queryable with which it is association.
 *
 */
public class ReferenceValueWithContext {
	private static StandaloneQuery cneQuery = StandaloneQuery.create((rootQuery) -> rootQuery.descendantsByBusinessObjectsRelativeReference((ContainedNamedElement cne) -> getBusinessObjectsPath(cne)).first());
	private static StandaloneQuery partialCneQuery = StandaloneQuery.create((rootQuery) -> rootQuery.descendantsByBusinessObjectsRelativeReference((ContainedNamedElement cne) -> getBusinessObjectsPath(cne), 1).first());

	public final ReferenceValue referenceValue;

	/**
	 * The property association belongs to an ancestor this many levels up from the element the Queryable is associated.
	 * For example, a value of 1 indicates that the path begins at the parent of the Queryable.
	 * The first element in the reference value's path will be a sibling of the queryable.
	 */
	public final int propertyAssociationOwnerAncestorLevel;

	public ReferenceValueWithContext(final ReferenceValue referenceValue,
			final int propertyAssociationOwnerAncestorLevel) {
		this.referenceValue = referenceValue;
		this.propertyAssociationOwnerAncestorLevel = propertyAssociationOwnerAncestorLevel;
	}

	// Rename q. It is the lowest element to which the element applies.
	public AadlPropertyResolutionResults resolve(final Queryable q, final QueryService queryService) {
		// Get the queryable
		boolean referenceOwnerInTree = true;
		Queryable tmp = q;
		for(int i = 0; i < propertyAssociationOwnerAncestorLevel; i++) {
			tmp = tmp.getParent();
			if (tmp == null) {
				referenceOwnerInTree = false;
				break;
			}
		}

		// Decide whether to show it as connection or not.
		// OPTIMIZE: Don't use queries. Should be able to do this in one loop instead of requiring 2 queries.
		final boolean hasPartialDestination;
		final boolean hasFinalDestination;
		final Queryable dst;
		if(referenceOwnerInTree) {
			dst = queryService.getFirstResult(partialCneQuery, tmp, referenceValue);
			hasPartialDestination = dst != null;

			if(hasPartialDestination) {
				final Queryable referencedQueryable = queryService.getFirstResult(cneQuery, tmp, referenceValue);
				hasFinalDestination = dst == referencedQueryable && !containsArrayElementReference(referenceValue);
			} else {
				hasFinalDestination = false;
			}
		} else {
			dst = null;
			hasPartialDestination = false;
			hasFinalDestination = false;
		}

		return new AadlPropertyResolutionResults(dst, hasPartialDestination && !hasFinalDestination);
	}

	/**
	 * Gets an array of business objects which describes the logical diagram element path to a contained named element
	 * Ignores array references
	 * @param ctx
	 * @param cne
	 * @return
	 */
	private static Object[] getBusinessObjectsPath(final ContainedNamedElement cne) {
		if(cne == null) {
			return null;
		}

		final List<Object> path = new ArrayList<>();
		for(ContainmentPathElement pathElement = cne.getPath(); pathElement != null; pathElement = pathElement.getPath()) {
			path.add(pathElement.getNamedElement());
		}

		return path.toArray();
	}

	private static boolean containsArrayElementReference(final ContainedNamedElement cne) {
		if(cne == null) {
			return false;
		}

		for(ContainmentPathElement pathElement = cne.getPath(); pathElement != null; pathElement = pathElement.getPath()) {
			if(pathElement.getArrayRanges() != null && pathElement.getArrayRanges().size() > 0) {
				return true;
			}
		}

		return false;
	}
}