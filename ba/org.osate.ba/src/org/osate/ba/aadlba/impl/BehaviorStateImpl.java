/**
 * AADL-BA-FrontEnd
 * 
 * Copyright (c) 2011-2020 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 2.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * https://www.eclipse.org/legal/epl-2.0/
 */
package org.osate.ba.aadlba.impl;


import java.util.Collection ;

import org.eclipse.emf.common.notify.Notification ;
import org.eclipse.emf.common.notify.NotificationChain ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EClass ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.InternalEObject ;
import org.eclipse.emf.ecore.impl.ENotificationImpl ;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList ;
import org.eclipse.emf.ecore.util.InternalEList ;
import org.osate.aadl2.Mode ;
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.BehaviorState ;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ba.utils.AadlBaLocationReference ;
import org.osate.ba.utils.visitor.IBAVisitor ;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Behavior State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorStateImpl#isInitial <em>Initial</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorStateImpl#isComplete <em>Complete</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorStateImpl#isFinal <em>Final</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorStateImpl#getBindedMode <em>Binded Mode</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorStateImpl#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 *   <li>{@link org.osate.ba.aadlba.impl.BehaviorStateImpl#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 * </ul>
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
   * The cached value of the '{@link #getIncomingTransitions() <em>Incoming Transitions</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIncomingTransitions()
   * @generated
   * @ordered
   */
  protected EList<BehaviorTransition> incomingTransitions;

  /**
   * The cached value of the '{@link #getOutgoingTransitions() <em>Outgoing Transitions</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutgoingTransitions()
   * @generated
   * @ordered
   */
  protected EList<BehaviorTransition> outgoingTransitions;

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
  @Override
  public boolean isInitial()
  {
    return initial;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
  @Override
  public boolean isComplete()
  {
    return complete;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
  @Override
  public boolean isFinal()
  {
    return final_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
  public Mode getBindedMode()
  {
    if (bindedMode != null && ((EObject)bindedMode).eIsProxy())
    {
      InternalEObject oldBindedMode = (InternalEObject)bindedMode;
      bindedMode = (Mode)eResolveProxy(oldBindedMode);
      if (bindedMode != oldBindedMode)
      {
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
  @Override
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
  public EList<BehaviorTransition> getIncomingTransitions()
  {
    if (incomingTransitions == null)
    {
      incomingTransitions = new EObjectWithInverseResolvingEList<BehaviorTransition>(BehaviorTransition.class, this, AadlBaPackage.BEHAVIOR_STATE__INCOMING_TRANSITIONS, AadlBaPackage.BEHAVIOR_TRANSITION__DESTINATION_STATE);
    }
    return incomingTransitions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<BehaviorTransition> getOutgoingTransitions()
  {
    if (outgoingTransitions == null)
    {
      outgoingTransitions = new EObjectWithInverseResolvingEList<BehaviorTransition>(BehaviorTransition.class, this, AadlBaPackage.BEHAVIOR_STATE__OUTGOING_TRANSITIONS, AadlBaPackage.BEHAVIOR_TRANSITION__SOURCE_STATE);
    }
    return outgoingTransitions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case AadlBaPackage.BEHAVIOR_STATE__INCOMING_TRANSITIONS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingTransitions()).basicAdd(otherEnd, msgs);
      case AadlBaPackage.BEHAVIOR_STATE__OUTGOING_TRANSITIONS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingTransitions()).basicAdd(otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
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
      case AadlBaPackage.BEHAVIOR_STATE__INCOMING_TRANSITIONS:
        return ((InternalEList<?>)getIncomingTransitions()).basicRemove(otherEnd, msgs);
      case AadlBaPackage.BEHAVIOR_STATE__OUTGOING_TRANSITIONS:
        return ((InternalEList<?>)getOutgoingTransitions()).basicRemove(otherEnd, msgs);
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
      case AadlBaPackage.BEHAVIOR_STATE__INITIAL:
        return isInitial();
      case AadlBaPackage.BEHAVIOR_STATE__COMPLETE:
        return isComplete();
      case AadlBaPackage.BEHAVIOR_STATE__FINAL:
        return isFinal();
      case AadlBaPackage.BEHAVIOR_STATE__BINDED_MODE:
        if (resolve) return getBindedMode();
        return basicGetBindedMode();
      case AadlBaPackage.BEHAVIOR_STATE__INCOMING_TRANSITIONS:
        return getIncomingTransitions();
      case AadlBaPackage.BEHAVIOR_STATE__OUTGOING_TRANSITIONS:
        return getOutgoingTransitions();
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
      case AadlBaPackage.BEHAVIOR_STATE__INCOMING_TRANSITIONS:
        getIncomingTransitions().clear();
        getIncomingTransitions().addAll((Collection<? extends BehaviorTransition>)newValue);
        return;
      case AadlBaPackage.BEHAVIOR_STATE__OUTGOING_TRANSITIONS:
        getOutgoingTransitions().clear();
        getOutgoingTransitions().addAll((Collection<? extends BehaviorTransition>)newValue);
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
      case AadlBaPackage.BEHAVIOR_STATE__INCOMING_TRANSITIONS:
        getIncomingTransitions().clear();
        return;
      case AadlBaPackage.BEHAVIOR_STATE__OUTGOING_TRANSITIONS:
        getOutgoingTransitions().clear();
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
      case AadlBaPackage.BEHAVIOR_STATE__INITIAL:
        return initial != INITIAL_EDEFAULT;
      case AadlBaPackage.BEHAVIOR_STATE__COMPLETE:
        return complete != COMPLETE_EDEFAULT;
      case AadlBaPackage.BEHAVIOR_STATE__FINAL:
        return final_ != FINAL_EDEFAULT;
      case AadlBaPackage.BEHAVIOR_STATE__BINDED_MODE:
        return bindedMode != null;
      case AadlBaPackage.BEHAVIOR_STATE__INCOMING_TRANSITIONS:
        return incomingTransitions != null && !incomingTransitions.isEmpty();
      case AadlBaPackage.BEHAVIOR_STATE__OUTGOING_TRANSITIONS:
        return outgoingTransitions != null && !outgoingTransitions.isEmpty();
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

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (initial: ");
    result.append(initial);
    result.append(", complete: ");
    result.append(complete);
    result.append(", final: ");
    result.append(final_);
    result.append(')');
    return result.toString();
  }

  @Override
  public AadlBaLocationReference getAadlBaLocationReference()
  {
    return (AadlBaLocationReference) this.getLocationReference() ;
  }

  public void accept(IBAVisitor visitor) {
    visitor.visit(this);
  }
} //BehaviorStateImpl
