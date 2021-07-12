/**
 * Copyright Text	Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file)....
 */
package org.osate.analysis.resource.budgets.internal.models.power;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerPackage
 * @generated
 * @since 4.1
 */
public interface PowerFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PowerFactory eINSTANCE = org.osate.analysis.resource.budgets.internal.models.power.impl.PowerFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Transmission System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transmission System</em>'.
	 * @generated
	 */
	PowerTransmissionSystem createPowerTransmissionSystem();

	/**
	 * Returns a new object of class '<em>Supplier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Supplier</em>'.
	 * @generated
	 */
	PowerSupplier createPowerSupplier();

	/**
	 * Returns a new object of class '<em>Consumer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Consumer</em>'.
	 * @generated
	 */
	PowerConsumer createPowerConsumer();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	PowerModel createPowerModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PowerPackage getPowerPackage();

} //PowerFactory
