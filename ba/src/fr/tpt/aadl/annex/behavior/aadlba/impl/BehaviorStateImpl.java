/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 1.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * http://www.eclipse.org/org/documents/epl-v10.php
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.aadl2.Mode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorStateImpl#isInitial <em>Initial</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorStateImpl#isComplete <em>Complete</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorStateImpl#isFinal <em>Final</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorStateImpl#getBindedMode <em>Binded Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BehaviorStateImpl extends BehaviorNamedElementImpl implements BehaviorState
{
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
	 * The cached value of the '{@link #getBindedMode() <em>Binded Mode</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getBindedMode()
	 * @generated
	 * @ordered
	 */
  protected Mode bindedMode;

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
  public Mode getBindedMode()
  {
		if (bindedMode != null && ((EObject)bindedMode).eIsProxy()) {
			InternalEObject oldBindedMode = (InternalEObject)bindedMode;
			bindedMode = (Mode)eResolveProxy(oldBindedMode);
			if (bindedMode != oldBindedMode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_STATE__BINDED_MODE, oldBindedMode, bindedMode));
			}
		}
		return bindedMode;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Mode basicGetBindedMode()
  {
		return bindedMode;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setBindedMode(Mode newBindedMode)
  {
		Mode oldBindedMode = bindedMode;
		bindedMode = newBindedMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_STATE__BINDED_MODE, oldBindedMode, bindedMode));
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
			case AadlBaPackage.BEHAVIOR_STATE__INITIAL:
				return isInitial();
			case AadlBaPackage.BEHAVIOR_STATE__COMPLETE:
				return isComplete();
			case AadlBaPackage.BEHAVIOR_STATE__FINAL:
				return isFinal();
			case AadlBaPackage.BEHAVIOR_STATE__BINDED_MODE:
				if (resolve) return getBindedMode();
				return basicGetBindedMode();
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
			case AadlBaPackage.BEHAVIOR_STATE__INITIAL:
				setInitial((Boolean)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_STATE__COMPLETE:
				setComplete((Boolean)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_STATE__FINAL:
				setFinal((Boolean)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_STATE__BINDED_MODE:
				setBindedMode((Mode)newValue);
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
			case AadlBaPackage.BEHAVIOR_STATE__INITIAL:
				setInitial(INITIAL_EDEFAULT);
				return;
			case AadlBaPackage.BEHAVIOR_STATE__COMPLETE:
				setComplete(COMPLETE_EDEFAULT);
				return;
			case AadlBaPackage.BEHAVIOR_STATE__FINAL:
				setFinal(FINAL_EDEFAULT);
				return;
			case AadlBaPackage.BEHAVIOR_STATE__BINDED_MODE:
				setBindedMode((Mode)null);
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
			case AadlBaPackage.BEHAVIOR_STATE__INITIAL:
				return initial != INITIAL_EDEFAULT;
			case AadlBaPackage.BEHAVIOR_STATE__COMPLETE:
				return complete != COMPLETE_EDEFAULT;
			case AadlBaPackage.BEHAVIOR_STATE__FINAL:
				return final_ != FINAL_EDEFAULT;
			case AadlBaPackage.BEHAVIOR_STATE__BINDED_MODE:
				return bindedMode != null;
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
		result.append(" (initial: ");
		result.append(initial);
		result.append(", complete: ");
		result.append(complete);
		result.append(", final: ");
		result.append(final_);
		result.append(')');
		return result.toString();
	}

} //BehaviorStateImpl
