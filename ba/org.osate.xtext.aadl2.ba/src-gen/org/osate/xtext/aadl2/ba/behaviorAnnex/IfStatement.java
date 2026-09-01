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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement#getThenActions <em>Then Actions</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement#getElseIfs <em>Else Ifs</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement#getElseActions <em>Else Actions</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getIfStatement()
 * @model
 * @generated
 */
public interface IfStatement extends BehaviorAction
{
  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(ValueExpression)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getIfStatement_Condition()
   * @model containment="true"
   * @generated
   */
  ValueExpression getCondition();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(ValueExpression value);

  /**
   * Returns the value of the '<em><b>Then Actions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then Actions</em>' containment reference.
   * @see #setThenActions(BehaviorActions)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getIfStatement_ThenActions()
   * @model containment="true"
   * @generated
   */
  BehaviorActions getThenActions();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement#getThenActions <em>Then Actions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then Actions</em>' containment reference.
   * @see #getThenActions()
   * @generated
   */
  void setThenActions(BehaviorActions value);

  /**
   * Returns the value of the '<em><b>Else Ifs</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.ba.behaviorAnnex.ElseIfClause}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else Ifs</em>' containment reference list.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getIfStatement_ElseIfs()
   * @model containment="true"
   * @generated
   */
  EList<ElseIfClause> getElseIfs();

  /**
   * Returns the value of the '<em><b>Else Actions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else Actions</em>' containment reference.
   * @see #setElseActions(BehaviorActions)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getIfStatement_ElseActions()
   * @model containment="true"
   * @generated
   */
  BehaviorActions getElseActions();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.IfStatement#getElseActions <em>Else Actions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else Actions</em>' containment reference.
   * @see #getElseActions()
   * @generated
   */
  void setElseActions(BehaviorActions value);

} // IfStatement
