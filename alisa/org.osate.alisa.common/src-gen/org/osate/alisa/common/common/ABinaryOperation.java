/**
 */
package org.osate.alisa.common.common;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.PropertyExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ABinary Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.ABinaryOperation#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.ABinaryOperation#getFeature <em>Feature</em>}</li>
 *   <li>{@link org.osate.alisa.common.common.ABinaryOperation#getRightOperand <em>Right Operand</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa.common.common.CommonPackage#getABinaryOperation()
 * @model
 * @generated
 */
public interface ABinaryOperation extends EObject, PropertyExpression
{
  /**
   * Returns the value of the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left Operand</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left Operand</em>' containment reference.
   * @see #setLeftOperand(PropertyExpression)
   * @see org.osate.alisa.common.common.CommonPackage#getABinaryOperation_LeftOperand()
   * @model containment="true"
   * @generated
   */
  PropertyExpression getLeftOperand();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.ABinaryOperation#getLeftOperand <em>Left Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left Operand</em>' containment reference.
   * @see #getLeftOperand()
   * @generated
   */
  void setLeftOperand(PropertyExpression value);

  /**
   * Returns the value of the '<em><b>Feature</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Feature</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Feature</em>' attribute.
   * @see #setFeature(String)
   * @see org.osate.alisa.common.common.CommonPackage#getABinaryOperation_Feature()
   * @model
   * @generated
   */
  String getFeature();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.ABinaryOperation#getFeature <em>Feature</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Feature</em>' attribute.
   * @see #getFeature()
   * @generated
   */
  void setFeature(String value);

  /**
   * Returns the value of the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right Operand</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right Operand</em>' containment reference.
   * @see #setRightOperand(PropertyExpression)
   * @see org.osate.alisa.common.common.CommonPackage#getABinaryOperation_RightOperand()
   * @model containment="true"
   * @generated
   */
  PropertyExpression getRightOperand();

  /**
   * Sets the value of the '{@link org.osate.alisa.common.common.ABinaryOperation#getRightOperand <em>Right Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right Operand</em>' containment reference.
   * @see #getRightOperand()
   * @generated
   */
  void setRightOperand(PropertyExpression value);

} // ABinaryOperation
