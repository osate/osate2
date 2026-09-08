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
package org.osate.verify.ui.quickfix;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Objects;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.verify.validation.VerifyValidator;
import org.osate.verify.verify.Claim;
import org.osate.verify.verify.Verification;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationPlan;
import org.osate.verify.verify.VerifyFactory;
import org.osate.verify.verify.VerifyPackage;

/**
 * Custom quickfixes.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#quickfixes
 */
public class VerifyQuickfixProvider extends DefaultQuickfixProvider {
	protected VerifyPackage verifyPackage = VerifyPackage.eINSTANCE;
	protected VerifyFactory verifyFactory = verifyPackage.getVerifyFactory();

	/**
	 * QuickFix for adding a claim for a requirement.
	 * The issue data array is expected to have two elements:
	 *
	 * issue.getData()[0]: The name of the requirement
	 * issue.getData()[1]: the URI of the requirement
	 */
	@Fix(VerifyValidator.MISSING_CLAIM_FOR_REQ)
	public void fixMissingClaimForRequirement(final Issue issue, final IssueResolutionAcceptor acceptor) {
		var requirementName = head(issue.getData());
		var requirementUri = issue.getData()[1];
		acceptor.accept(issue, "Add claim for " + requirementName, null, null, new ISemanticModification() {
			@Override
			public void apply(final EObject element, final IModificationContext context) throws Exception {
				var resourceSet = element.eResource().getResourceSet();
				var requirement = (Requirement) resourceSet.getEObject(URI.createURI(requirementUri), true);
				var verificationPlan = (VerificationPlan) element;
				var claim = verifyFactory.createClaim();
				claim.setRequirement(requirement);
				verificationPlan.getClaim().add(claim);
			}
		});
	}

	/**
	 * QuickFix for adding claims for multiple requirements.
	 * The issue data array is expected to hold the URIs of the requirements.
	 */
	@Fix(VerifyValidator.MISSING_CLAIM_FOR_MULTIPLE_REQ)
	public void fixMissingClaimForMultipleRequirements(final Issue issue, final IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add a claim for each missing requirement", null, null, new ISemanticModification() {
			@Override
			public void apply(final EObject element, final IModificationContext context) throws Exception {
				var resourceSet = element.eResource().getResourceSet();
				for (var requirementUri : issue.getData()) {
					var requirement = (Requirement) resourceSet.getEObject(URI.createURI(requirementUri), true);
					var verificationPlan = (VerificationPlan) element;
					var claim = verifyFactory.createClaim();
					claim.setRequirement(requirement);
					verificationPlan.getClaim().add(claim);
				}
			}
		});
	}

	/**
	 * QuickFix for organizing claims when multiple claims are missing requirements.
	 * The issue data array is expected to hold the URIs of the missing requirements.
	 */
	@Fix(VerifyValidator.MISSING_REQUIREMENTS_FOR_MULTIPLE_CLAIMS)
	public void fixOrganizeClaimsMissingRequirements(final Issue issue, final IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add claims for missing requirements", null, null, new ISemanticModification() {
			@Override
			public void apply(final EObject element, final IModificationContext context) throws Exception {
				var resourceSet = element.eResource().getResourceSet();
				for (var requirementUri : issue.getData()) {
					var requirement = (Requirement) resourceSet.getEObject(URI.createURI(requirementUri), true);
					var verificationPlan = (VerificationPlan) element;
					var claim = verifyFactory.createClaim();
					claim.setRequirement(requirement);
					verificationPlan.getClaim().add(claim);
				}
			}
		});
	}

	/**
	 * QuickFix for removing an illegal object in a verification file.
	 * The issue data array is expected to have two elements:
	 *
	 * issue.getData()[0]: The type of element
	 * issue.getData()[1]: The URI of the containing parent
	 */
	@Fix(VerifyValidator.ILLEGAL_OBJECT_FOR_FILETYPE)
	public void fixIllegalObjectForFileTypeInVerify(final Issue issue, final IssueResolutionAcceptor acceptor) {
		var elementType = head(issue.getData());
		var verificationUri = issue.getData()[1];
		acceptor.accept(issue, "Remove " + elementType + ".", null, null, new ISemanticModification() {
			@Override
			public void apply(final EObject element, final IModificationContext context) throws Exception {
				var resourceSet = element.eResource().getResourceSet();
				var verification = (Verification) resourceSet.getEObject(URI.createURI(verificationUri), true);
				verification.getContents().remove(element);
			}
		});
	}

	/**
	 * QuickFix for merging multiple claims with the same requirement.
	 * The issue data array is expected to have multiple elements:
	 *
	 * issue.getData()[0]: The URI of the verification plan
	 * issue.getData()[1]: The name of the requirement duplicated by multiple claims
	 * issue.getData()[2..n]: The URIs of the other claims with duplicate requirements
	 */
	@Fix(VerifyValidator.MULTIPLE_CLAIMS_WITH_DUPLICATE_REQUIREMENTS)
	public void mergeMultipleClaimsWithDuplicateRequirements(final Issue issue,
			final IssueResolutionAcceptor acceptor) {
		var issueData = issue.getData();
		var verificationPlanUri = head(issueData);
		var requirementName = issueData[1];
		var duplicateClaimUris = Arrays.asList(issueData)
				.subList(Math.min(2, issueData.length), issueData.length);
		acceptor.accept(issue, "Merge claims for requirement " + requirementName + ".", null, null,
				new ISemanticModification() {
					@Override
					public void apply(final EObject element, final IModificationContext context) throws Exception {
						var resourceSet = element.eResource().getResourceSet();
						var claim = (Claim) element;
						var verificationPlan = (VerificationPlan) resourceSet
								.getEObject(URI.createURI(verificationPlanUri), true);
						var duplicateClaims = duplicateClaimUris.stream()
								.map(uri -> (Claim) resourceSet.getEObject(URI.createURI(uri), true))
								.toList();

						var activitiesByName = new LinkedHashMap<String, VerificationActivity>();
						for (var duplicateClaim : duplicateClaims) {
							for (var activity : duplicateClaim.getActivities()) {
								activitiesByName.putIfAbsent(activity.getName(), activity);
							}
						}

						for (var duplicateClaimUri : duplicateClaimUris) {
							var duplicateClaim = (Claim) resourceSet
									.getEObject(URI.createURI(duplicateClaimUri), true);
							verificationPlan.getClaim().remove(duplicateClaim);
						}
						for (var activity : activitiesByName.values()) {
							var alreadyPresent = claim.getActivities()
									.stream()
									.anyMatch(existing -> Objects.equals(existing.getName(), activity.getName()));
							if (!alreadyPresent) {
								claim.getActivities().add(activity);
							}
						}
					}
				});
	}

	/**
	 * QuickFix for fixing parameters that do not match the Resolute definition.
	 * The issue data array is expected to have two elements:
	 *
	 * issue.getData()[0]: The text of the verification method
	 * issue.getData()[1]: The revised text with corrected parameters
	 */
	@Fix(VerifyValidator.METHOD_PARMS_DO_NOT_MATCH_RESOLUTE_DEFINITION)
	public void fixMethodParmsDoNotMatchResoluteDefinition(final Issue issue,
			final IssueResolutionAcceptor acceptor) {
		var oldMethodText = head(issue.getData());
		var newMethodText = issue.getData()[1];
		acceptor.accept(issue, "Change method parameters to match Resolute method parameters", null, null,
				new IModification() {
					@Override
					public void apply(final IModificationContext context) throws Exception {
						var documentText = context.getXtextDocument().get();
						var methodIndex = documentText.indexOf(oldMethodText);
						var newDocumentText = documentText.substring(0, methodIndex) + newMethodText
								+ documentText.substring(methodIndex + oldMethodText.length());
						context.getXtextDocument().set(newDocumentText);
					}
				});
	}

	private static String head(final String[] values) {
		return values.length == 0 ? null : values[0];
	}
}
