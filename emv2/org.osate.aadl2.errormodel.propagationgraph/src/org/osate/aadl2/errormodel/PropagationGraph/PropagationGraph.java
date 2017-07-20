/**
 */
package org.osate.aadl2.errormodel.PropagationGraph;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.instance.ComponentInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Propagation Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getDescription <em>Description</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getComponents <em>Components</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getPropagationPaths <em>Propagation Paths</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getNodes <em>Nodes</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationGraph()
 * @model
 * @generated
 */
public interface PropagationGraph extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationGraph_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationGraph_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Components</b></em>' reference list.
	 * The list contents are of type {@link org.osate.aadl2.instance.ComponentInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' reference list.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationGraph_Components()
	 * @model
	 * @generated
	 */
	EList<ComponentInstance> getComponents();

	/**
	 * Returns the value of the '<em><b>Propagation Paths</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPath}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Propagation Paths</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Propagation Paths</em>' containment reference list.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationGraph_PropagationPaths()
	 * @model containment="true"
	 * @generated
	 */
	EList<PropagationPath> getPropagationPaths();

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.aadl2.errormodel.PropagationGraph.PropagationNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationGraph_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<PropagationNode> getNodes();

} // PropagationGraph
