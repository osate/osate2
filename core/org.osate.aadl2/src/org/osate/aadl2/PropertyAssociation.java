/**
 * <copyright>
 * Copyright  2008 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 *
 * $Id: PropertyAssociation.java,v 1.21 2011-04-11 13:35:55 lwrage Exp $
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
 * <ul>
 *   <li>{@link org.osate.aadl2.PropertyAssociation#getProperty <em>Property</em>}</li>
 *   <li>{@link org.osate.aadl2.PropertyAssociation#getAppliesTos <em>Applies To</em>}</li>
 *   <li>{@link org.osate.aadl2.PropertyAssociation#getInBindings <em>In Binding</em>}</li>
 *   <li>{@link org.osate.aadl2.PropertyAssociation#isAppend <em>Append</em>}</li>
 *   <li>{@link org.osate.aadl2.PropertyAssociation#isConstant <em>Constant</em>}</li>
 *   <li>{@link org.osate.aadl2.PropertyAssociation#getOwnedValues <em>Owned Value</em>}</li>
 * </ul>
 * </p>
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
	EvaluatedProperty evaluate(EvaluationContext ctx) throws InvalidModelException;

	PropertyExpression valueInMode(Mode mode);

} // PropertyAssociation
