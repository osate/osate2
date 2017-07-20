/**
 */
package org.osate.aadl2.errormodel.PropagationGraph;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.instance.ComponentInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Propagation Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationNode#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationNode#isHighlight <em>Highlight</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationNode#getComponentInstance <em>Component Instance</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationNode()
 * @model
 * @generated
 */
public interface PropagationNode extends EObject {
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
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationNode_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Highlight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Highlight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Highlight</em>' attribute.
	 * @see #setHighlight(boolean)
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationNode_Highlight()
	 * @model
	 * @generated
	 */
	boolean isHighlight();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationNode#isHighlight <em>Highlight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Highlight</em>' attribute.
	 * @see #isHighlight()
	 * @generated
	 */
	void setHighlight(boolean value);

	/**
	 * Returns the value of the '<em><b>Component Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Instance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Instance</em>' reference.
	 * @see #setComponentInstance(ComponentInstance)
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationNode_ComponentInstance()
	 * @model
	 * @generated
	 */
	ComponentInstance getComponentInstance();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationNode#getComponentInstance <em>Component Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Instance</em>' reference.
	 * @see #getComponentInstance()
	 * @generated
	 */
	void setComponentInstance(ComponentInstance value);

} // PropagationNode
