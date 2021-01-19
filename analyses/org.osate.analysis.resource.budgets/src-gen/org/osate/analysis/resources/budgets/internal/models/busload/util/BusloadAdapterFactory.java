/**
 */
package org.osate.analysis.resources.budgets.internal.models.busload.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.osate.analysis.resources.budgets.internal.models.busload.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage
 * @generated
 */
public class BusloadAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BusloadPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusloadAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = BusloadPackage.eINSTANCE;
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
	protected BusloadSwitch<Adapter> modelSwitch =
		new BusloadSwitch<Adapter>() {
			@Override
			public Adapter caseAnalysisElement(AnalysisElement object) {
				return createAnalysisElementAdapter();
			}
			@Override
			public Adapter caseConnection(Connection object) {
				return createConnectionAdapter();
			}
			@Override
			public Adapter caseBroadcast(Broadcast object) {
				return createBroadcastAdapter();
			}
			@Override
			public Adapter caseBusOrVirtualBus(BusOrVirtualBus object) {
				return createBusOrVirtualBusAdapter();
			}
			@Override
			public Adapter caseVirtualBus(VirtualBus object) {
				return createVirtualBusAdapter();
			}
			@Override
			public Adapter caseBus(Bus object) {
				return createBusAdapter();
			}
			@Override
			public Adapter caseBusLoadModel(BusLoadModel object) {
				return createBusLoadModelAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.osate.analysis.resources.budgets.internal.models.busload.AnalysisElement <em>Analysis Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.AnalysisElement
	 * @generated
	 */
	public Adapter createAnalysisElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.analysis.resources.budgets.internal.models.busload.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.Connection
	 * @generated
	 */
	public Adapter createConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.analysis.resources.budgets.internal.models.busload.Broadcast <em>Broadcast</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.Broadcast
	 * @generated
	 */
	public Adapter createBroadcastAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus <em>Bus Or Virtual Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus
	 * @generated
	 */
	public Adapter createBusOrVirtualBusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.analysis.resources.budgets.internal.models.busload.VirtualBus <em>Virtual Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.VirtualBus
	 * @generated
	 */
	public Adapter createVirtualBusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.analysis.resources.budgets.internal.models.busload.Bus <em>Bus</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.Bus
	 * @generated
	 */
	public Adapter createBusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.osate.analysis.resources.budgets.internal.models.busload.BusLoadModel <em>Bus Load Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusLoadModel
	 * @generated
	 */
	public Adapter createBusLoadModelAdapter() {
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

} //BusloadAdapterFactory
