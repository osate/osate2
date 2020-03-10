/**
 */
package org.osate.xtext.aadl2.errormodel.EMV2Instance;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Variable Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateVariableInstance#getStates <em>States</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateVariableInstance#getCurrentState <em>Current State</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getStateVariableInstance()
 * @model
 * @generated
 */
public interface StateVariableInstance extends EMV2InstanceObject {
	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateInstance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getStateVariableInstance_States()
	 * @model containment="true"
	 * @generated
	 */
	EList<StateInstance> getStates();

	/**
	 * Returns the value of the '<em><b>Current State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current State</em>' reference.
	 * @see #setCurrentState(StateInstance)
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getStateVariableInstance_CurrentState()
	 * @model
	 * @generated
	 */
	StateInstance getCurrentState();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateVariableInstance#getCurrentState <em>Current State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current State</em>' reference.
	 * @see #getCurrentState()
	 * @generated
	 */
	void setCurrentState(StateInstance value);

} // StateVariableInstance
