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
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getErrorPropagations <em>Error Propagations</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getComponentBehavior <em>Component Behavior</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getCompositeBehavior <em>Composite Behavior</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getConnectionBehavior <em>Connection Behavior</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getPropagationPaths <em>Propagation Paths</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause()
 * @model
 * @generated
 */
public interface ErrorModelSubclause extends AnnexSubclause, TypeUseContext
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
   * Returns the value of the '<em><b>Error Propagations</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Error Propagations</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Error Propagations</em>' containment reference.
   * @see #setErrorPropagations(ErrorPropagations)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_ErrorPropagations()
   * @model containment="true"
   * @generated
   */
  ErrorPropagations getErrorPropagations();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getErrorPropagations <em>Error Propagations</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Error Propagations</em>' containment reference.
   * @see #getErrorPropagations()
   * @generated
   */
  void setErrorPropagations(ErrorPropagations value);

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
   * Returns the value of the '<em><b>Connection Behavior</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connection Behavior</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Connection Behavior</em>' containment reference.
   * @see #setConnectionBehavior(ConnectionErrorBehavior)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_ConnectionBehavior()
   * @model containment="true"
   * @generated
   */
  ConnectionErrorBehavior getConnectionBehavior();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getConnectionBehavior <em>Connection Behavior</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Connection Behavior</em>' containment reference.
   * @see #getConnectionBehavior()
   * @generated
   */
  void setConnectionBehavior(ConnectionErrorBehavior value);

  /**
   * Returns the value of the '<em><b>Propagation Paths</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Propagation Paths</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Propagation Paths</em>' containment reference.
   * @see #setPropagationPaths(PropagationPaths)
   * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getErrorModelSubclause_PropagationPaths()
   * @model containment="true"
   * @generated
   */
  PropagationPaths getPropagationPaths();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause#getPropagationPaths <em>Propagation Paths</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Propagation Paths</em>' containment reference.
   * @see #getPropagationPaths()
   * @generated
   */
  void setPropagationPaths(PropagationPaths value);

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
