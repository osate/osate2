/**
 * Copyright (c) 2004-2022 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.internal.diagram.runtime.filtering;

import java.util.Optional;

import org.osate.ge.ContentFilter;
import org.osate.ge.FundamentalContentFilter;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;

/**
 * Provides access to the available content filters
 *
 */
public interface ContentFilterProvider {
	/**
	 * Returns a collection containing registered {@link ContentFilter} extensions
	 * @return the collection containing registered {@link ContentFilter} extensions
	 */
	ImmutableCollection<ContentFilter> getConfigurableContentFilters();

	/**
	 * Returns a collection containing all registered {@link FundamentalContentFilter} extensions
	 * @return the collection containing all registered {@link FundamentalContentFilter} extensions
	 */
	ImmutableCollection<FundamentalContentFilter> getFundamentalContentFilters();

	/**
	 * Returns the configurable content filter with the specified ID
	 * @param id the ID of the content filter to return
	 * @return the requested content filter. If the content filter could not be found, an empty optional is returned.
	 */
	default Optional<ContentFilter> getContentFilterById(final String id) {
		for (final ContentFilter contentFilter : getConfigurableContentFilters()) {
			if (contentFilter.getId().equals(id)) {
				return Optional.of(contentFilter);
			}
		}

		return Optional.empty();
	}

	/**
	 * Returns the configurable content filters which are applicable to the specified business object
	 * @param bo the business object
	 * @return the configurable content filters which are applicable to the specified business object
	 * @see ContentFilter#isApplicable(Object)
	 */
	default ImmutableSet<ContentFilter> getApplicableContentFilters(final Object bo) {
		return getConfigurableContentFilters().stream().filter(cf -> cf.isApplicable(bo)).collect(ImmutableSet.toImmutableSet());
	}

	/**
	 * Returns true if the specified business object matches any fundamental content filter
	 * @param bo the business object to check
	 * @return true of the specified business object matches any fundamental content filter
	 * @see #getFundamentalContentFilters()
	 */
	default boolean isFundamental(final Object bo) {
		return getFundamentalContentFilters().stream().anyMatch(cf -> cf.test(bo));
	}
}
