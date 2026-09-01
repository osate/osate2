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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dispatch Trigger Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition#isTimeout <em>Timeout</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition#getTime <em>Time</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition#isStop <em>Stop</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getDispatchTriggerCondition()
 * @model
 * @generated
 */
public interface DispatchTriggerCondition extends EObject
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(DispatchTriggerLogicalExpression)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getDispatchTriggerCondition_Expression()
   * @model containment="true"
   * @generated
   */
  DispatchTriggerLogicalExpression getExpression();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(DispatchTriggerLogicalExpression value);

  /**
   * Returns the value of the '<em><b>Timeout</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Timeout</em>' attribute.
   * @see #setTimeout(boolean)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getDispatchTriggerCondition_Timeout()
   * @model
   * @generated
   */
  boolean isTimeout();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition#isTimeout <em>Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Timeout</em>' attribute.
   * @see #isTimeout()
   * @generated
   */
  void setTimeout(boolean value);

  /**
   * Returns the value of the '<em><b>Time</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Time</em>' containment reference.
   * @see #setTime(BehaviorTime)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getDispatchTriggerCondition_Time()
   * @model containment="true"
   * @generated
   */
  BehaviorTime getTime();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition#getTime <em>Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Time</em>' containment reference.
   * @see #getTime()
   * @generated
   */
  void setTime(BehaviorTime value);

  /**
   * Returns the value of the '<em><b>Stop</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stop</em>' attribute.
   * @see #setStop(boolean)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getDispatchTriggerCondition_Stop()
   * @model
   * @generated
   */
  boolean isStop();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.DispatchTriggerCondition#isStop <em>Stop</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Stop</em>' attribute.
   * @see #isStop()
   * @generated
   */
  void setStop(boolean value);

} // DispatchTriggerCondition
