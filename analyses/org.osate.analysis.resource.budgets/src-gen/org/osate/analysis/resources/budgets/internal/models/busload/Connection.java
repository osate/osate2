/**
 */
package org.osate.analysis.resources.budgets.internal.models.busload;

import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.analysis.resources.budgets.internal.models.analysis.AnalysisElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.Connection#getConnectionInstance <em>Connection Instance</em>}</li>
 * </ul>
 *
 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getConnection()
 * @model
 * @generated
 */
public interface Connection extends BusloadElement, AnalysisElement {
	/**
	 * Returns the value of the '<em><b>Connection Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Instance</em>' reference.
	 * @see #setConnectionInstance(ConnectionInstance)
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getConnection_ConnectionInstance()
	 * @model
	 * @generated
	 */
	ConnectionInstance getConnectionInstance();

	/**
	 * Sets the value of the '{@link org.osate.analysis.resources.budgets.internal.models.busload.Connection#getConnectionInstance <em>Connection Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection Instance</em>' reference.
	 * @see #getConnectionInstance()
	 * @generated
	 */
	void setConnectionInstance(ConnectionInstance value);

} // Connection
