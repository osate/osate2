/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Error Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getImportedNamespace <em>Imported Namespace</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getTransitionCondition <em>Transition Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getPropagationCondition <em>Propagation Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getDetectionEvent <em>Detection Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getComponentErrorBehavior()
 * @model
 * @generated
 */
public interface ComponentErrorBehavior extends EObject
{
  /**
   * Returns the value of the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imported Namespace</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imported Namespace</em>' attribute.
   * @see #setImportedNamespace(String)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getComponentErrorBehavior_ImportedNamespace()
   * @model
   * @generated
   */
  String getImportedNamespace();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getImportedNamespace <em>Imported Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Imported Namespace</em>' attribute.
   * @see #getImportedNamespace()
   * @generated
   */
  void setImportedNamespace(String value);

  /**
   * Returns the value of the '<em><b>Transition Condition</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.TransitionCondition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transition Condition</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transition Condition</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getComponentErrorBehavior_TransitionCondition()
   * @model containment="true"
   * @generated
   */
  EList<TransitionCondition> getTransitionCondition();

  /**
   * Returns the value of the '<em><b>Propagation Condition</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationCondition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Propagation Condition</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Propagation Condition</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getComponentErrorBehavior_PropagationCondition()
   * @model containment="true"
   * @generated
   */
  EList<PropagationCondition> getPropagationCondition();

  /**
   * Returns the value of the '<em><b>Detection Event</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.DetectionEvent}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Detection Event</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Detection Event</em>' containment reference list.
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getComponentErrorBehavior_DetectionEvent()
   * @model containment="true"
   * @generated
   */
  EList<DetectionEvent> getDetectionEvent();

} // ComponentErrorBehavior
