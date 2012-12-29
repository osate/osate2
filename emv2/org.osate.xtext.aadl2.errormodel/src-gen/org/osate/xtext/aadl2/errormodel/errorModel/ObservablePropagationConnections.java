/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Observable Propagation Connections</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.ObservablePropagationConnections#getConnection <em>Connection</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getObservablePropagationConnections()
 * @model
 * @generated
 */
public interface ObservablePropagationConnections extends EObject, Element
{
  /**
	 * Returns the value of the '<em><b>Connection</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.ObservablePropagationConnection}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connection</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getObservablePropagationConnections_Connection()
	 * @model containment="true"
	 * @generated
	 */
  EList<ObservablePropagationConnection> getConnection();

} // ObservablePropagationConnections
