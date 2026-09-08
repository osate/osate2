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
package org.osate.alisa.workbench.validation;

import java.util.stream.StreamSupport;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.alisa.common.util.CommonUtilExtension;
import org.osate.alisa.workbench.alisa.AlisaPackage;
import org.osate.alisa.workbench.alisa.AssuranceCase;
import org.osate.alisa.workbench.alisa.AssurancePlan;
import org.osate.alisa.workbench.util.AlisaWorkbenchUtilExtension;
import org.osate.verify.internal.util.IVerifyGlobalReferenceFinder;
import org.osate.verify.internal.util.VerifyUtilExtension;

import com.google.inject.Inject;

/**
 * Custom validation rules.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
public class AlisaValidator extends AbstractAlisaValidator {
	public static final String ASSURANCE_PLAN_OWN_MISSING_VERIFICATION_PLANS = "org.osate.alisa.workbench.validation.assurance.plan.own.missing.verification.plans";
	public static final String ASSURANCE_PLAN_OWN_INVALID_VERIFICATION_PLANS = "org.osate.alisa.workbench.validation.assurance.plan.own.invalid.verification.plans";
	public static final String ASSURANCE_PLAN_TARGET_INCORRECT = "org.osate.alisa.workbench.validation.assurance.plan.target.incorrect";
	@Inject
	private IVerifyGlobalReferenceFinder referenceFinder;

	@Check(CheckType.NORMAL)
	public void checkAssurancePlanNormal(final AssurancePlan assurancePlan) {
		this.checkAssurancePlanOwnOmissions(assurancePlan);
	}

	@Check(CheckType.NORMAL)
	public void checkAssurancePlanFast(final AssurancePlan assurancePlan) {
		// Needs further work: this can report a false error and does not yet handle global requirements.
		this.checkConsistentAssurancePlanTarget(assurancePlan);
		this.checkModelPlanOwnForInvalid(assurancePlan);
	}

	public void checkAssurancePlanOwnOmissions(final AssurancePlan assurancePlan) {
		var missingPlans = StreamSupport
				.stream(referenceFinder.getVerificationPlans(assurancePlan.getTarget(), assurancePlan).spliterator(),
						false)
				.filter(plan -> !assurancePlan.getAssure().contains(plan))
				.toList();
		var count = missingPlans.size();
		if (count > 0) {
			final String[] namesAndURI = new String[count * 2];
			var index = 0;
			for (var plan : missingPlans) {
				namesAndURI[index * 2] = plan.getName();
				namesAndURI[index * 2 + 1] = EcoreUtil.getURI(plan).toString();
				index++;
			}
			warning("Assurance Plan '" + assurancePlan.getName()
					+ "' missing Verification Plans in 'assure' statement '", assurancePlan,
					AlisaPackage.Literals.ASSURANCE_PLAN__NAME,
					AlisaValidator.ASSURANCE_PLAN_OWN_MISSING_VERIFICATION_PLANS, namesAndURI);
		}
	}

	public void checkModelPlanOwnForInvalid(final AssurancePlan assurancePlan) {
		final ComponentImplementation assTarget = assurancePlan.getTarget();
		for (var vp : assurancePlan.getAssure()) {
			if (!CommonUtilExtension.isSameorExtends(assTarget, VerifyUtilExtension.getTargetClassifier(vp))) {
				final int idx = assurancePlan.getAssure().indexOf(vp);
				error("Verification Plan '" + vp.getName() + "' for '"
						+ VerifyUtilExtension.getTargetClassifier(vp).getName() + "' is not valid for Assurance Plan '"
						+ assurancePlan.getName() + "' with target '" + assTarget.getName() + "'", assurancePlan,
						AlisaPackage.Literals.ASSURANCE_PLAN__ASSURE, idx,
						AlisaValidator.ASSURANCE_PLAN_OWN_INVALID_VERIFICATION_PLANS, vp.getName(),
						EcoreUtil.getURI(vp).toString());
			}
		}
	}

	public void checkConsistentAssurancePlanTarget(final AssurancePlan assurancePlan) {
		final ComponentImplementation assTarget = assurancePlan.getTarget();
		final AssuranceCase assCase = AlisaWorkbenchUtilExtension.getAssuranceCase(assurancePlan);
		final ComponentType caseTarget = assCase.getSystem();
		if (!CommonUtilExtension.isSameorExtends(assTarget, caseTarget)) {
			error("Assurance Plan '" + assurancePlan.getName() + "' for '" + assTarget.getName()
					+ "' is not valid for Assurance Case '" + assCase.getName() + "' with target '"
					+ caseTarget.getName() + "'", assurancePlan, AlisaPackage.Literals.ASSURANCE_PLAN__TARGET,
					AlisaValidator.ASSURANCE_PLAN_TARGET_INCORRECT, assurancePlan.getName(),
					EcoreUtil.getURI(assurancePlan).toString());
		}
	}
}
