/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Behavior Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition#getDestination <em>Destination</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorBehaviorTransition()
 * @model
 * @generated
 */
public interface ErrorBehaviorTransition extends EObject
{
  /**
   * Returns the value of the '<em><b>Source</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' reference.
   * @see #setSource(ErrorBehaviorState)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorBehaviorTransition_Source()
   * @model
   * @generated
   */
  ErrorBehaviorState getSource();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition#getSource <em>Source</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' reference.
   * @see #getSource()
   * @generated
   */
  void setSource(ErrorBehaviorState value);

  /**
   * Returns the value of the '<em><b>Destination</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Destination</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Destination</em>' reference.
   * @see #setDestination(ErrorBehaviorState)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorBehaviorTransition_Destination()
   * @model
   * @generated
   */
  ErrorBehaviorState getDestination();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition#getDestination <em>Destination</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Destination</em>' reference.
   * @see #getDestination()
   * @generated
   */
  void setDestination(ErrorBehaviorState value);

} // ErrorBehaviorTransition
