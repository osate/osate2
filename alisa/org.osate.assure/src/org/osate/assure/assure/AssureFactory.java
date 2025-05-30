/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.assure.assure;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.assure.assure.AssurePackage
 * @generated
 */
public interface AssureFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AssureFactory eINSTANCE = org.osate.assure.assure.impl.AssureFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Assurance Case Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assurance Case Result</em>'.
	 * @generated
	 */
	AssuranceCaseResult createAssuranceCaseResult();

	/**
	 * Returns a new object of class '<em>Model Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model Result</em>'.
	 * @generated
	 */
	ModelResult createModelResult();

	/**
	 * Returns a new object of class '<em>Subsystem Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subsystem Result</em>'.
	 * @generated
	 */
	SubsystemResult createSubsystemResult();

	/**
	 * Returns a new object of class '<em>Claim Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Claim Result</em>'.
	 * @generated
	 */
	ClaimResult createClaimResult();

	/**
	 * Returns a new object of class '<em>Verification Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Verification Result</em>'.
	 * @generated
	 */
	VerificationResult createVerificationResult();

	/**
	 * Returns a new object of class '<em>Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Result</em>'.
	 * @generated
	 */
	AssureResult createAssureResult();

	/**
	 * Returns a new object of class '<em>Verification Expr</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Verification Expr</em>'.
	 * @generated
	 */
	VerificationExpr createVerificationExpr();

	/**
	 * Returns a new object of class '<em>Else Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Else Result</em>'.
	 * @generated
	 */
	ElseResult createElseResult();

	/**
	 * Returns a new object of class '<em>Then Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Then Result</em>'.
	 * @generated
	 */
	ThenResult createThenResult();

	/**
	 * Returns a new object of class '<em>Metrics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Metrics</em>'.
	 * @generated
	 */
	Metrics createMetrics();

	/**
	 * Returns a new object of class '<em>Qualified Verification Plan Element Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Qualified Verification Plan Element Reference</em>'.
	 * @generated
	 */
	QualifiedVerificationPlanElementReference createQualifiedVerificationPlanElementReference();

	/**
	 * Returns a new object of class '<em>Qualified Claim Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Qualified Claim Reference</em>'.
	 * @generated
	 */
	QualifiedClaimReference createQualifiedClaimReference();

	/**
	 * Returns a new object of class '<em>Qualified VA Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Qualified VA Reference</em>'.
	 * @generated
	 */
	QualifiedVAReference createQualifiedVAReference();

	/**
	 * Returns a new object of class '<em>Nested Claim Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Nested Claim Reference</em>'.
	 * @generated
	 */
	NestedClaimReference createNestedClaimReference();

	/**
	 * Returns a new object of class '<em>Precondition Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Precondition Result</em>'.
	 * @generated
	 */
	PreconditionResult createPreconditionResult();

	/**
	 * Returns a new object of class '<em>Validation Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Validation Result</em>'.
	 * @generated
	 */
	ValidationResult createValidationResult();

	/**
	 * Returns a new object of class '<em>Verification Activity Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Verification Activity Result</em>'.
	 * @generated
	 */
	VerificationActivityResult createVerificationActivityResult();

	/**
	 * Returns a new object of class '<em>Predicate Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Predicate Result</em>'.
	 * @generated
	 */
	PredicateResult createPredicateResult();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AssurePackage getAssurePackage();

} //AssureFactory
