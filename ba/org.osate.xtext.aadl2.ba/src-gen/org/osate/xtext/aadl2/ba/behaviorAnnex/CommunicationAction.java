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
 * A representation of the model object '<em><b>Communication Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#getReference <em>Reference</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isSend <em>Send</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isDequeue <em>Dequeue</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isFreeze <em>Freeze</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isLock <em>Lock</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isUnlock <em>Unlock</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isAll <em>All</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isAllLock <em>All Lock</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isAllUnlock <em>All Unlock</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getCommunicationAction()
 * @model
 * @generated
 */
public interface CommunicationAction extends BehaviorAction
{
  /**
   * Returns the value of the '<em><b>Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference</em>' containment reference.
   * @see #setReference(Reference)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getCommunicationAction_Reference()
   * @model containment="true"
   * @generated
   */
  Reference getReference();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#getReference <em>Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference</em>' containment reference.
   * @see #getReference()
   * @generated
   */
  void setReference(Reference value);

  /**
   * Returns the value of the '<em><b>Send</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Send</em>' attribute.
   * @see #setSend(boolean)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getCommunicationAction_Send()
   * @model
   * @generated
   */
  boolean isSend();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isSend <em>Send</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Send</em>' attribute.
   * @see #isSend()
   * @generated
   */
  void setSend(boolean value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.ba.behaviorAnnex.ValueExpression}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getCommunicationAction_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<ValueExpression> getParameters();

  /**
   * Returns the value of the '<em><b>Dequeue</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dequeue</em>' attribute.
   * @see #setDequeue(boolean)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getCommunicationAction_Dequeue()
   * @model
   * @generated
   */
  boolean isDequeue();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isDequeue <em>Dequeue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dequeue</em>' attribute.
   * @see #isDequeue()
   * @generated
   */
  void setDequeue(boolean value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' containment reference.
   * @see #setTarget(Reference)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getCommunicationAction_Target()
   * @model containment="true"
   * @generated
   */
  Reference getTarget();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#getTarget <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' containment reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(Reference value);

  /**
   * Returns the value of the '<em><b>Freeze</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Freeze</em>' attribute.
   * @see #setFreeze(boolean)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getCommunicationAction_Freeze()
   * @model
   * @generated
   */
  boolean isFreeze();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isFreeze <em>Freeze</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Freeze</em>' attribute.
   * @see #isFreeze()
   * @generated
   */
  void setFreeze(boolean value);

  /**
   * Returns the value of the '<em><b>Lock</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lock</em>' attribute.
   * @see #setLock(boolean)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getCommunicationAction_Lock()
   * @model
   * @generated
   */
  boolean isLock();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isLock <em>Lock</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lock</em>' attribute.
   * @see #isLock()
   * @generated
   */
  void setLock(boolean value);

  /**
   * Returns the value of the '<em><b>Unlock</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unlock</em>' attribute.
   * @see #setUnlock(boolean)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getCommunicationAction_Unlock()
   * @model
   * @generated
   */
  boolean isUnlock();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isUnlock <em>Unlock</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unlock</em>' attribute.
   * @see #isUnlock()
   * @generated
   */
  void setUnlock(boolean value);

  /**
   * Returns the value of the '<em><b>All</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>All</em>' attribute.
   * @see #setAll(boolean)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getCommunicationAction_All()
   * @model
   * @generated
   */
  boolean isAll();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isAll <em>All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>All</em>' attribute.
   * @see #isAll()
   * @generated
   */
  void setAll(boolean value);

  /**
   * Returns the value of the '<em><b>All Lock</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>All Lock</em>' attribute.
   * @see #setAllLock(boolean)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getCommunicationAction_AllLock()
   * @model
   * @generated
   */
  boolean isAllLock();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isAllLock <em>All Lock</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>All Lock</em>' attribute.
   * @see #isAllLock()
   * @generated
   */
  void setAllLock(boolean value);

  /**
   * Returns the value of the '<em><b>All Unlock</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>All Unlock</em>' attribute.
   * @see #setAllUnlock(boolean)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getCommunicationAction_AllUnlock()
   * @model
   * @generated
   */
  boolean isAllUnlock();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction#isAllUnlock <em>All Unlock</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>All Unlock</em>' attribute.
   * @see #isAllUnlock()
   * @generated
   */
  void setAllUnlock(boolean value);

} // CommunicationAction
