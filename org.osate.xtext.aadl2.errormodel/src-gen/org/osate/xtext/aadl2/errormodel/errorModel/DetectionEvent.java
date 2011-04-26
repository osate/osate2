/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Detection Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.DetectionEvent#isSelf <em>Self</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.DetectionEvent#getEventPort <em>Event Port</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.DetectionEvent#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getDetectionEvent()
 * @model
 * @generated
 */
public interface DetectionEvent extends EObject
{
  /**
   * Returns the value of the '<em><b>Self</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Self</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Self</em>' attribute.
   * @see #setSelf(boolean)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getDetectionEvent_Self()
   * @model
   * @generated
   */
  boolean isSelf();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.DetectionEvent#isSelf <em>Self</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Self</em>' attribute.
   * @see #isSelf()
   * @generated
   */
  void setSelf(boolean value);

  /**
   * Returns the value of the '<em><b>Event Port</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Event Port</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Event Port</em>' reference.
   * @see #setEventPort(Feature)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getDetectionEvent_EventPort()
   * @model
   * @generated
   */
  Feature getEventPort();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.DetectionEvent#getEventPort <em>Event Port</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Event Port</em>' reference.
   * @see #getEventPort()
   * @generated
   */
  void setEventPort(Feature value);

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
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getDetectionEvent_Condition()
   * @model containment="true"
   * @generated
   */
  TriggerConditionExpression getCondition();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.DetectionEvent#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(TriggerConditionExpression value);

} // DetectionEvent
