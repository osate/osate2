/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.xtext.aadl2.ba.behaviorAnnex.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage;
import org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction;
import org.osate.xtext.aadl2.ba.behaviorAnnex.Reference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ValueExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Communication Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.CommunicationActionImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.CommunicationActionImpl#isSend <em>Send</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.CommunicationActionImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.CommunicationActionImpl#isDequeue <em>Dequeue</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.CommunicationActionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.CommunicationActionImpl#isFreeze <em>Freeze</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.CommunicationActionImpl#isLock <em>Lock</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.CommunicationActionImpl#isUnlock <em>Unlock</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.CommunicationActionImpl#isAll <em>All</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.CommunicationActionImpl#isAllLock <em>All Lock</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.CommunicationActionImpl#isAllUnlock <em>All Unlock</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CommunicationActionImpl extends BehaviorActionImpl implements CommunicationAction
{
  /**
   * The cached value of the '{@link #getReference() <em>Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReference()
   * @generated
   * @ordered
   */
  protected Reference reference;

  /**
   * The default value of the '{@link #isSend() <em>Send</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSend()
   * @generated
   * @ordered
   */
  protected static final boolean SEND_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSend() <em>Send</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSend()
   * @generated
   * @ordered
   */
  protected boolean send = SEND_EDEFAULT;

  /**
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<ValueExpression> parameters;

  /**
   * The default value of the '{@link #isDequeue() <em>Dequeue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDequeue()
   * @generated
   * @ordered
   */
  protected static final boolean DEQUEUE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDequeue() <em>Dequeue</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDequeue()
   * @generated
   * @ordered
   */
  protected boolean dequeue = DEQUEUE_EDEFAULT;

  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected Reference target;

  /**
   * The default value of the '{@link #isFreeze() <em>Freeze</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFreeze()
   * @generated
   * @ordered
   */
  protected static final boolean FREEZE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFreeze() <em>Freeze</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFreeze()
   * @generated
   * @ordered
   */
  protected boolean freeze = FREEZE_EDEFAULT;

  /**
   * The default value of the '{@link #isLock() <em>Lock</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLock()
   * @generated
   * @ordered
   */
  protected static final boolean LOCK_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isLock() <em>Lock</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isLock()
   * @generated
   * @ordered
   */
  protected boolean lock = LOCK_EDEFAULT;

  /**
   * The default value of the '{@link #isUnlock() <em>Unlock</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUnlock()
   * @generated
   * @ordered
   */
  protected static final boolean UNLOCK_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isUnlock() <em>Unlock</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUnlock()
   * @generated
   * @ordered
   */
  protected boolean unlock = UNLOCK_EDEFAULT;

  /**
   * The default value of the '{@link #isAll() <em>All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAll()
   * @generated
   * @ordered
   */
  protected static final boolean ALL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAll() <em>All</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAll()
   * @generated
   * @ordered
   */
  protected boolean all = ALL_EDEFAULT;

  /**
   * The default value of the '{@link #isAllLock() <em>All Lock</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAllLock()
   * @generated
   * @ordered
   */
  protected static final boolean ALL_LOCK_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAllLock() <em>All Lock</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAllLock()
   * @generated
   * @ordered
   */
  protected boolean allLock = ALL_LOCK_EDEFAULT;

  /**
   * The default value of the '{@link #isAllUnlock() <em>All Unlock</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAllUnlock()
   * @generated
   * @ordered
   */
  protected static final boolean ALL_UNLOCK_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAllUnlock() <em>All Unlock</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAllUnlock()
   * @generated
   * @ordered
   */
  protected boolean allUnlock = ALL_UNLOCK_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CommunicationActionImpl()
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
    return BehaviorAnnexPackage.Literals.COMMUNICATION_ACTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Reference getReference()
  {
    return reference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReference(Reference newReference, NotificationChain msgs)
  {
    Reference oldReference = reference;
    reference = newReference;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.COMMUNICATION_ACTION__REFERENCE, oldReference, newReference);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setReference(Reference newReference)
  {
    if (newReference != reference)
    {
      NotificationChain msgs = null;
      if (reference != null)
        msgs = ((InternalEObject)reference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.COMMUNICATION_ACTION__REFERENCE, null, msgs);
      if (newReference != null)
        msgs = ((InternalEObject)newReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.COMMUNICATION_ACTION__REFERENCE, null, msgs);
      msgs = basicSetReference(newReference, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.COMMUNICATION_ACTION__REFERENCE, newReference, newReference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isSend()
  {
    return send;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setSend(boolean newSend)
  {
    boolean oldSend = send;
    send = newSend;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.COMMUNICATION_ACTION__SEND, oldSend, send));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<ValueExpression> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EObjectContainmentEList<ValueExpression>(ValueExpression.class, this, BehaviorAnnexPackage.COMMUNICATION_ACTION__PARAMETERS);
    }
    return parameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isDequeue()
  {
    return dequeue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDequeue(boolean newDequeue)
  {
    boolean oldDequeue = dequeue;
    dequeue = newDequeue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.COMMUNICATION_ACTION__DEQUEUE, oldDequeue, dequeue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Reference getTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTarget(Reference newTarget, NotificationChain msgs)
  {
    Reference oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.COMMUNICATION_ACTION__TARGET, oldTarget, newTarget);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setTarget(Reference newTarget)
  {
    if (newTarget != target)
    {
      NotificationChain msgs = null;
      if (target != null)
        msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.COMMUNICATION_ACTION__TARGET, null, msgs);
      if (newTarget != null)
        msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.COMMUNICATION_ACTION__TARGET, null, msgs);
      msgs = basicSetTarget(newTarget, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.COMMUNICATION_ACTION__TARGET, newTarget, newTarget));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isFreeze()
  {
    return freeze;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setFreeze(boolean newFreeze)
  {
    boolean oldFreeze = freeze;
    freeze = newFreeze;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.COMMUNICATION_ACTION__FREEZE, oldFreeze, freeze));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isLock()
  {
    return lock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setLock(boolean newLock)
  {
    boolean oldLock = lock;
    lock = newLock;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.COMMUNICATION_ACTION__LOCK, oldLock, lock));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isUnlock()
  {
    return unlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setUnlock(boolean newUnlock)
  {
    boolean oldUnlock = unlock;
    unlock = newUnlock;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.COMMUNICATION_ACTION__UNLOCK, oldUnlock, unlock));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isAll()
  {
    return all;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAll(boolean newAll)
  {
    boolean oldAll = all;
    all = newAll;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.COMMUNICATION_ACTION__ALL, oldAll, all));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isAllLock()
  {
    return allLock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAllLock(boolean newAllLock)
  {
    boolean oldAllLock = allLock;
    allLock = newAllLock;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.COMMUNICATION_ACTION__ALL_LOCK, oldAllLock, allLock));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isAllUnlock()
  {
    return allUnlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAllUnlock(boolean newAllUnlock)
  {
    boolean oldAllUnlock = allUnlock;
    allUnlock = newAllUnlock;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.COMMUNICATION_ACTION__ALL_UNLOCK, oldAllUnlock, allUnlock));
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
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__REFERENCE:
        return basicSetReference(null, msgs);
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__PARAMETERS:
        return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__TARGET:
        return basicSetTarget(null, msgs);
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
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__REFERENCE:
        return getReference();
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__SEND:
        return isSend();
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__PARAMETERS:
        return getParameters();
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__DEQUEUE:
        return isDequeue();
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__TARGET:
        return getTarget();
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__FREEZE:
        return isFreeze();
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__LOCK:
        return isLock();
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__UNLOCK:
        return isUnlock();
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__ALL:
        return isAll();
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__ALL_LOCK:
        return isAllLock();
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__ALL_UNLOCK:
        return isAllUnlock();
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
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__REFERENCE:
        setReference((Reference)newValue);
        return;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__SEND:
        setSend((Boolean)newValue);
        return;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends ValueExpression>)newValue);
        return;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__DEQUEUE:
        setDequeue((Boolean)newValue);
        return;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__TARGET:
        setTarget((Reference)newValue);
        return;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__FREEZE:
        setFreeze((Boolean)newValue);
        return;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__LOCK:
        setLock((Boolean)newValue);
        return;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__UNLOCK:
        setUnlock((Boolean)newValue);
        return;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__ALL:
        setAll((Boolean)newValue);
        return;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__ALL_LOCK:
        setAllLock((Boolean)newValue);
        return;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__ALL_UNLOCK:
        setAllUnlock((Boolean)newValue);
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
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__REFERENCE:
        setReference((Reference)null);
        return;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__SEND:
        setSend(SEND_EDEFAULT);
        return;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__PARAMETERS:
        getParameters().clear();
        return;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__DEQUEUE:
        setDequeue(DEQUEUE_EDEFAULT);
        return;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__TARGET:
        setTarget((Reference)null);
        return;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__FREEZE:
        setFreeze(FREEZE_EDEFAULT);
        return;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__LOCK:
        setLock(LOCK_EDEFAULT);
        return;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__UNLOCK:
        setUnlock(UNLOCK_EDEFAULT);
        return;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__ALL:
        setAll(ALL_EDEFAULT);
        return;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__ALL_LOCK:
        setAllLock(ALL_LOCK_EDEFAULT);
        return;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__ALL_UNLOCK:
        setAllUnlock(ALL_UNLOCK_EDEFAULT);
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
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__REFERENCE:
        return reference != null;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__SEND:
        return send != SEND_EDEFAULT;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__DEQUEUE:
        return dequeue != DEQUEUE_EDEFAULT;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__TARGET:
        return target != null;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__FREEZE:
        return freeze != FREEZE_EDEFAULT;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__LOCK:
        return lock != LOCK_EDEFAULT;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__UNLOCK:
        return unlock != UNLOCK_EDEFAULT;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__ALL:
        return all != ALL_EDEFAULT;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__ALL_LOCK:
        return allLock != ALL_LOCK_EDEFAULT;
      case BehaviorAnnexPackage.COMMUNICATION_ACTION__ALL_UNLOCK:
        return allUnlock != ALL_UNLOCK_EDEFAULT;
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
    result.append(" (send: ");
    result.append(send);
    result.append(", dequeue: ");
    result.append(dequeue);
    result.append(", freeze: ");
    result.append(freeze);
    result.append(", lock: ");
    result.append(lock);
    result.append(", unlock: ");
    result.append(unlock);
    result.append(", all: ");
    result.append(all);
    result.append(", allLock: ");
    result.append(allLock);
    result.append(", allUnlock: ");
    result.append(allUnlock);
    result.append(')');
    return result.toString();
  }

} //CommunicationActionImpl
