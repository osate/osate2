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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reference Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression#getReference <em>Reference</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression#getProperty <em>Property</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression#isDequeue <em>Dequeue</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression#isCount <em>Count</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression#isFresh <em>Fresh</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getReferenceExpression()
 * @model
 * @generated
 */
public interface ReferenceExpression extends IntegerValue, ValueExpression
{
  /**
   * Returns the value of the '<em><b>Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference</em>' containment reference.
   * @see #setReference(Reference)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getReferenceExpression_Reference()
   * @model containment="true"
   * @generated
   */
  Reference getReference();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression#getReference <em>Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference</em>' containment reference.
   * @see #getReference()
   * @generated
   */
  void setReference(Reference value);

  /**
   * Returns the value of the '<em><b>Property</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property</em>' containment reference.
   * @see #setProperty(PropertyReferenceTail)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getReferenceExpression_Property()
   * @model containment="true"
   * @generated
   */
  PropertyReferenceTail getProperty();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression#getProperty <em>Property</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property</em>' containment reference.
   * @see #getProperty()
   * @generated
   */
  void setProperty(PropertyReferenceTail value);

  /**
   * Returns the value of the '<em><b>Dequeue</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dequeue</em>' attribute.
   * @see #setDequeue(boolean)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getReferenceExpression_Dequeue()
   * @model
   * @generated
   */
  boolean isDequeue();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression#isDequeue <em>Dequeue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dequeue</em>' attribute.
   * @see #isDequeue()
   * @generated
   */
  void setDequeue(boolean value);

  /**
   * Returns the value of the '<em><b>Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Count</em>' attribute.
   * @see #setCount(boolean)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getReferenceExpression_Count()
   * @model
   * @generated
   */
  boolean isCount();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression#isCount <em>Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Count</em>' attribute.
   * @see #isCount()
   * @generated
   */
  void setCount(boolean value);

  /**
   * Returns the value of the '<em><b>Fresh</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fresh</em>' attribute.
   * @see #setFresh(boolean)
   * @see org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage#getReferenceExpression_Fresh()
   * @model
   * @generated
   */
  boolean isFresh();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceExpression#isFresh <em>Fresh</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fresh</em>' attribute.
   * @see #isFresh()
   * @generated
   */
  void setFresh(boolean value);

} // ReferenceExpression
