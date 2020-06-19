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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.osate.assure.assure.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.assure.assure.AssurePackage
 * @generated
 */
public class AssureAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AssurePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssureAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AssurePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssureSwitch<Adapter> modelSwitch =
		new AssureSwitch<Adapter>() {
			@Override
			public Adapter caseAssuranceCaseResult(AssuranceCaseResult object) {
				return createAssuranceCaseResultAdapter();
			}
			@Override
			public Adapter caseModelResult(ModelResult object) {
				return createModelResultAdapter();
			}
			@Override
			public Adapter caseSubsystemResult(SubsystemResult object) {
				return createSubsystemResultAdapter();
			}
			@Override
			public Adapter caseClaimResult(ClaimResult object) {
				return createClaimResultAdapter();
			}
			@Override
			public Adapter caseVerificationResult(VerificationResult object) {
				return createVerificationResultAdapter();
			}
			@Override
			public Adapter caseAssureResult(AssureResult object) {
				return createAssureResultAdapter();
			}
			@Override
			public Adapter caseVerificationExpr(VerificationExpr object) {
				return createVerificationExprAdapter();
			}
			@Override
			public Adapter caseElseResult(ElseResult object) {
				return createElseResultAdapter();
			}
			@Override
			public Adapter caseThenResult(ThenResult object) {
				return createThenResultAdapter();
			}
			@Override
			public Adapter caseMetrics(Metrics object) {
				return createMetricsAdapter();
			}
			@Override
			public Adapter caseQualifiedVerificationPlanElementReference(QualifiedVerificationPlanElementReference object) {
				return createQualifiedVerificationPlanElementReferenceAdapter();
			}
			@Override
			public Adapter caseQualifiedClaimReference(QualifiedClaimReference object) {
				return createQualifiedClaimReferenceAdapter();
			}
			@Override
			public Adapter caseQualifiedVAReference(QualifiedVAReference object) {
				return createQualifiedVAReferenceAdapter();
			}
			@Override
			public Adapter caseNestedClaimReference(NestedClaimReference object) {
				return createNestedClaimReferenceAdapter();
			}
			@Override
			public Adapter casePreconditionResult(PreconditionResult object) {
				return createPreconditionResultAdapter();
			}
			@Override
			public Adapter caseValidationResult(ValidationResult object) {
				return createValidationResultAdapter();
			}
			@Override
			public Adapter caseVerificationActivityResult(VerificationActivityResult object) {
				return createVerificationActivityResultAdapter();
			}
			@Override
			public Adapter casePredicateResult(PredicateResult object) {
				return createPredicateResultAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.osate.assure.assure.AssuranceCaseResult <em>Assurance Case Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.assure.assure.AssuranceCaseResult
	 * @generated
	 */
	public Adapter createAssuranceCaseResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.assure.assure.ModelResult <em>Model Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.assure.assure.ModelResult
	 * @generated
	 */
	public Adapter createModelResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.assure.assure.SubsystemResult <em>Subsystem Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.assure.assure.SubsystemResult
	 * @generated
	 */
	public Adapter createSubsystemResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.assure.assure.ClaimResult <em>Claim Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.assure.assure.ClaimResult
	 * @generated
	 */
	public Adapter createClaimResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.assure.assure.VerificationResult <em>Verification Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.assure.assure.VerificationResult
	 * @generated
	 */
	public Adapter createVerificationResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.assure.assure.AssureResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.assure.assure.AssureResult
	 * @generated
	 */
	public Adapter createAssureResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.assure.assure.VerificationExpr <em>Verification Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.assure.assure.VerificationExpr
	 * @generated
	 */
	public Adapter createVerificationExprAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.assure.assure.ElseResult <em>Else Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.assure.assure.ElseResult
	 * @generated
	 */
	public Adapter createElseResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.assure.assure.ThenResult <em>Then Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.assure.assure.ThenResult
	 * @generated
	 */
	public Adapter createThenResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.assure.assure.Metrics <em>Metrics</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.assure.assure.Metrics
	 * @generated
	 */
	public Adapter createMetricsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.assure.assure.QualifiedVerificationPlanElementReference <em>Qualified Verification Plan Element Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.assure.assure.QualifiedVerificationPlanElementReference
	 * @generated
	 */
	public Adapter createQualifiedVerificationPlanElementReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.assure.assure.QualifiedClaimReference <em>Qualified Claim Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.assure.assure.QualifiedClaimReference
	 * @generated
	 */
	public Adapter createQualifiedClaimReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.assure.assure.QualifiedVAReference <em>Qualified VA Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.assure.assure.QualifiedVAReference
	 * @generated
	 */
	public Adapter createQualifiedVAReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.assure.assure.NestedClaimReference <em>Nested Claim Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.assure.assure.NestedClaimReference
	 * @generated
	 */
	public Adapter createNestedClaimReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.assure.assure.PreconditionResult <em>Precondition Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.assure.assure.PreconditionResult
	 * @generated
	 */
	public Adapter createPreconditionResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.assure.assure.ValidationResult <em>Validation Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.assure.assure.ValidationResult
	 * @generated
	 */
	public Adapter createValidationResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.assure.assure.VerificationActivityResult <em>Verification Activity Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.assure.assure.VerificationActivityResult
	 * @generated
	 */
	public Adapter createVerificationActivityResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.assure.assure.PredicateResult <em>Predicate Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.assure.assure.PredicateResult
	 * @generated
	 */
	public Adapter createPredicateResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //AssureAdapterFactory
