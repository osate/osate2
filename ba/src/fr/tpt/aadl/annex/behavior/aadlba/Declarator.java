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
 * A representation of the model object '<em><b>Declarator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Declarator#getIdentifierOwned <em>Identifier Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Declarator#getArraySizes <em>Array Sizes</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDeclarator()
 * @model
 * @generated
 */
public interface Declarator extends BehaviorElement {
	/**
	 * Returns the value of the '<em><b>Identifier Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier Owned</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier Owned</em>' containment reference.
	 * @see #setIdentifierOwned(Identifier)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDeclarator_IdentifierOwned()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Identifier getIdentifierOwned();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Declarator#getIdentifierOwned <em>Identifier Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier Owned</em>' containment reference.
	 * @see #getIdentifierOwned()
	 * @generated
	 */
	void setIdentifierOwned(Identifier value);

	/**
	 * Returns the value of the '<em><b>Array Sizes</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array Sizes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array Sizes</em>' containment reference list.
	 * @see #isSetArraySizes()
	 * @see #unsetArraySizes()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDeclarator_ArraySizes()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
	EList<IntegerValueConstant> getArraySizes();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Declarator#getArraySizes <em>Array Sizes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetArraySizes()
	 * @see #getArraySizes()
	 * @generated
	 */
	void unsetArraySizes();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Declarator#getArraySizes <em>Array Sizes</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Array Sizes</em>' containment reference list is set.
	 * @see #unsetArraySizes()
	 * @see #getArraySizes()
	 * @generated
	 */
	boolean isSetArraySizes();

} // Declarator
