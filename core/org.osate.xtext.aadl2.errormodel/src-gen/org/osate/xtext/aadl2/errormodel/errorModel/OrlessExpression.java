/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Orless Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.OrlessExpression#getCount <em>Count</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.OrlessExpression#getOperands <em>Operands</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getOrlessExpression()
 * @model
 * @generated
 */
public interface OrlessExpression extends TriggerConditionExpression, StateConditionExpression
{
  /**
   * Returns the value of the '<em><b>Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Count</em>' attribute.
   * @see #setCount(int)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getOrlessExpression_Count()
   * @model
   * @generated
   */
  int getCount();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.OrlessExpression#getCount <em>Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Count</em>' attribute.
   * @see #getCount()
   * @generated
   */
  void setCount(int value);

  /**
   * Returns the value of the '<em><b>Operands</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.StateConditionExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operands</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operands</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getOrlessExpression_Operands()
   * @model containment="true"
   * @generated
   */
  EList<StateConditionExpression> getOperands();

} // OrlessExpression
