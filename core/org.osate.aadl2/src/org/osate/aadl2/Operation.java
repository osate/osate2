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
package org.osate.aadl2;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLProperties::Expressions.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.Operation#getOp <em>Op</em>}</li>
 *   <li>{@link org.osate.aadl2.Operation#getOwnedPropertyExpressions <em>Owned Property Expression</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getOperation()
 * @model
 * @generated
 */
public interface Operation extends PropertyExpression {
	/**
	 * Returns the value of the '<em><b>Op</b></em>' attribute.
	 * The literals are from the enumeration {@link org.osate.aadl2.OperationKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Op</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Expressions.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Op</em>' attribute.
	 * @see org.osate.aadl2.OperationKind
	 * @see #setOp(OperationKind)
	 * @see org.osate.aadl2.Aadl2Package#getOperation_Op()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OperationKind getOp();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.Operation#getOp <em>Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Op</em>' attribute.
	 * @see org.osate.aadl2.OperationKind
	 * @see #getOp()
	 * @generated
	 */
	void setOp(OperationKind value);

	/**
	 * Returns the value of the '<em><b>Owned Property Expression</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.PropertyExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Property Expression</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Expressions.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Property Expression</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getOperation_OwnedPropertyExpression()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<PropertyExpression> getOwnedPropertyExpressions();

	/**
	 * Creates a new {@link org.osate.aadl2.PropertyExpression} and appends it to the '<em><b>Owned Property Expression</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.osate.aadl2.PropertyExpression} to create.
	 * @return The new {@link org.osate.aadl2.PropertyExpression}.
	 * @see #getOwnedPropertyExpressions()
	 * @generated
	 */
	PropertyExpression createOwnedPropertyExpression(EClass eClass);

} // Operation
