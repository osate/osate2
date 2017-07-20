/**
 */
package org.osate.aadl2.errormodel.PropagationGraph;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Propagation Path End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#getInstanceObject <em>Instance Object</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#getErrorPropagation <em>Error Propagation</em>}</li>
 *   <li>{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#getComponentInstance <em>Component Instance</em>}</li>
 * </ul>
 *
 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationPathEnd()
 * @model
 * @generated
 */
public interface PropagationPathEnd extends EObject {
	/**
	 * Returns the value of the '<em><b>Instance Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Object</em>' reference.
	 * @see #setInstanceObject(InstanceObject)
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationPathEnd_InstanceObject()
	 * @model
	 * @generated
	 */
	InstanceObject getInstanceObject();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#getInstanceObject <em>Instance Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Object</em>' reference.
	 * @see #getInstanceObject()
	 * @generated
	 */
	void setInstanceObject(InstanceObject value);

	/**
	 * Returns the value of the '<em><b>Error Propagation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Propagation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Propagation</em>' reference.
	 * @see #setErrorPropagation(ErrorPropagation)
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationPathEnd_ErrorPropagation()
	 * @model
	 * @generated
	 */
	ErrorPropagation getErrorPropagation();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#getErrorPropagation <em>Error Propagation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Propagation</em>' reference.
	 * @see #getErrorPropagation()
	 * @generated
	 */
	void setErrorPropagation(ErrorPropagation value);

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
	 * @see org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPackage#getPropagationPathEnd_ComponentInstance()
	 * @model
	 * @generated
	 */
	ComponentInstance getComponentInstance();

	/**
	 * Sets the value of the '{@link org.osate.aadl2.errormodel.PropagationGraph.PropagationPathEnd#getComponentInstance <em>Component Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Instance</em>' reference.
	 * @see #getComponentInstance()
	 * @generated
	 */
	void setComponentInstance(ComponentInstance value);

} // PropagationPathEnd
