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
package org.osate.verify.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.validation.Check;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlBoolean;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AadlString;
import org.osate.aadl2.Connection;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.Feature;
import org.osate.aadl2.MetaclassReference;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.ReferenceType;
import org.osate.alisa.common.common.AVariableReference;
import org.osate.alisa.common.common.ComputeDeclaration;
import org.osate.alisa.common.common.ModelRef;
import org.osate.alisa.common.common.PropertyRef;
import org.osate.alisa.common.common.TargetType;
import org.osate.alisa.common.common.TypeRef;
import org.osate.pluginsupport.ExecuteJavaUtil;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.reqSpec.SystemRequirementSet;
import org.osate.reqspec.reqSpec.ValuePredicate;
import org.osate.resolute.ResoluteUtil;
import org.osate.verify.internal.util.IVerifyGlobalReferenceFinder;
import org.osate.verify.internal.util.VerificationMethodDispatchers;
import org.osate.verify.internal.util.VerifyJavaUtil;
import org.osate.verify.internal.util.VerifyUtilExtension;
import org.osate.verify.typing.validation.VerifyTypeSystemValidator;
import org.osate.verify.verify.AgreeMethod;
import org.osate.verify.verify.Claim;
import org.osate.verify.verify.JUnit4Method;
import org.osate.verify.verify.JavaMethod;
import org.osate.verify.verify.PluginMethod;
import org.osate.verify.verify.ResoluteMethod;
import org.osate.verify.verify.Verification;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationCondition;
import org.osate.verify.verify.VerificationMethod;
import org.osate.verify.verify.VerificationMethodRegistry;
import org.osate.verify.verify.VerificationPlan;
import org.osate.verify.verify.VerifyPackage;

import com.google.inject.Inject;

/**
 * Custom validation rules.
 *
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
public class VerifyValidator extends VerifyTypeSystemValidator {
	public static final String INCORRECT_METHOD_PATH = "org.osate.verify.incorrectMethodPath";
	public static final String INCORRECT_CLASS_PATH = "org.osate.verify.incorrectClassPath";
	public static final String INCORRECT_METHOD_REFERENCE = "org.osate.verify.incorrectMethodReference";
	public static final String MISSING_METHOD_REFERENCE = "org.osate.verify.missingMethodReference";
	public static final String INCORRECT_METHOD_ID = "org.osate.verify.incorrectMethodID";
	public static final String CLAIM_MISSING_REQUIREMENT = "org.osate.verify.claimMissingRequirement";
	public static final String CLAIM_INVALID_REQUIREMENT = "org.osate.verify.claimInvalidRequirement";
	public static final String MISSING_CLAIM_FOR_REQ = "org.osate.verify.missingClaimForReq";
	public static final String MISSING_CLAIM_FOR_MULTIPLE_REQ = "org.osate.verify.missingClaimForMultipleReq";
	public static final String CLAIM_REQ_FOR_NOT_VP_FOR = "org.osate.verify.claimReqForNotVpFor";
	public static final String ILLEGAL_OBJECT_FOR_FILETYPE = "org.osate.verify.illegal.object.for.filetype";
	public static final String MISSING_REQUIREMENTS_FOR_MULTIPLE_CLAIMS =
			"org.osate.verify.missingRequirementsForMultipleClaims";
	public static final String MULTIPLE_CLAIMS_WITH_DUPLICATE_REQUIREMENTS =
			"org.osate.verify.multipleClaimsWithDuplicateRequirements";
	public static final String METHOD_PARMS_DO_NOT_MATCH_RESOLUTE_DEFINITION =
			"org.osate.verify.METHOD_PARMS_DO_NOT_MATCH_RESOLUTE_DEFINITION";
	public static final String MISMATCHED_TARGET = "org.osate.verify.MISMATCHED_TARGET";

	@Inject
	private IVerifyGlobalReferenceFinder verifyGlobalRefFinder;

	@Override
	protected List<EPackage> getEPackages() {
		var result = new ArrayList<>(super.getEPackages());
		result.add(VerifyPackage.eINSTANCE);
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://aadl.info/AADL/2.0"));
		return result;
	}

	@Check
	public void deprecateVerificationMethodBoolReport(final VerificationMethod verificationMethod) {
		if (verificationMethod.isIsPredicate()) {
			warning("Keyword 'boolean' is deprecated",
					VerifyPackage.Literals.VERIFICATION_METHOD__IS_PREDICATE);
		}
		if (verificationMethod.isIsResultReport()) {
			warning("Keyword 'report' is deprecated",
					VerifyPackage.Literals.VERIFICATION_METHOD__IS_RESULT_REPORT);
		}
	}

	@Check
	public void checkMethodPath(final JavaMethod method) {
		var parameterClasses = VerifyJavaUtil.getParameterClasses(method);
		var result = ExecuteJavaUtil.getJavaMethod(method.getMethodPath(), parameterClasses.toArray(Class<?>[]::new));
		if (result == null) {
			warning("Could not find method: " + method.getMethodPath(), VerifyPackage.Literals.JAVA_METHOD__METHOD_PATH,
					INCORRECT_METHOD_PATH);
		}
	}

	@Check
	public void checkClassPath(final JUnit4Method method) {
		var result = ExecuteJavaUtil.getJavaClass(method.getClassPath());
		if (result == null) {
			warning("Could not find JUnit4 test class: " + method.getClassPath(),
					VerifyPackage.Literals.JUNIT4_METHOD__CLASS_PATH, INCORRECT_CLASS_PATH);
		}
	}

	@Check
	public void checkMethodID(final PluginMethod method) {
		var result = VerificationMethodDispatchers.eInstance.dispatchVerificationMethod(method, null, null);
		if (result == null) {
			warning("Plugin verification method ID not found", VerifyPackage.Literals.PLUGIN_METHOD__METHOD_ID,
					INCORRECT_METHOD_ID);
		}
	}

	@Check
	public void checkAgreeMethod(final AgreeMethod method) {
		warning("Execution of AGREE verification methods is not supported",
				VerifyPackage.Literals.VERIFICATION_METHOD__METHOD_KIND);
	}

	@Check
	public void checkMethodReference(final VerificationCondition condition) {
		if (condition.getMethod() == null) {
			warning("Verification precondition or validation should have a verification method reference",
					VerifyPackage.Literals.VERIFICATION_CONDITION__METHOD, MISSING_METHOD_REFERENCE);
		}
	}

	@Check
	public void checkMissingMethodReference(final VerificationActivity activity) {
		if (activity.getMethod() == null) {
			warning("Verification activity should have a method reference",
					VerifyPackage.Literals.VERIFICATION_ACTIVITY__METHOD, MISSING_METHOD_REFERENCE);
		}
	}

	@Check
	public void checkConsistentTarget(final VerificationActivity activity) {
		var verificationMethod = activity.getMethod();
		if (verificationMethod == null) {
			return;
		}

		var containingClaim = VerifyUtilExtension.getContainingClaim(activity);
		var requirement = containingClaim == null ? null : containingClaim.getRequirement();
		var target = requirement == null ? null : requirement.getTargetElement();
		var categories = requirement == null ? null : requirement.getComponentCategory();
		if (target == null && (!categories.isEmpty() || requirement.getTargetType() == TargetType.COMPONENT
				|| requirement.getTargetType() == TargetType.ROOT)) {
			if (verificationMethod.getTargetType() != TargetType.COMPONENT
					&& verificationMethod.getTargetType() != TargetType.ELEMENT
					&& verificationMethod.getTargetType() != TargetType.ROOT) {
				error("Requirement is for component while verification method is not for component, element, or root",
						activity, VerifyPackage.Literals.VERIFICATION_ACTIVITY__METHOD, MISMATCHED_TARGET);
			}
		} else if ((requirement.getTargetType() == TargetType.FEATURE || target instanceof Feature)
				&& verificationMethod.getTargetType() != TargetType.FEATURE
				&& verificationMethod.getTargetType() != TargetType.ELEMENT
				&& !(verificationMethod.getMethodKind() instanceof PluginMethod)) {
			error("Requirement is for Feature while verification method is not for Feature", activity,
					VerifyPackage.Literals.VERIFICATION_ACTIVITY__METHOD, MISMATCHED_TARGET);
		} else if ((requirement.getTargetType() == TargetType.FLOW || target instanceof EndToEndFlow)
				&& verificationMethod.getTargetType() != TargetType.FLOW
				&& verificationMethod.getTargetType() != TargetType.ELEMENT
				&& !(verificationMethod.getMethodKind() instanceof PluginMethod)) {
			error("Requirement is for Flow while verification method is not for Flow", activity,
					VerifyPackage.Literals.VERIFICATION_ACTIVITY__METHOD, MISMATCHED_TARGET);
		} else if ((requirement.getTargetType() == TargetType.CONNECTION || target instanceof Connection)
				&& verificationMethod.getTargetType() != TargetType.CONNECTION
				&& verificationMethod.getTargetType() != TargetType.ELEMENT
				&& !(verificationMethod.getMethodKind() instanceof PluginMethod)) {
			error("Requirement is for Flow while verification method is not for Flow", activity,
					VerifyPackage.Literals.VERIFICATION_ACTIVITY__METHOD, MISMATCHED_TARGET);
		}
	}

	@Check
	public void checkVerificationActivityParams(final VerificationActivity activity) {
		var actualParameters = activity.getActuals();
		var expectedParameters = activity.getMethod().getFormals();
		if (expectedParameters.size() != actualParameters.size()) {
			warning(
					"The number of actual parameters differs from the number of formal parameters for verification activity",
					activity, VerifyPackage.Literals.VERIFICATION_ACTIVITY__METHOD);
		}
	}

	@Check
	public void checkVerificationActivityReturnCompute(final VerificationActivity activity) {
		var computeParameters = activity.getComputes();
		if (computeParameters.isEmpty()) {
			return;
		}

		var resultParameters = activity.getMethod().getResults();
		if (computeParameters.size() > resultParameters.size()) {
			error("The number of actual return parameters is less than the number of compute variable assignments",
					activity, VerifyPackage.Literals.VERIFICATION_ACTIVITY__COMPUTES);
		}

		var containingClaim = VerifyUtilExtension.getContainingClaim(activity);
		var requirement = containingClaim == null ? null : containingClaim.getRequirement();
		var predicate = requirement == null ? null : requirement.getPredicate();
		if (predicate instanceof ValuePredicate valuePredicate) {
			var variableReferences = EcoreUtil2.getAllContentsOfType(valuePredicate, AVariableReference.class);
			for (var variableReference : variableReferences) {
				var variable = variableReference.getVariable();
				if (variable instanceof ComputeDeclaration computeDeclaration
						&& computeParameters.stream()
								.noneMatch(parameter -> Objects.equals(parameter.getCompute(), computeDeclaration))) {
					error("Compute variable '" + computeDeclaration.getName()
							+ "' used in value predicate but not assigned in method call", activity,
							VerifyPackage.Literals.VERIFICATION_ACTIVITY__COMPUTES);
				}
			}
		}
	}

	@Check
	public void checkForDuplicateClaims(final VerificationPlan verificationPlan) {
		var claims = verificationPlan.getClaim();
		claims.forEach(EcoreUtil::resolveAll);
		var verificationPlanUri = EcoreUtil.getURI(verificationPlan).toString();
		for (var claim : claims) {
			var possibleDuplicates = new ArrayList<Claim>();
			for (var candidate : claims) {
				if (!Objects.equals(candidate, claim)
						&& Objects.equals(candidate.getRequirement(), claim.getRequirement())) {
					possibleDuplicates.add(candidate);
				}
			}
			if (!possibleDuplicates.isEmpty()) {
				var duplicateUris = new ArrayList<String>();
				duplicateUris.add(verificationPlanUri);
				duplicateUris.add(claim.getRequirement().getName());
				for (var duplicate : possibleDuplicates) {
					duplicateUris.add(EcoreUtil.getURI(duplicate).toString());
				}
				warning("Multiple Claims with duplicate Requirements", claim,
						VerifyPackage.Literals.CLAIM__REQUIREMENT, MULTIPLE_CLAIMS_WITH_DUPLICATE_REQUIREMENTS,
						duplicateUris.toArray(String[]::new));
			}
		}
	}

	@Check
	public void checkMultipleInvalidRequirementsForClaims(final VerificationPlan verificationPlan) {
		var claims = verificationPlan.getClaim();
		claims.forEach(EcoreUtil::resolveAll);
		var requirementSet = verificationPlan.getRequirementSet();
		var requirements = requirementSet.getRequirements();
		var verificationPlanUri = EcoreUtil.getURI(verificationPlan).toString();

		var claimedRequirements = new HashSet<Requirement>();
		for (var claim : claims) {
			claimedRequirements.add(claim.getRequirement());
		}
		var requirementsWithoutClaims = new ArrayList<Requirement>();
		for (var requirement : requirements) {
			if (!claimedRequirements.contains(requirement)) {
				requirementsWithoutClaims.add(requirement);
			}
		}
		var organizeClaims = !requirementsWithoutClaims.isEmpty();

		var missingRequirementUris = new ArrayList<String>();
		for (var requirement : requirementsWithoutClaims) {
			missingRequirementUris.add(EcoreUtil.getURI(requirement).toString());
		}

		var claimsWithMissingRequirements = new ArrayList<Claim>();
		for (var claim : claims) {
			if (claim.getRequirement() == null) {
				if (organizeClaims) {
					claimsWithMissingRequirements.add(claim);
				} else {
					error("Claim is missing requirement", claim, null, CLAIM_MISSING_REQUIREMENT, verificationPlanUri);
				}
			}
		}
		for (var claim : claims) {
			if (claim != null && claim.getRequirement() != null && claim.getRequirement().eIsProxy()) {
				if (organizeClaims) {
					claimsWithMissingRequirements.add(claim);
				} else {
					var requirementName = claim.getRequirement().getName();
					requirementName = requirementName == null ? "" : requirementName;
					if (!requirementName.isEmpty()) {
						requirementName += " ";
					}
					error("Requirement " + requirementName + "does not exist in " + requirementSet.getName() + ".",
							claim, VerifyPackage.Literals.CLAIM__REQUIREMENT, CLAIM_INVALID_REQUIREMENT,
							verificationPlanUri);
				}
			}
		}

		if (!claimsWithMissingRequirements.isEmpty()) {
			error("Claims with missing or unresolved Requirements", verificationPlan,
					VerifyPackage.Literals.VERIFICATION_PLAN__NAME, MISSING_REQUIREMENTS_FOR_MULTIPLE_CLAIMS,
					missingRequirementUris.toArray(String[]::new));
		}
	}

	@Check
	public void checkClaimsForRequirement(final VerificationPlan verificationPlan) {
		for (var requirement : verificationPlan.getRequirementSet().getRequirements()) {
			if (requirement.getRefinesReference().isEmpty()
					&& verificationPlan.getClaim()
							.stream()
							.noneMatch(claim -> claim.getRequirement() == requirement)) {
				warning("No claim for requirement " + requirement.getName(), verificationPlan,
						VerifyPackage.Literals.VERIFICATION_PLAN__NAME, MISSING_CLAIM_FOR_REQ, requirement.getName(),
						EcoreUtil.getURI(requirement).toString());
			}
		}
	}

	@Check
	public void checkClaimsForMultipleRequirement(final VerificationPlan verificationPlan) {
		var missingRequirements = new ArrayList<String>();
		for (var requirement : verificationPlan.getRequirementSet().getRequirements()) {
			if (requirement.getRefinesReference().isEmpty()
					&& verificationPlan.getClaim()
							.stream()
							.noneMatch(claim -> claim.getRequirement() == requirement)) {
				missingRequirements.add(EcoreUtil.getURI(requirement).toString());
			}
		}
		if (missingRequirements.size() > 1) {
			warning("Missing claims for multiple requirements", verificationPlan,
					VerifyPackage.Literals.VERIFICATION_PLAN__NAME, MISSING_CLAIM_FOR_MULTIPLE_REQ,
					missingRequirements.toArray(String[]::new));
		}
	}

	@Check
	public void checkVerificationMethodSignature(final VerificationMethod verificationMethod) {
		if (!(verificationMethod.getMethodKind() instanceof ResoluteMethod resoluteMethod)
				|| !ResoluteUtil.isResoluteInstalled()) {
			return;
		}

		var formalParameters = verificationMethod.getFormals();
		var methodReferenceOrProxy = resoluteMethod.getMethodReference();
		if (methodReferenceOrProxy == null
				|| !ResoluteUtil.getResolute().isFunctionDefinition(methodReferenceOrProxy)) {
			return;
		}

		var methodReference = (NamedElement) methodReferenceOrProxy;
		var actualParameters = ResoluteUtil.getResolute().getArgs(methodReference);
		var methodReferenceName = methodReference.getName();
		var hasComponentType = verificationMethod.getTargetType() != null;
		var formalCount = formalParameters.size() + (hasComponentType ? 1 : 0);
		if (formalCount != actualParameters.size()) {
			warning("method " + verificationMethod.getName()
					+ "'s number of parameters does not match the number of arguments for the Resolute method "
					+ methodReferenceName, verificationMethod, VerifyPackage.Literals.VERIFICATION_METHOD__NAME,
					METHOD_PARMS_DO_NOT_MATCH_RESOLUTE_DEFINITION);
			return;
		}

		var offset = hasComponentType ? 1 : 0;
		for (var index = 0; index < formalParameters.size(); index++) {
			var formalParameter = formalParameters.get(index);
			var actualParameter = actualParameters.get(index + offset);
			var resoluteType = ResoluteUtil.getResolute().getType(actualParameter);
			if (!matchResoluteType(formalParameter.getType(), resoluteType)) {
				warning("method " + verificationMethod.getName() + "'s parameter " + formalParameter.getName()
						+ " does not match the type of " + actualParameter.getName() + " in the Resolute method "
						+ methodReferenceName, verificationMethod,
						VerifyPackage.Literals.VERIFICATION_METHOD__NAME,
						METHOD_PARMS_DO_NOT_MATCH_RESOLUTE_DEFINITION);
			}
		}
	}

	/**
	 * @since 5.0
	 */
	public boolean matchResoluteType(final PropertyType formalType, final EObject resoluteType) {
		if (!ResoluteUtil.getResolute().isBaseType(resoluteType)) {
			return false;
		}

		return switch (formalType) {
		case AadlBoolean ignored ->
			ResoluteUtil.getResolute().getTypeName(resoluteType).equalsIgnoreCase("bool");
		case AadlReal ignored ->
			ResoluteUtil.getResolute().getTypeName(resoluteType).equalsIgnoreCase("real");
		case AadlInteger ignored ->
			ResoluteUtil.getResolute().getTypeName(resoluteType).equalsIgnoreCase("int");
		case AadlString ignored ->
			ResoluteUtil.getResolute().getTypeName(resoluteType).equalsIgnoreCase("string");
		case PropertyRef propertyReference -> {
			var property = propertyReference.getRef();
			var referencedType = property == null ? null : property.getReferencedPropertyType();
			var propertyType = referencedType != null ? referencedType : property.getOwnedPropertyType();
			yield propertyType instanceof ReferenceType referenceType
					? matchReferenceType(referenceType, resoluteType)
					: matchResoluteType(propertyType, resoluteType);
		}
		case ModelRef ignored ->
			ResoluteUtil.getResolute().getTypeName(resoluteType).equalsIgnoreCase("aadl");
		case TypeRef typeReference -> {
			var propertyType = typeReference.getRef();
			yield propertyType instanceof ReferenceType referenceType
					? matchReferenceType(referenceType, resoluteType)
					: matchResoluteType(propertyType, resoluteType);
		}
		case null, default -> false;
		};
	}

	/**
	 * @since 5.0
	 */
	public boolean matchReferenceType(final ReferenceType propertyType, final EObject resoluteType) {
		if (!ResoluteUtil.getResolute().isBaseType(resoluteType)) {
			return false;
		}
		var resoluteTypeName = ResoluteUtil.getResolute().getTypeName(resoluteType);
		if (resoluteTypeName.equalsIgnoreCase("aadl")) {
			return true;
		}

		var metaclassReference = Aadl2Factory.eINSTANCE.createMetaclassReference();
		metaclassReference.getMetaclassNames().add(resoluteTypeName);
		var referenceEClass = metaclassReference.getMetaclass();
		for (MetaclassReference namedElementReference : propertyType.getNamedElementReferences()) {
			if (referenceEClass.isSuperTypeOf(namedElementReference.getMetaclass())) {
				return true;
			}
		}
		return false;
	}

	@Check
	public void checkFileTypeContents(final Verification verification) {
		var verificationUri = EcoreUtil.getURI(verification);
		var fileExtension = verificationUri.fileExtension().toLowerCase();
		switch (fileExtension) {
		case "verify" -> {
			for (var content : verification.getContents()) {
				switch (content) {
				case VerificationPlan ignored -> {
				}
				case VerificationMethodRegistry ignored ->
					fileTypeError(fileExtension, "verification methods", content);
				default -> fileTypeError(fileExtension, content.getClass().getName(), content);
				}
			}
		}
		case "methodregistry" -> {
			for (var content : verification.getContents()) {
				switch (content) {
				case VerificationMethodRegistry ignored -> {
				}
				case VerificationPlan ignored -> fileTypeError(fileExtension, "verification plan", content);
				default -> fileTypeError(fileExtension, content.getClass().getName(), content);
				}
			}
		}
		default -> {
		}
		}
	}

	// TODO: The overload that supplies issue data invokes a quick fix that does not work as expected.
	public void fileTypeError(final String fileType, final String partName, final EObject part) {
		warning(partName + " not allowed in '" + fileType + "' file.", part, null);
	}

	@Check
	public void checkVerificationPlanUniqueToComponentClassifier(final VerificationPlan verificationPlan) {
		var requirementSet = verificationPlan.getRequirementSet();
		if (requirementSet instanceof SystemRequirementSet systemRequirements) {
			var verificationPlans = verifyGlobalRefFinder.getAllVerificationPlansForRequirements(systemRequirements,
					verificationPlan);
			var count = 0;
			for (var ignored : verificationPlans) {
				count++;
			}
			if (count > 1) {
				error("Other Verification Plans exist for '" + systemRequirements.getName()
						+ "'. Only one Verification Plans is allowed for a specific System Requirements.",
						verificationPlan, VerifyPackage.Literals.VERIFICATION_PLAN__REQUIREMENT_SET);
			}
		}
	}
}
