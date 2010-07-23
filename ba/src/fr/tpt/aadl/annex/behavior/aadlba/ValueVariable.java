/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#getDataComponentReferenceOwned <em>Data Component Reference Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#isInterrogation <em>Interrogation</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#isCount <em>Count</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#isFresh <em>Fresh</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#isHasDataCptRef <em>Has Data Cpt Ref</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#getElementNameOwned <em>Element Name Owned</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getValueVariable()
 * @model
 * @generated
 */
public interface ValueVariable extends Value, IntegerValue
{
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
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getValueVariable_DataComponentReferenceOwned()
    * @model containment="true"
    * @generated
    */
   DataComponentReference getDataComponentReferenceOwned();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#getDataComponentReferenceOwned <em>Data Component Reference Owned</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Data Component Reference Owned</em>' containment reference.
    * @see #getDataComponentReferenceOwned()
    * @generated
    */
   void setDataComponentReferenceOwned(DataComponentReference value);

   /**
    * Returns the value of the '<em><b>Interrogation</b></em>' attribute.
    * The default value is <code>"False"</code>.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Interrogation</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Interrogation</em>' attribute.
    * @see #setInterrogation(boolean)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getValueVariable_Interrogation()
    * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
    * @generated
    */
   boolean isInterrogation();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#isInterrogation <em>Interrogation</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Interrogation</em>' attribute.
    * @see #isInterrogation()
    * @generated
    */
   void setInterrogation(boolean value);

   /**
    * Returns the value of the '<em><b>Count</b></em>' attribute.
    * The default value is <code>"False"</code>.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Count</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Count</em>' attribute.
    * @see #setCount(boolean)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getValueVariable_Count()
    * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
    * @generated
    */
   boolean isCount();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#isCount <em>Count</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Count</em>' attribute.
    * @see #isCount()
    * @generated
    */
   void setCount(boolean value);

   /**
    * Returns the value of the '<em><b>Fresh</b></em>' attribute.
    * The default value is <code>"False"</code>.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Fresh</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Fresh</em>' attribute.
    * @see #setFresh(boolean)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getValueVariable_Fresh()
    * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
    * @generated
    */
   boolean isFresh();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#isFresh <em>Fresh</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Fresh</em>' attribute.
    * @see #isFresh()
    * @generated
    */
   void setFresh(boolean value);

   /**
    * Returns the value of the '<em><b>Has Data Cpt Ref</b></em>' attribute.
    * The default value is <code>"False"</code>.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Has Data Cpt Ref</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Has Data Cpt Ref</em>' attribute.
    * @see #setHasDataCptRef(boolean)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getValueVariable_HasDataCptRef()
    * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
    * @generated
    */
   boolean isHasDataCptRef();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#isHasDataCptRef <em>Has Data Cpt Ref</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Has Data Cpt Ref</em>' attribute.
    * @see #isHasDataCptRef()
    * @generated
    */
   void setHasDataCptRef(boolean value);

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
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getValueVariable_ElementNameOwned()
    * @model containment="true"
    * @generated
    */
   Name getElementNameOwned();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ValueVariable#getElementNameOwned <em>Element Name Owned</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Element Name Owned</em>' containment reference.
    * @see #getElementNameOwned()
    * @generated
    */
   void setElementNameOwned(Name value);

} // ValueVariable
