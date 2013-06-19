/**
 */
package org.osate.xtext.aadl2.errormodel.errorModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Propagation Paths</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationPaths#getPoints <em>Points</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationPaths#getConnections <em>Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getPropagationPaths()
 * @model
 * @generated
 */
public interface PropagationPaths extends EObject, Element
{
  /**
	 * Returns the value of the '<em><b>Points</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Points</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Points</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getPropagationPaths_Points()
	 * @model containment="true"
	 * @generated
	 */
  EList<PropagationPoint> getPoints();

  /**
	 * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.errorModel.PropagationPointConnection}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connections</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage#getPropagationPaths_Connections()
	 * @model containment="true"
	 * @generated
	 */
  EList<PropagationPointConnection> getConnections();

} // PropagationPaths
