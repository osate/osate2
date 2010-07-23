/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Or For All Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getDataUniqueCmtClassRef <em>Data Unique Cmt Class Ref</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getElementValuesOwned <em>Element Values Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#isForAll <em>For All</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getForOrForAllStatement()
 * @model
 * @generated
 */
public interface ForOrForAllStatement extends NamedElement, CondStatement
{
   /**
    * Returns the value of the '<em><b>Data Unique Cmt Class Ref</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Data Unique Cmt Class Ref</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Data Unique Cmt Class Ref</em>' containment reference.
    * @see #setDataUniqueCmtClassRef(UniqueComponentClassifierReference)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getForOrForAllStatement_DataUniqueCmtClassRef()
    * @model containment="true"
    * @generated
    */
   UniqueComponentClassifierReference getDataUniqueCmtClassRef();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getDataUniqueCmtClassRef <em>Data Unique Cmt Class Ref</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Data Unique Cmt Class Ref</em>' containment reference.
    * @see #getDataUniqueCmtClassRef()
    * @generated
    */
   void setDataUniqueCmtClassRef(UniqueComponentClassifierReference value);

   /**
    * Returns the value of the '<em><b>Element Values Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Element Values Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Element Values Owned</em>' containment reference.
    * @see #setElementValuesOwned(ElementValues)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getForOrForAllStatement_ElementValuesOwned()
    * @model containment="true"
    * @generated
    */
   ElementValues getElementValuesOwned();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getElementValuesOwned <em>Element Values Owned</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Element Values Owned</em>' containment reference.
    * @see #getElementValuesOwned()
    * @generated
    */
   void setElementValuesOwned(ElementValues value);

   /**
    * Returns the value of the '<em><b>Behavior Actions Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Behavior Actions Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Behavior Actions Owned</em>' containment reference.
    * @see #isSetBehaviorActionsOwned()
    * @see #unsetBehaviorActionsOwned()
    * @see #setBehaviorActionsOwned(BehaviorActions)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getForOrForAllStatement_BehaviorActionsOwned()
    * @model containment="true" unsettable="true"
    * @generated
    */
   BehaviorActions getBehaviorActionsOwned();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Behavior Actions Owned</em>' containment reference.
    * @see #isSetBehaviorActionsOwned()
    * @see #unsetBehaviorActionsOwned()
    * @see #getBehaviorActionsOwned()
    * @generated
    */
   void setBehaviorActionsOwned(BehaviorActions value);

   /**
    * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isSetBehaviorActionsOwned()
    * @see #getBehaviorActionsOwned()
    * @see #setBehaviorActionsOwned(BehaviorActions)
    * @generated
    */
   void unsetBehaviorActionsOwned();

   /**
    * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}' containment reference is set.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return whether the value of the '<em>Behavior Actions Owned</em>' containment reference is set.
    * @see #unsetBehaviorActionsOwned()
    * @see #getBehaviorActionsOwned()
    * @see #setBehaviorActionsOwned(BehaviorActions)
    * @generated
    */
   boolean isSetBehaviorActionsOwned();

   /**
    * Returns the value of the '<em><b>For All</b></em>' attribute.
    * The default value is <code>"False"</code>.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>For All</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>For All</em>' attribute.
    * @see #setForAll(boolean)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getForOrForAllStatement_ForAll()
    * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
    * @generated
    */
   boolean isForAll();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement#isForAll <em>For All</em>}' attribute.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>For All</em>' attribute.
    * @see #isForAll()
    * @generated
    */
   void setForAll(boolean value);

} // ForOrForAllStatement
