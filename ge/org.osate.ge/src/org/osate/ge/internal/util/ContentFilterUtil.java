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
package org.osate.ge.internal.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.osate.ge.ContentFilter;

import com.google.common.collect.ImmutableSet;

public class ContentFilterUtil {
	public static Stream<ContentFilter> getDescendants(final ContentFilter filter,
			final Collection<ContentFilter> applicableFilters) {
		return applicableFilters.stream().filter(t -> t.getParentId() == filter.getId())
				.flatMap(t -> Stream.concat(Stream.of(t), getDescendants(t, applicableFilters)));
	}

	public static Stream<ContentFilter> getChildren(final ContentFilter filter,
			final Collection<ContentFilter> applicableFilters) {
		return applicableFilters.stream().filter(t -> t.getParentId() == filter.getId());
	}

	/**
	 * Returns ordered stream of ancestors. Closer ancestors are earlier in the stream. For example: parents will appear before grandparents
	 * @param filter
	 * @return
	 */
	public static Stream<ContentFilter> getAncestors(final ContentFilter filter,
			final Collection<ContentFilter> applicableFilters) {
		if (filter.getParentId() == null) {
			return Stream.empty();
		}

		return applicableFilters.stream().filter(t -> t.getId() == filter.getParentId()).limit(1)
				.flatMap(t -> Stream.concat(Stream.of(t), getAncestors(t, applicableFilters)));
	}

	public static Optional<ContentFilter> getParent(final ContentFilter filter,
			final Collection<ContentFilter> applicableFilters) {
		if (filter.getParentId() == null) {
			return Optional.empty();
		}

		return applicableFilters.stream().filter(t -> t.getId() == filter.getParentId()).findFirst();
	}

	public static boolean anyDescendantsEnabled(final ContentFilter filterToCheck,
			final Collection<ContentFilter> enabledFilters, final Collection<ContentFilter> applicableFilters) {
		return getDescendants(filterToCheck, applicableFilters).anyMatch(t -> enabledFilters.contains(t));
	}

	public static boolean anyAncestorsEnabled(final ContentFilter filterToCheck,
			final Collection<ContentFilter> enabledFilters, final Collection<ContentFilter> applicableFilters) {
		return getAncestors(filterToCheck, applicableFilters).anyMatch(t -> enabledFilters.contains(t));
	}

	/**
	 * Adds or remove a content filter from the content filter set. If add is true, then the filter is added. Otherwise, it is removed. Handles combining and splitting filters when
	 * children are added or removed.
	 * @param enabledContentFilters
	 * @param applicableContentFilters
	 * @param updatedFilter
	 * @param add
	 * @return
	 */
	public static ImmutableSet<ContentFilter> updateContentFilterSet(
			final Collection<ContentFilter> enabledContentFilters,
			final Collection<ContentFilter> applicableContentFilters, final ContentFilter updatedFilter,
			final boolean add) {
		// Handle case where all the children of a filter are enabled individually. In that case, replace those filters with the parent filter.
		if (add) {
			final ContentFilter parentFilter = getParent(updatedFilter, applicableContentFilters).orElse(null);
			if (parentFilter != null) {
				if (applicableContentFilters.stream()
						.filter(tmp -> tmp.getParentId() == updatedFilter.getParentId() && tmp != updatedFilter)
						.allMatch(siblingFilter -> enabledContentFilters.contains(siblingFilter))) {
					return updateContentFilterSet(enabledContentFilters, applicableContentFilters, parentFilter, true);
				}
			}
		}

		// Create a mutable copy of the contents filters and update it based no the selection.
		final Set<ContentFilter> contentFilters = new HashSet<>(enabledContentFilters);

		// Remove descendants regardless of whether the filter is being added or removed
		ContentFilterUtil.getDescendants(updatedFilter, applicableContentFilters)
		.forEach(contentFilters::remove);

		if (add) {
			contentFilters.add(updatedFilter);
		} else {
			// Remove the filter
			contentFilters.remove(updatedFilter);

			// If disabling, then update ancestors and their siblings accordingly if any ancestors was enabled.
			if (updatedFilter.getParentId() != null) {
				final Collection<ContentFilter> applicableFilters = applicableContentFilters;

				final ContentFilter firstEnabledAncestor = ContentFilterUtil
						.getAncestors(updatedFilter, applicableFilters).filter(t -> contentFilters.contains(t))
						.findFirst().orElse(null);
				if (firstEnabledAncestor != null) {
					contentFilters.remove(firstEnabledAncestor);

					// Need to walk up from the updated filter and at each level enable all filters except for the sibling ancestor
					ContentFilter parent = ContentFilterUtil.getParent(updatedFilter, applicableFilters).get();
					for (ContentFilter tmpFilter = updatedFilter; tmpFilter != firstEnabledAncestor; tmpFilter = parent) {
						parent = ContentFilterUtil.getParent(tmpFilter, applicableFilters).orElse(null);
						if (parent != null) {
							final ContentFilter finalPrev = tmpFilter;
							ContentFilterUtil.getChildren(parent, applicableFilters).filter(t -> t != finalPrev)
							.forEach(contentFilters::add);
						}
					}
				}
			}
		}

		// Update the content filters
		return ImmutableSet.copyOf(contentFilters);
	}

	/**
	 * Returns true if the specified BO passes any of the specified content filters
	 * @param bo the bo to test
	 * @param contentFilters the content filters to test with
	 */
	public static boolean passesAnyContentFilter(final Object bo, final ImmutableSet<ContentFilter> contentFilters) {
		for (final ContentFilter filter : contentFilters) {
			if (filter.test(bo)) {
				return true;
			}
		}
		return false;
	}

}
