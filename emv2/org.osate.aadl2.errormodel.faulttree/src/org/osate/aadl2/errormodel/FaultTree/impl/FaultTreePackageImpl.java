/**
 */
package org.osate.aadl2.errormodel.FaultTree.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.osate.aadl2.errormodel.FaultTree.Event;
import org.osate.aadl2.errormodel.FaultTree.EventType;
import org.osate.aadl2.errormodel.FaultTree.FaultTree;
import org.osate.aadl2.errormodel.FaultTree.FaultTreeFactory;
import org.osate.aadl2.errormodel.FaultTree.FaultTreePackage;
import org.osate.aadl2.errormodel.FaultTree.FaultTreeType;
import org.osate.aadl2.errormodel.FaultTree.LogicOperation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FaultTreePackageImpl extends EPackageImpl implements FaultTreePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass faultTreeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eventTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum logicOperationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum faultTreeTypeEEnum = null;

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
	 * @see org.osate.aadl2.errormodel.FaultTree.FaultTreePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FaultTreePackageImpl() {
		super(eNS_URI, FaultTreeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link FaultTreePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FaultTreePackage init() {
		if (isInited) return (FaultTreePackage)EPackage.Registry.INSTANCE.getEPackage(FaultTreePackage.eNS_URI);

		// Obtain or create and register package
		FaultTreePackageImpl theFaultTreePackage = (FaultTreePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FaultTreePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FaultTreePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theFaultTreePackage.createPackageContents();

		// Initialize created meta-data
		theFaultTreePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFaultTreePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FaultTreePackage.eNS_URI, theFaultTreePackage);
		return theFaultTreePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFaultTree() {
		return faultTreeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultTree_Name() {
		return (EAttribute)faultTreeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultTree_Message() {
		return (EAttribute)faultTreeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFaultTree_FaultTreeType() {
		return (EAttribute)faultTreeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultTree_Events() {
		return (EReference)faultTreeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultTree_Root() {
		return (EReference)faultTreeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFaultTree_InstanceRoot() {
		return (EReference)faultTreeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvent() {
		return eventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_Name() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_Message() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvent_SubEvents() {
		return (EReference)eventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_K() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_AssignedProbability() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_ComputedProbability() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvent_RelatedInstanceObject() {
		return (EReference)eventEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_ReferenceCount() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_Type() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_SubEventLogic() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvent_RelatedEMV2Object() {
		return (EReference)eventEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_Scale() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getEvent__GetProbability() {
		return eventEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvent_RelatedErrorType() {
		return (EReference)eventEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEventType() {
		return eventTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLogicOperation() {
		return logicOperationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFaultTreeType() {
		return faultTreeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FaultTreeFactory getFaultTreeFactory() {
		return (FaultTreeFactory)getEFactoryInstance();
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
		faultTreeEClass = createEClass(FAULT_TREE);
		createEAttribute(faultTreeEClass, FAULT_TREE__NAME);
		createEAttribute(faultTreeEClass, FAULT_TREE__MESSAGE);
		createEAttribute(faultTreeEClass, FAULT_TREE__FAULT_TREE_TYPE);
		createEReference(faultTreeEClass, FAULT_TREE__ROOT);
		createEReference(faultTreeEClass, FAULT_TREE__INSTANCE_ROOT);
		createEReference(faultTreeEClass, FAULT_TREE__EVENTS);

		eventEClass = createEClass(EVENT);
		createEAttribute(eventEClass, EVENT__NAME);
		createEAttribute(eventEClass, EVENT__MESSAGE);
		createEReference(eventEClass, EVENT__SUB_EVENTS);
		createEAttribute(eventEClass, EVENT__K);
		createEAttribute(eventEClass, EVENT__ASSIGNED_PROBABILITY);
		createEAttribute(eventEClass, EVENT__COMPUTED_PROBABILITY);
		createEReference(eventEClass, EVENT__RELATED_INSTANCE_OBJECT);
		createEReference(eventEClass, EVENT__RELATED_ERROR_TYPE);
		createEAttribute(eventEClass, EVENT__REFERENCE_COUNT);
		createEAttribute(eventEClass, EVENT__TYPE);
		createEAttribute(eventEClass, EVENT__SUB_EVENT_LOGIC);
		createEReference(eventEClass, EVENT__RELATED_EMV2_OBJECT);
		createEAttribute(eventEClass, EVENT__SCALE);
		createEOperation(eventEClass, EVENT___GET_PROBABILITY);

		// Create enums
		eventTypeEEnum = createEEnum(EVENT_TYPE);
		logicOperationEEnum = createEEnum(LOGIC_OPERATION);
		faultTreeTypeEEnum = createEEnum(FAULT_TREE_TYPE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(faultTreeEClass, FaultTree.class, "FaultTree", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFaultTree_Name(), ecorePackage.getEString(), "name", null, 0, 1, FaultTree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultTree_Message(), ecorePackage.getEString(), "message", null, 0, 1, FaultTree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFaultTree_FaultTreeType(), this.getFaultTreeType(), "faultTreeType", null, 0, 1, FaultTree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFaultTree_Root(), this.getEvent(), null, "root", null, 0, 1, FaultTree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFaultTree_InstanceRoot(), ecorePackage.getEObject(), null, "instanceRoot", null, 0, 1, FaultTree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFaultTree_Events(), this.getEvent(), null, "events", null, 0, -1, FaultTree.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventEClass, Event.class, "Event", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEvent_Name(), ecorePackage.getEString(), "name", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Message(), ecorePackage.getEString(), "message", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_SubEvents(), this.getEvent(), null, "subEvents", null, 0, -1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_K(), ecorePackage.getEInt(), "k", "1", 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_AssignedProbability(), ecorePackage.getEBigDecimal(), "assignedProbability", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_ComputedProbability(), ecorePackage.getEBigDecimal(), "computedProbability", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_RelatedInstanceObject(), ecorePackage.getEObject(), null, "relatedInstanceObject", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_RelatedErrorType(), ecorePackage.getEObject(), null, "relatedErrorType", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_ReferenceCount(), ecorePackage.getEInt(), "referenceCount", "0", 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Type(), this.getEventType(), "type", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_SubEventLogic(), this.getLogicOperation(), "subEventLogic", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_RelatedEMV2Object(), ecorePackage.getEObject(), null, "relatedEMV2Object", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Scale(), ecorePackage.getEBigDecimal(), "scale", "1.0", 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getEvent__GetProbability(), ecorePackage.getEBigDecimal(), "getProbability", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(eventTypeEEnum, EventType.class, "EventType");
		addEEnumLiteral(eventTypeEEnum, EventType.BASIC);
		addEEnumLiteral(eventTypeEEnum, EventType.EXTERNAL);
		addEEnumLiteral(eventTypeEEnum, EventType.UNDEVELOPED);
		addEEnumLiteral(eventTypeEEnum, EventType.INTERMEDIATE);

		initEEnum(logicOperationEEnum, LogicOperation.class, "LogicOperation");
		addEEnumLiteral(logicOperationEEnum, LogicOperation.OR);
		addEEnumLiteral(logicOperationEEnum, LogicOperation.AND);
		addEEnumLiteral(logicOperationEEnum, LogicOperation.XOR);
		addEEnumLiteral(logicOperationEEnum, LogicOperation.PRIORITY_AND);
		addEEnumLiteral(logicOperationEEnum, LogicOperation.KOF);
		addEEnumLiteral(logicOperationEEnum, LogicOperation.KORMORE);
		addEEnumLiteral(logicOperationEEnum, LogicOperation.KORLESS);

		initEEnum(faultTreeTypeEEnum, FaultTreeType.class, "FaultTreeType");
		addEEnumLiteral(faultTreeTypeEEnum, FaultTreeType.FAULT_TREE);
		addEEnumLiteral(faultTreeTypeEEnum, FaultTreeType.FAULT_TRACE);
		addEEnumLiteral(faultTreeTypeEEnum, FaultTreeType.COMPOSITE_PARTS);
		addEEnumLiteral(faultTreeTypeEEnum, FaultTreeType.MINIMAL_CUT_SET);

		// Create resource
		createResource(eNS_URI);
	}

} // FaultTreePackageImpl
