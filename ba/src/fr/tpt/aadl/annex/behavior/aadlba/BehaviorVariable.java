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
 * A representation of the model object '<em><b>Behavior Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable#getLocalVariableDeclarators <em>Local Variable Declarators</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable#getDataUniqueComponentClassifierReference <em>Data Unique Component Classifier Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorVariable()
 * @model
 * @generated
 */
public interface BehaviorVariable extends BehaviorElement {
	/**
	 * Returns the value of the '<em><b>Local Variable Declarators</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.Declarator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Variable Declarators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Variable Declarators</em>' containment reference list.
	 * @see #isSetLocalVariableDeclarators()
	 * @see #unsetLocalVariableDeclarators()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorVariable_LocalVariableDeclarators()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
	EList<Declarator> getLocalVariableDeclarators();

	/**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable#getLocalVariableDeclarators <em>Local Variable Declarators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLocalVariableDeclarators()
	 * @see #getLocalVariableDeclarators()
	 * @generated
	 */
	void unsetLocalVariableDeclarators();

	/**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable#getLocalVariableDeclarators <em>Local Variable Declarators</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Local Variable Declarators</em>' containment reference list is set.
	 * @see #unsetLocalVariableDeclarators()
	 * @see #getLocalVariableDeclarators()
	 * @generated
	 */
	boolean isSetLocalVariableDeclarators();

	/**
	 * Returns the value of the '<em><b>Data Unique Component Classifier Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Unique Component Classifier Reference</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Unique Component Classifier Reference</em>' containment reference.
	 * @see #setDataUniqueComponentClassifierReference(UniqueComponentClassifierReference)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorVariable_DataUniqueComponentClassifierReference()
	 * @model containment="true" required="true"
	 * @generated
	 */
	UniqueComponentClassifierReference getDataUniqueComponentClassifierReference();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable#getDataUniqueComponentClassifierReference <em>Data Unique Component Classifier Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Unique Component Classifier Reference</em>' containment reference.
	 * @see #getDataUniqueComponentClassifierReference()
	 * @generated
	 */
	void setDataUniqueComponentClassifierReference(UniqueComponentClassifierReference value);

} // BehaviorVariable
