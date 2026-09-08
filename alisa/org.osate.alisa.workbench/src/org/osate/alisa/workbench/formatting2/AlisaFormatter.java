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
package org.osate.alisa.workbench.formatting2;

import java.util.Arrays;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.XbaseGenerated;
import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.common.DescriptionElement;
import org.osate.alisa.common.formatting2.CommonFormatter;
import org.osate.alisa.workbench.alisa.AssuranceCase;
import org.osate.alisa.workbench.alisa.AssurancePlan;
import org.osate.categories.categories.CategoryFilter;

/**
 * @since 3.0
 */
public class AlisaFormatter extends CommonFormatter {
	protected void _format(final AssuranceCase assuranceCase, @Extension final IFormattableDocument document) {
		// TODO: Format hidden regions around keywords, attributes, and cross references.
		document.format(assuranceCase.getDescription());
		for (var assurancePlan : assuranceCase.getAssurancePlans()) {
			document.format(assurancePlan);
		}
		for (var categoryFilter : assuranceCase.getTasks()) {
			document.format(categoryFilter);
		}
	}

	protected void _format(final AssurancePlan assurancePlan, @Extension final IFormattableDocument document) {
		// TODO: Format hidden regions around keywords, attributes, and cross references.
		document.format(assurancePlan.getDescription());
	}

	// TODO: Implement formatting for AssuranceTask.

	@XbaseGenerated
	public void format(final Object assuranceCase, final IFormattableDocument document) {
		if (assuranceCase instanceof XtextResource) {
			_format((XtextResource) assuranceCase, document);
			return;
		} else if (assuranceCase instanceof Description) {
			_format((Description) assuranceCase, document);
			return;
		} else if (assuranceCase instanceof DescriptionElement) {
			_format((DescriptionElement) assuranceCase, document);
			return;
		} else if (assuranceCase instanceof AssuranceCase) {
			_format((AssuranceCase) assuranceCase, document);
			return;
		} else if (assuranceCase instanceof AssurancePlan) {
			_format((AssurancePlan) assuranceCase, document);
			return;
		} else if (assuranceCase instanceof EObject) {
			_format((EObject) assuranceCase, document);
			return;
		} else if (assuranceCase == null) {
			_format((Void) null, document);
			return;
		} else if (assuranceCase != null) {
			_format(assuranceCase, document);
			return;
		} else {
			throw new IllegalArgumentException(
					"Unhandled parameter types: " + Arrays.<Object> asList(assuranceCase, document).toString());
		}
	}
}
