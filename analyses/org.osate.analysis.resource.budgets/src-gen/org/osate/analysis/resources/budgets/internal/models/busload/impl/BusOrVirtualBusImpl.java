/**
 */
package org.osate.analysis.resources.budgets.internal.models.busload.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
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
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.impl.BusOrVirtualBusImpl#getDataOverhead <em>Data Overhead</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BusOrVirtualBusImpl extends BusloadElementImpl implements BusOrVirtualBus {
	/**
	 * The cached value of the '{@link #getBoundBroadcasts() <em>Bound Broadcasts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundBroadcasts()
	 * @generated
	 * @ordered
	 */
	protected EList<Broadcast> boundBroadcasts;

	/**
	 * The cached value of the '{@link #getBoundConnections() <em>Bound Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<Connection> boundConnections;

	/**
	 * The cached value of the '{@link #getBoundVirtualBuses() <em>Bound Virtual Buses</em>}' containment reference list.
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
	 * The default value of the '{@link #getDataOverhead() <em>Data Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataOverhead()
	 * @generated
	 * @ordered
	 */
	protected static final double DATA_OVERHEAD_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getDataOverhead() <em>Data Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataOverhead()
	 * @generated
	 * @ordered
	 */
	protected double dataOverhead = DATA_OVERHEAD_EDEFAULT;

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
			boundBroadcasts = new EObjectContainmentEList<Broadcast>(Broadcast.class, this, BusloadPackage.BUS_OR_VIRTUAL_BUS__BOUND_BROADCASTS);
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
			boundConnections = new EObjectContainmentEList<Connection>(Connection.class, this, BusloadPackage.BUS_OR_VIRTUAL_BUS__BOUND_CONNECTIONS);
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
			boundVirtualBuses = new EObjectContainmentEList<VirtualBus>(VirtualBus.class, this, BusloadPackage.BUS_OR_VIRTUAL_BUS__BOUND_VIRTUAL_BUSES);
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
	public double getDataOverhead() {
		return dataOverhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataOverhead(double newDataOverhead) {
		double oldDataOverhead = dataOverhead;
		dataOverhead = newDataOverhead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BusloadPackage.BUS_OR_VIRTUAL_BUS__DATA_OVERHEAD, oldDataOverhead, dataOverhead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__BOUND_BROADCASTS:
				return ((InternalEList<?>)getBoundBroadcasts()).basicRemove(otherEnd, msgs);
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__BOUND_CONNECTIONS:
				return ((InternalEList<?>)getBoundConnections()).basicRemove(otherEnd, msgs);
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__BOUND_VIRTUAL_BUSES:
				return ((InternalEList<?>)getBoundVirtualBuses()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__DATA_OVERHEAD:
				return getDataOverhead();
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
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__DATA_OVERHEAD:
				setDataOverhead((Double)newValue);
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
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__DATA_OVERHEAD:
				setDataOverhead(DATA_OVERHEAD_EDEFAULT);
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
			case BusloadPackage.BUS_OR_VIRTUAL_BUS__DATA_OVERHEAD:
				return dataOverhead != DATA_OVERHEAD_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (dataOverhead: ");
		result.append(dataOverhead);
		result.append(')');
		return result.toString();
	}

} //BusOrVirtualBusImpl
