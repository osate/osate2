/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.common.util.EList;

import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.PropertyAssociation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subclause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getUseTypes <em>Use Types</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getUseBehavior <em>Use Behavior</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getPropagation <em>Propagation</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getComponentBehavior <em>Component Behavior</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getCompositeBehavior <em>Composite Behavior</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getObservablePropagationConnections <em>Observable Propagation Connections</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getConnectionTransformation <em>Connection Transformation</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause()
 * @model
 * @generated
 */
public interface ErrorModelSubclause extends AnnexSubclause, EBSMUseContext
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
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_UseTypes()
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
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_UseBehavior()
	 * @model
	 * @generated
	 */
  ErrorBehaviorStateMachine getUseBehavior();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getUseBehavior <em>Use Behavior</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Behavior</em>' reference.
	 * @see #getUseBehavior()
	 * @generated
	 */
  void setUseBehavior(ErrorBehaviorStateMachine value);

  /**
	 * Returns the value of the '<em><b>Propagation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Propagation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Propagation</em>' containment reference.
	 * @see #setPropagation(ErrorPropagations)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_Propagation()
	 * @model containment="true"
	 * @generated
	 */
  ErrorPropagations getPropagation();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getPropagation <em>Propagation</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Propagation</em>' containment reference.
	 * @see #getPropagation()
	 * @generated
	 */
  void setPropagation(ErrorPropagations value);

  /**
	 * Returns the value of the '<em><b>Component Behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Component Behavior</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Behavior</em>' containment reference.
	 * @see #setComponentBehavior(ComponentErrorBehavior)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_ComponentBehavior()
	 * @model containment="true"
	 * @generated
	 */
  ComponentErrorBehavior getComponentBehavior();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getComponentBehavior <em>Component Behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Behavior</em>' containment reference.
	 * @see #getComponentBehavior()
	 * @generated
	 */
  void setComponentBehavior(ComponentErrorBehavior value);

  /**
	 * Returns the value of the '<em><b>Composite Behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Composite Behavior</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite Behavior</em>' containment reference.
	 * @see #setCompositeBehavior(CompositeErrorBehavior)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_CompositeBehavior()
	 * @model containment="true"
	 * @generated
	 */
  CompositeErrorBehavior getCompositeBehavior();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getCompositeBehavior <em>Composite Behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite Behavior</em>' containment reference.
	 * @see #getCompositeBehavior()
	 * @generated
	 */
  void setCompositeBehavior(CompositeErrorBehavior value);

  /**
	 * Returns the value of the '<em><b>Observable Propagation Connections</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Observable Propagation Connections</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Observable Propagation Connections</em>' containment reference.
	 * @see #setObservablePropagationConnections(ObservablePropagationConnections)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_ObservablePropagationConnections()
	 * @model containment="true"
	 * @generated
	 */
  ObservablePropagationConnections getObservablePropagationConnections();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getObservablePropagationConnections <em>Observable Propagation Connections</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Observable Propagation Connections</em>' containment reference.
	 * @see #getObservablePropagationConnections()
	 * @generated
	 */
  void setObservablePropagationConnections(ObservablePropagationConnections value);

  /**
	 * Returns the value of the '<em><b>Connection Transformation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connection Transformation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Transformation</em>' containment reference.
	 * @see #setConnectionTransformation(ConnectionTransformation)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_ConnectionTransformation()
	 * @model containment="true"
	 * @generated
	 */
  ConnectionTransformation getConnectionTransformation();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getConnectionTransformation <em>Connection Transformation</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Transformation</em>' containment reference.
	 * @see #getConnectionTransformation()
	 * @generated
	 */
  void setConnectionTransformation(ConnectionTransformation value);

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
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_Properties()
	 * @model containment="true"
	 * @generated
	 */
  EList<PropertyAssociation> getProperties();

} // ErrorModelSubclause
