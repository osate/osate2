/**
 * Copyright Text	Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file)....
 */
package org.osate.analysis.resource.budgets.internal.models.power.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.osate.analysis.resource.budgets.internal.models.power.PowerConsumer;
import org.osate.analysis.resource.budgets.internal.models.power.PowerFactory;
import org.osate.analysis.resource.budgets.internal.models.power.PowerModel;
import org.osate.analysis.resource.budgets.internal.models.power.PowerPackage;
import org.osate.analysis.resource.budgets.internal.models.power.PowerSupplier;
import org.osate.analysis.resource.budgets.internal.models.power.PowerTransmissionSystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 * @since 4.1
 */
public class PowerFactoryImpl extends EFactoryImpl implements PowerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PowerFactory init() {
		try {
			PowerFactory thePowerFactory = (PowerFactory)EPackage.Registry.INSTANCE.getEFactory(PowerPackage.eNS_URI);
			if (thePowerFactory != null) {
				return thePowerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PowerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PowerPackage.POWER_TRANSMISSION_SYSTEM: return createPowerTransmissionSystem();
			case PowerPackage.POWER_SUPPLIER: return createPowerSupplier();
			case PowerPackage.POWER_CONSUMER: return createPowerConsumer();
			case PowerPackage.POWER_MODEL: return createPowerModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PowerTransmissionSystem createPowerTransmissionSystem() {
		PowerTransmissionSystemImpl powerTransmissionSystem = new PowerTransmissionSystemImpl();
		return powerTransmissionSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PowerSupplier createPowerSupplier() {
		PowerSupplierImpl powerSupplier = new PowerSupplierImpl();
		return powerSupplier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PowerConsumer createPowerConsumer() {
		PowerConsumerImpl powerConsumer = new PowerConsumerImpl();
		return powerConsumer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PowerModel createPowerModel() {
		PowerModelImpl powerModel = new PowerModelImpl();
		return powerModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PowerPackage getPowerPackage() {
		return (PowerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PowerPackage getPackage() {
		return PowerPackage.eINSTANCE;
	}

} //PowerFactoryImpl
