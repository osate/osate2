/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.common.util.EList;

import org.osate.aadl2.Element;
import org.osate.aadl2.PropertyAssociation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Error Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior#getUseTypes <em>Use Types</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior#getUseBehavior <em>Use Behavior</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior#getStates <em>States</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getCompositeErrorBehavior()
 * @model
 * @generated
 */
public interface CompositeErrorBehavior extends Element, EBSMUseContext
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
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getCompositeErrorBehavior_UseTypes()
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
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getCompositeErrorBehavior_UseBehavior()
	 * @model
	 * @generated
	 */
  ErrorBehaviorStateMachine getUseBehavior();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeErrorBehavior#getUseBehavior <em>Use Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Behavior</em>' reference.
	 * @see #getUseBehavior()
	 * @generated
	 */
  void setUseBehavior(ErrorBehaviorStateMachine value);

  /**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.CompositeState}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>States</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getCompositeErrorBehavior_States()
	 * @model containment="true"
	 * @generated
	 */
  EList<CompositeState> getStates();

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
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getCompositeErrorBehavior_Properties()
	 * @model containment="true"
	 * @generated
	 */
  EList<PropertyAssociation> getProperties();

} // CompositeErrorBehavior
