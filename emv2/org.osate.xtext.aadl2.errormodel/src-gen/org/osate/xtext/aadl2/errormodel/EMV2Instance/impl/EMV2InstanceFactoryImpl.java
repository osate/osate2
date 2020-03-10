/**
 */
package org.osate.xtext.aadl2.errormodel.EMV2Instance.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.osate.xtext.aadl2.errormodel.EMV2Instance.*;

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
			EMV2InstanceFactory theEMV2InstanceFactory = (EMV2InstanceFactory)EPackage.Registry.INSTANCE.getEFactory(EMV2InstancePackage.eNS_URI);
			if (theEMV2InstanceFactory != null) {
				return theEMV2InstanceFactory;
			}
		}
		catch (Exception exception) {
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
			case EMV2InstancePackage.EMV2_ANNEX_INSTANCE: return createEMV2AnnexInstance();
			case EMV2InstancePackage.STATE_VARIABLE_INSTANCE: return createStateVariableInstance();
			case EMV2InstancePackage.STATE_INSTANCE: return createStateInstance();
			case EMV2InstancePackage.CONSTRAINED_INSTANCE_OBJECT: return createConstrainedInstanceObject();
			case EMV2InstancePackage.STATE_TRANSITION_INSTANCE: return createStateTransitionInstance();
			case EMV2InstancePackage.STATE_SYNCHRONIZATION_INSTANCE: return createStateSynchronizationInstance();
			case EMV2InstancePackage.BEHAVIOR_INSTANCE: return createBehaviorInstance();
			case EMV2InstancePackage.TYPE_REFERENCE: return createTypeReference();
			case EMV2InstancePackage.ECOLLECTION: return createECollection();
			case EMV2InstancePackage.MULTI_LITERAL_CONSTRAINT: return createMultiLiteralConstraint();
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
	public StateVariableInstance createStateVariableInstance() {
		StateVariableInstanceImpl stateVariableInstance = new StateVariableInstanceImpl();
		return stateVariableInstance;
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
	public StateSynchronizationInstance createStateSynchronizationInstance() {
		StateSynchronizationInstanceImpl stateSynchronizationInstance = new StateSynchronizationInstanceImpl();
		return stateSynchronizationInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BehaviorInstance createBehaviorInstance() {
		BehaviorInstanceImpl behaviorInstance = new BehaviorInstanceImpl();
		return behaviorInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeReference createTypeReference() {
		TypeReferenceImpl typeReference = new TypeReferenceImpl();
		return typeReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ECollection createECollection() {
		ECollectionImpl eCollection = new ECollectionImpl();
		return eCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MultiLiteralConstraint createMultiLiteralConstraint() {
		MultiLiteralConstraintImpl multiLiteralConstraint = new MultiLiteralConstraintImpl();
		return multiLiteralConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation createEOperationFromString(EDataType eDataType, String initialValue) {
		EOperation result = EOperation.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
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
	@Override
	public EMV2InstancePackage getEMV2InstancePackage() {
		return (EMV2InstancePackage)getEPackage();
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

} //EMV2InstanceFactoryImpl
