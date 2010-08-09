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
 * A representation of the model object '<em><b>Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Name#getArrayIndexListOwned <em>Array Index List Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Name#getIdentifier <em>Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getName_()
 * @model
 * @generated
 */
public interface Name extends NamedElement, ElementValues
{
   /**
	 * Returns the value of the '<em><b>Array Index List Owned</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.ArrayIndex}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Array Index List Owned</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Array Index List Owned</em>' containment reference list.
	 * @see #isSetArrayIndexListOwned()
	 * @see #unsetArrayIndexListOwned()
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getName_ArrayIndexListOwned()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
   EList<ArrayIndex> getArrayIndexListOwned();

   /**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Name#getArrayIndexListOwned <em>Array Index List Owned</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isSetArrayIndexListOwned()
	 * @see #getArrayIndexListOwned()
	 * @generated
	 */
   void unsetArrayIndexListOwned();

   /**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Name#getArrayIndexListOwned <em>Array Index List Owned</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Array Index List Owned</em>' containment reference list is set.
	 * @see #unsetArrayIndexListOwned()
	 * @see #getArrayIndexListOwned()
	 * @generated
	 */
   boolean isSetArrayIndexListOwned();

   /**
	 * Returns the value of the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Identifier</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' containment reference.
	 * @see #setIdentifier(Identifier)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getName_Identifier()
	 * @model containment="true"
	 * @generated
	 */
   Identifier getIdentifier();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Name#getIdentifier <em>Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' containment reference.
	 * @see #getIdentifier()
	 * @generated
	 */
   void setIdentifier(Identifier value);

} // Name
