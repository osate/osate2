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
package org.osate.aadl2.errormodel.instance;

import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Outgoing Propagation Condition Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance#getOutgoingPropagationCondition <em>Outgoing Propagation Condition</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getOutgoingPropagationConditionInstance()
 * @model
 * @generated
 */
public interface OutgoingPropagationConditionInstance extends EMV2InstanceObject {
	/**
	 * Returns the value of the '<em><b>Outgoing Propagation Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Propagation Condition</em>' reference.
	 * @see #setOutgoingPropagationCondition(OutgoingPropagationCondition)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getOutgoingPropagationConditionInstance_OutgoingPropagationCondition()
	 * @model
	 * @generated
	 */
	OutgoingPropagationCondition getOutgoingPropagationCondition();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance#getOutgoingPropagationCondition <em>Outgoing Propagation Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outgoing Propagation Condition</em>' reference.
	 * @see #getOutgoingPropagationCondition()
	 * @generated
	 */
	void setOutgoingPropagationCondition(OutgoingPropagationCondition value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(TransitionSource)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getOutgoingPropagationConditionInstance_Source()
	 * @model containment="true"
	 * @generated
	 */
	TransitionSource getSource();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(TransitionSource value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(ConditionExpressionInstance)
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#getOutgoingPropagationConditionInstance_Condition()
	 * @model containment="true"
	 * @generated
	 */
	ConditionExpressionInstance getCondition();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(ConditionExpressionInstance value);

} // OutgoingPropagationConditionInstance
