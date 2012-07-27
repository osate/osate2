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
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorCondition;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition;
import fr.tpt.aadl.annex.behavior.utils.AadlBaLocationReference ;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl#getSourceState <em>Source State</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl#getDestinationState <em>Destination State</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl#getActionBlock <em>Action Block</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.BehaviorTransitionImpl#getPriority <em>Priority</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BehaviorTransitionImpl extends BehaviorNamedElementImpl implements BehaviorTransition
{
  /**
	 * The cached value of the '{@link #getSourceState() <em>Source State</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSourceState()
	 * @generated
	 * @ordered
	 */
  protected BehaviorState sourceState;

  /**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
  protected BehaviorCondition condition;

  /**
	 * The cached value of the '{@link #getDestinationState() <em>Destination State</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDestinationState()
	 * @generated
	 * @ordered
	 */
  protected BehaviorState destinationState;

  /**
	 * The cached value of the '{@link #getActionBlock() <em>Action Block</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getActionBlock()
	 * @generated
	 * @ordered
	 */
  protected BehaviorActionBlock actionBlock;

  /**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
  protected static final long PRIORITY_EDEFAULT = -1L;

  /**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
  protected long priority = PRIORITY_EDEFAULT;

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
  public BehaviorState getSourceState()
  {
		if (sourceState != null && ((EObject)sourceState).eIsProxy()) {
			InternalEObject oldSourceState = (InternalEObject)sourceState;
			sourceState = (BehaviorState)eResolveProxy(oldSourceState);
			if (sourceState != oldSourceState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE, oldSourceState, sourceState));
			}
		}
		return sourceState;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public BehaviorState basicGetSourceState()
  {
		return sourceState;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSourceState(BehaviorState newSourceState)
  {
		BehaviorState oldSourceState = sourceState;
		sourceState = newSourceState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE, oldSourceState, sourceState));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public BehaviorCondition getCondition()
  {
		if (condition != null && ((EObject)condition).eIsProxy()) {
			InternalEObject oldCondition = (InternalEObject)condition;
			condition = (BehaviorCondition)eResolveProxy(oldCondition);
			if (condition != oldCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_TRANSITION__CONDITION, oldCondition, condition));
			}
		}
		return condition;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public BehaviorCondition basicGetCondition()
  {
		return condition;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCondition(BehaviorCondition newCondition)
  {
		BehaviorCondition oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__CONDITION, oldCondition, condition));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public BehaviorState getDestinationState()
  {
		if (destinationState != null && ((EObject)destinationState).eIsProxy()) {
			InternalEObject oldDestinationState = (InternalEObject)destinationState;
			destinationState = (BehaviorState)eResolveProxy(oldDestinationState);
			if (destinationState != oldDestinationState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE, oldDestinationState, destinationState));
			}
		}
		return destinationState;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public BehaviorState basicGetDestinationState()
  {
		return destinationState;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setDestinationState(BehaviorState newDestinationState)
  {
		BehaviorState oldDestinationState = destinationState;
		destinationState = newDestinationState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE, oldDestinationState, destinationState));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public BehaviorActionBlock getActionBlock()
  {
		if (actionBlock != null && ((EObject)actionBlock).eIsProxy()) {
			InternalEObject oldActionBlock = (InternalEObject)actionBlock;
			actionBlock = (BehaviorActionBlock)eResolveProxy(oldActionBlock);
			if (actionBlock != oldActionBlock) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AadlBaPackage.BEHAVIOR_TRANSITION__ACTION_BLOCK, oldActionBlock, actionBlock));
			}
		}
		return actionBlock;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public BehaviorActionBlock basicGetActionBlock()
  {
		return actionBlock;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setActionBlock(BehaviorActionBlock newActionBlock)
  {
		BehaviorActionBlock oldActionBlock = actionBlock;
		actionBlock = newActionBlock;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__ACTION_BLOCK, oldActionBlock, actionBlock));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public long getPriority()
  {
		return priority;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setPriority(long newPriority)
  {
		long oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AadlBaPackage.BEHAVIOR_TRANSITION__PRIORITY, oldPriority, priority));
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
			case AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE:
				if (resolve) return getSourceState();
				return basicGetSourceState();
			case AadlBaPackage.BEHAVIOR_TRANSITION__CONDITION:
				if (resolve) return getCondition();
				return basicGetCondition();
			case AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE:
				if (resolve) return getDestinationState();
				return basicGetDestinationState();
			case AadlBaPackage.BEHAVIOR_TRANSITION__ACTION_BLOCK:
				if (resolve) return getActionBlock();
				return basicGetActionBlock();
			case AadlBaPackage.BEHAVIOR_TRANSITION__PRIORITY:
				return getPriority();
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
			case AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE:
				setSourceState((BehaviorState)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_TRANSITION__CONDITION:
				setCondition((BehaviorCondition)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE:
				setDestinationState((BehaviorState)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_TRANSITION__ACTION_BLOCK:
				setActionBlock((BehaviorActionBlock)newValue);
				return;
			case AadlBaPackage.BEHAVIOR_TRANSITION__PRIORITY:
				setPriority((Long)newValue);
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
			case AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE:
				setSourceState((BehaviorState)null);
				return;
			case AadlBaPackage.BEHAVIOR_TRANSITION__CONDITION:
				setCondition((BehaviorCondition)null);
				return;
			case AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE:
				setDestinationState((BehaviorState)null);
				return;
			case AadlBaPackage.BEHAVIOR_TRANSITION__ACTION_BLOCK:
				setActionBlock((BehaviorActionBlock)null);
				return;
			case AadlBaPackage.BEHAVIOR_TRANSITION__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
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
			case AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE:
				return sourceState != null;
			case AadlBaPackage.BEHAVIOR_TRANSITION__CONDITION:
				return condition != null;
			case AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE:
				return destinationState != null;
			case AadlBaPackage.BEHAVIOR_TRANSITION__ACTION_BLOCK:
				return actionBlock != null;
			case AadlBaPackage.BEHAVIOR_TRANSITION__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
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
		result.append(" (priority: ");
		result.append(priority);
		result.append(')');
		return result.toString();
	}
  
  @Override
  public AadlBaLocationReference getAadlBaLocationReference()
  {
    return (AadlBaLocationReference) this.getLocationReference() ;
  }

} //BehaviorTransitionImpl
