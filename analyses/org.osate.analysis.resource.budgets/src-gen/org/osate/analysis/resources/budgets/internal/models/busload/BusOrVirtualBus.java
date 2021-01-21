/**
 */
package org.osate.analysis.resources.budgets.internal.models.busload;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.instance.ComponentInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bus Or Virtual Bus</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getBoundBroadcasts <em>Bound Broadcasts</em>}</li>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getBoundConnections <em>Bound Connections</em>}</li>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getBoundVirtualBuses <em>Bound Virtual Buses</em>}</li>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getBusInstance <em>Bus Instance</em>}</li>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getDataOverhead <em>Data Overhead</em>}</li>
 * </ul>
 *
 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getBusOrVirtualBus()
 * @model abstract="true"
 * @generated
 */
public interface BusOrVirtualBus extends BusloadElement {
	/**
	 * Returns the value of the '<em><b>Bound Broadcasts</b></em>' reference list.
	 * The list contents are of type {@link org.osate.analysis.resources.budgets.internal.models.busload.Broadcast}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Broadcasts</em>' reference list.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getBusOrVirtualBus_BoundBroadcasts()
	 * @model
	 * @generated
	 */
	EList<Broadcast> getBoundBroadcasts();

	/**
	 * Returns the value of the '<em><b>Bound Connections</b></em>' reference list.
	 * The list contents are of type {@link org.osate.analysis.resources.budgets.internal.models.busload.Connection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Connections</em>' reference list.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getBusOrVirtualBus_BoundConnections()
	 * @model
	 * @generated
	 */
	EList<Connection> getBoundConnections();

	/**
	 * Returns the value of the '<em><b>Bound Virtual Buses</b></em>' reference list.
	 * The list contents are of type {@link org.osate.analysis.resources.budgets.internal.models.busload.VirtualBus}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bound Virtual Buses</em>' reference list.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getBusOrVirtualBus_BoundVirtualBuses()
	 * @model
	 * @generated
	 */
	EList<VirtualBus> getBoundVirtualBuses();

	/**
	 * Returns the value of the '<em><b>Bus Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bus Instance</em>' reference.
	 * @see #setBusInstance(ComponentInstance)
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getBusOrVirtualBus_BusInstance()
	 * @model
	 * @generated
	 */
	ComponentInstance getBusInstance();

	/**
	 * Sets the value of the '{@link org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getBusInstance <em>Bus Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bus Instance</em>' reference.
	 * @see #getBusInstance()
	 * @generated
	 */
	void setBusInstance(ComponentInstance value);

	/**
	 * Returns the value of the '<em><b>Data Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Overhead</em>' attribute.
	 * @see #setDataOverhead(double)
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getBusOrVirtualBus_DataOverhead()
	 * @model
	 * @generated
	 */
	double getDataOverhead();

	/**
	 * Sets the value of the '{@link org.osate.analysis.resources.budgets.internal.models.busload.BusOrVirtualBus#getDataOverhead <em>Data Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Overhead</em>' attribute.
	 * @see #getDataOverhead()
	 * @generated
	 */
	void setDataOverhead(double value);

} // BusOrVirtualBus
