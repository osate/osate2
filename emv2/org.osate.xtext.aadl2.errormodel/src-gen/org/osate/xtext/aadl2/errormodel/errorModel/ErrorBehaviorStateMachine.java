/**
 * <copyright>
 * </copyright>
 *
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.common.util.EList;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyAssociation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Behavior State Machine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine#getUseTypes <em>Use Types</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine#getUseTransformation <em>Use Transformation</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine#getEvents <em>Events</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine#getStates <em>States</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorBehaviorStateMachine()
 * @model
 * @generated
 */
public interface ErrorBehaviorStateMachine extends NamedElement, TypeUseContext
{
  /**
	 * Returns the value of the '<em><b>Extends</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extends</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' reference.
	 * @see #setExtends(ErrorBehaviorStateMachine)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorBehaviorStateMachine_Extends()
	 * @model
	 * @generated
	 */
  ErrorBehaviorStateMachine getExtends();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine#getExtends <em>Extends</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends</em>' reference.
	 * @see #getExtends()
	 * @generated
	 */
  void setExtends(ErrorBehaviorStateMachine value);

  /**
	 * Returns the value of the '<em><b>Use Types</b></em>' reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Types</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Types</em>' reference list.
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorBehaviorStateMachine_UseTypes()
	 * @model
	 * @generated
	 */
  EList<ErrorModelLibrary> getUseTypes();

  /**
	 * Returns the value of the '<em><b>Use Transformation</b></em>' reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Transformation</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Transformation</em>' reference list.
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorBehaviorStateMachine_UseTransformation()
	 * @model
	 * @generated
	 */
  EList<TypeTransformationSet> getUseTransformation();

  /**
	 * Returns the value of the '<em><b>Events</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorEvent}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Events</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Events</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorBehaviorStateMachine_Events()
	 * @model containment="true"
	 * @generated
	 */
  EList<ErrorBehaviorEvent> getEvents();

  /**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>States</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorBehaviorStateMachine_States()
	 * @model containment="true"
	 * @generated
	 */
  EList<ErrorBehaviorState> getStates();

  /**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorBehaviorStateMachine_Transitions()
	 * @model containment="true"
	 * @generated
	 */
  EList<ErrorBehaviorTransition> getTransitions();

  /**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.PropertyAssociation}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorBehaviorStateMachine_Properties()
	 * @model containment="true"
	 * @generated
	 */
  EList<PropertyAssociation> getProperties();

} // ErrorBehaviorStateMachine
