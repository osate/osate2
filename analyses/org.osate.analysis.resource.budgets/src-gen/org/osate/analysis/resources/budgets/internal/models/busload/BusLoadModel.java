/**
 */
package org.osate.analysis.resources.budgets.internal.models.busload;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bus Load Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.analysis.resources.budgets.internal.models.busload.BusLoadModel#getRootBuses <em>Root Buses</em>}</li>
 * </ul>
 *
 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getBusLoadModel()
 * @model
 * @generated
 */
public interface BusLoadModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Root Buses</b></em>' reference list.
	 * The list contents are of type {@link org.osate.analysis.resources.budgets.internal.models.busload.Bus}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Buses</em>' reference list.
	 * @see org.osate.analysis.resources.budgets.internal.models.busload.BusloadPackage#getBusLoadModel_RootBuses()
	 * @model
	 * @generated
	 */
	EList<Bus> getRootBuses();

} // BusLoadModel
