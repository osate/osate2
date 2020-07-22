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
package org.osate.ge.palette.internal;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.osate.ge.Categories;
import org.osate.ge.internal.util.EclipseExtensionUtil;
import org.osate.ge.palette.PaletteCategory;
import org.osate.ge.palette.PaletteContributor;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;

/**
 * Instantiates extensions registered using the palette contributors extension point.
 *
 */
public class PaletteContributorRegistry {
	private static final String PALETTE_COMMANDS_EXTENSION_POINT_ID = "org.osate.ge.paletteContributors";

	private final ImmutableCollection<PaletteContributor> contributors;
	private final ImmutableList<PaletteCategory> categories;

	public PaletteContributorRegistry(final IExtensionRegistry registry) {
		this.contributors = EclipseExtensionUtil.instantiateSimpleExtensions(registry,
				PALETTE_COMMANDS_EXTENSION_POINT_ID, "contributor", PaletteContributor.class);

		// Build category list
		final ImmutableList.Builder<PaletteCategory> categoriesListBuilder = ImmutableList.builder();
		contributors.stream().flatMap(PaletteContributor::getCategories)
		.sorted((c1, c2) -> c1.getLabel().compareToIgnoreCase(c2.getLabel()))
		.forEachOrdered(categoriesListBuilder::add);
		categoriesListBuilder.add(new PaletteCategory(Categories.MISC, "Miscellaneous"));
		this.categories = categoriesListBuilder.build();
	}

	/**
	 * Returns a sorted list of palette categories.
	 * @return a sorted list of palette categories. Please the built-in miscellaneous category at the end.
	 */
	public ImmutableList<PaletteCategory> getCategories() {
		return categories;
	}

	public ImmutableCollection<PaletteContributor> getPaletteContributors() {
		return contributors;
	}
}
