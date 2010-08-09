/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Communication Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getActionType <em>Action Type</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getEltNameOwned <em>Elt Name Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getSubpgmParamListOwned <em>Subpgm Param List Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#isHasValueExpression <em>Has Value Expression</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#isHasTarget <em>Has Target</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getValueExprOwned <em>Value Expr Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getTarOwned <em>Tar Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getDataUniqueComponentClassifierReference <em>Data Unique Component Classifier Reference</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#isCatchTimeout <em>Catch Timeout</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#isAll <em>All</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getCommunicationAction()
 * @model
 * @generated
 */
public interface CommunicationAction extends BasicAction
{
   /**
	 * Returns the value of the '<em><b>Action Type</b></em>' attribute.
	 * The literals are from the enumeration {@link fr.tpt.aadl.annex.behavior.aadlba.CommActionParameter}.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Action Type</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Type</em>' attribute.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.CommActionParameter
	 * @see #setActionType(CommActionParameter)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getCommunicationAction_ActionType()
	 * @model
	 * @generated
	 */
   CommActionParameter getActionType();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getActionType <em>Action Type</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Type</em>' attribute.
	 * @see fr.tpt.aadl.annex.behavior.aadlba.CommActionParameter
	 * @see #getActionType()
	 * @generated
	 */
   void setActionType(CommActionParameter value);

   /**
	 * Returns the value of the '<em><b>Elt Name Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Elt Name Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Elt Name Owned</em>' containment reference.
	 * @see #setEltNameOwned(Name)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getCommunicationAction_EltNameOwned()
	 * @model containment="true"
	 * @generated
	 */
   Name getEltNameOwned();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getEltNameOwned <em>Elt Name Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elt Name Owned</em>' containment reference.
	 * @see #getEltNameOwned()
	 * @generated
	 */
   void setEltNameOwned(Name value);

   /**
	 * Returns the value of the '<em><b>Subpgm Param List Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Subpgm Param List Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Subpgm Param List Owned</em>' containment reference.
	 * @see #isSetSubpgmParamListOwned()
	 * @see #unsetSubpgmParamListOwned()
	 * @see #setSubpgmParamListOwned(SubprogramParameterList)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getCommunicationAction_SubpgmParamListOwned()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
   SubprogramParameterList getSubpgmParamListOwned();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getSubpgmParamListOwned <em>Subpgm Param List Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subpgm Param List Owned</em>' containment reference.
	 * @see #isSetSubpgmParamListOwned()
	 * @see #unsetSubpgmParamListOwned()
	 * @see #getSubpgmParamListOwned()
	 * @generated
	 */
   void setSubpgmParamListOwned(SubprogramParameterList value);

   /**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getSubpgmParamListOwned <em>Subpgm Param List Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isSetSubpgmParamListOwned()
	 * @see #getSubpgmParamListOwned()
	 * @see #setSubpgmParamListOwned(SubprogramParameterList)
	 * @generated
	 */
   void unsetSubpgmParamListOwned();

   /**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getSubpgmParamListOwned <em>Subpgm Param List Owned</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Subpgm Param List Owned</em>' containment reference is set.
	 * @see #unsetSubpgmParamListOwned()
	 * @see #getSubpgmParamListOwned()
	 * @see #setSubpgmParamListOwned(SubprogramParameterList)
	 * @generated
	 */
   boolean isSetSubpgmParamListOwned();

   /**
	 * Returns the value of the '<em><b>Has Value Expression</b></em>' attribute.
	 * The default value is <code>"False"</code>.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Has Value Expression</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Value Expression</em>' attribute.
	 * @see #setHasValueExpression(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getCommunicationAction_HasValueExpression()
	 * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isHasValueExpression();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#isHasValueExpression <em>Has Value Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Value Expression</em>' attribute.
	 * @see #isHasValueExpression()
	 * @generated
	 */
   void setHasValueExpression(boolean value);

   /**
	 * Returns the value of the '<em><b>Has Target</b></em>' attribute.
	 * The default value is <code>"False"</code>.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Has Target</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Target</em>' attribute.
	 * @see #setHasTarget(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getCommunicationAction_HasTarget()
	 * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isHasTarget();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#isHasTarget <em>Has Target</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Target</em>' attribute.
	 * @see #isHasTarget()
	 * @generated
	 */
   void setHasTarget(boolean value);

   /**
	 * Returns the value of the '<em><b>Value Expr Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Value Expr Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Expr Owned</em>' containment reference.
	 * @see #setValueExprOwned(ValueExpression)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getCommunicationAction_ValueExprOwned()
	 * @model containment="true"
	 * @generated
	 */
   ValueExpression getValueExprOwned();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getValueExprOwned <em>Value Expr Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Expr Owned</em>' containment reference.
	 * @see #getValueExprOwned()
	 * @generated
	 */
   void setValueExprOwned(ValueExpression value);

   /**
	 * Returns the value of the '<em><b>Tar Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Tar Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Tar Owned</em>' containment reference.
	 * @see #setTarOwned(Target)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getCommunicationAction_TarOwned()
	 * @model containment="true"
	 * @generated
	 */
   Target getTarOwned();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getTarOwned <em>Tar Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tar Owned</em>' containment reference.
	 * @see #getTarOwned()
	 * @generated
	 */
   void setTarOwned(Target value);

   /**
	 * Returns the value of the '<em><b>Data Unique Component Classifier Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Data Unique Component Classifier Reference</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Unique Component Classifier Reference</em>' containment reference.
	 * @see #isSetDataUniqueComponentClassifierReference()
	 * @see #unsetDataUniqueComponentClassifierReference()
	 * @see #setDataUniqueComponentClassifierReference(UniqueComponentClassifierReference)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getCommunicationAction_DataUniqueComponentClassifierReference()
	 * @model containment="true" unsettable="true" required="true"
	 * @generated
	 */
   UniqueComponentClassifierReference getDataUniqueComponentClassifierReference();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getDataUniqueComponentClassifierReference <em>Data Unique Component Classifier Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Unique Component Classifier Reference</em>' containment reference.
	 * @see #isSetDataUniqueComponentClassifierReference()
	 * @see #unsetDataUniqueComponentClassifierReference()
	 * @see #getDataUniqueComponentClassifierReference()
	 * @generated
	 */
   void setDataUniqueComponentClassifierReference(UniqueComponentClassifierReference value);

   /**
	 * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getDataUniqueComponentClassifierReference <em>Data Unique Component Classifier Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isSetDataUniqueComponentClassifierReference()
	 * @see #getDataUniqueComponentClassifierReference()
	 * @see #setDataUniqueComponentClassifierReference(UniqueComponentClassifierReference)
	 * @generated
	 */
   void unsetDataUniqueComponentClassifierReference();

   /**
	 * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#getDataUniqueComponentClassifierReference <em>Data Unique Component Classifier Reference</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Data Unique Component Classifier Reference</em>' containment reference is set.
	 * @see #unsetDataUniqueComponentClassifierReference()
	 * @see #getDataUniqueComponentClassifierReference()
	 * @see #setDataUniqueComponentClassifierReference(UniqueComponentClassifierReference)
	 * @generated
	 */
   boolean isSetDataUniqueComponentClassifierReference();

   /**
	 * Returns the value of the '<em><b>Catch Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Catch Timeout</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Catch Timeout</em>' attribute.
	 * @see #setCatchTimeout(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getCommunicationAction_CatchTimeout()
	 * @model dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isCatchTimeout();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#isCatchTimeout <em>Catch Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Catch Timeout</em>' attribute.
	 * @see #isCatchTimeout()
	 * @generated
	 */
   void setCatchTimeout(boolean value);

   /**
	 * Returns the value of the '<em><b>All</b></em>' attribute.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>All</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>All</em>' attribute.
	 * @see #setAll(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getCommunicationAction_All()
	 * @model dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isAll();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.CommunicationAction#isAll <em>All</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>All</em>' attribute.
	 * @see #isAll()
	 * @generated
	 */
   void setAll(boolean value);

} // CommunicationAction
