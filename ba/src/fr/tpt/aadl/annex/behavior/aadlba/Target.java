/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Target</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Target#getElementNameOwned <em>Element Name Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.Target#getDataComponentReferenceOwned <em>Data Component Reference Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getTarget()
 * @model
 * @generated
 */
public interface Target extends ParameterLabel
{
   /**
    * Returns the value of the '<em><b>Element Name Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Element Name Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Element Name Owned</em>' containment reference.
    * @see #setElementNameOwned(Name)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getTarget_ElementNameOwned()
    * @model containment="true"
    * @generated
    */
   Name getElementNameOwned();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Target#getElementNameOwned <em>Element Name Owned</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Element Name Owned</em>' containment reference.
    * @see #getElementNameOwned()
    * @generated
    */
   void setElementNameOwned(Name value);

   /**
    * Returns the value of the '<em><b>Data Component Reference Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Data Component Reference Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Data Component Reference Owned</em>' containment reference.
    * @see #setDataComponentReferenceOwned(DataComponentReference)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getTarget_DataComponentReferenceOwned()
    * @model containment="true"
    * @generated
    */
   DataComponentReference getDataComponentReferenceOwned();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.Target#getDataComponentReferenceOwned <em>Data Component Reference Owned</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Data Component Reference Owned</em>' containment reference.
    * @see #getDataComponentReferenceOwned()
    * @generated
    */
   void setDataComponentReferenceOwned(DataComponentReference value);

} // Target
