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

import org.osate.aadl2.ComponentClassifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#isFor <em>For</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#isForall <em>Forall</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#getDataClassifier <em>Data Classifier</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#getValues <em>Values</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getForStatement()
 * @model
 * @generated
 */
public interface ForStatement extends BehaviorAction
{
  /**
   * Returns the value of the '<em><b>For</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>For</em>' attribute.
   * @see #setFor(boolean)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getForStatement_For()
   * @model
   * @generated
   */
  boolean isFor();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#isFor <em>For</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>For</em>' attribute.
   * @see #isFor()
   * @generated
   */
  void setFor(boolean value);

  /**
   * Returns the value of the '<em><b>Forall</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Forall</em>' attribute.
   * @see #setForall(boolean)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getForStatement_Forall()
   * @model
   * @generated
   */
  boolean isForall();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#isForall <em>Forall</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Forall</em>' attribute.
   * @see #isForall()
   * @generated
   */
  void setForall(boolean value);

  /**
   * Returns the value of the '<em><b>Variable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' attribute.
   * @see #setVariable(String)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getForStatement_Variable()
   * @model
   * @generated
   */
  String getVariable();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#getVariable <em>Variable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' attribute.
   * @see #getVariable()
   * @generated
   */
  void setVariable(String value);

  /**
   * Returns the value of the '<em><b>Data Classifier</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Data Classifier</em>' reference.
   * @see #setDataClassifier(ComponentClassifier)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getForStatement_DataClassifier()
   * @model
   * @generated
   */
  ComponentClassifier getDataClassifier();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#getDataClassifier <em>Data Classifier</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Data Classifier</em>' reference.
   * @see #getDataClassifier()
   * @generated
   */
  void setDataClassifier(ComponentClassifier value);

  /**
   * Returns the value of the '<em><b>Values</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' containment reference.
   * @see #setValues(ElementValues)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getForStatement_Values()
   * @model containment="true"
   * @generated
   */
  ElementValues getValues();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#getValues <em>Values</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Values</em>' containment reference.
   * @see #getValues()
   * @generated
   */
  void setValues(ElementValues value);

  /**
   * Returns the value of the '<em><b>Actions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Actions</em>' containment reference.
   * @see #setActions(BehaviorActions)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getForStatement_Actions()
   * @model containment="true"
   * @generated
   */
  BehaviorActions getActions();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement#getActions <em>Actions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Actions</em>' containment reference.
   * @see #getActions()
   * @generated
   */
  void setActions(BehaviorActions value);

} // ForStatement
