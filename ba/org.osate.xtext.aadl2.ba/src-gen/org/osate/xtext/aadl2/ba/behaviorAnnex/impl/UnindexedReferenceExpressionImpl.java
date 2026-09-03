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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnexPackage;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unindexed Reference Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnindexedReferenceExpressionImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnindexedReferenceExpressionImpl#isDequeue <em>Dequeue</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnindexedReferenceExpressionImpl#isCount <em>Count</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.ba.behaviorAnnex.impl.UnindexedReferenceExpressionImpl#isFresh <em>Fresh</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnindexedReferenceExpressionImpl extends PropertyIndexValueImpl implements UnindexedReferenceExpression
{
  /**
   * The cached value of the '{@link #getReference() <em>Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReference()
   * @generated
   * @ordered
   */
  protected UnindexedReference reference;

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
   * The default value of the '{@link #isCount() <em>Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCount()
   * @generated
   * @ordered
   */
  protected static final boolean COUNT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isCount() <em>Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCount()
   * @generated
   * @ordered
   */
  protected boolean count = COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #isFresh() <em>Fresh</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFresh()
   * @generated
   * @ordered
   */
  protected static final boolean FRESH_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isFresh() <em>Fresh</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isFresh()
   * @generated
   * @ordered
   */
  protected boolean fresh = FRESH_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UnindexedReferenceExpressionImpl()
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
    return BehaviorAnnexPackage.Literals.UNINDEXED_REFERENCE_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UnindexedReference getReference()
  {
    return reference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetReference(UnindexedReference newReference, NotificationChain msgs)
  {
    UnindexedReference oldReference = reference;
    reference = newReference;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__REFERENCE, oldReference, newReference);
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
  public void setReference(UnindexedReference newReference)
  {
    if (newReference != reference)
    {
      NotificationChain msgs = null;
      if (reference != null)
        msgs = ((InternalEObject)reference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__REFERENCE, null, msgs);
      if (newReference != null)
        msgs = ((InternalEObject)newReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__REFERENCE, null, msgs);
      msgs = basicSetReference(newReference, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__REFERENCE, newReference, newReference));
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
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__DEQUEUE, oldDequeue, dequeue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isCount()
  {
    return count;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCount(boolean newCount)
  {
    boolean oldCount = count;
    count = newCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__COUNT, oldCount, count));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isFresh()
  {
    return fresh;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setFresh(boolean newFresh)
  {
    boolean oldFresh = fresh;
    fresh = newFresh;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__FRESH, oldFresh, fresh));
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
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__REFERENCE:
        return basicSetReference(null, msgs);
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
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__REFERENCE:
        return getReference();
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__DEQUEUE:
        return isDequeue();
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__COUNT:
        return isCount();
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__FRESH:
        return isFresh();
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
    switch (featureID)
    {
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__REFERENCE:
        setReference((UnindexedReference)newValue);
        return;
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__DEQUEUE:
        setDequeue((Boolean)newValue);
        return;
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__COUNT:
        setCount((Boolean)newValue);
        return;
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__FRESH:
        setFresh((Boolean)newValue);
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
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__REFERENCE:
        setReference((UnindexedReference)null);
        return;
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__DEQUEUE:
        setDequeue(DEQUEUE_EDEFAULT);
        return;
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__COUNT:
        setCount(COUNT_EDEFAULT);
        return;
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__FRESH:
        setFresh(FRESH_EDEFAULT);
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
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__REFERENCE:
        return reference != null;
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__DEQUEUE:
        return dequeue != DEQUEUE_EDEFAULT;
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__COUNT:
        return count != COUNT_EDEFAULT;
      case BehaviorAnnexPackage.UNINDEXED_REFERENCE_EXPRESSION__FRESH:
        return fresh != FRESH_EDEFAULT;
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
    result.append(" (dequeue: ");
    result.append(dequeue);
    result.append(", count: ");
    result.append(count);
    result.append(", fresh: ");
    result.append(fresh);
    result.append(')');
    return result.toString();
  }

} //UnindexedReferenceExpressionImpl
