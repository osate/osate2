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
package org.osate.assure.assure;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Then Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.assure.assure.ThenResult#getFirst <em>First</em>}</li>
 *   <li>{@link org.osate.assure.assure.ThenResult#getSecond <em>Second</em>}</li>
 *   <li>{@link org.osate.assure.assure.ThenResult#isDidThenFail <em>Did Then Fail</em>}</li>
 * </ul>
 *
 * @see org.osate.assure.assure.AssurePackage#getThenResult()
 * @model
 * @generated
 */
public interface ThenResult extends VerificationExpr {
	/**
	 * Returns the value of the '<em><b>First</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.assure.assure.VerificationExpr}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First</em>' containment reference list.
	 * @see org.osate.assure.assure.AssurePackage#getThenResult_First()
	 * @model containment="true"
	 * @generated
	 */
	EList<VerificationExpr> getFirst();

	/**
	 * Returns the value of the '<em><b>Second</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.assure.assure.VerificationExpr}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second</em>' containment reference list.
	 * @see org.osate.assure.assure.AssurePackage#getThenResult_Second()
	 * @model containment="true"
	 * @generated
	 */
	EList<VerificationExpr> getSecond();

	/**
	 * Returns the value of the '<em><b>Did Then Fail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Did Then Fail</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Did Then Fail</em>' attribute.
	 * @see #setDidThenFail(boolean)
	 * @see org.osate.assure.assure.AssurePackage#getThenResult_DidThenFail()
	 * @model
	 * @generated
	 */
	boolean isDidThenFail();

	/**
	 * Sets the value of the '{@link org.osate.assure.assure.ThenResult#isDidThenFail <em>Did Then Fail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Did Then Fail</em>' attribute.
	 * @see #isDidThenFail()
	 * @generated
	 */
	void setDidThenFail(boolean value);

} // ThenResult
