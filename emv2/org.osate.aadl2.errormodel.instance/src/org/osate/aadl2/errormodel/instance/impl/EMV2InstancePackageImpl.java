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
import org.osate.aadl2.errormodel.instance.AllPropagations;
import org.osate.aadl2.errormodel.instance.AllPropagationsNoError;
import org.osate.aadl2.errormodel.instance.AllSources;
import org.osate.aadl2.errormodel.instance.AnonymousTypeSet;
import org.osate.aadl2.errormodel.instance.BindingPath;
import org.osate.aadl2.errormodel.instance.BindingPropagation;
import org.osate.aadl2.errormodel.instance.BindingType;
import org.osate.aadl2.errormodel.instance.Branch;
import org.osate.aadl2.errormodel.instance.BranchSameState;
import org.osate.aadl2.errormodel.instance.BranchStateReference;
import org.osate.aadl2.errormodel.instance.Branches;
import org.osate.aadl2.errormodel.instance.CompositeConditionExpression;
import org.osate.aadl2.errormodel.instance.CompositeStateInstance;
import org.osate.aadl2.errormodel.instance.ConditionExpressionInstance;
import org.osate.aadl2.errormodel.instance.ConditionPropagationReference;
import org.osate.aadl2.errormodel.instance.ConnectionEndPropagation;
import org.osate.aadl2.errormodel.instance.ConnectionPath;
import org.osate.aadl2.errormodel.instance.ConstantCode;
import org.osate.aadl2.errormodel.instance.ConstrainedInstanceObject;
import org.osate.aadl2.errormodel.instance.ConstraintElement;
import org.osate.aadl2.errormodel.instance.ConstraintExpression;
import org.osate.aadl2.errormodel.instance.CountExpression;
import org.osate.aadl2.errormodel.instance.CountExpressionOperation;
import org.osate.aadl2.errormodel.instance.DestinationPropagationReference;
import org.osate.aadl2.errormodel.instance.DestinationStateReference;
import org.osate.aadl2.errormodel.instance.DetectionInstance;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.EMV2InstanceFactory;
import org.osate.aadl2.errormodel.instance.EMV2InstanceObject;
import org.osate.aadl2.errormodel.instance.EMV2InstancePackage;
import org.osate.aadl2.errormodel.instance.EOperation;
import org.osate.aadl2.errormodel.instance.ErrorCodeInstance;
import org.osate.aadl2.errormodel.instance.ErrorEventInstance;
import org.osate.aadl2.errormodel.instance.ErrorFlowInstance;
import org.osate.aadl2.errormodel.instance.ErrorPathInstance;
import org.osate.aadl2.errormodel.instance.ErrorPropagationInstance;
import org.osate.aadl2.errormodel.instance.ErrorSinkInstance;
import org.osate.aadl2.errormodel.instance.ErrorSourceInstance;
import org.osate.aadl2.errormodel.instance.EventInstance;
import org.osate.aadl2.errormodel.instance.EventReference;
import org.osate.aadl2.errormodel.instance.FeaturePropagation;
import org.osate.aadl2.errormodel.instance.IntegerCode;
import org.osate.aadl2.errormodel.instance.ModeMappingInstance;
import org.osate.aadl2.errormodel.instance.NoErrorPropagationReference;
import org.osate.aadl2.errormodel.instance.OthersExpression;
import org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionDestination;
import org.osate.aadl2.errormodel.instance.OutgoingPropagationConditionInstance;
import org.osate.aadl2.errormodel.instance.PointPropagation;
import org.osate.aadl2.errormodel.instance.PropagationPathInstance;
import org.osate.aadl2.errormodel.instance.PropagationPointInstance;
import org.osate.aadl2.errormodel.instance.RecoverEventInstance;
import org.osate.aadl2.errormodel.instance.RepairEventInstance;
import org.osate.aadl2.errormodel.instance.SameState;
import org.osate.aadl2.errormodel.instance.SourceStateReference;
import org.osate.aadl2.errormodel.instance.StateInstance;
import org.osate.aadl2.errormodel.instance.StateReference;
import org.osate.aadl2.errormodel.instance.StateSource;
import org.osate.aadl2.errormodel.instance.StringCode;
import org.osate.aadl2.errormodel.instance.TransitionDestination;
import org.osate.aadl2.errormodel.instance.TransitionInstance;
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
	private EClass compositeStateInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeConditionExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass othersExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateReferenceEClass = null;

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
	private EClass errorEventInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recoverEventInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repairEventInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transitionInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateSourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceStateReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allSourcesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionExpressionInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionPropagationReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass noErrorPropagationReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass countExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transitionDestinationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass destinationStateReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sameStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass branchesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass branchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass branchStateReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass branchSameStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outgoingPropagationConditionInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outgoingPropagationConditionDestinationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass destinationPropagationReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allPropagationsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allPropagationsNoErrorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass detectionInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorCodeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerCodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringCodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constantCodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modeMappingInstanceEClass = null;

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
	private EClass errorPropagationInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionEndPropagationEClass = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum countExpressionOperationEEnum = null;

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
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_Conditions() {
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_PropagationPoints() {
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_Events() {
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_Detections() {
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_ModeMappings() {
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_ErrorFlows() {
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_Composites() {
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_Propagations() {
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_PropagationPaths() {
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_States() {
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEMV2AnnexInstance_InitialState() {
		return (EReference) emv2AnnexInstanceEClass.getEStructuralFeatures().get(4);
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
	public EReference getStateInstance_TypeSet() {
		return (EReference) stateInstanceEClass.getEStructuralFeatures().get(1);
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
	public EClass getCompositeStateInstance() {
		return compositeStateInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositeStateInstance_Composite() {
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
	public EReference getCompositeStateInstance_Destination() {
		return (EReference) compositeStateInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCompositeStateInstance_DestinationTypeSet() {
		return (EReference) compositeStateInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCompositeConditionExpression() {
		return compositeConditionExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOthersExpression() {
		return othersExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStateReference() {
		return stateReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStateReference_State() {
		return (EReference) stateReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStateReference_TypeSet() {
		return (EReference) stateReferenceEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getBindingPath_Type() {
		return (EAttribute) bindingPathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBindingPath_SourcePropagations() {
		return (EReference) bindingPathEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBindingPath_DestinationPropagations() {
		return (EReference) bindingPathEClass.getEStructuralFeatures().get(2);
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
	public EReference getUserDefinedPath_SourcePoint() {
		return (EReference) userDefinedPathEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUserDefinedPath_DestinationPoint() {
		return (EReference) userDefinedPathEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUserDefinedPath_SourcePropagation() {
		return (EReference) userDefinedPathEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUserDefinedPath_DestinationPropagation() {
		return (EReference) userDefinedPathEClass.getEStructuralFeatures().get(4);
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
	public EClass getErrorEventInstance() {
		return errorEventInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorEventInstance_ErrorEvent() {
		return (EReference) errorEventInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getErrorEventInstance_TypeSet() {
		return (EReference) errorEventInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRecoverEventInstance() {
		return recoverEventInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRecoverEventInstance_RecoverEvent() {
		return (EReference) recoverEventInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRecoverEventInstance_EventInitiators() {
		return (EReference) recoverEventInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRepairEventInstance() {
		return repairEventInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRepairEventInstance_RepairEvent() {
		return (EReference) repairEventInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRepairEventInstance_EventInitiators() {
		return (EReference) repairEventInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTransitionInstance() {
		return transitionInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransitionInstance_Condition() {
		return (EReference) transitionInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransitionInstance_Destination() {
		return (EReference) transitionInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStateSource() {
		return stateSourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransitionInstance_Transition() {
		return (EReference) transitionInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTransitionInstance_Source() {
		return (EReference) transitionInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSourceStateReference() {
		return sourceStateReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSourceStateReference_State() {
		return (EReference) sourceStateReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSourceStateReference_TypeSet() {
		return (EReference) sourceStateReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAllSources() {
		return allSourcesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConditionExpressionInstance() {
		return conditionExpressionInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEventReference() {
		return eventReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEventReference_Event() {
		return (EReference) eventReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEventReference_TypeSet() {
		return (EReference) eventReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConditionPropagationReference() {
		return conditionPropagationReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConditionPropagationReference_Propagation() {
		return (EReference) conditionPropagationReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConditionPropagationReference_TypeSet() {
		return (EReference) conditionPropagationReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNoErrorPropagationReference() {
		return noErrorPropagationReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNoErrorPropagationReference_Propagation() {
		return (EReference) noErrorPropagationReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCountExpression() {
		return countExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCountExpression_Operands() {
		return (EReference) countExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCountExpression_Operation() {
		return (EAttribute) countExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCountExpression_Count() {
		return (EAttribute) countExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTransitionDestination() {
		return transitionDestinationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDestinationStateReference() {
		return destinationStateReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDestinationStateReference_State() {
		return (EReference) destinationStateReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDestinationStateReference_TypeSet() {
		return (EReference) destinationStateReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSameState() {
		return sameStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBranches() {
		return branchesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBranches_Branches() {
		return (EReference) branchesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBranch() {
		return branchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBranch_Probability() {
		return (EAttribute) branchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBranchStateReference() {
		return branchStateReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBranchStateReference_State() {
		return (EReference) branchStateReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBranchStateReference_TypeSet() {
		return (EReference) branchStateReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBranchSameState() {
		return branchSameStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOutgoingPropagationConditionInstance() {
		return outgoingPropagationConditionInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOutgoingPropagationConditionInstance_OutgoingPropagationCondition() {
		return (EReference) outgoingPropagationConditionInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOutgoingPropagationConditionInstance_Source() {
		return (EReference) outgoingPropagationConditionInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOutgoingPropagationConditionInstance_Condition() {
		return (EReference) outgoingPropagationConditionInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOutgoingPropagationConditionInstance_Destination() {
		return (EReference) outgoingPropagationConditionInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOutgoingPropagationConditionDestination() {
		return outgoingPropagationConditionDestinationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDestinationPropagationReference() {
		return destinationPropagationReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDestinationPropagationReference_Propagation() {
		return (EReference) destinationPropagationReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDestinationPropagationReference_TypeSet() {
		return (EReference) destinationPropagationReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAllPropagations() {
		return allPropagationsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAllPropagations_TypeSet() {
		return (EReference) allPropagationsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAllPropagationsNoError() {
		return allPropagationsNoErrorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDetectionInstance() {
		return detectionInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDetectionInstance_Detection() {
		return (EReference) detectionInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDetectionInstance_Source() {
		return (EReference) detectionInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDetectionInstance_Condition() {
		return (EReference) detectionInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDetectionInstance_Destination() {
		return (EReference) detectionInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDetectionInstance_ErrorCode() {
		return (EReference) detectionInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getErrorCodeInstance() {
		return errorCodeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIntegerCode() {
		return integerCodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIntegerCode_Code() {
		return (EAttribute) integerCodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStringCode() {
		return stringCodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStringCode_Code() {
		return (EAttribute) stringCodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConstantCode() {
		return constantCodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstantCode_Code() {
		return (EReference) constantCodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getModeMappingInstance() {
		return modeMappingInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModeMappingInstance_ModeMapping() {
		return (EReference) modeMappingInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModeMappingInstance_State() {
		return (EReference) modeMappingInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModeMappingInstance_TypeSet() {
		return (EReference) modeMappingInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getModeMappingInstance_Modes() {
		return (EReference) modeMappingInstanceEClass.getEStructuralFeatures().get(3);
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
	public EClass getConnectionEndPropagation() {
		return connectionEndPropagationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConnectionEndPropagation_SourceConnectionPaths() {
		return (EReference) connectionEndPropagationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConnectionEndPropagation_DestinationConnectionPaths() {
		return (EReference) connectionEndPropagationEClass.getEStructuralFeatures().get(1);
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
	public EReference getPointPropagation_SourceUserDefinedPaths() {
		return (EReference) pointPropagationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPointPropagation_DestinationUserDefinedPaths() {
		return (EReference) pointPropagationEClass.getEStructuralFeatures().get(2);
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
	public EReference getBindingPropagation_SourceBindingPaths() {
		return (EReference) bindingPropagationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBindingPropagation_DestinationBindingPaths() {
		return (EReference) bindingPropagationEClass.getEStructuralFeatures().get(2);
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
	public EEnum getCountExpressionOperation() {
		return countExpressionOperationEEnum;
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
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__PROPAGATIONS);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__ERROR_FLOWS);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__PROPAGATION_PATHS);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__STATES);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__INITIAL_STATE);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__EVENTS);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__TRANSITIONS);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__CONDITIONS);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__DETECTIONS);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__MODE_MAPPINGS);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__COMPOSITES);
		createEReference(emv2AnnexInstanceEClass, EMV2_ANNEX_INSTANCE__PROPAGATION_POINTS);

		emv2InstanceObjectEClass = createEClass(EMV2_INSTANCE_OBJECT);

		constrainedInstanceObjectEClass = createEClass(CONSTRAINED_INSTANCE_OBJECT);
		createEReference(constrainedInstanceObjectEClass, CONSTRAINED_INSTANCE_OBJECT__INSTANCE_OBJECT);
		createEReference(constrainedInstanceObjectEClass, CONSTRAINED_INSTANCE_OBJECT__CONSTRAINT);
		createEAttribute(constrainedInstanceObjectEClass, CONSTRAINED_INSTANCE_OBJECT__PROPAGATION_KIND);

		constraintExpressionEClass = createEClass(CONSTRAINT_EXPRESSION);
		createEAttribute(constraintExpressionEClass, CONSTRAINT_EXPRESSION__OPERATOR);
		createEAttribute(constraintExpressionEClass, CONSTRAINT_EXPRESSION__K);
		createEReference(constraintExpressionEClass, CONSTRAINT_EXPRESSION__CONSTRAINT_ELEMENTS);

		constraintElementEClass = createEClass(CONSTRAINT_ELEMENT);

		errorPropagationInstanceEClass = createEClass(ERROR_PROPAGATION_INSTANCE);
		createEReference(errorPropagationInstanceEClass, ERROR_PROPAGATION_INSTANCE__IN_ERROR_PROPAGATION);
		createEReference(errorPropagationInstanceEClass, ERROR_PROPAGATION_INSTANCE__OUT_ERROR_PROPAGATION);
		createEReference(errorPropagationInstanceEClass, ERROR_PROPAGATION_INSTANCE__IN_TYPE_SET);
		createEReference(errorPropagationInstanceEClass, ERROR_PROPAGATION_INSTANCE__OUT_TYPE_SET);
		createEReference(errorPropagationInstanceEClass, ERROR_PROPAGATION_INSTANCE__ERROR_SOURCES);
		createEReference(errorPropagationInstanceEClass, ERROR_PROPAGATION_INSTANCE__ERROR_SINKS);
		createEReference(errorPropagationInstanceEClass, ERROR_PROPAGATION_INSTANCE__SOURCE_ERROR_PATHS);
		createEReference(errorPropagationInstanceEClass, ERROR_PROPAGATION_INSTANCE__DESTINATION_ERROR_PATHS);

		connectionEndPropagationEClass = createEClass(CONNECTION_END_PROPAGATION);
		createEReference(connectionEndPropagationEClass, CONNECTION_END_PROPAGATION__SOURCE_CONNECTION_PATHS);
		createEReference(connectionEndPropagationEClass, CONNECTION_END_PROPAGATION__DESTINATION_CONNECTION_PATHS);

		featurePropagationEClass = createEClass(FEATURE_PROPAGATION);
		createEReference(featurePropagationEClass, FEATURE_PROPAGATION__FEATURE);

		accessPropagationEClass = createEClass(ACCESS_PROPAGATION);

		pointPropagationEClass = createEClass(POINT_PROPAGATION);
		createEReference(pointPropagationEClass, POINT_PROPAGATION__POINT);
		createEReference(pointPropagationEClass, POINT_PROPAGATION__SOURCE_USER_DEFINED_PATHS);
		createEReference(pointPropagationEClass, POINT_PROPAGATION__DESTINATION_USER_DEFINED_PATHS);

		bindingPropagationEClass = createEClass(BINDING_PROPAGATION);
		createEAttribute(bindingPropagationEClass, BINDING_PROPAGATION__BINDING);
		createEReference(bindingPropagationEClass, BINDING_PROPAGATION__SOURCE_BINDING_PATHS);
		createEReference(bindingPropagationEClass, BINDING_PROPAGATION__DESTINATION_BINDING_PATHS);

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
		createEAttribute(bindingPathEClass, BINDING_PATH__TYPE);
		createEReference(bindingPathEClass, BINDING_PATH__SOURCE_PROPAGATIONS);
		createEReference(bindingPathEClass, BINDING_PATH__DESTINATION_PROPAGATIONS);

		userDefinedPathEClass = createEClass(USER_DEFINED_PATH);
		createEReference(userDefinedPathEClass, USER_DEFINED_PATH__PATH);
		createEReference(userDefinedPathEClass, USER_DEFINED_PATH__SOURCE_POINT);
		createEReference(userDefinedPathEClass, USER_DEFINED_PATH__DESTINATION_POINT);
		createEReference(userDefinedPathEClass, USER_DEFINED_PATH__SOURCE_PROPAGATION);
		createEReference(userDefinedPathEClass, USER_DEFINED_PATH__DESTINATION_PROPAGATION);

		stateInstanceEClass = createEClass(STATE_INSTANCE);
		createEReference(stateInstanceEClass, STATE_INSTANCE__STATE);
		createEReference(stateInstanceEClass, STATE_INSTANCE__TYPE_SET);

		eventInstanceEClass = createEClass(EVENT_INSTANCE);

		errorEventInstanceEClass = createEClass(ERROR_EVENT_INSTANCE);
		createEReference(errorEventInstanceEClass, ERROR_EVENT_INSTANCE__ERROR_EVENT);
		createEReference(errorEventInstanceEClass, ERROR_EVENT_INSTANCE__TYPE_SET);

		recoverEventInstanceEClass = createEClass(RECOVER_EVENT_INSTANCE);
		createEReference(recoverEventInstanceEClass, RECOVER_EVENT_INSTANCE__RECOVER_EVENT);
		createEReference(recoverEventInstanceEClass, RECOVER_EVENT_INSTANCE__EVENT_INITIATORS);

		repairEventInstanceEClass = createEClass(REPAIR_EVENT_INSTANCE);
		createEReference(repairEventInstanceEClass, REPAIR_EVENT_INSTANCE__REPAIR_EVENT);
		createEReference(repairEventInstanceEClass, REPAIR_EVENT_INSTANCE__EVENT_INITIATORS);

		transitionInstanceEClass = createEClass(TRANSITION_INSTANCE);
		createEReference(transitionInstanceEClass, TRANSITION_INSTANCE__TRANSITION);
		createEReference(transitionInstanceEClass, TRANSITION_INSTANCE__SOURCE);
		createEReference(transitionInstanceEClass, TRANSITION_INSTANCE__CONDITION);
		createEReference(transitionInstanceEClass, TRANSITION_INSTANCE__DESTINATION);

		stateSourceEClass = createEClass(STATE_SOURCE);

		sourceStateReferenceEClass = createEClass(SOURCE_STATE_REFERENCE);
		createEReference(sourceStateReferenceEClass, SOURCE_STATE_REFERENCE__STATE);
		createEReference(sourceStateReferenceEClass, SOURCE_STATE_REFERENCE__TYPE_SET);

		allSourcesEClass = createEClass(ALL_SOURCES);

		conditionExpressionInstanceEClass = createEClass(CONDITION_EXPRESSION_INSTANCE);

		eventReferenceEClass = createEClass(EVENT_REFERENCE);
		createEReference(eventReferenceEClass, EVENT_REFERENCE__EVENT);
		createEReference(eventReferenceEClass, EVENT_REFERENCE__TYPE_SET);

		conditionPropagationReferenceEClass = createEClass(CONDITION_PROPAGATION_REFERENCE);
		createEReference(conditionPropagationReferenceEClass, CONDITION_PROPAGATION_REFERENCE__PROPAGATION);
		createEReference(conditionPropagationReferenceEClass, CONDITION_PROPAGATION_REFERENCE__TYPE_SET);

		noErrorPropagationReferenceEClass = createEClass(NO_ERROR_PROPAGATION_REFERENCE);
		createEReference(noErrorPropagationReferenceEClass, NO_ERROR_PROPAGATION_REFERENCE__PROPAGATION);

		countExpressionEClass = createEClass(COUNT_EXPRESSION);
		createEReference(countExpressionEClass, COUNT_EXPRESSION__OPERANDS);
		createEAttribute(countExpressionEClass, COUNT_EXPRESSION__OPERATION);
		createEAttribute(countExpressionEClass, COUNT_EXPRESSION__COUNT);

		transitionDestinationEClass = createEClass(TRANSITION_DESTINATION);

		destinationStateReferenceEClass = createEClass(DESTINATION_STATE_REFERENCE);
		createEReference(destinationStateReferenceEClass, DESTINATION_STATE_REFERENCE__STATE);
		createEReference(destinationStateReferenceEClass, DESTINATION_STATE_REFERENCE__TYPE_SET);

		sameStateEClass = createEClass(SAME_STATE);

		branchesEClass = createEClass(BRANCHES);
		createEReference(branchesEClass, BRANCHES__BRANCHES);

		branchEClass = createEClass(BRANCH);
		createEAttribute(branchEClass, BRANCH__PROBABILITY);

		branchStateReferenceEClass = createEClass(BRANCH_STATE_REFERENCE);
		createEReference(branchStateReferenceEClass, BRANCH_STATE_REFERENCE__STATE);
		createEReference(branchStateReferenceEClass, BRANCH_STATE_REFERENCE__TYPE_SET);

		branchSameStateEClass = createEClass(BRANCH_SAME_STATE);

		outgoingPropagationConditionInstanceEClass = createEClass(OUTGOING_PROPAGATION_CONDITION_INSTANCE);
		createEReference(outgoingPropagationConditionInstanceEClass,
				OUTGOING_PROPAGATION_CONDITION_INSTANCE__OUTGOING_PROPAGATION_CONDITION);
		createEReference(outgoingPropagationConditionInstanceEClass, OUTGOING_PROPAGATION_CONDITION_INSTANCE__SOURCE);
		createEReference(outgoingPropagationConditionInstanceEClass,
				OUTGOING_PROPAGATION_CONDITION_INSTANCE__CONDITION);
		createEReference(outgoingPropagationConditionInstanceEClass,
				OUTGOING_PROPAGATION_CONDITION_INSTANCE__DESTINATION);

		outgoingPropagationConditionDestinationEClass = createEClass(OUTGOING_PROPAGATION_CONDITION_DESTINATION);

		destinationPropagationReferenceEClass = createEClass(DESTINATION_PROPAGATION_REFERENCE);
		createEReference(destinationPropagationReferenceEClass, DESTINATION_PROPAGATION_REFERENCE__PROPAGATION);
		createEReference(destinationPropagationReferenceEClass, DESTINATION_PROPAGATION_REFERENCE__TYPE_SET);

		allPropagationsEClass = createEClass(ALL_PROPAGATIONS);
		createEReference(allPropagationsEClass, ALL_PROPAGATIONS__TYPE_SET);

		allPropagationsNoErrorEClass = createEClass(ALL_PROPAGATIONS_NO_ERROR);

		detectionInstanceEClass = createEClass(DETECTION_INSTANCE);
		createEReference(detectionInstanceEClass, DETECTION_INSTANCE__DETECTION);
		createEReference(detectionInstanceEClass, DETECTION_INSTANCE__SOURCE);
		createEReference(detectionInstanceEClass, DETECTION_INSTANCE__CONDITION);
		createEReference(detectionInstanceEClass, DETECTION_INSTANCE__DESTINATION);
		createEReference(detectionInstanceEClass, DETECTION_INSTANCE__ERROR_CODE);

		errorCodeInstanceEClass = createEClass(ERROR_CODE_INSTANCE);

		integerCodeEClass = createEClass(INTEGER_CODE);
		createEAttribute(integerCodeEClass, INTEGER_CODE__CODE);

		stringCodeEClass = createEClass(STRING_CODE);
		createEAttribute(stringCodeEClass, STRING_CODE__CODE);

		constantCodeEClass = createEClass(CONSTANT_CODE);
		createEReference(constantCodeEClass, CONSTANT_CODE__CODE);

		modeMappingInstanceEClass = createEClass(MODE_MAPPING_INSTANCE);
		createEReference(modeMappingInstanceEClass, MODE_MAPPING_INSTANCE__MODE_MAPPING);
		createEReference(modeMappingInstanceEClass, MODE_MAPPING_INSTANCE__STATE);
		createEReference(modeMappingInstanceEClass, MODE_MAPPING_INSTANCE__TYPE_SET);
		createEReference(modeMappingInstanceEClass, MODE_MAPPING_INSTANCE__MODES);

		compositeStateInstanceEClass = createEClass(COMPOSITE_STATE_INSTANCE);
		createEReference(compositeStateInstanceEClass, COMPOSITE_STATE_INSTANCE__COMPOSITE);
		createEReference(compositeStateInstanceEClass, COMPOSITE_STATE_INSTANCE__CONDITION);
		createEReference(compositeStateInstanceEClass, COMPOSITE_STATE_INSTANCE__DESTINATION);
		createEReference(compositeStateInstanceEClass, COMPOSITE_STATE_INSTANCE__DESTINATION_TYPE_SET);

		compositeConditionExpressionEClass = createEClass(COMPOSITE_CONDITION_EXPRESSION);

		othersExpressionEClass = createEClass(OTHERS_EXPRESSION);

		stateReferenceEClass = createEClass(STATE_REFERENCE);
		createEReference(stateReferenceEClass, STATE_REFERENCE__STATE);
		createEReference(stateReferenceEClass, STATE_REFERENCE__TYPE_SET);

		// Create enums
		eOperationEEnum = createEEnum(EOPERATION);
		bindingTypeEEnum = createEEnum(BINDING_TYPE);
		countExpressionOperationEEnum = createEEnum(COUNT_EXPRESSION_OPERATION);
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
		Aadl2Package theAadl2Package = (Aadl2Package) EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		emv2AnnexInstanceEClass.getESuperTypes().add(theInstancePackage.getAnnexInstance());
		emv2InstanceObjectEClass.getESuperTypes().add(theInstancePackage.getInstanceObject());
		constrainedInstanceObjectEClass.getESuperTypes().add(getConstraintElement());
		constraintExpressionEClass.getESuperTypes().add(getConstraintElement());
		constraintElementEClass.getESuperTypes().add(getEMV2InstanceObject());
		errorPropagationInstanceEClass.getESuperTypes().add(getConstrainedInstanceObject());
		connectionEndPropagationEClass.getESuperTypes().add(getErrorPropagationInstance());
		featurePropagationEClass.getESuperTypes().add(getConnectionEndPropagation());
		accessPropagationEClass.getESuperTypes().add(getConnectionEndPropagation());
		pointPropagationEClass.getESuperTypes().add(getErrorPropagationInstance());
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
		stateInstanceEClass.getESuperTypes().add(getEMV2InstanceObject());
		eventInstanceEClass.getESuperTypes().add(getEMV2InstanceObject());
		errorEventInstanceEClass.getESuperTypes().add(getEventInstance());
		recoverEventInstanceEClass.getESuperTypes().add(getEventInstance());
		repairEventInstanceEClass.getESuperTypes().add(getEventInstance());
		transitionInstanceEClass.getESuperTypes().add(getEMV2InstanceObject());
		stateSourceEClass.getESuperTypes().add(getEMV2InstanceObject());
		sourceStateReferenceEClass.getESuperTypes().add(getStateSource());
		allSourcesEClass.getESuperTypes().add(getStateSource());
		conditionExpressionInstanceEClass.getESuperTypes().add(getCompositeConditionExpression());
		eventReferenceEClass.getESuperTypes().add(getConditionExpressionInstance());
		conditionPropagationReferenceEClass.getESuperTypes().add(getConditionExpressionInstance());
		noErrorPropagationReferenceEClass.getESuperTypes().add(getConditionExpressionInstance());
		noErrorPropagationReferenceEClass.getESuperTypes().add(getOutgoingPropagationConditionDestination());
		countExpressionEClass.getESuperTypes().add(getConditionExpressionInstance());
		transitionDestinationEClass.getESuperTypes().add(getEMV2InstanceObject());
		destinationStateReferenceEClass.getESuperTypes().add(getTransitionDestination());
		sameStateEClass.getESuperTypes().add(getTransitionDestination());
		branchesEClass.getESuperTypes().add(getTransitionDestination());
		branchEClass.getESuperTypes().add(getEMV2InstanceObject());
		branchStateReferenceEClass.getESuperTypes().add(getBranch());
		branchSameStateEClass.getESuperTypes().add(getBranch());
		outgoingPropagationConditionInstanceEClass.getESuperTypes().add(getEMV2InstanceObject());
		outgoingPropagationConditionDestinationEClass.getESuperTypes().add(getEMV2InstanceObject());
		destinationPropagationReferenceEClass.getESuperTypes().add(getOutgoingPropagationConditionDestination());
		allPropagationsEClass.getESuperTypes().add(getOutgoingPropagationConditionDestination());
		allPropagationsNoErrorEClass.getESuperTypes().add(getOutgoingPropagationConditionDestination());
		detectionInstanceEClass.getESuperTypes().add(getEMV2InstanceObject());
		errorCodeInstanceEClass.getESuperTypes().add(getEMV2InstanceObject());
		integerCodeEClass.getESuperTypes().add(getErrorCodeInstance());
		stringCodeEClass.getESuperTypes().add(getErrorCodeInstance());
		constantCodeEClass.getESuperTypes().add(getErrorCodeInstance());
		modeMappingInstanceEClass.getESuperTypes().add(getEMV2InstanceObject());
		compositeStateInstanceEClass.getESuperTypes().add(getEMV2InstanceObject());
		compositeConditionExpressionEClass.getESuperTypes().add(getEMV2InstanceObject());
		othersExpressionEClass.getESuperTypes().add(getCompositeConditionExpression());
		stateReferenceEClass.getESuperTypes().add(getConditionExpressionInstance());

		// Initialize classes and features; add operations and parameters
		initEClass(emv2AnnexInstanceEClass, EMV2AnnexInstance.class, "EMV2AnnexInstance", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEMV2AnnexInstance_Propagations(), getErrorPropagationInstance(), null, "propagations", null,
				0, -1, EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_ErrorFlows(), getErrorFlowInstance(), null, "errorFlows", null, 0, -1,
				EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_PropagationPaths(), getPropagationPathInstance(), null, "propagationPaths",
				null, 0, -1, EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_States(), getStateInstance(), null, "states", null, 0, -1,
				EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_InitialState(), getStateInstance(), null, "initialState", null, 0, 1,
				EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_Events(), getEventInstance(), null, "events", null, 0, -1,
				EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_Transitions(), getTransitionInstance(), null, "transitions", null, 0, -1,
				EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_Conditions(), getOutgoingPropagationConditionInstance(), null, "conditions",
				null, 0, -1, EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_Detections(), getDetectionInstance(), null, "detections", null, 0, -1,
				EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_ModeMappings(), getModeMappingInstance(), null, "modeMappings", null, 0, -1,
				EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_Composites(), getCompositeStateInstance(), null, "composites", null, 0, -1,
				EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEMV2AnnexInstance_PropagationPoints(), getPropagationPointInstance(), null,
				"propagationPoints", null, 0, -1, EMV2AnnexInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(emv2InstanceObjectEClass, EMV2InstanceObject.class, "EMV2InstanceObject", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

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

		initEClass(connectionEndPropagationEClass, ConnectionEndPropagation.class, "ConnectionEndPropagation",
				IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectionEndPropagation_SourceConnectionPaths(), getConnectionPath(),
				getConnectionPath_SourcePropagations(), "sourceConnectionPaths", null, 0, -1,
				ConnectionEndPropagation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionEndPropagation_DestinationConnectionPaths(), getConnectionPath(),
				getConnectionPath_DestinationPropagations(), "destinationConnectionPaths", null, 0, -1,
				ConnectionEndPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featurePropagationEClass, FeaturePropagation.class, "FeaturePropagation", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeaturePropagation_Feature(), theInstancePackage.getFeatureInstance(), null, "feature", null,
				0, 1, FeaturePropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(accessPropagationEClass, AccessPropagation.class, "AccessPropagation", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(pointPropagationEClass, PointPropagation.class, "PointPropagation", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPointPropagation_Point(), getPropagationPointInstance(), null, "point", null, 0, 1,
				PointPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPointPropagation_SourceUserDefinedPaths(), getUserDefinedPath(),
				getUserDefinedPath_SourcePropagation(), "sourceUserDefinedPaths", null, 0, -1, PointPropagation.class,
				IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getPointPropagation_DestinationUserDefinedPaths(), getUserDefinedPath(),
				getUserDefinedPath_DestinationPropagation(), "destinationUserDefinedPaths", null, 0, -1,
				PointPropagation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bindingPropagationEClass, BindingPropagation.class, "BindingPropagation", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBindingPropagation_Binding(), getBindingType(), "binding", null, 0, 1,
				BindingPropagation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getBindingPropagation_SourceBindingPaths(), getBindingPath(),
				getBindingPath_SourcePropagations(), "sourceBindingPaths", null, 0, -1, BindingPropagation.class,
				IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getBindingPropagation_DestinationBindingPaths(), getBindingPath(),
				getBindingPath_DestinationPropagations(), "destinationBindingPaths", null, 0, -1,
				BindingPropagation.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		initEReference(getConnectionPath_SourcePropagations(), getConnectionEndPropagation(),
				getConnectionEndPropagation_SourceConnectionPaths(), "sourcePropagations", null, 0, -1,
				ConnectionPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConnectionPath_DestinationPropagations(), getConnectionEndPropagation(),
				getConnectionEndPropagation_DestinationConnectionPaths(), "destinationPropagations", null, 0, -1,
				ConnectionPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(connectionPathEClass, getConnectionEndPropagation(), "getSourcePropagation", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		addEOperation(connectionPathEClass, getConnectionEndPropagation(), "getDestinationPropagation", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEClass(bindingPathEClass, BindingPath.class, "BindingPath", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBindingPath_Type(), getBindingType(), "type", null, 0, 1, BindingPath.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBindingPath_SourcePropagations(), getBindingPropagation(),
				getBindingPropagation_SourceBindingPaths(), "sourcePropagations", null, 0, -1, BindingPath.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBindingPath_DestinationPropagations(), getBindingPropagation(),
				getBindingPropagation_DestinationBindingPaths(), "destinationPropagations", null, 0, -1,
				BindingPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userDefinedPathEClass, UserDefinedPath.class, "UserDefinedPath", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserDefinedPath_Path(), theErrorModelPackage.getPropagationPath(), null, "path", null, 0, 1,
				UserDefinedPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUserDefinedPath_SourcePoint(), getPropagationPointInstance(), null, "sourcePoint", null, 0, 1,
				UserDefinedPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUserDefinedPath_DestinationPoint(), getPropagationPointInstance(), null, "destinationPoint",
				null, 0, 1, UserDefinedPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUserDefinedPath_SourcePropagation(), getPointPropagation(),
				getPointPropagation_SourceUserDefinedPaths(), "sourcePropagation", null, 0, 1, UserDefinedPath.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUserDefinedPath_DestinationPropagation(), getPointPropagation(),
				getPointPropagation_DestinationUserDefinedPaths(), "destinationPropagation", null, 0, 1,
				UserDefinedPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateInstanceEClass, StateInstance.class, "StateInstance", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateInstance_State(), theErrorModelPackage.getErrorBehaviorState(), null, "state", null, 0,
				1, StateInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateInstance_TypeSet(), getAnonymousTypeSet(), null, "typeSet", null, 0, 1,
				StateInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventInstanceEClass, EventInstance.class, "EventInstance", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(errorEventInstanceEClass, ErrorEventInstance.class, "ErrorEventInstance", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getErrorEventInstance_ErrorEvent(), theErrorModelPackage.getErrorEvent(), null, "errorEvent",
				null, 0, 1, ErrorEventInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getErrorEventInstance_TypeSet(), getAnonymousTypeSet(), null, "typeSet", null, 0, 1,
				ErrorEventInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recoverEventInstanceEClass, RecoverEventInstance.class, "RecoverEventInstance", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRecoverEventInstance_RecoverEvent(), theErrorModelPackage.getRecoverEvent(), null,
				"recoverEvent", null, 0, 1, RecoverEventInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecoverEventInstance_EventInitiators(), theInstancePackage.getConnectionInstanceEnd(), null,
				"eventInitiators", null, 0, -1, RecoverEventInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(repairEventInstanceEClass, RepairEventInstance.class, "RepairEventInstance", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepairEventInstance_RepairEvent(), theErrorModelPackage.getRepairEvent(), null, "repairEvent",
				null, 0, 1, RepairEventInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRepairEventInstance_EventInitiators(), theInstancePackage.getConnectionInstanceEnd(), null,
				"eventInitiators", null, 0, -1, RepairEventInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transitionInstanceEClass, TransitionInstance.class, "TransitionInstance", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransitionInstance_Transition(), theErrorModelPackage.getErrorBehaviorTransition(), null,
				"transition", null, 0, 1, TransitionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransitionInstance_Source(), getStateSource(), null, "source", null, 0, 1,
				TransitionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransitionInstance_Condition(), getConditionExpressionInstance(), null, "condition", null, 0,
				1, TransitionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransitionInstance_Destination(), getTransitionDestination(), null, "destination", null, 0, 1,
				TransitionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateSourceEClass, StateSource.class, "StateSource", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(sourceStateReferenceEClass, SourceStateReference.class, "SourceStateReference", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourceStateReference_State(), getStateInstance(), null, "state", null, 0, 1,
				SourceStateReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSourceStateReference_TypeSet(), getAnonymousTypeSet(), null, "typeSet", null, 0, 1,
				SourceStateReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(allSourcesEClass, AllSources.class, "AllSources", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(conditionExpressionInstanceEClass, ConditionExpressionInstance.class, "ConditionExpressionInstance",
				IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eventReferenceEClass, EventReference.class, "EventReference", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEventReference_Event(), getEventInstance(), null, "event", null, 0, 1, EventReference.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEventReference_TypeSet(), getAnonymousTypeSet(), null, "typeSet", null, 0, 1,
				EventReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionPropagationReferenceEClass, ConditionPropagationReference.class,
				"ConditionPropagationReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConditionPropagationReference_Propagation(), getErrorPropagationInstance(), null,
				"propagation", null, 0, 1, ConditionPropagationReference.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionPropagationReference_TypeSet(), getAnonymousTypeSet(), null, "typeSet", null, 0, 1,
				ConditionPropagationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(noErrorPropagationReferenceEClass, NoErrorPropagationReference.class, "NoErrorPropagationReference",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNoErrorPropagationReference_Propagation(), getErrorPropagationInstance(), null, "propagation",
				null, 0, 1, NoErrorPropagationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(countExpressionEClass, CountExpression.class, "CountExpression", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCountExpression_Operands(), getConditionExpressionInstance(), null, "operands", null, 0, -1,
				CountExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCountExpression_Operation(), getCountExpressionOperation(), "operation", null, 0, 1,
				CountExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getCountExpression_Count(), ecorePackage.getELong(), "count", null, 0, 1, CountExpression.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transitionDestinationEClass, TransitionDestination.class, "TransitionDestination", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(destinationStateReferenceEClass, DestinationStateReference.class, "DestinationStateReference",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDestinationStateReference_State(), getStateInstance(), null, "state", null, 0, 1,
				DestinationStateReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDestinationStateReference_TypeSet(), getAnonymousTypeSet(), null, "typeSet", null, 0, 1,
				DestinationStateReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(destinationStateReferenceEClass, getTypeTokenInstance(), "getTypeToken", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEClass(sameStateEClass, SameState.class, "SameState", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(branchesEClass, Branches.class, "Branches", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBranches_Branches(), getBranch(), null, "branches", null, 0, -1, Branches.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(branchEClass, Branch.class, "Branch", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBranch_Probability(), ecorePackage.getEBigDecimal(), "probability", null, 0, 1, Branch.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(branchStateReferenceEClass, BranchStateReference.class, "BranchStateReference", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBranchStateReference_State(), getStateInstance(), null, "state", null, 0, 1,
				BranchStateReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBranchStateReference_TypeSet(), getAnonymousTypeSet(), null, "typeSet", null, 0, 1,
				BranchStateReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(branchStateReferenceEClass, getTypeTokenInstance(), "getTypeToken", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(branchSameStateEClass, BranchSameState.class, "BranchSameState", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(outgoingPropagationConditionInstanceEClass, OutgoingPropagationConditionInstance.class,
				"OutgoingPropagationConditionInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutgoingPropagationConditionInstance_OutgoingPropagationCondition(),
				theErrorModelPackage.getOutgoingPropagationCondition(), null, "outgoingPropagationCondition", null, 0,
				1, OutgoingPropagationConditionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutgoingPropagationConditionInstance_Source(), getStateSource(), null, "source", null, 0, 1,
				OutgoingPropagationConditionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutgoingPropagationConditionInstance_Condition(), getConditionExpressionInstance(), null,
				"condition", null, 0, 1, OutgoingPropagationConditionInstance.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOutgoingPropagationConditionInstance_Destination(),
				getOutgoingPropagationConditionDestination(), null, "destination", null, 0, 1,
				OutgoingPropagationConditionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outgoingPropagationConditionDestinationEClass, OutgoingPropagationConditionDestination.class,
				"OutgoingPropagationConditionDestination", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(destinationPropagationReferenceEClass, DestinationPropagationReference.class,
				"DestinationPropagationReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDestinationPropagationReference_Propagation(), getErrorPropagationInstance(), null,
				"propagation", null, 0, 1, DestinationPropagationReference.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDestinationPropagationReference_TypeSet(), getAnonymousTypeSet(), null, "typeSet", null, 0, 1,
				DestinationPropagationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(destinationPropagationReferenceEClass, getTypeTokenInstance(), "getTypeToken", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEClass(allPropagationsEClass, AllPropagations.class, "AllPropagations", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAllPropagations_TypeSet(), getAnonymousTypeSet(), null, "typeSet", null, 0, 1,
				AllPropagations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(allPropagationsEClass, getTypeTokenInstance(), "getTypeToken", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(allPropagationsNoErrorEClass, AllPropagationsNoError.class, "AllPropagationsNoError", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(detectionInstanceEClass, DetectionInstance.class, "DetectionInstance", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDetectionInstance_Detection(), theErrorModelPackage.getErrorDetection(), null, "detection",
				null, 0, 1, DetectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDetectionInstance_Source(), getStateSource(), null, "source", null, 0, 1,
				DetectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDetectionInstance_Condition(), getConditionExpressionInstance(), null, "condition", null, 0,
				1, DetectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDetectionInstance_Destination(), theInstancePackage.getFeatureInstance(), null, "destination",
				null, 0, 1, DetectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDetectionInstance_ErrorCode(), getErrorCodeInstance(), null, "errorCode", null, 0, 1,
				DetectionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(errorCodeInstanceEClass, ErrorCodeInstance.class, "ErrorCodeInstance", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(integerCodeEClass, IntegerCode.class, "IntegerCode", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerCode_Code(), ecorePackage.getELong(), "code", null, 0, 1, IntegerCode.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringCodeEClass, StringCode.class, "StringCode", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringCode_Code(), ecorePackage.getEString(), "code", null, 0, 1, StringCode.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constantCodeEClass, ConstantCode.class, "ConstantCode", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstantCode_Code(), theAadl2Package.getPropertyConstant(), null, "code", null, 0, 1,
				ConstantCode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modeMappingInstanceEClass, ModeMappingInstance.class, "ModeMappingInstance", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModeMappingInstance_ModeMapping(), theErrorModelPackage.getErrorStateToModeMapping(), null,
				"modeMapping", null, 0, 1, ModeMappingInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModeMappingInstance_State(), getStateInstance(), null, "state", null, 0, 1,
				ModeMappingInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModeMappingInstance_TypeSet(), getAnonymousTypeSet(), null, "typeSet", null, 0, 1,
				ModeMappingInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModeMappingInstance_Modes(), theInstancePackage.getModeInstance(), null, "modes", null, 0, -1,
				ModeMappingInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeStateInstanceEClass, CompositeStateInstance.class, "CompositeStateInstance", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeStateInstance_Composite(), theErrorModelPackage.getCompositeState(), null,
				"composite", null, 0, 1, CompositeStateInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeStateInstance_Condition(), getCompositeConditionExpression(), null, "condition",
				null, 0, 1, CompositeStateInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeStateInstance_Destination(), getStateInstance(), null, "destination", null, 0, 1,
				CompositeStateInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeStateInstance_DestinationTypeSet(), getAnonymousTypeSet(), null,
				"destinationTypeSet", null, 0, 1, CompositeStateInstance.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(compositeStateInstanceEClass, getTypeTokenInstance(), "getDestinationTypeToken", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEClass(compositeConditionExpressionEClass, CompositeConditionExpression.class,
				"CompositeConditionExpression", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(othersExpressionEClass, OthersExpression.class, "OthersExpression", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(stateReferenceEClass, StateReference.class, "StateReference", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateReference_State(), getStateInstance(), null, "state", null, 0, 1, StateReference.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateReference_TypeSet(), getAnonymousTypeSet(), null, "typeSet", null, 0, 1,
				StateReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		initEEnum(countExpressionOperationEEnum, CountExpressionOperation.class, "CountExpressionOperation");
		addEEnumLiteral(countExpressionOperationEEnum, CountExpressionOperation.EQUALS);
		addEEnumLiteral(countExpressionOperationEEnum, CountExpressionOperation.LESS_EQUAL);
		addEEnumLiteral(countExpressionOperationEEnum, CountExpressionOperation.GREATER_EQUAL);

		// Create resource
		createResource(eNS_URI);
	}

} // EMV2InstancePackageImpl
