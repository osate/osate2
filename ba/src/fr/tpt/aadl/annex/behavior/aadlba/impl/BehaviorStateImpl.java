/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier;

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
 * An implementation of the model object '<em><b>Behavior State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorStateImpl#getBehaviorStateIdentifiers <em>Behavior State Identifiers</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorStateImpl#isInitial <em>Initial</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorStateImpl#isComplete <em>Complete</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorStateImpl#isFinal <em>Final</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BehaviorStateImpl extends ElementImpl implements BehaviorState
{
   /**
	 * The cached value of the '{@link #getBehaviorStateIdentifiers() <em>Behavior State Identifiers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #getBehaviorStateIdentifiers()
	 * @generated
	 * @ordered
	 */
   protected EList<Identifier> behaviorStateIdentifiers;

   /**
	 * The default value of the '{@link #isInitial() <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isInitial()
	 * @generated
	 * @ordered
	 */
   protected static final boolean INITIAL_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isInitial() <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isInitial()
	 * @generated
	 * @ordered
	 */
   protected boolean initial = INITIAL_EDEFAULT;

   /**
	 * The default value of the '{@link #isComplete() <em>Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isComplete()
	 * @generated
	 * @ordered
	 */
   protected static final boolean COMPLETE_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isComplete() <em>Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isComplete()
	 * @generated
	 * @ordered
	 */
   protected boolean complete = COMPLETE_EDEFAULT;

   /**
	 * The default value of the '{@link #isFinal() <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isFinal()
	 * @generated
	 * @ordered
	 */
   protected static final boolean FINAL_EDEFAULT = false;

   /**
	 * The cached value of the '{@link #isFinal() <em>Final</em>}' attribute.
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @see #isFinal()
	 * @generated
	 * @ordered
	 */
   protected boolean final_ = FINAL_EDEFAULT;

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   protected BehaviorStateImpl()
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
		return AadlBaPackage.Literals.BEHAVIOR_STATE;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public EList<Identifier> getBehaviorStateIdentifiers()
   {
		if (behaviorStateIdentifiers == null) {
			behaviorStateIdentifiers = new EObjectContainmentEList<Identifier>(Identifier.class, this, AadlBaPackage.BEHAVIOR_STATE__BEHAVIOR_STATE_IDENTIFIERS);
		}
		return behaviorStateIdentifiers;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isInitial()
   {
		return initial;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setInitial(boolean newInitial)
   {
		boolean oldInitial = initial;
		initial = newInitial;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_STATE__INITIAL, oldInitial, initial));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isComplete()
   {
		return complete;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setComplete(boolean newComplete)
   {
		boolean oldComplete = complete;
		complete = newComplete;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_STATE__COMPLETE, oldComplete, complete));
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public boolean isFinal()
   {
		return final_;
	}

   /**
	 * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
	 * @generated
	 */
   public void setFinal(boolean newFinal)
   {
		boolean oldFinal = final_;
		final_ = newFinal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_STATE__FINAL, oldFinal, final_));
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
			case AadlBaPackage.BEHAVIOR_STATE__BEHAVIOR_STATE_IDENTIFIERS:
				return ((InternalEList<?>)getBehaviorStateIdentifiers()).basicRemove(otherEnd, msgs);
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
			case AadlBaPackage.BEHAVIOR_STATE__BEHAVIOR_STATE_IDENTIFIERS:
				return getBehaviorStateIdentifiers();
			case AadlBaPackage.BEHAVIOR_STATE__INITIAL:
				return isInitial();
			case AadlBaPackage.BEHAVIOR_STATE__COMPLETE:
				return isComplete();
			case AadlBaPackage.BEHAVIOR_STATE__FINAL:
				return isFinal();
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
			case AadlBaPackage.BEHAVIOR_STATE__BEHAVIOR_STATE_IDENTIFIERS:
				getBehaviorStateIdentifiers().clear();
				getBehaviorStateIdentifiers().addAll((Collection<? extends Identifier>)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_STATE__INITIAL:
				setInitial((Boolean)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_STATE__COMPLETE:
				setComplete((Boolean)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_STATE__FINAL:
				setFinal((Boolean)newValue);
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
			case AadlBaPackage.BEHAVIOR_STATE__BEHAVIOR_STATE_IDENTIFIERS:
				getBehaviorStateIdentifiers().clear();
				return;
			case AadlBaPackage.BEHAVIOR_STATE__INITIAL:
				setInitial(INITIAL_EDEFAULT);
				return;
			case AadlBaPackage.BEHAVIOR_STATE__COMPLETE:
				setComplete(COMPLETE_EDEFAULT);
				return;
			case AadlBaPackage.BEHAVIOR_STATE__FINAL:
				setFinal(FINAL_EDEFAULT);
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
			case AadlBaPackage.BEHAVIOR_STATE__BEHAVIOR_STATE_IDENTIFIERS:
				return behaviorStateIdentifiers != null && !behaviorStateIdentifiers.isEmpty();
			case AadlBaPackage.BEHAVIOR_STATE__INITIAL:
				return initial != INITIAL_EDEFAULT;
			case AadlBaPackage.BEHAVIOR_STATE__COMPLETE:
				return complete != COMPLETE_EDEFAULT;
			case AadlBaPackage.BEHAVIOR_STATE__FINAL:
				return final_ != FINAL_EDEFAULT;
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
		result.append(" (Initial: ");
		result.append(initial);
		result.append(", Complete: ");
		result.append(complete);
		result.append(", Final: ");
		result.append(final_);
		result.append(')');
		return result.toString();
	}

} //BehaviorStateImpl
