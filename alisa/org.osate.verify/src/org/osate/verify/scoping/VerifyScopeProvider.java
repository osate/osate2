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
package org.osate.verify.scoping;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.NamedElement;
import org.osate.alisa.common.common.AVariableReference;
import org.osate.alisa.common.scoping.CommonScopeProvider;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.reqSpec.RequirementSet;
import org.osate.reqspec.reqSpec.SystemRequirementSet;
import org.osate.reqspec.util.ReqSpecUtilExtension;
import org.osate.verify.internal.util.VerifyUtilExtension;
import org.osate.verify.verify.Claim;
import org.osate.verify.verify.FormalParameter;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationMethod;

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation.html#scoping
 * on how and when to use it
 */
public class VerifyScopeProvider extends CommonScopeProvider {
	public IScope scope_ValDeclaration(final VerificationActivity context, final EReference reference) {
		final Claim claim = VerifyUtilExtension.getContainingClaim(context);
		Requirement req = claim.getRequirement();
		final IScope result = ReqSpecUtilExtension.scopeForGlobalVal(req, IScope.NULLSCOPE);
		return ReqSpecUtilExtension.scopeForVal(req, result);
	}

	public IScope scope_AVariableReference_variable(final AVariableReference context, final EReference reference) {
		final Claim claim = VerifyUtilExtension.getContainingClaim(context);
		Requirement req = claim.getRequirement();
		final IScope result1 = ReqSpecUtilExtension.scopeForGlobalVal(req, IScope.NULLSCOPE);
		final IScope result2 = ReqSpecUtilExtension.scopeForCompute(req, result1);
		return ReqSpecUtilExtension.scopeForVal(req, result2);
	}

	public IScope scope_ComputeDeclaration(final VerificationActivity context, final EReference reference) {
		final Claim claim = VerifyUtilExtension.getContainingClaim(context);
		Requirement req = claim.getRequirement();
		final IScope result = IScope.NULLSCOPE;
		return ReqSpecUtilExtension.scopeForCompute(req, result);
	}

	public IScope scope_Claim_requirement(final Claim context, final EReference reference) {
		IScope result = this.delegateGetScope(context, reference);
		final RequirementSet forSystemRequirements = VerifyUtilExtension.containingVerificationPlan(context)
				.getRequirementSet();
		if (!forSystemRequirements.getRequirements().isEmpty()) {
			var descriptions = Scopes.<EObject> scopedElementsFor(forSystemRequirements.getRequirements(),
					QualifiedName.<EObject> wrapper(SimpleAttributeResolver.NAME_RESOLVER));
			result = new SimpleScope(result, descriptions, false);
		}
		return result;
	}

	public SimpleScope scope_VerificationActivity(final EObject context, final EReference reference) {
		var activities = VerifyUtilExtension.getContainingClaim(context).getActivities();
		var descriptions = Scopes.<EObject> scopedElementsFor(activities,
				QualifiedName.<EObject> wrapper(SimpleAttributeResolver.NAME_RESOLVER));
		return new SimpleScope(IScope.NULLSCOPE, descriptions, false);
	}

	public SimpleScope scope_FormalParameter(final EObject context, final EReference reference) {
		var method = VerifyUtilExtension.getContainingVerificationMethod(context);
		var parameters = method == null ? null : method.getFormals();
		var descriptions = Scopes.<EObject> scopedElementsFor(parameters,
				QualifiedName.<EObject> wrapper(SimpleAttributeResolver.NAME_RESOLVER));
		return new SimpleScope(IScope.NULLSCOPE, descriptions, false);
	}

	@Override
	public IScope scope_AModelReference_modelElement(final EObject context, final EReference reference) {
		var requirement = ((Claim) context.eContainer()).getRequirement();
		NamedElement target = requirement == null ? null : requirement.getTargetElement();
		if (target == null && requirement != null) {
			target = requirement.getTarget();
		}
		if (target == null) {
			target = EcoreUtil2.getContainerOfType(requirement, SystemRequirementSet.class).getTarget();
		}
		return new SimpleScope(List.of(EObjectDescription.create("this", target)));
	}
}
