/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.assure.assure.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.osate.assure.assure.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.osate.assure.assure.AssurePackage
 * @generated
 */
public class AssureSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AssurePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssureSwitch() {
		if (modelPackage == null) {
			modelPackage = AssurePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case AssurePackage.ASSURANCE_CASE_RESULT: {
				AssuranceCaseResult assuranceCaseResult = (AssuranceCaseResult)theEObject;
				T result = caseAssuranceCaseResult(assuranceCaseResult);
				if (result == null) result = caseAssureResult(assuranceCaseResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AssurePackage.MODEL_RESULT: {
				ModelResult modelResult = (ModelResult)theEObject;
				T result = caseModelResult(modelResult);
				if (result == null) result = caseAssureResult(modelResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AssurePackage.SUBSYSTEM_RESULT: {
				SubsystemResult subsystemResult = (SubsystemResult)theEObject;
				T result = caseSubsystemResult(subsystemResult);
				if (result == null) result = caseAssureResult(subsystemResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AssurePackage.CLAIM_RESULT: {
				ClaimResult claimResult = (ClaimResult)theEObject;
				T result = caseClaimResult(claimResult);
				if (result == null) result = caseAssureResult(claimResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AssurePackage.VERIFICATION_RESULT: {
				VerificationResult verificationResult = (VerificationResult)theEObject;
				T result = caseVerificationResult(verificationResult);
				if (result == null) result = caseVerificationExpr(verificationResult);
				if (result == null) result = caseAssureResult(verificationResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AssurePackage.ASSURE_RESULT: {
				AssureResult assureResult = (AssureResult)theEObject;
				T result = caseAssureResult(assureResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AssurePackage.VERIFICATION_EXPR: {
				VerificationExpr verificationExpr = (VerificationExpr)theEObject;
				T result = caseVerificationExpr(verificationExpr);
				if (result == null) result = caseAssureResult(verificationExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AssurePackage.ELSE_RESULT: {
				ElseResult elseResult = (ElseResult)theEObject;
				T result = caseElseResult(elseResult);
				if (result == null) result = caseVerificationExpr(elseResult);
				if (result == null) result = caseAssureResult(elseResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AssurePackage.THEN_RESULT: {
				ThenResult thenResult = (ThenResult)theEObject;
				T result = caseThenResult(thenResult);
				if (result == null) result = caseVerificationExpr(thenResult);
				if (result == null) result = caseAssureResult(thenResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AssurePackage.METRICS: {
				Metrics metrics = (Metrics)theEObject;
				T result = caseMetrics(metrics);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AssurePackage.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE: {
				QualifiedVerificationPlanElementReference qualifiedVerificationPlanElementReference = (QualifiedVerificationPlanElementReference)theEObject;
				T result = caseQualifiedVerificationPlanElementReference(qualifiedVerificationPlanElementReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AssurePackage.QUALIFIED_CLAIM_REFERENCE: {
				QualifiedClaimReference qualifiedClaimReference = (QualifiedClaimReference)theEObject;
				T result = caseQualifiedClaimReference(qualifiedClaimReference);
				if (result == null) result = caseQualifiedVerificationPlanElementReference(qualifiedClaimReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AssurePackage.QUALIFIED_VA_REFERENCE: {
				QualifiedVAReference qualifiedVAReference = (QualifiedVAReference)theEObject;
				T result = caseQualifiedVAReference(qualifiedVAReference);
				if (result == null) result = caseQualifiedVerificationPlanElementReference(qualifiedVAReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AssurePackage.NESTED_CLAIM_REFERENCE: {
				NestedClaimReference nestedClaimReference = (NestedClaimReference)theEObject;
				T result = caseNestedClaimReference(nestedClaimReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AssurePackage.PRECONDITION_RESULT: {
				PreconditionResult preconditionResult = (PreconditionResult)theEObject;
				T result = casePreconditionResult(preconditionResult);
				if (result == null) result = caseVerificationResult(preconditionResult);
				if (result == null) result = caseVerificationExpr(preconditionResult);
				if (result == null) result = caseAssureResult(preconditionResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AssurePackage.VALIDATION_RESULT: {
				ValidationResult validationResult = (ValidationResult)theEObject;
				T result = caseValidationResult(validationResult);
				if (result == null) result = caseVerificationResult(validationResult);
				if (result == null) result = caseVerificationExpr(validationResult);
				if (result == null) result = caseAssureResult(validationResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AssurePackage.VERIFICATION_ACTIVITY_RESULT: {
				VerificationActivityResult verificationActivityResult = (VerificationActivityResult)theEObject;
				T result = caseVerificationActivityResult(verificationActivityResult);
				if (result == null) result = caseVerificationResult(verificationActivityResult);
				if (result == null) result = caseVerificationExpr(verificationActivityResult);
				if (result == null) result = caseAssureResult(verificationActivityResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AssurePackage.PREDICATE_RESULT: {
				PredicateResult predicateResult = (PredicateResult)theEObject;
				T result = casePredicateResult(predicateResult);
				if (result == null) result = caseVerificationResult(predicateResult);
				if (result == null) result = caseVerificationExpr(predicateResult);
				if (result == null) result = caseAssureResult(predicateResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assurance Case Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assurance Case Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssuranceCaseResult(AssuranceCaseResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelResult(ModelResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subsystem Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subsystem Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubsystemResult(SubsystemResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Claim Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Claim Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClaimResult(ClaimResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Verification Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Verification Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVerificationResult(VerificationResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssureResult(AssureResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Verification Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Verification Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVerificationExpr(VerificationExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Else Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Else Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseElseResult(ElseResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Then Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Then Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThenResult(ThenResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Metrics</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Metrics</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMetrics(Metrics object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Qualified Verification Plan Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Qualified Verification Plan Element Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQualifiedVerificationPlanElementReference(QualifiedVerificationPlanElementReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Qualified Claim Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Qualified Claim Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQualifiedClaimReference(QualifiedClaimReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Qualified VA Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Qualified VA Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQualifiedVAReference(QualifiedVAReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nested Claim Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nested Claim Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNestedClaimReference(NestedClaimReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Precondition Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Precondition Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreconditionResult(PreconditionResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Validation Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Validation Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValidationResult(ValidationResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Verification Activity Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Verification Activity Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVerificationActivityResult(VerificationActivityResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Predicate Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Predicate Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePredicateResult(PredicateResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //AssureSwitch
