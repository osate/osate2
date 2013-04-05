/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Propagation Point Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationPointConnection#getSource <em>Source</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationPointConnection#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getPropagationPointConnection()
 * @model
 * @generated
 */
public interface PropagationPointConnection extends EObject, NamedElement
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
	 * @see #setSource(QualifiedPropagationPoint)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getPropagationPointConnection_Source()
	 * @model containment="true"
	 * @generated
	 */
  QualifiedPropagationPoint getSource();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationPointConnection#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
  void setSource(QualifiedPropagationPoint value);

  /**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(QualifiedPropagationPoint)
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getPropagationPointConnection_Target()
	 * @model containment="true"
	 * @generated
	 */
  QualifiedPropagationPoint getTarget();

  /**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationPointConnection#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
  void setTarget(QualifiedPropagationPoint value);

} // PropagationPointConnection
