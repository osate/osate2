/**
 * Copyright Text	Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file)....
 */
package org.osate.analysis.resource.budgets.internal.models.power.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.osate.analysis.model.AnalysisElement;
import org.osate.analysis.resource.budgets.internal.models.power.PowerConsumer;
import org.osate.analysis.resource.budgets.internal.models.power.PowerElement;
import org.osate.analysis.resource.budgets.internal.models.power.PowerModel;
import org.osate.analysis.resource.budgets.internal.models.power.PowerPackage;
import org.osate.analysis.resource.budgets.internal.models.power.PowerSupplier;
import org.osate.analysis.resource.budgets.internal.models.power.PowerTransmissionSystem;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerPackage
 * @generated
 * @since 4.1
 */
public class PowerAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PowerPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = PowerPackage.eINSTANCE;
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
	protected PowerSwitch<Adapter> modelSwitch =
		new PowerSwitch<Adapter>() {
			@Override
			public Adapter casePowerElement(PowerElement object) {
				return createPowerElementAdapter();
			}
			@Override
			public Adapter casePowerTransmissionSystem(PowerTransmissionSystem object) {
				return createPowerTransmissionSystemAdapter();
			}
			@Override
			public Adapter casePowerSupplier(PowerSupplier object) {
				return createPowerSupplierAdapter();
			}
			@Override
			public Adapter casePowerConsumer(PowerConsumer object) {
				return createPowerConsumerAdapter();
			}
			@Override
			public Adapter casePowerModel(PowerModel object) {
				return createPowerModelAdapter();
			}
			@Override
			public Adapter caseAnalysisElement(AnalysisElement object) {
				return createAnalysisElementAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerElement
	 * @generated
	 */
	public Adapter createPowerElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerTransmissionSystem <em>Transmission System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerTransmissionSystem
	 * @generated
	 */
	public Adapter createPowerTransmissionSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerSupplier <em>Supplier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerSupplier
	 * @generated
	 */
	public Adapter createPowerSupplierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerConsumer <em>Consumer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerConsumer
	 * @generated
	 */
	public Adapter createPowerConsumerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.analysis.resource.budgets.internal.models.power.PowerModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.analysis.resource.budgets.internal.models.power.PowerModel
	 * @generated
	 */
	public Adapter createPowerModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.analysis.model.AnalysisElement <em>Analysis Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.analysis.model.AnalysisElement
	 * @generated
	 */
	public Adapter createAnalysisElementAdapter() {
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

} //PowerAdapterFactory
