/**
 */
package org.osate.analysis.resources.budgets.internal.models.busload;

import org.eclipse.emf.common.util.EList;

import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.analysis.resources.budgets.internal.models.analysis.AnalysisElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Broadcast</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.Broadcast#getConnections <em>Connections</em>}</li>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.Broadcast#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getBroadcast()
 * @model
 * @generated
 */
public interface Broadcast extends BusloadElement, AnalysisElement {
	/**
	 * Returns the value of the '<em><b>Connections</b></em>' reference list.
	 * The list contents are of type {@link org.osate.analysis.resources.budgets.internal.models.busload.Connection}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' reference list.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getBroadcast_Connections()
	 * @model
	 * @generated
	 */
	EList<Connection> getConnections();

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(ConnectionInstanceEnd)
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getBroadcast_Source()
	 * @model
	 * @generated
	 */
	ConnectionInstanceEnd getSource();

	/**
	 * Sets the value of the '{@link org.osate.analysis.resources.budgets.internal.models.busload.Broadcast#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ConnectionInstanceEnd value);

} // Broadcast
