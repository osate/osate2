/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behavior Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#getBasicActionOwned <em>Basic Action Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#getCondStatementOwned <em>Cond Statement Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isBasicAction <em>Basic Action</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isIf <em>If</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isFor <em>For</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isWhile <em>While</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isDoUntil <em>Do Until</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isBehaviorActions <em>Behavior Actions</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isLoop <em>Loop</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorAction()
 * @model
 * @generated
 */
public interface BehaviorAction extends Element
{
   /**
	 * Returns the value of the '<em><b>Basic Action Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Basic Action Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Basic Action Owned</em>' containment reference.
	 * @see #setBasicActionOwned(BasicAction)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorAction_BasicActionOwned()
	 * @model containment="true"
	 * @generated
	 */
   BasicAction getBasicActionOwned();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#getBasicActionOwned <em>Basic Action Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basic Action Owned</em>' containment reference.
	 * @see #getBasicActionOwned()
	 * @generated
	 */
   void setBasicActionOwned(BasicAction value);

   /**
	 * Returns the value of the '<em><b>Behavior Actions Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Behavior Actions Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior Actions Owned</em>' containment reference.
	 * @see #setBehaviorActionsOwned(BehaviorActions)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorAction_BehaviorActionsOwned()
	 * @model containment="true"
	 * @generated
	 */
   BehaviorActions getBehaviorActionsOwned();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior Actions Owned</em>' containment reference.
	 * @see #getBehaviorActionsOwned()
	 * @generated
	 */
   void setBehaviorActionsOwned(BehaviorActions value);

   /**
	 * Returns the value of the '<em><b>Cond Statement Owned</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Cond Statement Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Cond Statement Owned</em>' containment reference.
	 * @see #setCondStatementOwned(CondStatement)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorAction_CondStatementOwned()
	 * @model containment="true"
	 * @generated
	 */
   CondStatement getCondStatementOwned();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#getCondStatementOwned <em>Cond Statement Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cond Statement Owned</em>' containment reference.
	 * @see #getCondStatementOwned()
	 * @generated
	 */
   void setCondStatementOwned(CondStatement value);

   /**
	 * Returns the value of the '<em><b>Basic Action</b></em>' attribute.
	 * The default value is <code>"False"</code>.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Basic Action</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Basic Action</em>' attribute.
	 * @see #setBasicAction(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorAction_BasicAction()
	 * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isBasicAction();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isBasicAction <em>Basic Action</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Basic Action</em>' attribute.
	 * @see #isBasicAction()
	 * @generated
	 */
   void setBasicAction(boolean value);

   /**
	 * Returns the value of the '<em><b>If</b></em>' attribute.
	 * The default value is <code>"False"</code>.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>If</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>If</em>' attribute.
	 * @see #setIf(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorAction_If()
	 * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isIf();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isIf <em>If</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If</em>' attribute.
	 * @see #isIf()
	 * @generated
	 */
   void setIf(boolean value);

   /**
	 * Returns the value of the '<em><b>For</b></em>' attribute.
	 * The default value is <code>"False"</code>.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>For</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>For</em>' attribute.
	 * @see #setFor(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorAction_For()
	 * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isFor();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isFor <em>For</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>For</em>' attribute.
	 * @see #isFor()
	 * @generated
	 */
   void setFor(boolean value);

   /**
	 * Returns the value of the '<em><b>While</b></em>' attribute.
	 * The default value is <code>"False"</code>.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>While</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>While</em>' attribute.
	 * @see #setWhile(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorAction_While()
	 * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isWhile();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isWhile <em>While</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>While</em>' attribute.
	 * @see #isWhile()
	 * @generated
	 */
   void setWhile(boolean value);

   /**
	 * Returns the value of the '<em><b>Do Until</b></em>' attribute.
	 * The default value is <code>"False"</code>.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Do Until</em>' attribute isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Do Until</em>' attribute.
	 * @see #setDoUntil(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorAction_DoUntil()
	 * @model default="False" dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
   boolean isDoUntil();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isDoUntil <em>Do Until</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Do Until</em>' attribute.
	 * @see #isDoUntil()
	 * @generated
	 */
   void setDoUntil(boolean value);

   /**
	 * Returns the value of the '<em><b>Timeout</b></em>' containment reference.
	 * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Timeout</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
	 * @return the value of the '<em>Timeout</em>' containment reference.
	 * @see #setTimeout(BehaviorTime)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorAction_Timeout()
	 * @model containment="true"
	 * @generated
	 */
   BehaviorTime getTimeout();

   /**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#getTimeout <em>Timeout</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeout</em>' containment reference.
	 * @see #getTimeout()
	 * @generated
	 */
   void setTimeout(BehaviorTime value);

			/**
	 * Returns the value of the '<em><b>Behavior Actions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior Actions</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior Actions</em>' attribute.
	 * @see #setBehaviorActions(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorAction_BehaviorActions()
	 * @model dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
	boolean isBehaviorActions();

			/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isBehaviorActions <em>Behavior Actions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior Actions</em>' attribute.
	 * @see #isBehaviorActions()
	 * @generated
	 */
	void setBehaviorActions(boolean value);

			/**
	 * Returns the value of the '<em><b>Loop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop</em>' attribute.
	 * @see #setLoop(boolean)
	 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorAction_Loop()
	 * @model dataType="fr.tpt.aadl.annex.behavior.aadlba.Boolean"
	 * @generated
	 */
	boolean isLoop();

			/**
	 * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction#isLoop <em>Loop</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop</em>' attribute.
	 * @see #isLoop()
	 * @generated
	 */
	void setLoop(boolean value);

} // BehaviorAction
