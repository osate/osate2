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
package org.osate.alisa.common.common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Description Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.DescriptionElement#getText <em>Text</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.DescriptionElement#isThisTarget <em>This Target</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.DescriptionElement#getImage <em>Image</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.DescriptionElement#getShowValue <em>Show Value</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getDescriptionElement()
 * @model
 * @generated
 */
public interface DescriptionElement extends EObject
{
  /**
   * Returns the value of the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Text</em>' attribute.
   * @see #setText(String)
   * @see org.osate.alisa.common.common.CommonPackage#getDescriptionElement_Text()
   * @model
   * @generated
   */
  String getText();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.DescriptionElement#getText <em>Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Text</em>' attribute.
   * @see #getText()
   * @generated
   */
  void setText(String value);

  /**
   * Returns the value of the '<em><b>This Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>This Target</em>' attribute.
   * @see #setThisTarget(boolean)
   * @see org.osate.alisa.common.common.CommonPackage#getDescriptionElement_ThisTarget()
   * @model
   * @generated
   */
  boolean isThisTarget();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.DescriptionElement#isThisTarget <em>This Target</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>This Target</em>' attribute.
   * @see #isThisTarget()
   * @generated
   */
  void setThisTarget(boolean value);

  /**
   * Returns the value of the '<em><b>Image</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Image</em>' containment reference.
   * @see #setImage(ImageReference)
   * @see org.osate.alisa.common.common.CommonPackage#getDescriptionElement_Image()
   * @model containment="true"
   * @generated
   */
  ImageReference getImage();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.DescriptionElement#getImage <em>Image</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Image</em>' containment reference.
   * @see #getImage()
   * @generated
   */
  void setImage(ImageReference value);

  /**
   * Returns the value of the '<em><b>Show Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Show Value</em>' containment reference.
   * @see #setShowValue(AUnitExpression)
   * @see org.osate.alisa.common.common.CommonPackage#getDescriptionElement_ShowValue()
   * @model containment="true"
   * @generated
   */
  AUnitExpression getShowValue();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.DescriptionElement#getShowValue <em>Show Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Show Value</em>' containment reference.
   * @see #getShowValue()
   * @generated
   */
  void setShowValue(AUnitExpression value);

} // DescriptionElement
