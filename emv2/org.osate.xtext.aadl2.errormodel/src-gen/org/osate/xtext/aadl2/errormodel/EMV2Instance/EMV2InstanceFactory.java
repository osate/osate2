/**
 */
package org.osate.xtext.aadl2.errormodel.EMV2Instance;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage
 * @generated
 */
public interface EMV2InstanceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EMV2InstanceFactory eINSTANCE = org.osate.xtext.aadl2.errormodel.EMV2Instance.impl.EMV2InstanceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>EMV2 Annex Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EMV2 Annex Instance</em>'.
	 * @generated
	 */
	EMV2AnnexInstance createEMV2AnnexInstance();

	/**
	 * Returns a new object of class '<em>State Variable Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Variable Instance</em>'.
	 * @generated
	 */
	StateVariableInstance createStateVariableInstance();

	/**
	 * Returns a new object of class '<em>State Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Instance</em>'.
	 * @generated
	 */
	StateInstance createStateInstance();

	/**
	 * Returns a new object of class '<em>Constrained Instance Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constrained Instance Object</em>'.
	 * @generated
	 */
	ConstrainedInstanceObject createConstrainedInstanceObject();

	/**
	 * Returns a new object of class '<em>State Transition Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Transition Instance</em>'.
	 * @generated
	 */
	StateTransitionInstance createStateTransitionInstance();

	/**
	 * Returns a new object of class '<em>State Synchronization Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Synchronization Instance</em>'.
	 * @generated
	 */
	StateSynchronizationInstance createStateSynchronizationInstance();

	/**
	 * Returns a new object of class '<em>Behavior Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior Instance</em>'.
	 * @generated
	 */
	BehaviorInstance createBehaviorInstance();

	/**
	 * Returns a new object of class '<em>Type Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Reference</em>'.
	 * @generated
	 */
	TypeReference createTypeReference();

	/**
	 * Returns a new object of class '<em>ECollection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ECollection</em>'.
	 * @generated
	 */
	ECollection createECollection();

	/**
	 * Returns a new object of class '<em>Multi Literal Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Literal Constraint</em>'.
	 * @generated
	 */
	MultiLiteralConstraint createMultiLiteralConstraint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EMV2InstancePackage getEMV2InstancePackage();

} //EMV2InstanceFactory
