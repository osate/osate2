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
