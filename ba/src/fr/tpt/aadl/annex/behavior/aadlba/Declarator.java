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
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Declarator#getArraySizes <em>Array Sizes</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getDeclarator()
 * @model
 * @generated
 */
public interface Declarator extends NamedElement
{
   /**
    * Returns the value of the '<em><b>Array Sizes</b></em>' containment reference list.
    * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.ArraySize}.
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
   EList<ArraySize> getArraySizes();

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
