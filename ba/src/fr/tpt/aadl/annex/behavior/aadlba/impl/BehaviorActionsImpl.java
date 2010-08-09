/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions;

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
 * An implementation of the model object '<em><b>Behavior Actions</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionsImpl#getBehaviorAction <em>Behavior Action</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionsImpl#isSequence <em>Sequence</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorActionsImpl#isSet <em>Set</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BehaviorActionsImpl extends ElementImpl implements BehaviorActions
{
   /**
	 * The cached value of the '{@link #getBehaviorAction() <em>Behavior Action</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getBehaviorAction()
	 * @generated
	 * @ordered
	 */
   protected EList<BehaviorAction> behaviorAction;

   /**
	 * The default value of the '{@link #isSequence() <em>Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isSequence()
	 * @generated
	 * @ordered
	 */
   protected static final boolean SEQUENCE_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isSequence() <em>Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isSequence()
	 * @generated
	 * @ordered
	 */
   protected boolean sequence = SEQUENCE_EDEFAULT;

   /**
	 * The default value of the '{@link #isSet() <em>Set</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isSet()
	 * @generated
	 * @ordered
	 */
   protected static final boolean SET_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isSet() <em>Set</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isSet()
	 * @generated
	 * @ordered
	 */
   protected boolean set = SET_EDEFAULT;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected BehaviorActionsImpl()
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
		return AadlBaPackage.Literals.BEHAVIOR_ACTIONS;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EList<BehaviorAction> getBehaviorAction()
   {
		if (behaviorAction == null) {
			behaviorAction = new EObjectContainmentEList.Unsettable<BehaviorAction>(BehaviorAction.class, this, AadlBaPackage.BEHAVIOR_ACTIONS__BEHAVIOR_ACTION);
		}
		return behaviorAction;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void unsetBehaviorAction()
   {
		if (behaviorAction != null) ((InternalEList.Unsettable<?>)behaviorAction).unset();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSetBehaviorAction()
   {
		return behaviorAction != null && ((InternalEList.Unsettable<?>)behaviorAction).isSet();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSequence()
   {
		return sequence;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setSequence(boolean newSequence)
   {
		boolean oldSequence = sequence;
		sequence = newSequence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ACTIONS__SEQUENCE, oldSequence, sequence));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSet()
   {
		return set;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setSet(boolean newSet)
   {
		boolean oldSet = set;
		set = newSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_ACTIONS__SET, oldSet, set));
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
			case AadlBaPackage.BEHAVIOR_ACTIONS__BEHAVIOR_ACTION:
				return ((InternalEList<?>)getBehaviorAction()).basicRemove(otherEnd, msgs);
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
			case AadlBaPackage.BEHAVIOR_ACTIONS__BEHAVIOR_ACTION:
				return getBehaviorAction();
			case AadlBaPackage.BEHAVIOR_ACTIONS__SEQUENCE:
				return isSequence();
			case AadlBaPackage.BEHAVIOR_ACTIONS__SET:
				return isSet();
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
			case AadlBaPackage.BEHAVIOR_ACTIONS__BEHAVIOR_ACTION:
				getBehaviorAction().clear();
				getBehaviorAction().addAll((Collection<? extends BehaviorAction>)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_ACTIONS__SEQUENCE:
				setSequence((Boolean)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_ACTIONS__SET:
				setSet((Boolean)newValue);
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
			case AadlBaPackage.BEHAVIOR_ACTIONS__BEHAVIOR_ACTION:
				unsetBehaviorAction();
				return;
			case AadlBaPackage.BEHAVIOR_ACTIONS__SEQUENCE:
				setSequence(SEQUENCE_EDEFAULT);
				return;
			case AadlBaPackage.BEHAVIOR_ACTIONS__SET:
				setSet(SET_EDEFAULT);
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
			case AadlBaPackage.BEHAVIOR_ACTIONS__BEHAVIOR_ACTION:
				return isSetBehaviorAction();
			case AadlBaPackage.BEHAVIOR_ACTIONS__SEQUENCE:
				return sequence != SEQUENCE_EDEFAULT;
			case AadlBaPackage.BEHAVIOR_ACTIONS__SET:
				return set != SET_EDEFAULT;
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
		result.append(" (Sequence: ");
		result.append(sequence);
		result.append(", Set: ");
		result.append(set);
		result.append(')');
		return result.toString();
	}

} //BehaviorActionsImpl
