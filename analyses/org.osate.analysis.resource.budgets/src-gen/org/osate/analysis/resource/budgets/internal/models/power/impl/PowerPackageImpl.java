/**
 * Copyright Text	Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file)....
 */
package org.osate.analysis.resource.budgets.internal.models.power.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.analysis.model.ModelPackage;
import org.osate.analysis.resource.budgets.internal.models.power.PowerConsumer;
import org.osate.analysis.resource.budgets.internal.models.power.PowerElement;
import org.osate.analysis.resource.budgets.internal.models.power.PowerFactory;
import org.osate.analysis.resource.budgets.internal.models.power.PowerModel;
import org.osate.analysis.resource.budgets.internal.models.power.PowerPackage;
import org.osate.analysis.resource.budgets.internal.models.power.PowerSupplier;
import org.osate.analysis.resource.budgets.internal.models.power.PowerTransmissionSystem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 * @since 4.1
 */
public class PowerPackageImpl extends EPackageImpl implements PowerPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass powerElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass powerTransmissionSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass powerSupplierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass powerConsumerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass powerModelEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PowerPackageImpl() {
		super(eNS_URI, PowerFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link PowerPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PowerPackage init() {
		if (isInited) {
			return (PowerPackage)EPackage.Registry.INSTANCE.getEPackage(PowerPackage.eNS_URI);
		}

		// Obtain or create and register package
		Object registeredPowerPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		PowerPackageImpl thePowerPackage = registeredPowerPackage instanceof PowerPackageImpl ? (PowerPackageImpl)registeredPowerPackage : new PowerPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		Aadl2Package.eINSTANCE.eClass();
		ModelPackage.eINSTANCE.eClass();
		InstancePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thePowerPackage.createPackageContents();

		// Initialize created meta-data
		thePowerPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePowerPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PowerPackage.eNS_URI, thePowerPackage);
		return thePowerPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPowerElement() {
		return powerElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPowerElement_Capacity() {
		return (EAttribute)powerElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPowerElement_Budget() {
		return (EAttribute)powerElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPowerElement_Supply() {
		return (EAttribute)powerElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPowerTransmissionSystem() {
		return powerTransmissionSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPowerTransmissionSystem_ComponentInstance() {
		return (EReference)powerTransmissionSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPowerTransmissionSystem_Suppliers() {
		return (EReference)powerTransmissionSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPowerTransmissionSystem_Consumers() {
		return (EReference)powerTransmissionSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPowerSupplier() {
		return powerSupplierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPowerSupplier_FeatureInstance() {
		return (EReference)powerSupplierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPowerConsumer() {
		return powerConsumerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPowerConsumer_FeatureInstance() {
		return (EReference)powerConsumerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPowerModel() {
		return powerModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPowerModel_RootPowerTransmissionSystem() {
		return (EReference)powerModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PowerFactory getPowerFactory() {
		return (PowerFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) {
			return;
		}
		isCreated = true;

		// Create classes and their features
		powerElementEClass = createEClass(POWER_ELEMENT);
		createEAttribute(powerElementEClass, POWER_ELEMENT__CAPACITY);
		createEAttribute(powerElementEClass, POWER_ELEMENT__BUDGET);
		createEAttribute(powerElementEClass, POWER_ELEMENT__SUPPLY);

		powerTransmissionSystemEClass = createEClass(POWER_TRANSMISSION_SYSTEM);
		createEReference(powerTransmissionSystemEClass, POWER_TRANSMISSION_SYSTEM__COMPONENT_INSTANCE);
		createEReference(powerTransmissionSystemEClass, POWER_TRANSMISSION_SYSTEM__SUPPLIERS);
		createEReference(powerTransmissionSystemEClass, POWER_TRANSMISSION_SYSTEM__CONSUMERS);

		powerSupplierEClass = createEClass(POWER_SUPPLIER);
		createEReference(powerSupplierEClass, POWER_SUPPLIER__FEATURE_INSTANCE);

		powerConsumerEClass = createEClass(POWER_CONSUMER);
		createEReference(powerConsumerEClass, POWER_CONSUMER__FEATURE_INSTANCE);

		powerModelEClass = createEClass(POWER_MODEL);
		createEReference(powerModelEClass, POWER_MODEL__ROOT_POWER_TRANSMISSION_SYSTEM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) {
			return;
		}
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
		InstancePackage theInstancePackage = (InstancePackage)EPackage.Registry.INSTANCE.getEPackage(InstancePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		powerElementEClass.getESuperTypes().add(theModelPackage.getAnalysisElement());
		powerTransmissionSystemEClass.getESuperTypes().add(this.getPowerElement());
		powerSupplierEClass.getESuperTypes().add(this.getPowerElement());
		powerConsumerEClass.getESuperTypes().add(this.getPowerElement());
		powerModelEClass.getESuperTypes().add(theModelPackage.getAnalysisElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(powerElementEClass, PowerElement.class, "PowerElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPowerElement_Capacity(), ecorePackage.getEDouble(), "capacity", null, 0, 1, PowerElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPowerElement_Budget(), ecorePackage.getEDouble(), "budget", null, 0, 1, PowerElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPowerElement_Supply(), ecorePackage.getEDouble(), "supply", null, 0, 1, PowerElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(powerTransmissionSystemEClass, PowerTransmissionSystem.class, "PowerTransmissionSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPowerTransmissionSystem_ComponentInstance(), theInstancePackage.getComponentInstance(), null, "ComponentInstance", null, 0, 1, PowerTransmissionSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPowerTransmissionSystem_Suppliers(), this.getPowerSupplier(), null, "suppliers", null, 0, -1, PowerTransmissionSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPowerTransmissionSystem_Consumers(), this.getPowerConsumer(), null, "consumers", null, 0, -1, PowerTransmissionSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(powerSupplierEClass, PowerSupplier.class, "PowerSupplier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPowerSupplier_FeatureInstance(), theInstancePackage.getFeatureInstance(), null, "FeatureInstance", null, 0, 1, PowerSupplier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(powerConsumerEClass, PowerConsumer.class, "PowerConsumer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPowerConsumer_FeatureInstance(), theInstancePackage.getFeatureInstance(), null, "FeatureInstance", null, 0, 1, PowerConsumer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(powerModelEClass, PowerModel.class, "PowerModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPowerModel_RootPowerTransmissionSystem(), this.getPowerTransmissionSystem(), null, "rootPowerTransmissionSystem", null, 0, -1, PowerModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //PowerPackageImpl
