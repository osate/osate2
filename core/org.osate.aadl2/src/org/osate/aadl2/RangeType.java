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

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Range Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLProperties::Types.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.RangeType#getOwnedNumberType <em>Owned Number Type</em>}</li>
 *   <li>{@link org.osate.aadl2.RangeType#getNumberType <em>Number Type</em>}</li>
 *   <li>{@link org.osate.aadl2.RangeType#getReferencedNumberType <em>Referenced Number Type</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getRangeType()
 * @model
 * @generated
 */
public interface RangeType extends NonListType {
	/**
	 * Returns the value of the '<em><b>Owned Number Type</b></em>' containment reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.RangeType#getNumberType() <em>Number Type</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Number Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Types.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Number Type</em>' containment reference.
	 * @see #setOwnedNumberType(NumberType)
	 * @see org.osate.aadl2.Aadl2Package#getRangeType_OwnedNumberType()
	 * @model containment="true" ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	NumberType getOwnedNumberType();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.RangeType#getOwnedNumberType <em>Owned Number Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Number Type</em>' containment reference.
	 * @see #getOwnedNumberType()
	 * @generated
	 */
	void setOwnedNumberType(NumberType value);

	/**
	 * Creates a new {@link org.osate.aadl2.NumberType} and sets the '<em><b>Owned Number Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.osate.aadl2.NumberType} to create.
	 * @return The new {@link org.osate.aadl2.NumberType}.
	 * @see #getOwnedNumberType()
	 * @generated
	 */
	NumberType createOwnedNumberType(EClass eClass);

	/**
	 * Returns the value of the '<em><b>Number Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Types.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Number Type</em>' reference.
	 * @see org.osate.aadl2.Aadl2Package#getRangeType_NumberType()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	NumberType getNumberType();

	/**
	 * Returns the value of the '<em><b>Referenced Number Type</b></em>' reference.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.RangeType#getNumberType() <em>Number Type</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Types.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referenced Number Type</em>' reference.
	 * @see #setReferencedNumberType(NumberType)
	 * @see org.osate.aadl2.Aadl2Package#getRangeType_ReferencedNumberType()
	 * @model ordered="false"
	 *        annotation="subsets"
	 * @generated
	 */
	NumberType getReferencedNumberType();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.RangeType#getReferencedNumberType <em>Referenced Number Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Number Type</em>' reference.
	 * @see #getReferencedNumberType()
	 * @generated
	 */
	void setReferencedNumberType(NumberType value);

} // RangeType
