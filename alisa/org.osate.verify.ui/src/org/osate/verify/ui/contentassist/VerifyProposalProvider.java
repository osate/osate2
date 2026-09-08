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
package org.osate.verify.ui.contentassist;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.osate.categories.categories.Category;
import org.osate.reqspec.reqSpec.RequirementSet;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationMethod;
import org.osate.verify.verify.VerificationPlan;

import com.google.common.base.Predicate;

/**
 * see http://www.eclipse.org/Xtext/documentation.html#contentAssist on how to customize content assistant
 */
public class VerifyProposalProvider extends AbstractVerifyProposalProvider {
	@Override
	public void completeClaim_Requirement(final EObject model, final Assignment assignment,
			final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		// Filter the scope to requirements in the verification plan's system requirement set.
		final RequirementSet forSystemRequirements = ((VerificationPlan) model.eContainer()).getRequirementSet();
		var nameList = new ArrayList<EObject>();
		final Predicate<IEObjectDescription> filter = description -> {
			var proposedObject = EcoreUtil.resolve(description.getEObjectOrProxy(), model);
			// Prefer the short description by removing duplicates that later appear with fully qualified names.
			return nameList.add(proposedObject) && forSystemRequirements.getRequirements().contains(proposedObject);
		};
		// The scope already ensures that all valid requirements are included without a trailing model-reference period.
		lookupCrossReference((CrossReference) assignment.getTerminal(), context, acceptor, filter);
	}

	@Override
	public void completeVerificationMethod_Category(final EObject model, final Assignment assignment,
			final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		final Predicate<IEObjectDescription> filter = description -> ((VerificationMethod) model).getCategory()
				.stream()
				.noneMatch(category -> category.getName().equals(description.getQualifiedName().toString()));
		lookupCrossReference((CrossReference) assignment.getTerminal(), context, acceptor, filter);
	}

	@Override
	public void completeVerificationActivity_Category(final EObject model, final Assignment assignment,
			final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		final Predicate<IEObjectDescription> filter = description -> ((VerificationActivity) model).getCategory()
				.stream()
				.noneMatch(category -> category.getName().equals(description.getQualifiedName().toString()));
		lookupCrossReference((CrossReference) assignment.getTerminal(), context, acceptor, filter);
	}

	@Override
	public void completeVerificationMethod_Properties(final EObject model, final Assignment assignment,
			final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		lookupCrossReference((CrossReference) assignment.getTerminal(), context, acceptor, predeclaredFilter);
	}
}
