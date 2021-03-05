/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.assure.assure.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.osate.assure.assure.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AssureFactoryImpl extends EFactoryImpl implements AssureFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AssureFactory init() {
		try {
			AssureFactory theAssureFactory = (AssureFactory)EPackage.Registry.INSTANCE.getEFactory(AssurePackage.eNS_URI);
			if (theAssureFactory != null) {
				return theAssureFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AssureFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssureFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AssurePackage.ASSURANCE_CASE_RESULT: return createAssuranceCaseResult();
			case AssurePackage.MODEL_RESULT: return createModelResult();
			case AssurePackage.SUBSYSTEM_RESULT: return createSubsystemResult();
			case AssurePackage.CLAIM_RESULT: return createClaimResult();
			case AssurePackage.VERIFICATION_RESULT: return createVerificationResult();
			case AssurePackage.ASSURE_RESULT: return createAssureResult();
			case AssurePackage.VERIFICATION_EXPR: return createVerificationExpr();
			case AssurePackage.ELSE_RESULT: return createElseResult();
			case AssurePackage.THEN_RESULT: return createThenResult();
			case AssurePackage.METRICS: return createMetrics();
			case AssurePackage.QUALIFIED_VERIFICATION_PLAN_ELEMENT_REFERENCE: return createQualifiedVerificationPlanElementReference();
			case AssurePackage.QUALIFIED_CLAIM_REFERENCE: return createQualifiedClaimReference();
			case AssurePackage.QUALIFIED_VA_REFERENCE: return createQualifiedVAReference();
			case AssurePackage.NESTED_CLAIM_REFERENCE: return createNestedClaimReference();
			case AssurePackage.PRECONDITION_RESULT: return createPreconditionResult();
			case AssurePackage.VALIDATION_RESULT: return createValidationResult();
			case AssurePackage.VERIFICATION_ACTIVITY_RESULT: return createVerificationActivityResult();
			case AssurePackage.PREDICATE_RESULT: return createPredicateResult();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AssuranceCaseResult createAssuranceCaseResult() {
		AssuranceCaseResultImpl assuranceCaseResult = new AssuranceCaseResultImpl();
		return assuranceCaseResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelResult createModelResult() {
		ModelResultImpl modelResult = new ModelResultImpl();
		return modelResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SubsystemResult createSubsystemResult() {
		SubsystemResultImpl subsystemResult = new SubsystemResultImpl();
		return subsystemResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ClaimResult createClaimResult() {
		ClaimResultImpl claimResult = new ClaimResultImpl();
		return claimResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VerificationResult createVerificationResult() {
		VerificationResultImpl verificationResult = new VerificationResultImpl();
		return verificationResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AssureResult createAssureResult() {
		AssureResultImpl assureResult = new AssureResultImpl();
		return assureResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VerificationExpr createVerificationExpr() {
		VerificationExprImpl verificationExpr = new VerificationExprImpl();
		return verificationExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ElseResult createElseResult() {
		ElseResultImpl elseResult = new ElseResultImpl();
		return elseResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ThenResult createThenResult() {
		ThenResultImpl thenResult = new ThenResultImpl();
		return thenResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Metrics createMetrics() {
		MetricsImpl metrics = new MetricsImpl();
		return metrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QualifiedVerificationPlanElementReference createQualifiedVerificationPlanElementReference() {
		QualifiedVerificationPlanElementReferenceImpl qualifiedVerificationPlanElementReference = new QualifiedVerificationPlanElementReferenceImpl();
		return qualifiedVerificationPlanElementReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QualifiedClaimReference createQualifiedClaimReference() {
		QualifiedClaimReferenceImpl qualifiedClaimReference = new QualifiedClaimReferenceImpl();
		return qualifiedClaimReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QualifiedVAReference createQualifiedVAReference() {
		QualifiedVAReferenceImpl qualifiedVAReference = new QualifiedVAReferenceImpl();
		return qualifiedVAReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NestedClaimReference createNestedClaimReference() {
		NestedClaimReferenceImpl nestedClaimReference = new NestedClaimReferenceImpl();
		return nestedClaimReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PreconditionResult createPreconditionResult() {
		PreconditionResultImpl preconditionResult = new PreconditionResultImpl();
		return preconditionResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValidationResult createValidationResult() {
		ValidationResultImpl validationResult = new ValidationResultImpl();
		return validationResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VerificationActivityResult createVerificationActivityResult() {
		VerificationActivityResultImpl verificationActivityResult = new VerificationActivityResultImpl();
		return verificationActivityResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PredicateResult createPredicateResult() {
		PredicateResultImpl predicateResult = new PredicateResultImpl();
		return predicateResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AssurePackage getAssurePackage() {
		return (AssurePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AssurePackage getPackage() {
		return AssurePackage.eINSTANCE;
	}

} //AssureFactoryImpl
