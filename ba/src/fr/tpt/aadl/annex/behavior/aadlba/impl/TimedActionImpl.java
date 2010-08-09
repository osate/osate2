/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime;
import fr.tpt.aadl.annex.behavior.aadlba.TimedAction;

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
 * An implementation of the model object '<em><b>Timed Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TimedActionImpl#getBehaviorTimesOwned <em>Behavior Times Owned</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.TimedActionImpl#isComputation <em>Computation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimedActionImpl extends BasicActionImpl implements TimedAction
{
   /**
	 * The cached value of the '{@link #getBehaviorTimesOwned() <em>Behavior Times Owned</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getBehaviorTimesOwned()
	 * @generated
	 * @ordered
	 */
   protected EList<BehaviorTime> behaviorTimesOwned;

   /**
	 * The default value of the '{@link #isComputation() <em>Computation</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isComputation()
	 * @generated
	 * @ordered
	 */
   protected static final boolean COMPUTATION_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isComputation() <em>Computation</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isComputation()
	 * @generated
	 * @ordered
	 */
   protected boolean computation = COMPUTATION_EDEFAULT;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected TimedActionImpl()
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
		return AadlBaPackage.Literals.TIMED_ACTION;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EList<BehaviorTime> getBehaviorTimesOwned()
   {
		if (behaviorTimesOwned == null) {
			behaviorTimesOwned = new EObjectContainmentEList.Unsettable<BehaviorTime>(BehaviorTime.class, this, AadlBaPackage.TIMED_ACTION__BEHAVIOR_TIMES_OWNED);
		}
		return behaviorTimesOwned;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void unsetBehaviorTimesOwned()
   {
		if (behaviorTimesOwned != null) ((InternalEList.Unsettable<?>)behaviorTimesOwned).unset();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isSetBehaviorTimesOwned()
   {
		return behaviorTimesOwned != null && ((InternalEList.Unsettable<?>)behaviorTimesOwned).isSet();
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isComputation()
   {
		return computation;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setComputation(boolean newComputation)
   {
		boolean oldComputation = computation;
		computation = newComputation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.TIMED_ACTION__COMPUTATION, oldComputation, computation));
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
			case AadlBaPackage.TIMED_ACTION__BEHAVIOR_TIMES_OWNED:
				return ((InternalEList<?>)getBehaviorTimesOwned()).basicRemove(otherEnd, msgs);
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
			case AadlBaPackage.TIMED_ACTION__BEHAVIOR_TIMES_OWNED:
				return getBehaviorTimesOwned();
			case AadlBaPackage.TIMED_ACTION__COMPUTATION:
				return isComputation();
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
			case AadlBaPackage.TIMED_ACTION__BEHAVIOR_TIMES_OWNED:
				getBehaviorTimesOwned().clear();
				getBehaviorTimesOwned().addAll((Collection<? extends BehaviorTime>)newValue);
				return;
			case AadlBaPackage.TIMED_ACTION__COMPUTATION:
				setComputation((Boolean)newValue);
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
			case AadlBaPackage.TIMED_ACTION__BEHAVIOR_TIMES_OWNED:
				unsetBehaviorTimesOwned();
				return;
			case AadlBaPackage.TIMED_ACTION__COMPUTATION:
				setComputation(COMPUTATION_EDEFAULT);
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
			case AadlBaPackage.TIMED_ACTION__BEHAVIOR_TIMES_OWNED:
				return isSetBehaviorTimesOwned();
			case AadlBaPackage.TIMED_ACTION__COMPUTATION:
				return computation != COMPUTATION_EDEFAULT;
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
		result.append(" (Computation: ");
		result.append(computation);
		result.append(')');
		return result.toString();
	}

} //TimedActionImpl
