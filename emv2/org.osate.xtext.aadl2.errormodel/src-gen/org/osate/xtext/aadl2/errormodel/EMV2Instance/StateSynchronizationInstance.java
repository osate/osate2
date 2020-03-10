/**
 */
package org.osate.xtext.aadl2.errormodel.EMV2Instance;

import org.osate.xtext.aadl2.errormodel.errorModel.CompositeState;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Synchronization Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateSynchronizationInstance#getTargetState <em>Target State</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateSynchronizationInstance#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateSynchronizationInstance#getStateSynchronization <em>State Synchronization</em>}</li>
 * </ul>
 *
 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getStateSynchronizationInstance()
 * @model
 * @generated
 */
public interface StateSynchronizationInstance extends EMV2InstanceObject {
	/**
	 * Returns the value of the '<em><b>Target State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target State</em>' reference.
	 * @see #setTargetState(StateInstance)
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getStateSynchronizationInstance_TargetState()
	 * @model
	 * @generated
	 */
	StateInstance getTargetState();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateSynchronizationInstance#getTargetState <em>Target State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target State</em>' reference.
	 * @see #getTargetState()
	 * @generated
	 */
	void setTargetState(StateInstance value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Literal)
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getStateSynchronizationInstance_Condition()
	 * @model containment="true"
	 * @generated
	 */
	Literal getCondition();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateSynchronizationInstance#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Literal value);

	/**
	 * Returns the value of the '<em><b>State Synchronization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Synchronization</em>' reference.
	 * @see #setStateSynchronization(CompositeState)
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#getStateSynchronizationInstance_StateSynchronization()
	 * @model
	 * @generated
	 */
	CompositeState getStateSynchronization();

	/**
	 * Sets the value of the '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateSynchronizationInstance#getStateSynchronization <em>State Synchronization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Synchronization</em>' reference.
	 * @see #getStateSynchronization()
	 * @generated
	 */
	void setStateSynchronization(CompositeState value);

} // StateSynchronizationInstance
