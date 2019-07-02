/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */
package org.osate.alisa.common.common;

import org.osate.aadl2.AbstractNamedValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AProperty Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.APropertyReference#getModelElementReference <em>Model Element Reference</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.APropertyReference#getProperty <em>Property</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getAPropertyReference()
 * @model
 * @generated
 */
public interface APropertyReference extends AExpression
{
  /**
   * Returns the value of the '<em><b>Model Element Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model Element Reference</em>' containment reference.
   * @see #setModelElementReference(AModelReference)
   * @see org.osate.alisa.common.common.CommonPackage#getAPropertyReference_ModelElementReference()
   * @model containment="true"
   * @generated
   */
  AModelReference getModelElementReference();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.APropertyReference#getModelElementReference <em>Model Element Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Model Element Reference</em>' containment reference.
   * @see #getModelElementReference()
   * @generated
   */
  void setModelElementReference(AModelReference value);

  /**
   * Returns the value of the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Property</em>' reference.
   * @see #setProperty(AbstractNamedValue)
   * @see org.osate.alisa.common.common.CommonPackage#getAPropertyReference_Property()
   * @model
   * @generated
   */
  AbstractNamedValue getProperty();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.APropertyReference#getProperty <em>Property</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Property</em>' reference.
   * @see #getProperty()
   * @generated
   */
  void setProperty(AbstractNamedValue value);

} // APropertyReference
