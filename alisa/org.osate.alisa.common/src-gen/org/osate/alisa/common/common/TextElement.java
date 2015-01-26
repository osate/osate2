/**
 */
package org.osate.alisa.common.common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.TextElement#getText <em>Text</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.TextElement#isNewline <em>Newline</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getTextElement()
 * @model
 * @generated
 */
public interface TextElement extends EObject
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
   * @see org.osate.alisa.common.common.CommonPackage#getTextElement_Text()
   * @model
   * @generated
   */
  String getText();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.TextElement#getText <em>Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Text</em>' attribute.
   * @see #getText()
   * @generated
   */
  void setText(String value);

  /**
   * Returns the value of the '<em><b>Newline</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Newline</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Newline</em>' attribute.
   * @see #setNewline(boolean)
   * @see org.osate.alisa.common.common.CommonPackage#getTextElement_Newline()
   * @model
   * @generated
   */
  boolean isNewline();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.TextElement#isNewline <em>Newline</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Newline</em>' attribute.
   * @see #isNewline()
   * @generated
   */
  void setNewline(boolean value);

} // TextElement
