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
package org.osate.reqspec.util;

import java.util.Arrays;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.NamedElement;
import org.osate.alisa.common.common.AVariableDeclaration;
import org.osate.alisa.common.util.CommonUtilExtension;
import org.osate.reqspec.reqSpec.ContractualElement;
import org.osate.reqspec.reqSpec.GlobalConstants;
import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.reqSpec.RequirementSet;
import org.osate.reqspec.reqSpec.StakeholderGoals;
import org.osate.reqspec.reqSpec.SystemRequirementSet;

public class ReqSpecUtilExtension {
	/**
	 * return the classifier of the target.
	 * The target could be an element inside a classifier. Then return its classifier.
	 * If the target is a classifier return it.
	 */
	public static ComponentClassifier targetClassifier(final ContractualElement requirement) {
		if (requirement.getTarget() != null) {
			return requirement.getTarget();
		}

		EObject container = requirement;
		while (container.eContainer() != null) {
			container = container.eContainer();
			switch (container) {
			case SystemRequirementSet requirementSet when requirementSet.getTarget() != null:
				return requirementSet.getTarget();
			case StakeholderGoals stakeholderGoals when stakeholderGoals.getTarget() != null:
				return stakeholderGoals.getTarget();
			default:
				break;
			}
		}
		return null;
	}

	public static ContractualElement containingContractualElement(final EObject object) {
		return EcoreUtil2.getContainerOfType(object, ContractualElement.class);
	}

	public static Requirement containingRequirement(final EObject object) {
		return EcoreUtil2.getContainerOfType(object, Requirement.class);
	}

	public static RequirementSet containingRequirementSet(final EObject object) {
		return EcoreUtil2.getContainerOfType(object, RequirementSet.class);
	}

	public static StakeholderGoals containingStakeholderGoals(final EObject object) {
		return EcoreUtil2.getContainerOfType(object, StakeholderGoals.class);
	}

	public static IScope scopeForGlobalVal(final EObject context, final IScope parentScope) {
		var importedGlobals = getImportedGlobals(context);
		Iterable<AVariableDeclaration> constants = () -> importedGlobals.stream()
				.flatMap(global -> global.getConstants().stream())
				.map(AVariableDeclaration.class::cast)
				.iterator();
		if (!constants.iterator().hasNext()) {
			return parentScope;
		}
		return new SimpleScope(parentScope,
				Scopes.scopedElementsFor(constants, QualifiedName.wrapper(SimpleAttributeResolver.NAME_RESOLVER)),
				true);
	}

	public static EList<GlobalConstants> getImportedGlobals(final EObject context) {
		var requirementSet = containingRequirementSet(context);
		var stakeholderGoals = containingStakeholderGoals(context);
		var result = requirementSet == null ? null : requirementSet.getImportConstants();
		return result == null && stakeholderGoals != null ? stakeholderGoals.getImportConstants() : result;
	}

	public static IScope scopeForValCompute(final Requirement requirement, final IScope parentScope) {
		return scopeForValComputeReq(requirement, scopeForValGoal(requirement, parentScope));
	}

	public static IScope scopeForValComputeReq(final Requirement requirement, final IScope parentScope) {
		var result = parentScope;
		for (var decomposedRequirement : requirement.getDecomposesReference()) {
			result = scopeForValComputeReq(decomposedRequirement, result);
		}
		for (var refinedRequirement : requirement.getRefinesReference()) {
			result = scopeForValComputeReq(refinedRequirement, result);
		}
		if (requirement.getInheritsReference() != null) {
			result = scopeForValComputeReq(requirement.getInheritsReference(), result);
		}

		var requirementSet = containingRequirementSet(requirement);
		if (requirementSet != null) {
			var declarations = concat(requirementSet.getConstants(), requirementSet.getComputes());
			result = scopeFor(declarations, result);
		}
		return scopeFor(concat(requirement.getComputes(), requirement.getConstants()), result);
	}

	/**
	 * collect val definitions from goals up the req refinement hierarchy
	 */
	public static IScope scopeForValGoal(final Requirement requirement, final IScope parentScope) {
		var result = parentScope;
		for (var refinedRequirement : requirement.getRefinesReference()) {
			result = scopeForValGoal(refinedRequirement, result);
		}
		for (var goal : requirement.getGoalReference()) {
			result = scopeForVal(goal, result);
		}
		return result;
	}

	/**
	 * collect val for goal incl. refinement & stakeholder goals container
	 */
	public static IScope scopeForVal(final Goal goal, final IScope parentScope) {
		var result = parentScope;
		for (var refinedGoal : goal.getRefinesReference()) {
			result = scopeForVal(refinedGoal, result);
		}
		var stakeholderGoals = containingStakeholderGoals(goal);
		if (stakeholderGoals != null) {
			result = scopeFor(stakeholderGoals.getConstants(), result);
		}
		return scopeFor(goal.getConstants(), result);
	}

	/**
	 * collect Val definitions in req incl. refinements & goals associated with req.
	 */
	public static IScope scopeForVal(final Requirement requirement, final IScope parentScope) {
		return scopeForValReq(requirement, scopeForValGoal(requirement, parentScope));
	}

	/**
	 * collect val definitions in req including refinement
	 */
	public static IScope scopeForValReq(final Requirement requirement, final IScope parentScope) {
		var result = parentScope;
		for (var decomposedRequirement : requirement.getDecomposesReference()) {
			result = scopeForValReq(decomposedRequirement, result);
		}
		for (var refinedRequirement : requirement.getRefinesReference()) {
			result = scopeForValReq(refinedRequirement, result);
		}
		if (requirement.getInheritsReference() != null) {
			result = scopeForValReq(requirement.getInheritsReference(), result);
		}

		var requirementSet = containingRequirementSet(requirement);
		if (requirementSet != null) {
			result = scopeFor(requirementSet.getConstants(), result);
		}
		return scopeFor(requirement.getConstants(), result);
	}

	/**
	 * collect compute variable in req including refinement
	 */
	public static IScope scopeForCompute(final Requirement requirement, final IScope parentScope) {
		return scopeForComputeReq(requirement, parentScope);
	}

	public static IScope scopeForComputeReq(final Requirement requirement, final IScope parentScope) {
		var result = parentScope;
		for (var decomposedRequirement : requirement.getDecomposesReference()) {
			result = scopeForComputeReq(decomposedRequirement, result);
		}
		for (var refinedRequirement : requirement.getRefinesReference()) {
			result = scopeForComputeReq(refinedRequirement, result);
		}
		if (requirement.getInheritsReference() != null) {
			result = scopeForComputeReq(requirement.getInheritsReference(), result);
		}

		var requirementSet = containingRequirementSet(requirement);
		if (requirementSet != null) {
			result = scopeFor(requirementSet.getComputes(), result);
		}
		return scopeFor(requirement.getComputes(), result);
	}

	public static String constructDescription(final ContractualElement requirement) {
		if (requirement.getDescription() != null) {
			return CommonUtilExtension.toText(requirement.getDescription(), getContractualElementSubject(requirement));
		}
		if (requirement.getTitle() != null) {
			return requirement.getTitle();
		}
		return "";
	}

	public static NamedElement getContractualElementSubject(final ContractualElement requirement) {
		if (requirement != null && requirement.getTargetElement() != null) {
			return requirement.getTargetElement();
		}
		return targetClassifier(requirement);
	}

	public static boolean matchingCategory(final Iterable<ComponentCategory> categories,
			final ComponentCategory category) {
		if (!categories.iterator().hasNext() || category == null) {
			return true;
		}
		return StreamSupport.stream(categories.spliterator(), false)
				.anyMatch(candidate -> candidate.getName().equalsIgnoreCase(category.getName()));
	}

	private static IScope scopeFor(final Iterable<? extends EObject> elements, final IScope parentScope) {
		return new SimpleScope(parentScope,
				Scopes.scopedElementsFor(elements, QualifiedName.wrapper(SimpleAttributeResolver.NAME_RESOLVER)),
				false);
	}

	@SafeVarargs
	private static Iterable<AVariableDeclaration> concat(final Iterable<? extends AVariableDeclaration>... sources) {
		return () -> Arrays.stream(sources)
				.flatMap(source -> StreamSupport.stream(source.spliterator(), false))
				.map(AVariableDeclaration.class::cast)
				.iterator();
	}
}
