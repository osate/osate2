/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier;
import fr.tpt.aadl.annex.behavior.aadlba.Numeral;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl#getSourceStateIdentifiers <em>Source State Identifiers</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl#getBehaviorConditionOwned <em>Behavior Condition Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl#getBehaviorTransitionPriority <em>Behavior Transition Priority</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl#getDestinationStateIdentifier <em>Destination State Identifier</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl#getTransitionIdentifier <em>Transition Identifier</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl#getTimeout <em>Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BehaviorTransitionImpl extends ElementImpl implements BehaviorTransition
{
   /**
    * The cached value of the '{@link #getSourceStateIdentifiers() <em>Source State Identifiers</em>}' containment reference list.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getSourceStateIdentifiers()
    * @generated
    * @ordered
    */
   protected EList<Identifier> sourceStateIdentifiers;

   /**
    * The cached value of the '{@link #getBehaviorActionsOwned() <em>Behavior Actions Owned</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getBehaviorActionsOwned()
    * @generated
    * @ordered
    */
   protected BehaviorActions behaviorActionsOwned;

   /**
    * This is true if the Behavior Actions Owned containment reference has been set.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   protected boolean behaviorActionsOwnedESet;

   /**
    * The cached value of the '{@link #getBehaviorConditionOwned() <em>Behavior Condition Owned</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getBehaviorConditionOwned()
    * @generated
    * @ordered
    */
   protected BehaviorCondition behaviorConditionOwned;

   /**
    * This is true if the Behavior Condition Owned containment reference has been set.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   protected boolean behaviorConditionOwnedESet;

   /**
    * The cached value of the '{@link #getBehaviorTransitionPriority() <em>Behavior Transition Priority</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getBehaviorTransitionPriority()
    * @generated
    * @ordered
    */
   protected Numeral behaviorTransitionPriority;

   /**
    * This is true if the Behavior Transition Priority containment reference has been set.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   protected boolean behaviorTransitionPriorityESet;

   /**
    * The cached value of the '{@link #getDestinationStateIdentifier() <em>Destination State Identifier</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getDestinationStateIdentifier()
    * @generated
    * @ordered
    */
   protected Identifier destinationStateIdentifier;

   /**
    * The cached value of the '{@link #getTransitionIdentifier() <em>Transition Identifier</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getTransitionIdentifier()
    * @generated
    * @ordered
    */
   protected Identifier transitionIdentifier;

   /**
    * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' containment reference.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @see #getTimeout()
    * @generated
    * @ordered
    */
   protected BehaviorTime timeout;

   /**
    * This is true if the Timeout containment reference has been set.
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    * @ordered
    */
   protected boolean timeoutESet;

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected BehaviorTransitionImpl()
   {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   protected EClass eStaticClass()
   {
      return AadlBaPackage.Literals.BEHAVIOR_TRANSITION;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<Identifier> getSourceStateIdentifiers()
   {
      if (sourceStateIdentifiers == null)
      {
         sourceStateIdentifiers = new EObjectContainmentEList.Unsettable<Identifier>(Identifier.class, this, AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE_IDENTIFIERS);
      }
      return sourceStateIdentifiers;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void unsetSourceStateIdentifiers()
   {
      if (sourceStateIdentifiers != null) ((InternalEList.Unsettable<?>)sourceStateIdentifiers).unset();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isSetSourceStateIdentifiers()
   {
      return sourceStateIdentifiers != null && ((InternalEList.Unsettable<?>)sourceStateIdentifiers).isSet();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public BehaviorActions getBehaviorActionsOwned()
   {
      return behaviorActionsOwned;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetBehaviorActionsOwned(BehaviorActions newBehaviorActionsOwned, NotificationChain msgs)
   {
      BehaviorActions oldBehaviorActionsOwned = behaviorActionsOwned;
      behaviorActionsOwned = newBehaviorActionsOwned;
      boolean oldBehaviorActionsOwnedESet = behaviorActionsOwnedESet;
      behaviorActionsOwnedESet = true;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_ACTIONS_OWNED, oldBehaviorActionsOwned, newBehaviorActionsOwned, !oldBehaviorActionsOwnedESet);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setBehaviorActionsOwned(BehaviorActions newBehaviorActionsOwned)
   {
      if (newBehaviorActionsOwned != behaviorActionsOwned)
      {
         NotificationChain msgs = null;
         if (behaviorActionsOwned != null)
            msgs = ((InternalEObject)behaviorActionsOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_ACTIONS_OWNED, null, msgs);
         if (newBehaviorActionsOwned != null)
            msgs = ((InternalEObject)newBehaviorActionsOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_ACTIONS_OWNED, null, msgs);
         msgs = basicSetBehaviorActionsOwned(newBehaviorActionsOwned, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else
      {
         boolean oldBehaviorActionsOwnedESet = behaviorActionsOwnedESet;
         behaviorActionsOwnedESet = true;
         if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_ACTIONS_OWNED, newBehaviorActionsOwned, newBehaviorActionsOwned, !oldBehaviorActionsOwnedESet));
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicUnsetBehaviorActionsOwned(NotificationChain msgs)
   {
      BehaviorActions oldBehaviorActionsOwned = behaviorActionsOwned;
      behaviorActionsOwned = null;
      boolean oldBehaviorActionsOwnedESet = behaviorActionsOwnedESet;
      behaviorActionsOwnedESet = false;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_ACTIONS_OWNED, oldBehaviorActionsOwned, null, oldBehaviorActionsOwnedESet);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void unsetBehaviorActionsOwned()
   {
      if (behaviorActionsOwned != null)
      {
         NotificationChain msgs = null;
         msgs = ((InternalEObject)behaviorActionsOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_ACTIONS_OWNED, null, msgs);
         msgs = basicUnsetBehaviorActionsOwned(msgs);
         if (msgs != null) msgs.dispatch();
      }
      else
      {
         boolean oldBehaviorActionsOwnedESet = behaviorActionsOwnedESet;
         behaviorActionsOwnedESet = false;
         if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_ACTIONS_OWNED, null, null, oldBehaviorActionsOwnedESet));
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isSetBehaviorActionsOwned()
   {
      return behaviorActionsOwnedESet;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public BehaviorCondition getBehaviorConditionOwned()
   {
      return behaviorConditionOwned;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetBehaviorConditionOwned(BehaviorCondition newBehaviorConditionOwned, NotificationChain msgs)
   {
      BehaviorCondition oldBehaviorConditionOwned = behaviorConditionOwned;
      behaviorConditionOwned = newBehaviorConditionOwned;
      boolean oldBehaviorConditionOwnedESet = behaviorConditionOwnedESet;
      behaviorConditionOwnedESet = true;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED, oldBehaviorConditionOwned, newBehaviorConditionOwned, !oldBehaviorConditionOwnedESet);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setBehaviorConditionOwned(BehaviorCondition newBehaviorConditionOwned)
   {
      if (newBehaviorConditionOwned != behaviorConditionOwned)
      {
         NotificationChain msgs = null;
         if (behaviorConditionOwned != null)
            msgs = ((InternalEObject)behaviorConditionOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED, null, msgs);
         if (newBehaviorConditionOwned != null)
            msgs = ((InternalEObject)newBehaviorConditionOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED, null, msgs);
         msgs = basicSetBehaviorConditionOwned(newBehaviorConditionOwned, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else
      {
         boolean oldBehaviorConditionOwnedESet = behaviorConditionOwnedESet;
         behaviorConditionOwnedESet = true;
         if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED, newBehaviorConditionOwned, newBehaviorConditionOwned, !oldBehaviorConditionOwnedESet));
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicUnsetBehaviorConditionOwned(NotificationChain msgs)
   {
      BehaviorCondition oldBehaviorConditionOwned = behaviorConditionOwned;
      behaviorConditionOwned = null;
      boolean oldBehaviorConditionOwnedESet = behaviorConditionOwnedESet;
      behaviorConditionOwnedESet = false;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED, oldBehaviorConditionOwned, null, oldBehaviorConditionOwnedESet);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void unsetBehaviorConditionOwned()
   {
      if (behaviorConditionOwned != null)
      {
         NotificationChain msgs = null;
         msgs = ((InternalEObject)behaviorConditionOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED, null, msgs);
         msgs = basicUnsetBehaviorConditionOwned(msgs);
         if (msgs != null) msgs.dispatch();
      }
      else
      {
         boolean oldBehaviorConditionOwnedESet = behaviorConditionOwnedESet;
         behaviorConditionOwnedESet = false;
         if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED, null, null, oldBehaviorConditionOwnedESet));
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isSetBehaviorConditionOwned()
   {
      return behaviorConditionOwnedESet;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Numeral getBehaviorTransitionPriority()
   {
      return behaviorTransitionPriority;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetBehaviorTransitionPriority(Numeral newBehaviorTransitionPriority, NotificationChain msgs)
   {
      Numeral oldBehaviorTransitionPriority = behaviorTransitionPriority;
      behaviorTransitionPriority = newBehaviorTransitionPriority;
      boolean oldBehaviorTransitionPriorityESet = behaviorTransitionPriorityESet;
      behaviorTransitionPriorityESet = true;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY, oldBehaviorTransitionPriority, newBehaviorTransitionPriority, !oldBehaviorTransitionPriorityESet);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setBehaviorTransitionPriority(Numeral newBehaviorTransitionPriority)
   {
      if (newBehaviorTransitionPriority != behaviorTransitionPriority)
      {
         NotificationChain msgs = null;
         if (behaviorTransitionPriority != null)
            msgs = ((InternalEObject)behaviorTransitionPriority).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY, null, msgs);
         if (newBehaviorTransitionPriority != null)
            msgs = ((InternalEObject)newBehaviorTransitionPriority).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY, null, msgs);
         msgs = basicSetBehaviorTransitionPriority(newBehaviorTransitionPriority, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else
      {
         boolean oldBehaviorTransitionPriorityESet = behaviorTransitionPriorityESet;
         behaviorTransitionPriorityESet = true;
         if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY, newBehaviorTransitionPriority, newBehaviorTransitionPriority, !oldBehaviorTransitionPriorityESet));
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicUnsetBehaviorTransitionPriority(NotificationChain msgs)
   {
      Numeral oldBehaviorTransitionPriority = behaviorTransitionPriority;
      behaviorTransitionPriority = null;
      boolean oldBehaviorTransitionPriorityESet = behaviorTransitionPriorityESet;
      behaviorTransitionPriorityESet = false;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY, oldBehaviorTransitionPriority, null, oldBehaviorTransitionPriorityESet);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void unsetBehaviorTransitionPriority()
   {
      if (behaviorTransitionPriority != null)
      {
         NotificationChain msgs = null;
         msgs = ((InternalEObject)behaviorTransitionPriority).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY, null, msgs);
         msgs = basicUnsetBehaviorTransitionPriority(msgs);
         if (msgs != null) msgs.dispatch();
      }
      else
      {
         boolean oldBehaviorTransitionPriorityESet = behaviorTransitionPriorityESet;
         behaviorTransitionPriorityESet = false;
         if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY, null, null, oldBehaviorTransitionPriorityESet));
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isSetBehaviorTransitionPriority()
   {
      return behaviorTransitionPriorityESet;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Identifier getDestinationStateIdentifier()
   {
      return destinationStateIdentifier;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetDestinationStateIdentifier(Identifier newDestinationStateIdentifier, NotificationChain msgs)
   {
      Identifier oldDestinationStateIdentifier = destinationStateIdentifier;
      destinationStateIdentifier = newDestinationStateIdentifier;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER, oldDestinationStateIdentifier, newDestinationStateIdentifier);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setDestinationStateIdentifier(Identifier newDestinationStateIdentifier)
   {
      if (newDestinationStateIdentifier != destinationStateIdentifier)
      {
         NotificationChain msgs = null;
         if (destinationStateIdentifier != null)
            msgs = ((InternalEObject)destinationStateIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER, null, msgs);
         if (newDestinationStateIdentifier != null)
            msgs = ((InternalEObject)newDestinationStateIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER, null, msgs);
         msgs = basicSetDestinationStateIdentifier(newDestinationStateIdentifier, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER, newDestinationStateIdentifier, newDestinationStateIdentifier));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public Identifier getTransitionIdentifier()
   {
      return transitionIdentifier;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetTransitionIdentifier(Identifier newTransitionIdentifier, NotificationChain msgs)
   {
      Identifier oldTransitionIdentifier = transitionIdentifier;
      transitionIdentifier = newTransitionIdentifier;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER, oldTransitionIdentifier, newTransitionIdentifier);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setTransitionIdentifier(Identifier newTransitionIdentifier)
   {
      if (newTransitionIdentifier != transitionIdentifier)
      {
         NotificationChain msgs = null;
         if (transitionIdentifier != null)
            msgs = ((InternalEObject)transitionIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER, null, msgs);
         if (newTransitionIdentifier != null)
            msgs = ((InternalEObject)newTransitionIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER, null, msgs);
         msgs = basicSetTransitionIdentifier(newTransitionIdentifier, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else if (eNotificationRequired())
         eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER, newTransitionIdentifier, newTransitionIdentifier));
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public BehaviorTime getTimeout()
   {
      return timeout;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicSetTimeout(BehaviorTime newTimeout, NotificationChain msgs)
   {
      BehaviorTime oldTimeout = timeout;
      timeout = newTimeout;
      boolean oldTimeoutESet = timeoutESet;
      timeoutESet = true;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__TIMEOUT, oldTimeout, newTimeout, !oldTimeoutESet);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void setTimeout(BehaviorTime newTimeout)
   {
      if (newTimeout != timeout)
      {
         NotificationChain msgs = null;
         if (timeout != null)
            msgs = ((InternalEObject)timeout).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__TIMEOUT, null, msgs);
         if (newTimeout != null)
            msgs = ((InternalEObject)newTimeout).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__TIMEOUT, null, msgs);
         msgs = basicSetTimeout(newTimeout, msgs);
         if (msgs != null) msgs.dispatch();
      }
      else
      {
         boolean oldTimeoutESet = timeoutESet;
         timeoutESet = true;
         if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__TIMEOUT, newTimeout, newTimeout, !oldTimeoutESet));
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public NotificationChain basicUnsetTimeout(NotificationChain msgs)
   {
      BehaviorTime oldTimeout = timeout;
      timeout = null;
      boolean oldTimeoutESet = timeoutESet;
      timeoutESet = false;
      if (eNotificationRequired())
      {
         ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.BEHAVIOR_TRANSITION__TIMEOUT, oldTimeout, null, oldTimeoutESet);
         if (msgs == null) msgs = notification; else msgs.add(notification);
      }
      return msgs;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public void unsetTimeout()
   {
      if (timeout != null)
      {
         NotificationChain msgs = null;
         msgs = ((InternalEObject)timeout).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_TRANSITION__TIMEOUT, null, msgs);
         msgs = basicUnsetTimeout(msgs);
         if (msgs != null) msgs.dispatch();
      }
      else
      {
         boolean oldTimeoutESet = timeoutESet;
         timeoutESet = false;
         if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.BEHAVIOR_TRANSITION__TIMEOUT, null, null, oldTimeoutESet));
      }
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isSetTimeout()
   {
      return timeoutESet;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
   {
      switch (featureID)
      {
         case AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE_IDENTIFIERS:
            return ((InternalEList<?>)getSourceStateIdentifiers()).basicRemove(otherEnd, msgs);
         case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_ACTIONS_OWNED:
            return basicUnsetBehaviorActionsOwned(msgs);
         case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED:
            return basicUnsetBehaviorConditionOwned(msgs);
         case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY:
            return basicUnsetBehaviorTransitionPriority(msgs);
         case AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER:
            return basicSetDestinationStateIdentifier(null, msgs);
         case AadlBaPackage.BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER:
            return basicSetTransitionIdentifier(null, msgs);
         case AadlBaPackage.BEHAVIOR_TRANSITION__TIMEOUT:
            return basicUnsetTimeout(msgs);
      }
      return super.eInverseRemove(otherEnd, featureID, msgs);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Object eGet(int featureID, boolean resolve, boolean coreType)
   {
      switch (featureID)
      {
         case AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE_IDENTIFIERS:
            return getSourceStateIdentifiers();
         case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_ACTIONS_OWNED:
            return getBehaviorActionsOwned();
         case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED:
            return getBehaviorConditionOwned();
         case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY:
            return getBehaviorTransitionPriority();
         case AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER:
            return getDestinationStateIdentifier();
         case AadlBaPackage.BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER:
            return getTransitionIdentifier();
         case AadlBaPackage.BEHAVIOR_TRANSITION__TIMEOUT:
            return getTimeout();
      }
      return super.eGet(featureID, resolve, coreType);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @SuppressWarnings("unchecked")
   @Override
   public void eSet(int featureID, Object newValue)
   {
      switch (featureID)
      {
         case AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE_IDENTIFIERS:
            getSourceStateIdentifiers().clear();
            getSourceStateIdentifiers().addAll((Collection<? extends Identifier>)newValue);
            return;
         case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_ACTIONS_OWNED:
            setBehaviorActionsOwned((BehaviorActions)newValue);
            return;
         case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED:
            setBehaviorConditionOwned((BehaviorCondition)newValue);
            return;
         case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY:
            setBehaviorTransitionPriority((Numeral)newValue);
            return;
         case AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER:
            setDestinationStateIdentifier((Identifier)newValue);
            return;
         case AadlBaPackage.BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER:
            setTransitionIdentifier((Identifier)newValue);
            return;
         case AadlBaPackage.BEHAVIOR_TRANSITION__TIMEOUT:
            setTimeout((BehaviorTime)newValue);
            return;
      }
      super.eSet(featureID, newValue);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public void eUnset(int featureID)
   {
      switch (featureID)
      {
         case AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE_IDENTIFIERS:
            unsetSourceStateIdentifiers();
            return;
         case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_ACTIONS_OWNED:
            unsetBehaviorActionsOwned();
            return;
         case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED:
            unsetBehaviorConditionOwned();
            return;
         case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY:
            unsetBehaviorTransitionPriority();
            return;
         case AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER:
            setDestinationStateIdentifier((Identifier)null);
            return;
         case AadlBaPackage.BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER:
            setTransitionIdentifier((Identifier)null);
            return;
         case AadlBaPackage.BEHAVIOR_TRANSITION__TIMEOUT:
            unsetTimeout();
            return;
      }
      super.eUnset(featureID);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public boolean eIsSet(int featureID)
   {
      switch (featureID)
      {
         case AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE_IDENTIFIERS:
            return isSetSourceStateIdentifiers();
         case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_ACTIONS_OWNED:
            return isSetBehaviorActionsOwned();
         case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_CONDITION_OWNED:
            return isSetBehaviorConditionOwned();
         case AadlBaPackage.BEHAVIOR_TRANSITION__BEHAVIOR_TRANSITION_PRIORITY:
            return isSetBehaviorTransitionPriority();
         case AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE_IDENTIFIER:
            return destinationStateIdentifier != null;
         case AadlBaPackage.BEHAVIOR_TRANSITION__TRANSITION_IDENTIFIER:
            return transitionIdentifier != null;
         case AadlBaPackage.BEHAVIOR_TRANSITION__TIMEOUT:
            return isSetTimeout();
      }
      return super.eIsSet(featureID);
   }

} //BehaviorTransitionImpl
