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
package org.osate.alisa.workbench.ui.quickfix;

import java.util.ArrayList;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.osate.alisa.workbench.alisa.AssurancePlan;
import org.osate.alisa.workbench.validation.AlisaValidator;
import org.osate.verify.verify.VerificationPlan;

/**
 * Custom quickfixes.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#quickfixes
 */
public class AlisaQuickfixProvider extends DefaultQuickfixProvider {
	/**
	 * QuickFix for missing assureOwn
	 * The issue data array is expected to have multiple data elements:
	 * issue.getData()[Even]: The name of a missing verification plan
	 * issue.getData()[Odd]: The URI of the missing verification plan named prior
	 */
	@Fix(AlisaValidator.ASSURANCE_PLAN_OWN_MISSING_VERIFICATION_PLANS)
	public void fixMissingOwnVerificationPlans(final Issue issue, final IssueResolutionAcceptor acceptor) {
		var planNames = new ArrayList<String>();
		for (var index = 0; index < issue.getData().length; index += 2) {
			planNames.add(issue.getData()[index]);
		}
		final String names = "'" + String.join("', '", planNames) + "'";
		acceptor.accept(issue, (("Add verification plans " + names) + " to \'assure\'"), null, null,
				new ISemanticModification() {
					@Override
					public void apply(final EObject element, final IModificationContext context) throws Exception {
						final AssurancePlan assurancePlan = ((AssurancePlan) element);
						final ResourceSet resourceSet = element.eResource().getResourceSet();
						for (var index = 1; index < issue.getData().length; index += 2) {
							var verificationPlan = (VerificationPlan) resourceSet
									.getEObject(URI.createURI(issue.getData()[index]), true);
							assurancePlan.getAssure().add(verificationPlan);
						}
					}
				});
	}

	/**
	 * QuickFix for invalid verification plans in assureOwn
	 * The issue data array is expected to have multiple data elements:
	 * issue.getData()[Even]: The name of a invalid verification plan
	 * issue.getData()[Odd]: The URI of the invlaid verification plan named prior
	 */
	@Fix(AlisaValidator.ASSURANCE_PLAN_OWN_INVALID_VERIFICATION_PLANS)
	public void fixInvalidOwnVerificationPlans(final Issue issue, final IssueResolutionAcceptor acceptor) {
		final String name = issue.getData().length == 0 ? null : issue.getData()[0];
		final String vpUri = issue.getData()[1];
		acceptor.accept(issue, (("Remove verification plan \'" + name) + "\' from \'assure\'"), null, null,
				new ISemanticModification() {
					@Override
					public void apply(final EObject element, final IModificationContext context) throws Exception {
						final AssurancePlan assurancePlan = ((AssurancePlan) element);
						final ResourceSet resourceSet = element.eResource().getResourceSet();
						var verificationPlan = (VerificationPlan) resourceSet.getEObject(URI.createURI(vpUri), true);
						assurancePlan.getAssure().remove(verificationPlan);
					}
				});
	}
}
