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
package org.osate.reqspec.ui.contentassist;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.alisa.common.util.CommonUtilExtension;
import org.osate.reqspec.reqSpec.GlobalRequirementSet;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.reqSpec.StakeholderGoals;
import org.osate.reqspec.reqSpec.SystemRequirementSet;

import com.google.common.base.Predicate;

/**
 * see http://www.eclipse.org/Xtext/documentation.html#contentAssist on how to customize content assistant
 */
public class ReqSpecProposalProvider extends AbstractReqSpecProposalProvider {
	@Override
	public void completeStakeholderGoals_Target(final EObject model, final Assignment assignment,
			final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		final Predicate<IEObjectDescription> filter = description -> !description.getEObjectURI()
				.toString()
				.contains("Plugin_Resources");
		lookupCrossReference((CrossReference) assignment.getTerminal(), context, acceptor, filter);
	}

	@Override
	public void completeSystemRequirementSet_Target(final EObject model, final Assignment assignment,
			final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		final Predicate<IEObjectDescription> filter = description -> !description.getEObjectURI()
				.toString()
				.contains("Plugin_Resources");
		lookupCrossReference((CrossReference) assignment.getTerminal(), context, acceptor, filter);
	}

	@Override
	public void completeGlobalRequirement_GoalReference(final EObject model, final Assignment assignment,
			final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		var systemRequirements = (SystemRequirementSet) model.eContainer();
		var allAncestors = getSelfPlusAncestors(systemRequirements.getTarget());
		final Predicate<IEObjectDescription> filter = description -> {
			var proposedObject = EcoreUtil.resolve(description.getEObjectOrProxy(), model);
			var stakeholderGoals = (StakeholderGoals) proposedObject.eContainer();
			return allAncestors.contains(stakeholderGoals.getTarget());
		};
		lookupCrossReference((CrossReference) assignment.getTerminal(), context, acceptor, filter);
	}

	@Override
	public void completeGlobalRequirement_RefinesReference(final EObject model, final Assignment assignment,
			final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		var target = ((SystemRequirementSet) model.eContainer()).getTarget();
		var allSystemRequirements = Aadl2GlobalScopeUtil.<SystemRequirementSet> getAll(model,
				ReqSpecPackage.eINSTANCE.getSystemRequirementSet());
		Iterable<SystemRequirementSet> accessibleSystemRequirements = () -> StreamSupport
				.stream(allSystemRequirements.spliterator(), false)
				.filter(requirements -> CommonUtilExtension.isSameorExtends(target, requirements.getTarget()))
				.iterator();

		var proposedObjects = new ArrayList<EObject>();
		final Predicate<IEObjectDescription> filter = description -> {
			var proposedObject = EcoreUtil.resolve(description.getEObjectOrProxy(), model);
			// Prefer the short description by removing duplicates that later appear with fully qualified names.
			if (proposedObjects.contains(proposedObject)) {
				return false;
			}
			proposedObjects.add(proposedObject);
			return !Objects.equals(model, proposedObject)
					&& containsRequirement(accessibleSystemRequirements, proposedObject);
		};
		lookupCrossReference((CrossReference) assignment.getTerminal(), context, acceptor, filter);
	}

	private static boolean containsRequirement(final Iterable<SystemRequirementSet> requirementSets,
			final EObject requirement) {
		var found = false;
		for (var requirementSet : requirementSets) {
			if (requirementSet.getRequirements().contains(requirement)) {
				found = true;
			}
		}
		return found;
	}

	@Override
	public void completeGlobalRequirement_DecomposesReference(final EObject model, final Assignment assignment,
			final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		completeGlobalRequirement_RefinesReference(model, assignment, context, acceptor);
	}

	@Override
	public void completeGlobalRequirement_EvolvesReference(final EObject model, final Assignment assignment,
			final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		completeGlobalRequirement_RefinesReference(model, assignment, context, acceptor);
	}

	// Brought from Aadl2JavaValidator
	public EList<Classifier> getSelfPlusAncestors(final Classifier classifier) {
		var result = new BasicInternalEList<Classifier>(Classifier.class);
		result.add(classifier);

		var current = classifier;
		while (current.getExtended() != null) {
			if (result.contains(current.getExtended())) {
				return result;
			}
			current = current.getExtended();
			result.add(current);
		}

		// If implementation collect for type
		if (classifier instanceof ComponentImplementation implementation) {
			var type = implementation.getType();
			result.add(type);
			while (type.getExtended() != null) {
				if (result.contains(type.getExtended())) {
					return result;
				}
				type = type.getExtended();
				result.add(type);
			}
		}
		return result;
	}

	@Override
	public void completeGlobalRequirement_Category(final EObject model, final Assignment assignment,
			final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		final Predicate<IEObjectDescription> filter = description -> {
			var name = description.getQualifiedName().toString();
			return ((Requirement) model).getCategory().stream().noneMatch(category -> category.getName().equals(name));
		};
		lookupCrossReference((CrossReference) assignment.getTerminal(), context, acceptor, filter);
	}

	@Override
	public void completeGoal_Category(final EObject model, final Assignment assignment,
			final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		final Predicate<IEObjectDescription> filter = description -> {
			var name = description.getQualifiedName().toString();
			return ((Requirement) model).getCategory().stream().noneMatch(category -> category.getName().equals(name));
		};
		lookupCrossReference((CrossReference) assignment.getTerminal(), context, acceptor, filter);
	}

	@Override
	public void completeIncludeGlobalRequirement_Include(final EObject model, final Assignment assignment,
			final ContentAssistContext context, final ICompletionProposalAcceptor acceptor) {
		final Predicate<IEObjectDescription> filter = description -> model instanceof GlobalRequirementSet
				|| model instanceof Requirement && model.eContainer() instanceof GlobalRequirementSet;
		lookupCrossReference((CrossReference) assignment.getTerminal(), context, acceptor, filter);
	}
}
