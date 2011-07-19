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
 * $Id: PropertyConstant.java,v 1.15 2010-05-04 18:13:32 lwrage Exp $
 */
package org.osate.aadl2;

import org.eclipse.emf.ecore.EClass;
import org.osate.aadl2.properties.EvaluatedProperty;
import org.osate.aadl2.properties.EvaluationContext;
import org.osate.aadl2.properties.InvalidModelException;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Constant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.aadl2.PropertyConstant#getList <em>List</em>}</li>
 *   <li>{@link org.osate.aadl2.PropertyConstant#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link org.osate.aadl2.PropertyConstant#getConstantValue <em>Constant Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.aadl2.Aadl2Package#getPropertyConstant()
 * @model
 * @generated
 */
public interface PropertyConstant extends TypedElement, AbstractNamedValue {
	/**
	 * Returns the value of the '<em><b>List</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List</em>' attribute.
	 * @see #setList(long)
	 * @see org.osate.aadl2.Aadl2Package#getPropertyConstant_List()
	 * @model dataType="org.osate.aadl2.Integer" required="true" ordered="false"
	 * @generated
	 */
	long getList();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.PropertyConstant#getList <em>List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>List</em>' attribute.
	 * @see #getList()
	 * @generated
	 */
	void setList(long value);

	/**
	 * Returns the value of the '<em><b>Owned Type</b></em>' containment reference.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.osate.aadl2.PropertyConstant#getType() <em>Type</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Type</em>' containment reference.
	 * @see #setOwnedType(PropertyType)
	 * @see org.osate.aadl2.Aadl2Package#getPropertyConstant_OwnedType()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	PropertyType getOwnedType();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.PropertyConstant#getOwnedType <em>Owned Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Type</em>' containment reference.
	 * @see #getOwnedType()
	 * @generated
	 */
	void setOwnedType(PropertyType value);

	/**
	 * Creates a new {@link org.osate.aadl2.PropertyType} and sets the '<em><b>Owned Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.osate.aadl2.PropertyType} to create.
	 * @return The new {@link org.osate.aadl2.PropertyType}.
	 * @see #getOwnedType()
	 * @generated
	 */
	PropertyType createOwnedType(EClass eClass);

	/**
	 * Returns the value of the '<em><b>Constant Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constant Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Value</em>' containment reference.
	 * @see #setConstantValue(PropertyExpression)
	 * @see org.osate.aadl2.Aadl2Package#getPropertyConstant_ConstantValue()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	PropertyExpression getConstantValue();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.PropertyConstant#getConstantValue <em>Constant Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constant Value</em>' containment reference.
	 * @see #getConstantValue()
	 * @generated
	 */
	void setConstantValue(PropertyExpression value);

	/**
	 * Creates a new {@link org.osate.aadl2.PropertyExpression} and sets the '<em><b>Constant Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param eClass The Ecore class of the {@link org.osate.aadl2.PropertyExpression} to create.
	 * @return The new {@link org.osate.aadl2.PropertyExpression}.
	 * @see #getConstantValue()
	 * @generated
	 */
	PropertyExpression createConstantValue(EClass eClass);

	/**
	 * Evaluate a referenced property.
	 * 
	 * @param sign
	 * 			  The <code>referenceSign</code> value from the containing
	 * 			  Operation.
	 * @return The evaluated property value: either <code>null</code>, a
	 * 		   PropertyValue, or a list of PropertyValues. If the evaluation is
	 * 		   trivial, then this will be the same as the receiver.
	 * @throws InvalidModelException Thrown if there is a problem with the
	 * model that prevents the property value from being evaluated.
	 */
	EvaluatedProperty evaluate(EvaluationContext ctx) throws InvalidModelException;

} // PropertyConstant
