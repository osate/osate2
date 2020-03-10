/**
 */
package org.osate.xtext.aadl2.errormodel.EMV2Instance.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.aadl2.Aadl2Package;

import org.osate.aadl2.instance.InstancePackage;

import org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ECollection;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstanceFactory;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstanceObject;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EOperation;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.Literal;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.MultiLiteralConstraint;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateSynchronizationInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateVariableInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.TypeReference;

import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EMV2InstancePackageImpl extends EPackageImpl implements EMV2InstancePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emv2InstanceObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emv2AnnexInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateVariableInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constrainedInstanceObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateTransitionInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateSynchronizationInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiLiteralConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eOperationEEnum = null;

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
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EMV2InstancePackageImpl() {
		super(eNS_URI, EMV2InstanceFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EMV2InstancePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EMV2InstancePackage init() {
		if (isInited) return (EMV2InstancePackage)EPackage.Registry.INSTANCE.getEPackage(EMV2InstancePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredEMV2InstancePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		EMV2InstancePackageImpl theEMV2InstancePackage = registeredEMV2InstancePackage instanceof EMV2InstancePackageImpl ? (EMV2InstancePackageImpl)registeredEMV2InstancePackage : new EMV2InstancePackageImpl();

		isInited = true;

		// Initialize simple dependencies
		Aadl2Package.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		ErrorModelPackage.eINSTANCE.eClass();
		InstancePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEMV2InstancePackage.createPackageContents();

		// Initialize created meta-data
		theEMV2InstancePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEMV2InstancePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EMV2InstancePackage.eNS_URI, theEMV2InstancePackage);
		return theEMV2InstancePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEMV2InstanceObject() {
		return emv2InstanceObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEMV2AnnexInstance() {
		return emv2AnnexInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStateVariableInstance() {
		return stateVariableInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStateVariableInstance_States() {
		return (EReference)stateVariableInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStateVariableInstance_CurrentState() {
		return (EReference)stateVariableInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStateInstance() {
		return stateInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConstrainedInstanceObject() {
		return constrainedInstanceObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstrainedInstanceObject_InstanceObject() {
		return (EReference)constrainedInstanceObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstrainedInstanceObject_Constraint() {
		return (EReference)constrainedInstanceObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConstrainedInstanceObject_Outgoing() {
		return (EAttribute)constrainedInstanceObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStateTransitionInstance() {
		return stateTransitionInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStateTransitionInstance_TargetState() {
		return (EReference)stateTransitionInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStateTransitionInstance_Condition() {
		return (EReference)stateTransitionInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStateTransitionInstance_StateTransition() {
		return (EReference)stateTransitionInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStateSynchronizationInstance() {
		return stateSynchronizationInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStateSynchronizationInstance_TargetState() {
		return (EReference)stateSynchronizationInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStateSynchronizationInstance_Condition() {
		return (EReference)stateSynchronizationInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStateSynchronizationInstance_StateSynchronization() {
		return (EReference)stateSynchronizationInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBehaviorInstance() {
		return behaviorInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBehaviorInstance_Condition() {
		return (EReference)behaviorInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBehaviorInstance_Actions() {
		return (EReference)behaviorInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBehaviorInstance_Source() {
		return (EAttribute)behaviorInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBehaviorInstance_Sink() {
		return (EAttribute)behaviorInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteral() {
		return literalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypeReference() {
		return typeReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypeReference_Type() {
		return (EReference)typeReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getECollection() {
		return eCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getECollection_Elements() {
		return (EReference)eCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMultiLiteralConstraint() {
		return multiLiteralConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMultiLiteralConstraint_Operator() {
		return (EAttribute)multiLiteralConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMultiLiteralConstraint_K() {
		return (EAttribute)multiLiteralConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getEOperation() {
		return eOperationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMV2InstanceFactory getEMV2InstanceFactory() {
		return (EMV2InstanceFactory)getEFactoryInstance();
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
		emv2InstanceObjectEClass = createEClass(EMV2_INSTANCE_OBJECT);

		emv2AnnexInstanceEClass = createEClass(EMV2_ANNEX_INSTANCE);

		stateVariableInstanceEClass = createEClass(STATE_VARIABLE_INSTANCE);
		createEReference(stateVariableInstanceEClass, STATE_VARIABLE_INSTANCE__STATES);
		createEReference(stateVariableInstanceEClass, STATE_VARIABLE_INSTANCE__CURRENT_STATE);

		stateInstanceEClass = createEClass(STATE_INSTANCE);

		constrainedInstanceObjectEClass = createEClass(CONSTRAINED_INSTANCE_OBJECT);
		createEReference(constrainedInstanceObjectEClass, CONSTRAINED_INSTANCE_OBJECT__INSTANCE_OBJECT);
		createEReference(constrainedInstanceObjectEClass, CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT);
		createEAttribute(constrainedInstanceObjectEClass, CONSTRAINED_INSTANCE_OBJECT__OUTGOING);

		stateTransitionInstanceEClass = createEClass(STATE_TRANSITION_INSTANCE);
		createEReference(stateTransitionInstanceEClass, STATE_TRANSITION_INSTANCE__TARGET_STATE);
		createEReference(stateTransitionInstanceEClass, STATE_TRANSITION_INSTANCE__CONDITION);
		createEReference(stateTransitionInstanceEClass, STATE_TRANSITION_INSTANCE__STATE_TRANSITION);

		stateSynchronizationInstanceEClass = createEClass(STATE_SYNCHRONIZATION_INSTANCE);
		createEReference(stateSynchronizationInstanceEClass, STATE_SYNCHRONIZATION_INSTANCE__TARGET_STATE);
		createEReference(stateSynchronizationInstanceEClass, STATE_SYNCHRONIZATION_INSTANCE__CONDITION);
		createEReference(stateSynchronizationInstanceEClass, STATE_SYNCHRONIZATION_INSTANCE__STATE_SYNCHRONIZATION);

		behaviorInstanceEClass = createEClass(BEHAVIOR_INSTANCE);
		createEReference(behaviorInstanceEClass, BEHAVIOR_INSTANCE__CONDITION);
		createEReference(behaviorInstanceEClass, BEHAVIOR_INSTANCE__ACTIONS);
		createEAttribute(behaviorInstanceEClass, BEHAVIOR_INSTANCE__SOURCE);
		createEAttribute(behaviorInstanceEClass, BEHAVIOR_INSTANCE__SINK);

		literalEClass = createEClass(LITERAL);

		typeReferenceEClass = createEClass(TYPE_REFERENCE);
		createEReference(typeReferenceEClass, TYPE_REFERENCE__TYPE);

		eCollectionEClass = createEClass(ECOLLECTION);
		createEReference(eCollectionEClass, ECOLLECTION__ELEMENTS);

		multiLiteralConstraintEClass = createEClass(MULTI_LITERAL_CONSTRAINT);
		createEAttribute(multiLiteralConstraintEClass, MULTI_LITERAL_CONSTRAINT__OPERATOR);
		createEAttribute(multiLiteralConstraintEClass, MULTI_LITERAL_CONSTRAINT__K);

		// Create enums
		eOperationEEnum = createEEnum(EOPERATION);
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
		ErrorModelPackage theErrorModelPackage = (ErrorModelPackage)EPackage.Registry.INSTANCE.getEPackage(ErrorModelPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		emv2InstanceObjectEClass.getESuperTypes().add(theInstancePackage.getInstanceObject());
		emv2AnnexInstanceEClass.getESuperTypes().add(theInstancePackage.getInstanceObject());
		emv2AnnexInstanceEClass.getESuperTypes().add(theInstancePackage.getAnnexInstance());
		emv2AnnexInstanceEClass.getESuperTypes().add(this.getEMV2InstanceObject());
		stateVariableInstanceEClass.getESuperTypes().add(this.getEMV2InstanceObject());
		stateInstanceEClass.getESuperTypes().add(this.getEMV2InstanceObject());
		constrainedInstanceObjectEClass.getESuperTypes().add(this.getEMV2InstanceObject());
		constrainedInstanceObjectEClass.getESuperTypes().add(this.getLiteral());
		stateTransitionInstanceEClass.getESuperTypes().add(this.getEMV2InstanceObject());
		stateSynchronizationInstanceEClass.getESuperTypes().add(this.getEMV2InstanceObject());
		behaviorInstanceEClass.getESuperTypes().add(this.getEMV2InstanceObject());
		eCollectionEClass.getESuperTypes().add(this.getLiteral());

		// Initialize classes, features, and operations; add parameters
		initEClass(emv2InstanceObjectEClass, EMV2InstanceObject.class, "EMV2InstanceObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(emv2AnnexInstanceEClass, EMV2AnnexInstance.class, "EMV2AnnexInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stateVariableInstanceEClass, StateVariableInstance.class, "StateVariableInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateVariableInstance_States(), this.getStateInstance(), null, "states", null, 0, -1, StateVariableInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateVariableInstance_CurrentState(), this.getStateInstance(), null, "currentState", null, 0, 1, StateVariableInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateInstanceEClass, StateInstance.class, "StateInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constrainedInstanceObjectEClass, ConstrainedInstanceObject.class, "ConstrainedInstanceObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstrainedInstanceObject_InstanceObject(), theInstancePackage.getInstanceObject(), null, "instanceObject", null, 0, 1, ConstrainedInstanceObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstrainedInstanceObject_Constraint(), this.getLiteral(), null, "constraint", null, 0, 1, ConstrainedInstanceObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstrainedInstanceObject_Outgoing(), ecorePackage.getEBoolean(), "outgoing", null, 0, 1, ConstrainedInstanceObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateTransitionInstanceEClass, StateTransitionInstance.class, "StateTransitionInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateTransitionInstance_TargetState(), this.getStateInstance(), null, "targetState", null, 0, 1, StateTransitionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateTransitionInstance_Condition(), this.getLiteral(), null, "condition", null, 0, 1, StateTransitionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateTransitionInstance_StateTransition(), theErrorModelPackage.getErrorBehaviorTransition(), null, "stateTransition", null, 0, 1, StateTransitionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateSynchronizationInstanceEClass, StateSynchronizationInstance.class, "StateSynchronizationInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateSynchronizationInstance_TargetState(), this.getStateInstance(), null, "targetState", null, 0, 1, StateSynchronizationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateSynchronizationInstance_Condition(), this.getLiteral(), null, "condition", null, 0, 1, StateSynchronizationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateSynchronizationInstance_StateSynchronization(), theErrorModelPackage.getCompositeState(), null, "stateSynchronization", null, 0, 1, StateSynchronizationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorInstanceEClass, BehaviorInstance.class, "BehaviorInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorInstance_Condition(), this.getLiteral(), null, "condition", null, 0, 1, BehaviorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorInstance_Actions(), this.getConstrainedInstanceObject(), null, "actions", null, 0, -1, BehaviorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorInstance_Source(), ecorePackage.getEBoolean(), "source", null, 0, 1, BehaviorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorInstance_Sink(), ecorePackage.getEBoolean(), "sink", null, 0, 1, BehaviorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalEClass, Literal.class, "Literal", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeReferenceEClass, TypeReference.class, "TypeReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeReference_Type(), theErrorModelPackage.getErrorTypes(), null, "type", null, 0, 1, TypeReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eCollectionEClass, ECollection.class, "ECollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getECollection_Elements(), this.getLiteral(), null, "elements", null, 0, -1, ECollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiLiteralConstraintEClass, MultiLiteralConstraint.class, "MultiLiteralConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiLiteralConstraint_Operator(), this.getEOperation(), "operator", null, 0, 1, MultiLiteralConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiLiteralConstraint_K(), theEcorePackage.getEInt(), "k", null, 0, 1, MultiLiteralConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(eOperationEEnum, EOperation.class, "EOperation");
		addEEnumLiteral(eOperationEEnum, EOperation.ANY);
		addEEnumLiteral(eOperationEEnum, EOperation.ALL);
		addEEnumLiteral(eOperationEEnum, EOperation.ONEOF);
		addEEnumLiteral(eOperationEEnum, EOperation.KOFN);
		addEEnumLiteral(eOperationEEnum, EOperation.KORMORE);
		addEEnumLiteral(eOperationEEnum, EOperation.KORLESS);

		// Create resource
		createResource(eNS_URI);
	}

} //EMV2InstancePackageImpl
