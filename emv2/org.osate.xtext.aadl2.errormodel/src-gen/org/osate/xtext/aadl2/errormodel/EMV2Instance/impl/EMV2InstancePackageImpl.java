/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
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
import org.osate.xtext.aadl2.errormodel.EMV2Instance.CompositeStateInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.Constraint;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstraintElement;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstanceFactory;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstanceObject;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EOperation;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.EventInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateMachineInstance;
import org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance;
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
	private EClass stateMachineInstanceEClass = null;

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
	private EClass compositeStateInstanceEClass = null;

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
	private EClass eventInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintElementEClass = null;

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
	public EReference getEMV2AnnexInstance_Transitions() {
		return (EReference)emv2AnnexInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_Events() {
		return (EReference)emv2AnnexInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_StateMachine() {
		return (EReference)emv2AnnexInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_Behaviors() {
		return (EReference)emv2AnnexInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_Composites() {
		return (EReference)emv2AnnexInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_Actions() {
		return (EReference)emv2AnnexInstanceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStateMachineInstance() {
		return stateMachineInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStateMachineInstance_States() {
		return (EReference)stateMachineInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStateMachineInstance_CurrentState() {
		return (EReference)stateMachineInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStateMachineInstance_StateMachine() {
		return (EReference)stateMachineInstanceEClass.getEStructuralFeatures().get(2);
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
		return (EReference)stateTransitionInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStateTransitionInstance_Condition() {
		return (EReference)stateTransitionInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStateTransitionInstance_StateTransition() {
		return (EReference)stateTransitionInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStateTransitionInstance_InStates() {
		return (EReference)stateTransitionInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompositeStateInstance() {
		return compositeStateInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositeStateInstance_TargetState() {
		return (EReference)compositeStateInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositeStateInstance_Condition() {
		return (EReference)compositeStateInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositeStateInstance_CompositeState() {
		return (EReference)compositeStateInstanceEClass.getEStructuralFeatures().get(2);
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
		return (EReference)behaviorInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBehaviorInstance_Actions() {
		return (EReference)behaviorInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBehaviorInstance_Source() {
		return (EAttribute)behaviorInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBehaviorInstance_Sink() {
		return (EAttribute)behaviorInstanceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBehaviorInstance_Emv2Element() {
		return (EReference)behaviorInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBehaviorInstance_InStates() {
		return (EReference)behaviorInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEventInstance() {
		return eventInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEventInstance_Event() {
		return (EReference)eventInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEventInstance_GeneratedTypedEvents() {
		return (EReference)eventInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConstraint() {
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConstraint_Operator() {
		return (EAttribute)constraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConstraint_K() {
		return (EAttribute)constraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstraint_ConstraintElements() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConstraintElement() {
		return constraintElementEClass;
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
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__TRANSITIONS);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__EVENTS);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__STATE_MACHINE);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__BEHAVIORS);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__COMPOSITES);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__ACTIONS);

		stateMachineInstanceEClass = createEClass(STATE_MACHINE_INSTANCE);
		createEReference(stateMachineInstanceEClass, STATE_MACHINE_INSTANCE__STATES);
		createEReference(stateMachineInstanceEClass, STATE_MACHINE_INSTANCE__CURRENT_STATE);
		createEReference(stateMachineInstanceEClass, STATE_MACHINE_INSTANCE__STATE_MACHINE);

		stateInstanceEClass = createEClass(STATE_INSTANCE);

		constrainedInstanceObjectEClass = createEClass(CONSTRAINED_INSTANCE_OBJECT);
		createEReference(constrainedInstanceObjectEClass, CONSTRAINED_INSTANCE_OBJECT__INSTANCE_OBJECT);
		createEReference(constrainedInstanceObjectEClass, CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT);
		createEAttribute(constrainedInstanceObjectEClass, CONSTRAINED_INSTANCE_OBJECT__OUTGOING);

		stateTransitionInstanceEClass = createEClass(STATE_TRANSITION_INSTANCE);
		createEReference(stateTransitionInstanceEClass, STATE_TRANSITION_INSTANCE__STATE_TRANSITION);
		createEReference(stateTransitionInstanceEClass, STATE_TRANSITION_INSTANCE__IN_STATES);
		createEReference(stateTransitionInstanceEClass, STATE_TRANSITION_INSTANCE__CONDITION);
		createEReference(stateTransitionInstanceEClass, STATE_TRANSITION_INSTANCE__TARGET_STATE);

		compositeStateInstanceEClass = createEClass(COMPOSITE_STATE_INSTANCE);
		createEReference(compositeStateInstanceEClass, COMPOSITE_STATE_INSTANCE__TARGET_STATE);
		createEReference(compositeStateInstanceEClass, COMPOSITE_STATE_INSTANCE__CONDITION);
		createEReference(compositeStateInstanceEClass, COMPOSITE_STATE_INSTANCE__COMPOSITE_STATE);

		behaviorInstanceEClass = createEClass(BEHAVIOR_INSTANCE);
		createEReference(behaviorInstanceEClass, BEHAVIOR_INSTANCE__EMV2_ELEMENT);
		createEReference(behaviorInstanceEClass, BEHAVIOR_INSTANCE__IN_STATES);
		createEReference(behaviorInstanceEClass, BEHAVIOR_INSTANCE__CONDITION);
		createEReference(behaviorInstanceEClass, BEHAVIOR_INSTANCE__ACTIONS);
		createEAttribute(behaviorInstanceEClass, BEHAVIOR_INSTANCE__SOURCE);
		createEAttribute(behaviorInstanceEClass, BEHAVIOR_INSTANCE__SINK);

		eventInstanceEClass = createEClass(EVENT_INSTANCE);
		createEReference(eventInstanceEClass, EVENT_INSTANCE__EVENT);
		createEReference(eventInstanceEClass, EVENT_INSTANCE__GENERATED_TYPED_EVENTS);

		constraintEClass = createEClass(CONSTRAINT);
		createEAttribute(constraintEClass, CONSTRAINT__OPERATOR);
		createEAttribute(constraintEClass, CONSTRAINT__K);
		createEReference(constraintEClass, CONSTRAINT__CONSTRAINT_ELEMENTS);

		constraintElementEClass = createEClass(CONSTRAINT_ELEMENT);

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
		Aadl2Package theAadl2Package = (Aadl2Package)EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		emv2InstanceObjectEClass.getESuperTypes().add(theInstancePackage.getInstanceObject());
		emv2AnnexInstanceEClass.getESuperTypes().add(theInstancePackage.getAnnexInstance());
		stateMachineInstanceEClass.getESuperTypes().add(this.getEMV2InstanceObject());
		stateInstanceEClass.getESuperTypes().add(this.getEMV2InstanceObject());
		constrainedInstanceObjectEClass.getESuperTypes().add(this.getConstraintElement());
		stateTransitionInstanceEClass.getESuperTypes().add(this.getEMV2InstanceObject());
		compositeStateInstanceEClass.getESuperTypes().add(this.getEMV2InstanceObject());
		behaviorInstanceEClass.getESuperTypes().add(this.getEMV2InstanceObject());
		eventInstanceEClass.getESuperTypes().add(this.getEMV2InstanceObject());
		constraintEClass.getESuperTypes().add(this.getConstraintElement());
		constraintElementEClass.getESuperTypes().add(this.getEMV2InstanceObject());

		// Initialize classes and features; add operations and parameters
		initEClass(emv2InstanceObjectEClass, EMV2InstanceObject.class, "EMV2InstanceObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(emv2AnnexInstanceEClass, EMV2AnnexInstance.class, "EMV2AnnexInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEMV2AnnexInstance_Transitions(), this.getStateTransitionInstance(), null, "transitions", null, 0, -1, EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_Events(), this.getEventInstance(), null, "events", null, 0, -1, EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_StateMachine(), this.getStateMachineInstance(), null, "stateMachine", null, 0, 1, EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_Behaviors(), this.getBehaviorInstance(), null, "behaviors", null, 0, -1, EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_Composites(), this.getCompositeStateInstance(), null, "composites", null, 0, -1, EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_Actions(), this.getConstrainedInstanceObject(), null, "actions", null, 0, -1, EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateMachineInstanceEClass, StateMachineInstance.class, "StateMachineInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateMachineInstance_States(), this.getStateInstance(), null, "states", null, 0, -1, StateMachineInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachineInstance_CurrentState(), this.getStateInstance(), null, "currentState", null, 0, 1, StateMachineInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachineInstance_StateMachine(), theErrorModelPackage.getErrorBehaviorStateMachine(), null, "stateMachine", null, 0, 1, StateMachineInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateInstanceEClass, StateInstance.class, "StateInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constrainedInstanceObjectEClass, ConstrainedInstanceObject.class, "ConstrainedInstanceObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstrainedInstanceObject_InstanceObject(), theInstancePackage.getInstanceObject(), null, "instanceObject", null, 0, 1, ConstrainedInstanceObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstrainedInstanceObject_Constraint(), theErrorModelPackage.getTypeToken(), null, "constraint", null, 0, -1, ConstrainedInstanceObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstrainedInstanceObject_Outgoing(), ecorePackage.getEBoolean(), "outgoing", null, 0, 1, ConstrainedInstanceObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateTransitionInstanceEClass, StateTransitionInstance.class, "StateTransitionInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateTransitionInstance_StateTransition(), theErrorModelPackage.getErrorBehaviorTransition(), null, "stateTransition", null, 0, 1, StateTransitionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateTransitionInstance_InStates(), this.getStateInstance(), null, "inStates", null, 0, -1, StateTransitionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateTransitionInstance_Condition(), this.getConstraintElement(), null, "condition", null, 0, 1, StateTransitionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateTransitionInstance_TargetState(), this.getStateInstance(), null, "targetState", null, 0, 1, StateTransitionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeStateInstanceEClass, CompositeStateInstance.class, "CompositeStateInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeStateInstance_TargetState(), this.getStateInstance(), null, "targetState", null, 0, 1, CompositeStateInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeStateInstance_Condition(), this.getConstraintElement(), null, "condition", null, 0, 1, CompositeStateInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeStateInstance_CompositeState(), theErrorModelPackage.getCompositeState(), null, "compositeState", null, 0, 1, CompositeStateInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(behaviorInstanceEClass, BehaviorInstance.class, "BehaviorInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBehaviorInstance_Emv2Element(), theAadl2Package.getNamedElement(), null, "emv2Element", null, 0, 1, BehaviorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorInstance_InStates(), this.getStateInstance(), null, "inStates", null, 0, -1, BehaviorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorInstance_Condition(), this.getConstraintElement(), null, "condition", null, 0, 1, BehaviorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBehaviorInstance_Actions(), this.getConstrainedInstanceObject(), null, "actions", null, 0, -1, BehaviorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorInstance_Source(), ecorePackage.getEBoolean(), "source", null, 0, 1, BehaviorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBehaviorInstance_Sink(), ecorePackage.getEBoolean(), "sink", null, 0, 1, BehaviorInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventInstanceEClass, EventInstance.class, "EventInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEventInstance_Event(), theErrorModelPackage.getErrorBehaviorEvent(), null, "event", null, 0, 1, EventInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEventInstance_GeneratedTypedEvents(), this.getConstrainedInstanceObject(), null, "generatedTypedEvents", null, 0, -1, EventInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstraint_Operator(), this.getEOperation(), "operator", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstraint_K(), ecorePackage.getELong(), "k", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_ConstraintElements(), this.getConstraintElement(), null, "constraintElements", null, 0, -1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintElementEClass, ConstraintElement.class, "ConstraintElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

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
