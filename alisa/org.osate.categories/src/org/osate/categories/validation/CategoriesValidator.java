/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.categories.validation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.osate.categories.categories.Categories;
import org.osate.categories.categories.CategoriesDefinitions;
import org.osate.categories.categories.CategoryFilter;

/**
 * Custom validation rules.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
public class CategoriesValidator extends AbstractCategoriesValidator {
	public static final String CAT_FILE_EXT = "cat";
	public static final String FILTER_FILE_EXT = "filter";
	public static final String DUPLICATE_CATEGORY = "org.osate.categories.validation.duplicate.category";

	@Check(CheckType.FAST)
	public void checkFileTypeContents(final CategoriesDefinitions categoriesDefinitions) {
		final URI categoriesDefinitionURI = EcoreUtil.getURI(categoriesDefinitions);
		final String fileExt = categoriesDefinitionURI.fileExtension().toLowerCase();
		if (fileExt != null) {
			switch (fileExt) {
			case CategoriesValidator.CAT_FILE_EXT:
				categoriesDefinitions.getCategoryFilters().forEach(part -> fileTypeWarning(fileExt, "filter", part));
				break;
			case CategoriesValidator.FILTER_FILE_EXT:
				categoriesDefinitions.getCategories().forEach(part -> fileTypeWarning(fileExt, "category", part));
				break;
			default:
				break;
			}
		} else {
		}
	}

	public void fileTypeWarning(final String fileType, final String partName, final EObject part) {
		warning(partName + " not allowed in '" + fileType + "' file.", part, null);
	}
}
