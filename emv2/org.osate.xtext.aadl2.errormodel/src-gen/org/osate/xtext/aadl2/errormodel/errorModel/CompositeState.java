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
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeState#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeState#isOthers <em>Others</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeState#getState <em>State</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeState#getTypedToken <em>Typed Token</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getCompositeState()
 * @model
 * @generated
 */
public interface CompositeState extends EObject, NamedElement
{
  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(ConditionExpression)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getCompositeState_Condition()
   * @model containment="true"
   * @generated
   */
  ConditionExpression getCondition();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeState#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(ConditionExpression value);

  /**
   * Returns the value of the '<em><b>Others</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Others</em>' attribute.
   * @see #setOthers(boolean)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getCompositeState_Others()
   * @model
   * @generated
   */
  boolean isOthers();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeState#isOthers <em>Others</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Others</em>' attribute.
   * @see #isOthers()
   * @generated
   */
  void setOthers(boolean value);

  /**
   * Returns the value of the '<em><b>State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>State</em>' reference.
   * @see #setState(ErrorBehaviorState)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getCompositeState_State()
   * @model
   * @generated
   */
  ErrorBehaviorState getState();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeState#getState <em>State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State</em>' reference.
   * @see #getState()
   * @generated
   */
  void setState(ErrorBehaviorState value);

  /**
   * Returns the value of the '<em><b>Typed Token</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Typed Token</em>' containment reference.
   * @see #setTypedToken(TypeSet)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getCompositeState_TypedToken()
   * @model containment="true"
   * @generated
   */
  TypeSet getTypedToken();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeState#getTypedToken <em>Typed Token</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Typed Token</em>' containment reference.
   * @see #getTypedToken()
   * @generated
   */
  void setTypedToken(TypeSet value);

} // CompositeState
