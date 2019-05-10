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

import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AModel Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.AModelReference#getModelElement <em>Model Element</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.AModelReference#getPrev <em>Prev</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getAModelReference()
 * @model
 * @generated
 */
public interface AModelReference extends AExpression
{
  /**
   * Returns the value of the '<em><b>Model Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Model Element</em>' reference.
   * @see #setModelElement(NamedElement)
   * @see org.osate.alisa.common.common.CommonPackage#getAModelReference_ModelElement()
   * @model
   * @generated
   */
  NamedElement getModelElement();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.AModelReference#getModelElement <em>Model Element</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Model Element</em>' reference.
   * @see #getModelElement()
   * @generated
   */
  void setModelElement(NamedElement value);

  /**
   * Returns the value of the '<em><b>Prev</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Prev</em>' containment reference.
   * @see #setPrev(AModelReference)
   * @see org.osate.alisa.common.common.CommonPackage#getAModelReference_Prev()
   * @model containment="true"
   * @generated
   */
  AModelReference getPrev();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.AModelReference#getPrev <em>Prev</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Prev</em>' containment reference.
   * @see #getPrev()
   * @generated
   */
  void setPrev(AModelReference value);

} // AModelReference
