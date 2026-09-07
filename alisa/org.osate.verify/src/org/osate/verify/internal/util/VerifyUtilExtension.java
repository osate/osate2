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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.categories.categories.CategoryFilter;
import org.osate.categories.util.CategoriesUtil;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.reqSpec.RequirementSet;
import org.osate.reqspec.reqSpec.SystemRequirementSet;
import org.osate.result.AnalysisResult;
import org.osate.verify.verify.Claim;
import org.osate.verify.verify.ElseExpr;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationMethod;
import org.osate.verify.verify.VerificationPlan;

/**
 * @since 4.0
 */
public class VerifyUtilExtension {
	private static final Map<String, Set<String>> hasRunRecord = new HashMap<>();
	private static final Map<String, URI> analysisResultRecord = new HashMap<>();

	public static boolean getHasRun(final String analysisID, final EObject target) {
		var values = hasRunRecord.get(analysisID);
		return values != null && values.contains(EcoreUtil.getURI(target).toString());
	}

	public static void setHasRun(final String analysisID, final EObject target) {
		hasRunRecord.computeIfAbsent(analysisID, key -> new HashSet<>()).add(EcoreUtil.getURI(target).toString());
	}

	public static void unsetHasRun(final String analysisID, final EObject target) {
		var values = hasRunRecord.get(analysisID);
		if (values != null) {
			values.remove(EcoreUtil.getURI(target).toString());
			if (values.isEmpty()) {
				hasRunRecord.remove(analysisID);
			}
		}
	}

	public static void setAnalysisResult(final EObject target, final AnalysisResult analysisResult) {
		VerifyUtilExtension.analysisResultRecord.put(EcoreUtil.getURI(target).toString(),
				EcoreUtil.getURI(analysisResult));
	}

	public static AnalysisResult getAnalysisResult(final EObject target) {
		var result = VerifyUtilExtension.analysisResultRecord.get(EcoreUtil.getURI(target).toString());
		return (AnalysisResult) EcoreUtil2.getResourceSet(target).getEObject(result, true);
	}

	public static void clearAllHasRunRecords() {
		VerifyUtilExtension.hasRunRecord.clear();
		VerifyUtilExtension.analysisResultRecord.clear();
	}

	public static boolean hasFail(final ElseExpr cee) {
		return cee.getFail() != null;
	}

	public static boolean hasTimeout(final ElseExpr cee) {
		return cee.getTimeout() != null;
	}

	public static boolean hasError(final ElseExpr cee) {
		return cee.getError() != null;
	}

	public static VerificationPlan containingVerificationPlan(final EObject sh) {
		return EcoreUtil2.<VerificationPlan> getContainerOfType(sh, VerificationPlan.class);
	}

	public static Claim getContainingClaim(final EObject sh) {
		return EcoreUtil2.<Claim> getContainerOfType(sh, Claim.class);
	}

	public static VerificationMethod getContainingVerificationMethod(final EObject sh) {
		return EcoreUtil2.<VerificationMethod> getContainerOfType(sh, VerificationMethod.class);
	}

	public static String ordinal(final Integer i) {
		var lastTwoDigits = i % 100;
		if (lastTwoDigits >= 11 && lastTwoDigits <= 13) {
			return i + "th";
		}
		var suffixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
		return i + suffixes[i % 10];
	}

	public static void newArrayofSize(final int i) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub");
	}

	public static boolean evaluateRequirementFilter(final Requirement req, final CategoryFilter filter) {
		if ((filter == null)) {
			return true;
		}
		if (Aadl2Util.isNull(req)) {
			return false;
		}
		return CategoriesUtil.matches(req.getCategory(), filter.getCategory(), filter.isAnyCategory());
	}

	public static boolean evaluateRequirementFilter(final Claim claim, final CategoryFilter filter) {
		if ((filter == null)) {
			return true;
		}
		final Requirement req = claim.getRequirement();
		if (Aadl2Util.isNull(req)) {
			return false;
		}
		// Requirements without categories always drop through to their verification activities.
		if (req.getCategory().isEmpty()) {
			return true;
		}
		return CategoriesUtil.matches(req.getCategory(), filter.getCategory(), filter.isAnyCategory());
	}

	public static boolean evaluateVerificationMethodFilter(final VerificationActivity va, final CategoryFilter filter) {
		if ((filter == null)) {
			return true;
		}
		final VerificationMethod vm = va.getMethod();
		if ((vm == null)) {
			return false;
		}
		return CategoriesUtil.matches(vm.getCategory(), filter.getCategory(), filter.isAnyCategory());
	}

	public static boolean evaluateVerificationActivityFilter(final VerificationActivity va,
			final CategoryFilter filter) {
		if ((filter == null)) {
			return true;
		}
		return CategoriesUtil.matches(va.getCategory(), filter.getCategory(), filter.isAnyCategory());
	}

	public static String constructVerificationActivityReference(final VerificationActivity va) {
		var claim = getContainingClaim(va);
		var plan = containingVerificationPlan(va);
		return plan.getName() + "#" + constructClaimReferencePath(claim) + "#" + va.getName();
	}

	public static String constructClaimReference(final Claim claim) {
		var plan = containingVerificationPlan(claim);
		return plan.getName() + "#" + constructClaimReferencePath(claim);
	}

	public static String constructClaimReferencePath(final Claim claim) {
		final EObject parent = claim.eContainer();
		if ((parent instanceof Claim)) {
			return constructClaimReferencePath((Claim) parent) + "." + claim.getRequirement().getName();
		}
		return claim.getRequirement().getName();
	}

	public static ComponentClassifier getTargetClassifier(final VerificationPlan vp) {
		if (vp.getRequirementSet() instanceof SystemRequirementSet requirements) {
			return requirements.getTarget();
		}
		return null;
	}
}
