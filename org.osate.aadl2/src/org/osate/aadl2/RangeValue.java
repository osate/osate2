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
 * $Id: RangeValue.java,v 1.6 2009-10-07 16:46:58 lwrage Exp $
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
 * <ul>
 *   <li>{@link org.osate.aadl2.RangeValue#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.osate.aadl2.RangeValue#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.osate.aadl2.RangeValue#getDelta <em>Delta</em>}</li>
 * </ul>
 * </p>
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
