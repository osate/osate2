/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BasicAction;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime;
import fr.tpt.aadl.annex.behavior.aadlba.CondStatement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionImpl#getBasicActionOwned <em>Basic Action Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionImpl#getBehaviorActionsOwned <em>Behavior Actions Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionImpl#getCondStatementOwned <em>Cond Statement Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionImpl#isBasicAction <em>Basic Action</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionImpl#isIf <em>If</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionImpl#isFor <em>For</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionImpl#isWhile <em>While</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionImpl#isDoUntil <em>Do Until</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionImpl#getTimeout <em>Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BehaviorActionImpl extends ElementImpl implements BehaviorAction
{
   /**
	 * The cached value of the '{@link #getBasicActionOwned() <em>Basic Action Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getBasicActionOwned()
	 * @generated
	 * @ordered
	 */
   protected BasicAction basicActionOwned;

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
	 * The cached value of the '{@link #getCondStatementOwned() <em>Cond Statement Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getCondStatementOwned()
	 * @generated
	 * @ordered
	 */
   protected CondStatement condStatementOwned;

   /**
	 * The default value of the '{@link #isBasicAction() <em>Basic Action</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isBasicAction()
	 * @generated
	 * @ordered
	 */
   protected static final boolean BASIC_ACTION_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isBasicAction() <em>Basic Action</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isBasicAction()
	 * @generated
	 * @ordered
	 */
   protected boolean basicAction = BASIC_ACTION_EDEFAULT;

   /**
	 * The default value of the '{@link #isIf() <em>If</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isIf()
	 * @generated
	 * @ordered
	 */
   protected static final boolean IF_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isIf() <em>If</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isIf()
	 * @generated
	 * @ordered
	 */
   protected boolean if_ = IF_EDEFAULT;

   /**
	 * The default value of the '{@link #isFor() <em>For</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isFor()
	 * @generated
	 * @ordered
	 */
   protected static final boolean FOR_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isFor() <em>For</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isFor()
	 * @generated
	 * @ordered
	 */
   protected boolean for_ = FOR_EDEFAULT;

   /**
	 * The default value of the '{@link #isWhile() <em>While</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isWhile()
	 * @generated
	 * @ordered
	 */
   protected static final boolean WHILE_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isWhile() <em>While</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isWhile()
	 * @generated
	 * @ordered
	 */
   protected boolean while_ = WHILE_EDEFAULT;

   /**
	 * The default value of the '{@link #isDoUntil() <em>Do Until</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isDoUntil()
	 * @generated
	 * @ordered
	 */
   protected static final boolean DO_UNTIL_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isDoUntil() <em>Do Until</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isDoUntil()
	 * @generated
	 * @ordered
	 */
   protected boolean doUntil = DO_UNTIL_EDEFAULT;

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
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected BehaviorActionImpl()
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
		return AadlBaPackage.Literals.BEHAVIOR_ACTION;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public BasicAction getBasicActionOwned()
   {
		return basicActionOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicSetBasicActionOwned(BasicAction newBasicActionOwned, NotificationChain msgs)
   {
		BasicAction oldBasicActionOwned = basicActionOwned;
		basicActionOwned = newBasicActionOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ACTION__BASIC_ACTION_OWNED, oldBasicActionOwned, newBasicActionOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setBasicActionOwned(BasicAction newBasicActionOwned)
   {
		if (newBasicActionOwned != basicActionOwned) {
			NotificationChain msgs = null;
			if (basicActionOwned != null)
				msgs = ((InternalEObject)basicActionOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_ACTION__BASIC_ACTION_OWNED, null, msgs);
			if (newBasicActionOwned != null)
				msgs = ((InternalEObject)newBasicActionOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_ACTION__BASIC_ACTION_OWNED, null, msgs);
			msgs = basicSetBasicActionOwned(newBasicActionOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ACTION__BASIC_ACTION_OWNED, newBasicActionOwned, newBasicActionOwned));
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
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ACTION__BEHAVIOR_ACTIONS_OWNED, oldBehaviorActionsOwned, newBehaviorActionsOwned);
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
		if (newBehaviorActionsOwned != behaviorActionsOwned) {
			NotificationChain msgs = null;
			if (behaviorActionsOwned != null)
				msgs = ((InternalEObject)behaviorActionsOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_ACTION__BEHAVIOR_ACTIONS_OWNED, null, msgs);
			if (newBehaviorActionsOwned != null)
				msgs = ((InternalEObject)newBehaviorActionsOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_ACTION__BEHAVIOR_ACTIONS_OWNED, null, msgs);
			msgs = basicSetBehaviorActionsOwned(newBehaviorActionsOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ACTION__BEHAVIOR_ACTIONS_OWNED, newBehaviorActionsOwned, newBehaviorActionsOwned));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public CondStatement getCondStatementOwned()
   {
		return condStatementOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicSetCondStatementOwned(CondStatement newCondStatementOwned, NotificationChain msgs)
   {
		CondStatement oldCondStatementOwned = condStatementOwned;
		condStatementOwned = newCondStatementOwned;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ACTION__COND_STATEMENT_OWNED, oldCondStatementOwned, newCondStatementOwned);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setCondStatementOwned(CondStatement newCondStatementOwned)
   {
		if (newCondStatementOwned != condStatementOwned) {
			NotificationChain msgs = null;
			if (condStatementOwned != null)
				msgs = ((InternalEObject)condStatementOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_ACTION__COND_STATEMENT_OWNED, null, msgs);
			if (newCondStatementOwned != null)
				msgs = ((InternalEObject)newCondStatementOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_ACTION__COND_STATEMENT_OWNED, null, msgs);
			msgs = basicSetCondStatementOwned(newCondStatementOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ACTION__COND_STATEMENT_OWNED, newCondStatementOwned, newCondStatementOwned));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isBasicAction()
   {
		return basicAction;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setBasicAction(boolean newBasicAction)
   {
		boolean oldBasicAction = basicAction;
		basicAction = newBasicAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ACTION__BASIC_ACTION, oldBasicAction, basicAction));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isIf()
   {
		return if_;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setIf(boolean newIf)
   {
		boolean oldIf = if_;
		if_ = newIf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ACTION__IF, oldIf, if_));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isFor()
   {
		return for_;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setFor(boolean newFor)
   {
		boolean oldFor = for_;
		for_ = newFor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ACTION__FOR, oldFor, for_));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isWhile()
   {
		return while_;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setWhile(boolean newWhile)
   {
		boolean oldWhile = while_;
		while_ = newWhile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ACTION__WHILE, oldWhile, while_));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isDoUntil()
   {
		return doUntil;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setDoUntil(boolean newDoUntil)
   {
		boolean oldDoUntil = doUntil;
		doUntil = newDoUntil;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ACTION__DO_UNTIL, oldDoUntil, doUntil));
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
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ACTION__TIMEOUT, oldTimeout, newTimeout);
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
		if (newTimeout != timeout) {
			NotificationChain msgs = null;
			if (timeout != null)
				msgs = ((InternalEObject)timeout).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_ACTION__TIMEOUT, null, msgs);
			if (newTimeout != null)
				msgs = ((InternalEObject)newTimeout).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.BEHAVIOR_ACTION__TIMEOUT, null, msgs);
			msgs = basicSetTimeout(newTimeout, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ACTION__TIMEOUT, newTimeout, newTimeout));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
   {
		switch (featureID) {
			case AadlBaPackage.BEHAVIOR_ACTION__BASIC_ACTION_OWNED:
				return basicSetBasicActionOwned(null, msgs);
			case AadlBaPackage.BEHAVIOR_ACTION__BEHAVIOR_ACTIONS_OWNED:
				return basicSetBehaviorActionsOwned(null, msgs);
			case AadlBaPackage.BEHAVIOR_ACTION__COND_STATEMENT_OWNED:
				return basicSetCondStatementOwned(null, msgs);
			case AadlBaPackage.BEHAVIOR_ACTION__TIMEOUT:
				return basicSetTimeout(null, msgs);
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
		switch (featureID) {
			case AadlBaPackage.BEHAVIOR_ACTION__BASIC_ACTION_OWNED:
				return getBasicActionOwned();
			case AadlBaPackage.BEHAVIOR_ACTION__BEHAVIOR_ACTIONS_OWNED:
				return getBehaviorActionsOwned();
			case AadlBaPackage.BEHAVIOR_ACTION__COND_STATEMENT_OWNED:
				return getCondStatementOwned();
			case AadlBaPackage.BEHAVIOR_ACTION__BASIC_ACTION:
				return isBasicAction();
			case AadlBaPackage.BEHAVIOR_ACTION__IF:
				return isIf();
			case AadlBaPackage.BEHAVIOR_ACTION__FOR:
				return isFor();
			case AadlBaPackage.BEHAVIOR_ACTION__WHILE:
				return isWhile();
			case AadlBaPackage.BEHAVIOR_ACTION__DO_UNTIL:
				return isDoUntil();
			case AadlBaPackage.BEHAVIOR_ACTION__TIMEOUT:
				return getTimeout();
		}
		return super.eGet(featureID, resolve, coreType);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public void eSet(int featureID, Object newValue)
   {
		switch (featureID) {
			case AadlBaPackage.BEHAVIOR_ACTION__BASIC_ACTION_OWNED:
				setBasicActionOwned((BasicAction)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_ACTION__BEHAVIOR_ACTIONS_OWNED:
				setBehaviorActionsOwned((BehaviorActions)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_ACTION__COND_STATEMENT_OWNED:
				setCondStatementOwned((CondStatement)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_ACTION__BASIC_ACTION:
				setBasicAction((Boolean)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_ACTION__IF:
				setIf((Boolean)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_ACTION__FOR:
				setFor((Boolean)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_ACTION__WHILE:
				setWhile((Boolean)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_ACTION__DO_UNTIL:
				setDoUntil((Boolean)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_ACTION__TIMEOUT:
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
		switch (featureID) {
			case AadlBaPackage.BEHAVIOR_ACTION__BASIC_ACTION_OWNED:
				setBasicActionOwned((BasicAction)null);
				return;
			case AadlBaPackage.BEHAVIOR_ACTION__BEHAVIOR_ACTIONS_OWNED:
				setBehaviorActionsOwned((BehaviorActions)null);
				return;
			case AadlBaPackage.BEHAVIOR_ACTION__COND_STATEMENT_OWNED:
				setCondStatementOwned((CondStatement)null);
				return;
			case AadlBaPackage.BEHAVIOR_ACTION__BASIC_ACTION:
				setBasicAction(BASIC_ACTION_EDEFAULT);
				return;
			case AadlBaPackage.BEHAVIOR_ACTION__IF:
				setIf(IF_EDEFAULT);
				return;
			case AadlBaPackage.BEHAVIOR_ACTION__FOR:
				setFor(FOR_EDEFAULT);
				return;
			case AadlBaPackage.BEHAVIOR_ACTION__WHILE:
				setWhile(WHILE_EDEFAULT);
				return;
			case AadlBaPackage.BEHAVIOR_ACTION__DO_UNTIL:
				setDoUntil(DO_UNTIL_EDEFAULT);
				return;
			case AadlBaPackage.BEHAVIOR_ACTION__TIMEOUT:
				setTimeout((BehaviorTime)null);
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
		switch (featureID) {
			case AadlBaPackage.BEHAVIOR_ACTION__BASIC_ACTION_OWNED:
				return basicActionOwned != null;
			case AadlBaPackage.BEHAVIOR_ACTION__BEHAVIOR_ACTIONS_OWNED:
				return behaviorActionsOwned != null;
			case AadlBaPackage.BEHAVIOR_ACTION__COND_STATEMENT_OWNED:
				return condStatementOwned != null;
			case AadlBaPackage.BEHAVIOR_ACTION__BASIC_ACTION:
				return basicAction != BASIC_ACTION_EDEFAULT;
			case AadlBaPackage.BEHAVIOR_ACTION__IF:
				return if_ != IF_EDEFAULT;
			case AadlBaPackage.BEHAVIOR_ACTION__FOR:
				return for_ != FOR_EDEFAULT;
			case AadlBaPackage.BEHAVIOR_ACTION__WHILE:
				return while_ != WHILE_EDEFAULT;
			case AadlBaPackage.BEHAVIOR_ACTION__DO_UNTIL:
				return doUntil != DO_UNTIL_EDEFAULT;
			case AadlBaPackage.BEHAVIOR_ACTION__TIMEOUT:
				return timeout != null;
		}
		return super.eIsSet(featureID);
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   @Override
   public String toString()
   {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (BasicAction: ");
		result.append(basicAction);
		result.append(", If: ");
		result.append(if_);
		result.append(", For: ");
		result.append(for_);
		result.append(", While: ");
		result.append(while_);
		result.append(", DoUntil: ");
		result.append(doUntil);
		result.append(')');
		return result.toString();
	}

} //BehaviorActionImpl
