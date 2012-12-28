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
 * A representation of the model object '<em><b>Error Propagations</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations#getUseTypes <em>Use Types</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations#getUseBehavior <em>Use Behavior</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations#getPropagations <em>Propagations</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations#getFlows <em>Flows</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorPropagations()
 * @model
 * @generated
 */
public interface ErrorPropagations extends NamedElement, EBSMUseContext
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
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorPropagations_UseTypes()
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
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorPropagations_UseBehavior()
	 * @model
	 * @generated
	 */
  ErrorBehaviorStateMachine getUseBehavior();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations#getUseBehavior <em>Use Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Behavior</em>' reference.
	 * @see #getUseBehavior()
	 * @generated
	 */
  void setUseBehavior(ErrorBehaviorStateMachine value);

  /**
	 * Returns the value of the '<em><b>Propagations</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Propagations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Propagations</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorPropagations_Propagations()
	 * @model containment="true"
	 * @generated
	 */
  EList<ErrorPropagation> getPropagations();

  /**
	 * Returns the value of the '<em><b>Flows</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Flows</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Flows</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorPropagations_Flows()
	 * @model containment="true"
	 * @generated
	 */
  EList<ErrorFlow> getFlows();

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
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorPropagations_Properties()
	 * @model containment="true"
	 * @generated
	 */
  EList<PropertyAssociation> getProperties();

} // ErrorPropagations
