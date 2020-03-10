/**
 */
package org.osate.xtext.aadl2.errormodel.EMV2Instance.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;

import org.osate.aadl2.instance.AnnexInstance;
import org.osate.aadl2.instance.InstanceObject;

import org.osate.xtext.aadl2.errormodel.EMV2Instance.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstancePackage
 * @generated
 */
public class EMV2InstanceAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EMV2InstancePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMV2InstanceAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EMV2InstancePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EMV2InstanceSwitch<Adapter> modelSwitch =
		new EMV2InstanceSwitch<Adapter>() {
			@Override
			public Adapter caseEMV2InstanceObject(EMV2InstanceObject object) {
				return createEMV2InstanceObjectAdapter();
			}
			@Override
			public Adapter caseEMV2AnnexInstance(EMV2AnnexInstance object) {
				return createEMV2AnnexInstanceAdapter();
			}
			@Override
			public Adapter caseStateVariableInstance(StateVariableInstance object) {
				return createStateVariableInstanceAdapter();
			}
			@Override
			public Adapter caseStateInstance(StateInstance object) {
				return createStateInstanceAdapter();
			}
			@Override
			public Adapter caseConstrainedInstanceObject(ConstrainedInstanceObject object) {
				return createConstrainedInstanceObjectAdapter();
			}
			@Override
			public Adapter caseStateTransitionInstance(StateTransitionInstance object) {
				return createStateTransitionInstanceAdapter();
			}
			@Override
			public Adapter caseStateSynchronizationInstance(StateSynchronizationInstance object) {
				return createStateSynchronizationInstanceAdapter();
			}
			@Override
			public Adapter caseBehaviorInstance(BehaviorInstance object) {
				return createBehaviorInstanceAdapter();
			}
			@Override
			public Adapter caseLiteral(Literal object) {
				return createLiteralAdapter();
			}
			@Override
			public Adapter caseTypeReference(TypeReference object) {
				return createTypeReferenceAdapter();
			}
			@Override
			public Adapter caseECollection(ECollection object) {
				return createECollectionAdapter();
			}
			@Override
			public Adapter caseMultiLiteralConstraint(MultiLiteralConstraint object) {
				return createMultiLiteralConstraintAdapter();
			}
			@Override
			public Adapter caseElement(Element object) {
				return createElementAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseInstanceObject(InstanceObject object) {
				return createInstanceObjectAdapter();
			}
			@Override
			public Adapter caseAnnexInstance(AnnexInstance object) {
				return createAnnexInstanceAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstanceObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2InstanceObject
	 * @generated
	 */
	public Adapter createEMV2InstanceObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance <em>EMV2 Annex Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.EMV2AnnexInstance
	 * @generated
	 */
	public Adapter createEMV2AnnexInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateVariableInstance <em>State Variable Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateVariableInstance
	 * @generated
	 */
	public Adapter createStateVariableInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateInstance <em>State Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateInstance
	 * @generated
	 */
	public Adapter createStateInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject <em>Constrained Instance Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ConstrainedInstanceObject
	 * @generated
	 */
	public Adapter createConstrainedInstanceObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance <em>State Transition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateTransitionInstance
	 * @generated
	 */
	public Adapter createStateTransitionInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.StateSynchronizationInstance <em>State Synchronization Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.StateSynchronizationInstance
	 * @generated
	 */
	public Adapter createStateSynchronizationInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance <em>Behavior Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.BehaviorInstance
	 * @generated
	 */
	public Adapter createBehaviorInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.Literal
	 * @generated
	 */
	public Adapter createLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.TypeReference <em>Type Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.TypeReference
	 * @generated
	 */
	public Adapter createTypeReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.ECollection <em>ECollection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.ECollection
	 * @generated
	 */
	public Adapter createECollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.xtext.aadl2.errormodel.EMV2Instance.MultiLiteralConstraint <em>Multi Literal Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.xtext.aadl2.errormodel.EMV2Instance.MultiLiteralConstraint
	 * @generated
	 */
	public Adapter createMultiLiteralConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.Element
	 * @generated
	 */
	public Adapter createElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.instance.InstanceObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.instance.InstanceObject
	 * @generated
	 */
	public Adapter createInstanceObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.aadl2.instance.AnnexInstance <em>Annex Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.aadl2.instance.AnnexInstance
	 * @generated
	 */
	public Adapter createAnnexInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //EMV2InstanceAdapterFactory
