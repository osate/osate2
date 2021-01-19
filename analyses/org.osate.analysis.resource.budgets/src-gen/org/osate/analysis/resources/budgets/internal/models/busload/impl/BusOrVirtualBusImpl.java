/**
 */
package org.osate.analysis.resources.budgets.internal.models.busload.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.analysis.resources.budgets.internal.models.busload.Broadcast;
import org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus;
import org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage;
import org.osate.analysis.resources.budgets.internal.models.busload.Connection;
import org.osate.analysis.resources.budgets.internal.models.busload.VirtualBus;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bus Or Virtual Bus</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.BusOrVirtualBusImpl#getBoundBroadcasts <em>Bound Broadcasts</em>}</li>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.BusOrVirtualBusImpl#getBoundConnections <em>Bound Connections</em>}</li>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.BusOrVirtualBusImpl#getBoundVirtualBuses <em>Bound Virtual Buses</em>}</li>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.BusOrVirtualBusImpl#getBusInstance <em>Bus Instance</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BusOrVirtualBusImpl extends AnalysisElementImpl implements BusOrVirtualBus {
	/**
	 * The cached value of the '{@link #getBoundBroadcasts() <em>Bound Broadcasts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundBroadcasts()
	 * @generated
	 * @ordered
	 */
	protected EList<Broadcast> boundBroadcasts;

	/**
	 * The cached value of the '{@link #getBoundConnections() <em>Bound Connections</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<Connection> boundConnections;

	/**
	 * The cached value of the '{@link #getBoundVirtualBuses() <em>Bound Virtual Buses</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundVirtualBuses()
	 * @generated
	 * @ordered
	 */
	protected EList<VirtualBus> boundVirtualBuses;

	/**
	 * The cached value of the '{@link #getBusInstance() <em>Bus Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBusInstance()
	 * @generated
	 * @ordered
	 */
	protected ComponentInstance busInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BusOrVirtualBusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BusloadPackage.Literals.BUS_OR_VIRTUAL_BUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Broadcast> getBoundBroadcasts() {
		if (boundBroadcasts == null) {
			boundBroadcasts = new EObjectResolvingEList<Broadcast>(Broadcast.class, this, BusloadPackage.BUS_OR_VIRTUAL_BUS__BOUND_BROADCASTS);
		}
		return boundBroadcasts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Connection> getBoundConnections() {
		if (boundConnections == null) {
			boundConnections = new EObjectResolvingEList<Connection>(Connection.class, this, BusloadPackage.BUS_OR_VIRTUAL_BUS__BOUND_CONNECTIONS);
		}
		return boundConnections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VirtualBus> getBoundVirtualBuses() {
		if (boundVirtualBuses == null) {
			boundVirtualBuses = new EObjectResolvingEList<VirtualBus>(VirtualBus.class, this, BusloadPackage.BUS_OR_VIRTUAL_BUS__BOUND_VIRTUAL_BUSES);
		}
		return boundVirtualBuses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComponentInstance getBusInstance() {
		if (busInstance != null && busInstance.eIsProxy()) {
			InternalEObject oldBusInstance = (InternalEObject)busInstance;
			busInstance = (ComponentInstance)eResolveProxy(oldBusInstance);
			if (busInstance != oldBusInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BusloadPackage.BUS_OR_VIRTUAL_BUS__BUS_INSTANCE, oldBusInstance, busInstance));
			}
		}
		return busInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentInstance basicGetBusInstance() {
		return busInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBusInstance(ComponentInstance newBusInstance) {
		ComponentInstance oldBusInstance = busInstance;
		busInstance = newBusInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BusloadPackage.BUS_OR_VIRTUAL_BUS__BUS_INSTANCE, oldBusInstance, busInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__BOUND_BROADCASTS:
				return getBoundBroadcasts();
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__BOUND_CONNECTIONS:
				return getBoundConnections();
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__BOUND_VIRTUAL_BUSES:
				return getBoundVirtualBuses();
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__BUS_INSTANCE:
				if (resolve) return getBusInstance();
				return basicGetBusInstance();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__BOUND_BROADCASTS:
				getBoundBroadcasts().clear();
				getBoundBroadcasts().addAll((Collection<? extends Broadcast>)newValue);
				return;
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__BOUND_CONNECTIONS:
				getBoundConnections().clear();
				getBoundConnections().addAll((Collection<? extends Connection>)newValue);
				return;
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__BOUND_VIRTUAL_BUSES:
				getBoundVirtualBuses().clear();
				getBoundVirtualBuses().addAll((Collection<? extends VirtualBus>)newValue);
				return;
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__BUS_INSTANCE:
				setBusInstance((ComponentInstance)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__BOUND_BROADCASTS:
				getBoundBroadcasts().clear();
				return;
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__BOUND_CONNECTIONS:
				getBoundConnections().clear();
				return;
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__BOUND_VIRTUAL_BUSES:
				getBoundVirtualBuses().clear();
				return;
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__BUS_INSTANCE:
				setBusInstance((ComponentInstance)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__BOUND_BROADCASTS:
				return boundBroadcasts != null && !boundBroadcasts.isEmpty();
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__BOUND_CONNECTIONS:
				return boundConnections != null && !boundConnections.isEmpty();
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__BOUND_VIRTUAL_BUSES:
				return boundVirtualBuses != null && !boundVirtualBuses.isEmpty();
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__BUS_INSTANCE:
				return busInstance != null;
		}
		return super.eIsSet(featureID);
	}

} //BusOrVirtualBusImpl
