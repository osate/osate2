/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Component Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference#getNames <em>Names</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDataComponentReference()
 * @model
 * @generated
 */
public interface DataComponentReference extends ElementValues, Target, ValueVariable {
	/**
	 * Returns the value of the '<em><b>Names</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.Name}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Names</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Names</em>' containment reference list.
	 * @see #isSetNames()
	 * @see #unsetNames()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDataComponentReference_Names()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
	EList<Name> getNames();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference#getNames <em>Names</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNames()
	 * @see #getNames()
	 * @generated
	 */
	void unsetNames();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference#getNames <em>Names</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Names</em>' containment reference list is set.
	 * @see #unsetNames()
	 * @see #getNames()
	 * @generated
	 */
	boolean isSetNames();

} // DataComponentReference
