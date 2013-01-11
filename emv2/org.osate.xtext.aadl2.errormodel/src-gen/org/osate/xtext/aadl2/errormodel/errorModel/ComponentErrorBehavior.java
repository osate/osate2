/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.common.util.EList;

import org.osate.aadl2.Element;
import org.osate.aadl2.PropertyAssociation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Error Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getUseTypes <em>Use Types</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getUseBehavior <em>Use Behavior</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getUseTransformation <em>Use Transformation</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getEvents <em>Events</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getOutgoingPropagationConditions <em>Outgoing Propagation Conditions</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getErrorDetections <em>Error Detections</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getErrorStateToModeMappings <em>Error State To Mode Mappings</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getComponentErrorBehavior()
 * @model
 * @generated
 */
public interface ComponentErrorBehavior extends Element, EBSMUseContext
{
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
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getComponentErrorBehavior_UseTypes()
	 * @model
	 * @generated
	 */
  EList<ErrorModelLibrary> getUseTypes();

  /**
	 * Returns the value of the '<em><b>Use Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Behavior</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Behavior</em>' reference.
	 * @see #setUseBehavior(ErrorBehaviorStateMachine)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getComponentErrorBehavior_UseBehavior()
	 * @model
	 * @generated
	 */
  ErrorBehaviorStateMachine getUseBehavior();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getUseBehavior <em>Use Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Behavior</em>' reference.
	 * @see #getUseBehavior()
	 * @generated
	 */
  void setUseBehavior(ErrorBehaviorStateMachine value);

  /**
	 * Returns the value of the '<em><b>Use Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Transformation</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Transformation</em>' reference.
	 * @see #setUseTransformation(TypeTransformationSet)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getComponentErrorBehavior_UseTransformation()
	 * @model
	 * @generated
	 */
  TypeTransformationSet getUseTransformation();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ComponentErrorBehavior#getUseTransformation <em>Use Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Transformation</em>' reference.
	 * @see #getUseTransformation()
	 * @generated
	 */
  void setUseTransformation(TypeTransformationSet value);

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
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getComponentErrorBehavior_Events()
	 * @model containment="true"
	 * @generated
	 */
  EList<ErrorBehaviorEvent> getEvents();

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
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getComponentErrorBehavior_Transitions()
	 * @model containment="true"
	 * @generated
	 */
  EList<ErrorBehaviorTransition> getTransitions();

  /**
	 * Returns the value of the '<em><b>Outgoing Propagation Conditions</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outgoing Propagation Conditions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Propagation Conditions</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getComponentErrorBehavior_OutgoingPropagationConditions()
	 * @model containment="true"
	 * @generated
	 */
  EList<OutgoingPropagationCondition> getOutgoingPropagationConditions();

  /**
	 * Returns the value of the '<em><b>Error Detections</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Error Detections</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Detections</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getComponentErrorBehavior_ErrorDetections()
	 * @model containment="true"
	 * @generated
	 */
  EList<ErrorDetection> getErrorDetections();

  /**
	 * Returns the value of the '<em><b>Error State To Mode Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Error State To Mode Mappings</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Error State To Mode Mappings</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getComponentErrorBehavior_ErrorStateToModeMappings()
	 * @model containment="true"
	 * @generated
	 */
  EList<ErrorStateToModeMapping> getErrorStateToModeMappings();

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
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getComponentErrorBehavior_Properties()
	 * @model containment="true"
	 * @generated
	 */
  EList<PropertyAssociation> getProperties();

} // ComponentErrorBehavior
