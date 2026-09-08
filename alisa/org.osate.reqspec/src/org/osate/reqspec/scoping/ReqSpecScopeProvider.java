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
package org.osate.reqspec.scoping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.alisa.common.common.AVariableReference;
import org.osate.alisa.common.scoping.CommonScopeProvider;
import org.osate.alisa.common.util.CommonUtilExtension;
import org.osate.reqspec.reqSpec.ContractualElement;
import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.reqSpec.StakeholderGoals;
import org.osate.reqspec.reqSpec.SystemRequirementSet;
import org.osate.reqspec.reqSpec.WhenCondition;
import org.osate.reqspec.util.ReqSpecUtilExtension;
import org.osate.xtext.aadl2.errormodel.scoping.ErrorModelScopeProvider;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation.html#scoping
 * on how and when to use it
 */
public class ReqSpecScopeProvider extends CommonScopeProvider {
	public IScope scope_ContractualElement_targetElement(final ContractualElement context, final EReference reference) {
		var target = ReqSpecUtilExtension.targetClassifier(context);
		return switch (target) {
		case ComponentType type -> {
			var elements = concat(type.getAllFeatures(), type.getAllFlowSpecifications(), type.getAllModes());
			yield new SimpleScope(IScope.NULLSCOPE, descriptionsFor(elements), true);
		}
		case ComponentImplementation implementation -> {
			var elements = concat(implementation.getAllFeatures(), implementation.getType().getAllFlowSpecifications(),
					implementation.getAllModes(), implementation.getAllSubcomponents(),
					implementation.getAllEndToEndFlows(), implementation.getAllConnections());
			yield new SimpleScope(IScope.NULLSCOPE, descriptionsFor(elements), true);
		}
		case null, default -> IScope.NULLSCOPE;
		};
	}

	public IScope scope_Mode(final WhenCondition context, final EReference reference) {
		var target = ReqSpecUtilExtension.targetClassifier(ReqSpecUtilExtension.containingRequirement(context));
		if (target instanceof ComponentType type) {
			return new SimpleScope(IScope.NULLSCOPE, descriptionsFor(type.getAllModes()), true);
		}
		return IScope.NULLSCOPE;
	}

	public IScope scope_ErrorBehaviorState(final WhenCondition context, final EReference reference) {
		var target = ReqSpecUtilExtension.targetClassifier(ReqSpecUtilExtension.containingRequirement(context));
		if (target == null) {
			return IScope.NULLSCOPE;
		}
		var states = EMV2Util.getAllErrorBehaviorStates(target);
		return new SimpleScope(IScope.NULLSCOPE, descriptionsFor(states), true);
	}

//	Offer property definitions via scope. Here we can add filter to allow only those properties that actually apply to the target object
//	public IScope scope_Property(PropertyConsistentVariableDeclaration context, EReference reference) {
//		var props = ((CommonGlobalScopeProvider) scopeProvider).getGlobalEObjectDescriptions(context,
//				Aadl2Package.eINSTANCE.getProperty(), null);
//		return new SimpleScope(IScope.NULLSCOPE, props, true);
//	}
	public IScope scope_AVariableDeclaration(final AVariableReference context, final EReference reference) {
		var result = ReqSpecUtilExtension.scopeForGlobalVal(context, IScope.NULLSCOPE);
		var contract = ReqSpecUtilExtension.containingContractualElement(context);
		return switch (contract) {
		case Requirement requirement -> ReqSpecUtilExtension.scopeForValCompute(requirement, result);
		case Goal goal -> ReqSpecUtilExtension.scopeForVal(goal, result);
		case null, default -> null;
		};
	}

	public IScope scope_AVariableDeclaration(final Requirement context, final EReference reference) {
		var result = ReqSpecUtilExtension.scopeForGlobalVal(context, IScope.NULLSCOPE);
		return ReqSpecUtilExtension.scopeForValCompute(context, result);
	}

	public IScope scope_AVariableDeclaration(final Goal context, final EReference reference) {
		var result = ReqSpecUtilExtension.scopeForGlobalVal(context, IScope.NULLSCOPE);
		return ReqSpecUtilExtension.scopeForVal(context, result);
	}

	// TODO: probably want validation to take care of Refining itself. Need to take care of inheritance
	public IScope scope_Requirement_refinesReference(final Requirement context, final EReference reference) {
		// Use delegate to get other scopes including the global scope.
		var result = delegateGetScope(context, reference);
		var requirementSet = ReqSpecUtilExtension.containingRequirementSet(context);
		if (requirementSet instanceof SystemRequirementSet systemRequirements) {
			var target = systemRequirements.getTarget();
			var allSystemRequirements = Aadl2GlobalScopeUtil.<SystemRequirementSet> getAll(context,
					ReqSpecPackage.eINSTANCE.getSystemRequirementSet());
			Iterable<SystemRequirementSet> accessibleSystemRequirements = () -> StreamSupport
					.stream(allSystemRequirements.spliterator(), false)
					.filter(requirements -> CommonUtilExtension.isSameorExtends(target, requirements.getTarget()))
					.iterator();
			// TODO sort in extends hierarchy order
			for (var accessibleSystemRequirement : accessibleSystemRequirements) {
				if (!accessibleSystemRequirement.getRequirements().isEmpty()) {
					result = new SimpleScope(result, descriptionsFor(accessibleSystemRequirement.getRequirements()),
							true);
				}
			}
		}
		return result;
	}

	public IScope scope_Requirement_decomposesReference(final Requirement context, final EReference reference) {
		return scope_Requirement_refinesReference(context, reference);
	}

	public IScope scope_Requirement_evolvesReference(final Requirement context, final EReference reference) {
		return scope_Requirement_refinesReference(context, reference);
	}

	public IScope scope_Requirement_inheritsReference(final Requirement context, final EReference reference) {
		return scope_Requirement_refinesReference(context, reference);
	}

	public IScope scope_Requirement_exception(final Requirement context, final EReference reference) {
		var target = ReqSpecUtilExtension.targetClassifier(context);
		if (target == null) {
			return IScope.NULLSCOPE;
		}
		var exceptionItems = concat(EMV2Util.getAllErrorSources(target), EMV2Util.getAllErrorPaths(target));
		var propagationScope = ErrorModelScopeProvider.scopeForErrorPropagation(target, DirectionType.OUT);
		return new SimpleScope(propagationScope, descriptionsFor(exceptionItems), true);
	}

	@Override
	public IScope scope_AModelReference_modelElement(final EObject context, final EReference reference) {
		var contractualElement = EcoreUtil2.getContainerOfType(context, ContractualElement.class);
		NamedElement target = contractualElement == null ? null : contractualElement.getTargetElement();
		if (target == null && contractualElement != null) {
			target = contractualElement.getTarget();
		}
		if (target == null) {
			var stakeholderGoals = EcoreUtil2.getContainerOfType(context, StakeholderGoals.class);
			target = stakeholderGoals == null ? null : stakeholderGoals.getTarget();
		}
		if (target == null) {
			target = EcoreUtil2.getContainerOfType(context, SystemRequirementSet.class).getTarget();
		}
		return new SimpleScope(List.of(EObjectDescription.create("this", target)));
	}

	// Brought from Aadl2JavaValidator
	public EList<ComponentClassifier> getSelfPlusAncestors(final ComponentClassifier classifier) {
		var result = new BasicInternalEList<ComponentClassifier>(ComponentClassifier.class);
		result.add(classifier);

		var current = classifier;
		while (current.getExtended() != null) {
			if (result.contains(current.getExtended())) {
				return result;
			}
			current = (ComponentClassifier) current.getExtended();
			result.add(current);
		}

		// If implementation collect for type
		if (classifier instanceof ComponentImplementation implementation) {
			current = implementation.getType();
			result.add(current);
			while (current.getExtended() != null) {
				if (result.contains(current.getExtended())) {
					return result;
				}
				current = (ComponentClassifier) current.getExtended();
				result.add(current);
			}
		}
		return result;
	}

	@SafeVarargs
	private static Iterable<EObject> concat(final Iterable<? extends EObject>... sources) {
		return () -> Arrays.stream(sources)
				.flatMap(source -> StreamSupport.stream(source.spliterator(), false))
				.map(EObject.class::cast)
				.iterator();
	}

	private static Iterable<IEObjectDescription> descriptionsFor(final Iterable<? extends EObject> elements) {
		return Scopes.scopedElementsFor(elements, QualifiedName.wrapper(SimpleAttributeResolver.NAME_RESOLVER));
	}
}
