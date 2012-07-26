/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.declarative;

import fr.tpt.aadl.annex.behavior.aadlba.IntegerValue;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Arrayable Identifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.declarative.ArrayableIdentifier#getArrayIndexes <em>Array Indexes</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getArrayableIdentifier()
 * @model
 * @generated
 */
public interface ArrayableIdentifier extends Identifier {
	/**
	 * Returns the value of the '<em><b>Array Indexes</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array Indexes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array Indexes</em>' containment reference list.
	 * @see #isSetArrayIndexes()
	 * @see #unsetArrayIndexes()
	 * @see fr.tpt.aadl.annex.behavior.declarative.DeclarativePackage#getArrayableIdentifier_ArrayIndexes()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
	EList<IntegerValue> getArrayIndexes();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.declarative.ArrayableIdentifier#getArrayIndexes <em>Array Indexes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetArrayIndexes()
	 * @see #getArrayIndexes()
	 * @generated
	 */
	void unsetArrayIndexes();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.declarative.ArrayableIdentifier#getArrayIndexes <em>Array Indexes</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Array Indexes</em>' containment reference list is set.
	 * @see #unsetArrayIndexes()
	 * @see #getArrayIndexes()
	 * @generated
	 */
	boolean isSetArrayIndexes();

} // ArrayableIdentifier
