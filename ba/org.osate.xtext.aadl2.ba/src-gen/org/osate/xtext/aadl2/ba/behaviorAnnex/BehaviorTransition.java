/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.ba.behaviorAnnex;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getSourceStates <em>Source States</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getDestinationState <em>Destination State</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getActionBlock <em>Action Block</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getBehaviorTransition()
 * @model
 * @generated
 */
public interface BehaviorTransition extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getBehaviorTransition_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Priority</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Priority</em>' attribute.
   * @see #setPriority(String)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getBehaviorTransition_Priority()
   * @model
   * @generated
   */
  String getPriority();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getPriority <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Priority</em>' attribute.
   * @see #getPriority()
   * @generated
   */
  void setPriority(String value);

  /**
   * Returns the value of the '<em><b>Source States</b></em>' reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorState}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source States</em>' reference list.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getBehaviorTransition_SourceStates()
   * @model
   * @generated
   */
  EList<BehaviorState> getSourceStates();

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(BehaviorCondition)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getBehaviorTransition_Condition()
   * @model containment="true"
   * @generated
   */
  BehaviorCondition getCondition();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(BehaviorCondition value);

  /**
   * Returns the value of the '<em><b>Destination State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Destination State</em>' reference.
   * @see #setDestinationState(BehaviorState)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getBehaviorTransition_DestinationState()
   * @model
   * @generated
   */
  BehaviorState getDestinationState();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getDestinationState <em>Destination State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Destination State</em>' reference.
   * @see #getDestinationState()
   * @generated
   */
  void setDestinationState(BehaviorState value);

  /**
   * Returns the value of the '<em><b>Action Block</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action Block</em>' containment reference.
   * @see #setActionBlock(BehaviorActionBlock)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getBehaviorTransition_ActionBlock()
   * @model containment="true"
   * @generated
   */
  BehaviorActionBlock getActionBlock();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorTransition#getActionBlock <em>Action Block</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Action Block</em>' containment reference.
   * @see #getActionBlock()
   * @generated
   */
  void setActionBlock(BehaviorActionBlock value);

} // BehaviorTransition
