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
package org.osate.aadl2.errormodel.instance.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.errormodel.instance.AbstractTypeSet;
import org.osate.aadl2.errormodel.instance.AccessPropagation;
import org.osate.aadl2.errormodel.instance.AnonymousTypeSet;
import org.osate.aadl2.errormodel.instance.BindingPath;
import org.osate.aadl2.errormodel.instance.BindingPropagation;
import org.osate.aadl2.errormodel.instance.BindingType;
import org.osate.aadl2.errormodel.instance.CompositeStateInstance;
import org.osate.aadl2.errormodel.instance.ConnectionPath;
import org.osate.aadl2.errormodel.instance.ConstrainedInstanceObject;
import org.osate.aadl2.errormodel.instance.ConstraintElement;
import org.osate.aadl2.errormodel.instance.ConstraintExpression;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.EMV2InstanceFactory;
import org.osate.aadl2.errormodel.instance.EMV2InstanceObject;
import org.osate.aadl2.errormodel.instance.EMV2InstancePackage;
import org.osate.aadl2.errormodel.instance.EOperation;
import org.osate.aadl2.errormodel.instance.ErrorDetectionInstance;
import org.osate.aadl2.errormodel.instance.ErrorFlowInstance;
import org.osate.aadl2.errormodel.instance.ErrorPathInstance;
import org.osate.aadl2.errormodel.instance.ErrorPropagationConditionInstance;
import org.osate.aadl2.errormodel.instance.ErrorPropagationInstance;
import org.osate.aadl2.errormodel.instance.ErrorSinkInstance;
import org.osate.aadl2.errormodel.instance.ErrorSourceInstance;
import org.osate.aadl2.errormodel.instance.EventInstance;
import org.osate.aadl2.errormodel.instance.FeaturePropagation;
import org.osate.aadl2.errormodel.instance.OldPropagationPathInstance;
import org.osate.aadl2.errormodel.instance.PointPropagation;
import org.osate.aadl2.errormodel.instance.PropagationPathInstance;
import org.osate.aadl2.errormodel.instance.PropagationPointInstance;
import org.osate.aadl2.errormodel.instance.StateInstance;
import org.osate.aadl2.errormodel.instance.StateMachineInstance;
import org.osate.aadl2.errormodel.instance.StateTransitionInstance;
import org.osate.aadl2.errormodel.instance.TypeInstance;
import org.osate.aadl2.errormodel.instance.TypeProductInstance;
import org.osate.aadl2.errormodel.instance.TypeSetElement;
import org.osate.aadl2.errormodel.instance.TypeSetInstance;
import org.osate.aadl2.errormodel.instance.TypeTokenInstance;
import org.osate.aadl2.errormodel.instance.UserDefinedPath;
import org.osate.aadl2.instance.InstancePackage;
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
	private EClass emv2AnnexInstanceEClass = null;

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
	private EClass errorFlowInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorSourceInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorSinkInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorPathInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorPropagationConditionInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorDetectionInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propagationPointInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propagationPathInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionPathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingPathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userDefinedPathEClass = null;

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
	private EClass constraintExpressionEClass = null;

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
	private EClass oldPropagationPathInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorPropagationInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featurePropagationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pointPropagationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass accessPropagationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingPropagationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeSetElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeTokenInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeSetInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass anonymousTypeSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeProductInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTypeSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum eOperationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum bindingTypeEEnum = null;

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
	 * @see org.osate.aadl2.errormodel.instance.EMV2InstancePackage#eNS_URI
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
		if (isInited) {
			return (EMV2InstancePackage) EPackage.Registry.INSTANCE.getEPackage(EMV2InstancePackage.eNS_URI);
		}

		// Obtain or create and register package
		Object registeredEMV2InstancePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		EMV2InstancePackageImpl theEMV2InstancePackage = registeredEMV2InstancePackage instanceof EMV2InstancePackageImpl
				? (EMV2InstancePackageImpl) registeredEMV2InstancePackage
				: new EMV2InstancePackageImpl();

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
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_PropagationPoints() {
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_Events() {
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_StateMachine() {
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_ErrorPropagationConditions() {
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_ErrorDetections() {
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_ErrorFlows() {
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_Composites() {
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_OldPropagationPaths() {
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_Propagations() {
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_PropagationPaths() {
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(10);
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
		return (EReference) stateMachineInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStateMachineInstance_CurrentState() {
		return (EReference) stateMachineInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStateMachineInstance_StateMachine() {
		return (EReference) stateMachineInstanceEClass.getEStructuralFeatures().get(2);
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
	public EReference getStateInstance_State() {
		return (EReference) stateInstanceEClass.getEStructuralFeatures().get(0);
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
		return (EReference) constrainedInstanceObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstrainedInstanceObject_Constraint() {
		return (EReference) constrainedInstanceObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConstrainedInstanceObject_PropagationKind() {
		return (EAttribute) constrainedInstanceObjectEClass.getEStructuralFeatures().get(2);
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
	public EReference getStateTransitionInstance_StateTransition() {
		return (EReference) stateTransitionInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStateTransitionInstance_InStates() {
		return (EReference) stateTransitionInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStateTransitionInstance_Condition() {
		return (EReference) stateTransitionInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStateTransitionInstance_TargetState() {
		return (EReference) stateTransitionInstanceEClass.getEStructuralFeatures().get(3);
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
		return (EReference) compositeStateInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositeStateInstance_Condition() {
		return (EReference) compositeStateInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositeStateInstance_CompositeState() {
		return (EReference) compositeStateInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getErrorFlowInstance() {
		return errorFlowInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getErrorSourceInstance() {
		return errorSourceInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorSourceInstance_ErrorSource() {
		return (EReference) errorSourceInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorSourceInstance_Propagation() {
		return (EReference) errorSourceInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorSourceInstance_TypeSet() {
		return (EReference) errorSourceInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getErrorSinkInstance() {
		return errorSinkInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorSinkInstance_ErrorSink() {
		return (EReference) errorSinkInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorSinkInstance_Propagation() {
		return (EReference) errorSinkInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorSinkInstance_TypeSet() {
		return (EReference) errorSinkInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getErrorPathInstance() {
		return errorPathInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorPathInstance_ErrorPath() {
		return (EReference) errorPathInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorPathInstance_SourcePropagation() {
		return (EReference) errorPathInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorPathInstance_DestinationPropagation() {
		return (EReference) errorPathInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorPathInstance_DestinationTypeSet() {
		return (EReference) errorPathInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorPathInstance_SourceTypeSet() {
		return (EReference) errorPathInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getErrorPropagationConditionInstance() {
		return errorPropagationConditionInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorPropagationConditionInstance_Emv2Element() {
		return (EReference) errorPropagationConditionInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorPropagationConditionInstance_InStates() {
		return (EReference) errorPropagationConditionInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorPropagationConditionInstance_Condition() {
		return (EReference) errorPropagationConditionInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorPropagationConditionInstance_OutgoingPropagation() {
		return (EReference) errorPropagationConditionInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getErrorPropagationConditionInstance_Source() {
		return (EAttribute) errorPropagationConditionInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getErrorPropagationConditionInstance_Sink() {
		return (EAttribute) errorPropagationConditionInstanceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getErrorDetectionInstance() {
		return errorDetectionInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorDetectionInstance_Emv2Element() {
		return (EReference) errorDetectionInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorDetectionInstance_InStates() {
		return (EReference) errorDetectionInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorDetectionInstance_Condition() {
		return (EReference) errorDetectionInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getErrorDetectionInstance_ErrorCode() {
		return (EAttribute) errorDetectionInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorDetectionInstance_Port() {
		return (EReference) errorDetectionInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropagationPointInstance() {
		return propagationPointInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPropagationPointInstance_PropagationPoint() {
		return (EReference) propagationPointInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPropagationPathInstance() {
		return propagationPathInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConnectionPath() {
		return connectionPathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConnectionPath_Connection() {
		return (EReference) connectionPathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConnectionPath_SourcePropagations() {
		return (EReference) connectionPathEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConnectionPath_DestinationPropagations() {
		return (EReference) connectionPathEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBindingPath() {
		return bindingPathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBindingPath_SourcePropagation() {
		return (EReference) bindingPathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBindingPath_DestinationPropagation() {
		return (EReference) bindingPathEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUserDefinedPath() {
		return userDefinedPathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUserDefinedPath_Path() {
		return (EReference) userDefinedPathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUserDefinedPath_SourcePropagation() {
		return (EReference) userDefinedPathEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUserDefinedPath_DestinationPropagation() {
		return (EReference) userDefinedPathEClass.getEStructuralFeatures().get(2);
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
		return (EReference) eventInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEventInstance_GeneratedTypedEvents() {
		return (EReference) eventInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConstraintExpression() {
		return constraintExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConstraintExpression_Operator() {
		return (EAttribute) constraintExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConstraintExpression_K() {
		return (EAttribute) constraintExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstraintExpression_ConstraintElements() {
		return (EReference) constraintExpressionEClass.getEStructuralFeatures().get(2);
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
	public EClass getOldPropagationPathInstance() {
		return oldPropagationPathInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOldPropagationPathInstance_Emv2Element() {
		return (EReference) oldPropagationPathInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOldPropagationPathInstance_Source() {
		return (EReference) oldPropagationPathInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOldPropagationPathInstance_Target() {
		return (EReference) oldPropagationPathInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getErrorPropagationInstance() {
		return errorPropagationInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorPropagationInstance_InErrorPropagation() {
		return (EReference) errorPropagationInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorPropagationInstance_OutErrorPropagation() {
		return (EReference) errorPropagationInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorPropagationInstance_InTypeSet() {
		return (EReference) errorPropagationInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorPropagationInstance_OutTypeSet() {
		return (EReference) errorPropagationInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorPropagationInstance_ErrorSources() {
		return (EReference) errorPropagationInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorPropagationInstance_ErrorSinks() {
		return (EReference) errorPropagationInstanceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorPropagationInstance_SourceErrorPaths() {
		return (EReference) errorPropagationInstanceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorPropagationInstance_DestinationErrorPaths() {
		return (EReference) errorPropagationInstanceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFeaturePropagation() {
		return featurePropagationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFeaturePropagation_Feature() {
		return (EReference) featurePropagationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPointPropagation() {
		return pointPropagationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPointPropagation_Point() {
		return (EReference) pointPropagationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAccessPropagation() {
		return accessPropagationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBindingPropagation() {
		return bindingPropagationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBindingPropagation_Binding() {
		return (EAttribute) bindingPropagationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypeSetElement() {
		return typeSetElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypeTokenInstance() {
		return typeTokenInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypeInstance() {
		return typeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypeInstance_Type() {
		return (EReference) typeInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypeSetInstance() {
		return typeSetInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypeSetInstance_TypeSet() {
		return (EReference) typeSetInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAnonymousTypeSet() {
		return anonymousTypeSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypeProductInstance() {
		return typeProductInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypeProductInstance_Types() {
		return (EReference) typeProductInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractTypeSet() {
		return abstractTypeSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractTypeSet_Elements() {
		return (EReference) abstractTypeSetEClass.getEStructuralFeatures().get(0);
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
	public EEnum getBindingType() {
		return bindingTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMV2InstanceFactory getEMV2InstanceFactory() {
		return (EMV2InstanceFactory) getEFactoryInstance();
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
		emv2AnnexInstanceEClass = createEClass(EMV2_ANNEX_INSTANCE);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__TRANSITIONS);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__PROPAGATION_POINTS);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__EVENTS);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__STATE_MACHINE);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__ERROR_PROPAGATION_CONDITIONS);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__ERROR_DETECTIONS);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__ERROR_FLOWS);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__COMPOSITES);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__OLD_PROPAGATION_PATHS);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__PROPAGATIONS);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__PROPAGATION_PATHS);

		emv2InstanceObjectEClass = createEClass(EMV2_INSTANCE_OBJECT);

		stateMachineInstanceEClass = createEClass(STATE_MACHINE_INSTANCE);
		createEReference(stateMachineInstanceEClass, STATE_MACHINE_INSTANCE__STATES);
		createEReference(stateMachineInstanceEClass, STATE_MACHINE_INSTANCE__CURRENT_STATE);
		createEReference(stateMachineInstanceEClass, STATE_MACHINE_INSTANCE__STATE_MACHINE);

		stateInstanceEClass = createEClass(STATE_INSTANCE);
		createEReference(stateInstanceEClass, STATE_INSTANCE__STATE);

		constrainedInstanceObjectEClass = createEClass(CONSTRAINED_INSTANCE_OBJECT);
		createEReference(constrainedInstanceObjectEClass, CONSTRAINED_INSTANCE_OBJECT__INSTANCE_OBJECT);
		createEReference(constrainedInstanceObjectEClass, CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT);
		createEAttribute(constrainedInstanceObjectEClass, CONSTRAINED_INSTANCE_OBJECT__PROPAGATION_KIND);

		stateTransitionInstanceEClass = createEClass(STATE_TRANSITION_INSTANCE);
		createEReference(stateTransitionInstanceEClass, STATE_TRANSITION_INSTANCE__STATE_TRANSITION);
		createEReference(stateTransitionInstanceEClass, STATE_TRANSITION_INSTANCE__IN_STATES);
		createEReference(stateTransitionInstanceEClass, STATE_TRANSITION_INSTANCE__CONDITION);
		createEReference(stateTransitionInstanceEClass, STATE_TRANSITION_INSTANCE__TARGET_STATE);

		compositeStateInstanceEClass = createEClass(COMPOSITE_STATE_INSTANCE);
		createEReference(compositeStateInstanceEClass, COMPOSITE_STATE_INSTANCE__TARGET_STATE);
		createEReference(compositeStateInstanceEClass, COMPOSITE_STATE_INSTANCE__CONDITION);
		createEReference(compositeStateInstanceEClass, COMPOSITE_STATE_INSTANCE__COMPOSITE_STATE);

		errorPropagationConditionInstanceEClass = createEClass(ERROR_PROPAGATION_CONDITION_INSTANCE);
		createEReference(errorPropagationConditionInstanceEClass, ERROR_PROPAGATION_CONDITION_INSTANCE__EMV2_ELEMENT);
		createEReference(errorPropagationConditionInstanceEClass, ERROR_PROPAGATION_CONDITION_INSTANCE__IN_STATES);
		createEReference(errorPropagationConditionInstanceEClass, ERROR_PROPAGATION_CONDITION_INSTANCE__CONDITION);
		createEReference(errorPropagationConditionInstanceEClass,
				ERROR_PROPAGATION_CONDITION_INSTANCE__OUTGOING_PROPAGATION);
		createEAttribute(errorPropagationConditionInstanceEClass, ERROR_PROPAGATION_CONDITION_INSTANCE__SOURCE);
		createEAttribute(errorPropagationConditionInstanceEClass, ERROR_PROPAGATION_CONDITION_INSTANCE__SINK);

		errorDetectionInstanceEClass = createEClass(ERROR_DETECTION_INSTANCE);
		createEReference(errorDetectionInstanceEClass, ERROR_DETECTION_INSTANCE__EMV2_ELEMENT);
		createEReference(errorDetectionInstanceEClass, ERROR_DETECTION_INSTANCE__IN_STATES);
		createEReference(errorDetectionInstanceEClass, ERROR_DETECTION_INSTANCE__CONDITION);
		createEAttribute(errorDetectionInstanceEClass, ERROR_DETECTION_INSTANCE__ERROR_CODE);
		createEReference(errorDetectionInstanceEClass, ERROR_DETECTION_INSTANCE__PORT);

		eventInstanceEClass = createEClass(EVENT_INSTANCE);
		createEReference(eventInstanceEClass, EVENT_INSTANCE__EVENT);
		createEReference(eventInstanceEClass, EVENT_INSTANCE__GENERATED_TYPED_EVENTS);

		constraintExpressionEClass = createEClass(CONSTRAINT_EXPRESSION);
		createEAttribute(constraintExpressionEClass, CONSTRAINT_EXPRESSION__OPERATOR);
		createEAttribute(constraintExpressionEClass, CONSTRAINT_EXPRESSION__K);
		createEReference(constraintExpressionEClass, CONSTRAINT_EXPRESSION__CONSTRAINT_ELEMENTS);

		constraintElementEClass = createEClass(CONSTRAINT_ELEMENT);

		oldPropagationPathInstanceEClass = createEClass(OLD_PROPAGATION_PATH_INSTANCE);
		createEReference(oldPropagationPathInstanceEClass, OLD_PROPAGATION_PATH_INSTANCE__EMV2_ELEMENT);
		createEReference(oldPropagationPathInstanceEClass, OLD_PROPAGATION_PATH_INSTANCE__SOURCE);
		createEReference(oldPropagationPathInstanceEClass, OLD_PROPAGATION_PATH_INSTANCE__TARGET);

		errorPropagationInstanceEClass = createEClass(ERROR_PROPAGATION_INSTANCE);
		createEReference(errorPropagationInstanceEClass, ERROR_PROPAGATION_INSTANCE__IN_ERROR_PROPAGATION);
		createEReference(errorPropagationInstanceEClass, ERROR_PROPAGATION_INSTANCE__OUT_ERROR_PROPAGATION);
		createEReference(errorPropagationInstanceEClass, ERROR_PROPAGATION_INSTANCE__IN_TYPE_SET);
		createEReference(errorPropagationInstanceEClass, ERROR_PROPAGATION_INSTANCE__OUT_TYPE_SET);
		createEReference(errorPropagationInstanceEClass, ERROR_PROPAGATION_INSTANCE__ERROR_SOURCES);
		createEReference(errorPropagationInstanceEClass, ERROR_PROPAGATION_INSTANCE__ERROR_SINKS);
		createEReference(errorPropagationInstanceEClass, ERROR_PROPAGATION_INSTANCE__SOURCE_ERROR_PATHS);
		createEReference(errorPropagationInstanceEClass, ERROR_PROPAGATION_INSTANCE__DESTINATION_ERROR_PATHS);

		featurePropagationEClass = createEClass(FEATURE_PROPAGATION);
		createEReference(featurePropagationEClass, FEATURE_PROPAGATION__FEATURE);

		pointPropagationEClass = createEClass(POINT_PROPAGATION);
		createEReference(pointPropagationEClass, POINT_PROPAGATION__POINT);

		accessPropagationEClass = createEClass(ACCESS_PROPAGATION);

		bindingPropagationEClass = createEClass(BINDING_PROPAGATION);
		createEAttribute(bindingPropagationEClass, BINDING_PROPAGATION__BINDING);

		typeSetElementEClass = createEClass(TYPE_SET_ELEMENT);

		typeTokenInstanceEClass = createEClass(TYPE_TOKEN_INSTANCE);

		typeInstanceEClass = createEClass(TYPE_INSTANCE);
		createEReference(typeInstanceEClass, TYPE_INSTANCE__TYPE);

		typeProductInstanceEClass = createEClass(TYPE_PRODUCT_INSTANCE);
		createEReference(typeProductInstanceEClass, TYPE_PRODUCT_INSTANCE__TYPES);

		abstractTypeSetEClass = createEClass(ABSTRACT_TYPE_SET);
		createEReference(abstractTypeSetEClass, ABSTRACT_TYPE_SET__ELEMENTS);

		typeSetInstanceEClass = createEClass(TYPE_SET_INSTANCE);
		createEReference(typeSetInstanceEClass, TYPE_SET_INSTANCE__TYPE_SET);

		anonymousTypeSetEClass = createEClass(ANONYMOUS_TYPE_SET);

		errorFlowInstanceEClass = createEClass(ERROR_FLOW_INSTANCE);

		errorSourceInstanceEClass = createEClass(ERROR_SOURCE_INSTANCE);
		createEReference(errorSourceInstanceEClass, ERROR_SOURCE_INSTANCE__ERROR_SOURCE);
		createEReference(errorSourceInstanceEClass, ERROR_SOURCE_INSTANCE__PROPAGATION);
		createEReference(errorSourceInstanceEClass, ERROR_SOURCE_INSTANCE__TYPE_SET);

		errorSinkInstanceEClass = createEClass(ERROR_SINK_INSTANCE);
		createEReference(errorSinkInstanceEClass, ERROR_SINK_INSTANCE__ERROR_SINK);
		createEReference(errorSinkInstanceEClass, ERROR_SINK_INSTANCE__PROPAGATION);
		createEReference(errorSinkInstanceEClass, ERROR_SINK_INSTANCE__TYPE_SET);

		errorPathInstanceEClass = createEClass(ERROR_PATH_INSTANCE);
		createEReference(errorPathInstanceEClass, ERROR_PATH_INSTANCE__ERROR_PATH);
		createEReference(errorPathInstanceEClass, ERROR_PATH_INSTANCE__SOURCE_PROPAGATION);
		createEReference(errorPathInstanceEClass, ERROR_PATH_INSTANCE__SOURCE_TYPE_SET);
		createEReference(errorPathInstanceEClass, ERROR_PATH_INSTANCE__DESTINATION_PROPAGATION);
		createEReference(errorPathInstanceEClass, ERROR_PATH_INSTANCE__DESTINATION_TYPE_SET);

		propagationPointInstanceEClass = createEClass(PROPAGATION_POINT_INSTANCE);
		createEReference(propagationPointInstanceEClass, PROPAGATION_POINT_INSTANCE__PROPAGATION_POINT);

		propagationPathInstanceEClass = createEClass(PROPAGATION_PATH_INSTANCE);

		connectionPathEClass = createEClass(CONNECTION_PATH);
		createEReference(connectionPathEClass, CONNECTION_PATH__CONNECTION);
		createEReference(connectionPathEClass, CONNECTION_PATH__SOURCE_PROPAGATIONS);
		createEReference(connectionPathEClass, CONNECTION_PATH__DESTINATION_PROPAGATIONS);

		bindingPathEClass = createEClass(BINDING_PATH);
		createEReference(bindingPathEClass, BINDING_PATH__SOURCE_PROPAGATION);
		createEReference(bindingPathEClass, BINDING_PATH__DESTINATION_PROPAGATION);

		userDefinedPathEClass = createEClass(USER_DEFINED_PATH);
		createEReference(userDefinedPathEClass, USER_DEFINED_PATH__PATH);
		createEReference(userDefinedPathEClass, USER_DEFINED_PATH__SOURCE_PROPAGATION);
		createEReference(userDefinedPathEClass, USER_DEFINED_PATH__DESTINATION_PROPAGATION);

		// Create enums
		eOperationEEnum = createEEnum(EOPERATION);
		bindingTypeEEnum = createEEnum(BINDING_TYPE);
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
		InstancePackage theInstancePackage = (InstancePackage) EPackage.Registry.INSTANCE
				.getEPackage(InstancePackage.eNS_URI);
		ErrorModelPackage theErrorModelPackage = (ErrorModelPackage) EPackage.Registry.INSTANCE
				.getEPackage(ErrorModelPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		Aadl2Package theAadl2Package = (Aadl2Package) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		emv2AnnexInstanceEClass.getESuperTypes().add(theInstancePackage.getAnnexInstance());
		emv2InstanceObjectEClass.getESuperTypes().add(theInstancePackage.getInstanceObject());
		stateMachineInstanceEClass.getESuperTypes().add(getEMV2InstanceObject());
		stateInstanceEClass.getESuperTypes().add(getEMV2InstanceObject());
		constrainedInstanceObjectEClass.getESuperTypes().add(getConstraintElement());
		stateTransitionInstanceEClass.getESuperTypes().add(getEMV2InstanceObject());
		compositeStateInstanceEClass.getESuperTypes().add(getEMV2InstanceObject());
		errorPropagationConditionInstanceEClass.getESuperTypes().add(getEMV2InstanceObject());
		errorDetectionInstanceEClass.getESuperTypes().add(getEMV2InstanceObject());
		eventInstanceEClass.getESuperTypes().add(getEMV2InstanceObject());
		constraintExpressionEClass.getESuperTypes().add(getConstraintElement());
		constraintElementEClass.getESuperTypes().add(getEMV2InstanceObject());
		oldPropagationPathInstanceEClass.getESuperTypes().add(getEMV2InstanceObject());
		errorPropagationInstanceEClass.getESuperTypes().add(getConstrainedInstanceObject());
		featurePropagationEClass.getESuperTypes().add(getErrorPropagationInstance());
		pointPropagationEClass.getESuperTypes().add(getErrorPropagationInstance());
		accessPropagationEClass.getESuperTypes().add(getErrorPropagationInstance());
		bindingPropagationEClass.getESuperTypes().add(getErrorPropagationInstance());
		typeSetElementEClass.getESuperTypes().add(getEMV2InstanceObject());
		typeTokenInstanceEClass.getESuperTypes().add(getTypeSetElement());
		typeInstanceEClass.getESuperTypes().add(getTypeTokenInstance());
		typeProductInstanceEClass.getESuperTypes().add(getTypeTokenInstance());
		abstractTypeSetEClass.getESuperTypes().add(getEMV2InstanceObject());
		typeSetInstanceEClass.getESuperTypes().add(getAbstractTypeSet());
		typeSetInstanceEClass.getESuperTypes().add(getTypeSetElement());
		anonymousTypeSetEClass.getESuperTypes().add(getAbstractTypeSet());
		errorFlowInstanceEClass.getESuperTypes().add(getEMV2InstanceObject());
		errorSourceInstanceEClass.getESuperTypes().add(getErrorFlowInstance());
		errorSinkInstanceEClass.getESuperTypes().add(getErrorFlowInstance());
		errorPathInstanceEClass.getESuperTypes().add(getErrorFlowInstance());
		propagationPointInstanceEClass.getESuperTypes().add(getEMV2InstanceObject());
		propagationPathInstanceEClass.getESuperTypes().add(getEMV2InstanceObject());
		connectionPathEClass.getESuperTypes().add(getPropagationPathInstance());
		bindingPathEClass.getESuperTypes().add(getPropagationPathInstance());
		userDefinedPathEClass.getESuperTypes().add(getPropagationPathInstance());

		// Initialize classes and features; add operations and parameters
		initEClass(emv2AnnexInstanceEClass, EMV2AnnexInstance.class, "EMV2AnnexInstance", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEMV2AnnexInstance_Transitions(), getStateTransitionInstance(), null, "transitions", null, 0,
				-1, EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_PropagationPoints(), getPropagationPointInstance(), null,
				"propagationPoints", null, 0, -1, EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_Events(), getEventInstance(), null, "events", null, 0, -1,
				EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_StateMachine(), getStateMachineInstance(), null, "stateMachine", null, 0, 1,
				EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_ErrorPropagationConditions(), getErrorPropagationConditionInstance(), null,
				"errorPropagationConditions", null, 0, -1, EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_ErrorDetections(), getErrorDetectionInstance(), null, "errorDetections",
				null, 0, -1, EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_ErrorFlows(), getErrorFlowInstance(), null, "errorFlows", null, 0, -1,
				EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_Composites(), getCompositeStateInstance(), null, "composites", null, 0, -1,
				EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_OldPropagationPaths(), getOldPropagationPathInstance(), null,
				"oldPropagationPaths", null, 0, -1, EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_Propagations(), getErrorPropagationInstance(), null, "propagations", null,
				0, -1, EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_PropagationPaths(), getPropagationPathInstance(), null, "propagationPaths",
				null, 0, -1, EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(emv2InstanceObjectEClass, EMV2InstanceObject.class, "EMV2InstanceObject", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(stateMachineInstanceEClass, StateMachineInstance.class, "StateMachineInstance", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateMachineInstance_States(), getStateInstance(), null, "states", null, 0, -1,
				StateMachineInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachineInstance_CurrentState(), getStateInstance(), null, "currentState", null, 0, 1,
				StateMachineInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachineInstance_StateMachine(), theErrorModelPackage.getErrorBehaviorStateMachine(),
				null, "stateMachine", null, 0, 1, StateMachineInstance.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateInstanceEClass, StateInstance.class, "StateInstance", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateInstance_State(), theErrorModelPackage.getErrorBehaviorState(), null, "state", null, 0,
				1, StateInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constrainedInstanceObjectEClass, ConstrainedInstanceObject.class, "ConstrainedInstanceObject",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstrainedInstanceObject_InstanceObject(), theInstancePackage.getInstanceObject(), null,
				"instanceObject", null, 0, 1, ConstrainedInstanceObject.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstrainedInstanceObject_Constraint(), theErrorModelPackage.getTypeToken(), null,
				"constraint", null, 0, -1, ConstrainedInstanceObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstrainedInstanceObject_PropagationKind(), ecorePackage.getEString(), "propagationKind",
				null, 0, 1, ConstrainedInstanceObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateTransitionInstanceEClass, StateTransitionInstance.class, "StateTransitionInstance",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateTransitionInstance_StateTransition(), theEcorePackage.getEObject(), null,
				"stateTransition", null, 0, 1, StateTransitionInstance.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateTransitionInstance_InStates(), getStateInstance(), null, "inStates", null, 0, -1,
				StateTransitionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateTransitionInstance_Condition(), getConstraintElement(), null, "condition", null, 0, 1,
				StateTransitionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateTransitionInstance_TargetState(), getStateInstance(), null, "targetState", null, 0, 1,
				StateTransitionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeStateInstanceEClass, CompositeStateInstance.class, "CompositeStateInstance", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeStateInstance_TargetState(), getStateInstance(), null, "targetState", null, 0, 1,
				CompositeStateInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeStateInstance_Condition(), getConstraintElement(), null, "condition", null, 0, 1,
				CompositeStateInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeStateInstance_CompositeState(), theErrorModelPackage.getCompositeState(), null,
				"compositeState", null, 0, 1, CompositeStateInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorPropagationConditionInstanceEClass, ErrorPropagationConditionInstance.class,
				"ErrorPropagationConditionInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorPropagationConditionInstance_Emv2Element(),
				theErrorModelPackage.getOutgoingPropagationCondition(), null, "emv2Element", null, 0, 1,
				ErrorPropagationConditionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPropagationConditionInstance_InStates(), getStateInstance(), null, "inStates", null, 0,
				-1, ErrorPropagationConditionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPropagationConditionInstance_Condition(), getConstraintElement(), null, "condition",
				null, 0, 1, ErrorPropagationConditionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPropagationConditionInstance_OutgoingPropagation(), getConstrainedInstanceObject(), null,
				"outgoingPropagation", null, 0, 1, ErrorPropagationConditionInstance.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorPropagationConditionInstance_Source(), ecorePackage.getEBoolean(), "source", null, 0, 1,
				ErrorPropagationConditionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorPropagationConditionInstance_Sink(), ecorePackage.getEBoolean(), "sink", null, 0, 1,
				ErrorPropagationConditionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorDetectionInstanceEClass, ErrorDetectionInstance.class, "ErrorDetectionInstance", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorDetectionInstance_Emv2Element(), theErrorModelPackage.getErrorDetection(), null,
				"emv2Element", null, 0, 1, ErrorDetectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorDetectionInstance_InStates(), getStateInstance(), null, "inStates", null, 0, -1,
				ErrorDetectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorDetectionInstance_Condition(), getConstraintElement(), null, "condition", null, 0, 1,
				ErrorDetectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getErrorDetectionInstance_ErrorCode(), ecorePackage.getEString(), "errorCode", null, 0, 1,
				ErrorDetectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorDetectionInstance_Port(), theInstancePackage.getFeatureInstance(), null, "port", null, 0,
				1, ErrorDetectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventInstanceEClass, EventInstance.class, "EventInstance", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEventInstance_Event(), theErrorModelPackage.getErrorBehaviorEvent(), null, "event", null, 0,
				1, EventInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEventInstance_GeneratedTypedEvents(), getConstrainedInstanceObject(), null,
				"generatedTypedEvents", null, 0, -1, EventInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintExpressionEClass, ConstraintExpression.class, "ConstraintExpression", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstraintExpression_Operator(), getEOperation(), "operator", null, 0, 1,
				ConstraintExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstraintExpression_K(), ecorePackage.getELong(), "k", null, 0, 1,
				ConstraintExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraintExpression_ConstraintElements(), getConstraintElement(), null, "constraintElements",
				null, 0, -1, ConstraintExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintElementEClass, ConstraintElement.class, "ConstraintElement", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(oldPropagationPathInstanceEClass, OldPropagationPathInstance.class, "OldPropagationPathInstance",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOldPropagationPathInstance_Emv2Element(), theAadl2Package.getNamedElement(), null,
				"emv2Element", null, 0, 1, OldPropagationPathInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOldPropagationPathInstance_Source(), getConstraintElement(), null, "source", null, 0, 1,
				OldPropagationPathInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOldPropagationPathInstance_Target(), getConstrainedInstanceObject(), null, "target", null, 0,
				1, OldPropagationPathInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorPropagationInstanceEClass, ErrorPropagationInstance.class, "ErrorPropagationInstance",
				IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorPropagationInstance_InErrorPropagation(), theErrorModelPackage.getErrorPropagation(),
				null, "inErrorPropagation", null, 0, 1, ErrorPropagationInstance.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPropagationInstance_OutErrorPropagation(), theErrorModelPackage.getErrorPropagation(),
				null, "outErrorPropagation", null, 0, 1, ErrorPropagationInstance.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPropagationInstance_InTypeSet(), getAnonymousTypeSet(), null, "inTypeSet", null, 0, 1,
				ErrorPropagationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPropagationInstance_OutTypeSet(), getAnonymousTypeSet(), null, "outTypeSet", null, 0, 1,
				ErrorPropagationInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPropagationInstance_ErrorSources(), getErrorSourceInstance(),
				getErrorSourceInstance_Propagation(), "errorSources", null, 0, -1, ErrorPropagationInstance.class,
				IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPropagationInstance_ErrorSinks(), getErrorSinkInstance(),
				getErrorSinkInstance_Propagation(), "errorSinks", null, 0, -1, ErrorPropagationInstance.class,
				IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPropagationInstance_SourceErrorPaths(), getErrorPathInstance(),
				getErrorPathInstance_SourcePropagation(), "sourceErrorPaths", null, 0, -1,
				ErrorPropagationInstance.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPropagationInstance_DestinationErrorPaths(), getErrorPathInstance(),
				getErrorPathInstance_DestinationPropagation(), "destinationErrorPaths", null, 0, -1,
				ErrorPropagationInstance.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(errorPropagationInstanceEClass, theAadl2Package.getDirectionType(), "getDirection", 0, 1,
				IS_UNIQUE, IS_ORDERED);

		initEClass(featurePropagationEClass, FeaturePropagation.class, "FeaturePropagation", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeaturePropagation_Feature(), theInstancePackage.getFeatureInstance(), null, "feature", null,
				0, 1, FeaturePropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pointPropagationEClass, PointPropagation.class, "PointPropagation", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPointPropagation_Point(), getPropagationPointInstance(), null, "point", null, 0, 1,
				PointPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(accessPropagationEClass, AccessPropagation.class, "AccessPropagation", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(bindingPropagationEClass, BindingPropagation.class, "BindingPropagation", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBindingPropagation_Binding(), getBindingType(), "binding", null, 0, 1,
				BindingPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(typeSetElementEClass, TypeSetElement.class, "TypeSetElement", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeTokenInstanceEClass, TypeTokenInstance.class, "TypeTokenInstance", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeInstanceEClass, TypeInstance.class, "TypeInstance", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeInstance_Type(), theErrorModelPackage.getErrorType(), null, "type", null, 0, 1,
				TypeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(typeInstanceEClass, theErrorModelPackage.getErrorType(), "resolveAlias", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEClass(typeProductInstanceEClass, TypeProductInstance.class, "TypeProductInstance", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeProductInstance_Types(), getTypeInstance(), null, "types", null, 0, -1,
				TypeProductInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractTypeSetEClass, AbstractTypeSet.class, "AbstractTypeSet", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractTypeSet_Elements(), getTypeSetElement(), null, "elements", null, 0, -1,
				AbstractTypeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(abstractTypeSetEClass, getTypeTokenInstance(), "flatten", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(typeSetInstanceEClass, TypeSetInstance.class, "TypeSetInstance", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeSetInstance_TypeSet(), theErrorModelPackage.getTypeSet(), null, "typeSet", null, 0, 1,
				TypeSetInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(typeSetInstanceEClass, theErrorModelPackage.getTypeSet(), "resolveAlias", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEClass(anonymousTypeSetEClass, AnonymousTypeSet.class, "AnonymousTypeSet", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(errorFlowInstanceEClass, ErrorFlowInstance.class, "ErrorFlowInstance", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(errorSourceInstanceEClass, ErrorSourceInstance.class, "ErrorSourceInstance", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorSourceInstance_ErrorSource(), theErrorModelPackage.getErrorSource(), null, "errorSource",
				null, 0, 1, ErrorSourceInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorSourceInstance_Propagation(), getErrorPropagationInstance(),
				getErrorPropagationInstance_ErrorSources(), "propagation", null, 0, 1, ErrorSourceInstance.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorSourceInstance_TypeSet(), getAnonymousTypeSet(), null, "typeSet", null, 0, 1,
				ErrorSourceInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorSinkInstanceEClass, ErrorSinkInstance.class, "ErrorSinkInstance", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorSinkInstance_ErrorSink(), theErrorModelPackage.getErrorSink(), null, "errorSink", null,
				0, 1, ErrorSinkInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorSinkInstance_Propagation(), getErrorPropagationInstance(),
				getErrorPropagationInstance_ErrorSinks(), "propagation", null, 0, 1, ErrorSinkInstance.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorSinkInstance_TypeSet(), getAnonymousTypeSet(), null, "typeSet", null, 0, 1,
				ErrorSinkInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorPathInstanceEClass, ErrorPathInstance.class, "ErrorPathInstance", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorPathInstance_ErrorPath(), theErrorModelPackage.getErrorPath(), null, "errorPath", null,
				0, 1, ErrorPathInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPathInstance_SourcePropagation(), getErrorPropagationInstance(),
				getErrorPropagationInstance_SourceErrorPaths(), "sourcePropagation", null, 0, 1,
				ErrorPathInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPathInstance_SourceTypeSet(), getAnonymousTypeSet(), null, "sourceTypeSet", null, 0, 1,
				ErrorPathInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPathInstance_DestinationPropagation(), getErrorPropagationInstance(),
				getErrorPropagationInstance_DestinationErrorPaths(), "destinationPropagation", null, 0, 1,
				ErrorPathInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorPathInstance_DestinationTypeSet(), getAnonymousTypeSet(), null, "destinationTypeSet",
				null, 0, 1, ErrorPathInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(errorPathInstanceEClass, getTypeTokenInstance(), "getDestinationTypeToken", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEClass(propagationPointInstanceEClass, PropagationPointInstance.class, "PropagationPointInstance",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropagationPointInstance_PropagationPoint(), theErrorModelPackage.getPropagationPoint(), null,
				"propagationPoint", null, 0, 1, PropagationPointInstance.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propagationPathInstanceEClass, PropagationPathInstance.class, "PropagationPathInstance", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(connectionPathEClass, ConnectionPath.class, "ConnectionPath", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectionPath_Connection(), theInstancePackage.getConnectionInstance(), null, "connection",
				null, 0, 1, ConnectionPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionPath_SourcePropagations(), getErrorPropagationInstance(), null,
				"sourcePropagations", null, 0, -1, ConnectionPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionPath_DestinationPropagations(), getErrorPropagationInstance(), null,
				"destinationPropagations", null, 0, -1, ConnectionPath.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(connectionPathEClass, getErrorPropagationInstance(), "getSourcePropagation", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		addEOperation(connectionPathEClass, getErrorPropagationInstance(), "getDestinationPropagation", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEClass(bindingPathEClass, BindingPath.class, "BindingPath", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBindingPath_SourcePropagation(), getBindingPropagation(), null, "sourcePropagation", null, 0,
				1, BindingPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBindingPath_DestinationPropagation(), getBindingPropagation(), null, "destinationPropagation",
				null, 0, 1, BindingPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userDefinedPathEClass, UserDefinedPath.class, "UserDefinedPath", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserDefinedPath_Path(), theErrorModelPackage.getPropagationPath(), null, "path", null, 0, 1,
				UserDefinedPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUserDefinedPath_SourcePropagation(), getPointPropagation(), null, "sourcePropagation", null,
				0, 1, UserDefinedPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUserDefinedPath_DestinationPropagation(), getPointPropagation(), null,
				"destinationPropagation", null, 0, 1, UserDefinedPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(eOperationEEnum, EOperation.class, "EOperation");
		addEEnumLiteral(eOperationEEnum, EOperation.ANY);
		addEEnumLiteral(eOperationEEnum, EOperation.ALL);
		addEEnumLiteral(eOperationEEnum, EOperation.ONEOF);
		addEEnumLiteral(eOperationEEnum, EOperation.KOFN);
		addEEnumLiteral(eOperationEEnum, EOperation.KORMORE);
		addEEnumLiteral(eOperationEEnum, EOperation.KORLESS);

		initEEnum(bindingTypeEEnum, BindingType.class, "BindingType");
		addEEnumLiteral(bindingTypeEEnum, BindingType.PROCESSOR);
		addEEnumLiteral(bindingTypeEEnum, BindingType.MEMORY);
		addEEnumLiteral(bindingTypeEEnum, BindingType.CONNECTION);
		addEEnumLiteral(bindingTypeEEnum, BindingType.BINDING);
		addEEnumLiteral(bindingTypeEEnum, BindingType.BINDINGS);

		// Create resource
		createResource(eNS_URI);
	}

} // EMV2InstancePackageImpl
