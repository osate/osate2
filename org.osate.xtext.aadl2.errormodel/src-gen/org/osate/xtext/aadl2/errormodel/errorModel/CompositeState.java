/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeState#getState <em>State</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeState#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getCompositeState()
 * @model
 * @generated
 */
public interface CompositeState extends EObject
{
  /**
   * Returns the value of the '<em><b>State</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State</em>' reference.
   * @see #setState(ErrorBehaviorState)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getCompositeState_State()
   * @model
   * @generated
   */
  ErrorBehaviorState getState();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeState#getState <em>State</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>State</em>' reference.
   * @see #getState()
   * @generated
   */
  void setState(ErrorBehaviorState value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(StateConditionExpression)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getCompositeState_Condition()
   * @model containment="true"
   * @generated
   */
  StateConditionExpression getCondition();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeState#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(StateConditionExpression value);

} // CompositeState
