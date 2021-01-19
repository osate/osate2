/**
 */
package org.osate.analysis.resources.budgets.internal.models.busload.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.aadl2.Aadl2Package;

import org.osate.aadl2.instance.InstancePackage;

import org.osate.analysis.resources.budgets.internal.models.busload.AnalysisElement;
import org.osate.analysis.resources.budgets.internal.models.busload.Broadcast;
import org.osate.analysis.resources.budgets.internal.models.busload.Bus;
import org.osate.analysis.resources.budgets.internal.models.busload.BusLoadModel;
import org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus;
import org.osate.analysis.resources.budgets.internal.models.busload.BusloadFactory;
import org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage;
import org.osate.analysis.resources.budgets.internal.models.busload.Connection;
import org.osate.analysis.resources.budgets.internal.models.busload.VirtualBus;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BusloadPackageImpl extends EPackageImpl implements BusloadPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass analysisElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass broadcastEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass busOrVirtualBusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass virtualBusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass busEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass busLoadModelEClass = null;

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
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BusloadPackageImpl() {
		super(eNS_URI, BusloadFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link BusloadPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BusloadPackage init() {
		if (isInited) return (BusloadPackage)EPackage.Registry.INSTANCE.getEPackage(BusloadPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredBusloadPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		BusloadPackageImpl theBusloadPackage = registeredBusloadPackage instanceof BusloadPackageImpl ? (BusloadPackageImpl)registeredBusloadPackage : new BusloadPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		Aadl2Package.eINSTANCE.eClass();
		InstancePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theBusloadPackage.createPackageContents();

		// Initialize created meta-data
		theBusloadPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBusloadPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BusloadPackage.eNS_URI, theBusloadPackage);
		return theBusloadPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAnalysisElement() {
		return analysisElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAnalysisElement_Label() {
		return (EAttribute)analysisElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAnalysisElement_Actual() {
		return (EAttribute)analysisElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAnalysisElement_Budget() {
		return (EAttribute)analysisElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConnection() {
		return connectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConnection_ConnectionInstance() {
		return (EReference)connectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBroadcast() {
		return broadcastEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBroadcast_Connections() {
		return (EReference)broadcastEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBroadcast_Source() {
		return (EReference)broadcastEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBusOrVirtualBus() {
		return busOrVirtualBusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBusOrVirtualBus_BoundBroadcasts() {
		return (EReference)busOrVirtualBusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBusOrVirtualBus_BoundConnections() {
		return (EReference)busOrVirtualBusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBusOrVirtualBus_BoundVirtualBuses() {
		return (EReference)busOrVirtualBusEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVirtualBus() {
		return virtualBusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBus() {
		return busEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBusLoadModel() {
		return busLoadModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBusLoadModel_RootBuses() {
		return (EReference)busLoadModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BusloadFactory getBusloadFactory() {
		return (BusloadFactory)getEFactoryInstance();
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
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		analysisElementEClass = createEClass(ANALYSIS_ELEMENT);
		createEAttribute(analysisElementEClass, ANALYSIS_ELEMENT__LABEL);
		createEAttribute(analysisElementEClass, ANALYSIS_ELEMENT__ACTUAL);
		createEAttribute(analysisElementEClass, ANALYSIS_ELEMENT__BUDGET);

		connectionEClass = createEClass(CONNECTION);
		createEReference(connectionEClass, CONNECTION__CONNECTION_INSTANCE);

		broadcastEClass = createEClass(BROADCAST);
		createEReference(broadcastEClass, BROADCAST__CONNECTIONS);
		createEReference(broadcastEClass, BROADCAST__SOURCE);

		busOrVirtualBusEClass = createEClass(BUS_OR_VIRTUAL_BUS);
		createEReference(busOrVirtualBusEClass, BUS_OR_VIRTUAL_BUS__BOUND_BROADCASTS);
		createEReference(busOrVirtualBusEClass, BUS_OR_VIRTUAL_BUS__BOUND_CONNECTIONS);
		createEReference(busOrVirtualBusEClass, BUS_OR_VIRTUAL_BUS__BOUND_VIRTUAL_BUSES);

		virtualBusEClass = createEClass(VIRTUAL_BUS);

		busEClass = createEClass(BUS);

		busLoadModelEClass = createEClass(BUS_LOAD_MODEL);
		createEReference(busLoadModelEClass, BUS_LOAD_MODEL__ROOT_BUSES);
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
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		InstancePackage theInstancePackage = (InstancePackage)EPackage.Registry.INSTANCE.getEPackage(InstancePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		connectionEClass.getESuperTypes().add(this.getAnalysisElement());
		broadcastEClass.getESuperTypes().add(this.getAnalysisElement());
		busOrVirtualBusEClass.getESuperTypes().add(this.getAnalysisElement());
		virtualBusEClass.getESuperTypes().add(this.getBusOrVirtualBus());
		busEClass.getESuperTypes().add(this.getBusOrVirtualBus());

		// Initialize classes, features, and operations; add parameters
		initEClass(analysisElementEClass, AnalysisElement.class, "AnalysisElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnalysisElement_Label(), ecorePackage.getEString(), "label", null, 0, 1, AnalysisElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnalysisElement_Actual(), ecorePackage.getEDouble(), "actual", null, 0, 1, AnalysisElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnalysisElement_Budget(), ecorePackage.getEDouble(), "budget", null, 0, 1, AnalysisElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(connectionEClass, Connection.class, "Connection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnection_ConnectionInstance(), theInstancePackage.getConnectionInstance(), null, "connectionInstance", null, 0, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(broadcastEClass, Broadcast.class, "Broadcast", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBroadcast_Connections(), this.getConnection(), null, "connections", null, 0, -1, Broadcast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBroadcast_Source(), theInstancePackage.getConnectionInstanceEnd(), null, "source", null, 0, 1, Broadcast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(busOrVirtualBusEClass, BusOrVirtualBus.class, "BusOrVirtualBus", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBusOrVirtualBus_BoundBroadcasts(), this.getBroadcast(), null, "boundBroadcasts", null, 0, -1, BusOrVirtualBus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBusOrVirtualBus_BoundConnections(), this.getConnection(), null, "boundConnections", null, 0, -1, BusOrVirtualBus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBusOrVirtualBus_BoundVirtualBuses(), this.getVirtualBus(), null, "boundVirtualBuses", null, 0, -1, BusOrVirtualBus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(virtualBusEClass, VirtualBus.class, "VirtualBus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(busEClass, Bus.class, "Bus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(busLoadModelEClass, BusLoadModel.class, "BusLoadModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBusLoadModel_RootBuses(), this.getBus(), null, "rootBuses", null, 0, -1, BusLoadModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //BusloadPackageImpl
