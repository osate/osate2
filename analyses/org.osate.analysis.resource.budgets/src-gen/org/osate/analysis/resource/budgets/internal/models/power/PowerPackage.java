/**
 * Copyright Text	Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file)....
 */
package org.osate.analysis.resource.budgets.internal.models.power;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.osate.analysis.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerFactory
 * @model kind="package"
 * @generated
 * @since 4.1
 */
public interface PowerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "power";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://osate.org/analysis/power";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "power";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PowerPackage eINSTANCE = org.osate.analysis.resource.budgets.internal.models.power.impl.PowerPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.osate.analysis.resource.budgets.internal.models.power.impl.PowerElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.resource.budgets.internal.models.power.impl.PowerElementImpl
	 * @see org.osate.analysis.resource.budgets.internal.models.power.impl.PowerPackageImpl#getPowerElement()
	 * @generated
	 */
	int POWER_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_ELEMENT__CAPACITY = ModelPackage.ANALYSIS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Budget</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_ELEMENT__BUDGET = ModelPackage.ANALYSIS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Supply</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_ELEMENT__SUPPLY = ModelPackage.ANALYSIS_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_ELEMENT_FEATURE_COUNT = ModelPackage.ANALYSIS_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Leaf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_ELEMENT___IS_LEAF = ModelPackage.ANALYSIS_ELEMENT___IS_LEAF;

	/**
	 * The operation id for the '<em>Get Ordered Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_ELEMENT___GET_ORDERED_CHILDREN = ModelPackage.ANALYSIS_ELEMENT___GET_ORDERED_CHILDREN;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_ELEMENT_OPERATION_COUNT = ModelPackage.ANALYSIS_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.analysis.resource.budgets.internal.models.power.impl.PowerTransmissionSystemImpl <em>Transmission System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.resource.budgets.internal.models.power.impl.PowerTransmissionSystemImpl
	 * @see org.osate.analysis.resource.budgets.internal.models.power.impl.PowerPackageImpl#getPowerTransmissionSystem()
	 * @generated
	 */
	int POWER_TRANSMISSION_SYSTEM = 1;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSMISSION_SYSTEM__CAPACITY = POWER_ELEMENT__CAPACITY;

	/**
	 * The feature id for the '<em><b>Budget</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSMISSION_SYSTEM__BUDGET = POWER_ELEMENT__BUDGET;

	/**
	 * The feature id for the '<em><b>Supply</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSMISSION_SYSTEM__SUPPLY = POWER_ELEMENT__SUPPLY;

	/**
	 * The feature id for the '<em><b>Component Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSMISSION_SYSTEM__COMPONENT_INSTANCE = POWER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Suppliers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSMISSION_SYSTEM__SUPPLIERS = POWER_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Consumers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSMISSION_SYSTEM__CONSUMERS = POWER_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Transmission System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSMISSION_SYSTEM_FEATURE_COUNT = POWER_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Is Leaf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSMISSION_SYSTEM___IS_LEAF = POWER_ELEMENT___IS_LEAF;

	/**
	 * The operation id for the '<em>Get Ordered Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSMISSION_SYSTEM___GET_ORDERED_CHILDREN = POWER_ELEMENT___GET_ORDERED_CHILDREN;

	/**
	 * The number of operations of the '<em>Transmission System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_TRANSMISSION_SYSTEM_OPERATION_COUNT = POWER_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.analysis.resource.budgets.internal.models.power.impl.PowerSupplierImpl <em>Supplier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.resource.budgets.internal.models.power.impl.PowerSupplierImpl
	 * @see org.osate.analysis.resource.budgets.internal.models.power.impl.PowerPackageImpl#getPowerSupplier()
	 * @generated
	 */
	int POWER_SUPPLIER = 2;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLIER__CAPACITY = POWER_ELEMENT__CAPACITY;

	/**
	 * The feature id for the '<em><b>Budget</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLIER__BUDGET = POWER_ELEMENT__BUDGET;

	/**
	 * The feature id for the '<em><b>Supply</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLIER__SUPPLY = POWER_ELEMENT__SUPPLY;

	/**
	 * The feature id for the '<em><b>Feature Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLIER__FEATURE_INSTANCE = POWER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Supplier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLIER_FEATURE_COUNT = POWER_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Leaf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLIER___IS_LEAF = POWER_ELEMENT___IS_LEAF;

	/**
	 * The operation id for the '<em>Get Ordered Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLIER___GET_ORDERED_CHILDREN = POWER_ELEMENT___GET_ORDERED_CHILDREN;

	/**
	 * The number of operations of the '<em>Supplier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_SUPPLIER_OPERATION_COUNT = POWER_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.analysis.resource.budgets.internal.models.power.impl.PowerConsumerImpl <em>Consumer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.resource.budgets.internal.models.power.impl.PowerConsumerImpl
	 * @see org.osate.analysis.resource.budgets.internal.models.power.impl.PowerPackageImpl#getPowerConsumer()
	 * @generated
	 */
	int POWER_CONSUMER = 3;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_CONSUMER__CAPACITY = POWER_ELEMENT__CAPACITY;

	/**
	 * The feature id for the '<em><b>Budget</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_CONSUMER__BUDGET = POWER_ELEMENT__BUDGET;

	/**
	 * The feature id for the '<em><b>Supply</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_CONSUMER__SUPPLY = POWER_ELEMENT__SUPPLY;

	/**
	 * The feature id for the '<em><b>Feature Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_CONSUMER__FEATURE_INSTANCE = POWER_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Consumer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_CONSUMER_FEATURE_COUNT = POWER_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Leaf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_CONSUMER___IS_LEAF = POWER_ELEMENT___IS_LEAF;

	/**
	 * The operation id for the '<em>Get Ordered Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_CONSUMER___GET_ORDERED_CHILDREN = POWER_ELEMENT___GET_ORDERED_CHILDREN;

	/**
	 * The number of operations of the '<em>Consumer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_CONSUMER_OPERATION_COUNT = POWER_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.osate.analysis.resource.budgets.internal.models.power.impl.PowerModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.osate.analysis.resource.budgets.internal.models.power.impl.PowerModelImpl
	 * @see org.osate.analysis.resource.budgets.internal.models.power.impl.PowerPackageImpl#getPowerModel()
	 * @generated
	 */
	int POWER_MODEL = 4;

	/**
	 * The feature id for the '<em><b>Root Power Transmission System</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_MODEL__ROOT_POWER_TRANSMISSION_SYSTEM = ModelPackage.ANALYSIS_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_MODEL_FEATURE_COUNT = ModelPackage.ANALYSIS_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Is Leaf</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_MODEL___IS_LEAF = ModelPackage.ANALYSIS_ELEMENT___IS_LEAF;

	/**
	 * The operation id for the '<em>Get Ordered Children</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_MODEL___GET_ORDERED_CHILDREN = ModelPackage.ANALYSIS_ELEMENT___GET_ORDERED_CHILDREN;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_MODEL_OPERATION_COUNT = ModelPackage.ANALYSIS_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerElement
	 * @generated
	 */
	EClass getPowerElement();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerElement#getCapacity <em>Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capacity</em>'.
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerElement#getCapacity()
	 * @see #getPowerElement()
	 * @generated
	 */
	EAttribute getPowerElement_Capacity();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerElement#getBudget <em>Budget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Budget</em>'.
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerElement#getBudget()
	 * @see #getPowerElement()
	 * @generated
	 */
	EAttribute getPowerElement_Budget();

	/**
	 * Returns the meta object for the attribute '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerElement#getSupply <em>Supply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Supply</em>'.
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerElement#getSupply()
	 * @see #getPowerElement()
	 * @generated
	 */
	EAttribute getPowerElement_Supply();

	/**
	 * Returns the meta object for class '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerTransmissionSystem <em>Transmission System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transmission System</em>'.
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerTransmissionSystem
	 * @generated
	 */
	EClass getPowerTransmissionSystem();

	/**
	 * Returns the meta object for the reference '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerTransmissionSystem#getComponentInstance <em>Component Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component Instance</em>'.
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerTransmissionSystem#getComponentInstance()
	 * @see #getPowerTransmissionSystem()
	 * @generated
	 */
	EReference getPowerTransmissionSystem_ComponentInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerTransmissionSystem#getSuppliers <em>Suppliers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Suppliers</em>'.
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerTransmissionSystem#getSuppliers()
	 * @see #getPowerTransmissionSystem()
	 * @generated
	 */
	EReference getPowerTransmissionSystem_Suppliers();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerTransmissionSystem#getConsumers <em>Consumers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Consumers</em>'.
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerTransmissionSystem#getConsumers()
	 * @see #getPowerTransmissionSystem()
	 * @generated
	 */
	EReference getPowerTransmissionSystem_Consumers();

	/**
	 * Returns the meta object for class '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerSupplier <em>Supplier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Supplier</em>'.
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerSupplier
	 * @generated
	 */
	EClass getPowerSupplier();

	/**
	 * Returns the meta object for the reference '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerSupplier#getFeatureInstance <em>Feature Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature Instance</em>'.
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerSupplier#getFeatureInstance()
	 * @see #getPowerSupplier()
	 * @generated
	 */
	EReference getPowerSupplier_FeatureInstance();

	/**
	 * Returns the meta object for class '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerConsumer <em>Consumer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Consumer</em>'.
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerConsumer
	 * @generated
	 */
	EClass getPowerConsumer();

	/**
	 * Returns the meta object for the reference '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerConsumer#getFeatureInstance <em>Feature Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature Instance</em>'.
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerConsumer#getFeatureInstance()
	 * @see #getPowerConsumer()
	 * @generated
	 */
	EReference getPowerConsumer_FeatureInstance();

	/**
	 * Returns the meta object for class '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerModel
	 * @generated
	 */
	EClass getPowerModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerModel#getRootPowerTransmissionSystem <em>Root Power Transmission System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Root Power Transmission System</em>'.
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerModel#getRootPowerTransmissionSystem()
	 * @see #getPowerModel()
	 * @generated
	 */
	EReference getPowerModel_RootPowerTransmissionSystem();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PowerFactory getPowerFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.osate.analysis.resource.budgets.internal.models.power.impl.PowerElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.resource.budgets.internal.models.power.impl.PowerElementImpl
		 * @see org.osate.analysis.resource.budgets.internal.models.power.impl.PowerPackageImpl#getPowerElement()
		 * @generated
		 */
		EClass POWER_ELEMENT = eINSTANCE.getPowerElement();

		/**
		 * The meta object literal for the '<em><b>Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POWER_ELEMENT__CAPACITY = eINSTANCE.getPowerElement_Capacity();

		/**
		 * The meta object literal for the '<em><b>Budget</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POWER_ELEMENT__BUDGET = eINSTANCE.getPowerElement_Budget();

		/**
		 * The meta object literal for the '<em><b>Supply</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POWER_ELEMENT__SUPPLY = eINSTANCE.getPowerElement_Supply();

		/**
		 * The meta object literal for the '{@link org.osate.analysis.resource.budgets.internal.models.power.impl.PowerTransmissionSystemImpl <em>Transmission System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.resource.budgets.internal.models.power.impl.PowerTransmissionSystemImpl
		 * @see org.osate.analysis.resource.budgets.internal.models.power.impl.PowerPackageImpl#getPowerTransmissionSystem()
		 * @generated
		 */
		EClass POWER_TRANSMISSION_SYSTEM = eINSTANCE.getPowerTransmissionSystem();

		/**
		 * The meta object literal for the '<em><b>Component Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POWER_TRANSMISSION_SYSTEM__COMPONENT_INSTANCE = eINSTANCE.getPowerTransmissionSystem_ComponentInstance();

		/**
		 * The meta object literal for the '<em><b>Suppliers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POWER_TRANSMISSION_SYSTEM__SUPPLIERS = eINSTANCE.getPowerTransmissionSystem_Suppliers();

		/**
		 * The meta object literal for the '<em><b>Consumers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POWER_TRANSMISSION_SYSTEM__CONSUMERS = eINSTANCE.getPowerTransmissionSystem_Consumers();

		/**
		 * The meta object literal for the '{@link org.osate.analysis.resource.budgets.internal.models.power.impl.PowerSupplierImpl <em>Supplier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.resource.budgets.internal.models.power.impl.PowerSupplierImpl
		 * @see org.osate.analysis.resource.budgets.internal.models.power.impl.PowerPackageImpl#getPowerSupplier()
		 * @generated
		 */
		EClass POWER_SUPPLIER = eINSTANCE.getPowerSupplier();

		/**
		 * The meta object literal for the '<em><b>Feature Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POWER_SUPPLIER__FEATURE_INSTANCE = eINSTANCE.getPowerSupplier_FeatureInstance();

		/**
		 * The meta object literal for the '{@link org.osate.analysis.resource.budgets.internal.models.power.impl.PowerConsumerImpl <em>Consumer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.resource.budgets.internal.models.power.impl.PowerConsumerImpl
		 * @see org.osate.analysis.resource.budgets.internal.models.power.impl.PowerPackageImpl#getPowerConsumer()
		 * @generated
		 */
		EClass POWER_CONSUMER = eINSTANCE.getPowerConsumer();

		/**
		 * The meta object literal for the '<em><b>Feature Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POWER_CONSUMER__FEATURE_INSTANCE = eINSTANCE.getPowerConsumer_FeatureInstance();

		/**
		 * The meta object literal for the '{@link org.osate.analysis.resource.budgets.internal.models.power.impl.PowerModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.osate.analysis.resource.budgets.internal.models.power.impl.PowerModelImpl
		 * @see org.osate.analysis.resource.budgets.internal.models.power.impl.PowerPackageImpl#getPowerModel()
		 * @generated
		 */
		EClass POWER_MODEL = eINSTANCE.getPowerModel();

		/**
		 * The meta object literal for the '<em><b>Root Power Transmission System</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POWER_MODEL__ROOT_POWER_TRANSMISSION_SYSTEM = eINSTANCE.getPowerModel_RootPowerTransmissionSystem();

	}

} //PowerPackage
