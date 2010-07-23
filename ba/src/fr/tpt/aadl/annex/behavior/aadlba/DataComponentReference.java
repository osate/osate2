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
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference#getElementsNameOwned <em>Elements Name Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDataComponentReference()
 * @model
 * @generated
 */
public interface DataComponentReference extends Element, ElementValues
{
   /**
    * Returns the value of the '<em><b>Elements Name Owned</b></em>' containment reference list.
    * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.Name}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Elements Name Owned</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Elements Name Owned</em>' containment reference list.
    * @see #isSetElementsNameOwned()
    * @see #unsetElementsNameOwned()
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDataComponentReference_ElementsNameOwned()
    * @model containment="true" unsettable="true"
    * @generated
    */
   EList<Name> getElementsNameOwned();

   /**
    * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference#getElementsNameOwned <em>Elements Name Owned</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isSetElementsNameOwned()
    * @see #getElementsNameOwned()
    * @generated
    */
   void unsetElementsNameOwned();

   /**
    * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference#getElementsNameOwned <em>Elements Name Owned</em>}' containment reference list is set.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return whether the value of the '<em>Elements Name Owned</em>' containment reference list is set.
    * @see #unsetElementsNameOwned()
    * @see #getElementsNameOwned()
    * @generated
    */
   boolean isSetElementsNameOwned();

} // DataComponentReference
