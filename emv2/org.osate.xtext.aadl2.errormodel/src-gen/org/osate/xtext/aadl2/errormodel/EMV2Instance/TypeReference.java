/**
 */
package org.osate.xtext.aadl2.errormodel.EMV2Instance;

import org.eclipse.emf.ecore.EObject;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.TypeReference#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getTypeReference()
 * @model
 * @generated
 */
public interface TypeReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(ErrorTypes)
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getTypeReference_Type()
	 * @model
	 * @generated
	 */
	ErrorTypes getType();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.TypeReference#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(ErrorTypes value);

} // TypeReference
