/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchLogicalExpression;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTrigger;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier;
import fr.tpt.aadl.annex.behavior.aadlba.Numeral;
import fr.tpt.aadl.annex.behavior.aadlba.ValueConstant;

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
 * An implementation of the model object '<em><b>Dispatch Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerImpl#getTheDispatchLogicalExpression <em>The Dispatch Logical Expression</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerImpl#getTheBehaviorTime <em>The Behavior Time</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerImpl#getIdentifierOwned <em>Identifier Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerImpl#getDispatchTriggers <em>Dispatch Triggers</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerImpl#getNumeralOwned <em>Numeral Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerImpl#getValueConstantOwned <em>Value Constant Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerImpl#isNot <em>Not</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerImpl#isTimeout <em>Timeout</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerImpl#isOthers <em>Others</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerImpl#isOrMore <em>Or More</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.DispatchTriggerImpl#isOrLess <em>Or Less</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DispatchTriggerImpl extends ElementImpl implements DispatchTrigger
{
   /**
	 * The cached value of the '{@link #getTheDispatchLogicalExpression() <em>The Dispatch Logical Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getTheDispatchLogicalExpression()
	 * @generated
	 * @ordered
	 */
   protected DispatchLogicalExpression theDispatchLogicalExpression;

   /**
	 * The cached value of the '{@link #getTheBehaviorTime() <em>The Behavior Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getTheBehaviorTime()
	 * @generated
	 * @ordered
	 */
   protected BehaviorTime theBehaviorTime;

   /**
	 * This is true if the The Behavior Time containment reference has been set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
   protected boolean theBehaviorTimeESet;

   /**
	 * The cached value of the '{@link #getIdentifierOwned() <em>Identifier Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getIdentifierOwned()
	 * @generated
	 * @ordered
	 */
   protected Identifier identifierOwned;

   /**
	 * This is true if the Identifier Owned containment reference has been set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
   protected boolean identifierOwnedESet;

   /**
	 * The cached value of the '{@link #getDispatchTriggers() <em>Dispatch Triggers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getDispatchTriggers()
	 * @generated
	 * @ordered
	 */
   protected EList<DispatchTrigger> dispatchTriggers;

   /**
	 * The cached value of the '{@link #getNumeralOwned() <em>Numeral Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getNumeralOwned()
	 * @generated
	 * @ordered
	 */
   protected Numeral numeralOwned;

   /**
	 * This is true if the Numeral Owned containment reference has been set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
   protected boolean numeralOwnedESet;

   /**
	 * The cached value of the '{@link #getValueConstantOwned() <em>Value Constant Owned</em>}' containment reference.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getValueConstantOwned()
	 * @generated
	 * @ordered
	 */
   protected ValueConstant valueConstantOwned;

   /**
	 * This is true if the Value Constant Owned containment reference has been set.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
   protected boolean valueConstantOwnedESet;

   /**
	 * The default value of the '{@link #isNot() <em>Not</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isNot()
	 * @generated
	 * @ordered
	 */
   protected static final boolean NOT_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isNot() <em>Not</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isNot()
	 * @generated
	 * @ordered
	 */
   protected boolean not = NOT_EDEFAULT;

   /**
	 * The default value of the '{@link #isTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isTimeout()
	 * @generated
	 * @ordered
	 */
   protected static final boolean TIMEOUT_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isTimeout()
	 * @generated
	 * @ordered
	 */
   protected boolean timeout = TIMEOUT_EDEFAULT;

   /**
	 * The default value of the '{@link #isOthers() <em>Others</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isOthers()
	 * @generated
	 * @ordered
	 */
   protected static final boolean OTHERS_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isOthers() <em>Others</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isOthers()
	 * @generated
	 * @ordered
	 */
   protected boolean others = OTHERS_EDEFAULT;

   /**
	 * The default value of the '{@link #isOrMore() <em>Or More</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isOrMore()
	 * @generated
	 * @ordered
	 */
   protected static final boolean OR_MORE_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isOrMore() <em>Or More</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isOrMore()
	 * @generated
	 * @ordered
	 */
   protected boolean orMore = OR_MORE_EDEFAULT;

   /**
	 * The default value of the '{@link #isOrLess() <em>Or Less</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isOrLess()
	 * @generated
	 * @ordered
	 */
   protected static final boolean OR_LESS_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isOrLess() <em>Or Less</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isOrLess()
	 * @generated
	 * @ordered
	 */
   protected boolean orLess = OR_LESS_EDEFAULT;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected DispatchTriggerImpl()
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
		return AadlBaPackage.Literals.DISPATCH_TRIGGER;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public DispatchLogicalExpression getTheDispatchLogicalExpression()
   {
		return theDispatchLogicalExpression;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicSetTheDispatchLogicalExpression(DispatchLogicalExpression newTheDispatchLogicalExpression, NotificationChain msgs)
   {
		DispatchLogicalExpression oldTheDispatchLogicalExpression = theDispatchLogicalExpression;
		theDispatchLogicalExpression = newTheDispatchLogicalExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_TRIGGER__THE_DISPATCH_LOGICAL_EXPRESSION, oldTheDispatchLogicalExpression, newTheDispatchLogicalExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setTheDispatchLogicalExpression(DispatchLogicalExpression newTheDispatchLogicalExpression)
   {
		if (newTheDispatchLogicalExpression != theDispatchLogicalExpression) {
			NotificationChain msgs = null;
			if (theDispatchLogicalExpression != null)
				msgs = ((InternalEObject)theDispatchLogicalExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.DISPATCH_TRIGGER__THE_DISPATCH_LOGICAL_EXPRESSION, null, msgs);
			if (newTheDispatchLogicalExpression != null)
				msgs = ((InternalEObject)newTheDispatchLogicalExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.DISPATCH_TRIGGER__THE_DISPATCH_LOGICAL_EXPRESSION, null, msgs);
			msgs = basicSetTheDispatchLogicalExpression(newTheDispatchLogicalExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_TRIGGER__THE_DISPATCH_LOGICAL_EXPRESSION, newTheDispatchLogicalExpression, newTheDispatchLogicalExpression));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public BehaviorTime getTheBehaviorTime()
   {
		return theBehaviorTime;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicSetTheBehaviorTime(BehaviorTime newTheBehaviorTime, NotificationChain msgs)
   {
		BehaviorTime oldTheBehaviorTime = theBehaviorTime;
		theBehaviorTime = newTheBehaviorTime;
		boolean oldTheBehaviorTimeESet = theBehaviorTimeESet;
		theBehaviorTimeESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_TRIGGER__THE_BEHAVIOR_TIME, oldTheBehaviorTime, newTheBehaviorTime, !oldTheBehaviorTimeESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setTheBehaviorTime(BehaviorTime newTheBehaviorTime)
   {
		if (newTheBehaviorTime != theBehaviorTime) {
			NotificationChain msgs = null;
			if (theBehaviorTime != null)
				msgs = ((InternalEObject)theBehaviorTime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.DISPATCH_TRIGGER__THE_BEHAVIOR_TIME, null, msgs);
			if (newTheBehaviorTime != null)
				msgs = ((InternalEObject)newTheBehaviorTime).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.DISPATCH_TRIGGER__THE_BEHAVIOR_TIME, null, msgs);
			msgs = basicSetTheBehaviorTime(newTheBehaviorTime, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldTheBehaviorTimeESet = theBehaviorTimeESet;
			theBehaviorTimeESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_TRIGGER__THE_BEHAVIOR_TIME, newTheBehaviorTime, newTheBehaviorTime, !oldTheBehaviorTimeESet));
		}
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicUnsetTheBehaviorTime(NotificationChain msgs)
   {
		BehaviorTime oldTheBehaviorTime = theBehaviorTime;
		theBehaviorTime = null;
		boolean oldTheBehaviorTimeESet = theBehaviorTimeESet;
		theBehaviorTimeESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.DISPATCH_TRIGGER__THE_BEHAVIOR_TIME, oldTheBehaviorTime, null, oldTheBehaviorTimeESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void unsetTheBehaviorTime()
   {
		if (theBehaviorTime != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)theBehaviorTime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.DISPATCH_TRIGGER__THE_BEHAVIOR_TIME, null, msgs);
			msgs = basicUnsetTheBehaviorTime(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldTheBehaviorTimeESet = theBehaviorTimeESet;
			theBehaviorTimeESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.DISPATCH_TRIGGER__THE_BEHAVIOR_TIME, null, null, oldTheBehaviorTimeESet));
		}
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSetTheBehaviorTime()
   {
		return theBehaviorTimeESet;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public Identifier getIdentifierOwned()
   {
		return identifierOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicSetIdentifierOwned(Identifier newIdentifierOwned, NotificationChain msgs)
   {
		Identifier oldIdentifierOwned = identifierOwned;
		identifierOwned = newIdentifierOwned;
		boolean oldIdentifierOwnedESet = identifierOwnedESet;
		identifierOwnedESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_TRIGGER__IDENTIFIER_OWNED, oldIdentifierOwned, newIdentifierOwned, !oldIdentifierOwnedESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setIdentifierOwned(Identifier newIdentifierOwned)
   {
		if (newIdentifierOwned != identifierOwned) {
			NotificationChain msgs = null;
			if (identifierOwned != null)
				msgs = ((InternalEObject)identifierOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.DISPATCH_TRIGGER__IDENTIFIER_OWNED, null, msgs);
			if (newIdentifierOwned != null)
				msgs = ((InternalEObject)newIdentifierOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.DISPATCH_TRIGGER__IDENTIFIER_OWNED, null, msgs);
			msgs = basicSetIdentifierOwned(newIdentifierOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldIdentifierOwnedESet = identifierOwnedESet;
			identifierOwnedESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_TRIGGER__IDENTIFIER_OWNED, newIdentifierOwned, newIdentifierOwned, !oldIdentifierOwnedESet));
		}
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicUnsetIdentifierOwned(NotificationChain msgs)
   {
		Identifier oldIdentifierOwned = identifierOwned;
		identifierOwned = null;
		boolean oldIdentifierOwnedESet = identifierOwnedESet;
		identifierOwnedESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.DISPATCH_TRIGGER__IDENTIFIER_OWNED, oldIdentifierOwned, null, oldIdentifierOwnedESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void unsetIdentifierOwned()
   {
		if (identifierOwned != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)identifierOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.DISPATCH_TRIGGER__IDENTIFIER_OWNED, null, msgs);
			msgs = basicUnsetIdentifierOwned(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldIdentifierOwnedESet = identifierOwnedESet;
			identifierOwnedESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.DISPATCH_TRIGGER__IDENTIFIER_OWNED, null, null, oldIdentifierOwnedESet));
		}
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSetIdentifierOwned()
   {
		return identifierOwnedESet;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EList<DispatchTrigger> getDispatchTriggers()
   {
		if (dispatchTriggers == null) {
			dispatchTriggers = new EObjectContainmentEList.Unsettable<DispatchTrigger>(DispatchTrigger.class, this, AadlBaPackage.DISPATCH_TRIGGER__DISPATCH_TRIGGERS);
		}
		return dispatchTriggers;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void unsetDispatchTriggers()
   {
		if (dispatchTriggers != null) ((InternalEList.Unsettable<?>)dispatchTriggers).unset();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSetDispatchTriggers()
   {
		return dispatchTriggers != null && ((InternalEList.Unsettable<?>)dispatchTriggers).isSet();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public Numeral getNumeralOwned()
   {
		return numeralOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicSetNumeralOwned(Numeral newNumeralOwned, NotificationChain msgs)
   {
		Numeral oldNumeralOwned = numeralOwned;
		numeralOwned = newNumeralOwned;
		boolean oldNumeralOwnedESet = numeralOwnedESet;
		numeralOwnedESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_TRIGGER__NUMERAL_OWNED, oldNumeralOwned, newNumeralOwned, !oldNumeralOwnedESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setNumeralOwned(Numeral newNumeralOwned)
   {
		if (newNumeralOwned != numeralOwned) {
			NotificationChain msgs = null;
			if (numeralOwned != null)
				msgs = ((InternalEObject)numeralOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.DISPATCH_TRIGGER__NUMERAL_OWNED, null, msgs);
			if (newNumeralOwned != null)
				msgs = ((InternalEObject)newNumeralOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.DISPATCH_TRIGGER__NUMERAL_OWNED, null, msgs);
			msgs = basicSetNumeralOwned(newNumeralOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldNumeralOwnedESet = numeralOwnedESet;
			numeralOwnedESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_TRIGGER__NUMERAL_OWNED, newNumeralOwned, newNumeralOwned, !oldNumeralOwnedESet));
		}
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicUnsetNumeralOwned(NotificationChain msgs)
   {
		Numeral oldNumeralOwned = numeralOwned;
		numeralOwned = null;
		boolean oldNumeralOwnedESet = numeralOwnedESet;
		numeralOwnedESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.DISPATCH_TRIGGER__NUMERAL_OWNED, oldNumeralOwned, null, oldNumeralOwnedESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void unsetNumeralOwned()
   {
		if (numeralOwned != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)numeralOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.DISPATCH_TRIGGER__NUMERAL_OWNED, null, msgs);
			msgs = basicUnsetNumeralOwned(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldNumeralOwnedESet = numeralOwnedESet;
			numeralOwnedESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.DISPATCH_TRIGGER__NUMERAL_OWNED, null, null, oldNumeralOwnedESet));
		}
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSetNumeralOwned()
   {
		return numeralOwnedESet;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public ValueConstant getValueConstantOwned()
   {
		return valueConstantOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicSetValueConstantOwned(ValueConstant newValueConstantOwned, NotificationChain msgs)
   {
		ValueConstant oldValueConstantOwned = valueConstantOwned;
		valueConstantOwned = newValueConstantOwned;
		boolean oldValueConstantOwnedESet = valueConstantOwnedESet;
		valueConstantOwnedESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_TRIGGER__VALUE_CONSTANT_OWNED, oldValueConstantOwned, newValueConstantOwned, !oldValueConstantOwnedESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setValueConstantOwned(ValueConstant newValueConstantOwned)
   {
		if (newValueConstantOwned != valueConstantOwned) {
			NotificationChain msgs = null;
			if (valueConstantOwned != null)
				msgs = ((InternalEObject)valueConstantOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.DISPATCH_TRIGGER__VALUE_CONSTANT_OWNED, null, msgs);
			if (newValueConstantOwned != null)
				msgs = ((InternalEObject)newValueConstantOwned).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.DISPATCH_TRIGGER__VALUE_CONSTANT_OWNED, null, msgs);
			msgs = basicSetValueConstantOwned(newValueConstantOwned, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldValueConstantOwnedESet = valueConstantOwnedESet;
			valueConstantOwnedESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_TRIGGER__VALUE_CONSTANT_OWNED, newValueConstantOwned, newValueConstantOwned, !oldValueConstantOwnedESet));
		}
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public NotificationChain basicUnsetValueConstantOwned(NotificationChain msgs)
   {
		ValueConstant oldValueConstantOwned = valueConstantOwned;
		valueConstantOwned = null;
		boolean oldValueConstantOwnedESet = valueConstantOwnedESet;
		valueConstantOwnedESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.DISPATCH_TRIGGER__VALUE_CONSTANT_OWNED, oldValueConstantOwned, null, oldValueConstantOwnedESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void unsetValueConstantOwned()
   {
		if (valueConstantOwned != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)valueConstantOwned).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AadlBaPackage.DISPATCH_TRIGGER__VALUE_CONSTANT_OWNED, null, msgs);
			msgs = basicUnsetValueConstantOwned(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldValueConstantOwnedESet = valueConstantOwnedESet;
			valueConstantOwnedESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, AadlBaPackage.DISPATCH_TRIGGER__VALUE_CONSTANT_OWNED, null, null, oldValueConstantOwnedESet));
		}
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSetValueConstantOwned()
   {
		return valueConstantOwnedESet;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isNot()
   {
		return not;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setNot(boolean newNot)
   {
		boolean oldNot = not;
		not = newNot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_TRIGGER__NOT, oldNot, not));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isTimeout()
   {
		return timeout;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setTimeout(boolean newTimeout)
   {
		boolean oldTimeout = timeout;
		timeout = newTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_TRIGGER__TIMEOUT, oldTimeout, timeout));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isOthers()
   {
		return others;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setOthers(boolean newOthers)
   {
		boolean oldOthers = others;
		others = newOthers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_TRIGGER__OTHERS, oldOthers, others));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isOrMore()
   {
		return orMore;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setOrMore(boolean newOrMore)
   {
		boolean oldOrMore = orMore;
		orMore = newOrMore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_TRIGGER__OR_MORE, oldOrMore, orMore));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isOrLess()
   {
		return orLess;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setOrLess(boolean newOrLess)
   {
		boolean oldOrLess = orLess;
		orLess = newOrLess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.DISPATCH_TRIGGER__OR_LESS, oldOrLess, orLess));
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
			case AadlBaPackage.DISPATCH_TRIGGER__THE_DISPATCH_LOGICAL_EXPRESSION:
				return basicSetTheDispatchLogicalExpression(null, msgs);
			case AadlBaPackage.DISPATCH_TRIGGER__THE_BEHAVIOR_TIME:
				return basicUnsetTheBehaviorTime(msgs);
			case AadlBaPackage.DISPATCH_TRIGGER__IDENTIFIER_OWNED:
				return basicUnsetIdentifierOwned(msgs);
			case AadlBaPackage.DISPATCH_TRIGGER__DISPATCH_TRIGGERS:
				return ((InternalEList<?>)getDispatchTriggers()).basicRemove(otherEnd, msgs);
			case AadlBaPackage.DISPATCH_TRIGGER__NUMERAL_OWNED:
				return basicUnsetNumeralOwned(msgs);
			case AadlBaPackage.DISPATCH_TRIGGER__VALUE_CONSTANT_OWNED:
				return basicUnsetValueConstantOwned(msgs);
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
			case AadlBaPackage.DISPATCH_TRIGGER__THE_DISPATCH_LOGICAL_EXPRESSION:
				return getTheDispatchLogicalExpression();
			case AadlBaPackage.DISPATCH_TRIGGER__THE_BEHAVIOR_TIME:
				return getTheBehaviorTime();
			case AadlBaPackage.DISPATCH_TRIGGER__IDENTIFIER_OWNED:
				return getIdentifierOwned();
			case AadlBaPackage.DISPATCH_TRIGGER__DISPATCH_TRIGGERS:
				return getDispatchTriggers();
			case AadlBaPackage.DISPATCH_TRIGGER__NUMERAL_OWNED:
				return getNumeralOwned();
			case AadlBaPackage.DISPATCH_TRIGGER__VALUE_CONSTANT_OWNED:
				return getValueConstantOwned();
			case AadlBaPackage.DISPATCH_TRIGGER__NOT:
				return isNot();
			case AadlBaPackage.DISPATCH_TRIGGER__TIMEOUT:
				return isTimeout();
			case AadlBaPackage.DISPATCH_TRIGGER__OTHERS:
				return isOthers();
			case AadlBaPackage.DISPATCH_TRIGGER__OR_MORE:
				return isOrMore();
			case AadlBaPackage.DISPATCH_TRIGGER__OR_LESS:
				return isOrLess();
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
		switch (featureID) {
			case AadlBaPackage.DISPATCH_TRIGGER__THE_DISPATCH_LOGICAL_EXPRESSION:
				setTheDispatchLogicalExpression((DispatchLogicalExpression)newValue);
				return;
			case AadlBaPackage.DISPATCH_TRIGGER__THE_BEHAVIOR_TIME:
				setTheBehaviorTime((BehaviorTime)newValue);
				return;
			case AadlBaPackage.DISPATCH_TRIGGER__IDENTIFIER_OWNED:
				setIdentifierOwned((Identifier)newValue);
				return;
			case AadlBaPackage.DISPATCH_TRIGGER__DISPATCH_TRIGGERS:
				getDispatchTriggers().clear();
				getDispatchTriggers().addAll((Collection<? extends DispatchTrigger>)newValue);
				return;
			case AadlBaPackage.DISPATCH_TRIGGER__NUMERAL_OWNED:
				setNumeralOwned((Numeral)newValue);
				return;
			case AadlBaPackage.DISPATCH_TRIGGER__VALUE_CONSTANT_OWNED:
				setValueConstantOwned((ValueConstant)newValue);
				return;
			case AadlBaPackage.DISPATCH_TRIGGER__NOT:
				setNot((Boolean)newValue);
				return;
			case AadlBaPackage.DISPATCH_TRIGGER__TIMEOUT:
				setTimeout((Boolean)newValue);
				return;
			case AadlBaPackage.DISPATCH_TRIGGER__OTHERS:
				setOthers((Boolean)newValue);
				return;
			case AadlBaPackage.DISPATCH_TRIGGER__OR_MORE:
				setOrMore((Boolean)newValue);
				return;
			case AadlBaPackage.DISPATCH_TRIGGER__OR_LESS:
				setOrLess((Boolean)newValue);
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
			case AadlBaPackage.DISPATCH_TRIGGER__THE_DISPATCH_LOGICAL_EXPRESSION:
				setTheDispatchLogicalExpression((DispatchLogicalExpression)null);
				return;
			case AadlBaPackage.DISPATCH_TRIGGER__THE_BEHAVIOR_TIME:
				unsetTheBehaviorTime();
				return;
			case AadlBaPackage.DISPATCH_TRIGGER__IDENTIFIER_OWNED:
				unsetIdentifierOwned();
				return;
			case AadlBaPackage.DISPATCH_TRIGGER__DISPATCH_TRIGGERS:
				unsetDispatchTriggers();
				return;
			case AadlBaPackage.DISPATCH_TRIGGER__NUMERAL_OWNED:
				unsetNumeralOwned();
				return;
			case AadlBaPackage.DISPATCH_TRIGGER__VALUE_CONSTANT_OWNED:
				unsetValueConstantOwned();
				return;
			case AadlBaPackage.DISPATCH_TRIGGER__NOT:
				setNot(NOT_EDEFAULT);
				return;
			case AadlBaPackage.DISPATCH_TRIGGER__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case AadlBaPackage.DISPATCH_TRIGGER__OTHERS:
				setOthers(OTHERS_EDEFAULT);
				return;
			case AadlBaPackage.DISPATCH_TRIGGER__OR_MORE:
				setOrMore(OR_MORE_EDEFAULT);
				return;
			case AadlBaPackage.DISPATCH_TRIGGER__OR_LESS:
				setOrLess(OR_LESS_EDEFAULT);
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
			case AadlBaPackage.DISPATCH_TRIGGER__THE_DISPATCH_LOGICAL_EXPRESSION:
				return theDispatchLogicalExpression != null;
			case AadlBaPackage.DISPATCH_TRIGGER__THE_BEHAVIOR_TIME:
				return isSetTheBehaviorTime();
			case AadlBaPackage.DISPATCH_TRIGGER__IDENTIFIER_OWNED:
				return isSetIdentifierOwned();
			case AadlBaPackage.DISPATCH_TRIGGER__DISPATCH_TRIGGERS:
				return isSetDispatchTriggers();
			case AadlBaPackage.DISPATCH_TRIGGER__NUMERAL_OWNED:
				return isSetNumeralOwned();
			case AadlBaPackage.DISPATCH_TRIGGER__VALUE_CONSTANT_OWNED:
				return isSetValueConstantOwned();
			case AadlBaPackage.DISPATCH_TRIGGER__NOT:
				return not != NOT_EDEFAULT;
			case AadlBaPackage.DISPATCH_TRIGGER__TIMEOUT:
				return timeout != TIMEOUT_EDEFAULT;
			case AadlBaPackage.DISPATCH_TRIGGER__OTHERS:
				return others != OTHERS_EDEFAULT;
			case AadlBaPackage.DISPATCH_TRIGGER__OR_MORE:
				return orMore != OR_MORE_EDEFAULT;
			case AadlBaPackage.DISPATCH_TRIGGER__OR_LESS:
				return orLess != OR_LESS_EDEFAULT;
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
		result.append(" (Not: ");
		result.append(not);
		result.append(", Timeout: ");
		result.append(timeout);
		result.append(", Others: ");
		result.append(others);
		result.append(", OrMore: ");
		result.append(orMore);
		result.append(", OrLess: ");
		result.append(orLess);
		result.append(')');
		return result.toString();
	}

} //DispatchTriggerImpl
