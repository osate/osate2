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
package org.osate.verify.internal.util;

import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.alisa.common.util.CommonUtilExtension;
import org.osate.reqspec.reqSpec.RequirementSet;
import org.osate.reqspec.reqSpec.SystemRequirementSet;
import org.osate.verify.verify.VerificationMethod;
import org.osate.verify.verify.VerificationPlan;
import org.osate.verify.verify.VerifyPackage;

/**
 * @since 4.0
 */
public class VerifyGlobalReferenceFinder implements IVerifyGlobalReferenceFinder {
	@Override
	public Iterable<VerificationPlan> getVerificationPlans(final ComponentClassifier cc, final EObject context) {
		var plans = Aadl2GlobalScopeUtil.<VerificationPlan> getAll(context, VerifyPackage.Literals.VERIFICATION_PLAN);
		return () -> StreamSupport.stream(plans.spliterator(), false)
				.filter(plan -> plan.getRequirementSet() instanceof SystemRequirementSet requirements
						&& CommonUtilExtension.isSameorExtends(cc, requirements.getTarget()))
				.iterator();
	}

	@Override
	public Iterable<VerificationPlan> getAllVerificationPlansForRequirements(final RequirementSet reqs,
			final EObject context) {
		var plans = Aadl2GlobalScopeUtil.<VerificationPlan> getAll(context, VerifyPackage.Literals.VERIFICATION_PLAN);
		return () -> StreamSupport.stream(plans.spliterator(), false)
				.filter(plan -> plan.getRequirementSet() == reqs)
				.iterator();
	}

	@Override
	public Iterable<VerificationMethod> getVerificationMethod(final String methodName, final EObject context) {
		var methods = Aadl2GlobalScopeUtil.<VerificationMethod> getAll(context,
				VerifyPackage.Literals.VERIFICATION_PLAN);
		return () -> StreamSupport.stream(methods.spliterator(), false)
				.filter(method -> methodName.equalsIgnoreCase(method.getName()))
				.iterator();
	}
}
