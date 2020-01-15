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
import org.osate.aadl2.properties.EvaluatedProperty;
import org.osate.aadl2.properties.EvaluationContext;
import org.osate.aadl2.properties.InvalidModelException;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>From package AADLProperties::Associations.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.PropertyAssociation#getProperty <em>Property</em>}</li>
 *   <li>{@link org.osate.aadl2.PropertyAssociation#getAppliesTos <em>Applies To</em>}</li>
 *   <li>{@link org.osate.aadl2.PropertyAssociation#getInBindings <em>In Binding</em>}</li>
 *   <li>{@link org.osate.aadl2.PropertyAssociation#isAppend <em>Append</em>}</li>
 *   <li>{@link org.osate.aadl2.PropertyAssociation#isConstant <em>Constant</em>}</li>
 *   <li>{@link org.osate.aadl2.PropertyAssociation#getOwnedValues <em>Owned Value</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.Aadl2Package#getPropertyAssociation()
 * @model
 * @generated
 */
public interface PropertyAssociation extends Element {
	/**
	 * Returns the value of the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Associations.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Property</em>' reference.
	 * @see #setProperty(Property)
	 * @see org.osate.aadl2.Aadl2Package#getPropertyAssociation_Property()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Property getProperty();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.PropertyAssociation#getProperty <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' reference.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(Property value);

	/**
	 * Returns the value of the '<em><b>Applies To</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.ContainedNamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Applies To</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Associations.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Applies To</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPropertyAssociation_AppliesTo()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ContainedNamedElement> getAppliesTos();

	/**
	 * Creates a new {@link org.osate.aadl2.ContainedNamedElement} and appends it to the '<em><b>Applies To</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.osate.aadl2.ContainedNamedElement} to create.
	 * @return The new {@link org.osate.aadl2.ContainedNamedElement}.
	 * @see #getAppliesTos()
	 * @generated
	 */
	ContainedNamedElement createAppliesTo(EClass eClass);

	/**
	 * Creates a new {@link org.osate.aadl2.ContainedNamedElement} and appends it to the '<em><b>Applies To</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ContainedNamedElement}.
	 * @see #getAppliesTos()
	 * @generated
	 */
	ContainedNamedElement createAppliesTo();

	/**
	 * Returns the value of the '<em><b>In Binding</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.Classifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Binding</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Associations.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>In Binding</em>' reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPropertyAssociation_InBinding()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Classifier> getInBindings();

	/**
	 * Returns the value of the '<em><b>Append</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Append</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Associations.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Append</em>' attribute.
	 * @see #setAppend(boolean)
	 * @see org.osate.aadl2.Aadl2Package#getPropertyAssociation_Append()
	 * @model dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isAppend();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.PropertyAssociation#isAppend <em>Append</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Append</em>' attribute.
	 * @see #isAppend()
	 * @generated
	 */
	void setAppend(boolean value);

	/**
	 * Returns the value of the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Associations.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Constant</em>' attribute.
	 * @see #setConstant(boolean)
	 * @see org.osate.aadl2.Aadl2Package#getPropertyAssociation_Constant()
	 * @model dataType="org.osate.aadl2.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isConstant();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.PropertyAssociation#isConstant <em>Constant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant</em>' attribute.
	 * @see #isConstant()
	 * @generated
	 */
	void setConstant(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Value</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.ModalPropertyValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Value</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package AADLProperties::Associations.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Value</em>' containment reference list.
	 * @see org.osate.aadl2.Aadl2Package#getPropertyAssociation_OwnedValue()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<ModalPropertyValue> getOwnedValues();

	/**
	 * Creates a new {@link org.osate.aadl2.ModalPropertyValue} and appends it to the '<em><b>Owned Value</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.osate.aadl2.ModalPropertyValue}.
	 * @see #getOwnedValues()
	 * @generated
	 */
	ModalPropertyValue createOwnedValue();

	/**
	 * Determine if the property value depends on mode.
	 * @return True, iff there are multiple modal property values, or the single value has a non-empty inModes.
	 */
	boolean isModal();

	/**
	 * Evaluate all property expressions in this property association.
	 * @return copies of the owned modal property values.
	 */
	EvaluatedProperty evaluate(EvaluationContext ctx, int depth) throws InvalidModelException;

	PropertyExpression valueInMode(Mode mode);

} // PropertyAssociation
