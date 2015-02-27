/**
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
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.DescriptionElement#getText <em>Text</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.DescriptionElement#getShowValue <em>Show Value</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.DescriptionElement#isThisTarget <em>This Target</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.DescriptionElement#getImage <em>Image</em>}</li>
 * </ul>
 * </p>
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
   * <p>
   * If the meaning of the '<em>Text</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
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
   * Returns the value of the '<em><b>Show Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Show Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Show Value</em>' containment reference.
   * @see #setShowValue(ShowValue)
   * @see org.osate.alisa.common.common.CommonPackage#getDescriptionElement_ShowValue()
   * @model containment="true"
   * @generated
   */
  ShowValue getShowValue();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.DescriptionElement#getShowValue <em>Show Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Show Value</em>' containment reference.
   * @see #getShowValue()
   * @generated
   */
  void setShowValue(ShowValue value);

  /**
   * Returns the value of the '<em><b>This Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>This Target</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
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
   * <p>
   * If the meaning of the '<em>Image</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
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

} // DescriptionElement
