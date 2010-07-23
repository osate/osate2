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
 * A representation of the model object '<em><b>Subprogram Parameter List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramParameterList#getParameterList <em>Parameter List</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getSubprogramParameterList()
 * @model
 * @generated
 */
public interface SubprogramParameterList extends Element
{
   /**
    * Returns the value of the '<em><b>Parameter List</b></em>' containment reference list.
    * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Parameter List</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Parameter List</em>' containment reference list.
    * @see #isSetParameterList()
    * @see #unsetParameterList()
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getSubprogramParameterList_ParameterList()
    * @model containment="true" unsettable="true"
    * @generated
    */
   EList<ParameterLabel> getParameterList();

   /**
    * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramParameterList#getParameterList <em>Parameter List</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isSetParameterList()
    * @see #getParameterList()
    * @generated
    */
   void unsetParameterList();

   /**
    * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.SubprogramParameterList#getParameterList <em>Parameter List</em>}' containment reference list is set.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return whether the value of the '<em>Parameter List</em>' containment reference list is set.
    * @see #unsetParameterList()
    * @see #getParameterList()
    * @generated
    */
   boolean isSetParameterList();

} // SubprogramParameterList
