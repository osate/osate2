/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.TransitionCondition#getErrorTransition <em>Error Transition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.TransitionCondition#isMask <em>Mask</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.TransitionCondition#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getTransitionCondition()
 * @model
 * @generated
 */
public interface TransitionCondition extends EObject
{
  /**
   * Returns the value of the '<em><b>Error Transition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Error Transition</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Error Transition</em>' reference.
   * @see #setErrorTransition(TriggeredTransition)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getTransitionCondition_ErrorTransition()
   * @model
   * @generated
   */
  TriggeredTransition getErrorTransition();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.TransitionCondition#getErrorTransition <em>Error Transition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Error Transition</em>' reference.
   * @see #getErrorTransition()
   * @generated
   */
  void setErrorTransition(TriggeredTransition value);

  /**
   * Returns the value of the '<em><b>Mask</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mask</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mask</em>' attribute.
   * @see #setMask(boolean)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getTransitionCondition_Mask()
   * @model
   * @generated
   */
  boolean isMask();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.TransitionCondition#isMask <em>Mask</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mask</em>' attribute.
   * @see #isMask()
   * @generated
   */
  void setMask(boolean value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(TriggerConditionExpression)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getTransitionCondition_Condition()
   * @model containment="true"
   * @generated
   */
  TriggerConditionExpression getCondition();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.TransitionCondition#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(TriggerConditionExpression value);

} // TransitionCondition
