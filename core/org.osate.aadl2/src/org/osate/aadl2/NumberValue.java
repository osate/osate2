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
 * A representation of the model object '<em><b>Number Value</b></em>'.
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
 *   <li>{@link org.osate.aadl2.NumberValue#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getNumberValue()
 * @model abstract="true"
 * @generated
 */
public interface NumberValue extends PropertyValue {
	/**
	 * Returns the value of the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Expressions.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unit</em>' reference.
	 * @see #setUnit(UnitLiteral)
	 * @see org.osate.aadl2.Aadl2Package#getNumberValue_Unit()
	 * @model ordered="false"
	 * @generated
	 */
	UnitLiteral getUnit();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.NumberValue#getUnit <em>Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' reference.
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(UnitLiteral value);

	/**
	 * @author dionisio
	 *
	 * set the value by parsing the string.
	 * @param s string with number to parse
	 */

	void setValue(String s);

	/**
	 * Create a "clone" that inverts this value.  It is a clone in the sense
	 * that it represent a number from the same source location.
	 * @return
	 */
	NumberValue cloneAndInvert();

	/**
	 * Clone this number value.
	 * @return
	 */
	NumberValue cloneNumber();

	/**
	 * Get the scaled value of the number, this is the number's value
	 * multiplied by the number's unit's absolute factor.  If the number doesn't
	 * have a unit then the scaled value is the same as the number's value.
	 * @return the value scaled to the base unit
	 */
	double getScaledValue();

	/**
	 * Get the scaled value of the number, this is the number's value
	 * multiplied by the number's unit's scaling factor for the specified unit.  If the number doesn't
	 * have a unit then the scaled value is the same as the number's value.
	 * @param target the target unit
	 * @return the value scaled to the target unit
	 */
	double getScaledValue(UnitLiteral target);

	double getScaledValue(String target);
} // NumberValue
