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
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Unit Literal</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLProperties::Types.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.UnitLiteral#getBaseUnit <em>Base Unit</em>}</li>
 *   <li>{@link org.osate.aadl2.UnitLiteral#getFactor <em>Factor</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getUnitLiteral()
 * @model
 * @generated
 */
public interface UnitLiteral extends EnumerationLiteral {
	/**
	 * Returns the value of the '<em><b>Base Unit</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Unit</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Base Unit</em>' reference.
	 * @see #setBaseUnit(UnitLiteral)
	 * @see org.osate.aadl2.Aadl2Package#getUnitLiteral_BaseUnit()
	 * @model ordered="false"
	 * @generated
	 */
	UnitLiteral getBaseUnit();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.UnitLiteral#getBaseUnit <em>Base Unit</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Unit</em>' reference.
	 * @see #getBaseUnit()
	 * @generated
	 */
	void setBaseUnit(UnitLiteral value);

	/**
	 * Returns the value of the '<em><b>Factor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Factor</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Types.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Factor</em>' containment reference.
	 * @see #setFactor(NumberValue)
	 * @see org.osate.aadl2.Aadl2Package#getUnitLiteral_Factor()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	NumberValue getFactor();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.UnitLiteral#getFactor <em>Factor</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factor</em>' containment reference.
	 * @see #getFactor()
	 * @generated
	 */
	void setFactor(NumberValue value);

	/**
	 * Creates a new {@link org.osate.aadl2.NumberValue} and sets the '<em><b>Factor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.osate.aadl2.NumberValue} to create.
	 * @return The new {@link org.osate.aadl2.NumberValue}.
	 * @see #getFactor()
	 * @generated
	 */
	NumberValue createFactor(EClass eClass);

	/**
	 * Get the absolute relationship between this literal and the ground
	 * literal. For example, in
	 * <p>
	 * <code>my_units: units (a, b => a * 10, c => b * 10)</code>
	 * <p>
	 * The factor for <code>c</code> is 10, but the absolute factor is 100.
	 *
	 * @return conversion factor
	 */
	public double getAbsoluteFactor();

	/**
	 * get conversion factor in terms of specified unit
	 *
	 * @param target UnitLiteral
	 * @return conversion factor
	 */
	double getAbsoluteFactor(UnitLiteral target);

} // UnitLiteral
