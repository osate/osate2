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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.osate.aadl2.errormodel.instance.AnonymousTypeSet;
import org.osate.aadl2.errormodel.instance.BindingPropagation;
import org.osate.aadl2.errormodel.instance.BindingType;
import org.osate.aadl2.errormodel.instance.CompositeStateInstance;
import org.osate.aadl2.errormodel.instance.ConstrainedInstanceObject;
import org.osate.aadl2.errormodel.instance.ConstraintExpression;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.EMV2InstanceFactory;
import org.osate.aadl2.errormodel.instance.EMV2InstancePackage;
import org.osate.aadl2.errormodel.instance.EOperation;
import org.osate.aadl2.errormodel.instance.ErrorDetectionInstance;
import org.osate.aadl2.errormodel.instance.ErrorFlowInstance;
import org.osate.aadl2.errormodel.instance.ErrorPropagationConditionInstance;
import org.osate.aadl2.errormodel.instance.ErrorSourceInstance;
import org.osate.aadl2.errormodel.instance.EventInstance;
import org.osate.aadl2.errormodel.instance.FeaturePropagation;
import org.osate.aadl2.errormodel.instance.PointPropagation;
import org.osate.aadl2.errormodel.instance.PropagationPathInstance;
import org.osate.aadl2.errormodel.instance.PropagationPointInstance;
import org.osate.aadl2.errormodel.instance.StateInstance;
import org.osate.aadl2.errormodel.instance.StateMachineInstance;
import org.osate.aadl2.errormodel.instance.StateTransitionInstance;
import org.osate.aadl2.errormodel.instance.TypeInstance;
import org.osate.aadl2.errormodel.instance.TypeProductInstance;
import org.osate.aadl2.errormodel.instance.TypeSetInstance;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EMV2InstanceFactoryImpl extends EFactoryImpl implements EMV2InstanceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EMV2InstanceFactory init() {
		try {
			EMV2InstanceFactory theEMV2InstanceFactory = (EMV2InstanceFactory) EPackage.Registry.INSTANCE
					.getEFactory(EMV2InstancePackage.eNS_URI);
			if (theEMV2InstanceFactory != null) {
				return theEMV2InstanceFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EMV2InstanceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMV2InstanceFactoryImpl() {
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
		case EMV2InstancePackage.EMV2_ANNEX_INSTANCE:
			return createEMV2AnnexInstance();
		case EMV2InstancePackage.STATE_MACHINE_INSTANCE:
			return createStateMachineInstance();
		case EMV2InstancePackage.STATE_INSTANCE:
			return createStateInstance();
		case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT:
			return createConstrainedInstanceObject();
		case EMV2InstancePackage.STATE_TRANSITION_INSTANCE:
			return createStateTransitionInstance();
		case EMV2InstancePackage.COMPOSITE_STATE_INSTANCE:
			return createCompositeStateInstance();
		case EMV2InstancePackage.ERROR_PROPAGATION_CONDITION_INSTANCE:
			return createErrorPropagationConditionInstance();
		case EMV2InstancePackage.ERROR_DETECTION_INSTANCE:
			return createErrorDetectionInstance();
		case EMV2InstancePackage.EVENT_INSTANCE:
			return createEventInstance();
		case EMV2InstancePackage.CONSTRAINT_EXPRESSION:
			return createConstraintExpression();
		case EMV2InstancePackage.PROPAGATION_PATH_INSTANCE:
			return createPropagationPathInstance();
		case EMV2InstancePackage.FEATURE_PROPAGATION:
			return createFeaturePropagation();
		case EMV2InstancePackage.POINT_PROPAGATION:
			return createPointPropagation();
		case EMV2InstancePackage.BINDING_PROPAGATION:
			return createBindingPropagation();
		case EMV2InstancePackage.TYPE_INSTANCE:
			return createTypeInstance();
		case EMV2InstancePackage.TYPE_PRODUCT_INSTANCE:
			return createTypeProductInstance();
		case EMV2InstancePackage.TYPE_SET_INSTANCE:
			return createTypeSetInstance();
		case EMV2InstancePackage.ANONYMOUS_TYPE_SET:
			return createAnonymousTypeSet();
		case EMV2InstancePackage.ERROR_FLOW_INSTANCE:
			return createErrorFlowInstance();
		case EMV2InstancePackage.ERROR_SOURCE_INSTANCE:
			return createErrorSourceInstance();
		case EMV2InstancePackage.PROPAGATION_POINT_INSTANCE:
			return createPropagationPointInstance();
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
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case EMV2InstancePackage.EOPERATION:
			return createEOperationFromString(eDataType, initialValue);
		case EMV2InstancePackage.BINDING_TYPE:
			return createBindingTypeFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case EMV2InstancePackage.EOPERATION:
			return convertEOperationToString(eDataType, instanceValue);
		case EMV2InstancePackage.BINDING_TYPE:
			return convertBindingTypeToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMV2AnnexInstance createEMV2AnnexInstance() {
		EMV2AnnexInstanceImpl emv2AnnexInstance = new EMV2AnnexInstanceImpl();
		return emv2AnnexInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StateMachineInstance createStateMachineInstance() {
		StateMachineInstanceImpl stateMachineInstance = new StateMachineInstanceImpl();
		return stateMachineInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StateInstance createStateInstance() {
		StateInstanceImpl stateInstance = new StateInstanceImpl();
		return stateInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConstrainedInstanceObject createConstrainedInstanceObject() {
		ConstrainedInstanceObjectImpl constrainedInstanceObject = new ConstrainedInstanceObjectImpl();
		return constrainedInstanceObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StateTransitionInstance createStateTransitionInstance() {
		StateTransitionInstanceImpl stateTransitionInstance = new StateTransitionInstanceImpl();
		return stateTransitionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositeStateInstance createCompositeStateInstance() {
		CompositeStateInstanceImpl compositeStateInstance = new CompositeStateInstanceImpl();
		return compositeStateInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ErrorFlowInstance createErrorFlowInstance() {
		ErrorFlowInstanceImpl errorFlowInstance = new ErrorFlowInstanceImpl();
		return errorFlowInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ErrorSourceInstance createErrorSourceInstance() {
		ErrorSourceInstanceImpl errorSourceInstance = new ErrorSourceInstanceImpl();
		return errorSourceInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ErrorPropagationConditionInstance createErrorPropagationConditionInstance() {
		ErrorPropagationConditionInstanceImpl errorPropagationConditionInstance = new ErrorPropagationConditionInstanceImpl();
		return errorPropagationConditionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ErrorDetectionInstance createErrorDetectionInstance() {
		ErrorDetectionInstanceImpl errorDetectionInstance = new ErrorDetectionInstanceImpl();
		return errorDetectionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropagationPointInstance createPropagationPointInstance() {
		PropagationPointInstanceImpl propagationPointInstance = new PropagationPointInstanceImpl();
		return propagationPointInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventInstance createEventInstance() {
		EventInstanceImpl eventInstance = new EventInstanceImpl();
		return eventInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConstraintExpression createConstraintExpression() {
		ConstraintExpressionImpl constraintExpression = new ConstraintExpressionImpl();
		return constraintExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropagationPathInstance createPropagationPathInstance() {
		PropagationPathInstanceImpl propagationPathInstance = new PropagationPathInstanceImpl();
		return propagationPathInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeaturePropagation createFeaturePropagation() {
		FeaturePropagationImpl featurePropagation = new FeaturePropagationImpl();
		return featurePropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PointPropagation createPointPropagation() {
		PointPropagationImpl pointPropagation = new PointPropagationImpl();
		return pointPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BindingPropagation createBindingPropagation() {
		BindingPropagationImpl bindingPropagation = new BindingPropagationImpl();
		return bindingPropagation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeInstance createTypeInstance() {
		TypeInstanceImpl typeInstance = new TypeInstanceImpl();
		return typeInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeSetInstance createTypeSetInstance() {
		TypeSetInstanceImpl typeSetInstance = new TypeSetInstanceImpl();
		return typeSetInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnonymousTypeSet createAnonymousTypeSet() {
		AnonymousTypeSetImpl anonymousTypeSet = new AnonymousTypeSetImpl();
		return anonymousTypeSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeProductInstance createTypeProductInstance() {
		TypeProductInstanceImpl typeProductInstance = new TypeProductInstanceImpl();
		return typeProductInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation createEOperationFromString(EDataType eDataType, String initialValue) {
		EOperation result = EOperation.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEOperationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingType createBindingTypeFromString(EDataType eDataType, String initialValue) {
		BindingType result = BindingType.get(initialValue);
		if (result == null) {
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBindingTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMV2InstancePackage getEMV2InstancePackage() {
		return (EMV2InstancePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EMV2InstancePackage getPackage() {
		return EMV2InstancePackage.eINSTANCE;
	}

} // EMV2InstanceFactoryImpl
