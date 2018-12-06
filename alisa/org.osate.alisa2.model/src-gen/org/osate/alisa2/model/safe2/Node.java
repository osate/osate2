/**
 */
package org.osate.alisa2.model.safe2;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa2.model.safe2.Node#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa2.model.safe2.Safe2Package#getNode()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Node extends EObject {
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
	 * @see org.osate.alisa2.model.safe2.Safe2Package#getNode_Name()
	 * @model dataType="org.osate.aadl2.String" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.osate.alisa2.model.safe2.Node#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Node
