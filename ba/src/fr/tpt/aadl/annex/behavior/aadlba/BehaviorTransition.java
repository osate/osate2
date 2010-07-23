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
 * A representation of the model object '<em><b>Behavior Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getSourceStateIdentifiers <em>Source State Identifiers</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorConditionOwned <em>Behavior Condition Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorTransitionPriority <em>Behavior Transition Priority</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getDestinationStateIdentifier <em>Destination State Identifier</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getTransitionIdentifier <em>Transition Identifier</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getTimeout <em>Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorTransition()
 * @model
 * @generated
 */
public interface BehaviorTransition extends Element
{
   /**
    * Returns the value of the '<em><b>Source State Identifiers</b></em>' containment reference list.
    * The list contents are of type {@link fr.tpt.aadl.annex.behavior.aadlba.Identifier}.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Source State Identifiers</em>' containment reference list isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Source State Identifiers</em>' containment reference list.
    * @see #isSetSourceStateIdentifiers()
    * @see #unsetSourceStateIdentifiers()
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorTransition_SourceStateIdentifiers()
    * @model containment="true" unsettable="true"
    * @generated
    */
   EList<Identifier> getSourceStateIdentifiers();

   /**
    * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getSourceStateIdentifiers <em>Source State Identifiers</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isSetSourceStateIdentifiers()
    * @see #getSourceStateIdentifiers()
    * @generated
    */
   void unsetSourceStateIdentifiers();

   /**
    * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getSourceStateIdentifiers <em>Source State Identifiers</em>}' containment reference list is set.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return whether the value of the '<em>Source State Identifiers</em>' containment reference list is set.
    * @see #unsetSourceStateIdentifiers()
    * @see #getSourceStateIdentifiers()
    * @generated
    */
   boolean isSetSourceStateIdentifiers();

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
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorTransition_BehaviorActionsOwned()
    * @model containment="true" unsettable="true"
    * @generated
    */
   BehaviorActions getBehaviorActionsOwned();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}' containment reference.
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
    * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isSetBehaviorActionsOwned()
    * @see #getBehaviorActionsOwned()
    * @see #setBehaviorActionsOwned(BehaviorActions)
    * @generated
    */
   void unsetBehaviorActionsOwned();

   /**
    * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}' containment reference is set.
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
    * Returns the value of the '<em><b>Behavior Condition Owned</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Behavior Condition Owned</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Behavior Condition Owned</em>' containment reference.
    * @see #isSetBehaviorConditionOwned()
    * @see #unsetBehaviorConditionOwned()
    * @see #setBehaviorConditionOwned(BehaviorCondition)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorTransition_BehaviorConditionOwned()
    * @model containment="true" unsettable="true"
    * @generated
    */
   BehaviorCondition getBehaviorConditionOwned();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorConditionOwned <em>Behavior Condition Owned</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Behavior Condition Owned</em>' containment reference.
    * @see #isSetBehaviorConditionOwned()
    * @see #unsetBehaviorConditionOwned()
    * @see #getBehaviorConditionOwned()
    * @generated
    */
   void setBehaviorConditionOwned(BehaviorCondition value);

   /**
    * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorConditionOwned <em>Behavior Condition Owned</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isSetBehaviorConditionOwned()
    * @see #getBehaviorConditionOwned()
    * @see #setBehaviorConditionOwned(BehaviorCondition)
    * @generated
    */
   void unsetBehaviorConditionOwned();

   /**
    * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorConditionOwned <em>Behavior Condition Owned</em>}' containment reference is set.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return whether the value of the '<em>Behavior Condition Owned</em>' containment reference is set.
    * @see #unsetBehaviorConditionOwned()
    * @see #getBehaviorConditionOwned()
    * @see #setBehaviorConditionOwned(BehaviorCondition)
    * @generated
    */
   boolean isSetBehaviorConditionOwned();

   /**
    * Returns the value of the '<em><b>Behavior Transition Priority</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Behavior Transition Priority</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Behavior Transition Priority</em>' containment reference.
    * @see #isSetBehaviorTransitionPriority()
    * @see #unsetBehaviorTransitionPriority()
    * @see #setBehaviorTransitionPriority(Numeral)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorTransition_BehaviorTransitionPriority()
    * @model containment="true" unsettable="true"
    * @generated
    */
   Numeral getBehaviorTransitionPriority();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorTransitionPriority <em>Behavior Transition Priority</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Behavior Transition Priority</em>' containment reference.
    * @see #isSetBehaviorTransitionPriority()
    * @see #unsetBehaviorTransitionPriority()
    * @see #getBehaviorTransitionPriority()
    * @generated
    */
   void setBehaviorTransitionPriority(Numeral value);

   /**
    * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorTransitionPriority <em>Behavior Transition Priority</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isSetBehaviorTransitionPriority()
    * @see #getBehaviorTransitionPriority()
    * @see #setBehaviorTransitionPriority(Numeral)
    * @generated
    */
   void unsetBehaviorTransitionPriority();

   /**
    * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getBehaviorTransitionPriority <em>Behavior Transition Priority</em>}' containment reference is set.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return whether the value of the '<em>Behavior Transition Priority</em>' containment reference is set.
    * @see #unsetBehaviorTransitionPriority()
    * @see #getBehaviorTransitionPriority()
    * @see #setBehaviorTransitionPriority(Numeral)
    * @generated
    */
   boolean isSetBehaviorTransitionPriority();

   /**
    * Returns the value of the '<em><b>Destination State Identifier</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Destination State Identifier</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Destination State Identifier</em>' containment reference.
    * @see #setDestinationStateIdentifier(Identifier)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorTransition_DestinationStateIdentifier()
    * @model containment="true"
    * @generated
    */
   Identifier getDestinationStateIdentifier();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getDestinationStateIdentifier <em>Destination State Identifier</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Destination State Identifier</em>' containment reference.
    * @see #getDestinationStateIdentifier()
    * @generated
    */
   void setDestinationStateIdentifier(Identifier value);

   /**
    * Returns the value of the '<em><b>Transition Identifier</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Transition Identifier</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Transition Identifier</em>' containment reference.
    * @see #setTransitionIdentifier(Identifier)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorTransition_TransitionIdentifier()
    * @model containment="true"
    * @generated
    */
   Identifier getTransitionIdentifier();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getTransitionIdentifier <em>Transition Identifier</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Transition Identifier</em>' containment reference.
    * @see #getTransitionIdentifier()
    * @generated
    */
   void setTransitionIdentifier(Identifier value);

   /**
    * Returns the value of the '<em><b>Timeout</b></em>' containment reference.
    * <!-- begin-user-doc -->
    * <p>
    * If the meaning of the '<em>Timeout</em>' containment reference isn't clear,
    * there really should be more of a description here...
    * </p>
    * <!-- end-user-doc -->
    * @return the value of the '<em>Timeout</em>' containment reference.
    * @see #isSetTimeout()
    * @see #unsetTimeout()
    * @see #setTimeout(BehaviorTime)
    * @see fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage#getBehaviorTransition_Timeout()
    * @model containment="true" unsettable="true"
    * @generated
    */
   BehaviorTime getTimeout();

   /**
    * Sets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getTimeout <em>Timeout</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @param value the new value of the '<em>Timeout</em>' containment reference.
    * @see #isSetTimeout()
    * @see #unsetTimeout()
    * @see #getTimeout()
    * @generated
    */
   void setTimeout(BehaviorTime value);

   /**
    * Unsets the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getTimeout <em>Timeout</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #isSetTimeout()
    * @see #getTimeout()
    * @see #setTimeout(BehaviorTime)
    * @generated
    */
   void unsetTimeout();

   /**
    * Returns whether the value of the '{@link fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition#getTimeout <em>Timeout</em>}' containment reference is set.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @return whether the value of the '<em>Timeout</em>' containment reference is set.
    * @see #unsetTimeout()
    * @see #getTimeout()
    * @see #setTimeout(BehaviorTime)
    * @generated
    */
   boolean isSetTimeout();

} // BehaviorTransition
