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
 * A representation of the model object '<em><b>Range Value</b></em>'.
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
 *   <li>{@link org.osate.aadl2.RangeValue#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.osate.aadl2.RangeValue#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.osate.aadl2.RangeValue#getDelta <em>Delta</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getRangeValue()
 * @model
 * @generated
 */
public interface RangeValue extends PropertyValue {
	/**
	 * Returns the value of the '<em><b>Minimum</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Expressions.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Minimum</em>' containment reference.
	 * @see #setMinimum(PropertyExpression)
	 * @see org.osate.aadl2.Aadl2Package#getRangeValue_Minimum()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	PropertyExpression getMinimum();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.RangeValue#getMinimum <em>Minimum</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum</em>' containment reference.
	 * @see #getMinimum()
	 * @generated
	 */
	void setMinimum(PropertyExpression value);

	/**
	 * Creates a new {@link org.osate.aadl2.PropertyExpression} and sets the '<em><b>Minimum</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.osate.aadl2.PropertyExpression} to create.
	 * @return The new {@link org.osate.aadl2.PropertyExpression}.
	 * @see #getMinimum()
	 * @generated
	 */
	PropertyExpression createMinimum(EClass eClass);

	/**
	 * Returns the value of the '<em><b>Maximum</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Expressions.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Maximum</em>' containment reference.
	 * @see #setMaximum(PropertyExpression)
	 * @see org.osate.aadl2.Aadl2Package#getRangeValue_Maximum()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	PropertyExpression getMaximum();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.RangeValue#getMaximum <em>Maximum</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum</em>' containment reference.
	 * @see #getMaximum()
	 * @generated
	 */
	void setMaximum(PropertyExpression value);

	/**
	 * Creates a new {@link org.osate.aadl2.PropertyExpression} and sets the '<em><b>Maximum</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.osate.aadl2.PropertyExpression} to create.
	 * @return The new {@link org.osate.aadl2.PropertyExpression}.
	 * @see #getMaximum()
	 * @generated
	 */
	PropertyExpression createMaximum(EClass eClass);

	/**
	 * Returns the value of the '<em><b>Delta</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delta</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Expressions.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Delta</em>' containment reference.
	 * @see #setDelta(PropertyExpression)
	 * @see org.osate.aadl2.Aadl2Package#getRangeValue_Delta()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	PropertyExpression getDelta();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.RangeValue#getDelta <em>Delta</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delta</em>' containment reference.
	 * @see #getDelta()
	 * @generated
	 */
	void setDelta(PropertyExpression value);

	/**
	 * Creates a new {@link org.osate.aadl2.PropertyExpression} and sets the '<em><b>Delta</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.osate.aadl2.PropertyExpression} to create.
	 * @return The new {@link org.osate.aadl2.PropertyExpression}.
	 * @see #getDelta()
	 * @generated
	 */
	PropertyExpression createDelta(EClass eClass);

	/**
	 * Get the numeric value of the lower bound.
	 * @return the minimum value in the range
	 */
	NumberValue getMinimumValue();

	/**
	 * Get the numeric value of the upper bound.
	 * @return the maximum value in the range
	 */
	NumberValue getMaximumValue();

	/**
	 * Get the numeric value of the delta.
	 * @return the delta value of the range
	 */
	NumberValue getDeltaValue();

} // RangeValue
