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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Number Type</b></em>'.
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
 *   <li>{@link org.osate.aadl2.NumberType#getOwnedUnitsType <em>Owned Units Type</em>}</li>
 *   <li>{@link org.osate.aadl2.NumberType#getReferencedUnitsType <em>Referenced Units Type</em>}</li>
 *   <li>{@link org.osate.aadl2.NumberType#getRange <em>Range</em>}</li>
 *   <li>{@link org.osate.aadl2.NumberType#getUnitsType <em>Units Type</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getNumberType()
 * @model abstract="true"
 * @generated
 */
public interface NumberType extends NonListType {
	/**
	 * Returns the value of the '<em><b>Owned Units Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Units Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Types.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Units Type</em>' containment reference.
	 * @see #setOwnedUnitsType(UnitsType)
	 * @see org.osate.aadl2.Aadl2Package#getNumberType_OwnedUnitsType()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	UnitsType getOwnedUnitsType();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.NumberType#getOwnedUnitsType <em>Owned Units Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Units Type</em>' containment reference.
	 * @see #getOwnedUnitsType()
	 * @generated
	 */
	void setOwnedUnitsType(UnitsType value);

	/**
	 * Creates a new {@link org.osate.aadl2.UnitsType} and sets the '<em><b>Owned Units Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.UnitsType}.
	 * @see #getOwnedUnitsType()
	 * @generated
	 */
	UnitsType createOwnedUnitsType();

	/**
	 * Returns the value of the '<em><b>Referenced Units Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Types.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Referenced Units Type</em>' reference.
	 * @see #setReferencedUnitsType(UnitsType)
	 * @see org.osate.aadl2.Aadl2Package#getNumberType_ReferencedUnitsType()
	 * @model ordered="false"
	 * @generated
	 */
	UnitsType getReferencedUnitsType();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.NumberType#getReferencedUnitsType <em>Referenced Units Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referenced Units Type</em>' reference.
	 * @see #getReferencedUnitsType()
	 * @generated
	 */
	void setReferencedUnitsType(UnitsType value);

	/**
	 * Returns the value of the '<em><b>Units Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Units Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Types.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Units Type</em>' reference.
	 * @see org.osate.aadl2.Aadl2Package#getNumberType_UnitsType()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	UnitsType getUnitsType();

	/**
	 * Returns the value of the '<em><b>Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Types.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Range</em>' containment reference.
	 * @see #setRange(NumericRange)
	 * @see org.osate.aadl2.Aadl2Package#getNumberType_Range()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	NumericRange getRange();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.NumberType#getRange <em>Range</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range</em>' containment reference.
	 * @see #getRange()
	 * @generated
	 */
	void setRange(NumericRange value);

	/**
	 * Creates a new {@link org.osate.aadl2.NumericRange} and sets the '<em><b>Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.NumericRange}.
	 * @see #getRange()
	 * @generated
	 */
	NumericRange createRange();

} // NumberType
