/**
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file).
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

/**
 * A configurable content filter defines a set of business objects which can be optionally shown on a diagram. Must be stateless.
 * Logically, a content filter defines a set of business objects which consists of the business objects which pass the filter.
 * This interface does not have Configurable in the name because it predates the concept of fundamental content filters.
 * Configurable content filters are registered using the <i>org.osate.ge.contentFilters</i> extension point.
 * @see FundamentalContentFilter
 */
public interface ContentFilter {
	/**
	 * Returns a unique identifier for the content filter.
	 * @return a unique identifier for the content filter
	 */
	String getId();

	/**
	 * Optional. If the method does not return null, it must return the ID of the content filter of which this content filter represents a part.
	 * Enabling all parts of a filter must be equivalent to enabling the filter itself.
	 * @return the ID of the parent content filter. Returns null if the content filter does not have a parent.
	 */
	default String getParentId() {
		return null;
	}

	/**
	 * Returns a user-friendly label for the content filter.
	 * @return the name of the content filter
	 */
	String getName();

	/**
	 * Returns whether the content filter can be applied to children of the specified business object.
	 * @param bo the business object which is the parent of the business objects to be tested.
	 * @return whether the content filter applicable for the given parent business object.
	 */
	boolean isApplicable(Object bo);

	/**
	 * Checks whether the specified business object matches the filter.
	 * @param bo the business object to check
	 * @return whether the business object matches the filter
	 */
	boolean test(Object bo);
}
