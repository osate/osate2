/**
 * <copyright>
 * </copyright>
 *
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Observable Propagation Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ObservablePropagationConnection#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ObservablePropagationConnection#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getObservablePropagationConnection()
 * @model
 * @generated
 */
public interface ObservablePropagationConnection extends EObject, NamedElement
{
  /**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(QualifiedObservableErrorPropagationPoint)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getObservablePropagationConnection_Source()
	 * @model containment="true"
	 * @generated
	 */
  QualifiedObservableErrorPropagationPoint getSource();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ObservablePropagationConnection#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
  void setSource(QualifiedObservableErrorPropagationPoint value);

  /**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(QualifiedObservableErrorPropagationPoint)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getObservablePropagationConnection_Target()
	 * @model containment="true"
	 * @generated
	 */
  QualifiedObservableErrorPropagationPoint getTarget();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.ObservablePropagationConnection#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
  void setTarget(QualifiedObservableErrorPropagationPoint value);

} // ObservablePropagationConnection
