/**
 */
package org.osate.alisa2.model.safe2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Overview</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa2.model.safe2.SystemOverview#getSystemName <em>System Name</em>}</li>
 *   <li>{@link org.osate.alisa2.model.safe2.SystemOverview#getFundamentals <em>Fundamentals</em>}</li>
 * </ul>
 *
 * @see org.osate.alisa2.model.safe2.Safe2Package#getSystemOverview()
 * @model
 * @generated
 */
public interface SystemOverview extends EObject {
	/**
	 * Returns the value of the '<em><b>System Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Name</em>' attribute.
	 * @see #setSystemName(String)
	 * @see org.osate.alisa2.model.safe2.Safe2Package#getSystemOverview_SystemName()
	 * @model
	 * @generated
	 */
	String getSystemName();

	/**
	 * Sets the value of the '{@link org.osate.alisa2.model.safe2.SystemOverview#getSystemName <em>System Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Name</em>' attribute.
	 * @see #getSystemName()
	 * @generated
	 */
	void setSystemName(String value);

	/**
	 * Returns the value of the '<em><b>Fundamentals</b></em>' containment reference list.
	 * The list contents are of type {@link org.osate.alisa2.model.safe2.Fundamental}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fundamentals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fundamentals</em>' containment reference list.
	 * @see org.osate.alisa2.model.safe2.Safe2Package#getSystemOverview_Fundamentals()
	 * @model containment="true"
	 * @generated
	 */
	EList<Fundamental> getFundamentals();

} // SystemOverview
